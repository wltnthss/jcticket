package com.jcticket.payment.controller;

import com.jcticket.payment.dto.PaymentRequestDto;
import com.jcticket.payment.dto.PaymentResponseDto;
import com.jcticket.payment.dto.UserPayDto;
import com.jcticket.payment.dto.prepare.PrepareRequestDto;
import com.jcticket.payment.dto.prepare.PrepareResponseDto;
import com.jcticket.payment.service.PaymentService;
import com.jcticket.payment.service.PortOneService;
import com.jcticket.ticketing.service.TicketingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * packageName    : com.jcticket.payment.controller
 * fileName       : PaymentController
 * author         : 조영상
 * date           : 1/31/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 1/31/24         조영상        최초 생성
 */
@Controller
public class PaymentController {
    private final PortOneService portOneService;
    private final TicketingService ticketingService;
    private final PaymentService paymentService;
    @Autowired
    public PaymentController(PortOneService portOneService, TicketingService ticketingService, PaymentService paymentService) {
        this.portOneService = portOneService;
        this.ticketingService = ticketingService;
        this.paymentService = paymentService;
    }

    // 토큰최초 발급 && 사전등록진행하기
    @GetMapping("/payments/{ticketingId}")
    public ResponseEntity<?> preparePayment(@PathVariable String ticketingId) throws Exception{
        System.out.println("==== GET /payments/{ticketingId} 진입 ====");
        System.out.println(ticketingId);
        try{
            // 토큰 발급하기
            String token = portOneService.getToken().getBody().getResponse().getAccess_token();
            System.out.println("발급받은 토큰 >> "+ token);
            // 사전등록 진행하기
            PrepareRequestDto dto = ticketingService.getTicketingIdAmount(ticketingId);
            ResponseEntity<PrepareResponseDto> responseEntity = portOneService.preparePayment(dto, token);
            System.out.println("응답 데이터 >> "+ responseEntity.getBody().getResponse());
            return ResponseEntity.status(responseEntity.getStatusCode()).headers(responseEntity.getHeaders()).body(responseEntity.getBody());
        }catch (Exception e){
            e.printStackTrace();
            // 상태코드별 에러처리 필요
            return ResponseEntity.status(500).body("Exception!");
        }
    }
    // 결제 요청에 필요한 유저 정보 가져오기
    @GetMapping("/payments/{userId}/info")
    public ResponseEntity<?> getUserInfo(@PathVariable String userId) throws Exception{
        System.out.println("====getUSerInfo 진입 ==== +"+ userId );
        UserPayDto userPayDto = paymentService.getUserInfo(userId);
        System.out.println("userPayInfo >> " + userPayDto);
        return ResponseEntity.ok().body(userPayDto);
    }

    // 결제 성공시 흐름
    @PostMapping("/payments/success")
    public ResponseEntity<?> createPayment(@RequestBody PaymentRequestDto requestDto) throws Exception{
        System.out.println("==== POST /payments 진입 ====");
        System.out.println(requestDto.toString());
        try {
            paymentService.createPayment(requestDto);
            paymentService.setBookingStatus(requestDto.getMerchant_uid());
            return ResponseEntity.ok().body("update complete!");
        }catch (Exception e){
            return ResponseEntity.ok().body("ok!");
        }
    }

    // 결제 실패시 흐름
    @GetMapping("/payments/{ticketingId}/delete")
    public ResponseEntity<?> deleteTicketing(@PathVariable String ticketingId) throws Exception{
        System.out.println("==== GET /payments/{ticketingId}/delete 진입 ====");
        System.out.println("PathVariable => "+ticketingId);
        try {
            String res = paymentService.removeTicketing(ticketingId);
            System.out.println();
            return ResponseEntity.ok().body(res);
        }catch (Exception e){
            return ResponseEntity.status(500).body("server error");
        }
    }
}
