package com.jcticket.notice.dao;

import com.jcticket.notice.dto.NoticeDto;

import java.util.List;
import java.util.Map;

/**
 * packageName :  com.jcticket.notice.dao
 * fileName : NoticeDao
 * author :  jisoo Son
 * date : 2024-01-31
 * description : 공지사항 Dao
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-01-31             jisoo Son             최초 생성
 */
public interface NoticeDao {
    String test() throws Exception;

    List<NoticeDto> list() throws Exception;
    NoticeDto select(int no) throws Exception;

    // 전체 notice 리스트 개수 조회
    int count(String keyword) throws Exception;

    // 상세보기 진입시 조회수 1씩 증가
    int addViewCnt(int no) throws Exception;
    List<NoticeDto> pagingList(Map<String, Object> pagingParams);

    List<NoticeDto> pagingViewOrderList(Map<String, Object> pagingParams);
}