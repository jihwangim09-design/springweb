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
    private Integer couserId;
    @Column 
    private String couserName;
    // @OneToMany ( mappedBy = "매핑할멤버변수명 ")
    @OneToMany ( mappedBy = "courseEntity" , cascade = CascadeType.ALL , fetch = FetchType.LAZY )
    @ToString.Exclude // 순환참조방지
    @Builder.Default // 빌더패턴 사용시 초기값 사용
    private List<EnrollEntity> entites = new ArrayList<>();
    
}
