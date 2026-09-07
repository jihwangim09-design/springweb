package example.Practice4.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import example.Practice4.model.entity.StudentEntity;

public interface StudentRepository extends JpaRepository< StudentEntity  , Integer > {
    
    
}
