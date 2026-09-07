package example.Practice5.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.Practice5.dto.CommentDto;
import example.Practice5.model.Repository.CommentRepository;
import example.Practice5.model.entity.CommentEntity;

@Service 
public class CommentService {
    @Autowired private CommentRepository commentRepository;

    // 1.등록
    public boolean 댓글등록( CommentDto commentDto ){
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
