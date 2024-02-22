package com.jcticket.ticketing.controller;

import com.jcticket.ticketing.dto.TicketingDto;
import com.jcticket.ticketing.service.TicketingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//@RequestMapping(value = "/ticketing")
public class TicketingController {
    private final TicketingService ticketingService;

    @GetMapping(value = "/ticketing")
    public String ticketing() throws Exception{
        System.out.println("/ticketing 실행");
        return "ticketing/popup-test";
    }


    // 예매하기 버튼을 눌렀을때 들어오는 url
    // 팝업창을 만들어 보여준다.

    @GetMapping(value = "/ticketing-detail")
    public String getTicketingDetail(@RequestParam("play_id") String play_id, Model model) throws Exception{
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
            e.printStackTrace();
        }
        return "ticketing/booking";
    }

    // 캘린더에서 공연일정을 눌렀을때 회차정보를 받아와 보여준다.
    // ajax를 통해 호출회는 POST 메서드, @RequestBody로 파라미터(공연일정)울 받아 처리한다.
    // @RequestBody => http 요청의 본문이 그대로 전달된다.
    // @ResponseBody => http 요청의 본문이 그대로 전달된다.
    // ajax로 파라미터 넘기는 방법 찾가
    @PostMapping("/ticketing-detail")
    @ResponseBody // 자바 객체를 HTTP요청의 바디 내용으로 매핑하여 클라이언트로 전송한다.
    public List<String> getShowingRound(@RequestBody Map<String,String> data) throws Exception{
        // ajax로 받아온 Map data 에는 date_text와 play_id가 들어있다.
        // map에서 date_text와 play_id 분리하기
        String play_id = data.get("play_id");
        String date_text = data.get("date_text");
        // 서비스에서 받아온 리스트를 반환한다.
        return ticketingService.getRoundList(play_id, date_text);
    }
}
