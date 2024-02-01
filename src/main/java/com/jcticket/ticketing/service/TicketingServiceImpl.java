package com.jcticket.ticketing.service;

import com.jcticket.ticketing.dao.TicketingDao;
import com.jcticket.ticketing.dto.TicketingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.jcticket.ticketing.service
 * fileName       : TicketingServiceImpl
 * author         : 조영상
 * date           : 2/1/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/1/24         조영상        최초 생성
 */
@Service
@RequiredArgsConstructor
public class TicketingServiceImpl implements TicketingService{
    private final TicketingDao ticketingDao;
    @Override
    public String showNow() throws Exception{
        return ticketingDao.getNow();
    }

    @Override
    public TicketingDto getTicketingInfo(int ticketingId) throws Exception{
        return ticketingDao.selectTicketingInfo(ticketingId);
    }
}
