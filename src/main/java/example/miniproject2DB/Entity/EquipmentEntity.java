package example.miniproject2DB.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "equipment")
@NoArgsConstructor @AllArgsConstructor @Builder @Data
public class EquipmentEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer e_no;

    @Column(nullable = false, length = 50)
    private String e_name;

    @Column(length = 30)
    private String e_category;

    @Column(length = 20)
    @Builder.Default
    private String e_status = "대여가능";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "l_no")
    @ToString.Exclude
    private LockerEntity lockerEntity;
}