package com.jcticket.mypage.dao;

import com.jcticket.ticketing.dto.TicketingDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * packageName    : com.jcticket.mypage.dao
 * fileName       : mypageImplTest
 * author         : JJS
 * date           : 2024-02-10
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-10        JJS       최초 생성
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class mypageImplTest {
        @Autowired
        mypageDAO mypageDAO;
    @Test
    public void selectAll() throws Exception {
        List<TicketingDto> list = mypageDAO.findAll();

//        System.out.println("list = "  + list);
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getTicketing_status().equals("예매취소"))
            System.out.println("list = " + list.get(i).getTicketing_id());
        }
    }


}