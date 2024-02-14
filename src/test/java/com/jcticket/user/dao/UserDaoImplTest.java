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
public class UserDaoImplTest {
    @Autowired
    UserDao userDao;
    Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

    @Test
    public void insertTest() throws Exception{
        userDao.deleteAll();
        assertTrue(userDao.count()==0);
        UserDto userDto = new UserDto("wlswls","1234","욱","wlsdnr1233@naver.com","010-9741-2159","미왕빌딩","wook","19990219","M",currentTimestamp,currentTimestamp,currentTimestamp,"Y",0,"연극","",currentTimestamp,"system",currentTimestamp,"system");
        System.out.println("userDto = " + userDto);
        userDao.insert(userDto);
        assertTrue(userDao.count()==1);
    }

    @Test
    public void selectTest() throws Exception {
        userDao.deleteAll();
        assertTrue(userDao.count()==0);
        UserDto userDto = new UserDto("wlswls","1234","욱","wlsdnr1233@naver.com","010-9741-2159","미왕빌딩","wook","19990219","M",currentTimestamp,currentTimestamp,currentTimestamp,"Y",0,"연극","",currentTimestamp,"system",currentTimestamp,"system");
        userDao.insert(userDto);
        assertTrue(userDao.count()==1);

        String user_id = userDto.getUser_id();

        UserDto userDto2 = userDao.select(user_id);
        System.out.println("userDto = " + userDto);
        System.out.println("userDto2 = " + userDto2);
        assertTrue(userDto.equals(userDto2));
    }

    @Test
    public void updateUserTest() throws Exception{
        userDao.deleteAll();
        assertTrue(userDao.count()==0);

        UserDto userDto = new UserDto("wlswls","1234","욱","wlsdnr1233@naver.com","010-9741-2159","미왕빌딩","wook","19990219","M",currentTimestamp,currentTimestamp,currentTimestamp,"N",0,"연극","",currentTimestamp,"system",currentTimestamp,"system");
        userDao.insert(userDto);
        assertTrue(userDao.count()==1);
        userDto.setUser_email("wlsdnremail@aaa.com");
        userDto.setUser_password("2345");
        assertTrue(userDao.update(userDto)==1);

        UserDto userDto2 = userDao.select(userDto.getUser_id());
        assertTrue(userDto.equals(userDto2));
    }

    @Test
    public void increaseLoginCntTest() throws Exception {
        userDao.deleteAll();
        assertTrue(userDao.count()==0);

        UserDto userDto = new UserDto("wlswls","1234","욱","wlsdnr1233@naver.com","010-9741-2159","미왕빌딩","wook","19990219","M",currentTimestamp,currentTimestamp,currentTimestamp,"Y",0,"연극","",currentTimestamp,"system",currentTimestamp,"system");
        userDao.insert(userDto);

        String user_id = userDto.getUser_id();
        System.out.println("user_id = " + user_id);

        userDao.increaseLoginCnt(user_id);

        assertTrue(userDto.getUser_visit_cnt()==2);
    }
}