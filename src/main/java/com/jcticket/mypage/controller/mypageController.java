package com.jcticket.mypage.controller;

import com.jcticket.mypage.dto.MyPagingDTO;
import com.jcticket.notice.dto.NoticeDto;
import com.jcticket.notice.dto.PageDto;
import com.jcticket.ticketing.dto.TicketingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.jcticket.mypage.service.mypageService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
public class mypageController {
    @Autowired
    mypageService mypageService;

    @GetMapping("/mypageIndex")
    public String mypage(Model model) throws Exception {
        List<TicketingDto> list = mypageService.selectAll_desc();
        model.addAttribute("ticketList", list);
        return "/mypage/mypage_main";
    }


    @GetMapping("/mypageticket")
    public String ticket(@RequestParam(defaultValue = "1")Integer page,
                         @RequestParam(defaultValue = "5")Integer pageSize,
                         Model model) throws Exception {
        int totalCount = mypageService.count();

        try {

            MyPagingDTO myPagingDTO = new MyPagingDTO(totalCount, page, pageSize);

            Map map = new HashMap();
            map.put("offset", (page - 1) * pageSize);
            map.put("pageSize", pageSize);


            List<TicketingDto> list = mypageService.selectAll_page(map);
            model.addAttribute("ticketList", list);
            model.addAttribute("ph", myPagingDTO);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/mypage/mypage_ticket";
    }

    @GetMapping("/mypagecupon")
    public String cupon() {
        return "/mypage/mypage_cupon";
    }

    @GetMapping("/mypageview")
    public String view() {
        return "/mypage/mypage_view";
    }

    @GetMapping("/mypageclient")
    public String client() {
        return "/mypage/mypage_client";
    }
}


