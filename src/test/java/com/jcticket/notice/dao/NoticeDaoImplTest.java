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

    @Before
    public void init() throws Exception{
        System.out.println("init DELETE ALL");
        noticeDao.deleteAll();
    }

    @Test
    public void insert() throws Exception {

        for (int i = 1; i < 12; i++) {

            // given
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

            // when
            noticeDao.insert(noticeDto);
        }
        // then
        assertEquals(11, noticeDao.count(KEYWORD));
    }
    @Test
    public void selectAllCnt() throws Exception {

        NoticeDto noticeDto = NoticeDto.builder()
                .notice_title("정석코딩13기")
                .notice_content("정석코딩13기 모집합니다.")
                .notice_reg_at(NOW)
                .notice_pin_yn("N")
                .notice_use_yn("Y")
                .admin_id("admin")
                .created_at(NOW)
                .created_id("SYSTEM")
                .updated_at(NOW)
                .update_id("SYSTEM")
                .build();

        // when
        int insertResult = noticeDao.insert(noticeDto);
        List<NoticeDto> list = noticeDao.selectAll();
        int vertifyCnt = noticeDao.count(KEYWORD);

        // then
        assertEquals(1, insertResult);
        assertEquals(list.size(), vertifyCnt);
    }
    @Test
    public void updateViewCnt() throws Exception{

        // given
        NoticeDto noticeDto = NoticeDto.builder()
                .notice_title("정석코딩13기")
                .notice_content("정석코딩13기 모집합니다.")
                .notice_reg_at(NOW)
                .notice_pin_yn("N")
                .notice_use_yn("Y")
                .admin_id("admin")
                .created_at(NOW)
                .created_id("SYSTEM")
                .updated_at(NOW)
                .update_id("SYSTEM")
                .build();

        // when
        int insertRslt = noticeDao.insert(noticeDto);
        noticeDto = noticeDao.select(noticeDto.getNotice_seq());

        noticeDao.addViewCnt(noticeDto.getNotice_seq());
        noticeDto = noticeDao.select(noticeDto.getNotice_seq());

        // then
        assertEquals(1, insertRslt);
        assertEquals(1, noticeDto.getNotice_view_cnt());
    }
}