package com.jcticket.admin.dao;

import com.jcticket.admin.dto.AdminDto;
import com.jcticket.ticketing.dto.TicketingDto;
import com.jcticket.user.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * packageName :  com.jcticket.admin.dao
 * fileName : AdminDaoImplTest
 * author :  jisoo Son
 * date : 2024-02-05
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05             jisoo Son             최초 생성
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class AdminDaoImplTest {

    @Autowired
    AdminDao adminDao;

    @Test
    public void login() throws Exception{

        // given
        AdminDto adminDto = new AdminDto("jcticket1", "1111");
        // when
        AdminDto validateNickName = adminDao.login(adminDto);
        System.out.println("validateNickName => " + validateNickName);
        // then
        assertTrue(validateNickName.getAdmin_nickname().equals("jc관리자1"));
    }

    @Test
    public void userstatics() throws Exception{

        // given, when
        List<UserDto> userlists = adminDao.userstatics();
        System.out.println("userlists => "+ userlists);
        // then
        assertTrue(userlists.size() == 3);
    }

    @Test
    public void userListCnt() throws Exception{

        // given
        String option = "I";
        String keyword = "1";

        Map<String, Object> pagingParams = new HashMap<>();

        pagingParams.put("option", option);
        pagingParams.put("keyword", keyword);

        // when
        int userCnt = adminDao.usercnt(pagingParams);

        System.out.println("option => " + option);
        System.out.println("keyword => " + keyword);
        System.out.println("userCnt => " + userCnt);

        // then
//        assertTrue(6 == userCnt);
    }

    @Test
    public void insertUser() throws Exception {

        // given
        // 자바 현재 시간 TimeStamp
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        UserDto userDto = new UserDto("jisu15", "1111", "지수", "wltn@naver.com", "010-2521-3414", "서울 성동구",
                "soodari", "19990219", "M", currentTimestamp, currentTimestamp, null, "N", 0, "공연", "고수", currentTimestamp, "userAdmin", currentTimestamp, "userAdmin");
        System.out.println("userDto => " + userDto);
        // when
        int result = adminDao.insertUser(userDto);
        System.out.println("result => " + result);

        // then
    }
}