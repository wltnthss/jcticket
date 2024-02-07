package com.jcticket.admin.dao;

import com.jcticket.admin.dto.AdminDto;
import com.jcticket.user.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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
        AdminDto adminDto = new AdminDto("jcticket1", "1111");

        AdminDto loginCheck = adminDao.login(adminDto);
        System.out.println("loginCheck => " + loginCheck);

        assertTrue(loginCheck != null);
    }

    @Test
    public void userstatics() throws Exception{
//        UserDto userDto = new UserDto("1", "wook1234");

        List<UserDto> userlists = adminDao.userstatics();
        System.out.println("userlists => " + userlists);

        assertTrue(userlists.size() == 11);

    }
}