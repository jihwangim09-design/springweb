package example.Practice2;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Service 
public class TestService {
   
    private final TestRepository testRepository;

    // [1] 게시물등록
    public boolean testWrite( TestEntity entity ){
        TestEntity savedEntity = testRepository.save( entity );
        if( savedEntity.getNo() >= 1 ) return true;
        return false;
    }

    // [2] 게시물 전체조회
    public List<TestEntity> testPrint( ){
        return testRepository.findAll();
    }

    // [3] 게시물 개별조회
    public TestEntity testDetail( int no ){
        Optional<TestEntity> optional = testRepository.findById( no );
        if( optional.isPresent() ) {
            return optional.get();
        }
        return null; // 조회 결과 없으면 null 반환
    }

    // [4] 게시물 삭제
    public boolean testDelete( int no ){
        testRepository.deleteById( no );
        return true;
    }

    // [5] 게시물 수정
    @Transactional
    public boolean testUpdate( TestEntity entity ){
        Optional<TestEntity> optional = testRepository.findById( entity.getNo() );
        if( optional.isPresent() ) {
            TestEntity savedEntity = optional.get();
            savedEntity.setContent( entity.getContent() );
            return true;
        }
        return false;
    }
}