package com.jcticket.mypage.controller;

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
        Map map = new HashMap();
        map.put("selectType", "desc");
        List<TicketingDto> list = mypageService.selectLimit(map);
        model.addAttribute("ticketList", list);
        return "/mypage/mypage_main";
    }



    @GetMapping("/mypageticket")
    public String ticket(@RequestParam(defaultValue = "1")Integer page,
                         @RequestParam(defaultValue = "5")Integer pageSize,
                         @RequestParam(name = "option", defaultValue = "A") String option,
                         @RequestParam(required = false) String start_date,
                         @RequestParam(required = false) String end_date,
                         @RequestParam(required = false) String keyword,
                         Model model) throws Exception {

        try {
            Map map = new HashMap();
            map.put("offset", (page - 1) * pageSize);
            map.put("pageSize", pageSize);
            map.put("option", option);
            map.put("start_date", start_date);
            map.put("end_date", end_date);

            int totalCount = mypageService.count(map);

            PageHandler myPagingDTO = new PageHandler(totalCount, page, pageSize, option, start_date, end_date, keyword);

            List<TicketingDto> list = mypageService.selectAll(map);
            model.addAttribute("ticketList", list);
            model.addAttribute("ph", myPagingDTO);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/mypage/mypage_ticket";
    }



    @GetMapping("/mypagedetail")
    public String detail(@RequestParam(required = false) String ticketing_id,
                         Model model) throws Exception {

        TicketingDto ticketingDto = mypageService.ticket_detail(ticketing_id);
        System.out.println(ticketing_id);
        System.out.println(ticketingDto.toString());

        model.addAttribute("ticketingDto", ticketingDto);

        return "/mypage/mypage_detail";
    }




    @GetMapping("/mypageview")
    public String view(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "3") Integer pageSize,
                       @RequestParam(name = "option", defaultValue = "A") String option,
                       @RequestParam(required = false) String start_date,
                       @RequestParam(required = false) String end_date,
                       @RequestParam(required = false) String keyword,
                       Model model) throws Exception {


        System.out.println("option => " + option);
        System.out.println("start_date => " + start_date);
        System.out.println("end_date => " + end_date);
        System.out.println("keyword => " + keyword);

        try {

            Map map = new HashMap();
            map.put("offset", (page - 1) * pageSize);
            map.put("pageSize", pageSize);
            map.put("option", option);
            map.put("start_date", start_date);
            map.put("end_date", end_date);
            map.put("keyword", keyword);

            int totalCount = mypageService.view_count(map);

            System.out.println("totalCount = " + totalCount);

            PageHandler myPagingDTO = new PageHandler(totalCount, page, pageSize, option, start_date, end_date, keyword);

            List<TicketingDto> list = mypageService.select_view(map);

            model.addAttribute("view_list", list);
            model.addAttribute("ph", myPagingDTO);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "/mypage/mypage_view";
    }



    @GetMapping("/mypageclient")
    public String client() {
        return "/mypage/mypage_client";
    }

    @GetMapping("/mypage_client_in")
    public String client_insert(Model model) throws Exception {
        return "/mypage/mypage_client_Insert";
    }

    @GetMapping("/withdraw")
    public String withdraw() {
        return "/mypage/withdraw";
    }

    @GetMapping("/mypagecupon")
    public String cupon(@RequestParam(required = false) String coupon_id) throws  Exception{

        int a = mypageService.coupon_count(coupon_id);

        if(a != 0 && coupon_id != null) {

        }




        return "/mypage/mypage_cupon";
    }
}


