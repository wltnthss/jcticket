package com.jcticket.mypage.dao;

import com.jcticket.ticketing.dto.TicketingDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * packageName    : com.jcticket.mypage.dao
 * fileName       : mypageImpl
 * author         : JJS
 * date           : 2024-02-10
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-10        JJS       최초 생성
 */
@Repository
public class mypageImpl implements mypageDAO {

    @Autowired
    private SqlSession session;

    public final String namespace = "com.jcticket.ticketing.mybatis.mapper.mypage.mypageMapper.";

    @Override
    public List<TicketingDto> findAll() throws Exception {
        return session.selectList(namespace + "findAll");
    }

    @Override
    public List<TicketingDto> selectArll_desc() throws Exception {
        return session.selectList(namespace + "selectAll_desc");
    }

    @Override
    public int count() throws Exception {
        return session.selectOne(namespace + "count");
    }

    @Override
    public List<TicketingDto> selectAll_page(Map map) throws Exception {
        return session.selectList(namespace + "selectAll_page", map);
    }


}
