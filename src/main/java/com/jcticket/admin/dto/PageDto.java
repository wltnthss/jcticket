package com.jcticket.admin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName :  com.jcticket.aadmin.dto
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

    private String option;  // 회원 검색 옵션 기준
    private String keyword; // 회원 검색 keyword
    private String start_at;// 관리자 쿠폰 조회 시작 일자
    private String end_at;  // 관리자 쿠폰 조회 종료 일자
    private String status;  // 관리자 상품 상태
    private String category;// 관리자 상품 카테고리
}