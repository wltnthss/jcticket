package com.jcticket.user.service;

import com.jcticket.user.dao.UserDao;
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
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    //user_id에 맞는 유저 정보 가져옴
    @Override
    public UserDto loginUser(String user_id)throws Exception{

        // user가 로그인 할때마다 1씩 증가. 방문횟수
        userDao.increaseLoginCnt(user_id);

        return userDao.select(user_id);
    }



    @Override
    public int insertUser(UserDto userDto) throws Exception {
        return userDao.insert(userDto);
    }

    @Override
    public int chkIdDupl(String user_id) throws Exception {
        return userDao.selectIdDupl(user_id);
    }

    @Override
    public int chkNickNameDupl(String user_nickname) throws Exception {
        return userDao.selectNickNameDupl(user_nickname);
    }
}
