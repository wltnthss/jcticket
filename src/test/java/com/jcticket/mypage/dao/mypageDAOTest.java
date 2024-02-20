package com.jcticket.mypage.dao;

import com.jcticket.mypage.controller.PageHandler;
import com.jcticket.mypage.dto.InquiryDto;
import com.jcticket.ticketing.dto.TicketingDto;
import org.apache.ibatis.jdbc.Null;
import org.junit.Before;
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

    Timestamp CURRENT_TIMESTAMP = new Timestamp(System.currentTimeMillis());



    @Test
    public void countAll() throws Exception {
        Map map = new HashMap();
        map.put("option", "A");

        System.out.println("map => " + map);

        int count = mypageDAO.count(map);
        System.out.println(count);
        assertTrue(count == 60);
    }

    @Test
    public void count_check() throws Exception {
        Map map = new HashMap();
        map.put("option", "Y");

        System.out.println("map => " + map);

        int count = mypageDAO.count(map);
        System.out.println(count);
        assertTrue(count == 30);
    }

    @Test
    public void count_cancel() throws Exception {
        Map map = new HashMap();
        map.put("option", "C");

        System.out.println("map => " + map);

        int count = mypageDAO.count(map);
        System.out.println(count);
        assertTrue(count == 30);
    }



    // ticketing_at 내림차순으로 잘 정렬 되는지 테스트
    @Test
    public void selectlimit() throws Exception {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        int page = 1;
        int pageSize = 5;
        Map map = new HashMap();
        map.put("selectType", "desc");
        map.put("offset", (page - 1) * pageSize);
        map.put("pageSize", pageSize);
        List<TicketingDto> ticketingDtos = mypageDAO.selectLimit(map);
        for (int i = 0; i < ticketingDtos.size(); i++) {
            Date date1 = format1.parse(ticketingDtos.get(i).getTicketing_at().toString());

            for (int j = i + 1; j < ticketingDtos.size(); j++) {
                Date date2 = format2.parse(ticketingDtos.get(j).getTicketing_at().toString());


                assertTrue(date1.after(date2));

            }
        }
    }



//  주어진 날짜조건에 맞게 나오는지 테스트
    @Test
    public void date_test() throws Exception {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        int page = 1;
        int pageSize = 5;
        PageHandler ph = new PageHandler(1, 10, 5);
        Map map = new HashMap();
        map.put("selectType", "page");
        map.put("offset", (page - 1) * pageSize);
        map.put("pageSize", 100);
        map.put("start_date", "2024-02-02");
        map.put("end_date", "2024-02-10");

        List<TicketingDto> list = mypageDAO.selectAll(map);

        int count = 0;

        for(int i = 0; i < list.size(); i++) {
            Date date = format1.parse(list.get(i).getTicketing_at().toString());
            System.out.println(date.toString());
            count++;
        }

        assertTrue(count == 8);
        assertTrue(ph.getBeginPage() == 1);
        assertTrue(ph.getEndPage() == 1);
    }




    @Test
    public void insert() throws Exception {

        for(int i = 0; i < 60; i++) {

            Timestamp CURRENT_TIMESTAMP = new Timestamp(System.currentTimeMillis());

            TicketingDto ticketingDto;

            long newTimeInMillis = CURRENT_TIMESTAMP.getTime() - 7200000 * 24 * (i + 390) ;
            CURRENT_TIMESTAMP.setTime(newTimeInMillis);


            if(i % 2 == 0) {
                ticketingDto = new TicketingDto(
                        "ID" + i, CURRENT_TIMESTAMP, i, "Y", "[51회] 17시 00분", "20240409", CURRENT_TIMESTAMP, 100, "Stage"  + i, "A"  + i, 200,
                        "User51", "UserID51", CURRENT_TIMESTAMP, "Play" + i % 10, CURRENT_TIMESTAMP, "Creator" + i, CURRENT_TIMESTAMP, "Updater"  + i);
                mypageDAO.insert(ticketingDto);
            }
            else {
                ticketingDto = new TicketingDto(
                        "ID" + i, CURRENT_TIMESTAMP, i, "C", "[51회] 17시 00분", "20240409", CURRENT_TIMESTAMP, 100, "Stage51", "B" + i, 200,
                        "User51", "UserID51", CURRENT_TIMESTAMP, "Play" + i % 10, CURRENT_TIMESTAMP, "Creator" + i, CURRENT_TIMESTAMP, "Updater" + i);

                mypageDAO.insert(ticketingDto);
            }
        }
    }

    @Test
    public void insert2() throws Exception {
        InquiryDto inquiryDto = new InquiryDto(null, "Example Inquiry", null, "This is an example inquiry content.",
                CURRENT_TIMESTAMP, "General", "user123", CURRENT_TIMESTAMP,
                "admin", CURRENT_TIMESTAMP, "admin");

        mypageDAO.insert_InquiryDto(inquiryDto);
    }

}