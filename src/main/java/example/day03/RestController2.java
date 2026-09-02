package example.day03;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @Component // 1. 스프링 컨테이너에 객체(빈) 등록
// @Controller // 2. HTTP 서블릿 지원 + @Component 포함
@RestController// 3. 응답content-type을 'application/json' 설정(@ResponseBody) + @Controller
// 활용: HTML(VIEW(화면)) -> @Controller , JSON(값) -> @RestController
@RequestMapping( "/day03" ) // *클래스내 메소드들의 공통 URL 정의 * // 그 클래스 안에 있는 모든 메서드의 URL 앞에 /day03이 공통으로 붙는다. 
public class RestController2 {
    // 1. 해당 클래스가 @RestController 이면 @ResponseBody 생략가능
    @GetMapping("/task5") // 중복없는 URL 정의
    public String task5(){ return "서버에서 응답하는 메시지";}
    // --------- 요청 매개변수 --------- //
    // 2. http://localhost:8080/day03/task6?name=유재석&age=10
    // @RequestParam이란? 요청 content-type이 (HTML)form 또는 쿼리스트링의 매개변수 매핑/연결  
    @GetMapping( "/task6") // 클래스내 동일한 URL에 대해서는 @RequestMapping 에서 정의한다.
    public int task6( @RequestParam("name") String name , @RequestParam("age") int age ){
        System.out.println( name ); System.out.println( age );
        return 6;
    }
    // 3. http://localhost:8080/day03/task7?name=유재석&age=10&count=80
    @GetMapping( "/task7")
    public int task7 ( 
        @RequestParam("name") String name , // @RequestParam 이름 명시
        @RequestParam(name = "age") int age , // @RequestParam( name = "매핑할매개변수명" )
        @RequestParam(name = "count", required = false, defaultValue = "10") int count 
    // @RequestParam( required = "필수여부" , defaultValue = "기본값") 매개변수 무조건 필요
    ){System.out.println( name ); System.out.println( age ); System.out.println( count );
        return 7;
    }   
    // 4. http://localhost:8080/day03/task8?name=유재석&age=10
    @DeleteMapping( "/task8")
    public int task8 ( @RequestParam Map<String,Object> map ){
        System.out.println( map );
        return 8;
    }
    // 5. http://localhost:8080/day03/task9?name=유재석&age=10
    @DeleteMapping( "/task9")
    public int task9 ( @ModelAttribute ExamDto examDto ){
        System.out.println( examDto );
        return 9;
    }
    // 6. http://localhost:8080/day03/task10/유재석/10      ?안씀위에처럼
    @GetMapping( "/task10/{name}/{age}")
    public int task10( 
        @PathVariable(name = "name") String name , 
        @PathVariable(name = "age") int age ){
        System.out.println( name ); System.out.println( age );
        return 10;
    }
    // 7. http://localhost:8080/day03/task11 , { "name" : "유재석" , "age" : 10 }
    @PostMapping( "/task11") 
    public int task11( @RequestBody ExamDto examDto ){
        System.out.println( examDto );
        return 11;
    }
    
} // class end


/* 
    요청 Request ------->
                  HTTP
            <----------- 응답 Response
    * HTTP content-type : 전송하는 데이터의 타입 뜻
    쿼리스트링이란?: ?(물음표)뒤부터 URL?매개변수명=값&매개변수명=값 
        - GET / POST / PUT / DELETE 모두 사용 가능
    경로구분자이란? URL/값1/값2
    1. @RequestParm : 쿼리스트링 또는 content-type:'application/x-www-form-urlencoded'(기본값) 	주 용도:단순 값 몇 개
    2. @ModelAttribute(생략가능) : + DTO 매핑  주 용도:값이 많을 때 DTO 객체 하나로 묶어서 받음
    3. @PathVariable : 경로구분자  주 용도:특정 자원 지목
    4. @RequestBody : content-type:'application/json'  주 용도:JSON 통신(API) 프론트엔드(JS)에서 fetch/axios로 JSON 보낼 때 사용
        -> POST / PUT 메소드만 body(본문-경로상의값노출이없다) 지원한다.
    */
