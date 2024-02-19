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

    int count(Map map) throws Exception;
    int view_count(Map map) throws Exception;

    List<TicketingDto> selectAll(Map map) throws  Exception;
    List<TicketingDto> selectLimit(Map map) throws  Exception;

    List<TicketingDto> select_list() throws Exception;
    List<TicketingDto> select_view(Map map) throws Exception;

    int insert(TicketingDto ticketingDto)  throws Exception;


}
