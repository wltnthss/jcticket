package com.jcticket.mypage.controller;

import com.jcticket.admin.dto.CouponDto;
import com.jcticket.mypage.dto.MyUserCouponDto;
import com.jcticket.ticketing.dto.TicketingDto;
import com.jcticket.user.dto.UserDto;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.jcticket.mypage.service.mypageService;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
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
    public String mypage(HttpSession session,
                         Model model) throws Exception {

        String sessionId = (String)session.getAttribute("sessionId");

        System.out.println("sessionId => " + sessionId);

        Map map = new HashMap();
        map.put("selectType", "desc");
        map.put("user_id", sessionId);
        List<TicketingDto> list = mypageService.selectLimit(map);
        model.addAttribute("ticketList", list);
        return "/mypage/mypage_main";
    }


    @GetMapping("/mypageticket")
    public String ticket(@RequestParam(defaultValue = "1") Integer page,
                         @RequestParam(defaultValue = "5") Integer pageSize,
                         @RequestParam(name = "option", defaultValue = "A") String option,
                         @RequestParam(required = false) String start_date,
                         @RequestParam(required = false) String end_date,
                         @RequestParam(required = false) String keyword,
                         @RequestParam(defaultValue = "ok") String cancel,
                         HttpSession session,
                         Model model) throws Exception {




        if(!cancel.equals("ok")) {
            int result = mypageService.ticket_cancel(cancel);
            System.out.println(result);
        }
        

//        if(cancel.equals("cancel")) {
//            System.out.println("응애");
//        }


        String sessionId = (String)session.getAttribute("sessionId");

        System.out.println("sessionId => " + sessionId);


        try {
            Map map = new HashMap();
            map.put("offset", (page - 1) * pageSize);
            map.put("pageSize", pageSize);
            map.put("option", option);
            map.put("start_date", start_date);
            map.put("end_date", end_date);
            map.put("user_id", sessionId);


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
                       HttpSession session,
                       Model model) throws Exception {


        String sessionId = (String)session.getAttribute("sessionId");

        System.out.println("sessionId => " + sessionId);


        try {

            Map map = new HashMap();
            map.put("offset", (page - 1) * pageSize);
            map.put("pageSize", pageSize);
            map.put("option", option);
            map.put("start_date", start_date);
            map.put("end_date", end_date);
            map.put("keyword", keyword);
            map.put("user_id", sessionId);

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

    @RequestMapping(value = "/withdraw", method = {RequestMethod.GET,RequestMethod.POST})
    public String withdraw(HttpSession session,
                           String user_id,
                           String user_password,
                           Model model) throws Exception {
        String id = (String) session.getAttribute("sessionId");

        System.out.println(user_id);
        System.out.println(user_password);



        UserDto userDto = mypageService.user_info(id);

        boolean pass = BCrypt.checkpw(user_password, userDto.getUser_password());

        System.out.println(userDto);

        model.addAttribute("user", userDto);

        if(pass && user_id.equals(userDto.getUser_id())) {

            int result = mypageService.withdraw(userDto);

            System.out.println(result);
            session.invalidate();

            return "/index";
        }

        return "/mypage/withdraw";
    }

    @RequestMapping(value = "/Modifying", method = {RequestMethod.GET, RequestMethod.POST})
    public String modifying(@RequestParam(required = false) String user_password,
                            @RequestParam(required = false) String user_nickname,
                            @RequestParam(required = false) String user_tel,
                            @RequestParam(required = false) String user_address,
                            @RequestParam(required = false) String user_email,
                            HttpSession session,
                            Model model) throws Exception {


        String id = (String) session.getAttribute("sessionId");

        UserDto userDto = mypageService.user_info(id);


        System.out.println(id);


        String email = userDto.getUser_email();

        int index = email.indexOf("@");

        userDto.setUser_email(email.substring(0, index));

        System.out.println(userDto);


        model.addAttribute("user", userDto);

        if (user_nickname != null) {

            try {

                String hashPassword = BCrypt.hashpw(user_password, BCrypt.gensalt());


                userDto.setUser_password(hashPassword);
                userDto.setUser_nickname(user_nickname);
                userDto.setUser_tel(user_tel);
                userDto.setUser_address(user_address);
                userDto.setUser_email(user_email);
                mypageService.user_update(userDto);


                System.out.println(userDto);

                session.invalidate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                return "index";
            }
        }

        return "/mypage/modify";
    }

    @GetMapping("/mypagecupon")
    @PostMapping("mypagecoupn")
    public String cupon(@RequestParam(required = false) String coupon_id,
                        @RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "5") Integer pageSize,
                        @RequestParam(defaultValue = "on") String button,
                        HttpSession session,
                        Model model) throws Exception {


        int a = mypageService.coupon_update();

        System.out.println("a => " + a);

        String sessionId = (String)session.getAttribute("sessionId");

        System.out.println("sessionId => " + sessionId);


        try {
            if (coupon_id != null) {

                CouponDto couponDto = mypageService.coupon_select(coupon_id);

                System.out.println(couponDto);

                Timestamp now = new Timestamp(System.currentTimeMillis());

                if (couponDto.getCoupon_id() != null && couponDto.getCoupon_status().equals("A")) {

//                    UserCouponDto userCouponDto = new UserCouponDto(null, "", coupon_id, null, now, now, "N", now, "Ralo", now, "Ralo");
//                    mypageService.coupon_insert(userCouponDto);
//                    mypageService.update_coupon(couponDto);

                    MyUserCouponDto userCouponDto = new MyUserCouponDto(coupon_id, sessionId, coupon_id, null, now, now, "N", now, "Ralo", now, "Ralo");
                    mypageService.coupon_insert(userCouponDto);
                    mypageService.update_coupon(couponDto);

                }
            }


            Map map = new HashMap();
            map.put("offset", (page - 1) * pageSize);
            map.put("pageSize", pageSize);
            map.put("button", button);
            map.put("user_id", sessionId);

            System.out.println("button => (after)" + button);


            List<MyUserCouponDto> list = mypageService.coupon_list(map);

            int totalCount = mypageService.coupon_count(map);

            System.out.println("totalCount = >" + totalCount);

            PageHandler pageHandler = new PageHandler(totalCount, page, pageSize, button);


            model.addAttribute("coupon_list", list);
            model.addAttribute("ph", pageHandler);


        } catch (Exception e) {
            e.printStackTrace();
        }


        return "/mypage/mypage_cupon";
    }
}


