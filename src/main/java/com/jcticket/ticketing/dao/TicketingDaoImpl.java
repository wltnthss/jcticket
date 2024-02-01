package com.jcticket.ticketing.dao;

import com.jcticket.ticketing.dto.TicketingDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * packageName    : com.jcticket.ticketing.dao
 * fileName       : TicketingDaoImpl
 * author         : 조영상
 * date           : 2/1/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/1/24         조영상        최초 생성
 */
@Repository
public class TicketingDaoImpl implements TicketingDao{
    @Autowired
    SqlSession sqlSession;
    public final String namespace = "com.jcticket.ticketing.TicketMapper.";
    @Override
    public String getNow() throws Exception {
        return sqlSession.selectOne(namespace+"getNow");
    }

    @Override
    public TicketingDto selectTicketingInfo(int ticketingId) throws Exception {
        return sqlSession.selectOne(namespace+"selectTicketInfo", ticketingId);
    }
}
