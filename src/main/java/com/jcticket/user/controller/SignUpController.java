package com.jcticket.user.controller;

import com.jcticket.common.CommonValidateHandling;
import com.jcticket.user.dto.TermsDto;
import com.jcticket.user.dto.UserDto;
import com.jcticket.user.service.UserService;
import com.jcticket.user.service.TermsService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * packageName    : com.jcticket.signup
 * fileName       : SignUpController
 * author         : jinwook Song
 * date           : 2024-02-04
 * description    : SignupController
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-04        jinwook Song       최초 생성
 */
@RequestMapping("/signup")
@Controller
public class SignUpController {


    @Autowired
    UserService userService;

    @Autowired
    TermsService termsService;

//회원가입 페이지 이동
    @GetMapping("")
    public String signUpForm(){
        return "signup/signup";
    };

//    이메일 인증번호 발송 시작
    @ResponseBody
    @GetMapping("/emailChk")
    public String emailChk(@RequestParam("totalEmail") String totalEmail) throws Exception {
        System.out.println("totalEmail = " + totalEmail);
        String num = "";
        int authNum = (int)(Math.random()*(999999-100000+1)+100000);

        //중복된 이메일이 존재하면 num에 "duplicate" 대입
        if(userService.chkEmailDupl(totalEmail) == 1){
            num = "duplicate";
            return num;
        }
        //난수6자리 인증번호

        try {
            //인증번호 메일 발송
            userService.sendEmail(totalEmail,authNum);

            num = Integer.toString(authNum);
        }catch (Exception e){
            e.printStackTrace();
            //올바르지 않은 형태의 이메일이 존재하면 num에 "error" 대입
            num="error";
        }
        return num;
    }
    //    이메일 인증번호 발송 끝


    //    아이디 중복체크 시작
    @ResponseBody
    @PostMapping("/chk_id_dupl")
    public boolean chkIdDupl(@RequestParam String user_id){
        System.out.println("user_id = " + user_id);

        try {
            //user table에 같은 아이디 있는지 카운트. 1이면 중복(true) 0이면 중복x(false)
            return userService.chkIdDupl(user_id) == 1;
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
            //user table에 같은 닉네임 있는지 카운트. 1이면 중복(true) 0이면 중복x(false)
            return userService.chkNickNameDupl(user_nickname) ==1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    // 닉네임 중복체크 끝

    //생년월일 검사 시작. 1900년생 이후인지, 날짜 형식에 맞는지
    @ResponseBody
    @PostMapping("/chk_birth")
    public boolean chkBirth(@RequestParam String user_birth){
        System.out.println("user_birth = " + user_birth);

        try{
            return userService.chkBirth(user_birth);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    //생년월일 검사 끝.

    //회원가입 버튼 눌렀을 때.insert
    @PostMapping("/signup")
    public String insertUser(@Valid UserDto userDto, BindingResult bindingResult, TermsDto termsDto, Model m) throws Exception{

        if(bindingResult.hasErrors()){

            // 회원가입 실패시 입력 데이터 값 유지하기 위함
            m.addAttribute("userDto", userDto);

            CommonValidateHandling cvh = new CommonValidateHandling();

            // Map 타입 { valid_user_id, "오류 메세지" } 리턴
            Map<String, String> validatorRslt = cvh.validateHandling(bindingResult);

            for (String key: validatorRslt.keySet()) {
                m.addAttribute(key, validatorRslt.get(key));
            }

            return "signup/signup";
        }

        try{
            // DB 저장 전 비밀번호 암호화
            String hashPassword = BCrypt.hashpw(userDto.getUser_password(), BCrypt.gensalt());
            userDto.setUser_password(hashPassword);

            //user table insert 실패시 예외 발생시킴
            if(userService.signup(userDto)!=1){
                throw new Exception("insert failed");
            }

            //유저_약관 table insert 실패시 예외 발생시킴
            if(termsService.insertUserTerm(termsDto)!=1){
                throw new Exception("insert terms failed");
            }
            System.out.println("회원가입 성공");
            return "signup/signupSuccess";

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("회원가입 실패");
            m.addAttribute("userDto",userDto);

            return "index";
        }
    }

    @PostMapping("/signupSNS")
    public String signupSNS_NAVER(UserDto userDto, TermsDto termsDto, Model m){
        try {

            System.out.println("userDto = " + userDto);

            if (userService.signupSNS(userDto) != 1) {
                throw new Exception("signupSNS failed");
            }

            if(termsService.insertUserTerm(termsDto)!=1){
                throw new Exception("insert terms failed");
            }

            System.out.println("회원가입 성공");
            return "signup/signupSuccess";

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("회원가입 실패");
            m.addAttribute("userDto",userDto);
            return "signup/signupSNS";
        }
    }
}


