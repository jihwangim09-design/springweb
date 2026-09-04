package example.day06;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table( name = "reply")
@NoArgsConstructor@AllArgsConstructor@Builder@Data
public class ReplyEntity {
    @Id
    private Integer rno;
    private String rname;
    //단방향 참조
    @ManyToOne( cascade = CascadeType.Type , fetch = )
    @JoinColumn( name = "bno")
    private BoardEntity boardEntity;
}

/*
    영속성이란? 자바는 영구저장이 불가능 하므로 DB 매핑/연결 하여 영속성(영구저장) 표현
    Entity entity = new entity(); // 객체
    repository.save() , repository.findll( ) , repository.findById( ) 등등 결과 영속된
    즉 Entity 영속된entity = repository.save( 비영속entity )

    @ManyToOne( cascade = 영속성제약조건 , fetch = 불러올시기)
    CascadeType.REMOVE : 만일 부모 엔티티가 삭제되면 자식 엔티티도 같이 삭제된다.
    CascadeType.MERGE : 만일 부모 엔티티가 수정되면 자식 엔티티 수정 같이 반영된다.
    CascadeType.DETACH : 만일 부모 엔티티가 영속(연결)해제 하면 자식 엔티티 같이 해제한다.
    CascadeType.RE
    CascadeType.DETACH
*/