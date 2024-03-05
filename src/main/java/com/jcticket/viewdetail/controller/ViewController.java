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
import java.net.URLDecoder;
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
    public Map<String, Object> viewdetailv(@RequestParam String this_play_id,
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
    public String viewdetail(@RequestParam String this_play_id,
                             @RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             Model model) throws Exception {

        //ticketing 페이지로 보낼 play_id
        String play_id = this_play_id;
        model.addAttribute("play_id",play_id);

        //상세보기에 표시할 것들 서비스에서 하나로 묶어서 tx?
        List<JoinDto> viewDetail = viewDetailService.getViewDetail(this_play_id);
        Map<String, List<String>> viewDetailTime = viewDetailService.getViewDetailTime(this_play_id);

        ReviewDto reviewDto = new ReviewDto();
//        인서트로 바꿀것
        List<ReviewDto> review = viewDetailService.review_select(this_play_id);
        model.addAttribute("review", review);

//        System.out.println("viewDetailTime=============>"+viewDetailTime);

        model.addAttribute("viewDetail", viewDetail);
        model.addAttribute("viewDetailTime", viewDetailTime);


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
    public List<ShowingDto> viewDetail2(
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
    public int viewDetail4(@RequestBody String remainSeat)
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

    @GetMapping("/review_insert")
    public Object review_insert() throws Exception {
        return "viewdetail/review_insert";
    }
}