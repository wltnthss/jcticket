package com.jcticket.ticketing.service;

import com.jcticket.ticketing.dto.TicketingDto;

import java.util.List;

/**
 * packageName    : com.jcticket.ticketing.service
 * fileName       : TicketService
 * author         : 조영상
 * date           : 1/31/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 1/31/24         조영상        최초 생성
 */
public interface TicketingService {
    String showNow() throws Exception;
    List<TicketingDto> getTicketingAll() throws Exception;
    String getTicketingId(int ticketingId) throws Exception;
}
