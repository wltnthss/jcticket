package com.jcticket.viewdetail.controller;

import com.jcticket.user.dao.UserDao;
import com.jcticket.viewdetail.dao.ViewDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String viewdetail(@RequestParam(value = "dateText", required = false) String dateText,
                             String showing_date, String showing_info,
                             Model model,
                             HttpServletRequest request,
                             HttpServletResponse response) throws Exception {


        //에러가 떴던 이유, 널값체크 안해서 (dateText != null) 이거
        if (dateText != null && showing_date.equals(dateText)) {
            String info = "<a href='#'>" + showing_info + "</a>";
            model.addAttribute("info", info);
        }

        return "viewdetail/viewdetail";
    }
}
