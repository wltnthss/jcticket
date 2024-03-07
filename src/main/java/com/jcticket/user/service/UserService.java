package com.jcticket.user.service;

import com.jcticket.user.dto.UserDto;

import java.util.List;
import java.util.Map;

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
    //유저조회
    UserDto getUser(String user_id) throws Exception;
    //방문횟수
    int increaseLoginCnt(String user_id)throws Exception;
    //아이디 중복 확인
    int chkIdDupl(String user_id) throws Exception;
    //닉네임 중복확인
    int chkNickNameDupl(String user_nickname) throws Exception;
    //회원가입
    int signup(UserDto userDto) throws Exception;
    //sns회원가입
    int signupSNS(UserDto userDto) throws Exception;

    //로그인 유효성검사
    boolean loginCheck(String user_id, String user_password)throws Exception;
    //탈퇴여부 판단. Y이면 로그인하지 못함
    boolean isUserRetired(String user_id) throws Exception;

    int deleteAll() throws Exception;
    int count() throws Exception;
    List<Map<String, Object>> selectImg() throws Exception;

}
