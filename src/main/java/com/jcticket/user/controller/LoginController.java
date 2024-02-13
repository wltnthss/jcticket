package com.jcticket.user.controller;

import com.jcticket.user.dto.UserDto;
import com.jcticket.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.*;
import java.util.Objects;

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
    LoginService loginService;

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
    public String login(String user_id, String user_pwd, boolean rememberId, Model m,
                        HttpServletRequest request, HttpServletResponse response) throws Exception {

        if (!loginCheck(user_id, user_pwd)) {
            //유효성 검사 때매 넘김
            m.addAttribute("user_id", user_id);
            m.addAttribute("user_pwd", user_pwd);

            return "redirect:/login";
        }

        HttpSession session = request.getSession();
        session.setAttribute("user_id", user_id);

        //아이디 저장 기능 시작
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
        //아이디 저장 기능 끝

        //방문횟수 1 추가
        loginService.loginCnt(user_id);

        return "index";
    }


    //회원가입 되어있는(DB에 있는) 아이디 비밀번호 일치확인
    private boolean loginCheck(String user_id, String user_pwd) {
        UserDto userDto = null;
        System.out.println("user_id = " + user_id);
        System.out.println("user_pwd = " + user_pwd);
        try {
            userDto = loginService.loginUser(user_id);
            System.out.println(userDto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userDto != null && userDto.getUser_password().equals(user_pwd);
    }
}



