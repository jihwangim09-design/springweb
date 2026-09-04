package example.Practice3;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor@Builder //룸복

public class MovieDto {
    private Integer movieid;
    private String title;
    private String director;
    private LocalDate releasedate;
    private Double rating;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;


    // 1. DTO -> ENTITY : 주로 등록시
    public MovieEntity toEntity(){ // static 제외한 이유? 해당 메소드 호출하는대상이 dto인스턴스라서
    // 생성자 방식 return new MovieEntity(null, this.title, this.director, this.releasedate, this.rating);
    // vs
    // 빌더패턴     
    // 여기서는 this뺴도 됨 매개변수가 이름이 똑같을때는 this를 써야하는데 여기서는 안써도 된다?
    return MovieEntity.builder()
        .director(this.director)
        .title(this.title)
        .rating(this.rating)
        .build();
    }   

    // 2. ENTITY -> DTO : 주로 조회시
    public static MovieDto from( MovieEntity entity ) {// static 포함한 이유? 해당 메소드 호출하는 대상의 dto 인스턴스가 없어서
        return MovieDto.builder()
        .movieid( entity.getMovieid() ).director( entity.getDirector() ).rating( entity.getRating() )
        .title( entity.getTitle() ).releasedate( entity.getReleasedate() )
        .createDate( entity.getCreateDate() ).updateDate( entity.getUpdateDate() )
        .build();
    }
}
