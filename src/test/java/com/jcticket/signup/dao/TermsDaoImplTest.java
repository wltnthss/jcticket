package com.jcticket.signup.dao;

import com.jcticket.signup.dto.TermsDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * packageName    : com.jcticket.signup.dao
 * fileName       : TermsDaoImplTest
 * author         : jinwook Song
 * date           : 2024-02-11
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        jinwook Song       최초 생성
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TermsDaoImplTest {

    @Autowired
    TermsDao termsDao;

    @Test
    public void insertTerm1() throws Exception {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        TermsDto termsDto = new TermsDto(4,"wlsdnr12314","N",currentTimestamp,currentTimestamp,"system",currentTimestamp,"system");
        System.out.println("termsDto = " + termsDto);
        assertTrue(termsDao.insertTerm(termsDto)==1);
    }


}