package example.Practice4.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import example.Practice4.model.entity.CourseEntity;

 
 	
@NoArgsConstructor@AllArgsConstructor@Builder@Data
public class CourseDto {
    private Integer courseId;
    private String courseName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    // + 학생목록
    private List<StudentDto> studentDtos = new ArrayList<>();
    // + toEntity : 과정등록 용도
    public CourseEntity toEntity( ){
        return CourseEntity.builder()
                .courseName(this.courseName)
                .build();
    }
    // + from : 출력 용도
    public static CourseDto from( CourseEntity entity ){
        return CourseDto.builder()
                .courseId( entity.getCourseId() )
                .courseName( entity.getCourseName() )
                .createdAt( entity.getCreateDate() )
                .updatedAt( entity.getUpdateDate() )
                // 학생목록은 서비스계층 에서~
                .build();
    }
}
