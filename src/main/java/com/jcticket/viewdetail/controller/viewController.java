package com.jcticket.viewdetail.controller;

import com.jcticket.user.dao.UserDao;
import com.jcticket.viewdetail.dao.ViewDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class viewController {
    @GetMapping("/viewdetail")
    public String viewdetail(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "viewdetail/viewdetail";
    }
    @PostMapping("/viewdetail")
    @ResponseBody
    public String viewdetail2(@RequestBody String dateText,
                             String showing_date, String showing_info,
                             Model model,
                             HttpServletRequest request,
                             HttpServletResponse response) throws Exception {

//        dateText값 들어오는지 확인
        System.out.println("값 들어오나??");
        System.out.println("dateText => " + dateText);


        // dateText뒤에 계속 등호 들어와서 자름 (2024-02-10=   <<< 이런식으로 들어옴 왜인지는 모르겠다)
        String dateCal = dateText.substring(0, 10);
        System.out.println("dateCal => " + dateCal);

        String msg = null;

//        showing_info 나오는지 확인
        System.out.println("showing_info => " + showing_info);


        //에러가 떴던 이유, 널값체크 안해서 (dateText != null) 이거
        if (dateCal != null && showing_date.equals(dateCal)) {
            msg = showing_info;
        }

        return msg;
    }
}
