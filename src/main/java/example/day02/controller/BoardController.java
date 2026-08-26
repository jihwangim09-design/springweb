package example.day02.controller;

import example.day02.model.dao.BoardDao;


// 컨트롤러가 없는 이유는 아파치가 서블렛을 자동으로 연결해줘서 
public class BoardController {
    private BoardDao bd = BoardDao.getInstance();
}
