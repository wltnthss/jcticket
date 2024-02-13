package com.jcticket.viewdetail.controller;

import com.jcticket.user.dto.UserDto;
import com.jcticket.viewdetail.dao.ViewDetailDao;
import com.jcticket.viewdetail.dto.SeatClassDto;
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

//    @GetMapping("/viewdetail")
//    public String viewDetail() throws Exception {
//        return "viewdetail/viewdetail";
//    }

    @GetMapping("/viewdetail")
    public String remainSeat(Model model) throws Exception{

        try {
//            좌석가격
            int priceSeat = viewDetailService.getSeatPrice();
//            공연날짜 set에 넣었다 빼서 중복을 제거함
            List<ShowingDto> showingDate = viewDetailService.getShowingDate();
            HashSet<ShowingDto> deduplication = new HashSet<>(showingDate);
            showingDate = new ArrayList<>(deduplication);
//            ArrayList역순으로 순서 바꿔줌 why? 그래야 날짜순으로 화면에 출력됨
            Collections.reverse(showingDate);
//            System.out.println(list);
            model.addAttribute("SeatPrice", priceSeat);
            model.addAttribute("ShowingDate", showingDate);

        } catch (Exception e){
            e.printStackTrace();
        }
        return "viewdetail/viewdetail";
    }

    @PostMapping("/viewdetail")
    @ResponseBody
    public List<ShowingDto> viewDetail2(@RequestBody String dateText)
            throws Exception {
//        System.out.println(dateText);
        // dateText뒤에 계속 등호 들어와서 자름 (2024-02-10=   <<< 이런식으로 들어옴 왜인지는 모르겠다)
        char[] charArr = dateText.toCharArray();
        String dateCal = dateText.substring(0, charArr.length-1);

        List<ShowingDto> msg = null;

        try {
//            날짜정보를 통해 해당 날짜의 회차정보 받음
            List<ShowingDto> list = viewDetailService.getShowingInfo(dateCal);
//            model.addAttribute("info", list);
            msg = list;
//            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        ajax로 보낸건 msg로 받아야됨 viewdetail/viewdetail 로 받으면 안됨
        return msg;
    }
//}

//    @PostMapping("/viewdetail/seatInfo")
//    @ResponseBody
//    public List<SeatClassDto> viewDetail3(@RequestBody String seatInfo)
//            throws Exception {
//        //디코딩
//        String decodedSeatInfo = URLDecoder.decode(seatInfo, "UTF-8");
//
//        char[] charArr = decodedSeatInfo.toCharArray();
//        String seatInfoCal = decodedSeatInfo.substring(0, charArr.length-1);
//
//        //        dateText값 들어오는지 확인
////        System.out.println("값 들어오나??");
////        System.out.println("seatInfo => " + seatInfoCal);
//
//        List<SeatClassDto> msg = null;
//        try {
//            List<SeatClassDto> list = viewDetailService.getSeatPrice(seatInfoCal);
//            msg = list;
////            System.out.println(list.get(0));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return msg;
//    }

    @PostMapping("/viewdetail/remainSeat")
    @ResponseBody
    public int viewDetail4(@RequestBody String remainSeat)
            throws Exception {
        //디코딩
        String decodedSeatInfo = URLDecoder.decode(remainSeat, "UTF-8");

        char[] charArr = decodedSeatInfo.toCharArray();
        String remainSeatCal = (decodedSeatInfo.substring(0, charArr.length-1));

        //        dateText값 들어오는지 확인
//        System.out.println("값 들어오나??");
//        System.out.println("remainSeat => " + remainSeatCal);

        int msg = 0;
        try {
//            잔여석 정보
            int list = viewDetailService.getRemainSeat(remainSeatCal);
            msg = list;
//            System.out.println(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
}