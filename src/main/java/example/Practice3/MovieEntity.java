package example.Practice3;

import java.time.LocalDate;

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

@Entity
@Table( name = "movie" )
@Data@NoArgsConstructor@AllArgsConstructor@Builder //룸복

public class MovieEntity extends BaseTime{
    @Id // primary key
    @GeneratedValue( strategy = GenerationType.IDENTITY ) // auto_increment
    private Integer movieid;

    @Column( nullable = false ) // not null
    private String title;

    @Column( length = 100 ) // varchar(100)
    private String director;
    private LocalDate releasedate;
    private Double rating;
}
