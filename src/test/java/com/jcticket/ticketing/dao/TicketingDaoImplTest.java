package com.jcticket.ticketing.dao;

import com.jcticket.admin.dao.AdminDao;
import com.jcticket.ticketing.dto.TicketingDto;
import com.jcticket.viewdetail.dto.ShowingDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

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

    final static Timestamp NOW = new Timestamp(System.currentTimeMillis());
    String endDate = "2024-02-20 23:59:59";
    String showingDate = "2024-02-17";
    @Autowired
    TicketingDao ticketingDao;


    @Before
    public void deleteAll() throws Exception{

        int result = ticketingDao.deleteAll();
        assertTrue(1 == result);
    }
    @Test
    public void insertTest() throws Exception{
        // given -> 임의의 데이터를 주입
        ShowingDto dto = new ShowingDto(
                8,
                NOW,
                Timestamp.valueOf(endDate),
                "1회 15시 00분",
                showingDate,
                "토",
                "BS",
                80,
                "공연아이디2",
                "공연장아이디1",
                NOW,
                "system",
                NOW,
                "system"
        );
        // when -> 데이터의 조건 dao, service
        int result = ticketingDao.insertShowing(dto);
        // then -> 검증하는 절차
        assertTrue(1 == result);
    }


    @Test
    public void deleteTest() throws Exception {
        //given
        String play_id = "공연아이디1";
        //when
        int result = ticketingDao.deleteShowing(play_id);
        //then
        assertTrue(1 == result);
    }

    //

    /*
        공연날짜를 조회하는 쿼리
        '조회를' 테스트한다는 것은 무엇을 검증하려고 하는 것일까?
        내가 조회하고자 하는 데이터 즉 기댓값과 실제로 조회된 결과를 비교하는것...
        테스트 케이스에서의 기댓값은 내가 따로 DB에 insert해야한다...
        즉 mapper.xml에 daoImpl 객체가 이용할 수 있는 인터페이스가 있어야 하므로 쿼리가 필요하다.
        내가 insert 한 공연날짜를 잘 가져왔나 보는것이 포인트이다.... 이것은 insert 테스트인가 select 테스트인가
        그저 기댓값과 같으면 문제가 없다고 보는 것인가??
        그러면 insert는 어떻게 구현할 것인가
        DTO를  가지고 모든 필드를 채워넣는 insert 하나만을 만들 것이냐 아니면
        특정 컬럼에 대한 값 or 값들만을 채워넣는 방식으로 여러 개를 만들 것이냐....

        일단 성준님의 ViewDetailDaoImpl 을 확인해보지.
     */
    @Test
    public selectShowingDateTest() throws Exception{
        //given
        String play_id = "테스트공연아이디";
        String testDate = "2024-02-25";
        ShowingDto dto = new ShowingDto(
                10,
                NOW,
                Timestamp.valueOf(endDate),
                "1회 15시 00분",
                testDate ,
                "토",
                "BS",
                80,
                play_id,
                "공연장아이디1",
                NOW,
                "system",
                NOW,
                "system");
        ticketingDao.insertShowing(dto);
        //when
        List<HashMap<String,Object>> resultList = ticketingDao.selectShowingDate(play_id);
        //then
        for (HashMap<String,Object> hm : resultList){
            Set<String> keys = hm.keySet();
            for(String key : keys){
                if(hm.get(key))
            }
        }
        dto.getShowing_date() ==
        // 결론은

        assertEquals();
    }
}