package com.jcticket.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * packageName    : com.jcticket.login
 * fileName       : loginController
 * author         : jinwook Song
 * date           : 2024-02-01
 * description    : 로그인 컨트롤러
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-01        jinwook Song       최초 생성
 */

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("")
    public String Login(){

        return "login";
    }
}
