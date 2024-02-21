package com.jcticket.notice.service;

import com.jcticket.notice.dto.NoticeDto;
import com.jcticket.notice.dto.PageDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // DTO timestamp 데이터 삽입 테스트용
    final static Timestamp NOW = new Timestamp(System.currentTimeMillis());
    final static int PAGELIMIT = 10;   // 한 페이지당 보여줄 글 개수
    final static int BLOCKLIMIT = 10;  // 하단에 보여줄 페이지 번호

    @Before
    public void init() throws Exception{
        System.out.println("init DELETE ALL");
        noticeService.deleteAll();
    }
    @Test
    public void pageDefaultList() throws Exception{
        // given
        int result = 0;
        for (int i = 1; i < 122; i++) {
            NoticeDto noticeDto = new NoticeDto("정석코딩"+i+"기", "정석코딩"+i+"기 모집", 0, NOW, "Y", "N", "admin", NOW, "JISOO", NOW, "JISOO");

            result = noticeService.insert(noticeDto);
            assertTrue(1 == result);
        }
        int page = 2;
        String sort = "";
        String keyword = "";
        List<NoticeDto> pagingList = null;

        //when
        PageDto pageDto = noticeService.pagingParam(page, keyword);
        System.out.println("pageDto => " + pageDto.toString());

        pagingList = noticeService.pagingList(page, sort, keyword);
        System.out.println("pagingList => " + pagingList);

        //then
        assertTrue(pagingList.size() == 10);
        assertTrue(13 == pageDto.getMaxPage());
        assertTrue(1 == pageDto.getStartPage());
        assertTrue(10 == pageDto.getEndPage());
    }

    @Test
    public void pageKeywordList() throws Exception{

        // given 테스트케이스 꼼꼼하게 더 추가하기
        int result = 0;
        for (int i = 1; i < 122; i++) {
            NoticeDto noticeDto = new NoticeDto("정석코딩"+i+"기", "정석코딩"+i+"기 모집", 0, NOW, "Y", "N", "admin", NOW, "JISOO", NOW, "JISOO");

            result = noticeService.insert(noticeDto);
            assertTrue(1 == result);
        }
        int page = 1;
        String sort = "";
        String keyword = "1";
        List<NoticeDto> pagingList = null;

        //when
        int cnt = noticeService.count(keyword);
        System.out.println("cnt => " + cnt);

        pagingList = noticeService.pagingList(page, sort, keyword);
        PageDto pageDto = noticeService.pagingParam(page, keyword);
        System.out.println("pageDto => " + pageDto.toString());

        //then
        assertTrue(cnt == 41);
        assertTrue(5 == pageDto.getMaxPage());
        assertTrue(1 == pageDto.getStartPage());
        assertTrue(5 == pageDto.getEndPage());
    }
}