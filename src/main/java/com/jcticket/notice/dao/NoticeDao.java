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
    // 공지사항 상세보기
    NoticeDto select(int no) throws Exception;
    // 전체 notice 리스트 개수 조회
    int count(String keyword) throws Exception;
    // 상세보기 진입시 조회수 1씩 증가
    int addViewCnt(int no) throws Exception;
    // paging 번호순 내림차순 List 조회
    List<NoticeDto> pagingList(Map<String, Object> pagingParams);
    // paging 조회순 내림차순 List 조회
    List<NoticeDto> pagingViewOrderList(Map<String, Object> pagingParams);
}