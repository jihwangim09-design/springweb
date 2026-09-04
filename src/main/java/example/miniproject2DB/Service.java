package example.miniproject2DB;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import example.miniproject2DB.Dto.EquipmentDto;
import example.miniproject2DB.Entity.EquipmentEntity;
import example.miniproject2DB.Repository.EquipmentRepository;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private EquipmentRepository equipmentRepository;

    public EquipmentDto create(EquipmentDto dto) {
        EquipmentEntity entity = EquipmentEntity.builder()
                .e_name(dto.getE_name())
                .e_category(dto.getE_category())
                .e_status(dto.getE_status())
                .build();
        return toDto(equipmentRepository.save(entity));
    }

    public List<EquipmentDto> findAll() {
        return equipmentRepository.findAll()
                .stream().map(this::toDto).collect(Collectors.toList());
    }

    public EquipmentDto findOne(Integer e_no) {
        EquipmentEntity entity = equipmentRepository.findById(e_no)
                .orElseThrow(() -> new RuntimeException("장비 없음: " + e_no));
        return toDto(entity);
    }

    public EquipmentDto update(Integer e_no, EquipmentDto dto) {
        EquipmentEntity entity = equipmentRepository.findById(e_no)
                .orElseThrow(() -> new RuntimeException("장비 없음: " + e_no));
        entity.setE_name(dto.getE_name());
        entity.setE_category(dto.getE_category());
        entity.setE_status(dto.getE_status());
        return toDto(equipmentRepository.save(entity));
    }

    public void delete(Integer e_no) {
        equipmentRepository.deleteById(e_no);
    }

    private EquipmentDto toDto(EquipmentEntity entity) {
        return EquipmentDto.builder()
                .e_no(entity.getE_no())
                .e_name(entity.getE_name())
                .e_category(entity.getE_category())
                .e_status(entity.getE_status())
                .l_no(entity.getLockerEntity() != null ? entity.getLockerEntity().getL_no() : null)
                .build();
    }
}