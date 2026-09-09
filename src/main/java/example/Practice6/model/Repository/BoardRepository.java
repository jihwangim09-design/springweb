package example.Practice6.model.Repository;

import java.beans.IntrospectionException;

import org.springframework.data.jpa.repository.JpaRepository;

import example.Practice5.model.entity.BoardEntity;

public interface BoardRepository extends JpaRepository< BoardEntity , Integer >{


    
}
