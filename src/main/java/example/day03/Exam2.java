package example.day03;

import com.google.errorprone.annotations.NoAllocation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class Exam2 {
    public static void main(String[] args) {
        Student s1 = new Student(); // 1. @NoArgsConstructor
        Student s2 = new Student("유재석", 100, 90); // 2. @AllArgsConstructor
        s1.setKor(100); // 3.@setter
        System.out.println( s2.getKor() ); // 4.@Getter
        System.out.println( s2.toString() ); // 5. @ToString
        // 6. 빌더 패턴 이용한 객체 생성 , 장점:순서무관,선택적대입,유연한객체생성
        Student s3 = Student.builder() // - 빌더패턴 시작
                    .kor(100)   // 멤버변수 대입
                    .name("강호동")
                    .math(95)
                    .build(); // - 빌더패턴 끝
        // 즉 new 생성자명() [VS] 클래스명.builder().build();
        // 클래스명.메소드명(): 메소드가 static이면 객체 필요없다. 
    } // main end
} // class end
@Builder // 빌더 패턴 지원
@NoArgsConstructor // 매개변수 없는 생성자 (자동)생성  ex)매개변수 없는 생성자 자동 생성 → Student()
@AllArgsConstructor // 전체 매개변수 있는 생성자 (자동)생성  ex)멤버변수 전부를 매개변수로 받는 생성자 자동 생성 → Student(String name, int kor, int math)
// @RequiredArgsConstructor // final 멤버변수의 생성자 (자동)생성  ex)final로 선언된 멤버변수만 매개변수로 받는 생성자 생성
@Getter @Setter // ex)모든 필드의 getName(), getKor(), getMath() 자동 생성 모든 필드의 setName(...), setKor(...), setMath(...) 자동 생성
@ToString // 멤버변수 문자열 출력 메소드 (자동)생성 ex)	toString()
@Data // setter + getter + RequiredArgsConstructor + toString 묶음 ex) Getter+Setter+ToString+EqualsAndHashCode+RequiredArgsConstructor 전부
@EqualsAndHashCode // 객체내 멤버변수의 값 모두 비교 메소드 (자동)생성 ex) equals(), hashCode()

class Student{
    // 1. 멤버변수
    private String name; // 멤버변수
    private int kor; // 국어점수
    private int math; // 수학점수
    // 2. 생성자 -> 롬복 어노테이션 대체
} // class end
