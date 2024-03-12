package com.jcticket.payment.service;

import com.jcticket.payment.dto.PaymentDto;
import com.jcticket.payment.dto.PaymentRequestDto;
import com.jcticket.payment.dto.UserPayDto;
import com.jcticket.ticketing.dto.TicketingRequestDto;

/**
 * packageName    : com.jcticket.payment.service
 * fileName       : PaymentService
 * author         : 조영상
 * date           : 3/13/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/13/24         조영상        최초 생성
 */
public interface PaymentService {
    // 결제 성공시 payment 테이블 insert
    int createPayment(PaymentRequestDto dto)throws Exception;

    // 결제 성공시 show_seat 테이블과 user_coupon 테이블의 각각 상태를 업데이트하는 서비스:
    //  (파라미터로 한번에 두 개의 Dao에서 필요한 값들을 받는다)
    String setBookingStatus(String ticketingId) throws Exception;

    // 결제 or 결제 사전검증 실패시 만들어진 ticketing DB 삭제
    String removeTicketing(String userId) throws Exception;

    UserPayDto getUserInfo(String userId) throws Exception;
}
