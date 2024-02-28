package com.jcticket.mypage.service;

import com.jcticket.ticketing.dto.TicketingDto;

import java.util.List;
import java.util.Map;

/**
 * packageName    : com.jcticket.mypage.service
 * fileName       : mypageService
 * author         : JJS
 * date           : 2024-02-10
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-10        JJS       최초 생성
 */
public interface mypageService {
    Integer count(Map map) throws Exception;
    Integer view_count(Map map) throws Exception;

    List<TicketingDto> selectAll(Map map) throws Exception;

    List<TicketingDto> select_list() throws Exception;
    List<TicketingDto> selectLimit(Map map) throws Exception;
    List<TicketingDto> select_view(Map map) throws Exception;

}
