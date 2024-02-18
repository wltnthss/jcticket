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
 * description : 공지사항 Controller
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
    public String NoticePaging(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
                            @RequestParam(value = "sort", defaultValue = "seq")  String sort,
                               @RequestParam(value = "keyword", required = false)  String keyword) throws Exception {
        // page 값이 없이 들어오면다면 default 값 1 설정
        System.out.println("page => " + page);
        // 정렬값
        System.out.println("sort => " + sort) ;
        // 검색한 keyword
        System.out.println("keyword => " + keyword);

        try {

            List<NoticeDto> pagingList = null;

            // page, sort, keyword 받아온 값 동적으로 list 생성
            pagingList = noticeService.pagingList(page, sort, keyword);
            // pageDto에 설정한 maxPage, startPage, endPage 사용하기 위함
            PageDto pageDto = noticeService.pagingParam(page, keyword);

            model.addAttribute("list", pagingList);
            model.addAttribute("paging", pageDto);

        } catch (Exception e){
            e.printStackTrace();
        }

        return "notice/notice";
    }

    @GetMapping("/{notice_seq}")
    public String NoticeDetail(Model model, @PathVariable  int notice_seq,
                               @RequestParam(value = "page", required = false, defaultValue = "1") int page) throws Exception {

        try {
            NoticeDto dto = noticeService.read(notice_seq);

            model.addAttribute("dto", dto);
            model.addAttribute("page", page);
        } catch (Exception e){
            // validation 어노테이션
            e.printStackTrace();
        }

        return "notice/noticedetail";
    }
}