package com.jcticket.viewdetail.service;

import com.jcticket.viewdetail.dto.JoinDto;
import com.jcticket.viewdetail.dto.ReviewDto;
import com.jcticket.viewdetail.dto.ShowingDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * packageName    : com.jcticket.viewdetail.service
 * fileName       : ViewDetailService
 * author         : sungjun
 * date           : 2024-02-06
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-06        kyd54       최초 생성
 */

public interface ViewDetailService {
    List<ShowingDto> getShowingInfo(String dateText) throws Exception;

    int getRemainSeat(String showing_seq) throws Exception;

    List<JoinDto> getViewDetail(String play_id) throws Exception;

    List<ShowingDto> getViewDetailTime(String play_id) throws Exception;


    int get_review_count() throws Exception;

    int review_deleteAll() throws Exception;

    int review_delete(int review_num, String user_id) throws Exception;

    int review_create(ReviewDto reviewDto) throws Exception;

    int review_increaseViewCnt(int review_num) throws Exception;

    int review_update(ReviewDto reviewDto) throws Exception;

    List<ReviewDto> review_select_all(String play_id) throws Exception;

    List<ReviewDto> review_select(int review_num) throws Exception;

    List<ReviewDto> review_select_page(Map map) throws Exception;
}
