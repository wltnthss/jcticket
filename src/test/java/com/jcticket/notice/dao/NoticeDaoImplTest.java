package com.jcticket.notice.dao;

import com.jcticket.notice.dto.NoticeDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

    @Test
    public void test() throws Exception {
        System.out.println("noticeDao.test() => " + noticeDao.test());
    }

    @Test
    public void selectAllTest() throws Exception {
        System.out.println("noticeDao selectAll => " + noticeDao.list());
        assertTrue(noticeDao.list().size() == 12);
    }

    @Test
    public void selectTest() throws Exception {

        int no = noticeDao.list().get(0).getNotice_seq();
        System.out.println("no => " + no);
        System.out.println("notice select => " + noticeDao.select(no));

        // 현재시간 형변환
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        NoticeDto noticeDto;
        noticeDto = new NoticeDto(1, "제목test", "내용test", 0, currentTimestamp, "Y", "N", "admin1", currentTimestamp , "system", currentTimestamp, "system");
        System.out.println("noticeDto 객체 생성 => " + noticeDto);

        assertTrue(noticeDto.getNotice_title().equals("제목test"));
    }

    @Test
    public void countTest() throws Exception {
        System.out.println("countTest => " + noticeDao.count());

        int listSize = noticeDao.list().size();
        System.out.println("listSize => " + listSize);

        int count = noticeDao.count();

        assertTrue(listSize == count);
    }

    @Test
    public void updateViewCnt() throws Exception{

        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        NoticeDto noticeDto = new NoticeDto(1, "제목test", "내용test", 0, currentTimestamp, "Y", "N", "admin1", currentTimestamp , "system", currentTimestamp, "system");
        System.out.println("noticeDto1 => "  + noticeDto);

        System.out.println("noticeDto => " + noticeDto.toString());
        System.out.println("noticeDto.getNotice_seq() => " + noticeDto.getNotice_seq());

        int increaseOneViewCnt = noticeDao.addViewCnt(noticeDto.getNotice_seq());
        assertTrue(increaseOneViewCnt == 1);


    }
}