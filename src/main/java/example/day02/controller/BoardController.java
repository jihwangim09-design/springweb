package example.day02.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import example.day02.model.dao.BoardDao;
import example.day02.model.dto.BoardDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




/*
    컨트롤러에 서블릿( HTTP 프로토콜 사용 가능하게 기능( GET/POST/PUT/DELETE ) 제공하는 클래스 ) 기능 달기
        * 레거시(과거코드) 코드는 상속받아 서블릿 구현
        * 스프링은 @Controller에 내 서블릿 포함 스프링은 상속을 대신해준다?
    // 1. 웹기술 포함한 컨트롤러 클래스 위에 @Controller 또는 반환타입이 JSON 이면 @RestController 
        * HTTP content type: http 통해 데이터를 보내서 받은 곳에서 해당 데이터를 잘 사용 할 있게 하는 타입 명시  JSON타입으로 변환시켜주고 이런게 아님 
        * HTTP content type: http 전송 데이터 타입 명시
        text/html , application/json(@RestController) , form 등등 (DTO는 없다.) 
    // 2. 해당 메소드 마다의 URL 정의
        * URL 정의시 http://127.0.0.1:8080(도메인) 이후 경로(path/url) 정의 , 중복없이 아무거나!
        1. @PostMapping("/URL ") : HTTP 메소드중에 POST 메소드 매핑/연결/대응 어노테이션
*/


@RestController
// 컨트롤러가 없는 이유는 아파치가 서블렛을 자동으로 연결해줘서 
public class BoardController {
    private BoardDao bd = BoardDao.getInstance();

    // [1] 등록
    @PostMapping("/board/save") //
    public boolean save( BoardDto boardDto) {
        boolean result = bd.save(boardDto);
        return result;
    }

   
 	
    // [2] 전체조회
    @GetMapping( "/board/findall" )
    public ArrayList<BoardDto> findAll( ){
        ArrayList<BoardDto> result = bd.findAll();
        return result;
    }
}
