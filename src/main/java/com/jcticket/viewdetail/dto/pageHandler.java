package com.jcticket.viewdetail.dto;

/**
 * packageName    : com.jcticket.viewdetail.dto
 * fileName       : pageHandler
 * author         : sungjun
 * date           : 2024-02-14
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-14        kyd54       최초 생성
 */
//제대로 다시 만들것
public class pageHandler {
    final static int NAV_SIZE = 10;
    int page; //현재 페이지
    int totalCnt; //전체 게시물 개수
    int pageSize; //페이지 사이즈
    int startPage = 1; //시작 페이지
    int endPage; //끝페이지
    int totalPage; //전체 페이지
    boolean showPrev; //이전 링크
    boolean showNext; //다음 링크

    public pageHandler(int page, int totalCnt, int pageSize) {
        this.page = page;
        this.totalCnt = totalCnt;
        this.pageSize = pageSize;
        
        totalPage = totalCnt/pageSize + (totalCnt % pageSize==0? 0 : 1);
        startPage = page / NAV_SIZE * NAV_SIZE +1; //15 > 11
        // page(현재페이지)가 전체 페이지의 범위를 벗어나면 기본값인 1로 변경.
        page = page > totalPage || page <= 0 ? 1: page;
        // endPage가 totalPage보다 크면 endPage는 totalPage가 되어야 한다.
        endPage = endPage>totalPage?totalPage:endPage;
        showPrev = startPage != 1;
        showNext = endPage != totalPage;
    }

    //getter setter 추가


    public int getPage() {
        return page;
    }

    public int getTotalCnt() {
        return totalCnt;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public boolean isShowPrev() {
        return showPrev;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public String toString() {
        String str = "";
        if (showPrev)
            str += "< 이전";

        for (int i = startPage; i < endPage; i++)
            System.out.println(" " + i + " ");
        if (showNext)

            str += "다음 >";
        return str;
    }
}
