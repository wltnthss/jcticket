package com.jcticket.user.service;

import com.jcticket.user.dto.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * packageName    : com.jcticket.user.service
 * fileName       : UserServiceImplTest
 * author         : jinwook Song
 * date           : 2024-02-15
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-15        jinwook Song       최초 생성
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserServiceImplTest {
    @Autowired
    UserService userService;


    Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

    @Before
    public void init() throws Exception{
        System.out.println("init DELETE ALL");
        userService.deleteAll();
    }

    @Test
    public void loginCheck() {
    }

    @Test
    public void isUserRetired() throws Exception {
        assertTrue(userService.count()==0);
        UserDto userDto = new UserDto("","1234","욱","wlsdnr1233@naver.com","010-9741-2159","미왕빌딩","wook","19990219","M",currentTimestamp,"N",0,"연극",currentTimestamp,"system",currentTimestamp,"system");
        assertTrue(userService.signup(userDto)==1);
        assertTrue(userService.count()==1);

        UserDto userDto2 = new UserDto("wlswls2","1234","욱","wlsdnr1233@naver.com","010-9741-2259","미왕빌딩","wook2","19990219","M",currentTimestamp,"Y",0,"연극",currentTimestamp,"system",currentTimestamp,"system");
        assertTrue(userService.signup(userDto2)==1);
        assertTrue(userService.count()==2);

        String retireYN = userDto.getUser_retire_yn();
        String retireYN2 = userDto2.getUser_retire_yn();

        assertTrue(retireYN=="Y"||retireYN=="N");
        assertTrue(retireYN2=="Y"||retireYN2=="N");

    }
}