package com.jcticket.mypage.dao;

import com.jcticket.ticketing.dto.TicketingDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * packageName    : com.jcticket.mypage.dao
 * fileName       : mypageDAO
 * author         : JJS
 * date           : 2024-02-10
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-10        JJS       최초 생성
 */

@Repository
public interface mypageDAO {

    int count() throws Exception;
//    List<TicketingDto> selectArll_desc() throws  Exception;
//    public List<TicketingDto> selectAll_page(Map map) throws Exception;

    List<TicketingDto> selectAll(Map map);


    int insert(TicketingDto ticketingDto)  throws Exception;



}
