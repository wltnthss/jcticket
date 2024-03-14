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
public class TicketingController {
    private final TicketingService ticketingService;

    @GetMapping(value = "/ticketing")
    public String ticketing() throws Exception{
        System.out.println("===== /ticketing 진입 =====");
        return "ticketing/popup-test";
    }

//    @GetMapping("/ticketing/poster/{play_id}")
//    public String getPosterPath(@PathVariable(value = "play_id") String play_id)throws Exception{
//
//    }


    // 예매하기 버튼을 눌렀을때 들어오는 url
    // 팝업창을 만들어 보여준다.
    @GetMapping(value = "/ticketing/booking")
    public String getTicketingDetail(@RequestParam(value = "play_id") String play_id, Model model) throws Exception{
        System.out.println("ticketing/detail 진입: parameter ==> " + play_id);
        try{

            Map<String, Object> map = ticketingService.getPlayInfo(play_id);
            String play_name = (String)map.get("play_name");
            String stage_name = (String)map.get("stage_name");
            ArrayList<String> list= (ArrayList<String>)map.get("showing_date");
            String img_name = ticketingService.getPosterPath(play_id);
            model.addAttribute("play_id", play_id);
            model.addAttribute("play_name",play_name);
            model.addAttribute("stage_name",stage_name);
            model.addAttribute("list",list);
            model.addAttribute("img_name", img_name);
            System.out.println("모델객체에 값 넘김:");
            System.out.println("play_id ==> " +play_id);
            System.out.println("play_name ==> "+ play_name);
            System.out.println("stage_name ==> " +stage_name);
            System.out.println("date list ==> " +list.toString());
        }catch (Exception e){
            System.out.println("예외발생!!! at ==> /ticketing/booking");
            e.printStackTrace();
        }
        return "ticketing/booking";
    }

    // 캘린더에서 공연일정을 눌렀을때 회차정보를 받아와 보여준다.
    // ajax를 통해 호출회는 POST 메서드, @RequestBody로 파라미터(공연일정)울 받아 처리한다.
    // @RequestBody => http 요청의 본문이 그대로 전달된다.
    // @ResponseBody => http 요청의 본문이 그대로 전달된다.
    // ajax로 파라미터 넘기는 방법 찾가
    @PostMapping("/ticketing/rounds")
    //@ResponseBody // 자바 객체를 HTTP요청의 바디 내용으로 매핑하여 클라이언트로 전송한다.
    public ResponseEntity<?> getShowingRound(@RequestBody Map<String,String> data) throws Exception{
        // ajax로 받아온 Map data 에는 date_text와 play_id가 들어있다.
        // map에서 date_text와 play_id 분리하기
        System.out.println("=====/ticketing/rounds 진입=====");
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
    @PostMapping("/ticketing/seats")
    public ResponseEntity<?> getSeatPrice(@RequestBody Map<String, String> data) throws Exception{
        // ajax에서 넘어온 data 에는 play_id가 들어있다.
        System.out.println("======/ticketing/seats 진입 =======");
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

    // 유저가 보유한 쿠폰 정보 리스트를 반환하는 컨트롤러.
    @GetMapping("/ticketing/coupons")
    public ResponseEntity<?> getCouponInfo(@RequestParam("userId")String userId) throws Exception{
        System.out.println("======/ticketing/coupons 진입 =======");
        System.out.println("RequestParam ==> " + userId);

        try{
            List<CouponResponseDto> list = ticketingService.getCouponInfo(userId);
            for(CouponResponseDto dto : list){
                System.out.println(dto.toString());
            }
            return ResponseEntity.ok().body(list);
        }catch (Exception e){
            System.out.println("===== 예외 발생 ====");
            return ResponseEntity.badRequest().body("Bad Request!");
        }
    }

    // 예매(ticketing) 테이블 create 요청 받는 컨트롤러..
    @PostMapping("/ticketing/tickets")
    public ResponseEntity<String> createTicket(@RequestBody TicketingRequestDto requestDto)throws Exception{
        System.out.println("========= /ticketing/tickets 진입===============");
        System.out.println(requestDto.toString());
        String res = ticketingService.createTicketing(requestDto);
        System.out.println("생성된 예매 아이디 >> "+ res);
        if(res.equals("fail")){
            return ResponseEntity.status(500).body("internal server error");
        }else {
            return ResponseEntity.ok().body(res);
        }
    }
}
