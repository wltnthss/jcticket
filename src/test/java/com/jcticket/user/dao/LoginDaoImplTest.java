package com.jcticket.user.dao;

import com.jcticket.user.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * packageName    : com.jcticket.user.dao
 * fileName       : UserDaoImplTest
 * author         : jinwook Song
 * date           : 2024-02-02
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-02        jinwook Song       최초 생성
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class LoginDaoImplTest {
    @Autowired
    LoginDao loginDao;

    @Test
    public void selectUser() throws Exception {
        System.out.println("userDao.selectUser() = " + loginDao.selectUser("1"));
    }

    @Test
    public void increaseLoginCnt() throws Exception {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        UserDto userDto = loginDao.selectUser("wook123");
        System.out.println("userDto = " + userDto);

        String user_id = userDto.getUser_id();
        System.out.println("user_id = " + user_id);

        int increaseLoginCnt = loginDao.increaseLoginCnt(user_id);
        System.out.println("increaseLoginCnt = " + increaseLoginCnt);

        assertTrue(userDto.getUser_visit_cnt()==10);
    }
}