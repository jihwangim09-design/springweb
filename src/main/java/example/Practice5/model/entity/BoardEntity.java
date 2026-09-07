package example.Practice5.model.entity;

import java.util.ArrayList;

import example.Practice5.Basetime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity@Table ( name = "board")
@Data @NoArgsConstructor @AllArgsConstructor @Builder 
@Getter @Setter 
public class BoardEntity extends Basetime {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private Integer boardId;
    @Column 
    private String author;
    private String password;
    private String content;

    // 한 게시글에는 여러 댓글 등록 가능
    // mappedBy = "boardEntity"FK는  CommentEntity의 boardEntity 필드가 갖고 있음
    @OneToMany(mappedBy = "boardEntity", cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
    // 댓글(CommentEntity)을 여러 개 담을 리스트
    private List<CommentEntity> commentEntities = new ArrayList<>();
     
}
