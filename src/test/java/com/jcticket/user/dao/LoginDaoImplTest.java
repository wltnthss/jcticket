package com.jcticket.user.dao;

import com.jcticket.signup.dao.SignupDao;
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
    public void selectUserTest() throws Exception {
        loginDao.deleteAll();
        assertTrue(loginDao.count()==0);
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        UserDto userDto = new UserDto("wlswls","1234","욱","wlsdnr1233@naver.com","010-9741-2159","미왕빌딩","wook","19990219","M",currentTimestamp,currentTimestamp,currentTimestamp,"Y",0,"연극","",currentTimestamp,"system",currentTimestamp,"system");
        loginDao.insert(userDto);
        assertTrue(loginDao.count()==1);

        String user_id = userDto.getUser_id();

        UserDto userDto2 = loginDao.selectUser(user_id);
        assertTrue(userDto.equals(userDto2));
    }

    @Test
    public void updateUserTest() throws Exception{
        loginDao.deleteAll();
        assertTrue(loginDao.count()==0);

        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        UserDto userDto = new UserDto("wlswls","1234","욱","wlsdnr1233@naver.com","010-9741-2159","미왕빌딩","wook","19990219","M",currentTimestamp,currentTimestamp,currentTimestamp,"N",0,"연극","",currentTimestamp,"system",currentTimestamp,"system");
        loginDao.insert(userDto);
        assertTrue(loginDao.count()==1);
        userDto.setUser_email("wlsdnremail@aaa.com");
        userDto.setUser_password("2345");
        assertTrue(loginDao.update(userDto)==1);

        UserDto userDto2 = loginDao.selectUser(userDto.getUser_id());
        assertTrue(userDto.equals(userDto2));
    }

    @Test
    public void increaseLoginCntTest() throws Exception {
        loginDao.deleteAll();
        assertTrue(loginDao.count()==0);

        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        UserDto userDto = new UserDto("wlswls","1234","욱","wlsdnr1233@naver.com","010-9741-2159","미왕빌딩","wook","19990219","M",currentTimestamp,currentTimestamp,currentTimestamp,"Y",0,"연극","",currentTimestamp,"system",currentTimestamp,"system");
        loginDao.insert(userDto);

        String user_id = userDto.getUser_id();
        System.out.println("user_id = " + user_id);

        loginDao.increaseLoginCnt(user_id);

        assertTrue(userDto.getUser_visit_cnt()==2);
    }
}