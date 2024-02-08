package com.jcticket.mypage.controller;

import com.jcticket.mypage.dto.TicketingDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * packageName    : com.jcticket.mypage.controller
 * fileName       : mypageController
 * author         : JJS
 * date           : 2024-01-31
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-31        JJS       최초 생성
 */
@Controller
//@RequestMapping("/mypage")
public class mypageController {

    @GetMapping("/mypageIndex")
    public String mypage(){
        return "/mypage/mypage_1";
    }


    @GetMapping("/mypageticket")
    public String ticket(){
        return "/mypage/ticketpage";
    }

    @GetMapping("/mypagecupon")
    public String cupon(){
        return "/mypage/cuponpage";
    }

    @GetMapping("/mypageview")
    public String view(){
        return "/mypage/viewpage";
    }

    @GetMapping("/mypageclient")
    public String client(){
        return "/mypage/clientpage";
    }
}


