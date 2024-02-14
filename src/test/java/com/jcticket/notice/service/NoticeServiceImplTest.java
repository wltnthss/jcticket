package com.jcticket.notice.service;

import com.jcticket.notice.dto.NoticeDto;
import com.jcticket.notice.dto.PageDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * packageName :  com.jcticket.notice.service
 * fileName : NoticeServiceImplTest
 * author :  jisoo Son
 * date : 2024-02-14
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-14             jisoo Son             최초 생성
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class NoticeServiceImplTest {

    @Autowired
    NoticeService noticeService;

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
        assertTrue(4 == pageDto.getMaxPage());
        assertTrue(1 == pageDto.getStartPage());
        assertTrue(4 == pageDto.getEndPage());
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