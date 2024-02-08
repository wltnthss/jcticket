package com.jcticket.signup.dao;

import com.jcticket.signup.dto.SignupDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * packageName    : com.jcticket.signup.dao
 * fileName       : SignupDaoImplTest
 * author         : jinwook Song
 * date           : 2024-02-07
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-07        jinwook Song       최초 생성
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class SignupDaoImplTest {

    @Autowired
    SignupDao signupDao;

    @Test
    public void insertUser() throws Exception {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        SignupDto signupDto = new SignupDto("wltn123","wltn123","손지수","wltn123@naver.com","010-9741-2159","미왕빌딩","springMaster",
                "19000101","M",currentTimestamp,"N",0,"연극",currentTimestamp,"system",currentTimestamp,"system");

//        System.out.println("signupDao.insertUser(signupDto) = " + signupDao.insertUser(signupDto));

        assertTrue(signupDao.insertUser(signupDto)==1);
    }
}