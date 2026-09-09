package example.Practice6.model.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Table ( name = "board")
@Data @NoArgsConstructor @AllArgsConstructor @Builder 
public class BoardEntity {
    @Id 
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private Integer boardId;
    private String author;
    private String password;
    private String content;

    @OneToMany ( mappedBy = "boardEntity" , cascade = CascadeType.ALL )
    @ToString.Exclude
    @Builder.Default
    private List<CommentEntity> commenttities = new ArrayList<>();
    
}
