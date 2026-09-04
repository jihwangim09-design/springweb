package example.miniproject2DB.Entity;

import example.Practice3.BaseTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table(name = "users")
@NoArgsConstructor @AllArgsConstructor @Builder @Data
public class UsersEntity extends BaseTime {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer u_no;

    @Column(nullable = false, length = 15)
    private String u_pwd;

    @Column(nullable = false, unique = true, length = 20)
    private String u_phone;

    @Column(nullable = false, length = 10)
    private String u_name;

    @Column(length = 10)
    @Builder.Default
    private String u_grade = "user";

    @Column(nullable = false, unique = true, length = 10)
    private String u_student_id;
}
