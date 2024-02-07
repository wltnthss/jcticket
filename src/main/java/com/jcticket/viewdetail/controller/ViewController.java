package com.jcticket.viewdetail.controller;

import com.jcticket.viewdetail.dao.ViewDetailDao;
import com.jcticket.viewdetail.dto.ShowingDto;
import com.jcticket.viewdetail.service.ViewDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

//    @Autowired
//    public ViewController(ViewDetailService viewDetailService) {
//        this.viewDetailService = viewDetailService;
//    }

    @GetMapping("/viewdetail")
    public String viewDetail() throws Exception {

        return "viewdetail/viewdetail";
    }
    @PostMapping("/viewdetail")
    @ResponseBody
    public List<ShowingDto> viewDetail2(@RequestBody String dateText)
            throws Exception {

//        dateText값 들어오는지 확인
        System.out.println("값 들어오나??");
        System.out.println("dateText => " + dateText);


        // dateText뒤에 계속 등호 들어와서 자름 (2024-02-10=   <<< 이런식으로 들어옴 왜인지는 모르겠다)
        String dateCal = dateText.substring(0, 10);
        System.out.println("dateCal => " + dateCal);


        System.out.println("test => " + viewDetailService.getShowingInfo(dateCal));


        List<ShowingDto> msg = null;

        try {
            List<ShowingDto> list = viewDetailService.getShowingInfo(dateCal);
//            model.addAttribute("info", list);
            msg = list;
        } catch (Exception e) {
            e.printStackTrace();
        }

//        ajax로 보낸건 msg로 받아야됨 viewdetail/viewdetail 로 받으면 안됨
        return msg;
    }
}
