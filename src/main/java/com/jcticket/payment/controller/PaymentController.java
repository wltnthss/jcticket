package com.jcticket.payment.controller;

import com.jcticket.payment.dto.PaymentPrepareDto;
import com.jcticket.payment.dto.PaymentRequestDto;
import com.jcticket.payment.service.PortOneService;
import com.jcticket.ticketing.service.TicketingService;
import lombok.RequiredArgsConstructor;
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

    @Autowired
    public PaymentController(PortOneService portOneService, TicketingService ticketingService) {
        this.portOneService = portOneService;
        this.ticketingService = ticketingService;
    }
    @GetMapping("/payments/{ticketingId}")
    public ResponseEntity<?> getTicketingId(@PathVariable String ticketingId) throws Exception{
        System.out.println("==== GET /payments/{ticketingId} 진입 ====");
        try{
            System.out.println(ticketingId);
            PaymentPrepareDto dto = ticketingService.getTicketingIdAmount(ticketingId);
            ResponseEntity<String> responseEntity = portOneService.preparePayment(dto);
            System.out.println("응답 코드 >> "+ responseEntity.getStatusCode());
            return ResponseEntity.status(responseEntity.getStatusCode()).headers(responseEntity.getHeaders()).body(responseEntity.getBody());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("bad request!");
        }
    }
    @PostMapping("/payments")
    public ResponseEntity<?> createPayment(@RequestBody PaymentRequestDto requestDto) throws Exception{
        System.out.println("==== POST /payments 진입 ====");
        System.out.println(requestDto.toString());
        return ResponseEntity.ok().body("ok!");
    }
}
