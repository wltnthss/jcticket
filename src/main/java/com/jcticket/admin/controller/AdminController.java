package com.jcticket.admin.controller;

import com.jcticket.admin.dto.AdminDto;
import com.jcticket.admin.dto.AdminValidLoginDto;
import com.jcticket.admin.dto.CouponDto;
import com.jcticket.notice.dto.NoticeValidDto;
import com.jcticket.admin.dto.PageDto;
import com.jcticket.admin.service.AdminService;
import com.jcticket.agency.dto.AgencyDto;
import com.jcticket.common.CommonValidateHandling;
import com.jcticket.notice.dto.NoticeDto;
import com.jcticket.notice.service.NoticeService;
import com.jcticket.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * packageName :  com.jcticket.admin.controller
 * fileName : AdminController
 * author :  jisoo Son
 * date : 2024-02-05
 * description : 관리자 Controller
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05             jisoo Son             최초 생성
 */
@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    NoticeService noticeService;

    // /admin url 입력시 loginform 이동
    @GetMapping("/admin")
    public String admin() throws Exception{
        return "admin/adminloginform";
    }


    // 관리자 로그아웃
    @GetMapping("/admin/logout")
    public String adminLogout(HttpServletRequest request) throws Exception{

        HttpSession session = request.getSession();

        // 로그아웃 후 세션 삭제
        session.invalidate();

        return "redirect:/admin";
    }

    // 관리자 로그인시 대시보드 이동
    @GetMapping("/admin/dashboard")
    public String adminDashBoard(Model model) throws Exception{

        try {
            List<UserDto> userLists = adminService.userstatics();

            model.addAttribute("userLists", userLists);
        } catch (Exception e){
            e.printStackTrace();
        }

        return "admin/admindashboard";
    }

    // 관리자 로그인
    @PostMapping("/admin")
    private String login(Model model, HttpServletRequest request, @Valid AdminValidLoginDto adminValidLoginDto, BindingResult bindingResult) throws Exception {

        HttpSession session = request.getSession();

        try {

            if (bindingResult.hasErrors()){

                // 회원가입 실패시 입력 데이터 값 유지하기 위함
                model.addAttribute("adminValidLoginDto", adminValidLoginDto);

                CommonValidateHandling cvh = new CommonValidateHandling();

                // Map 타입 { valid_user_id, "오류 메세지" } 뷰 리턴 하기위함
                Map<String, String> validatorRslt = cvh.validateHandling(bindingResult);

                for (String key: validatorRslt.keySet()) {
                    model.addAttribute(key, validatorRslt.get(key));
                }

                return "admin/adminloginform";
            }

            Map<String, Object> map = new HashMap<>();

            map.put("admin_id", adminValidLoginDto.getAdmin_id());
            map.put("admin_password", adminValidLoginDto.getAdmin_password());

            AdminDto rslt = adminService.adminLogin(map);

            // DB에 있는 관리자 사용 여부 Y 그리고 아이디 비밀번호 일치 값 존재시 로그인 성공
            if ((rslt != null) && rslt.getAdmin_use_yn().equals("Y")) {

                session.setAttribute("adminId", rslt.getAdmin_id());
                session.setAttribute("adminNickName", rslt.getAdmin_nickname());

                // 세션 유지기간 60분
                session.setMaxInactiveInterval(60*60);

                return "redirect:/admin/dashboard";
            }else{

                model.addAttribute("failLogin", "아이디와 패스워드가 일치하지않습니다.");
                session.invalidate();

                return "admin/adminloginform";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/dashboard";
    }
    // 회원 관리
    @GetMapping("/admin/user")
    public String adminUser(Model model,
                            @RequestParam(value = "option", required = false) String option,
                            @RequestParam(value = "keyword", required = false) String keyword,
                            @RequestParam(value = "page", defaultValue = "1") int page) throws Exception{

        try {
            List<UserDto> pagingList = null;

            pagingList = adminService.userPaingList(page, option, keyword);
            PageDto pageDto = adminService.userPagingParam(page, option, keyword);
            int userTotalCnt = adminService.usercnt(option, keyword);

            model.addAttribute("list", pagingList);
            model.addAttribute("paging", pageDto);
            model.addAttribute("userListCnt", userTotalCnt);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "admin/adminuser";
    }
    // 회원 등록하기 폼
    @GetMapping("/admin/userregister")
    public String adminuserRegister() throws Exception{
        return "admin/adminuserregister";
    }
    // 회원 등록하기
    @PostMapping("/admin/userregister")
    public String adminUserRegisterPost(Model model, @Valid UserDto userDto, BindingResult bindingResult, RedirectAttributes rattr) throws Exception{

        try {
            if(bindingResult.hasErrors()){

                // 회원가입 실패시 입력 데이터 값 유지하기 위함
                model.addAttribute("userDto", userDto);

                CommonValidateHandling cvh = new CommonValidateHandling();

                // Map 타입 { valid_user_id, "오류 메세지" } 리턴
                Map<String, String> validatorRslt = cvh.validateHandling(bindingResult);

                for (String key: validatorRslt.keySet()) {
                    model.addAttribute(key, validatorRslt.get(key));
                }

                return "admin/adminuserregister";
            }

            int rslt = adminService.userInsert(userDto);

            if(rslt != 1){
                rattr.addFlashAttribute("msg", "INS_ERR");
                return "redirect:/admin/userregister";
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/admin/user";
    }

    // 회원 삭제 폼
    @GetMapping("/admin/userdelete")
    public String adminUserDelete(Model model,
                            @RequestParam(value = "option", required = false) String option,
                            @RequestParam(value = "keyword", required = false) String keyword,
                            @RequestParam(value = "page", defaultValue = "1") int page) throws Exception{

        try {

            List<UserDto> pagingList = null;

            pagingList = adminService.userPaingList(page, option, keyword);
            PageDto pageDto = adminService.userPagingParam(page, option, keyword);
            int userTotalCnt = adminService.usercnt(option, keyword);

            model.addAttribute("list", pagingList);
            model.addAttribute("paging", pageDto);
            model.addAttribute("userListCnt", userTotalCnt);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "admin/adminuserdelete";
    }
    // 회원 삭제
    @DeleteMapping("/admin/userdelete")
    @ResponseBody
    public int adminUserDeleteMapping(@RequestBody List<String> valueArr) throws Exception{

        // ajax 성공, 실패 결과 return
        int result = 1;

        try {
            for (String userId : valueArr) {
                // 각 값에 대한 삭제 로직 구현
                adminService.userDelete(userId);
            }
        } catch (Exception e){
            result = 0;
            e.printStackTrace();
        }

        return result;
    }
    // 기획사관리
    @GetMapping("/admin/agency")
    public String adminAgency(Model model,
                              @RequestParam(value = "option", required = false) String option,
                              @RequestParam(value = "keyword", required = false) String keyword,
                              @RequestParam(value = "page", defaultValue = "1") int page) throws Exception{

        try {
            List<AgencyDto> pagingList = null;

            pagingList = adminService.agencyPaingList(page, option, keyword);
            PageDto pageDto = adminService.agencyPagingParam(page, option, keyword);
            int agencyCnt = adminService.agencyCnt(option, keyword);

            model.addAttribute("list", pagingList);
            model.addAttribute("paging", pageDto);
            model.addAttribute("listCnt", agencyCnt);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "admin/adminagency";
    }
    // 기획사 등록 폼 이동
    @GetMapping("/admin/agencyregister")
    public String adminGetAgencyRegister() throws Exception{

        return "admin/adminagencyregister";
    }
    // 기획사 등록
    @PostMapping("/admin/agencyregister")
    public String adminPostAgencyRegister(Model model, @Valid AgencyDto agencyDto, BindingResult bindingResult
                                        , RedirectAttributes rattr) throws Exception{

        try {

            if(bindingResult.hasErrors()){

                // 회원가입 실패시 입력 데이터 값 유지하기 위함
                model.addAttribute("agencyDto", agencyDto);

                CommonValidateHandling cvh = new CommonValidateHandling();

                // Map 타입 { valid_user_id, "오류 메세지" } 리턴
                Map<String, String> validatorRslt = cvh.validateHandling(bindingResult);

                for (String key: validatorRslt.keySet()) {
                    model.addAttribute(key, validatorRslt.get(key));
                }

                return "admin/adminagencyregister";
            }

            int rslt = adminService.insertAgency(agencyDto);

            if(rslt != 1){
                rattr.addFlashAttribute("msg", "INS_ERR");
                return "redirect:/admin/agencyregister";
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/admin/agency";
    }
    // 공지사항 관리
    @GetMapping("/admin/notice")
    public String adminNotice(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "sort", defaultValue = "seq")  String sort,
                              @RequestParam(value = "keyword", required = false)  String keyword) throws Exception{

        // page 값이 없이 들어오면다면 default 값 1 설정
        System.out.println("page => " + page);
        // 정렬값
        System.out.println("sort => " + sort) ;
        // 검색한 keyword
        System.out.println("keyword => " + keyword);

        try {

            List<NoticeDto> pagingList = null;

            // page, sort, keyword 받아온 값 동적으로 list 생성
            pagingList = noticeService.pagingList(page, sort, keyword);
            // pageDto에 설정한 maxPage, startPage, endPage 사용하기 위함
            com.jcticket.notice.dto.PageDto pageDto = noticeService.pagingParam(page, keyword);
            int noticeListCnt = noticeService.count(keyword);

            model.addAttribute("list", pagingList);
            model.addAttribute("paging", pageDto);
            model.addAttribute("noticeListCnt", noticeListCnt);

        } catch (Exception e){
            e.printStackTrace();
        }

        return "admin/adminnotice";
    }
    // 공지사항 등록 폼 이동
    @GetMapping("/admin/noticeregister")
    public String adminNoticeRegisterForm() throws Exception{
        return "admin/adminnoticeregister";
    }
    // 공지사항 등록
    @PostMapping("/admin/noticeregister")
    public String adminNoticeRegister(HttpSession session, Model model, @Valid NoticeValidDto noticeValidDto, BindingResult bindingResult
            , RedirectAttributes rattr) throws Exception{

        try {
            if(bindingResult.hasErrors()){

                // 회원가입 실패시 입력 데이터 값 유지하기 위함
                model.addAttribute("noticeValidDto", noticeValidDto);

                CommonValidateHandling cvh = new CommonValidateHandling();

                // Map 타입 { valid_user_id, "오류 메세지" } 리턴
                Map<String, String> validatorRslt = cvh.validateHandling(bindingResult);

                for (String key: validatorRslt.keySet()) {
                    model.addAttribute(key, validatorRslt.get(key));
                }

                return "admin/adminnoticeregister";
            }

            // 세션에 있는 adminid 인서트
            System.out.println("session => " + session.getAttribute("adminId"));
            noticeValidDto.setAdmin_id((String) session.getAttribute("adminId"));

            int rslt = noticeService.insertValid(noticeValidDto);

            if(rslt != 1){
                rattr.addFlashAttribute("msg", "INS_ERR");
                return "redirect:/admin/noticeregister";
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/admin/notice";
    }
    // 공지사항 삭제 폼 이동
    @GetMapping("/admin/noticedelete")
    public String adminNoticeDeleteForm(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "sort", defaultValue = "seq")  String sort,
                              @RequestParam(value = "keyword", required = false)  String keyword) throws Exception{

        // page 값이 없이 들어오면다면 default 값 1 설정
        System.out.println("page => " + page);
        // 정렬값
        System.out.println("sort => " + sort) ;
        // 검색한 keyword
        System.out.println("keyword => " + keyword);

        try {

            List<NoticeDto> pagingList = null;

            // page, sort, keyword 받아온 값 동적으로 list 생성
            pagingList = noticeService.pagingList(page, sort, keyword);
            // pageDto에 설정한 maxPage, startPage, endPage 사용하기 위함
            com.jcticket.notice.dto.PageDto pageDto = noticeService.pagingParam(page, keyword);
            int noticeListCnt = noticeService.count(keyword);

            model.addAttribute("list", pagingList);
            model.addAttribute("paging", pageDto);
            model.addAttribute("noticeListCnt", noticeListCnt);

        } catch (Exception e){
            e.printStackTrace();
        }

        return "admin/adminnoticedelete";
    }

    @DeleteMapping("/admin/noticedelete")
    @ResponseBody
    public int adminNoticeDelete(@RequestBody List<String> valueArr) throws Exception{
        // ajax 성공, 실패 결과 return
        int result = 1;

        try {
            for (String noticeSeq : valueArr) {
                // 각 값에 대한 삭제 로직 구현
                adminService.noticeDelete(Integer.parseInt(noticeSeq));
            }
        } catch (Exception e){
            result = 0;
            e.printStackTrace();
        }

        return result;
    }
    // 공지사항 수정 폼 이동
    @GetMapping("/admin/noticemodify/{notice_seq}")
    public String adminNoticeModifyForm(Model model, @PathVariable  int notice_seq,
                                    @RequestParam(value = "page", required = false, defaultValue = "1") int page
            ,RedirectAttributes rattr) throws Exception{

        try {
            NoticeDto dto = noticeService.read(notice_seq);

            if(dto != null){
                model.addAttribute("dto", dto);
                model.addAttribute("page", page);
            }else{
                // DB내에 없는 번호를 입력할 경우 리스트 페이지로 이동하며 에러 메세지 alert
                rattr.addFlashAttribute("msg", "READ_ERR");
                return "redirect:/admin/notice";
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return "admin/adminnoticemodify";
    }
    // 공지사항 수정
    @PostMapping("/admin/noticemodify")
    public String adminNoticeModify(Model model, int notice_seq,
                                    @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                    RedirectAttributes rattr, NoticeDto noticeDto) throws Exception{

        System.out.println("notice_seq = " + notice_seq);
        System.out.println("page = " + page);

        try {

            int result = noticeService.updateInfo(noticeDto);

            if(result != 1){
                rattr.addFlashAttribute("msg", "MODIFY_ERR");
                return "redirect:/admin/noticemodify";
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/admin/notice";
    }
    // 환경설정 관리자 정보 수정 폼 이동
    @GetMapping("/admin/setting")
    public String adminSettingForm(Model model, String admin_id, HttpSession session) throws Exception{

        admin_id = (String) session.getAttribute("adminId");

        AdminDto dto = adminService.showAdminInfo(admin_id);
        model.addAttribute("adminDto", dto);

        return "admin/adminsetting";
    }
    // 환경설정 관리자 정보 수정
    @PostMapping("/admin/setting")
    public String adminSetting(HttpSession session, Model model,
                               @Valid AdminDto adminDto, BindingResult bindingResult
                               ) throws Exception{

        try {

            if (bindingResult.hasErrors()){

                CommonValidateHandling cvh = new CommonValidateHandling();

                // Map 타입 { valid_user_id, "오류 메세지" } 뷰 리턴 하기위함
                Map<String, String> validatorRslt = cvh.validateHandling(bindingResult);

                for (String key: validatorRslt.keySet()) {
                    model.addAttribute(key, validatorRslt.get(key));
                }

                return "admin/adminsetting";
            }
                // adminId는 로그인한 관리자 아이디 세션값 인서트
                adminDto.setAdmin_id((String) session.getAttribute("adminId"));
                adminService.updateAdminInfo(adminDto);

        } catch (Exception e) {
            e.printStackTrace();
        }
        // 관리자 정보 수정 -> 세션 삭제 후, 로그인폼 페이지 이동
        session.invalidate();

        return "redirect:/admin";
    }
    // 관리자 쿠폰 관리 폼 이동
    @GetMapping("/admin/coupon")
    public String adminCouponForm(Model model, Map<String, Object> map
                        ,@RequestParam(defaultValue = "A") String option
                        ,@RequestParam(required = false) String start_at
                        ,@RequestParam(required = false) String end_at
                        ,@RequestParam(required = false) String keyword
                        ,@RequestParam(value = "page", defaultValue = "1") int page) throws Exception{

        map = new HashMap<>();
        map.put("option", option);
        map.put("keyword", keyword);
        map.put("start_date", start_at);
        map.put("end_date", end_at);

        List<CouponDto> list = adminService.selectAllOptionCoupon(page, option, keyword, start_at, end_at);
        PageDto pageDto = adminService.couponPagingParam(page, option, keyword, start_at, end_at);
        int couponListCnt = adminService.countOptionCoupon(map);

        model.addAttribute("list", list);
        model.addAttribute("paging", pageDto);
        model.addAttribute("couponListCnt", couponListCnt);

        return "admin/admincoupon";
    }
    // 관리자 쿠폰 등록 폼 이동
    @GetMapping("/admin/couponregister")
    public String adminCouponRegisterForm() throws Exception{

        return "admin/admincouponregister";
    }
    // 관리자 쿠폰 등록
    @PostMapping("/admin/couponregister")
    public String adminCouponRegister(Model model, RedirectAttributes rattr,
                                      CouponDto couponDto) throws Exception{

        try {

            int rslt = adminService.insertCoupon(couponDto);

            if(rslt == 0){
                rattr.addFlashAttribute("msg", "INS_ERR");
                return "redirect:/admin/couponregister";
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/admin/coupon";
    }
    @GetMapping("/admin/coupondelete")
    public String adminCouponDeleteForm(Model model, Map<String, Object> map
            ,@RequestParam(defaultValue = "A") String option
            ,@RequestParam(required = false) String start_at
            ,@RequestParam(required = false) String end_at
            ,@RequestParam(required = false) String keyword
            ,@RequestParam(value = "page", defaultValue = "1") int page) throws Exception{

        map = new HashMap<>();
        map.put("option", option);
        map.put("keyword", keyword);
        map.put("start_date", start_at);
        map.put("end_date", end_at);

        List<CouponDto> list = adminService.selectAllOptionCoupon(page, option, keyword, start_at, end_at);
        PageDto pageDto = adminService.couponPagingParam(page, option, keyword, start_at, end_at);
        int couponListCnt = adminService.countOptionCoupon(map);

        model.addAttribute("list", list);
        model.addAttribute("paging", pageDto);
        model.addAttribute("couponListCnt", couponListCnt);

        return "admin/admincoupondelete";
    }
    @DeleteMapping("/admin/coupondelete")
    @ResponseBody
    public int adminCouponDelete(@RequestBody List<String> valueArr) throws Exception{

        // ajax 성공, 실패 결과 return
        int result = 1;
        System.out.println("valueArr = " + valueArr);

        try {
            for (String couponId : valueArr) {
                // 각 값에 대한 삭제 로직 구현
                adminService.deleteCoupon(couponId);
            }
        } catch (Exception e){
            result = 0;
            e.printStackTrace();
        }

        return result;
    }
    @GetMapping("/admin/product")
    public String adminProduct() throws Exception{
        return "admin/adminproduct";
    }
    @GetMapping("/admin/inquiry")
    public String adminInquiry() throws Exception{
        return "admin/admininquiry";
    }
}