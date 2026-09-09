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
        @Autowired  private TestService testService;
        int result4 = testService.plus(10, 5);
    }
}
class TestService{

    //private TestService(){} 싱글톤
    //private static final TestService instance = new TestService(); 싱글톤
    //public static TestService getInstance(){ return instance;} 싱글톤

    int plus( int x , int y ){
        return x + y;
    }
    static int plus2( int x , int y ){ return x + y ;}

}