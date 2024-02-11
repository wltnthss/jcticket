package com.jcticket.user.controller;

import com.jcticket.user.dao.UserDao;
import com.jcticket.agency.dao.AgencyDao;
import com.jcticket.user.dto.UserDto;
import com.jcticket.agency.dto.AgencyDto;
import com.jcticket.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.*;
import java.net.URLEncoder;
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


    @GetMapping("/login")
    public String loginForm(){return "login/login";}

    @PostMapping("/login")
    public String login(String user_id, String user_pwd, boolean rememberId, Model m,
                        HttpServletRequest request, HttpServletResponse response) throws Exception {

        if (!loginCheck(user_id, user_pwd)) {
            m.addAttribute("user_id", user_id);
            m.addAttribute("user_pwd", user_pwd);

            if (!Objects.equals(user_id, "") && !Objects.equals(user_pwd, "")) {
                UserDto userDto = null;
                userDto = loginService.loginUser(user_id);
                m.addAttribute("userDto",userDto);
                System.out.println("userDto = " + userDto);
            }

            return "redirect:/login";
        }

        HttpSession session = request.getSession();
        session.setAttribute("user_id", user_id);

        System.out.println("rememberId = " + rememberId);

        //아이디 저장 기능 시작
        if (rememberId) {
            Cookie cookie = new Cookie("user_id", user_id);
            response.addCookie(cookie);
            System.out.println("cookie = " + cookie.getValue());
        } else {
            Cookie cookie = new Cookie("user_id", user_id);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            System.out.println("cookie = " + cookie.getValue());
        }
        //아이디 저장 기능 끝

        loginService.loginCnt(user_id);

        return "index";
    }


    //회원가입 되어있는(DB에 있는) 아이디 비밀번호 일치확인git
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



