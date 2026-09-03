package example.day05;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name = "test")
@Data@NoArgsConstructor@AllArgsConstructor@Builder
@Getter@Setter@ToString
public class TestEntity extends BaseTime {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private Integer no;
    @Column( name="name" , nullable = false , length = 100 , unique = true ) // 제약조건
    private String name; // 이름
    @Column( columnDefinition = "varchar(100) not null default '제품설명'")
    private String desc; // 설명
    @Column( insertable = true , updatable = true )
    private String price; // 가격
    // + 제품 등록일 ++ 제품 수정일 --> basetime 상속
}
/*
    @Column( name="필드명" ) : 생략시 자동으로 멤버변수명지정
    @Column( nullable = true/false ) : null 조건 설정 true면 null false면 not null
    @Column( length = "문자열길이~255" )
    @Column( unique = true) : 중복 불가능/가능
    @Column( columnDefinition = "SQL구문" ) 예전에 SQL구문쓰듯이 순수 SQL을쓰고 싶으면 columnDefinition 이거 사용
    @Column( insertable = insertable여부 , updatable = updatable여부 ) 둘다 기본값은 true


*/