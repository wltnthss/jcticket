package com.jcticket.ticketing.dao;

import com.jcticket.ticketing.dto.TicketingDto;

import java.util.List;

/**
 * packageName    : com.jcticket.ticketing.dao
 * fileName       : TicketDao
 * author         : 조영상
 * date           : 1/31/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 1/31/24         조영상        최초 생성
 */
public interface TicketingDao {

    List<TicketingDto> selectAll() throws Exception;
    String selectPlayName(int play_id) throws Exception;
    String selectStageName(int play_id) throws Exception;

}
