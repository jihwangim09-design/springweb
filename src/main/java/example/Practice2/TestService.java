package example.Practice2;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Service // 해당 클래스가 비지니스로직 객체(빈)등록
public class TestService {
   
    // @Autowired private TestRepository testRepository; @Autowired로 할시
    private final TestRepository testRepository;

    // [1] 게시물등록
    // testEntity : 영속전
    // 1. 리포지토리 이용한 insert 처리하기 , .save( 입력받은값이들어있는엔티티 )
    public boolean testWrite( TestEntity entity ){
        TestEntity savedEntity = testRepository.save( entity );
    // 2. save 후 성공시 영속(자바<--연결된상태-->DB) 된 엔티티
        if( savedEntity.getNo() >= 1 ) return true;
        return false;
    }

    // [2] 게시물 전체조회
    // 1. 리포지토리 이용한 select 처리하기 , findAll( )
    public List<TestEntity> testPrint( ){
        return testRepository.findAll(); // findAll() = Repository(TestRepository)에 있는 메서드
        // repository에서 JpaRepository를 상속받았기 때문
    }

    // [3] 게시물 개별조회
    public TestEntity testDetail( int no ){
        // 1. 리포지토리 이용한 select 처리하기 , findById( PK 번호 )
        // *** Optional 클래스란? 객체사용시 null 예외가 발생하는 경우 안전하게 메소드 제공 
        // entity를 바로 주는게 아니라 한번 안전하게 포장해서 주는것
        Optional<TestEntity> optional = testRepository.findById( no );
        // 2. 포장(Optional)내 엔티티가 들어있어?
        if( optional.isPresent() ) {
            // 3. 포장(Optional) 열기, 엔티티 꺼내기
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