package com.jcticket.user.dao;

import com.jcticket.user.dto.UserDto;

import java.util.List;
import java.util.Map;

/**
 * packageName    : com.jcticket.user
 * fileName       : UserDao
 * author         : jinwook Song
 * date           : 2024-02-01
 * description    : User DAO 작성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-01        jinwook Song       최초 생성
 */
public interface UserDao {
    //유저 조회
    UserDto select(String user_id) throws Exception; //
    //방문횟수
    int increaseLoginCnt(String user_id) throws Exception; //
    //아이디 중복 확인
    int selectIdDupl(String user_id) throws Exception;//
    //닉네임 중복 확인
    int selectNickNameDupl(String user_nickname) throws Exception;//
    //이메일 중복 확인
    int selectEmailDupl(String user_email) throws Exception;//

    //회원가입
    int insert(UserDto userDto) throws Exception; //
    List<Map<String, Object>> selectImg() throws Exception;
//    sns회원가입
    int insertSNS(UserDto userDto)throws  Exception;

    int count() throws Exception; //
    int delete(String user_id) throws  Exception; //
    int deleteAll() throws Exception;//
}

