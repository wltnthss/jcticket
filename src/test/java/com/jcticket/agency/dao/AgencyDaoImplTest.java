package com.jcticket.agency.dao;

import com.jcticket.agency.dto.EnrollDto;
import com.jcticket.agency.dto.AgencyDto;
import com.jcticket.agency.dto.StageDto;
import com.jcticket.viewdetail.dto.ShowingDto;
import com.jcticket.viewdetail.dto.PlayDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.sql.Connection;
import java.sql.Timestamp;
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

    //----------------------

    @Test
    public void testInsertAndRetrieveStage() {
        // StageDto 생성, 임의의 값들을 설정
        StageDto stageDto = new StageDto();
        stageDto.setStage_id("stage1");
        stageDto.setStage_name("Test Stage");
        stageDto.setStage_address("Test Address");
        stageDto.setStage_seat_cnt(100);
        stageDto.setStage_manager("Test Manager");
        stageDto.setStage_type("Test Type");
        stageDto.setStage_tel("Test Tel");

        // 생성한 StageDto 삽입
        agencyDao.insertStage(stageDto);

        // 삽입한 StageDto를 StageDto 조회
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
    }

//    @Test
//    public void saveAgency() throws Exception {
//
//
//    }
//@displayname junit5기능인데 좋아보여,, 지수야..
    //builder() 쓰면 순서 상관없이 쓸 수 있음

//assertThroWs? 이건 뭔데?


//    @Test
//    public void testEnrollDto() {
//        // given
//        String agencyName = "Agency Test";
//        String playName = "Play Test";
//        String showingName = "Showing Test";
//        String stageName = "Stage Test";
//
//        // when
//        EnrollDto enrollDto = new EnrollDto(agencyName, playName, showingName, stageName);
//
//        // then
//        assertEquals(agencyName, enrollDto.getAgencyName());
//        assertEquals(playName, enrollDto.getPlayName());
//        assertEquals(showingName, enrollDto.getShowingName());
//        assertEquals(stageName, enrollDto.getStageName());
//    }


}







