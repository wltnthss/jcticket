package com.jcticket.notice.dao;

import com.jcticket.notice.dto.NoticeDto;
import com.jcticket.notice.dto.PageDto;
import com.jcticket.notice.service.NoticeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * packageName :  com.jcticket.notice.dao
 * fileName : NoticeDaoImplTest
 * author :  jisoo Son
 * date : 2024-01-31
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-01-31             jisoo Son             최초 생성
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class NoticeDaoImplTest {

    @Autowired
    NoticeDao noticeDao;

    @Autowired
    NoticeService noticeService;

    @Test
    public void updateViewCnt() throws Exception{

        // given -> 임의의 데이터를 주입
        int noticeSeq = 1;

        // when -> 데이터의 조건 dao, service
        NoticeDto noticeDto = noticeDao.select(noticeSeq);
        noticeDao.addViewCnt(noticeDto.getNotice_seq());

        // then -> 검증하는 절차
        assertTrue(48 == noticeDto.getNotice_view_cnt());
    }

    @Test
    public void listcount() throws Exception{

        //given => insert 한 내용을 기준으로 재테스트

        // keyword "" 인 경우 전체 리스트 카운트
        int totalCnt = noticeDao.count("");
        // keyword "qwer" 인 경우 DB에 제목이 qwer인 값만 카운트
        int totcalKeywordCnt = noticeDao.count("qwer");

        // then
        assertTrue(28 == totalCnt);
        assertTrue(4 == totcalKeywordCnt);
    }

    @Test
    public void pageDefaultList() throws Exception{
        // given  => for문으로 재테스트
        int page = 1;
        String sort = "";
        String keyword = "";
        List<NoticeDto> pagingList = null;

        //when
        pagingList = noticeService.pagingList(page, sort, keyword);
        System.out.println("pagingList => " + pagingList);
        PageDto pageDto = noticeService.pagingParam(page, keyword);

        //then
        assertTrue(pagingList.size() == 10);
        assertTrue(3 == pageDto.getMaxPage());
        assertTrue(1 == pageDto.getStartPage());
        assertTrue(3 == pageDto.getEndPage());
    }

    @Test
    public void pageKeywordList() throws Exception{

        //given
        int page = 1;
        String sort = "";
        String keyword = "qwer";
        List<NoticeDto> pagingList = null;

        //when
        pagingList = noticeService.pagingList(page, sort, keyword);
        PageDto pageDto = noticeService.pagingParam(page, keyword);

        //then
        assertTrue(pagingList.size() == 4);
        assertTrue(1 == pageDto.getMaxPage());
        assertTrue(1 == pageDto.getStartPage());
        assertTrue(1 == pageDto.getEndPage());
    }

    @Test
    public void pageOrderList() throws Exception{

        //given
        int page = 1;
        String sort = "view";
        String keyword = "";
        List<NoticeDto> pagingList = null;

        //when
        pagingList = noticeService.pagingList(page, sort, keyword);
        PageDto pageDto = noticeService.pagingParam(page, keyword);

        //then
        assertTrue(pagingList.get(0).getNotice_title().equals("공지사항 제목 테스트 1"));
    }
}