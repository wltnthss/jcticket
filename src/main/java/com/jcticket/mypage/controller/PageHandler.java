package com.jcticket.mypage.controller;

/**
 * packageName    : com.jcticket.mypage.dto
 * fileName       : MyPagingDTO
 * author         : JJS
 * date           : 2024-02-13
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-13        JJS       최초 생성
 */
public class PageHandler {

    private int page;

    private String option;   // 조회 검색

    private String keyword;

    private String start_date; //날짜별 조회 검색 시작
    
    private String end_date;  //날짜별 조회 검색 끝
    private int totalCnt;
    private int pageSize;
    private int navSize = 10;
    private int totalPage;
    private int beginPage;
    private int endPage;
    private boolean showPrev;
    private boolean showNext;



    public PageHandler(int totalCnt, int page, String option, String start_date, String end_date, String keyword) {
        this(totalCnt, page, 10, option, start_date, end_date, keyword);
    }

    public PageHandler(int totalCnt, int page, int pageSize, String option, String start_date, String end_date, String keyword) {
        this.totalCnt = totalCnt;
        this.page = page;
        this.pageSize = pageSize;
        this.option = option;
        this.start_date = start_date;
        this.end_date = end_date;
        this.keyword = keyword;



        totalPage = (int)Math.ceil(totalCnt / (double)pageSize);    // 11
        beginPage = (page - 1) / navSize * navSize + 1;             // 1
        endPage = Math.min(beginPage + navSize - 1, totalPage);     // 10
        showPrev = beginPage != 1;                                  // false
        showNext = endPage != totalPage;                            // true

    }




    public PageHandler(int totalCnt, int page, int pageSize) {
        this.totalCnt = totalCnt;
        this.page = page;
        this.pageSize = pageSize;



        totalPage = (int)Math.ceil(totalCnt / (double)pageSize);    // 11
        beginPage = (page - 1) / navSize * navSize + 1;             // 1
        endPage = Math.min(beginPage + navSize - 1, totalPage);     // 10
        showPrev = beginPage != 1;                                  // false
        showNext = endPage != totalPage;                            // true

    }

    public PageHandler(int totalCnt, int page) {
        this(totalCnt, page, 10);
    }


    public void print() {
        System.out.println("page = " + page);
        System.out.print(showPrev ? "[PREV] " : " ");
        for(int i = beginPage; i <= endPage; i++) {
            System.out.print(i + " ");
        }
        System.out.print(showNext ? " [NEXT] " : " ");
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getNavSize() {
        return navSize;
    }

    public void setNavSize(int navSize) {
        this.navSize = navSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isShowPrev() {
        return showPrev;
    }

    public void setShowPrev(boolean showPrev) {
        this.showPrev = showPrev;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public PageHandler(int page, String option, String start_date, String end_date, int totalCnt, int pageSize, int navSize, int totalPage, int beginPage, int endPage, boolean showPrev, boolean showNext) {
        this.page = page;
        this.option = option;
        this.start_date = start_date;
        this.end_date = end_date;
        this.totalCnt = totalCnt;
        this.pageSize = pageSize;
        this.navSize = navSize;
        this.totalPage = totalPage;
        this.beginPage = beginPage;
        this.endPage = endPage;
        this.showPrev = showPrev;
        this.showNext = showNext;
    }
}
