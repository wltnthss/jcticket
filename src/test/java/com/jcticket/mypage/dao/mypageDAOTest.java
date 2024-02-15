package com.jcticket.mypage.dao;

import com.jcticket.mypage.controller.PageHandler;
import com.jcticket.ticketing.dto.TicketingDto;
import org.apache.ibatis.jdbc.Null;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * packageName    : com.jcticket.mypage.dao
 * fileName       : mypageDAOTest
 * author         : JJS
 * date           : 2024-02-13
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-13        JJS       최초 생성
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class mypageDAOTest {

    @Autowired
    private mypageDAO mypageDAO;



    @Test
    public void count() throws Exception {
        int count = mypageDAO.count();
        System.out.println(count);
        assertTrue(count == 55);
    }



    @Test
    public void selectAll() throws Exception {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        Map map = new HashMap();
        map.put("selectType", "desc");
        List<TicketingDto> ticketingDtos = mypageDAO.selectAll(map);
        for(int i = 0; i < ticketingDtos.size(); i++) {
            Date date1 = format1.parse(ticketingDtos.get(i).getTicketing_at().toString());
            for(int j = 1; j < ticketingDtos.size(); j++) {
            Date date2 = format2.parse(ticketingDtos.get(j).getTicketing_at().toString());

            System.out.println(date1.after(date2));
            }
        }

    }
    @Test
    public void insert() throws Exception {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        TicketingDto ticketingDto = new TicketingDto("TICKET1020", timestamp, 3, "Y", "[1회] 17시 00분",
                "20240301", null, 50, "StageA", "A1", 100, "User1", timestamp,
                "PlayName1", timestamp, "AdminUser", timestamp, "AdminUser");

        mypageDAO.insert(ticketingDto);

        int total = mypageDAO.count();

        System.out.println(total);
    }


}