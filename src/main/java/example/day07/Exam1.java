package example.day07;

import org.springframework.beans.factory.annotation.Autowired;

public class Exam1 {
    public static void main(String[] args) {
        // 서로 다른 클래스의 메소드 호출 하는 방법
        // 메소드란? 상호작용( 2개 이상의 개체 주고 (인수M)받는(리턴1) )
        // 1. 인스턴스 생성하여 메소드호출
        TestService testService = new TestService();
        int result1 = testService.plus(3, 5);
        System.out.println( result1 );

        // 2.싱글톤(인스턴스)
        // TestService testService = TestService.getInstance();
        // int result = testService.plus( 3 , 5 )

        // 3. 메소드가 스태틱이면
        int result3 = TestService.plus2(10, 5);

        // 4. 스프링방식:
        // @Service(자동인스턴스생성)@Autowired(인스턴스호출)
        // @Autowired  private TestService testService;
        // int result4 = testService.plus(10, 5);
        // 인스턴스(주체p) VS static(주체x)
        TestService t1 = new TestService();
        t1.달리기();
        TestService t2 = new TestService();
        t2.달리기();
        // TestService.달리기2();

        // 앞글자를 봐야함 대문자인지 소문자인지 클래스명이랑 변수명 구분해야함
        // memberDto.toEntity() <---- 현재 DTO 인스턴스가 엔티티로 
        // MemberDto.from( entitiy ); <--- 그냥 실행이라서 변환할 엔티티를 매개변수로 전달 스태틱은 주체가 없음

        // 5. 사칙연산
        int x = 10 + 2 + 5 ; // 17
    }
}
class TestService{

    //private TestService(){} 싱글톤
    //private static final TestService instance = new TestService(); 싱글톤
    //public static TestService getInstance(){ return instance;} 싱글톤

    int plus( int x , int y ){return x + y;}
    static int plus2( int x , int y ){ return x + y ;}

    void 달리기(){System.out.println( this );}
    // static void 달리기2(){System.out.println( this );}

}
class Student{
    String name;
    void 밥먹기(){
        System.out.println( this.name + "밥 먹는다.");
    }

}