package com.jcticket.login.controller;

import com.jcticket.user.dao.UserDao;
import com.jcticket.agency.dao.AgencyDao;
import com.jcticket.user.dto.UserDto;
import com.jcticket.agency.dto.AgencyDto;
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
    UserDao userDao;

    @Autowired
    AgencyDao agencyDao;


    @GetMapping("/login")
    public String loginForm(){return "login";}

    @PostMapping("/login")
    public String login(String user_id, String user_pwd, boolean rememberId, Model m,
                        HttpServletRequest request, HttpServletResponse response) throws Exception {

        if(!loginCheck(user_id,user_pwd)){
            m.addAttribute("user_id",user_id);
            m.addAttribute("user_pwd",user_pwd);

            if(!Objects.equals(user_id, "")&&!Objects.equals(user_pwd, "")){
                UserDto userDto = null;
                userDto = userDao.selectUser(user_id);
                m.addAttribute("boardDtoPWD",userDto.getUser_password());
                System.out.println("userDto = " + userDto);
            }

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


//    -------------------------------------------------------------------------------------------
@PostMapping("/agencyLogin") // 기획사 로그인 메서드
public String agencyLogin(AgencyDto agencyDto, boolean rememberId, Model m,
                          HttpServletRequest request, HttpServletResponse response) throws Exception {
    if (!agencyLoginCheck(agencyDto)) {
        m.addAttribute("agencyDto", agencyDto);

        if (!Objects.equals(agencyDto.getAgency_id(), "") && !Objects.equals(agencyDto.getAgency_password(), "")) {
            // DB에서 기획사 로그인 가져옴
            AgencyDto fetchedAgency = agencyDao.selectAgency(agencyDto.getAgency_id());
            m.addAttribute("agencyDtoPWD", fetchedAgency.getAgency_password());
            System.out.println("fetchedAgency = " + fetchedAgency);
        }

        return "redirect:/login";
    }//false 반환시 로그인페이지로 리다이렉트

    HttpSession session = request.getSession();
    session.setAttribute("agency_id", agencyDto.getAgency_id());
//true를 반환시 index 페이지로
    return "index";
}

    private boolean agencyLoginCheck(AgencyDto agencyDto) {//존재체크
        AgencyDto fetchedAgency = null;
        System.out.println("agency_id = " + agencyDto.getAgency_id());
        System.out.println("agency_pwd = " + agencyDto.getAgency_password());
        try {
            fetchedAgency = agencyDao.selectAgency(agencyDto.getAgency_id());
            System.out.println(fetchedAgency);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fetchedAgency != null && fetchedAgency.getAgency_password().equals(agencyDto.getAgency_password());
    }//기획사가 존재하고, 비번이 일치 하는지
}
