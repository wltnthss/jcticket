package com.jcticket.viewdetail.dao;

import com.jcticket.viewdetail.dto.JoinDto;
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
    public List<ShowingDto> select_showing_info(String dateText) throws Exception {
        return session.selectList(namespace + "select_showing_info", dateText);
    }

    @Override
    public int remain_seat(String showing_seq) throws Exception {
        return session.selectOne(namespace + "remain_seat", showing_seq);
    }

    @Override
    public List<JoinDto> viewDetail(String play_id) throws Exception {
        return session.selectList(namespace + "viewDetail", play_id);
    }

    @Override
    public List<ShowingDto> view_showing_info(String play_id) throws Exception {
        return session.selectList(namespace + "view_showing_info", play_id);
    }
}
