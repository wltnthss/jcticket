package com.jcticket.login.controller;

import com.jcticket.user.dao.UserDao;
import com.jcticket.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.*;
import java.net.URLEncoder;

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
    UserDao userDao;

    @GetMapping("/login")
    public String loginForm(){return "login";}

    @PostMapping("/login")
    public String login(String user_id, String user_pwd, boolean rememberId,
                        HttpServletRequest request, HttpServletResponse response)throws Exception{

        String referer = request.getHeader("Referer");
        System.out.println("referer = " + referer);
        if(!loginCheck(user_id,user_pwd)){
            String msg = URLEncoder.encode("아이디 또는 비밀번호가 일치하지 않습니다.","utf-8");
            System.out.println("실패");
            return"redirect:/login";
        }

        HttpSession session =request.getSession();
        session.setAttribute("user_id",user_id);

        System.out.println("rememberId = " + rememberId);

        //아이디 저장 기능 시작
        if(rememberId){
            Cookie cookie = new Cookie("user_id",user_id);
            response.addCookie(cookie);
            System.out.println("cookie = " + cookie.getValue());
        }
        else{
            Cookie cookie = new Cookie("user_id",user_id);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            System.out.println("cookie = " + cookie.getValue());
        }
        //아이디 저장 기능 끝

        return "index";
    }


    //회원가입 되어있는(DB에 있는) 아이디 비밀번호 일치확인
    private boolean loginCheck(String user_id, String user_pwd){
        UserDto userDto = null;
        System.out.println("user_id = " + user_id);
        System.out.println("user_pwd = " + user_pwd);
        try {
            userDto = userDao.selectUser(user_id);
            System.out.println(userDto);
        } catch(Exception e){
            e.printStackTrace();

        }

        return userDto!=null && userDto.getUser_password().equals(user_pwd);
    }
}