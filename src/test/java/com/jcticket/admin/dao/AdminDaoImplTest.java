package com.jcticket.admin.dao;

import com.jcticket.admin.dto.AdminDto;
import com.jcticket.ticketing.dto.TicketingDto;
import com.jcticket.user.dao.LoginDao;
import com.jcticket.user.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    LoginDao userDao;

    final static Timestamp CURRENT_TIMESTAMP = new Timestamp(System.currentTimeMillis());

    @Test
    public void login() throws Exception{

        // given
        AdminDto adminDto = new AdminDto("admin", "admin@gmail.com", "1111", "010-1257-7845", "jcticket 관리자", "Y", CURRENT_TIMESTAMP, "S", CURRENT_TIMESTAMP, "JISOO", CURRENT_TIMESTAMP, "JISOO");
        // when
        int result = adminDao.insertAdmin(adminDto);
        AdminDto validateNickName = adminDao.adminLogin(adminDto);
        // then
        assertEquals(result, 1);
        assertEquals("jcticket 관리자", validateNickName.getAdmin_nickname());

        // after data delete
        int deleteCnt = adminDao.deleteAdmin(validateNickName.getAdmin_id());
        assertEquals(1, deleteCnt);
    }
    @Test
    public void userstatics() throws Exception{

        // given, when
        List<UserDto> userlists = adminDao.userstatics();
        System.out.println("userlists => "+ userlists);
        // then
        assertEquals(3, userlists.size());
    }

    @Test
    public void insertUser() throws Exception {

        // given
        for (int i = 1; i < 9; i++) {
            UserDto userDto = new UserDto("jisoo"+i, "1111", "지수", "wltn@naver.com", "010-1111-341"+i, "서울 성동구",
                    "soodal"+i, "19990219", "M", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, null, "N", 0, "공연", "고수", CURRENT_TIMESTAMP, "userAdmin", CURRENT_TIMESTAMP, "userAdmin");
            // when
            int result = adminDao.insertUser(userDto);
            // then
            assertEquals(1, result);
        }
    }
    @Test
    public void deleteUser() throws Exception {

        // given
        for (int i = 1; i < 9; i++) {
            UserDto userDto = new UserDto("jisoo"+i, "1111", "지수", "wltn@naver.com", "010-2521-341"+i, "서울 성동구",
                    "soodal"+i, "19990219", "M", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, null, "N", 0, "공연", "고수", CURRENT_TIMESTAMP, "userAdmin", CURRENT_TIMESTAMP, "userAdmin");
            // when
            int result = adminDao.userDelete("jisoo" + i);
            // then
            assertEquals(1, result);
        }
    }
    @Test
    public void userRetireUpdate() throws Exception {
        // given
        UserDto userDto = new UserDto("0sang", "4444");
        UserDto testUser = userDao.selectUser(userDto.getUser_id());

        // when
        int updateResult = adminDao.userRetireUpdate(testUser.getUser_id());
        UserDto afterUpdateTestUser = userDao.selectUser(userDto.getUser_id());

        // then
        assertEquals(1, updateResult);
        assertEquals("Y", afterUpdateTestUser.getUser_retire_yn());
    }
}