package com.jcticket.notice.dao;

import com.jcticket.notice.dto.NoticeValidDto;
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

    private static String namespace = "NoticeMapper.";

    @Override
    public int deleteAll() throws Exception {
        return sqlSession.delete(namespace+"deleteAll");
    }

    @Override
    public int insert(NoticeDto noticeDto) throws Exception {
        return sqlSession.insert(namespace+"insert", noticeDto);
    }

    @Override
    public List<NoticeDto> selectAll() throws Exception {
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
    public int insertValid(NoticeValidDto noticeValidDto) throws Exception {
        return sqlSession.insert(namespace + "insertValid", noticeValidDto);
    }

    @Override
    public int updateInfo(NoticeDto noticeDto) throws Exception {
        return sqlSession.update(namespace+"updateInfo", noticeDto);
    }
}