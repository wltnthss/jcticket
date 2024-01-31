package com.jcticket.notice.controller;

import com.jcticket.notice.dto.NoticeDto;
import com.jcticket.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * packageName :  com.jcticket.notice.controller
 * fileName : NoticeController
 * author :  jisoo Son
 * date : 2024-01-31
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-01-31             jisoo Son             최초 생성
 */
@Controller
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @GetMapping("/notice")
    public String notice(Model model) throws Exception {

        List<NoticeDto> list =  noticeService.list();
        model.addAttribute("list", list);

        return "notice/notice";
    }
}