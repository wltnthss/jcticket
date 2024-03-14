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
        int page = 2;
        String sort = "";
        String keyword = "";
        List<NoticeDto> pagingList = null;

        for (int i = 1; i < 12; i++) {
            NoticeDto noticeDto = NoticeDto.builder()
                    .notice_title("정석코딩" +i+ "기")
                    .notice_content("정석코딩" +i+ "기 모집합니다.")
                    .notice_reg_at(NOW)
                    .notice_pin_yn("N")
                    .notice_use_yn("Y")
                    .admin_id("admin" +i)
                    .created_at(NOW)
                    .created_id("SYSTEM")
                    .updated_at(NOW)
                    .update_id("SYSTEM")
                    .build();

            noticeService.insert(noticeDto);
        }

        //when
        PageDto pageDto = noticeService.pagingParam(page, keyword);
        pagingList = noticeService.pagingList(page, sort, keyword);

        //then
        assertTrue(pagingList.size() == 1);
        assertTrue(2 == pageDto.getMaxPage());
        assertTrue(1 == pageDto.getStartPage());
        assertTrue(2 == pageDto.getEndPage());
    }

    @Test
    public void pageKeywordList() throws Exception{

        // given
        int page = 1;
        String sort = "";
        String keyword = "1";
        List<NoticeDto> pagingList = null;

        for (int i = 1; i < 12; i++) {

            NoticeDto noticeDto = NoticeDto.builder()
                    .notice_title("정석코딩" +i+ "기")
                    .notice_content("정석코딩" +i+ "기 모집합니다.")
                    .notice_reg_at(NOW)
                    .notice_pin_yn("N")
                    .notice_use_yn("Y")
                    .admin_id("admin" +i)
                    .created_at(NOW)
                    .created_id("SYSTEM")
                    .updated_at(NOW)
                    .update_id("SYSTEM")
                    .build();

            noticeService.insert(noticeDto);
        }


        //when
        int cnt = noticeService.count(keyword);
        pagingList = noticeService.pagingList(page, sort, keyword);
        PageDto pageDto = noticeService.pagingParam(page, keyword);

        //then
        assertTrue(cnt == 3);
        assertTrue(1 == pageDto.getMaxPage());
        assertTrue(1 == pageDto.getStartPage());
        assertTrue(1 == pageDto.getEndPage());
    }
}