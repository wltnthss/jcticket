package com.jcticket.signup.dao;

import com.jcticket.signup.dto.SignupDto;
import com.jcticket.user.dto.UserDto;

/**
 * packageName    : com.jcticket.signup.dao
 * fileName       : SignupDao
 * author         : jinwook Song
 * date           : 2024-02-07
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-07        jinwook Song       최초 생성
 */
public interface SignupDao {
    int insertUser(SignupDto signupDto) throws Exception;
    int selectOne(String user_id) throws Exception;
    int selectNickName(String user_nickname) throws Exception;
}
