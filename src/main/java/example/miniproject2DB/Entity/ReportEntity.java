package example.miniproject2DB.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "report")
@NoArgsConstructor @AllArgsConstructor @Builder @Data
public class ReportEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer report_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "r_no", nullable = false)
    @ToString.Exclude
    private RentalEntity rentalEntity;

    private String report_type;

    @Lob
    private String description;

    @Builder.Default
    private String status = "접수";
}