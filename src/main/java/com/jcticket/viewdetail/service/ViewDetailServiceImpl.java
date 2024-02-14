package com.jcticket.viewdetail.service;

import com.jcticket.viewdetail.dao.ViewDetailDao;
import com.jcticket.viewdetail.dto.JoinDto;
import com.jcticket.viewdetail.dto.ShowingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

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
        return viewDetailDao.viewDetail(play_id);
    }

    @Override
    public List<ShowingDto> getViewShowingInfo(String play_id) throws Exception {
        return viewDetailDao.view_showing_info(play_id);
    }
}
