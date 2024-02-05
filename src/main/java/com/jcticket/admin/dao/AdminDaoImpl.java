package com.jcticket.admin.dao;

import com.jcticket.admin.dto.AdminDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * packageName :  com.jcticket.admin.dao
 * fileName : AdminDaoImpl
 * author :  jisoo Son
 * date : 2024-02-05
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05             jisoo Son             최초 생성
 */
@Repository
public class AdminDaoImpl implements AdminDao{

    @Autowired
    private SqlSession sqlSession;

    private static String namespace = "adminMapper.";

    @Override
    public AdminDto login(AdminDto adminDto) throws Exception {
        return sqlSession.selectOne(namespace + "login", adminDto);
    }

}