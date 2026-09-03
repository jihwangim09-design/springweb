package example.Practice2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // 해당 클래스가 HTTP 컨트롤러 객체(빈)등록, @Controller( 안에 @Component(싱글톤대신 사용) 있음 ) + @Responsebody
@RestController
public class TestController {
    // DI : IOC(제어역전) 기반으로 스프링 객체(빈)가 등록된 객체(빈) 주입
    // @Autowired private TestService testService; 방법이 3가지가 있는데 @Autowired 얘도 가능한 방법
    // * 서비스객체 (주입)불러오기
    private final TestService testService;

    // [1] 게시물등록 POST /test
    @PostMapping( "/test" )
    public boolean testWrite( @RequestBody TestEntity entity ){ // TestEntity 자바 객체로 자동 변환해서 entity에 담음
        return testService.testWrite( entity );
    }

    // [2] 게시물 전체조회 GET /test
    @GetMapping( "/test" )
    public List<TestEntity> testPrint( ){
        return testService.testPrint();
    }

    // [3] 게시물 개별조회 GET /test/detail?no=1
    @GetMapping( "/test/detail" )
    public TestEntity testDetail( @RequestParam( name = "no" ) int no ){
         // ex) /test/detail?no=1이면, "no=1"에서 1을 꺼내옴
        return testService.testDetail( no );
    }

    // [4] 게시물 삭제 DELETE /test?no=1
    @DeleteMapping( "/test" )
    public boolean testDelete( @RequestParam( name = "no" ) int no ){
        return testService.testDelete( no );
    }

    // [5] 게시물 수정 PUT /test
    @PutMapping( "/test" )
    public boolean testUpdate( @RequestBody TestEntity entity ){
        return testService.testUpdate( entity );
    }
}