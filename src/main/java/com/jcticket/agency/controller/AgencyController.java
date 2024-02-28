package com.jcticket.agency.controller;

import com.jcticket.agency.dto.PosterDto;
import com.jcticket.agency.service.AgencyService;
import com.jcticket.notice.dto.NoticeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

import com.jcticket.agency.dto.EnrollDto;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * packageName    : com.jcticket.agency.controller
 * fileName       : AgencyController
 * author         : {sana}
 * date           : 2024-02-02
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-02        {sana}       최초 생성
 */



@Controller
@RequestMapping("/agency")//이 클래스의 모든 메서드는 /agency 경로에 매핑

public class AgencyController {

//    @Autowired
//    private AgencyService agencyService;//AgencyService 인터페이스를 사용하기 위해 의존성을 주입 받음

    private final AgencyService agencyService;

    @Autowired
    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }


    //RequestMapping("/agency")을 해 줬기 떄문에 GetMapping("/processLogin 만 적어도
    @GetMapping("/processLogin")// /agency/processLogin 경로로 POST 요청을 보내면, 이 메서드가 실행되어 로그인을 처리함
    public String showAgencyLoginForm() {

        return "viewdetail/login"; //로그인 폼을 보여주는 페이지의 경로


    }

//    @RequestMapping(value = "/agencyenroll/insert_data", method = RequestMethod.POST)
//    public String insert_data(@ModelAttribute agencyEnroll agencyenroll){
//        System.out.print(agencyenroll.toString());
//        return "redirect:/agency/agencyenroll";
//    }

    //--------------실패시 얼럿창, 서비스단에서-------------->
