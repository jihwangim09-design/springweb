package example.miniproject2DB;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import example.miniproject2DB.Dto.EquipmentDto;

@RestController
@RequestMapping("/api/equipment")
public class Controller {

    @Autowired
    private Service service;

    // 등록
    @PostMapping
    public EquipmentDto create(@RequestBody EquipmentDto dto) {
        return service.create(dto);
    }

    // 조회 (전체)
    @GetMapping
    public List<EquipmentDto> findAll() {
        return service.findAll();
    }

    // 조회 (단건)
    @GetMapping("/{e_no}")
    public EquipmentDto findOne(@PathVariable Integer e_no) {
        return service.findOne(e_no);
    }

    // 수정
    @PutMapping("/{e_no}")
    public EquipmentDto update(@PathVariable Integer e_no, @RequestBody EquipmentDto dto) {
        return service.update(e_no, dto);
    }

    // 삭제
    @DeleteMapping("/{e_no}")
    public void delete(@PathVariable Integer e_no) {
        service.delete(e_no);
    }
}