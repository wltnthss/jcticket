package com.jcticket.ticketing.controller;

import com.jcticket.ticketing.service.TicketingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping(value = "/now")
    public String getNowTime(Model model) throws Exception{
        String data = ticketingService.showNow();
        model.addAttribute("data", data);
        return"ticketing/ticketing";
    }

}