//@PostMapping("/processLogin")
//public String processAgencyLogin(String agency_id, String agency_pwd, boolean rememberId, Model m,
//                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//    if (!agencyLoginCheck(agency_id, agency_pwd)) {
//        // 로그인이 실패한 경우, 로그인 폼으로 리다이렉션하되 파라미터를 전달하지 않도록 하여서 입력값을 url에 보여주지 않음
//        return "redirect:/login";
//    }
//
//        HttpSession session = request.getSession();//로그인이 성공하면 세션에 기관 ID를 저장
//        session.setAttribute("agency_id", agency_id);
//
//        System.out.println("rememberId = " + rememberId);
//
//
//        return "/agency/agencydashboard";//로그인 성공 시
//    }
    //-------------------------------------------------------------------------------
    @PostMapping("/processLogin")
    public String processAgencyLogin(String agency_id, String agency_pwd, boolean rememberId, Model model,
                                     HttpServletRequest request) {
        try {
            if (agencyService.processAgencyLogin(agency_id, agency_pwd)) {
                HttpSession session = request.getSession();
                session.setAttribute("agency_id", agency_id);
                return "/agency/agencydashboard"; // 성공 시 대시보드 페이지로 이동
            } else {
                model.addAttribute("loginError", true);
                return "redirect:/login"; // 실패 시 로그인 페이지를 다시 표시
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error"; // 예외 발생 시 로그인 ? 에러? 어디로 보내지~~
        }
    }


//    @PostMapping("/submitForm")
//    public String submitForm(@ModelAttribute("enrollDto") EnrollDto enrollDto) {
//        agencyService.saveFormData(enrollDto);
//        return "redirect:/success"; // 성공 페이지로 리다이렉트
//    }


    @GetMapping("/dashboard")//홈
    public String showAgencyDashboard(Model model) {
        model.addAttribute("dashboardPage", "agency/agencydashboard");
        return "agency/agencydashboard";
    }

    @GetMapping("/enroll")//신청서페이지
    public String agencyEnroll() {
        try {
            return "agency/agencyenroll";
        } catch (Exception e) {
            return "error"; //존재하지는 않지만 우선 에러 페이지로 이동
        }
    }


    @PostMapping("/enroll")//
    public ResponseEntity<String> enroll(HttpServletRequest request, EnrollDto enrollDto, PosterDto posterDto) {
        try {
            // AgencyService를 통해서 처리
            agencyService.insertEnroll(enrollDto, posterDto);

            //agencyService.processEnrollment(enrollDto);
            return ResponseEntity.ok("Enrollment process successful.");//성공 시
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred during enrollment process.");
        }
    }




//        try {
//            List<EnrollDto> enrollDtoList = agencyService.getEnrollDtoList(page, itemsPerPage);
//            model.addAttribute("enrollDtoList", enrollDtoList);
//            return "agency/agencysale"; //


    @GetMapping("/sale-page")
    public String getAgencyList(@RequestParam(defaultValue = "1") int page,
                                @RequestParam(defaultValue = "10") int itemsPerPage,
                                Model model) {
        try {
            List<EnrollDto> enrollDtoList = agencyService.getEnrollDtoList(page, itemsPerPage);
            model.addAttribute("list", enrollDtoList);
            return "agency/agencysale"; //
        } catch (Exception e) {
            e.printStackTrace();
            // 예외
            return "error";
        }
    }

    @GetMapping("/sale")//판매중
    public String agencysale() {
        try {
            return "agency/agencysale";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/rollout")//신규,예정
    public String agencyrollout() {
        try {
            return "agency/agencyrollout";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/soldout")//판매종료
    public String agencysoldout() {
        try {
            return "agency/agencysoldout";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/productlist")//상품등록내역전체
    public  String agencyproductlist(){
        try{
            return "agency/agencyproductlist";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/setting")//사용자정보 에 넣을게.. 있나?
    public String agencysetting() {
        try {
            return "agency/agencysetting";
        } catch (Exception e) {
            return "error";
        }
    }

//    @GetMapping("/agency/sale")
//    public String agencysale(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
//                              @RequestParam(value = "sort", defaultValue = "seq")  String sort,
//                              @RequestParam(value = "keyword", required = false)  String keyword) throws Exception{
//
//        // page 값이 없이 들어오면다면 default 값 1 설정
//        System.out.println("page => " + page);
//        // 정렬값
//        System.out.println("sort => " + sort) ;
//        // 검색한 keyword
//        System.out.println("keyword => " + keyword);
//
//        try {
//
//            List<EnrollDto> pagingList = null;
//
//            // page, sort, keyword 받아온 값 동적으로 list 생성
//            pagingList = AgencyService.pagingList(page, sort, keyword);
//            // pageDto에 설정한 maxPage, startPage, endPage 사용하기 위함
//            com.jcticket.agency.dto.PageDto pageDto = agencyService.pagingParam(page, keyword);
//            int noticeListCnt = agencyService.count(keyword);
//
//            model.addAttribute("list", pagingList);
//            model.addAttribute("paging", pageDto);
//            model.addAttribute("noticeListCnt", noticeListCnt);
//
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return "admin/adminnotice";
//    }
//




}//끝

//    private boolean agencyLoginCheck (String agency_id, String agency_pwd) {
//        AgencyDto agencyDto = null;
//        System.out.println("agency_id = " + agency_id);
//        System.out.println("agency_pwd = " + agency_pwd);
//        try {
//            agencyDto = agencyService.selectAgency(agency_id);//호출하여 해당  정보를 가져옴. 가져온 정보와 입력된 비밀번호를 비교하여 로그인 여부를 확인
//            System.out.println(agencyDto);//로그인이 성공하면 AgencyDto 객체를 반환
//        } catch (Exception e) {
//            e.printStackTrace();//예외가 발생하면 스택 트레이스를 출력하고, 로그인 실패를 의미하는 null을 반환
//        }
//
//        return agencyDto != null && agencyDto.getAgency_password().equals(agency_pwd);
//
//
//    }


//    @PostMapping("/processEnroll")
//    public String processAgencyEnroll(@ModelAttribute AgencyEnrollmentForm enrollmentForm) {
//        try {
//            // AgencyEnrollmentForm 데이터를 Service 계층으로 전달하여 처리
//            agencyService.processEnrollment(enrollmentForm);
//        } catch (Exception e) {
//            e.printStackTrace(); // 오류 발생 시 스택 트레이스 출력
//            // 오류 처리 로직 추가 가능
//            return "error"; // 예시: 오류 페이지로 리다이렉트
//        }
//
//        // 처리 후 이동할 페이지 지정 (예: 등록 완료 후 메인 대시보드 페이지)
//        return "redirect:/agency/dashboard";
//    }


        // 기획사 로그인 체크
//    private boolean loginCheck(String agencyId, String agencyPwd) {
//        try {
//            // 기획사 정보를 데이터베이스에서 가져오는 로직
//            AgencyDto agencyDto = agencyDao.selectAgency(agencyId);
//
//            // 기획사 정보가 존재하고 비밀번호가 일치하는지 확인
//            if (agencyDto != null && agencyDto.getAgency_password().equals(agencyPwd)) {
//                return true; // 로그인 성공
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false; // 로그인 실패
//    }
