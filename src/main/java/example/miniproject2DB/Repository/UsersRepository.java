package example.miniproject2DB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import example.miniproject2DB.Entity.UsersEntity;

public interface UsersRepository extends JpaRepository <UsersEntity , Integer> {

    
}
