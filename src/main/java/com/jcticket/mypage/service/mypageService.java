package com.jcticket.mypage.service;

import com.jcticket.notice.dto.NoticeDto;
import com.jcticket.notice.dto.PageDto;
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
    Integer count() throws Exception;

//    List<TicketingDto> selectAll_desc() throws Exception;
//    List<TicketingDto> selectAll_page(Map map) throws Exception;
    List<TicketingDto> selectAll(Map map) throws Exception;


}
