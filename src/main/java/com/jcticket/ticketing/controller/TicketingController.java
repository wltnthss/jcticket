package com.jcticket.ticketing.controller;

import com.jcticket.ticketing.dto.TicketingDto;
import com.jcticket.ticketing.service.TicketingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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


    @GetMapping(value = "/ticketing-detail")
    public String getTicketingDetail(@RequestParam("play_id") String play_id, Model model) throws Exception{
        System.out.println("ticketing/detail 진입: parameter ==> " + play_id);
        try{

            Map<String, Object> map = ticketingService.getPlayInfo(play_id);
            String play_name = (String)map.get("play_name");
            String stage_name = (String)map.get("stage_name");
            ArrayList<String> list= (ArrayList<String>)map.get("showing_date");

            model.addAttribute("play_name",play_name);
            model.addAttribute("stage_name",stage_name);
            model.addAttribute("list",list);
            System.out.println("모델객체에 값 넘김:");
            System.out.println("play_name ==> "+ play_name);
            System.out.println("stage_name ==> " +stage_name);
            System.out.println("date list ==> " +list.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "ticketing/booking";
    }

}
