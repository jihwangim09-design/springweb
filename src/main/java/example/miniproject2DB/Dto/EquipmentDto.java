package example.miniproject2DB.Dto;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class EquipmentDto {
    private Integer e_no;
    private String e_name;
    private String e_category;
    private String e_status;
    private Integer l_no;
}