package com.jcticket.signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
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


    @GetMapping("")
    public String signUpForm(){
        return "signup/signup";
    };

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

}


