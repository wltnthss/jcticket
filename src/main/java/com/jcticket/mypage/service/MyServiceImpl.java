package com.jcticket.mypage.service;

import com.jcticket.mypage.dao.mypageDAO;
import com.jcticket.ticketing.dto.TicketingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

/**
 * packageName    : com.jcticket.mypage.service
 * fileName       : MyServiceImpl
 * author         : JJS
 * date           : 2024-02-10
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-10        JJS       최초 생성
 */



@Service
public class MyServiceImpl implements mypageService {

    @Autowired
    mypageDAO mypageDAO;

    @Override
    public Integer count() throws Exception {
        return mypageDAO.count();
    }
//    @Override
//    public List<TicketingDto> selectAll_desc() throws Exception {
//        return mypageDAO.selectArll_desc();
//    }
//
//    @Override
//    public List<TicketingDto> selectAll_page(Map map) throws Exception {
//        return mypageDAO.selectAll_page(map);
//    }

    @Override
    public List<TicketingDto> selectAll(Map map) throws Exception {
        return mypageDAO.selectAll(map);
    }


}
