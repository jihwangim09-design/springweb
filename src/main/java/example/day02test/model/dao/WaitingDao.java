package example.day02test.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import example.day02test.model.dto.WaitingDto;

public class WaitingDao {
    private WaitingDao(){};
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance( ){ return instance; }


    // [1] 등록
    public boolean save( WaitingDto waitingDto ){
        try{
            String sql = "insest into waiting( phone , headcount ) valuse( ? , ? )";
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setString(1, waitingDto.getPhone());
            ps.setInt(2, waitingDto.getHeadcount());
            int result = ps.executeUpdate();
            if ( result == 1 ){ return true; }
        }catch( Exception e ){ System.out.println( e );}
        return false;
    }

    // [2] 전체조회
    public ArrayList < WaitingDto > findAll( ){
        ArrayList < WaitingDto > list = new ArrayList<>();
        try{
            String sql = " select * from waiting ";
            PreparedStatement ps = conn.prepareStatement( sql );
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
            }
        }catch( Exception e) { System.out.println( e );}





    }   






}

