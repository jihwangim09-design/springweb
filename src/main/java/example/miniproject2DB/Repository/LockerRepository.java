package example.miniproject2DB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import example.miniproject2DB.Entity.LockerEntity;

public interface LockerRepository extends JpaRepository<LockerEntity, Integer> {}