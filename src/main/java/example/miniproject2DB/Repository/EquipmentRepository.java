package example.miniproject2DB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import example.miniproject2DB.Entity.EquipmentEntity;

public interface EquipmentRepository extends JpaRepository<EquipmentEntity, Integer> {}