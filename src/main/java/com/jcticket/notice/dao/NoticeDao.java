package com.jcticket.notice.dao;

import com.jcticket.notice.dto.NoticeValidDto;
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
    // 공지사항 전체 삭제
    int deleteAll() throws Exception;
    // 공지사항 인서트
    int insert(NoticeDto noticeDto) throws Exception;
    // 공지사항 전체 리스트 조회
    List<NoticeDto> selectAll() throws Exception;
    // 공지사항 상세보기
    NoticeDto select(int no) throws Exception;
    // 전체 notice 리스트 개수 조회
    int count(String keyword) throws Exception;
    // 상세보기 진입시 조회수 1씩 증가
    int addViewCnt(int no) throws Exception;
    // paging List 조회
    List<NoticeDto> pagingList(Map<String, Object> pagingParams);
    // 관리자단 공지사항 등록
    int insertValid(NoticeValidDto noticeValidDto) throws Exception;
    // 관리자단 공지사항 수정
    int updateInfo(NoticeDto noticeDto) throws Exception;
}