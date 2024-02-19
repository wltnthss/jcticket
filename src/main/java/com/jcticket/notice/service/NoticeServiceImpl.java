package com.jcticket.notice.service;

import com.jcticket.notice.dto.NoticeValidDto;
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

    final static int PAGELIMIT = 10;   // 한 페이지당 보여줄 글 개수
    final static int BLOCKLIMIT = 10;  // 하단에 보여줄 페이지 번호

    @Autowired
    NoticeDao noticeDao;

    @Override
    public NoticeDto read(int no) throws Exception {

        // controller에서 1씩 증가된 값
        noticeDao.addViewCnt(no);

        return noticeDao.select(no);
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
        int pagingStart = (page - 1) * PAGELIMIT;
        List<NoticeDto> pagingList = null;

        Map<String, Object> pagingParams = new HashMap<>();

        pagingParams.put("start", pagingStart);
        pagingParams.put("limit", PAGELIMIT);
        pagingParams.put("keyword", keyword);
        pagingParams.put("sort", sort);

        // 동적쿼리 번호순 seq 값 들어오면 번호순 정렬, view 값 들어오면 조회순 정렬
        pagingList = noticeDao.pagingList(pagingParams);

        return pagingList;
    }

    @Override
    public PageDto pagingParam(int page, String keyword) throws Exception {

        // 전체 글 개수 조회
        int noticeCount = noticeDao.count(keyword);
        System.out.println("noticeCount => " + noticeCount);

        // 전체 페이지 갯수 계산 ex) 24 / 10 => 2.4 => 3
        int maxPage = (int) (Math.ceil((double) noticeCount / PAGELIMIT));
        // 시작 페이지 값 계산 (1, 11, 21 ...)
        int startPage = (((int) (Math.ceil((double) page / BLOCKLIMIT))) -1 ) * BLOCKLIMIT + 1;
        // 끝 페이지 값 계산 (10, 20, 30...)
        int endPage = startPage + BLOCKLIMIT - 1;
        // 이전, 다음 링크 계산
        boolean showPrev = page != 1;
        boolean showNext = page != maxPage;

        if(endPage > maxPage){
            endPage = maxPage;
        }

        PageDto pageDto = new PageDto();
        pageDto.setPage(page);
        pageDto.setMaxPage(maxPage);
        pageDto.setStartPage(startPage);
        pageDto.setEndPage(endPage);
        pageDto.setShowPrev(showPrev);
        pageDto.setShowNext(showNext);
        pageDto.setKeyword(keyword);

        return pageDto;
    }

    @Override
    public int insert(NoticeDto noticeDto) throws Exception {
        return noticeDao.insert(noticeDto);
    }

    @Override
    public int deleteAll() throws Exception {
        return noticeDao.deleteAll();
    }

    @Override
    public int count(String keyword) throws Exception {
        return noticeDao.count(keyword);
    }

    @Override
    public int insertValid(NoticeValidDto noticeValidDto) throws Exception {
        return noticeDao.insertValid(noticeValidDto);
    }

    @Override
    public int updateInfo(NoticeDto noticeDto) throws Exception {
        return noticeDao.updateInfo(noticeDto);
    }

}