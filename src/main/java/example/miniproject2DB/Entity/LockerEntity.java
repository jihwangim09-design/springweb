package example.miniproject2DB.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "locker")
@NoArgsConstructor @AllArgsConstructor @Builder @Data
public class LockerEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer l_no;

    @Column(nullable = false, length = 50)
    private String l_location;

    @Column(length = 10)
    @Builder.Default
    private String l_status = "닫힘";
}