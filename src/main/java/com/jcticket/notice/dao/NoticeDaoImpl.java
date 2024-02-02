package com.jcticket.notice.dao;

import com.jcticket.notice.dto.NoticeDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName :  com.jcticket.notice.dao
 * fileName : NoticeDaoImpl
 * author :  jisoo Son
 * date : 2024-01-31
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-01-31             jisoo Son             최초 생성
 */
@Repository
public class NoticeDaoImpl implements NoticeDao{

    @Autowired
    private SqlSession sqlSession;

    private static String namespace = "com.jcticket.notice.mybatis.mapper.notice.NoticeMapper.";

    @Override
    public String test() throws Exception {
        return sqlSession.selectOne(namespace + "test");
    }

    @Override
    public List<NoticeDto> list() throws Exception {
        return sqlSession.selectList(namespace+"selectAll");
    }
}