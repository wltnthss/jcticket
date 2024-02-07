package com.jcticket.admin.controller;

import com.jcticket.admin.dto.AdminDto;
import com.jcticket.admin.service.AdminService;
import com.jcticket.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * packageName :  com.jcticket.admin.controller
 * fileName : AdminController
 * author :  jisoo Son
 * date : 2024-02-05
 * description : 관리자 Controller
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05             jisoo Son             최초 생성
 */
@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/admin")
    public String admin() throws Exception{
        return "admin/adminloginform";
    }

    @GetMapping("/admin/logout")
    public String adminlogout(HttpServletRequest request) throws Exception{

        HttpSession session = request.getSession();
        System.out.println("logout session => " + session);

        // 로그아웃 후 세션 삭제
        session.invalidate();

        return "redirect:/admin";
    }

    @GetMapping("/admin/dashboard")
    public String admindashboard(Model model) throws Exception{

        try {
            List<UserDto> userLists = adminService.userstatics();
            System.out.println("userLists => " + userLists);

            model.addAttribute("userLists", userLists);
        } catch (Exception e){
            e.printStackTrace();
        }

        return "admin/admindashboard";
    }
    @PostMapping("/admin")
    @ResponseBody
    private String login(@RequestBody AdminDto adminDto, HttpServletRequest request) throws Exception {

        System.out.println("admin post 요청 확인");

        HttpSession session = request.getSession();
        String msg = null;

        try {
            AdminDto rslt = adminService.login(adminDto);
            System.out.println("rslt => " + rslt);

            if (rslt != null) {
                System.out.println("Admin Login");
                session.setAttribute("adminId", adminDto.getAdmin_id());
                session.setAttribute("adminNickName", adminDto.getAdmin_nickname());
                System.out.println("session => " + session);

                msg = "ok";
            }else{
                session.setAttribute("adminId", null);
                System.out.println("session => " + session);
                msg = "fail";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return msg;

    }
    @GetMapping("/admin/user")
    public String adminuser() throws Exception{
        return "admin/adminuser";
    }
    @GetMapping("/admin/register")
    public String adminuserregister() throws Exception{
        return "admin/adminuserregister";
    }
    @GetMapping("/admin/delete")
    public String adminuserdelete() throws Exception{
        return "admin/adminuserdelete";
    }
    @GetMapping("/admin/agency")
    public String adminagency() throws Exception{
        return "admin/adminagency";
    }
    @GetMapping("/admin/product")
    public String adminproduct() throws Exception{
        return "admin/adminproduct";
    }
    @GetMapping("/admin/notice")
    public String adminnotice() throws Exception{
        return "admin/adminnotice";
    }
    @GetMapping("/admin/inquiry")
    public String admininquiry() throws Exception{
        return "admin/admininquiry";
    }
    @GetMapping("/admin/coupon")
    public String admincoupon() throws Exception{
        return "admin/admincoupon";
    }
    @GetMapping("/admin/stactics")
    public String adminstactics() throws Exception{
        return "admin/adminstactics";
    }
    @GetMapping("/admin/setting")
    public String adminsetting() throws Exception{
        return "admin/adminsetting";
    }
}