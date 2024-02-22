package com.jcticket.agency.dao;

import com.jcticket.agency.dto.EnrollDto;
import com.jcticket.agency.dto.AgencyDto;
import com.jcticket.agency.dto.StageDto;
import com.jcticket.viewdetail.dto.ShowingDto;
import com.jcticket.viewdetail.dto.PlayDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.sql.Connection;
import java.sql.Timestamp;
import java.time.Instant;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
/**
 * packageName    : com.jcticket.agency.dao
 * fileName       : AgencyDaoImplTest
 * author         : {sana}
 * date           : 2024-02-06
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-06        {sana}       최초 생성
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
//public class AgencyDaoImplTest {
//
//    @Autowired
//    AgencyDao agencyDao;
//
//    @Test
//    public void agencylogin() throws Exception {
//        AgencyDto agencyDto = new AgencyDto("22", "22");
//
//        System.out.println("agencyDto => " + agencyDto);
//
//        AgencyDto check = agencyDao.agencylogin(agencyDto);
//
//        System.out.println("check => " + check);
//
//        assertTrue(check != null);
//    }
//}
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class AgencyDaoImplTest {

    @Autowired
    AgencyDao agencyDao;

    Timestamp CURRENT_TIMESTAMP = new Timestamp(System.currentTimeMillis());

    @Test
    public void agencylogin() throws Exception {

        // given
        agencyDao.deleteAgency();
        AgencyDto agencyDto = new AgencyDto("sana3", "1111", "(주)카카오", "sana@gmail.com", "010-1234-5679", "211-57-784578", CURRENT_TIMESTAMP, "운영중", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, "카카오", "김범수", CURRENT_TIMESTAMP, "AGENCY ADMIN", CURRENT_TIMESTAMP, "AGENCY ADMIN");
        System.out.println("agencyDto => " + agencyDto);

        // when
        agencyDao.insertAgency(agencyDto);

        AgencyDto check = agencyDao.selectAgency(agencyDto.getAgency_id());
        System.out.println("check => " + check);

        assertTrue("sana3".equals(agencyDto.getAgency_id()));
    }

    @Test

    public void insertAgency() throws Exception {

        // given
        AgencyDto agencyDto = new AgencyDto("sana1", "1111", "(주)카카오", "sana@gmail.com", "010-1234-5679", "211-57-784578", CURRENT_TIMESTAMP, "운영중", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, "카카오", "김범수", CURRENT_TIMESTAMP, "AGENCY ADMIN", CURRENT_TIMESTAMP, "AGENCY ADMIN");
        System.out.println("agencyDto => " + agencyDto);

        // when
        int rslt = agencyDao.insertAgency(agencyDto);

        // then
        assertTrue(1 == rslt);
    }

    @Test
    public void deleteAgency() throws Exception {

        AgencyDto agencyDto = new AgencyDto("sana1", "1111", "(주)카카오", "sana@gmail.com", "010-1234-5679", "211-57-784578", CURRENT_TIMESTAMP, "운영중", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, "카카오", "김범수", CURRENT_TIMESTAMP, "AGENCY ADMIN", CURRENT_TIMESTAMP, "AGENCY ADMIN");
        System.out.println("agencyDto => " + agencyDto);

        agencyDao.deleteAgency();
        assertTrue(0 == agencyDao.agencyCount());

        AgencyDto agencyDto2 = new AgencyDto("sana1", "1111", "(주)카카오", "sana@gmail.com", "010-1234-5679", "211-57-784578", CURRENT_TIMESTAMP, "운영중", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, "카카오", "김범수", CURRENT_TIMESTAMP, "AGENCY ADMIN", CURRENT_TIMESTAMP, "AGENCY ADMIN");
        System.out.println("agencyDto => " + agencyDto);

        int result = agencyDao.insertAgency(agencyDto2);
        assertTrue(1 == result);

    }

    //----------------------------------------------
    //enrollDto > stageDto Insert값 가져 오기?
    @Test
    public void testInsertAndRetrieveStage() {
        // StageDto &#xC0DD;&#xC131;, &#xC784;&#xC758;&#xC758; &#xAC12;&#xB4E4;&#xC744; &#xC124;&#xC815;
        StageDto stageDto = new StageDto();
        stageDto.setStage_id("stage1");
        stageDto.setStage_name("Test Stage");
        stageDto.setStage_address("Test Address");
        stageDto.setStage_seat_cnt(100);
        stageDto.setStage_manager("Test Manager");
        stageDto.setStage_type("A");
        stageDto.setStage_tel("Test Tel");

        // 시간 값을 현재 시간으로 설정
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        stageDto.setCreated_at(currentTime);
        stageDto.setUpdated_at(currentTime);

        // Id 값을 "sana"로 설정
        stageDto.setCreated_id("sana");
        stageDto.setUpdated_id("sana");

        // 생성한 StageDto 삽입
        agencyDao.insertStage(stageDto);

        // 삽입한 StageDto를  조회
        List<StageDto> stages = agencyDao.getAllStages();
        assertNotNull(stages);
        assertTrue(stages.size() > 0);

        // 조회된 StageDto 중에서 첫 번째 StageDto 확인
        StageDto retrievedStage = stages.get(0);
        assertEquals(stageDto.getStage_id(), retrievedStage.getStage_id());
        assertEquals(stageDto.getStage_name(), retrievedStage.getStage_name());
        assertEquals(stageDto.getStage_address(), retrievedStage.getStage_address());
        assertEquals(stageDto.getStage_seat_cnt(), retrievedStage.getStage_seat_cnt());
        assertEquals(stageDto.getStage_manager(), retrievedStage.getStage_manager());
        assertEquals(stageDto.getStage_type(), retrievedStage.getStage_type());
        assertEquals(stageDto.getStage_tel(), retrievedStage.getStage_tel());

        // 생성된 데이터의 createdId와 updatedId 값 확인
        assertEquals(stageDto.getCreated_id(), retrievedStage.getCreated_id());
        assertEquals(stageDto.getUpdated_id(), retrievedStage.getUpdated_id());

        // 생성된 데이터의 createdAt와 updatedAt 값 확인
        assertTrue(Math.abs(stageDto.getCreated_at().getTime() - retrievedStage.getCreated_at().getTime()) < 1000 * 50);
        assertTrue(Math.abs(stageDto.getUpdated_at().getTime() - retrievedStage.getUpdated_at().getTime()) < 1000 * 50);
    }


    @Test
    public void testInsertAndRetrievePlay() {
        // PlayDto 생성, 임의의 값들을 설정
        PlayDto playDto = new PlayDto();
        playDto.setPlay_id("play1");
        playDto.setPlay_name("Test Play");
        playDto.setPlay_poster("Test Poster");
        playDto.setPlay_info("Test Info");
        playDto.setPlay_major_cat("con");
        playDto.setPlay_middle_cat("C_km");
        playDto.setPlay_small_cat("a");
        playDto.setPlay_run_time(120);
        playDto.setAgency_id("sana1");

        // 시간 값을 현재 시간으로 설정
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        playDto.setCreated_at(currentTime);
        playDto.setUpdated_at(currentTime);

        // Id 값을 "sana"로 설정
        playDto.setCreated_id("sana");
        playDto.setUpdated_id("sana");

        // 생성한 PlayDto 삽입
        agencyDao.insertPlay(playDto);

        // 삽입한 PlayDto를 조회
        List<PlayDto> plays = agencyDao.getAllPlays();
        assertNotNull(plays);
        assertTrue(plays.size() > 0);

        // 조회된 PlayDto 중에서 첫 번째 PlayDto 확인
        PlayDto retrievedPlay = plays.get(0);
        assertEquals(playDto.getPlay_id(), retrievedPlay.getPlay_id());
        assertEquals(playDto.getPlay_name(), retrievedPlay.getPlay_name());
        assertEquals(playDto.getPlay_poster(), retrievedPlay.getPlay_poster());
        assertEquals(playDto.getPlay_info(), retrievedPlay.getPlay_info());
        assertEquals(playDto.getPlay_major_cat(), retrievedPlay.getPlay_major_cat());
        assertEquals(playDto.getPlay_middle_cat(), retrievedPlay.getPlay_middle_cat());
        assertEquals(playDto.getPlay_small_cat(), retrievedPlay.getPlay_small_cat());
        assertEquals(playDto.getPlay_run_time(), retrievedPlay.getPlay_run_time());
        assertEquals(playDto.getAgency_id(), retrievedPlay.getAgency_id());

        // 생성된 데이터의 createdId와 updatedId 값 확인
        assertEquals(playDto.getCreated_id(), retrievedPlay.getCreated_id());
        assertEquals(playDto.getUpdated_id(), retrievedPlay.getUpdated_id());

        // 생성된 데이터의 createdAt와 updatedAt 값 확인
        assertTrue(Math.abs(playDto.getCreated_at().getTime() - retrievedPlay.getCreated_at().getTime()) < 1000 * 50);
        assertTrue(Math.abs(playDto.getUpdated_at().getTime() - retrievedPlay.getUpdated_at().getTime()) < 1000 * 50);
    }



    @Test
    public void testInsertAndRetrieveShowing() {
        // ShowingDto 생성, 임의의 값들을 설정
        ShowingDto showingDto = new ShowingDto();
        showingDto.setShowing_seq(1);
        showingDto.setShowing_start_at(new Timestamp(System.currentTimeMillis()));
        showingDto.setShowing_end_at(new Timestamp(System.currentTimeMillis()));
        showingDto.setShowing_info("Test Showing Info");
        showingDto.setShowing_date("2024-02-21");
        showingDto.setShowing_day("Monday");
        showingDto.setShowing_status("bs");
        showingDto.setShowing_seat_cnt(100);
        showingDto.setPlay_id("testPlay");
        showingDto.setStage_id("testStage");

        // 시간 값을 현재 시간으로 설정
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        showingDto.setCreated_at(currentTime);
        showingDto.setUpdated_at(currentTime);

        // Id 값을 "sana"로 설정
        showingDto.setCreated_id("sana");
        showingDto.setUpdated_id("sana");

        // 생성한 ShowingDto 삽입
        agencyDao.insertShowing(showingDto);

        // 삽입한 ShowingDto를 조회
        List<ShowingDto> showings = agencyDao.getAllShowings();
        assertNotNull(showings);
        assertTrue(showings.size() > 0);

        // 조회된 ShowingDto 중에서 첫 번째 ShowingDto 확인
        ShowingDto retrievedShowing = showings.get(0);
        assertEquals(showingDto.getShowing_seq(), retrievedShowing.getShowing_seq());
        assertEquals(showingDto.getShowing_start_at(), retrievedShowing.getShowing_start_at());
        assertEquals(showingDto.getShowing_end_at(), retrievedShowing.getShowing_end_at());
        assertEquals(showingDto.getShowing_info(), retrievedShowing.getShowing_info());
        assertEquals(showingDto.getShowing_date(), retrievedShowing.getShowing_date());
        assertEquals(showingDto.getShowing_day(), retrievedShowing.getShowing_day());
        assertEquals(showingDto.getShowing_status(), retrievedShowing.getShowing_status());
        assertEquals(showingDto.getShowing_seat_cnt(), retrievedShowing.getShowing_seat_cnt());
        assertEquals(showingDto.getPlay_id(), retrievedShowing.getPlay_id());
        assertEquals(showingDto.getStage_id(), retrievedShowing.getStage_id());

        // 생성된 데이터의 createdId와 updatedId 값 확인
        assertEquals(showingDto.getCreated_id(), retrievedShowing.getCreated_id());
        assertEquals(showingDto.getUpdated_id(), retrievedShowing.getUpdated_id());

        // 생성된 데이터의 createdAt와 updatedAt 값 확인
        assertTrue(Math.abs(showingDto.getCreated_at().getTime() - retrievedShowing.getCreated_at().getTime()) < 1000 * 50);
        assertTrue(Math.abs(showingDto.getUpdated_at().getTime() - retrievedShowing.getUpdated_at().getTime()) < 1000 * 50);
    }


}//끝




//@displayname junit5기능인데 좋아보여,, 지수야..
    //builder() 쓰면 순서 상관없이 쓸 수 있음

//assertThroWs? 이건 뭔데?













