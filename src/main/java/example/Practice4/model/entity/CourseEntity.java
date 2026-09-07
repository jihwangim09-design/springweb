package example.Practice4.model.entity;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.engine.profile.Fetch;

import example.Practice3.BaseTime;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity@Table ( name = "course")
@Data@NoArgsConstructor@AllArgsConstructor@Builder 
@Getter@Setter
public class CourseEntity extends BaseTime{
    @Id 
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private Integer courseId;
    @Column 
    private String courseName;
    // @OneToMany ( mappedBy = "매핑할멤버변수명 ")
    // "하나의 Course에 여러 개의 Enroll(수강)이 연결된다"는 1:다 관계.
    // FK(외래키)는 항상 "다(Many)" 쪽 테이블에 있음
    // 여기서는 EnrollEntity (다 쪽) → FK를 가짐 → 관계의 주인
    @OneToMany ( mappedBy = "courseEntity" , cascade = CascadeType.ALL , fetch = FetchType.LAZY )
    // FK 없음 = 일(One)쪽 = @OneToMany = 주인 아님 = mappedBy 꼭 씀 (상대방 필드명 적어줌) 여기서는 mappedBy를 적어줘야함
    // mappedBy = "courseEntity"이거는 이 관계의 진짜 주인(FK 보유자)은 내가 아니라
    // EnrollEntity 클래스 안에 있는 courseEntity라는 이름의 필드
    // List<EnrollEntity> 이거보고 판단해서 EnrollEntity 클래스 안에 가서 courseEntity라는 필드를 찾는다고 해석
    @ToString.Exclude // 순환참조방지
    @Builder.Default // 빌더패턴 사용시 초기값 사용
    private List<EnrollEntity> enrollEntities = new ArrayList<>();
    
}
