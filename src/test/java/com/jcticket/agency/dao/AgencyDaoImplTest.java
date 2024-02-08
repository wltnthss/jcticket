package com.jcticket.agency.dao;

import com.jcticket.agency.dto.AgencyDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

    @Test
    public void agencylogin() throws Exception {

        AgencyDto agencyDto = new AgencyDto("22", "22");
        System.out.println(" agencyDto " + agencyDto);

        AgencyDto check = agencyDao.selectAgency(agencyDto.getAgency_id());
        System.out.println("check => " + check);

        assertTrue(check != null);
    }
}