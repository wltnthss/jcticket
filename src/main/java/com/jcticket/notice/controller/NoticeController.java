package com.jcticket.notice.controller;

import com.jcticket.notice.dto.NoticeDto;
import com.jcticket.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @GetMapping("")
    public String Notice(Model model) throws Exception {

        List<NoticeDto> list =  noticeService.list();
        model.addAttribute("list", list);

        return "notice/notice";
    }

    @GetMapping("/{notice_seq}")
    public String NoticeDetail(Model model, @PathVariable String notice_seq) throws Exception {

        System.out.println("RESTFul API TEST");
        System.out.println("notice_seq => " + notice_seq);

        return "notice/noticedetail";
    }

}