package example.Practice5.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.Practice5.dto.CommentDto;
import example.Practice5.model.Repository.BoardRepository;
import example.Practice5.model.Repository.CommentRepository;
import example.Practice5.model.entity.CommentEntity;

@Service 
public class CommentService {
    @Autowired private CommentRepository commentRepository;
    @Autowired private BoardRepository boardRepository; // 댓글 등록 시 boardId(숫자)로 진짜 BoardEntity 객체를 조회해서 FK로 연결하기 위해 필요

    // 1.등록
    public boolean 댓글등록( CommentDto commentDto ){ // http://localhost:8080/api/board/comments
        // {"boardId": 1,"author": "댓글테스트","password": "9999","content": "테스트 댓글" }
        CommentEntity commentEntity = commentDto.toEntity();
        CommentEntity savedEntity = commentRepository.save( commentEntity );
        if( savedEntity.getCommentId() >= 1 ) return true;
        return false;
    }

    // 2.삭제
    public boolean 댓글삭제( Integer commentId , String password ) {
        Optional<CommentEntity> optional = commentRepository.findById(commentId);

        if (optional.isPresent()){
            CommentEntity commentEntity = optional.get();
            if (commentEntity.getPassword().equals(password)){
                commentRepository.deleteById(commentId);
                return true;
            }
        }
        return false;
    }
}
