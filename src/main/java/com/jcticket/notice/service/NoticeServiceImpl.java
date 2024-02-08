package com.jcticket.notice.service;

import com.jcticket.notice.dao.NoticeDao;
import com.jcticket.notice.dto.NoticeDto;
import com.jcticket.notice.dto.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * packageName :  com.jcticket.notice.service
 * fileName : NoticeServiceImpl
 * author :  jisoo Son
 * date : 2024-01-31
 * description : 공지사항 ServiceImpl
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-01-31             jisoo Son             최초 생성
 */
@Service
public class NoticeServiceImpl implements NoticeService{

    final int pageLimit = 10;   // 한 페이지당 보여줄 글 개수
    final int blockLimit = 10;  // 하단에 보여줄 페이지 번호

    @Autowired
    NoticeDao noticeDao;

    @Override
    public NoticeDto select(int no) throws Exception {
        return noticeDao.select(no);
    }

    @Override
    public int addViewCnt(int no) throws Exception {
        return noticeDao.addViewCnt(no);
    }

    @Override
    public List<NoticeDto> pagingList(int page, String sort, String keyword) throws Exception {
        // 1 page 당 보여주는 글 개수 10
        /*
            1page => 0
            2page => 10
            3page => 20
         */

        // 1page 는 0부터 2page는 10부터 3page는 20부터 시작
        int pagingStart = (page - 1) * pageLimit;
        List<NoticeDto> pagingList = null;

        Map<String, Object> pagingParams = new HashMap<>();

        pagingParams.put("start", pagingStart);
        pagingParams.put("limit", pageLimit);
        pagingParams.put("keyword", keyword);

        // 번호순 seq 값 들어오면 번호순 정렬, 아닐 시에 조회순 정렬
        if(sort.equals("seq")){
            pagingList = noticeDao.pagingList(pagingParams);
        }else{
            pagingList = noticeDao.pagingViewOrderList(pagingParams);
        }

        return pagingList;
    }

    @Override
    public PageDto pagingParam(int page, String keyword) throws Exception {

        // 전체 글 개수 조회
        int noticeCount = noticeDao.count(keyword);
        System.out.println("noticeCount => " + noticeCount);

        // 전체 페이지 갯수 계산 ex) 24 / 10 => 2.4 => 3
        int maxPage = (int) (Math.ceil((double) noticeCount / pageLimit));
        // 시작 페이지 값 계산 (1, 11, 21 ...)
        int startPage = (((int) (Math.ceil((double) page / blockLimit))) -1 ) * blockLimit + 1;
        // 끝 페이지 값 계산 (10, 20, 30...)
        int endPage = startPage + blockLimit - 1;

        if(endPage > maxPage){
            endPage = maxPage;
        }

        PageDto pageDto = new PageDto();
        pageDto.setPage(page);
        pageDto.setMaxPage(maxPage);
        pageDto.setStartPage(startPage);
        pageDto.setEndPage(endPage);
        pageDto.setKeyword(keyword);

        return pageDto;
    }
}