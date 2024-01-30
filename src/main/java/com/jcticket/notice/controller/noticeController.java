package com.jcticket.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * packageName :  com.jcticket.notice.controller
 * fileName : noticeController
 * author :  jisoo Son
 * date : 2024-01-30
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-01-30             jisoo Son             최초 생성
 */
@Controller
public class noticeController {

    @GetMapping("/notice")
    public String noticePage(){
        return "/notice/notice";
    }
}