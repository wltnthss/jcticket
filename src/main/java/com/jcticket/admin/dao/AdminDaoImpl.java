package com.jcticket.admin.dao;

import com.jcticket.admin.dto.AdminDto;
import com.jcticket.ticketing.dto.TicketingDto;
import com.jcticket.user.dto.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * packageName :  com.jcticket.admin.dao
 * fileName : AdminDaoImpl
 * author :  jisoo Son
 * date : 2024-02-05
 * description : 관리자 DaoImpl
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05             jisoo Son             최초 생성
 */
@Repository
public class AdminDaoImpl implements AdminDao{

    @Autowired
    private SqlSession sqlSession;

    private static final String namespace = "adminMapper.";

    @Override
    public AdminDto login(AdminDto adminDto) throws Exception {
        return sqlSession.selectOne(namespace + "login", adminDto);
    }

    @Override
    public List<UserDto> userstatics() throws Exception {
        return sqlSession.selectList(namespace + "userstatics");
    }

    @Override
    public int usercnt(Map<String, Object> options) throws Exception {
        return sqlSession.selectOne(namespace + "usercnt", options);
    }
    @Override
    public List<UserDto> userPaingList(Map<String, Object> pagingParams) throws Exception {
        return sqlSession.selectList(namespace + "userpaginglist", pagingParams);
    }

    @Override
    public int insertUser(UserDto userDto) throws Exception {
        return sqlSession.insert(namespace + "insertUser", userDto);
    }

    @Override
    public int userDelete(String user_id) throws Exception {
        return sqlSession.update(namespace + "userretireupdate", user_id);
    }
}