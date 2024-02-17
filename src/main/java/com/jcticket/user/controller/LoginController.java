package com.jcticket.user.controller;

import com.jcticket.user.dto.UserDto;
import com.jcticket.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.*;

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
//@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserService userService;

    String retireYN = "";

    @GetMapping("/logout")
    public String logout(HttpSession session){
        //세션을 지우고
        session.invalidate();
        //홈으로
        return "index";
    }

    @GetMapping("/login")
    public String loginForm(){return "login/login";}

    @PostMapping("/login")
    public String login(String user_id, String user_password, boolean rememberId, Model m,
                        HttpServletRequest request, HttpServletResponse response) throws Exception {

        //아이디 비번 틀리면 로그인 안되게
        if (!userService.loginCheck(user_id,user_password)){
            //유효성 검사 때매 넘김
            m.addAttribute("user_id", user_id);
            m.addAttribute("user_password", user_password);
            return "redirect:/login";
        }

        //탈퇴회원이면 로그인 안되게
        if (userService.isUserRetired(user_id)) {
            m.addAttribute("retireYN", "Y");
            return "redirect:/login";
        }

        //방문횟수 증가
        userService.increaseLoginCnt(user_id);

        HttpSession session = request.getSession();
        session.setAttribute("user_id", user_id);

        //아이디 저장
        rememberId(user_id, rememberId, response);

        return "index";
    }


    private static void rememberId(String user_id, boolean rememberId, HttpServletResponse response) {
        // rememberId가 true이면(아이디 저장 체크박스 체크되어있으면)
        if (rememberId) {
//            쿠키 생성
            Cookie cookie = new Cookie("user_id", user_id);
            response.addCookie(cookie);
            System.out.println("cookie = " + cookie.getValue());
        //remember Id가 false이면
        } else {
           //쿠키 삭제
            Cookie cookie = new Cookie("user_id", user_id);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            System.out.println("cookie = " + cookie.getValue());
        }
    }
}