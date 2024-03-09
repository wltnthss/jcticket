package com.jcticket.ticketing.controller;

import com.jcticket.ticketing.dto.CouponResponseDto;
import com.jcticket.ticketing.dto.TicketingDto;
import com.jcticket.ticketing.dto.TicketingRequestDto;
import com.jcticket.ticketing.service.TicketingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * packageName    : com.jcticket.ticketing.controller
 * fileName       : TicketController
 * author         : 조영상
 * date           : 1/31/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 1/31/24         조영상        최초 생성
 */
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/ticketing")
public class TicketingController {
    private final TicketingService ticketingService;

    @GetMapping(value = "/")
    public String ticketing() throws Exception{
        System.out.println("===== /ticketing 실행 =====");
        return "ticketing/popup-test";
    }


    // 예매하기 버튼을 눌렀을때 들어오는 url
    // 팝업창을 만들어 보여준다.

    @GetMapping(value = "/detail")
    public String getTicketingDetail(@RequestParam(value = "play_id") String play_id, Model model) throws Exception{
        System.out.println("ticketing/detail 진입: parameter ==> " + play_id);
        try{

            Map<String, Object> map = ticketingService.getPlayInfo(play_id);
            String play_name = (String)map.get("play_name");
            String stage_name = (String)map.get("stage_name");
            ArrayList<String> list= (ArrayList<String>)map.get("showing_date");

            model.addAttribute("play_id", play_id);
            model.addAttribute("play_name",play_name);
            model.addAttribute("stage_name",stage_name);
            model.addAttribute("list",list);
            System.out.println("모델객체에 값 넘김:");
            System.out.println("play_id ==> " +play_id);
            System.out.println("play_name ==> "+ play_name);
            System.out.println("stage_name ==> " +stage_name);
            System.out.println("date list ==> " +list.toString());
        }catch (Exception e){
            System.out.println("예외발생!!! at ==> controller /detail");
            e.printStackTrace();
        }
        return "ticketing/booking";
    }

    // 캘린더에서 공연일정을 눌렀을때 회차정보를 받아와 보여준다.
    // ajax를 통해 호출회는 POST 메서드, @RequestBody로 파라미터(공연일정)울 받아 처리한다.
    // @RequestBody => http 요청의 본문이 그대로 전달된다.
    // @ResponseBody => http 요청의 본문이 그대로 전달된다.
    // ajax로 파라미터 넘기는 방법 찾가
    @PostMapping("/detail/round")
    //@ResponseBody // 자바 객체를 HTTP요청의 바디 내용으로 매핑하여 클라이언트로 전송한다.
    public ResponseEntity<?> getShowingRound(@RequestBody Map<String,String> data) throws Exception{
        // ajax로 받아온 Map data 에는 date_text와 play_id가 들어있다.
        // map에서 date_text와 play_id 분리하기

            String date_text = data.get("date_text");
            String play_id = data.get("play_id");
        try{
            // 서비스에서 받아온 리스트를 반환한다.
            return ResponseEntity.ok().body(ticketingService.getRoundInfo(play_id, date_text));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("BadRequest!!");
        }
    }

    // 좌석 정보를 넘겨줄 컨트롤러.
    @PostMapping("/detail/seat")
    public ResponseEntity<?> getSeatPrice(@RequestBody Map<String, String> data) throws Exception{
        // ajax에서 넘어온 data 에는 play_id가 들어있다.
        System.out.println("======/detail/seat 진입 =======");
        int seq = Integer.parseInt(data.get("showing_seq"));
        System.out.println("showing_seq = " + seq);
        try{
            System.out.println("===== 정상 처리 =====");
            Map<String, Object> map = ticketingService.getSeatList(seq);
            String price = ticketingService.getSeatPrice(seq);
            map.put("seat_price",price);
            return ResponseEntity.ok().body(map);
        }catch(Exception e){
            System.out.println("===== 예외 발생 =====");
            return ResponseEntity.badRequest().body("Bad Request!");
        }
    }

    // 쿠폰 정보를 넘겨줄 컨트롤러.
    @GetMapping("/detail/coupon")
    public ResponseEntity<?> getCouponInfo(@RequestParam("userId")String userId) throws Exception{
        System.out.println("======/detail/coupon 진입 =======");
        System.out.println("RequestParam ==> " + userId);

        try{
            List<CouponResponseDto> list = ticketingService.getCouponInfo(userId);
            return ResponseEntity.ok().body(list);
        }catch (Exception e){
            System.out.println("===== 예외 발생 ====");
            return ResponseEntity.badRequest().body("Bad Request!");
        }
    }

    // 예매 정보를 받는 컨트롤러
    @PostMapping("/detail/book-info")
    public ResponseEntity<?> createTicket(@RequestBody TicketingRequestDto dto)throws Exception{
        System.out.println("=========book-info 진입===============");
        System.out.println("매수: "+dto.getTicketCnt()+",  좌석 리스트: "+ dto.getSeatList() +",  예매 가격: "+ dto.getTicketingPrice() + ",  예매일: "+dto.getTicketingDate()+ ",  주문자 아이디: "+dto.getUserId()+",  할인가격: "+dto.getDiscountAmount());
        return ResponseEntity.ok().body("ok");
    }
}
