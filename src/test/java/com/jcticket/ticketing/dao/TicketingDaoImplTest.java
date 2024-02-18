package com.jcticket.ticketing.dao;

import com.jcticket.admin.dao.AdminDao;
import com.jcticket.ticketing.dto.TicketingDto;
import com.jcticket.viewdetail.dto.ShowingDto;
import org.apache.ibatis.jdbc.Null;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.*;

import static org.junit.Assert.*;

/**
 * packageName :  com.jcticket.ticketing.dao
 * fileName : TicketingDaoImplTest
 * author :  jisoo Son
 * date : 2024-02-10
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-10             jisoo Son             최초 생성
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TicketingDaoImplTest {

    final Timestamp NOW = new Timestamp(System.currentTimeMillis());
    String SYS = "system";
    String testPlay_id = "테스트공연ID";
    String testStage_id = "테스트공연장ID";
    String endDate = "2024-02-20 23:59:59";
    String testDate = "2024-02-24";
    @Autowired
    TicketingDao ticketingDao;


    @Before
    public void deleteAll() throws Exception{
        int result = ticketingDao.deleteAll();
    }

    @Test
    public void insertTest() throws Exception{
        // given -> 임의의 데이터를 주입
        ShowingDto dto = new ShowingDto("1회 09시 30분", testDate, "토", "BS", 80, testPlay_id, testStage_id, SYS, SYS);
        // when -> 데이터의 조건 dao, service
        int result = ticketingDao.insert(dto);
        // then -> 검증하는 절차
        assertTrue(1 == result);
    }
    @Test
    public void deleteByPlayIdTest() throws Exception {
        //given
        ShowingDto dto = new ShowingDto("2회 12시 30분", testDate, "토", "BS", 80, testPlay_id, testStage_id, SYS, SYS);
        ticketingDao.insert(dto);
        //when
        int result = ticketingDao.deleteByPlayId(testPlay_id);
        //then
        assertEquals(1, result);
    }

    // 공연아이디별 회차 수 카운트
    @Test
    public void countTest() throws Exception{
        //given
        for(int i = 1; i <= 10; i++){
            ShowingDto dto = new ShowingDto(i+"회 "+i+"시 00분", testDate, "토", "BS", 80, testPlay_id, testStage_id, SYS, SYS);
            ticketingDao.insert(dto);
        }
        //when
        int result = ticketingDao.countByPlayId(testPlay_id);
        //then
        assertTrue(result == 10);
    }

    // 공연아이디별 조회 테스트
    public void selectByPlayIdTest() throws Exception{
        //given
        for(int i = 1; i <= 10; i++){
            ShowingDto dto = new ShowingDto(i+"회 "+i+"시 00분", testDate, "토", "BS", 80, testPlay_id, testStage_id, SYS, SYS);
            ticketingDao.insert(dto);
        }
        //when
        List<ShowingDto> list = ticketingDao.selectByPlayId(testPlay_id);
        //then
        for(ShowingDto dto : list){
            assertEquals(dto.getPlay_id(), testPlay_id);
            assertEquals(dto.getShowing_date(), testDate);
            assertEquals(dto.getStage_id(), testStage_id);
        }
    }

    // 공연아이디별 공연일정 조회
    public void selectDateTest() throws Exception{
        //given
        for(int i = 1; i <= 5; i++){
            ShowingDto dto = new ShowingDto(i+"회 "+i+"시 00분", testDate, "토", "BS", 80, testPlay_id, testStage_id, SYS, SYS);
            ticketingDao.insert(dto);
        }
        //when
        List<Map<String,String>> list = ticketingDao.selectDateByPlayId(testPlay_id);
        //then
        assertTrue(list.size() == 5);
        for(Map<String,String> map : list) {
            Set<String> keys = map.keySet();
            for (String key : keys) {
                if (key.equals("showing_date")) {
                    assertEquals(testDate, map.get("showing_date"));
                }
            }
        }
    }

    // 같은 공연 아이디를 가지는 회차 시퀀스를 조회
    @Test
    public void selectSeq() throws Exception {
        //given
        String sDate = "2024-02-25";
        ShowingDto dto = new ShowingDto(15,"1회 09시 30분", sDate, "토", "BS", 80, testPlay_id, testStage_id, SYS, SYS);
        //when
        int insertResult = ticketingDao.insertShowing(dto);
        int expectedValue = dto.getShowing_seq();
        List<HashMap<String,Object>> list = ticketingDao.selectSeq(testPlay_id);

        HashMap<String,Object> hm = list.get(list.size()-1);
        int result = (Integer)hm.get("showing_sequence");
        // then
        assertTrue(insertResult == 1);
        assertEquals(expectedValue, result);
    }
    /*
        공연날짜를 조회하는 쿼리
     */
    @Test
    public void selectShowingDateTest() throws Exception{
        //given
        String testDate = "2024-03-26";
        ShowingDto dto = new ShowingDto("1회 09시 30분", testDate, "일", "BS", 80, testPlay_id, testStage_id, SYS, SYS);
        int insertResult = ticketingDao.insertShowing(dto);
        //when
        List<HashMap<String,Object>> resultList = ticketingDao.selectShowingDate(testPlay_id);
        //then
        assertTrue(insertResult == 1);
        assertTrue(resultList != null);
    }

    @Test
    public void selectShowingRoundTest() throws  Exception{
        //given
        ShowingDto dto = new ShowingDto("1회 09시 30분", showingDate, "토", "BS", 80, testPlay_id, testStage_id, SYS, SYS);
        int insertResult = ticketingDao.insertShowing(dto);
        HashMap<String,String> hashmap = new HashMap<>();
        hashmap.put("dateText",showingDate);
        hashmap.put("play_id", testPlay_id);
        //when
        List<HashMap<String,String>> resultList = ticketingDao.selectShowingRound(hashmap);
        String resultDate = resultList.get(resultList.size()-1).get(showingDate);
        //then
        assertTrue(1 == insertResult);
        assertTrue(resultList != null);
        assertTrue(showingDate.equals(resultDate));
    }


    @Test
    public void selectPlayStageTest() throws Exception{
        //given
        ShowingDto dto = new ShowingDto("1회 09시 30분", showingDate, "토", "BS", 80, testPlay_id, testStage_id, SYS, SYS);
        int insertResult = ticketingDao.insertShowing(dto);

        //when
        HashMap<String, String> hashMap = ticketingDao.selectPlayStageName(testPlay_id);
        //then
        assertTrue(insertResult == 1);
        assertTrue(!hashMap.isEmpty());
    }
}