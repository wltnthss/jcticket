package com.jcticket.mypage.dao;

import com.jcticket.mypage.dto.InquiryDto;
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
    public int count(Map map) throws Exception {
        return session.selectOne(namespace + "count", map);
    }

    @Override
    public int view_count(Map map) throws Exception {
        return session.selectOne(namespace + "view_count", map);
    }

    @Override
    public List<TicketingDto> selectAll(Map map) {
        return session.selectList(namespace + "selectAll", map);
    }
    public List<TicketingDto> selectLimit(Map map) {
        return session.selectList(namespace + "selectLimit", map);
    }

    @Override
    public List<TicketingDto> select_list() throws Exception {
        return session.selectList(namespace + "select_list");
    }
    @Override
    public List<TicketingDto> select_view(Map map) throws Exception {
        return session.selectList(namespace + "select_view", map);
    }

    @Override
    public int insert(TicketingDto ticketingDto) throws Exception {
        return session.insert(namespace + "insert", ticketingDto);
    }

    @Override
    public int insert_InquiryDto(InquiryDto inquiryDto) throws Exception {
        return session.insert(namespace + "Inquiry_insert", inquiryDto);
    }


}
