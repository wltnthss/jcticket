package com.jcticket.mypage.dto;

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
public class MyPagingDTO {

    private int totalCnt;
    private int pageSize;
    private int navSize = 10;
    private int totalPage;
    private int page;
    private int beginPage;
    private int endPage;
    private boolean showPrev;
    private boolean showNext;

    public MyPagingDTO(int totalCnt, int page) {
        this(totalCnt, page, 10);
    }

    public MyPagingDTO(int totalCnt, int page, int pageSize) {
        this.totalCnt = totalCnt;
        this.page = page;
        this.pageSize = pageSize;

        totalPage = (int)Math.ceil(totalCnt / (double)pageSize);
        beginPage = page / navSize * navSize + 1;
        endPage = Math.min(beginPage + navSize - 1, totalPage);
        showPrev = beginPage != 1;
        showNext = endPage != totalPage;
    }

    void print() {
        System.out.println("page = " + page);
        System.out.print(showPrev ? "[PREV] " : " ");
        for(int i = beginPage; i <= endPage; i++) {
            System.out.print(i + " ");
        }
        System.out.print(showNext ? " [NEXT] " : " ");

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

    @Override
    public String toString() {
        return "MyPagingDTO{" +
                "totalCnt=" + totalCnt +
                ", pageSize=" + pageSize +
                ", navSize=" + navSize +
                ", totalPage=" + totalPage +
                ", page=" + page +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", showPrev=" + showPrev +
                ", showNext=" + showNext +
                '}';
    }
}
