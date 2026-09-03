package example.day05;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data@NoArgsConstructor@AllArgsConstructor@Builder
@Getter@Setter@ToString
public class TestDto { // 서로 다른 계층간 이동객체( Controller에서는 엔티티 사용금지 )
    // 엔티티와 동일하게 멤버변수 구성: 기능별로 DTO 구성 ex) 등록DTO , 조회DTO , 수정DTO
    private Integer no;
    private String name;
    private String descri;
    private Integer price;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    // DTO ----> ENTITY 함수 : C -> S(D -> E) , toEntity( ) , 주로 save/update 목적
    // this란? 해당 메소드 호출한 인스턴스 가리킴. 즉 myDto.toEntity()라고 호출하면 this는 myDto 가리킴
    public TestEntity toEntity( ){
        return TestEntity.builder() // 빌더패턴이란? new 대신에 객체생성을 메소드 방식 지원
                .name(this.name)
                .descri(this.descri)
                .price(this.price)
                .build(); // 끝

    }
    // ENTITY ----> DTO 함수 : S -> C( E -> D) , from( Entity entity ) , 주로 find
    // Static 이란? 인스턴스 없이 호출가능 메소드/변수
    // Static 에는 this가 없을까? 인스턴스없이 사용하는 메서드
    public static TestDto from( TestEntity testEntity ){
        return TestDto.builder() // 빌더시작 , 순서/개수 상관없이 자유롭게 객체생성가능
                .name( testEntity.getName() )
                .descri( testEntity.getDescri() )
                .price( testEntity.getPrice() )
                .createDate( testEntity.getCreateDate() )
                .updateDate( testEntity.getUpdateDate() )
                .build(); // 끝

    }
}
