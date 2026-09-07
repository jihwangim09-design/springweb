package example.Practice5.controller;


import java.util.List;
import example.Practice5.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import example.Practice5.dto.BoardDto;

@RestController 
public class BoardController {
    @Autowired private BoardService boardService;


    @PostMapping ("/api/board") // http://localhost:8080/api/board
    // {"author": "테스트작성자", "password": "1234", "content": "테스트 내용입니다" }
    public boolean 게시물등록(
        @RequestBody BoardDto boardDto ){
            return boardService.게시물등록( boardDto );
    }
    
    @GetMapping  ("/api/board") // http://localhost:8080/api/board
    public List<BoardDto> 게시물전체조회( ){
        return boardService.게시물전체조회();
    }

    @DeleteMapping ("/api/board") // http://localhost:8080/api/board?boardId=4&password=1234
    public boolean 게시물삭제( 
        @RequestParam(name = "boardId") Integer boardId, // @RequestParam(name = "boardId") Integer boardId 이름 지정
        @RequestParam(name = "password") String password
    ){
        return boardService.게시물삭제(boardId, password);
    }
}
