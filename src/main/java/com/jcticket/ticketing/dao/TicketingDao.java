package com.jcticket.ticketing.dao;

import com.jcticket.ticketing.dto.TicketingDto;
import com.jcticket.viewdetail.dto.ShowingDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // 삽입
    int insert(ShowingDto dto) throws Exception;
    // 공연아이디별 삭제
    int deleteByPlayId(String play_id) throws Exception;
    // 회차시퀀스별 삭제
    int deleteBySeq(int seq) throws Exception;
    // 전체 삭제
    int deleteAll() throws Exception;
    String getNow() throws Exception;
    List<TicketingDto> selectAll() throws Exception;

    String selectId() throws Exception;

    // 공연아이디별 회차 수 카운트
    int countByPlayId(String play_id) throws Exception;

    // 공연아이디별 조회
    List<ShowingDto> selectByPlayId(String play_id) throws Exception;

    // 공연아이디별 공연일정 조회
    List<Map<String,String>> selectDateByPlayId(String play_id) throws Exception;

    // 공연아이디 && 공연일정별로 회차정보 조회
    List<Map<String,String>> selectRound(Map<String,String> map ) throws Exception;

    // 공연아이디로 공연명과 공연표지, 공연장명 조회
    Map<String,Object> selectPlayStageName(String play_id) throws Exception;
}
