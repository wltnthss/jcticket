package com.jcticket.agency.dao;

import com.jcticket.agency.dto.AgencyDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;

import static org.junit.Assert.*;

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
}