package com.jcticket.category.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * packageName :  com.jcticket.category.dao
 * fileName : CategoryDaoImpl
 * author :  jisoo Son
 * date : 2024-03-06
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-03-06             jisoo Son             최초 생성
 */
@Repository
public class CategoryDaoImpl implements CategoryDao{

    @Autowired
    private SqlSession session;
    private static String namespace = "CategoryMapper.";

    @Override
    public List<Map<String, Object>> selectConcertList() throws Exception {
        return session.selectList(namespace+"selectConcertList");
    }

    @Override
    public List<Map<String, Object>> selectMusicalList() throws Exception {
        return session.selectList(namespace+"selectMusicalList");
    }

    @Override
    public List<Map<String, Object>> selectTheaterList() throws Exception {
        return session.selectList(namespace+"selectTheaterList");
    }

    @Override
    public List<Map<String, Object>> selectClassicList() throws Exception {
        return session.selectList(namespace+"selectClassicList");
    }
}