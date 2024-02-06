package com.jcticket.admin.controller;

import com.jcticket.admin.dto.AdminDto;
import com.jcticket.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @GetMapping("/admin/dashboard")
    public String admindashboard() throws Exception{
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
}