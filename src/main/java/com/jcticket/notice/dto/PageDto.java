package com.jcticket.notice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName :  com.jcticket.notice.dto
 * fileName : PagingDto
 * author :  jisoo Son
 * date : 2024-02-02
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-02             jisoo Son             최초 생성
 */
@Getter
@Setter
@ToString
public class PageDto {
    private int page;       // 현재 페이지
    private int maxPage;    // 전체 필요한 페이지 개수
    private int startPage;  // 현재 페이지 기준 시작 페이지 값
    private int endPage;    // 현재 페이지 기준 마지막 페이지 값
    private boolean showPrev;   // 이전 링크
    private boolean showNext;   // 다음 링크

    private String keyword; // 공지사항 검색 값
}