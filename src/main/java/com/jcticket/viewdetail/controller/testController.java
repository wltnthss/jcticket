package com.jcticket.viewdetail.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * packageName    : com.jcticket.viewdetail.controller
 * fileName       : testController
 * author         : sungjun
 * date           : 2024-02-14
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-14        kyd54       최초 생성
 */


@Controller
public class testController {
    @GetMapping("/test")
    public String test() throws Exception {
        return "viewdetail/test";
    }
}
