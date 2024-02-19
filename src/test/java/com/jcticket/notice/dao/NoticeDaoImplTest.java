package com.jcticket.notice.dao;

import com.jcticket.notice.dto.NoticeDto;
import com.jcticket.notice.dto.PageDto;
import com.jcticket.notice.service.NoticeService;
import org.junit.Before;
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

    // DTO timestamp 데이터 삽입 테스트용
    final static Timestamp NOW = new Timestamp(System.currentTimeMillis());
    // count keyword null 테스트용
    final static String KEYWORD = "";

    // 각 테스트 케이스 실행전 공지사항 전체 삭제 -> before는 테스트케이스 안에 넣는 것이 명확하기 때문에 메서드 안에서 사용하자.
    @Before
    public void init() throws Exception{
        System.out.println("init DELETE ALL");
        noticeDao.deleteAll();
    }

    @Test
    public void insert() throws Exception {
        // given
        int result = 0;
        for (int i = 1; i < 112; i++) {
            NoticeDto noticeDto = new NoticeDto("정석코딩"+i+"기", "정석코딩"+i+"기 모집", 0, NOW, "Y", "N", "admin", NOW, "JISOO", NOW, "JISOO");

            // when
            result = noticeDao.insert(noticeDto);
            assertTrue(1 == result);
        }
        // then
        assertTrue(noticeDao.count(KEYWORD) == 111);
    }
    @Test
    public void selectAllCnt() throws Exception {
        // given
        NoticeDto noticeDto = new NoticeDto("정석코딩9기", "정석코딩9기 모집합니다", 0, NOW, "Y", "N", "admin", NOW, "JISOO", NOW, "JISOO");
        int insertResult = noticeDao.insert(noticeDto);

        // when
        List<NoticeDto> list = noticeDao.selectAll();
        int vertifyCnt = noticeDao.count(KEYWORD);

        // then
        assertTrue(insertResult==1);
        assertTrue(list.size() == vertifyCnt);
    }
    @Test
    public void updateViewCnt() throws Exception{

        // given
        NoticeDto noticeDto = new NoticeDto("정석코딩9기", "정석코딩9기 모집", 0, NOW, "Y", "N", "admin", NOW, "JISOO", NOW, "JISOO");

        // when
        int insertRslt = noticeDao.insert(noticeDto);
        noticeDto = noticeDao.select(noticeDto.getNotice_seq());

        noticeDao.addViewCnt(noticeDto.getNotice_seq());
        noticeDto = noticeDao.select(noticeDto.getNotice_seq());

        // then
        assertTrue(1 == insertRslt);
        assertTrue(1 == noticeDto.getNotice_view_cnt());
    }
}