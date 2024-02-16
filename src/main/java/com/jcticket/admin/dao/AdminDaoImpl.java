package com.jcticket.admin.dao;

import com.jcticket.admin.dto.AdminDto;
import com.jcticket.agency.dto.AgencyDto;
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
    public AdminDto adminLogin(AdminDto adminDto) throws Exception {
        return sqlSession.selectOne(namespace + "adminLogin", adminDto);
    }
    @Override
    public List<UserDto> userstatics() throws Exception {
        return sqlSession.selectList(namespace + "userStatics");
    }
    @Override
    public int usercnt(Map<String, Object> options) throws Exception {
        return sqlSession.selectOne(namespace + "userCnt", options);
    }
    @Override
    public List<UserDto> userPaingList(Map<String, Object> pagingParams) throws Exception {
        return sqlSession.selectList(namespace + "userPagingList", pagingParams);
    }
    @Override
    public int insertUser(UserDto userDto) throws Exception {
        return sqlSession.insert(namespace + "insertUser", userDto);
    }
    @Override
    public int userRetireUpdate(String user_id) throws Exception {
        return sqlSession.update(namespace + "userRetireUpdate", user_id);
    }
    @Override
    public int userDelete(String user_id) throws Exception {
        return sqlSession.delete(namespace+"userDelete", user_id);
    }
    @Override
    public int insertAdmin(AdminDto adminDto) throws Exception {
        return sqlSession.insert(namespace+"insertAdmin", adminDto);
    }
    @Override
    public int deleteAdmin(String admin_id) throws Exception {
        return sqlSession.delete(namespace + "adminDelete", admin_id);
    }
    @Override
    public int insertAgency(AgencyDto agencyDto) throws Exception {
        return sqlSession.insert(namespace+"insertAgency", agencyDto);
    }
    @Override
    public int deleteAllAgency() throws Exception {
        return sqlSession.delete(namespace+"deleteAllAgency");
    }
    @Override
    public int countAllAgency() throws Exception {
        return sqlSession.selectOne(namespace + "countAllAgency");
    }

    @Override
    public int agencyCnt(Map<String, Object> options) throws Exception {
        return sqlSession.selectOne(namespace + "agencyCnt", options);
    }

    @Override
    public List<AgencyDto> agencyPaingList(Map<String, Object> pagingParams) throws Exception {
        return sqlSession.selectList(namespace + "agencyPagingList", pagingParams);
    }
}