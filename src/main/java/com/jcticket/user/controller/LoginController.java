package com.jcticket.user.controller;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.jcticket.common.CommonValidateHandling;
import com.jcticket.user.dto.UserDto;
import com.jcticket.user.dto.UserValidLoginDto;
import com.jcticket.user.service.UserService;
import com.jcticket.user.sns.NaverLoginBO;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.*;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

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
public class LoginController {

    private NaverLoginBO naverLoginBO;
    private String apiResult = null;

    @Autowired
    private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
        this.naverLoginBO = naverLoginBO;
    }

    @Autowired
    UserService userService;

    @GetMapping("/logout")
    public String logout(HttpSession session){
        //세션을 지우고
        session.invalidate();
        //홈으로
        return "index";
    }

    @GetMapping("/login")
    public String loginForm(Model m, HttpSession session){
        String naverAuthurl = naverLoginBO.getAuthorizationUrl(session);
        System.out.println("naverAuthurl = " + naverAuthurl);
        m.addAttribute("naverUrl",naverAuthurl);

        return "login/login";}

    @PostMapping("/login")
    public String login(@Valid UserValidLoginDto userValidLoginDto, BindingResult bindingResult, boolean rememberId, Model m,
                        HttpServletRequest request, HttpServletResponse response, RedirectAttributes rattr){

        String user_id = userValidLoginDto.getUser_id();
        String user_password = userValidLoginDto.getUser_password();

        //valid 유효성검사 시작
        if(bindingResult.hasErrors()){

            // 회원가입 실패시 입력 데이터 값 유지하기 위함
            m.addAttribute("userValidLoginDto", userValidLoginDto);

            CommonValidateHandling cvh = new CommonValidateHandling();

            // Map 타입 { valid_user_id, "오류 메세지" } 리턴
            Map<String, String> validatorRslt = cvh.validateHandling(bindingResult);

            for (String key: validatorRslt.keySet()) {
                rattr.addFlashAttribute(key, validatorRslt.get(key));
            }
            return "redirect:/login";
        }
        //valid 유효성검사 끝

        try {
//        아이디 비번 틀리면 로그인 안되게
            if (!userService.loginCheck(user_id, user_password)) {
                m.addAttribute("user_id", user_id);
                m.addAttribute("user_password", user_password);
                return "login/login";
            }

            //탈퇴회원이면 로그인 안되게
            if (userService.isUserRetired(user_id)) {
                m.addAttribute("retireYN", "Y");
                return "login/login";
            }

            //방문횟수 증가
            userService.increaseLoginCnt(user_id);

        }catch (Exception e){
            e.printStackTrace();
        }
        //로그인 성공시 세션 부여
        HttpSession session = request.getSession();
        session.setAttribute("sessionId", user_id);


        //아이디 저장
        rememberId(user_id, rememberId, response);

        return "index";
    }

    //네이버 로그인 성공시 callback호출 메소드
     @RequestMapping(value = "/login/naverCb", method = { RequestMethod.GET, RequestMethod.POST })
     public String callback(Model m, @RequestParam String code, @RequestParam String state, HttpSession session) throws Exception {
        System.out.println("여기는 callback");

        OAuth2AccessToken oauthToken;
        oauthToken = naverLoginBO.getAccessToken(session, code, state);

        //1. 로그인 사용자 정보를 읽어온다.
          apiResult = naverLoginBO.getUserProfile(oauthToken);  //String형식의 json데이터
          /** apiResult json 구조
          {"resultcode":"00",
          "message":"success",
          "response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
          **/

         // 2. String형식인 apiResult를 json형태로 바꿈
          JSONParser parser = new JSONParser();
          Object obj = parser.parse(apiResult);
          JSONObject jsonObj = (JSONObject) obj;

         // 3. 데이터 파싱
         // Top레벨 단계 _response 파싱
          JSONObject response_obj = (JSONObject)jsonObj.get("response");

         System.out.println("response_obj = " + response_obj);

         //------------ response의 값 파싱 후 인서트 ---------

         // 아이디
         String id = (String)response_obj.get("email");
         int idx =  id.indexOf("@");
         String n_id = id.substring(0,idx);
         System.out.println("n_id = " + n_id);
         System.out.println("n_id.length() = " + n_id.length());
         System.out.println("(userService.getUser(n_id)) = " + (userService.getUser(n_id)));
         try {
             if (userService.getUser(n_id)!=null) {
                 session.setAttribute("sessionId",n_id); //세션 생성/
                 m.addAttribute("result", apiResult);
                 return "redirect:/";
             }
         }catch (Exception e){
             e.printStackTrace();
         }

         m.addAttribute("n_id", n_id);
         // 이름
         String n_name = (String) response_obj.get("name");
         m.addAttribute("n_name", n_name);
         // 이메일
         String n_email = (String) response_obj.get("email");
         m.addAttribute("n_email", n_email);
         // 전화번호
         String n_tel = (String) response_obj.get("mobile");
         m.addAttribute("n_tel", n_tel);
         // 생년월일
         String n_birth = (String) response_obj.get("birthyear") + ((String) response_obj.get("birthday")).replace("-", "");
         m.addAttribute("n_birth", n_birth);
         //성별
         String n_gender = (String) response_obj.get("gender");
         m.addAttribute("n_gender", n_gender);

         return "signup/signupSNS";
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