package com.jcticket.signup.service;

import com.jcticket.signup.dto.SignupDto;
import com.jcticket.user.dto.UserDto;

/**
 * packageName    : com.jcticket.signup.service
 * fileName       : SignupService
 * author         : jinwook Song
 * date           : 2024-02-07
 * description    : Signup Service
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-07        jinwook Song       최초 생성
 */

public interface SignupService {
    int insertUser(SignupDto signupDto) throws Exception;
    int chkIdDupl(String user_id) throws Exception;
    int chkNickNameDupl(String user_nickname) throws Exception;
}
