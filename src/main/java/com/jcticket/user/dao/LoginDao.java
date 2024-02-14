package com.jcticket.user.dao;

import com.jcticket.user.dto.UserDto;

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
public interface LoginDao {
    UserDto selectUser(String user_id) throws Exception;
    int increaseLoginCnt(String user_id) throws Exception;


    int count() throws Exception;
    int insert(UserDto userDto) throws Exception;
    int delete(String user_id) throws  Exception;
    int update(UserDto userDto) throws Exception;
    int deleteAll() throws Exception;

}

