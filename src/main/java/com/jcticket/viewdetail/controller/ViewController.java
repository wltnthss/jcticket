package com.jcticket.viewdetail.controller;

import com.jcticket.viewdetail.dto.JoinDto;
import com.jcticket.viewdetail.dto.PageHandler;
import com.jcticket.viewdetail.dto.ReviewDto;
import com.jcticket.viewdetail.dto.ShowingDto;
import com.jcticket.viewdetail.service.ViewDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * packageName    : com.jcticket.viewdetail.controller
 * fileName       : detailcontroller
 * author         : sungjun
 * date           : 2024-01-31
 * description    : 티켓상세보기 컨트롤러
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-31        kyd54       최초 생성
 */
@Controller
public class ViewController {
    //에러처리
    //ExceptionCatcher.java 파일에서 일괄적으로 해줌

    //ExceptionHandler를 사용한 덕에 중복코드 제거 가능해짐
//        try {
    
    //        } catch (Exception e){
//            e.printStackTrace();
//            return "viewdetail/error";
//        }

    @Autowired
    ViewDetailService viewDetailService;

//    ajax 사용한 페이징
    @GetMapping("/viewdetail/page")
    @ResponseBody
    public Map<String, Object> review(@RequestParam String this_play_id,
                                    @RequestParam Integer page,
                                    @RequestParam Integer pageSize
                                    ,Model model) throws Exception {

        Map<String, Object> msg = new HashMap<>();

        Map board_map = new HashMap();
        board_map.put("play_id",this_play_id);
        board_map.put("offset",(page-1)*pageSize);
        board_map.put("pageSize",pageSize);

        List<ReviewDto> boardList = viewDetailService.review_select_limit(board_map);
//        System.out.println(boardList);
        msg.put("boardList",boardList);

        return msg;
    }

//    공연아이디 조건, view에서 표시할 정보들
    @GetMapping("/viewdetail")
    public String viewdetail(@RequestParam(required = false) String this_play_id,
                             @RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             Model model,
                             HttpServletRequest request) throws Exception {
        
        //공연아이디 없이 viewdetail페이지로 진입할 시 index 페이지로 이동
        if (this_play_id == null) {
            return "redirect:/index";
        }

        //ticketing 페이지로 보낼 play_id
        model.addAttribute("play_id",this_play_id);

        //상세보기에 표시할 것들 서비스에서 하나로 묶어서 tx?
        List<JoinDto> viewDetail = viewDetailService.getViewDetail(this_play_id);
        Map<String, List<String>> viewDetailTime = viewDetailService.getViewDetailTime(this_play_id);

//        ReviewDto reviewDto = new ReviewDto();

        //카테고리 한글 > 영문 변환 (a태그 href에 들어갈 것)
        String major_cat = "";
        for (JoinDto category : viewDetail) {
            major_cat = category.getPlay_major_cat().toLowerCase(); // 모든 문자열을 소문자로 변환
            if (major_cat.equals("콘서트")) {
                major_cat = "concert";
            } else if (major_cat.equals("뮤지컬")) {
                major_cat = "musical";
            } else if (major_cat.equals("연극")) {
                major_cat = "play";
            } else if (major_cat.equals("클래식")) {
                major_cat = "classic";
            }
        }
//        System.out.println("major_cat==============>"+major_cat);
        model.addAttribute("major_cat", major_cat);


//        인서트로 바꿀것
        List<ReviewDto> review = viewDetailService.review_select(this_play_id);
        model.addAttribute("review", review);

        System.out.println("viewDetail=============>"+viewDetail);

        //상세보기에 들어갈 내용들(제목, 공연장이름, 좌석가격 등)
        model.addAttribute("viewDetail", viewDetail);
        model.addAttribute("viewDetailTime", viewDetailTime);
        
        //세션에 저장된 아이디 가져오기
        HttpSession session = request.getSession();
        String user_id = (String)session.getAttribute("sessionId");

//        System.out.println("user_id================>"+user_id);

        model.addAttribute("user_id",user_id);
        
        //리뷰작성시 들어갈 관람일시
        Map viewing_at_map = new HashMap();
        viewing_at_map.put("play_id",this_play_id);
        viewing_at_map.put("user_id",user_id);
        List<String> viewing_at = viewDetailService.viewing_at(viewing_at_map);
        model.addAttribute("viewing_at",viewing_at);


        
        //-----------------------------------------------------------------------

//        //페이지핸들러
        int totalCnt = viewDetailService.get_review_count(this_play_id);
        PageHandler pageHandler = new PageHandler(page,totalCnt,pageSize);

        model.addAttribute("ph",pageHandler);

        //예외페이지 테스트
//        throw new Exception("예외 발생");
//        throw new NullPointerException("예외 발생");

        return "viewdetail/viewdetail";
    }

//    회차정보받기(ex.24년 2월 1일 >>> 1회 12시 00분)
    @PostMapping("/viewdetail")
    @ResponseBody
    public List<ShowingDto> GetShowingInfo(
            @RequestParam String dateText,
            @RequestParam String play_id
    )
            throws Exception {

        List<ShowingDto> msg = null;

//        System.out.println("play_id======>"+play_id);
//        System.out.println("dateText======>"+dateText);

//            날짜정보를 통해 해당 날짜의 회차정보 받음
        List<ShowingDto> list = viewDetailService.getShowingInfo(dateText,play_id);
        msg = list;

        return msg;
    }

//    잔여석정보(ex.잔여 5석)
    @PostMapping("/viewdetail/remainSeat")
    @ResponseBody
    public int RemainSeat(@RequestBody String remainSeat)
            throws Exception {
        //디코딩
        String decodedSeatInfo = URLDecoder.decode(remainSeat, "UTF-8");
        char[] charArr = decodedSeatInfo.toCharArray();
        String remainSeatCal = (decodedSeatInfo.substring(0, charArr.length-1));
        int msg = 0;

        int list = viewDetailService.getRemainSeat(remainSeatCal);
        msg = list;

        return msg;
    }

    @PostMapping("/review_insert")
    public String review_insert(HttpServletRequest request,
                                HttpServletResponse response,
                                @RequestParam(required = false) String play_id,
                                @RequestParam(required = false) String user_id,
                                @RequestParam(required = false) String star,
                                @RequestParam(required = false) String viewing_at,
                                @RequestParam(required = false) String review_content
                                ) throws Exception {
        // 이전 페이지의 URL을 받아오기
        String referer = request.getHeader("referer");

//        System.out.println("user_id===================>"+user_id);
//        System.out.println("play_id===================>"+play_id);
        if(user_id==null || user_id.isEmpty()) {
            return "redirect:/login";
        } else {
            // ReviewDto 객체 생성
            ReviewDto reviewDto = new ReviewDto();
            reviewDto.setPlay_id(play_id);
            reviewDto.setUser_id(user_id);
            reviewDto.setReview_star_rating(Integer.parseInt(star)); // 별점은 정수로 변환
            reviewDto.setReview_viewing_at(viewing_at);
            reviewDto.setReview_content(review_content);
            reviewDto.setCreated_id(user_id);
            reviewDto.setUpdated_id(user_id);

            // ReviewDto 객체를 서비스 계층을 통해 DAO 계층으로 전달하여 데이터베이스에 저장
            viewDetailService.review_create(reviewDto);

            // 후기작성란으로 리다이렉트
            return "redirect:" + referer + "#review_place";
        }
    }

    @GetMapping("/review_delete") //@DeleteMapping 써볼것
    public int ReviewDelete() throws Exception {
        // ajax 성공, 실패 결과 return
        int result = 1;

        return result;
    }
}