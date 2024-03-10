package com.jcticket.payment.service;

import com.jcticket.payment.dao.PaymentDao;
import com.jcticket.payment.dto.PaymentPrepareDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * packageName    : com.jcticket.payment.service
 * fileName       : PaymentServiceImpl
 * author         : 조영상
 * date           : 3/10/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/10/24         조영상        최초 생성
 */
@Service
@RequiredArgsConstructor
public class PortOneServiceImpl implements PortOneService {
    private final RestTemplate restTemplate;

    public ResponseEntity<String> preparePayment(PaymentPrepareDto dto) {
        // IAMPORT API 호출
        String merchantUid = dto.getMerchantUid();
        int amount = dto.getAmount();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestBody = "{\"merchant_uid\":\"" + merchantUid + "\",\"amount\":" + amount + "}";
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "https://api.iamport.kr/payments/prepare",
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        // IAMPORT API 응답 반환
        return ResponseEntity.status(responseEntity.getStatusCode())
                .headers(responseEntity.getHeaders())
                .body(responseEntity.getBody());
    }
}
