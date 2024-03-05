package com.jcticket.viewdetail.dao;

import com.jcticket.viewdetail.dto.JoinDto;
import com.jcticket.viewdetail.dto.ReviewDto;
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
 * fileName       : ViewDetailReviewBoardTest
 * author         : sungjun
 * date           : 2024-02-17
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-17        kyd54       최초 생성
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ViewDetailReviewBoardTest {
    @Autowired
    ViewDetailDao viewDetailDao;

    Timestamp now = new Timestamp(System.currentTimeMillis());

//    게시글 수 카운트 테스트, 글 전체 삭제 테스트
    @Test
    public void review_deleteAll() throws Exception {
        viewDetailDao.review_deleteAll();
        assertTrue(viewDetailDao.review_count("공연아이디1")==0);
    }
    
//    리뷰 생성 테스트
    @Test
    public void review_insert() throws Exception {
        for(int i=0;i<255;i++) {
            //랜덤으로 평점주기
            int random_rating = ((int)(Math.random()*5)+1);
            int cnt = viewDetailDao.review_count("공연아이디1");
            System.out.println("cnt" +
                    " = " + cnt);

            ReviewDto reviewDto = new ReviewDto(1+i,now,random_rating,"2024-02-28","꿀잼"+i,0,"test123","공연아이디1",now,"test123",now,"test123", (double) random_rating /cnt,cnt);
            viewDetailDao.review_insert(reviewDto);
        }
    }

//    하나씩 제거 테스트
//    @Test
//    public void review_delete() throws Exception {
//        int review_cnt = viewDetailDao.review_count();
//
//        System.out.println("review_cnt =>" + review_cnt);
//
//        for(int i=review_cnt;i>0;i--){
//            int review_num = i+i;
//            String user_id = "test123";
//            viewDetailDao.review_delete(review_num, user_id);
//        }
//
//        review_cnt = viewDetailDao.review_count();
//
//        assertTrue(review_cnt==50);
//    }

    //조회수 테스트
//    @Test
//    public void review_increaseViewCnt() throws Exception {
//        int review_num = 1;
//        int result = viewDetailDao.review_increaseViewCnt(review_num);
//
//        assertTrue(result == 1);
//    }

//    리뷰 수정 테스트
    @Test
    public void review_update() throws Exception {
        int review_num = 1;

        int random_rating = ((int)(Math.random()*5)+1);
        int cnt = viewDetailDao.review_count("공연아이디1");

//        1번 리뷰의 내용 변경
        ReviewDto update_data = new ReviewDto(review_num,now,5,"2024-02-28","꿀잼입니다요",0,"test123","공연아이디1",now,"test123",now,"test123",(double) random_rating /cnt,cnt);

        System.out.println("update_data =>" + update_data);
    }
}