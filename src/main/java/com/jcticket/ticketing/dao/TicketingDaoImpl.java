package com.jcticket.ticketing.dao;

import com.jcticket.ticketing.dto.TicketingDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    SqlSession session;
    public final String namespace = "com.jcticket.ticketing.mybatis.mapper.ticketing.TicketingMapper.";
    @Override
    public List<TicketingDto> selectAll() throws Exception {
        return session.selectList(namespace+"selectAll");
    }
    @Override
    public String selectPlayName(int play_id) throws Exception{
        return session.selectOne(namespace+"selectPlayName", play_id);
    }

    @Override
    public String selectStageName(int stage_id)throws Exception{
        return session.selectOne(namespace+"selectStageName", stage_id);
    }

}
