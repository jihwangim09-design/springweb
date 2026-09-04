package example.miniproject2DB.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data@NoArgsConstructor@AllArgsConstructor@Builder // 룸복
@Getter@Setter

public class UsersDto {
    private Integer u_no;
    private String u_pwd;
    private String u_phone;
    private String u_name;
    private String u_grade;
    private String u_student_id;
}
