package example.Practice2;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TestController {
    // * 서비스객체 (주입)불러오기
    private final TestService testService;

    // [1] 게시물등록 POST /test
    @PostMapping( "/test" )
    public boolean testWrite( @RequestBody TestEntity entity ){
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