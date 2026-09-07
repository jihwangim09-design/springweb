package example.Practice5.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class CommentEntity {
    @Id 
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Integer commentId;
    @Column 
    private String author;
    
}
