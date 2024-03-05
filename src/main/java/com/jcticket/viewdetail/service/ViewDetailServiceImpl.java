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

    public List<ShowingDto> getShowingInfo(String dateText, String play_id) throws Exception {
        return viewDetailDao.select_showing_info(dateText,play_id);
    }

    public int getRemainSeat(String showing_seq) throws Exception {
        return viewDetailDao.remain_seat(showing_seq);
    }

    @Override
    public List<JoinDto> getViewDetail(String play_id) throws Exception {
        List<JoinDto> joinDtoList = viewDetailDao.viewDetail_view(play_id);
        // 포맷팅 수행
        for (JoinDto joinDto : joinDtoList) {
            joinDto.format_seat_price();
        }
        return joinDtoList;
        //showing_seat_price(30000) >>>> seat_price(30,000) 포맷팅
    }

    @Override
    public Map<String, List<String>> getViewDetailTime(String play_id) throws Exception {
        //showing_date 중복제거 할 것
        List<ShowingDto> showingDtoList = viewDetailDao.viewDetail_view_time(play_id);

        Map<String, List<String>> viewDetailTimeMap = new HashMap<>();

        Set<String> showing_date_set = new HashSet<>();

        for (ShowingDto dto : showingDtoList) {
            String showing_date = dto.getShowing_date();
            String showing_info = dto.getShowing_info();

            showing_date_set.add(showing_date);

            // 이미 해당 날짜에 대한 정보가 맵에 있는지 확인 후 추가
            if (!viewDetailTimeMap.containsKey(showing_date)) {
                viewDetailTimeMap.put(showing_date, new ArrayList<>());
            }
            viewDetailTimeMap.get(showing_date).add(showing_info);
        }

        return viewDetailTimeMap;
    }

    @Override
    public int get_review_count(String play_id) throws Exception {
        return viewDetailDao.review_count(play_id);
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
    public List<ReviewDto> review_select_limit(Map map) throws Exception {
        return viewDetailDao.review_select_limit(map);
    }

    @Override
    public List<ReviewDto> review_select(String play_id) throws Exception {
        List<ReviewDto> review = viewDetailDao.review_select(play_id);
        int cnt = viewDetailDao.review_count(play_id);

        for (ReviewDto dto : review) {
            double avg = dto.getReview_avg(); // 리뷰의 평균값 가져오기
            avg = Math.round(avg * 10) / 10.0; // 소수점 첫 번째 자리까지 반올림
            dto.setReview_avg(avg); // 반올림한 값을 다시 설정
            dto.setReview_count(cnt);
        }

        return review;
    }

    //질문
    @Override
    public List<String> viewing_at(Map map) throws Exception {
        return viewDetailDao.bring_review_viewing_at(map);
    }
}
