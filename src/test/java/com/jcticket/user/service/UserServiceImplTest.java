package com.jcticket.user.service;

import com.jcticket.user.dto.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mindrot.jbcrypt.BCrypt;
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
    public void loginCheck() throws Exception{
        assertTrue(userService.count()==0);
        UserDto userDto = new UserDto("wlswls","1234","욱","wlsdnr1233@naver.com","010-9741-2159","미왕빌딩","wook","19990219","M",currentTimestamp,"N",0,"연극",currentTimestamp,"system",currentTimestamp,"system");
        //비밀번호 암호화
        String hashPassword = BCrypt.hashpw(userDto.getUser_password(), BCrypt.gensalt());
        userDto.setUser_password(hashPassword);
        //insert(회원가입)
        assertTrue(userService.signup(userDto)==1);
        System.out.println("userDto = " + userDto);

        String user_id = userDto.getUser_id();
        //저장(암호화)된 비밀번호
        String user_dto_password = userDto.getUser_password();
        //사용자가 입력한 비밀번호
        String user_password = "1234";

        assertFalse(user_id==null||user_id.isEmpty());
        assertFalse(user_password==null||user_password.isEmpty());
        assertTrue(BCrypt.checkpw(user_password,user_dto_password)&&userDto != null);
    }

    @Test
    public void isUserRetired() throws Exception {
        assertTrue(userService.count()==0);
        UserDto userDto = new UserDto("wlswls","1234","욱","wlsdnr1233@naver.com","010-9741-2159","미왕빌딩","wook","19990219","M",currentTimestamp,"N",0,"연극",currentTimestamp,"system",currentTimestamp,"system");
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