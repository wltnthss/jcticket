package com.jcticket.payment.service;

import com.jcticket.payment.dto.prepare.PrepareRequestDto;
import com.jcticket.payment.dto.prepare.PrepareResponseDto;
import com.jcticket.payment.dto.token.TokenResponseDto;
import org.springframework.http.ResponseEntity;

/**
 * packageName    : com.jcticket.payment.service
 * fileName       : PaymentService
 * author         : 조영상
 * date           : 1/31/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 1/31/24         조영상        최초 생성
 */
public interface PortOneService {

    // 토큰 발급 받아오기
    ResponseEntity<TokenResponseDto> getToken()throws Exception;

    // 결제 사전검증위해 사전등록
    ResponseEntity<PrepareResponseDto> preparePayment(PrepareRequestDto dto, String token) throws Exception;
}
