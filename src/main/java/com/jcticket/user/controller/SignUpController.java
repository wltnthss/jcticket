package com.jcticket.user.controller;

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
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
    private JavaMailSender mailSender;

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
    // 닉네임 중복체크 시작

    //생년월일 검사 시작. 1900년생 이후인지, 날짜 형식에 맞는지
    @ResponseBody
    @PostMapping("/chk_birth")
    public boolean chkBirth(@RequestParam String user_birth){
        System.out.println("user_birth = " + user_birth);

        try{
            //검증할 날짜 포맷 설정
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            //false일경우 처리시 입력한 값이 잘못된 형식일 시 오류가 발생
            sdf.setLenient(false);

            //user_birth를 날짜로 parsing
            Date formatDate = sdf.parse(user_birth);

            // 입력한 생년월일이 1900년 1월 1일 이후인지 확인
            Calendar minDate = Calendar.getInstance();
            minDate.set(1900, Calendar.JANUARY, 1);

            if(formatDate.after(minDate.getTime())) {
                return true; // 유효한 범위 내에 있음
            }else{
                return false; // 범위를 벗어남
            }
        }catch (Exception e){
            return false;
        }
    }
    //생년월일 검사 끝.

    //회원가입 버튼 눌렀을 때.insert
    @PostMapping("/signup")
    public String insertUser(UserDto userDto, TermsDto termsDto, Model m, HttpServletRequest request,
                             HttpServletResponse response) throws Exception{
        System.out.println("userDto = " + userDto);
        System.out.println("userDto.getUser_password() = " + userDto.getUser_password());

        // DB 저장 전 비밀번호 암호화
        String hashPassword = BCrypt.hashpw(userDto.getUser_password(), BCrypt.gensalt());
        userDto.setUser_password(hashPassword);

        try{
            //user table insert 실패시 예외 발생시킴
            if(userService.signup(userDto)!=1){
                throw new Exception("insert failed");
            }

            //유저_약관 table insert 실패시 예외 발생시킴
            if(termsService.insertUserTerm(termsDto)!=1){
                throw new Exception("insert terms failed");
            }
            System.out.println("회원가입 성공");
            return "index";

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("회원가입 실패");
            m.addAttribute(userDto);
            return "redirect:/signup";
        }
    }
}


