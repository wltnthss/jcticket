package com.jcticket.user.service;

import com.jcticket.user.dao.UserDao;
import com.jcticket.user.dto.UserDto;
import com.jcticket.user.service.LoginService;
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
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserDao userDao;

    @Override
    public UserDto loginUser(String user_id)throws Exception{
        return userDao.selectUser(user_id);
    }

    @Override
    public int loginCnt(String user_id) throws Exception {
        return userDao.increaseLoginCnt(user_id);
    }

}
