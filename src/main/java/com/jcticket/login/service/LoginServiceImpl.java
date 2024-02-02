package com.jcticket.login.service;

import com.jcticket.user.dao.UserDao;
import com.jcticket.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.jcticket.login.service
 * fileName       : LoginServiceImpl
 * author         : jinwook Song
 * date           : 2024-02-01
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-01        jinwook Song       최초 생성
 */
@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    UserDao userDao;

    public UserDto selectUser(String user_id)throws Exception{
        return userDao.selectUser(user_id);
    }
}
