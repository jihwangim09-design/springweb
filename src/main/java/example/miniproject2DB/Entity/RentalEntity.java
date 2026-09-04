package example.miniproject2DB.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "rental")
@NoArgsConstructor @AllArgsConstructor @Builder @Data
public class RentalEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer r_no;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "u_no", nullable = false)
    @ToString.Exclude
    private UsersEntity usersEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "e_no", nullable = false)
    @ToString.Exclude
    private EquipmentEntity equipmentEntity;

    @Builder.Default
    private LocalDateTime r_date = LocalDateTime.now();
    private LocalDateTime r_due_date;
    private LocalDateTime r_return_date;

    @Builder.Default
    private String r_status = "대여중";
    private String r_condition;
}