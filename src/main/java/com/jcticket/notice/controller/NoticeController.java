package com.jcticket.notice.controller;

import com.jcticket.notice.dto.NoticeDto;
import com.jcticket.notice.dto.PageDto;
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
 * description : 공지사항 Controller,
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

    @GetMapping("/paging")
    public String NoticePaging(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                            @RequestParam(value = "sort", required = false, defaultValue = "seq")  String sort,
                               @RequestParam(value = "keyword", required = false)  String keyword) throws Exception {
        // page 값이 없이 들어오면다면 default 값 1 설정
        System.out.println("page => " + page);
        // 정렬값
        System.out.println("sort => " + sort) ;
        System.out.println("keyword => " + keyword);

        try {

            List<NoticeDto> pagingList = null;

            pagingList = noticeService.pagingList(page, sort, keyword);
            PageDto pageDto = noticeService.pagingParam(page, sort, keyword);

            model.addAttribute("list", pagingList);
            model.addAttribute("paging", pageDto);

        } catch (Exception e){
            e.printStackTrace();
        }

        // 해당 페이지에서 가져올 글 목록
        return "notice/notice";
    }

    @GetMapping("/{notice_seq}")
    public String NoticeDetail(Model model, @PathVariable int notice_seq,
                               @RequestParam(value = "page", required = false, defaultValue = "1") int page) throws Exception {

        System.out.println("notice_seq => " + notice_seq);

        NoticeDto dto = noticeService.select(notice_seq);

        // 조회 수 1 증가
        noticeService.addViewCnt(notice_seq);

        model.addAttribute("dto", dto);
        model.addAttribute("page", page);

        System.out.println("detail Page => " + page);

        return "notice/noticedetail";
    }
}