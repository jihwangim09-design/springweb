package example.Practice4.model.entity;

import org.hibernate.annotations.ManyToAny;

import example.Practice3.BaseTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

 	
@Entity@Table( name="enroll")
@NoArgsConstructor@AllArgsConstructor@Builder@Data 
public class EnrollEntity extends BaseTime  {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer studentId;
    @Column
    private String status;
    // ---------- FK : 과정번호 -------------
    @JoinColumn( name = "courseId") // FK필드명은 주로 연관할 PK필드명과 동일
    @ManyToOne // M:1 , 다:일 , DB에서는 FK표시 되고 JAVA에서는 객체로 표시 
    private CourseEntity courseEntity;
    // ---------- FK : 학생번호 -------------
    @JoinColumn( name = "studentId")
    @ManyToOne
    private StudentEntity studentEntity;
}