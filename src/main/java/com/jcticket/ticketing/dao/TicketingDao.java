package com.jcticket.ticketing.dao;

import com.jcticket.ticketing.dto.TicketingDto;
import com.jcticket.viewdetail.dto.ShowingDto;

import java.util.HashMap;
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
    //삽입
    int insertShowing(ShowingDto dto) throws Exception;
    //삭제
    int deleteShowing(String play_id) throws Exception;
    // 공연아이다로 공연일정조회
    List<HashMap<String,Object>> selectShowingDate(String play_id) throws Exception;
    // 공연아이디와 공연시퀀스로 공연회차 조회
    List<HashMap<String,Object>> selectShowingRound(HashMap<String, Object> hm ) throws Exception;

    HashMap<String, Object> selectPlayStageName(String play_id) throws Exception;
}
