package com.jcticket.notice.service;

import com.jcticket.notice.dto.NoticeDto;
import com.jcticket.notice.dto.PageDto;

import java.util.List;
import java.util.Map;

/**
 * packageName :  com.jcticket.notice.service
 * fileName : NoticeService
 * author :  jisoo Son
 * date : 2024-01-31
 * description : 공지사항 Service
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-01-31             jisoo Son             최초 생성
 */
public interface NoticeService {

    List<NoticeDto> list() throws Exception;

    NoticeDto select(int no) throws Exception;
    // 상세보기 진입시 조회수 1씩 증가
    int addViewCnt(int no) throws Exception;

    List<NoticeDto> pagingList(int page, String sort) throws Exception;

    PageDto pagingParam(int page, String sort) throws Exception;

    List<NoticeDto> pagingViewOrderList(int page, String sort) throws Exception;
}