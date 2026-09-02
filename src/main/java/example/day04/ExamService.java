package example.day04;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor // final 멤버변수 생성자 자동 생성
@Service // 비지니스로직 담당하는 객체(빈)등록
public class ExamService {
    // * 리포지토리객체 (주입)불러오기
    private final ExamRepository examRepository;
    
    // [1] 전체조회
    public List<ExamEntity> findAll( ){
        // 리포지토리 호출
        // 리포지토리객체.findAll() : 구현체() select 지원
        // 반환값: 매핑된 테이블의 모든 레코드(엔티티) 반환
        return examRepository.findAll();
    }
    // [2] 저장
    public boolean 저장( ExamEntity entity ){
        // 리포지토리 호출
        // 리포지토리객체.save( 저장할entity ) : insert 지원
        // save 반환값은 영속(매핑/저장)된 엔티티 반환
        ExamEntity savedEntity = examRepository.save( entity );
        // 즉 만약에 SAVE된 엔티티에 PK가 존재하면 저장 성공
        if( savedEntity.getEno() >= 1) return true;
        // PK가 없으면 저장 실패
        return false;
    }
}
