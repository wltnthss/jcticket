package com.jcticket.ticketing.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.junit.Assert.*;
/**
 * packageName    : com.jcticket.ticketing.service
 * fileName       : TicketingServiceImplTest
 * author         : 조영상
 * date           : 2/18/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/18/24         조영상        최초 생성
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TicketingServiceImplTest {
    @Autowired
    TicketingService ticketingService;

    String TEST_PLAY_ID = "테스트공연ID";
    String TEST_DATE = "2024-02-25";

    // 공연 정보를 잘 가져오는지 테스트
    @Test
    public void getPlayInfoTest() throws Exception{
        //given
        ArrayList<String> dateList;
        Set<String> keys;
        //when
        Map<String,Object> map = ticketingService.getPlayInfo(TEST_PLAY_ID);
        //then
        keys = map.keySet();
        for(String key : keys){
            System.out.println("key ==> " + key);
            System.out.println("value ==> " + map.get(key));
            if(key.equals("play_name")){
                assertEquals("테스트콘서트", map.get(key));
            }else if(key.equals("play_poster")){
                System.out.println("poster key???? "+ key);
                assertTrue(map.get(key) != null);
            }else if(key.equals("stage_name")){
                assertEquals("정석극장", map.get(key));
            } else if (key.equals("showing_date")){
                dateList = (ArrayList<String>) map.get(key);
                for(String val : dateList){
                    System.out.println("dateList => "+ val);
                    assertTrue(val != null);
                }
            }
        }

    }

    // 회차를 잘 가져오는치 테스트
    @Test
    public void getRoundTest() throws Exception{
        //given
        List<String> roundList;
        Set<String> keys;
        //when
        Map<String,Object> map = ticketingService.getRound(TEST_PLAY_ID, TEST_DATE);
        //then
        keys = map.keySet();
        for (String key : keys){
            System.out.println("key ==> " + key);
            System.out.println("value ==> " + map.get(key));
            roundList = (ArrayList<String>)map.get(key);
            for(String val : roundList){
                System.out.println("round ==> " + val);
                assertTrue(3 == roundList.size());
                assertTrue(val != null);
            }
        }

    }
}
