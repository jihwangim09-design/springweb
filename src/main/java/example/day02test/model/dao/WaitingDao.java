package example.day02test.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import example.day02test.model.dto.WaitingDto;

public class WaitingDao extends BaseDao {
    private WaitingDao(){};
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance( ){ return instance; }

    // [1] 등록
    public boolean save( WaitingDto waitingDto ){
        try{
            String sql = "insert into waiting( phone, headcount ) values( ? , ? )";
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setString( 1 , waitingDto.getPhone() );
            ps.setInt( 2 , waitingDto.getHeadcount() );
            int result = ps.executeUpdate();
            if( result == 1 ){ return true; }
        }catch(Exception e ){ System.out.println( e ); }
        return false;
    }

    // [2] 전체조회
    public ArrayList< WaitingDto > findAll( ){
        ArrayList<WaitingDto> list = new ArrayList<>();
        try{
            String sql = "select * from waiting" ;
            PreparedStatement ps = conn.prepareStatement( sql );
            ResultSet rs = ps.executeQuery();
            while( rs.next() ){
                WaitingDto waitingDto = new WaitingDto();
                waitingDto.setPhone( rs.getString("phone") );
                waitingDto.setHeadcount( rs.getInt("headcount") );
                list.add(waitingDto);
            }
        }catch(Exception e ){ System.out.println( e ); }
        return list;
    }

    // [3] 개별수정
    public boolean update( WaitingDto waitingDto ){
        try{
            String sql = "update waiting set headcount = ? where phone = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt( 1 , waitingDto.getHeadcount() );
            ps.setString( 2 , waitingDto.getPhone() );
            int result = ps.executeUpdate();
            if( result == 1 ) return true;
        }catch( SQLException e ){ System.out.println( e ); }
        return false;
    }

    // [4] 개별삭제
    public boolean delete( String phone ){
        try{
            String sql = "delete from waiting where phone = ?";
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setString( 1 , phone );
            int result = ps.executeUpdate();
            if( result == 1 ) return true;
        }catch( SQLException e ){ System.out.println( e ); }
        return false;
    }

} // class end