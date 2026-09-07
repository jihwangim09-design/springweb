package example.Practice4.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import example.Practice4.model.entity.CourseEntity;

public interface EnrollRepository extends JpaRepository< CourseEntity , Integer > {

    
}
