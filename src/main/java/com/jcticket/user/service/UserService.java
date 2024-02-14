package com.jcticket.user.service;

import com.jcticket.user.dto.UserDto;

/**
 * packageName    : com.jcticket.login.service
 * fileName       : LoginService
 * author         : jinwook Song
 * date           : 2024-02-01
 * description    : LoginService
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-01        jinwook Song       최초 생성
 */

public interface UserService {
    UserDto loginUser(String user_id) throws Exception;
    int insertUser(UserDto userDto) throws Exception;
    int chkIdDupl(String user_id) throws Exception;
    int chkNickNameDupl(String user_nickname) throws Exception;
}
