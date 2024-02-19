package com.jcticket.viewdetail.service;

import com.jcticket.viewdetail.dao.ViewDetailDao;
import com.jcticket.viewdetail.dto.JoinDto;
import com.jcticket.viewdetail.dto.ReviewDto;
import com.jcticket.viewdetail.dto.ShowingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * packageName    : com.jcticket.viewdetail.service
 * fileName       : ViewDetailServiceImpl
 * author         : sungjun
 * date           : 2024-02-06
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-06        kyd54       최초 생성
 */

@Service
public class ViewDetailServiceImpl implements ViewDetailService{
    @Autowired
    ViewDetailDao viewDetailDao;

    public List<ShowingDto> getShowingInfo(String dateText) throws Exception {
        return viewDetailDao.select_showing_info(dateText);
    }

    public int getRemainSeat(String showing_seq) throws Exception {

        return viewDetailDao.remain_seat(showing_seq);
    }

    @Override
    public List<JoinDto> getViewDetail(String play_id) throws Exception {
        return viewDetailDao.viewDetail_view(play_id);
    }

    @Override
    public List<ShowingDto> getViewDetailTime(String play_id) throws Exception {
        return viewDetailDao.viewDetail_view_time(play_id);
    }

    @Override
    public int get_review_count() throws Exception {
        return viewDetailDao.review_count();
    }

    @Override
    public int review_deleteAll() throws Exception {
        return viewDetailDao.review_deleteAll();
    }

    @Override
    public int review_delete(int review_num, String user_id) throws Exception {
        return viewDetailDao.review_delete(review_num,user_id);
    }

    @Override
    public int review_create(ReviewDto reviewDto) throws Exception {
        return viewDetailDao.review_insert(reviewDto);
    }

    @Override
    public int review_increaseViewCnt(int review_num) throws Exception {
        return viewDetailDao.review_increaseViewCnt(review_num);
    }

    @Override
    public int review_update(ReviewDto reviewDto) throws Exception {
        return viewDetailDao.review_update(reviewDto);
    }

    @Override
    public List<ReviewDto> review_select_all(String play_id) throws Exception {
        return viewDetailDao.review_select_all(play_id);
    }

    @Override
    public List<ReviewDto> review_select(int review_num) throws Exception {
        return viewDetailDao.review_select(review_num);
    }

    @Override
    public List<ReviewDto> review_select_page(Map map) throws Exception {
        return viewDetailDao.review_select_page(map);
    }
}
