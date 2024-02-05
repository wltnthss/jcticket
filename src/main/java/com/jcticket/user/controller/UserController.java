package com.jcticket.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * packageName    : com.jcticket.user.controller
 * fileName       : userController
 * author         : jinwook Song
 * date           : 2024-01-29
 * description    : 로그인/회원가입 컨트롤러...
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-29        jinwook Song       최초 생성
 */
@Controller
public class UserController {
    @GetMapping("/index")
    public String index(){

        return "index";
    }


}
