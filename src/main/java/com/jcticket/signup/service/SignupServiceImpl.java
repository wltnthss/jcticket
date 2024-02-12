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
 * description    : SignupService 구현 클래스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-07        jinwook Song       최초 생성
 */
@Service
public class SignupServiceImpl implements SignupService {
    @Autowired
    SignupDao signupDao;

    //회원가입 시 user table에 입력한 정보들 insert
    @Override
    public int insertUser(SignupDto signupDto)throws Exception{
        return signupDao.insertUser(signupDto);
    }

    //중복 아이디 체크
    @Override
    public int chkIdDupl(String user_id) throws Exception {
        return signupDao.selectOne(user_id);
    }

    //중복 닉네임 체크
    @Override
    public int chkNickNameDupl(String user_nickname) throws Exception {
        return signupDao.selectNickName(user_nickname);
    }
}
