package com.jcticket.viewdetail.dao;

import com.jcticket.viewdetail.dto.JoinDto;
import com.jcticket.viewdetail.dto.PlayDto;
import com.jcticket.viewdetail.dto.SeatClassDto;
import com.jcticket.viewdetail.dto.ShowingDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * packageName    : com.jcticket.viewdetail.dao
 * fileName       : ViewDetailDaoTest
 * author         : sungjun
 * date           : 2024-02-11
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        kyd54       최초 생성
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ViewDetailDaoTest {

    @Autowired
    ViewDetailDao viewDetailDao;

    Timestamp now = new Timestamp(System.currentTimeMillis());

//    play테이블 insert, delete 테스트
    @Test
    public void play_insert() throws Exception {
//        쿼리 전부 제거
//        viewDetailDao.play_delete_all();

//        테스트용 딜리트
        viewDetailDao.test_delete_play();
        //given
        PlayDto playDto = new PlayDto("테스트1","<테스트>-테스트","poster","infoimg","콘서트","강연","SmallCategory",60,"1231",now,"1231",now,"1231");

        //when
        int insert = viewDetailDao.play_insert(playDto);

        //then
        assertTrue(1==insert);
    }

//    @Test
//    public void showing_insert() throws Exception {
////        쿼리 전부 제거
////        viewDetailDao.showing_delete_all();
////        테스트용 딜리트
//        viewDetailDao.test_delete_showing();
//        //given
//        ShowingDto showingDto = new ShowingDto(5,now,now,"1회 13시 00분","2024-03-15","금","BS",10,"테스트1","테스트공연장1",now,"최초등록자아이디1",now,"최종등록자아이디1");
//
//        //when
//        int insert = viewDetailDao.showing_insert(showingDto);
//
//        //then
//        assertTrue(1==insert);
//    }

    @Test
    public void seat_class_insert() throws Exception {
//        쿼리 전부 제거
//        viewDetailDao.seat_class_delete_all();

//        테스트용 딜리트
        viewDetailDao.test_delete_seat_class();
        //given
        SeatClassDto seatClassDto = new SeatClassDto(2,"300,000","테스트1",now,"최초등록자1",now,"최종등록자1");

        //when
        int insert = viewDetailDao.seat_class_insert(seatClassDto);

        //then
        assertTrue(1==insert);
    }

    @Test
    public void viewDetail() throws Exception {
        //given
        String test_play_id = "테스트1";
        //예상결과
        List<JoinDto> expected_result = new ArrayList<>();
        expected_result.add(new JoinDto("<테스트>-테스트","콘서트","강연",60,"poster","infoimg","1231","300,000","종각극장"));
        System.out.println("expected_result =>" + expected_result);

        //when
        List<JoinDto> list = viewDetailDao.viewDetail_view(test_play_id);
        System.out.println("list =>" + list);

        //then
        assertEquals(expected_result.size(), list.size());

        for (int i=0;i<expected_result.size(); i++) {
            assertEquals(expected_result.get(i), list.get(i));
        }
    }

//    테스트를 마친 후 테스트데이터 제거
//    @Test
//    public void testDelete() throws Exception {
//        //        테스트용 딜리트
//        viewDetailDao.test_delete_seat_class();
//        //        테스트용 딜리트
//        viewDetailDao.test_delete_showing();
//        //        테스트용 딜리트
//        viewDetailDao.test_delete_play();
//    }
}