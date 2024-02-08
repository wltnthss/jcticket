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

    NoticeDto select(int no) throws Exception;
    int addViewCnt(int no) throws Exception;
    // 화면에서 받은 sort 값에 따라 번호순, 조회순 분기 따라 쿼리 적용
    List<NoticeDto> pagingList(int page, String sort, String keyword) throws Exception;
    // 현재페이지, 전체, 시작, 끝, 검색값 전달 PageDto 전달
    PageDto pagingParam(int page, String keyword) throws Exception;
}