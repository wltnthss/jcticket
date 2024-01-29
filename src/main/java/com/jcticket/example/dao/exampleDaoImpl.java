package com.jcticket.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class exampleDaoImpl implements exampleDao{
    @Autowired
    private SqlSession sqlSession;

    private static String namespace = "com.jcticket.example.mybatis.mapper.example.exampleMapper.";
    @Override
    public String test() throws Exception {
        return sqlSession.selectOne(namespace + "test");
    }
}
