package com.jcticket.signup.controller;

import com.jcticket.signup.dto.SignupDto;
import com.jcticket.signup.service.SignupService;
import com.jcticket.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Properties;

/**
 * packageName    : com.jcticket.signup
 * fileName       : SignUpController
 * author         : jinwook Song
 * date           : 2024-02-04
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-04        jinwook Song       최초 생성
 */
@RequestMapping("/signup")
@Controller
public class SignUpController {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    SignupService signupService;

//회원가입 페이지 이동
    @GetMapping("")
    public String signUpForm(){
        return "signup/signup";
    };

//    이메일 인증번호 발송 시작
    @ResponseBody
    @GetMapping("/emailChk")
    public String emailChk(@RequestParam("totalEmail") String totalEmail) throws MessagingException {
        System.out.println("totalEmail = " + totalEmail);

        //난수6자리 인증번호
        int authNum = (int)(Math.random()*(999999-100000+1)+100000);

        String from = "wlsdnr1233@naver.com"; // 보내는사람
        String to = totalEmail; // 받는사람
        String title = "회원가입시 필요한 인증번호 입니다."; //메일 제목
        String content = "[인증번호] "+authNum+" 입니다. <br/> 인증번호 확인란에 기입해주세요."; // 메일 내용

        String num = "";
        try {
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "utf-8");

            mailHelper.setFrom(from);
            mailHelper.setTo(to);
            mailHelper.setSubject(title);
            mailHelper.setText(content, true);

            mailSender.send(mail);
            num = Integer.toString(authNum);
        }catch (Exception e){
            e.printStackTrace();
            num="error";
        }
        return num;
    }
    //    이메일 인증번호 발송 시작


    //    아이디 중복체크 시작
    @ResponseBody
    @PostMapping("/chk_id_dupl")
    public boolean chkIdDupl(@RequestParam String user_id){
        System.out.println("user_id = " + user_id);

        try {
            return signupService.chkIdDupl(user_id) == 1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    //    아이디 중복체크 끝


    // 닉네임 중복체크 시작
    @ResponseBody
    @PostMapping("/chk_nickname_dupl")
    public boolean chkNicknameDupl(@RequestParam String user_nickname){
        System.out.println("user_nickname = " + user_nickname);

        try{
            return signupService.chkNickNameDupl(user_nickname) ==1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    // 닉네임 중복체크 시작


    //회원가입 버튼 눌렀을 때.
    @PostMapping("/signup")
    public String insertUser(SignupDto signupDto, Model m, HttpServletRequest request,
                             HttpServletResponse response) throws Exception{
        System.out.println("signupDto = " + signupDto);

        try{
            if(signupService.insertUser(signupDto)!=1){
                throw new Exception("insert failed");
            }

            System.out.println("회원가입 성공");
            return "signupSuccess";

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("회원가입 실패");
            m.addAttribute(signupDto);
            return "redirect:/signup";
        }
    }


//    @GetMapping("signupSuccess")

}


