package example.day02.model.dao;

import java.sql.PreparedStatement;

import example.day02.model.dto.BoardDto;

public class BoardDao extends BaseDao {
    private BoardDao(){};
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance(){ return instance; }

    // [1] 등록
    public boolean save( BoardDto boardDto ) {
        try{
        // 1. SQL 작성
        String sql = "insert into board( content, writer ) values( ? , ? )";
        // 2. SQL 기재( SQL은 자바가 아니고 외부(MYSQL서버)에전달)
        PreparedStatement ps = conn.prepareStatement( sql ); 
        // 3. 기재된 SQL에 매개변수 대입 , ps.set타입( ? 순서번호 , 입력받은값 ) 
        ps.setString(1 , boardDto.getContent() );
        ps.setString(2 , boardDto.getWriter() );
        // 4. 기재된 SQL 실행 , ps.execute()는 단순실행만함 , .executeUpdate()는 실행후반영된레코드개수를 반환
        int result = ps.executeUpdate();
        // 5. SQL 실행 결과
        if( result == 1){ return true; } // 만약에 레코드 등록이 1개 되었다면 성공
        }catch( Exception e ){ System.out.println( e ); }  
        return false;
    }
}
