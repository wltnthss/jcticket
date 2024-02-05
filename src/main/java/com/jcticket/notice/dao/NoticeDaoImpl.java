package com.jcticket.notice.dao;

import com.jcticket.notice.dto.NoticeDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * packageName :  com.jcticket.notice.dao
 * fileName : NoticeDaoImpl
 * author :  jisoo Son
 * date : 2024-01-31
 * description : 공지사항 DaoImpl
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

    @Override
    public NoticeDto select(int no) throws Exception {
        return sqlSession.selectOne(namespace+"select", no);
    }

    @Override
    public int count(String keyword) throws Exception {
        return sqlSession.selectOne(namespace+"count", keyword);
    }

    @Override
    public int addViewCnt(int no) throws Exception {
        return sqlSession.update(namespace+"addViewCnt", no);
    }

    @Override
    public List<NoticeDto> pagingList(Map<String, Object> pagingParams) {
        return sqlSession.selectList(namespace+"pagingList", pagingParams);
    }

    @Override
    public List<NoticeDto> pagingViewOrderList(Map<String, Object> pagingParams) {
        return sqlSession.selectList(namespace+"pagingViewOrderList", pagingParams);
    }


}