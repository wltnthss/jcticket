package com.jcticket.user.service;

import com.jcticket.user.dao.LoginDao;
import com.jcticket.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.jcticket.login.service
 * fileName       : LoginServiceImpl
 * author         : jinwook Song
 * date           : 2024-02-01
 * description    : LoginService 구현클래스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-01        jinwook Song       최초 생성
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginDao loginDao;

    //user_id에 맞는 유저 정보 가져옴
    @Override
    public UserDto loginUser(String user_id)throws Exception{
        return loginDao.selectUser(user_id);
    }

    //user가 로그인 할때마다 1씩 증가. 방문횟수
    @Override
    public int loginCnt(String user_id) throws Exception {
        return loginDao.increaseLoginCnt(user_id);
    }

}
