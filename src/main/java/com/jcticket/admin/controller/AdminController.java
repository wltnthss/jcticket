package com.jcticket.admin.controller;

import com.jcticket.admin.dto.*;
import com.jcticket.notice.dto.NoticeValidDto;
import com.jcticket.admin.service.AdminService;
import com.jcticket.agency.dto.AgencyDto;
import com.jcticket.common.CommonValidateHandling;
import com.jcticket.notice.dto.NoticeDto;
import com.jcticket.notice.service.NoticeService;
import com.jcticket.user.dto.UserDto;
import com.jcticket.viewdetail.dto.ShowingDto;
import org.apache.commons.io.IOUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

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

    final int pageLimit = 10;   // 한 페이지당 보여줄 글 개수
    final int blockLimit = 10;  // 하단에 보여줄 페이지 번호

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
            List<Map<String, Object>> productLists = adminService.selectProductsStactics();

            int concertCnt = adminService.concertCnt();
            int musicalCnt = adminService.musicalCnt();
            int theaterCnt = adminService.theaterCnt();
            int classicCnt = adminService.classicCnt();

            model.addAttribute("userLists", userLists);
            model.addAttribute("productLists", productLists);

            model.addAttribute("concertCnt", concertCnt);
            model.addAttribute("musicalCnt", musicalCnt);
            model.addAttribute("theaterCnt", theaterCnt);
            model.addAttribute("classicCnt", classicCnt);

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

                // 세션에서 startTime 값을 가져오거나 없으면 현재 시간으로 설정
                Date startTime = (Date) session.getAttribute("startTime");

                if (startTime == null) {
                    startTime = new Date();
                    session.setAttribute("startTime", startTime);
                }

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

            // 회원 비밀번호 암호화
            String hashPassword = BCrypt.hashpw(userDto.getUser_password(), BCrypt.gensalt());
            userDto.setUser_password(hashPassword);

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
    public String adminCouponForm(Model model
                        ,@RequestParam(defaultValue = "A") String option
                        ,@RequestParam(required = false) String start_at
                        ,@RequestParam(required = false) String end_at
                        ,@RequestParam(required = false) String keyword
                        ,@RequestParam(value = "page", defaultValue = "1") int page) throws Exception{

        Map<String, Object> map = new HashMap<>();
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
    // 관리자 쿠폰 삭제 폼
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
    // 관리자 쿠폰 삭제
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
    // 관리자 공연장명 검색 팝업 조회
    @GetMapping("/admin/stage")
    @ResponseBody
    public List<StageDto> adminProduct(@RequestParam String keyword) throws Exception {

        List<StageDto> list = null;
        try {
            list = adminService.selectKeywordStage(keyword);
            System.out.println("list = " + list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    // 관리자 공연명 검색 팝업 조회
    @GetMapping("/admin/play")
    @ResponseBody
    public List<PlayDto> adminPlay(@RequestParam String keyword) throws Exception {

        List<PlayDto> list = null;
        try {
            list = adminService.selectKeywordPlay(keyword);
            System.out.println("list = " + list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    // 관리자 상품 관리
    @GetMapping("/admin/product")
    public String adminProduct(Model model
            ,@RequestParam(required = false) String start_at
            ,@RequestParam(required = false) String end_at
            ,@RequestParam(required = false) String keyword
            ,@RequestParam(defaultValue = "A") String option
            ,@RequestParam(defaultValue = "A") String status
            ,@RequestParam(defaultValue = "A") String category
            ,@RequestParam(value = "page", defaultValue = "1") int page
                               ) throws Exception{

        Map<String, Object> map = new HashMap<>();
        map.put("start", (page - 1) * pageLimit);
        map.put("limit", pageLimit);
        map.put("keyword", keyword);
        map.put("start_at", start_at);
        map.put("end_at", end_at);
        map.put("option", option);
        map.put("status", status);
        map.put("category", category);

        List<Map<String,Object>> list = adminService.selectAllProduct(map);
        PageDto pageDto = adminService.productPagingParam(page, option, keyword, start_at, end_at, status, category);
        int showingListCnt = adminService.countOptionProduct(map);

        model.addAttribute("list", list);
        model.addAttribute("paging", pageDto);
        model.addAttribute("showingListCnt", showingListCnt);

        return "admin/adminproduct";
    }

    @GetMapping("/upload/{img_name}")
    public @ResponseBody byte[] adminProductImg(Model model, @PathVariable String img_name) throws Exception {

        System.out.println(img_name);
        try{

              String path = "C:/play_img/" + img_name + ".JPG";
            //String path = "/Users/joyoungsang/play_img/" + img_name + ".JPG";
//            System.out.println("path = " + path);

            System.out.println(path);

            InputStream in = new FileInputStream(path);

            System.out.println(in);

            return IOUtils.toByteArray(in);

        } catch (IOException e){
            throw new RuntimeException("이미지 업로드 실패", e);
        }
    }

    // 관리자 상품 관리 등록 폼
    @GetMapping("/admin/productregister")
    public String adminProductRegisterForm() throws Exception{
        return "admin/adminproductregister";
    }
    // 관리자 공연 등록
    @PostMapping("/admin/playregister")
    public String adminProductRegister(Model model, PlayDto playDto) throws Exception{

        try {
            System.out.println("playDto = " + playDto);
            adminService.insertPlay(playDto);
        } catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/admin/productregister";
    }
    // 관리자 회차 등록
    @PostMapping("/admin/showingregister")
    public String adminShowingRegister(ShowingDto showingDto) throws Exception{

        String[] formatShowingInfo = showingDto.getShowing_info().split(",");

        // 회차 정보의 개수 만큼 회차 테이블에 인서트
        Arrays.stream(formatShowingInfo)
                .forEach(info -> {
                    System.out.println("info = " + info);
                    try {
                        System.out.println("showingSeq ++++ " + showingDto.getShowing_seq());
                        showingDto.setShowing_info(info);
                        adminService.insertShowing(showingDto);

                        int showingSeat = showingDto.getShowing_seat_cnt();
                        int showingSeq = showingDto.getShowing_seq();
                        System.out.println("showingSeq ===== " + showingSeq);
                        String showingStageId = showingDto.getStage_id();

                        final int COL = 10;         // 좌석 수를 열의 총 개수 10으로 나눔.
                        int rows = showingSeat / COL;   // 80 / 10 => 8 행수 계산
                        char startRow = 'A';
                        char endRow = (char) (startRow + rows - 1);

                        // 회차 인서트 개수 만큼 회차에 존재하는 좌석수의 수 만큼 회차 좌석 수 삽입
                        for (char row = startRow; row <= endRow; row++) {
                            for (int column = 1; column <= COL; column++) {
                                ShowSeatDto showSeatDto = new ShowSeatDto();

                                showSeatDto.setShowing_seq(showingSeq);
                                showSeatDto.setSeat_row(new String(String.valueOf(row)));
                                showSeatDto.setSeat_col(column);
                                showSeatDto.setStage_id(showingStageId);
                                adminService.insertShowSeat(showSeatDto);
                            }
                        }
                    } catch (Exception e) {
                        throw new RuntimeException("INSERT ERROR => " + e);
                    }
                });

        return "redirect:/admin/product";
    }
    @DeleteMapping("/admin/productdelete")
    @ResponseBody
    public int adminProductDelete(@RequestBody List<String> valueArr) throws Exception{

        // ajax 성공, 실패 결과 return
        int result = 1;
        System.out.println("valueArr = " + valueArr);

        try {
            for (String productId : valueArr) {
                // 각 값에 대한 삭제 로직 구현
                adminService.deleteProduct(productId);
            }
        } catch (Exception e){
            result = 0;
            e.printStackTrace();
        }

        return result;
    }
    // 상품관리 수정 폼 이동
    @GetMapping("/admin/productmodify/{play_id}/{showing_seq}")
    public String adminProductModifyForm(Model model, @PathVariable  String play_id,
                                        @PathVariable int showing_seq,
                                        @RequestParam(value = "page", required = false, defaultValue = "1") int page) throws Exception{

        System.out.println("play_id = " + play_id);
        System.out.println("page = " + page);
        System.out.println("showing_seq = " + showing_seq);

        try {
            PlayDto playDto = adminService.selectPlayInfo(play_id);
            PlayImgDto playImgDto = adminService.selectPlayImgInfo(play_id);
            ShowingDto showingDto = adminService.selectShowingInfo(showing_seq);

            model.addAttribute("playDto", playDto);
            model.addAttribute("playImgDto", playImgDto);
            model.addAttribute("showingDto", showingDto);

        } catch (Exception e){
            e.printStackTrace();
        }

        return "admin/adminproductmodify";
    }

    @PostMapping("/admin/productmodify")
    public String adminProductModify(Model model, ShowingDto showingDto) throws Exception{

        System.out.println("showing_seq = " + showingDto.getShowing_seq());

        try {

            adminService.updateShowingInfo(showingDto);

        } catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/admin/product";
    }
    @GetMapping("/admin/inquiry")
    public String adminInquiry() throws Exception{
        return "admin/admininquiry";
    }
}