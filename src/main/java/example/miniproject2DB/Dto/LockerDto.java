package example.miniproject2DB.Dto;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class LockerDto {
    private Integer l_no;
    private String l_location;
    private String l_status;
}