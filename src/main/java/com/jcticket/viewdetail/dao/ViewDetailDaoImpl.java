package com.jcticket.viewdetail.dao;

import com.jcticket.admin.dto.PlayDto;
import com.jcticket.viewdetail.dto.*;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * packageName    : com.jcticket.viewdetail.dao
 * fileName       : ViewDetailDaoImpl
 * author         : sungjun
 * date           : 2024-02-06
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-06        kyd54       최초 생성
 */
@Repository
public class ViewDetailDaoImpl implements ViewDetailDao{
    @Autowired
    private SqlSession session;

    private static String namespace="com.jcticket.viewdetail.viewdetailMapper.";

    //공연테이블 인서트
    @Override
    public int play_insert(PlayDto playDto) throws Exception {
        return session.insert(namespace + "play_insert", playDto);
    }

    //화차테이블 인서트
    @Override
    public int showing_insert(ShowingDto showingDto) throws Exception {
        return session.insert(namespace + "showing_insert", showingDto);
    }

    //좌석테이블 인서트
    @Override
    public int seat_class_insert(SeatClassDto seatClassDto) throws Exception {
        return session.insert(namespace + "seat_class_insert", seatClassDto);
    }

    //Delete All
    @Override
    public int play_delete_all() throws Exception {
        return session.delete(namespace + "play_delete_all");
    }
    @Override
    public int showing_delete_all() throws Exception {
        return session.delete(namespace + "showing_delete_all");
    }
    @Override
    public int seat_class_delete_all() throws Exception {
        return session.delete(namespace + "seat_class_delete_all");
    }

//    테스트용 delete
    @Override
    public int test_delete_play() throws Exception {
        return session.delete(namespace + "test_delete_play");
    }
    @Override
    public int test_delete_showing() throws Exception {
        return session.delete(namespace + "test_delete_showing");
    }
    @Override
    public int test_delete_seat_class() throws Exception {
        return session.delete(namespace + "test_delete_seat_class");
    }

    //공연회차정보,시퀀스 조회 (dateText는 달력에서 선택한 날짜)
    @Override
    public List<ShowingDto> select_showing_info(String dateText, String play_id) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("dateText", dateText);
        params.put("play_id", play_id);

        return session.selectList(namespace + "select_showing_info", params);
    }

//    잔여석 조회(공연회차정보, 시퀀스 조회에서 받은 시퀀스를 가지고 잔여석 조회)
    @Override
    public int remain_seat(String showing_seq) throws Exception {
        return session.selectOne(namespace + "remain_seat", showing_seq);
    }

//    공연(play),좌석구분(seat_class),공연장(stage) 테이블 합침 view에서 보여주는 정보들
    @Override
    public List<JoinDto> viewDetail_view(String play_id) throws Exception {
        return session.selectList(namespace + "viewDetail_view", play_id);
    }

//    회차(showing)테이블 view에서 보여주는 정보들(날짜, 시간)
    @Override
    public List<ShowingDto> viewDetail_view_time(String play_id) throws Exception {
        return session.selectList(namespace + "viewDetail_view_time", play_id);
    }


    //-----------------------------------------------------------------------------------
//    후기게시판
    @Override
    public int review_count(String play_id) throws Exception {
        return session.selectOne(namespace + "review_count", play_id);
    }

    @Override
    public int review_deleteAll() throws Exception {
        return session.delete(namespace + "review_deleteAll");
    }

    @Override
    public int review_delete(int review_num, String user_id) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("review_num", review_num);
        params.put("user_id", user_id);
        return session.delete(namespace + "review_delete", params);
    }

    @Override
    public int review_insert(ReviewDto reviewDto) throws Exception {
        return session.insert(namespace + "review_insert", reviewDto);
    }

    @Override
    public int review_increaseViewCnt(int review_num) throws Exception {
        return session.update(namespace + "review_increaseViewCnt", review_num);
    }

    @Override
    public int review_update(ReviewDto reviewDto) throws Exception {
        return session.update(namespace + "review_update", reviewDto);
    }

    @Override
    public List<ReviewDto> review_select_all(String play_id) throws Exception {
        return session.selectList(namespace + "review_select_all", play_id);
    }

    @Override
    public List<ReviewDto> review_select_limit(Map map) throws Exception {
        return session.selectList(namespace + "review_select_limit", map);
    }

    @Override
    public List<ReviewDto> review_select(String play_id) throws Exception {
        return session.selectList(namespace + "review_select", play_id);
    }

    @Override
    public List<String> review_viewing_at(String play_id) throws Exception {
        return session.selectList(namespace + "review_viewing_at", play_id);
    }


}
