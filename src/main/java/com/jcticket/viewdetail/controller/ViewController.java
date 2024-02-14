package com.jcticket.viewdetail.controller;

import com.jcticket.user.dto.UserDto;
import com.jcticket.viewdetail.dao.ViewDetailDao;
import com.jcticket.viewdetail.dto.JoinDto;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

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
    @Autowired
    ViewDetailService viewDetailService;

//    공연아이디 조건, view에서 표시할 정보들
    @GetMapping("/viewdetail")
    public String viewdetail(@RequestParam String this_play_id,
            Model model) throws Exception{
        try {
            List<JoinDto> viewDetail = viewDetailService.getViewDetail(this_play_id);
            List<ShowingDto> view_showing_info = viewDetailService.getViewShowingInfo(this_play_id);
            model.addAttribute("viewDetail", viewDetail);
            model.addAttribute("viewShwoingInfo", view_showing_info);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "viewdetail/viewdetail";
    }

//    회차정보받기(ex.24년 2월 1일 >>> 1회 12시 00분)
    @PostMapping("/viewdetail")
    @ResponseBody
    public List<ShowingDto> viewDetail2(@RequestBody String dateText)
            throws Exception {
        // dateText뒤에 계속 등호 들어와서 자름 (2024-02-10=   <<< 이런식으로 들어옴 왜인지는 모르겠다)
        char[] charArr = dateText.toCharArray();
        String dateCal = dateText.substring(0, charArr.length-1);
        List<ShowingDto> msg = null;
        try {
//            날짜정보를 통해 해당 날짜의 회차정보 받음
            List<ShowingDto> list = viewDetailService.getShowingInfo(dateCal);
            msg = list;
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        try {
            int list = viewDetailService.getRemainSeat(remainSeatCal);
            msg = list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
}