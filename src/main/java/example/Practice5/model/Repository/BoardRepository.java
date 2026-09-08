package example.Practice5.model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import example.Practice5.model.entity.BoardEntity;

@Repository
public interface BoardRepository extends JpaRepository< BoardEntity , Integer > {
    // BoardEntity = 어떤 Entity를 다룰건지
    // Integer = 그 Entity의 PK 타입
}