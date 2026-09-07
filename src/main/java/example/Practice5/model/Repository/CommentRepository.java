package example.Practice5.model.Repository;

import javax.xml.stream.events.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import example.Practice5.model.entity.CommentEntity;

@Repository 
public interface CommentRepository extends JpaRepository < CommentEntity , Integer > {
    // CommentEntity = 어떤 Entity를 다룰건지
    // Integer = 그 Entity의 PK 타입
    
}
