package com.jcticket.signup.service;

import com.jcticket.signup.dao.SignupDao;
import com.jcticket.signup.dto.SignupDto;
import com.jcticket.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.jcticket.signup.service
 * fileName       : SignupServiceImpl
 * author         : jinwook Song
 * date           : 2024-02-07
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-07        jinwook Song       최초 생성
 */
@Service
public class SignupServiceImpl implements SignupService {
    @Autowired
    SignupDao signupDao;

    @Override
    public int insertUser(SignupDto signupDto)throws Exception{
        return signupDao.insertUser(signupDto);
    }

    @Override
    public int chkIdDupl(String user_id) throws Exception {
        return signupDao.selectOne(user_id);
    }

    @Override
    public int chkNickNameDupl(String user_nickname) throws Exception {
        return signupDao.selectNickName(user_nickname);
    }
}
