package example.day07;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.Comparator;
import java.util.List;

public class Exam3 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of( 1 , 2 , 3 , 4 , 5 , 6, 7 , 8 , 9 , 10 );
        // 1. 컬렉션(List/Set/Map) 순회
            // 1-1
            for( int index = 0 ; index <= numbers.size()-1; index++ ){
                System.out.println( numbers.get(index));
            }
            // 1-2 향상된 for문
            for ( Integer data : numbers ){ System.out.println( data );}
            // 1-3 forEach
            numbers.forEach( (data) -> { System.out.println( data ); });    
        // 2. 스트림API , 리스트객체.stream().중간연산1().중간연산2().최종연산();
            // 2-1 stream().forEach( (순회변수명 ) -> {실행문} ); // forEach는 순회만함
            numbers.stream().forEach( (data) -> {System.out.println( data );});
            // 2-2 stream().map( ( 순회변수명 ) -> {return 값;} ).최종연산();  , return 있는 순회 제공    // map은 리턴 가능
            List<Integer> newList = numbers.stream().map( (data) -> {return data;} ).toList();
            // 2-3 stream().filter( 순회변수명 ) -> { return 조건식; } ).최종연산();
            List<Integer> newList2 = numbers.stream().filter( (data) -> { return data % 2 == 0; } ).toList();
            System.out.println( newList2 ); // [2 , 4 , 6 , 8 , 10]
            // 2-4 Stream()..sorted().최종연산(); 오름차순정렬 , Comparator.reverseOrder() 내림차순정렬
            List<Integer> newList3 = numbers.stream().sorted( Comparator.reverseOrder() ).toList();
            // 2-5 stream().distinct().최종연산(); 중복제거 stream().limit( 개수 ) 개수만큼 반환;
            List<Integer> newList4 = numbers.stream().distinct().limit(3).toList();
            System.out.println( newList4);
            // 2-6 중간연산은 여러번 가능, 최종연산은 1번 가능
            List<Integer> newList5 = numbers.stream()
                                    .distinct() // 중복제거 (중간연산)
                                    .filter((x) -> {return x % 2 == 0;})    // 조건식 (중간연산)
                                    .map((x) -> {return x;} )               // 반환 (중간연산)
                                    .sorted( Comparator.reverseOrder() )    // 정렬 (중간연산) 역순임
                                    .limit(3)                       // 반환개수제한 (중간연산)
                                    .toList();                               // 리스트로 반환 (최종연산)
            System.out.println( newList5 ); // [10 , 8 , 6]

    }   
}
