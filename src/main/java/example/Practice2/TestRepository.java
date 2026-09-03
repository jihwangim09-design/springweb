package example.Practice2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Repository
public interface TestRepository // mvc 패턴의 DAO 역할을함
    extends JpaRepository <TestEntity , Integer > {
    // extends JpaRepository < 조작할엔티티명 , 조작할엔티티PK타입 >
    // 1. 기본 CRUD 제공 받는다. save( ) , findById( ) , findAll( ) , deletById( )
    // 2. 페이징/정렬 제공 받는다.
    // 3. 쿼리 커스텀 제공 받는다.
}
