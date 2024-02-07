package com.jcticket.user.dao;

import com.jcticket.user.dto.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * packageName    : com.jcticket.user
 * fileName       : UserDaoImpl
 * author         : jinwook Song
 * date           : 2024-02-01
 * description    : Dao 구현한 클래스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-01        jinwook Song       최초 생성
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private SqlSession session;
    private static String namespace = "UserMapper.";

    @Override
    public UserDto selectUser(String user_id){
        return session.selectOne(namespace+"select", user_id);
    }

    @Override
    public int increaseLoginCnt(String user_id) {return session.update(namespace+"increase_visit_cnt", user_id);}
}
