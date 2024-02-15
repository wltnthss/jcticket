package com.jcticket.viewdetail.dao;

import com.jcticket.viewdetail.dto.JoinDto;
import com.jcticket.viewdetail.dto.PlayDto;
import com.jcticket.viewdetail.dto.SeatClassDto;
import com.jcticket.viewdetail.dto.ShowingDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public int play_insert(PlayDto playDto) throws Exception {
        return session.insert(namespace + "play_insert", playDto);
    }

    @Override
    public int showing_insert(ShowingDto showingDto) throws Exception {
        return session.insert(namespace + "showing_insert", showingDto);
    }

    @Override
    public int seat_class_insert(SeatClassDto seatClassDto) throws Exception {
        return session.insert(namespace + "seat_class_insert", seatClassDto);
    }

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

    @Override
    public List<ShowingDto> select_showing_info(String dateText) throws Exception {
        return session.selectList(namespace + "select_showing_info", dateText);
    }

    @Override
    public int remain_seat(String showing_seq) throws Exception {
        return session.selectOne(namespace + "remain_seat", showing_seq);
    }

    @Override
    public List<JoinDto> viewDetail_view(String play_id) throws Exception {
        return session.selectList(namespace + "viewDetail_view", play_id);
    }

    @Override
    public List<ShowingDto> viewDetail_view_time(String play_id) throws Exception {
        return session.selectList(namespace + "viewDetail_view_time", play_id);
    }
}
