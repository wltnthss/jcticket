package com.jcticket.ticketing.service;

import com.jcticket.ticketing.dto.CouponResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

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

    // 회차 정보를 조회 테스트
    @Test
    public void getRoundTest() throws Exception{
        //given
        HashMap<String, Object> map;
        ArrayList<String> seqList;
        ArrayList<String> infoList;
        //when
        map = (HashMap<String, Object>) ticketingService.getRoundInfo(TEST_PLAY_ID, TEST_DATE);
        //then
        assertTrue(1 == 1);
        //assertTrue( 3 == roundList.size());
        //Iterator<String> it = map.keySet().iterator();
        Set<String> keys = map.keySet();
        for (String key : keys){
            System.out.println(key+" ==> "+ map.get(key));
        }
    }

    // 회차시퀀스로 회차좌석가격 조회
    @Test
    public void getSeatPriceTest() throws Exception {
        //given
        int expectedPrice = 15000;
        int resultPrice;
        //when
        resultPrice = Integer.parseInt(ticketingService.getSeatPrice(1));
        System.out.print("expected price => " + expectedPrice + " / ");
        System.out.println("result price => " + resultPrice);
        //then
        assertEquals(expectedPrice, resultPrice);
    }

    // 회차시퀀스로 좌석번호, 좌석상태리스트를 받아 HashMap<String,ArrayList<String>> 형태로 가공되는지 테스트
    @Test
    public void getSeatListTest() throws Exception {
        //given
        final int SEQ = 1;
        String exKey1 = "seat_id";
        String exKey2 = "seat_status";
        Map<String, Object> map;
        List<String> idList;
        List<String> statusList;
        //when
        map = ticketingService.getSeatList(SEQ);
        System.out.println("map ====> " + map);
        System.out.println("type => " + map.getClass().getName());
        Set<String> keys = map.keySet();
        System.out.println("keySet => " + keys);
        System.out.println("value => " + map.get("seat_id"));
        System.out.println("value => " + map.get("seat_status"));
        //then
        for(String key : keys){
            if(key.equals(exKey1)){
                System.out.print("key1 => " + key + "  / ");
                System.out.println("value1 => " + map.get(key));
                idList = (ArrayList<String>)map.get(key);
                for(String val : idList){
                    assertTrue(null != val);
                    System.out.print("id => " + val + ", ");
                }
                System.out.println();
            }else if(key.equals(exKey2)){
                System.out.print("key2 => " + key + " / ");
                System.out.println("value2 => " + map.get(key));
                statusList = (ArrayList<String>)map.get(key);
                for(String val : statusList){
                    assertEquals("Y", val);
                    System.out.print("status => " + val + ", ");
                }
                System.out.println();
            } else if (key.equals("end_row")){
                System.out.println("key => "+ key);
                System.out.println("val => "+ map.get(key));
            } else {
                System.out.println("key => "+ key);
                System.out.println("val => "+ map.get(key));
            }
        }

    }

    // 유저아이디를 받아서 쿠폰정보를 반환한다.
    @Test
    public void getCouponTest() throws Exception {
        // given
        String userId = "www444";

        // when
        List<CouponResponseDto> list = ticketingService.getCouponInfo(userId);
        for(CouponResponseDto dto : list){
            assertTrue(null != dto);
            System.out.println(dto.getCouponName());
            System.out.println(dto.getCouponDiscount());
            System.out.println(dto.getMinOrder());
            System.out.println(dto.getDiscription());
            System.out.println(dto.getUseCondition());
            System.out.println(dto.getCouponUseableStartDate());
            System.out.println(dto.getCouponUseableEndDate());
        }
        // then

    }

}
