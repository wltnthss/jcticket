package com.jcticket.admin.service;

import com.jcticket.admin.dao.AdminDao;
import com.jcticket.admin.dto.AdminDto;
import com.jcticket.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * packageName :  com.jcticket.admin.service
 * fileName : AdminServiceImpl
 * author :  jisoo Son
 * date : 2024-02-05
 * description : 관리자 ServiceImpl
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05             jisoo Son             최초 생성
 */
@Controller
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDao adminDao;

    @Override
    public AdminDto login(AdminDto adminDto) throws Exception {
        return adminDao.login(adminDto);
    }

    @Override
    public List<UserDto> userstatics() throws Exception {
        return adminDao.userstatics();
    }

}