package example.Practice4.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import example.Practice4.model.entity.CourseEntity;

@Repository
public interface CourseRepository extends JpaRepository< CourseEntity , Integer > {
    // CourseEntity = 어떤 Entity를 다룰건지
    // Integer = 그 Entity의 PK 타입
}

// JpaRepository 다 이안에 들어가있음

// save(entity)         // 저장/수정
// findById(id)          // ID로 조회
// findAll()             // 전체 조회
// deleteById(id)         // ID로 삭제
// delete(entity)         // 삭제
// count()                // 개수 세기
// existsById(id)          // 존재 여부 확인
