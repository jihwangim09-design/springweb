package example.Practice5.model.entity;

import example.Practice5.Basetime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table ( name = "comment")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Getter @Setter 
public class CommentEntity extends Basetime {
    @Id 
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Integer commentId;
    @Column 
    private String author;
    private String password;
    private String content;
    // FK란? 다른테이블(엔티티) 참조
    @JoinColumn( name = "board_id")
    @ManyToOne // M : 1
    private BoardEntity boardEntity;

}
