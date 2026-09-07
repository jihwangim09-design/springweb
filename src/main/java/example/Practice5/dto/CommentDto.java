package example.Practice5.dto;

import java.security.PublicKey;
import java.time.LocalDateTime;

import example.Practice5.model.entity.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder 
public class CommentDto {
    private Integer commentId;
    private String author;
    private String password;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer boardId; // 어느 게시글에 달리는 댓글인지 (FK를 숫자로 받음)

    // 등록용: DTO → Entity
    public CommentEntity toEntity(){
        return CommentEntity.builder()
                .author(this.author)
                .password(this.password)
                .content(this.content)
                .build();
                // boardEntity(게시글 객체)는 여기서 안 채움 ??
    }
    // 조회용: Entity → DTO
    public static CommentDto from(CommentEntity entity){
        return CommentDto.builder()
                .commentId(entity.getCommentId())
                .author(entity.getAuthor())
                .content(entity.getContent())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .boardId(entity.getBoardEntity().getBoardId())  // 연결된 게시글의 ID만 꺼내옴 ??
                // Comment 안에 있는 Board 객체를 꺼내고 그 Board 객체 안의 boardId를 또 꺼내기?
                .build();
    }
}
