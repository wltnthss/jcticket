package com.jcticket.enroll.controller;
import com.jcticket.enroll.dto.EnrollDto;
import com.jcticket.enroll.service.EnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * packageName    : com.jcticket.mypage.controller
 * fileName       : mypageController
 * author         : JJS
 * date           : 2024-01-31
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-31        JJS       최초 생성
 */
@Controller
@RequestMapping("/enroll")
public class EnrollController {
    @Autowired
    EnrollService enrollService;

//    private final EnrollService enrollService;
//
//    public EnrollController(EnrollService enrollService) {
//        this.enrollService = enrollService;
//    }

    @PostMapping("/enroll")
    public String submitEnrollForm(EnrollDto enrollDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        try {
            if (bindingResult.hasErrors()) {
                // 유효성 검사 오류가 있는 경우
                return "redirect:/enroll/form"; // 입력 폼 페이지로 리다이렉트
            }

            // EnrollDto를 DB에 저장
            enrollService.insertEnroll(enrollDto);

            // 저장이 성공한 걸  알리고 대시보드로 리다이렉트
            redirectAttributes.addFlashAttribute("successMessage", "신규 등록이 성공적으로 신청되었습니다.");
            return "redirect:/agency/dashboard";
        } catch (Exception e) {
            // 저장이 실패한 경우
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage", "신규 등록 신청에 실패했습니다.");
            return "redirect:/enroll/form"; // 입력 폼 페이지로 리다이렉트
        }
    }


//    @PostMapping("/signup")
//    public String insertUser(@Valid UserDto userDto, BindingResult bindingResult, TermsDto termsDto, Model m, RedirectAttributes rattr) throws Exception{
//
//        if(bindingResult.hasErrors()){
//
//            // 회원가입 실패시 입력 데이터 값 유지하기 위함
//            m.addAttribute("userDto", userDto);
//
//            CommonValidateHandling cvh = new CommonValidateHandling();
//
//            // Map 타입 { valid_user_id, "오류 메세지" } 리턴
//            Map<String, String> validatorRslt = cvh.validateHandling(bindingResult);
//
//            for (String key: validatorRslt.keySet()) {
//                rattr.addFlashAttribute(key, validatorRslt.get(key));
//            }
//
//            return "redirect:/signup";
//        }
//
//        try{
//            // DB 저장 전 비밀번호 암호화
//            String hashPassword = BCrypt.hashpw(userDto.getUser_password(), BCrypt.gensalt());
//            userDto.setUser_password(hashPassword);
//
//            //user table insert 실패시 예외 발생시킴
//            if(userService.signup(userDto)!=1){
//                throw new Exception("insert failed");
//            }
//
//            //유저_약관 table insert 실패시 예외 발생시킴
//            if(termsService.insertUserTerm(termsDto)!=1){
//                throw new Exception("insert terms failed");
//            }
//            System.out.println("회원가입 성공");
//            return "index";
//
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println("회원가입 실패");
//            m.addAttribute(userDto);
//            return "redirect:/signup";
//        }
//    }
//}

}


