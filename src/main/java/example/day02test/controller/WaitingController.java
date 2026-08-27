package example.day02test.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import example.day02.model.dao.BoardDao;
import example.day02test.model.dao.WaitingDao;
import example.day02test.model.dto.WaitingDto;

@RestController
public class WaitingController {
    private WaitingDao wd = WaitingDao.getInstance();

    // [1] 등록
    @PostMapping( "/waiting/save" )
    public boolean save( WaitingDto waitingDto ){
        return wd.save(waitingDto);
    }

    // [2] 전체조회
    @GetMapping( "/waiting/findall" )
    public ArrayList<WaitingDto> findAll( ){
        return wd.findAll();
    }

    // [3] 개별수정
    @PutMapping( "/waiting/update" )
    public boolean update( WaitingDto waitingDto ){
        return wd.update( waitingDto );
    }
    // [4] 개별삭제
    @DeleteMapping( "/waiting/delete" )
    public boolean delete( @RequestParam("phone") String phone ){
        return wd.delete( phone );
    }
    
}
