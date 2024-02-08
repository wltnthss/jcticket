package com.jcticket.user.service;

import com.jcticket.user.dto.UserDto;

/**
 * packageName    : com.jcticket.login.service
 * fileName       : LoginService
 * author         : jinwook Song
 * date           : 2024-02-01
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-01        jinwook Song       최초 생성
 */
public interface LoginService {
    UserDto loginUser(String user_id) throws Exception;
    int loginCnt(String user_id) throws Exception;
}