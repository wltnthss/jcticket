package com.jcticket.ticketing.service;

import com.jcticket.payment.dto.prepare.PrepareRequestDto;
import com.jcticket.ticketing.dto.CouponResponseDto;
import com.jcticket.ticketing.dto.TicketingRequestDto;

import java.util.List;
import java.util.Map;

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

    // 서비스에서 어떤 (DAO처럼 단순 쿼리와는 다른) 작업을 구현하고 데이터 가공을 어떻게 할지에 대한 고민이 생각보단 복잡함..
    // Step1. 일정선택

    // 공연명, 공연포스터, 공연일자, 공연장명을 공연아이디를 가지고 받아온다.
    Map<String, Object> getPlayInfo(String play_id) throws Exception;

    // 공연아이디와 공연일자를 가지고 회차 정보 & 회차 시퀀스를 가져온다.
    Map<String, Object> getRoundInfo(String play_id, String date_text) throws Exception;

    // step2. 좌석선택
    // 회차시퀀스로 회차좌석가격을 조회한다.
    String getSeatPrice(int showing_seq) throws Exception;

    // 회차시퀀스로 좌석번호, 좌석상태리스트를 가공하여 반환한다.
    Map<String,Object> getSeatList(int showing_seq) throws Exception;

    // step3. 쿠폰선택
    // 유저아이디를 받아서 쿠폰정보를 반환한다.
    List<CouponResponseDto> getCouponInfo(String userId) throws Exception;

    // step4. 결제(결제 직전 예매테이블 insert/delete 끼지..)
    String createTicketing(TicketingRequestDto requestDto) throws Exception;

    // 결제 사전검증을 위해 만들어진 ticketing 테이블에서 amount 값을 조회하고 ticketing_id 와 함께 전달하는 서비스
    PrepareRequestDto getTicketingIdAmount(String ticketingId) throws Exception;

    // 공연 아이디로 공연 포스터 이미지 경로를 조회한다.
    String getPosterPath(String play_id) throws Exception;

}
