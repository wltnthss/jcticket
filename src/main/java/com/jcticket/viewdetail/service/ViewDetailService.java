package com.jcticket.viewdetail.service;

import com.jcticket.viewdetail.dto.JoinDto;
import com.jcticket.viewdetail.dto.ReviewDto;
import com.jcticket.viewdetail.dto.ShowingDto;

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
    List<ShowingDto> getShowingInfo(String dateText, String play_id) throws Exception;

    int getRemainSeat(String showing_seq) throws Exception;

    List<JoinDto> getViewDetail(String play_id) throws Exception;

    Map<String, List<String>> getViewDetailTime(String play_id) throws Exception;


    int get_review_count(String play_id) throws Exception;

    int review_deleteAll() throws Exception;

    int review_delete(int review_num, String user_id) throws Exception;

    int review_create(ReviewDto reviewDto) throws Exception;

    int review_increaseViewCnt(int review_num) throws Exception;

    int review_update(ReviewDto reviewDto) throws Exception;

    List<ReviewDto> review_select_all(String play_id) throws Exception;

    List<ReviewDto> review_select_limit(Map map) throws Exception;

    List<ReviewDto> review_select(String play_id) throws Exception;

    //질문
    List<String> viewing_at(Map map) throws Exception;

    List<String> view_time_info(String play_id) throws Exception;
}
