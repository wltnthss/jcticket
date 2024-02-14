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

    Timestamp now = new Timestamp(System.currentTimeMillis());

    @Test
    public void insert() throws Exception {
        // given
        NoticeDto noticeDto = new NoticeDto("정석코딩9기", "정석코딩9기 모집", 0, now, "Y", "N", "admin", now, "JISOO", now, "JISOO");
        System.out.println("noticeDto => " + noticeDto);

        // when
        int result = noticeDao.insert(noticeDto);

        // then
        assertTrue(1 == result);

        System.out.println("noticeDto => " + noticeDto);
    }
    @Test
    public void selectAllCnt() throws Exception {
        // given
        List<NoticeDto> list = null;
        String keyword = "";
        list = noticeDao.selectAll();
        int listSize = list.size();

        // when
        int vertifyCnt = noticeDao.count(keyword);

        // then
        assertTrue(listSize == vertifyCnt);
    }
    @Test
    public void updateViewCnt() throws Exception{

        // given
        NoticeDto noticeDto = new NoticeDto("정석코딩9기", "정석코딩9기 모집", 0, now, "Y", "N", "admin", now, "JISOO", now, "JISOO");
        System.out.println("noticeDto => " + noticeDto);

        // when
        int result = noticeDao.insert(noticeDto);
        noticeDto = noticeDao.select(noticeDto.getNotice_seq());
        System.out.println("noticeDto => " + noticeDto);

        noticeDao.addViewCnt(noticeDto.getNotice_seq());
        noticeDto = noticeDao.select(noticeDto.getNotice_seq());

        // then -> 검증하는 절차
        assertTrue(1 == result);
        assertTrue(1 == noticeDto.getNotice_view_cnt());
    }
}