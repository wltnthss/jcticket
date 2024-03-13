package com.jcticket.mypage.service;

import com.jcticket.admin.dto.CouponDto;
import com.jcticket.mypage.dao.mypageDAO;
import com.jcticket.mypage.dto.MyUserCouponDto;
import com.jcticket.ticketing.dto.TicketingDto;
import com.jcticket.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

/**
 * packageName    : com.jcticket.mypage.service
 * fileName       : MyServiceImpl
 * author         : JJS
 * date           : 2024-02-10
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-10        JJS       최초 생성
 */


@Service
public class MyServiceImpl implements mypageService {

    @Autowired
    mypageDAO mypageDAO;

    @Override
    public Integer count(Map map) throws Exception {
        return mypageDAO.count(map);
    }

    @Override
    public Integer coupon_count(Map map) throws Exception {
        return mypageDAO.coupon_count(map);
    }

    @Override
    public Integer view_count(Map map) throws Exception {
        return mypageDAO.view_count(map);
    }


    @Override
    public Integer coupon_insert(MyUserCouponDto userCouponDto) throws Exception {
        return mypageDAO.coupon_insert(userCouponDto);
    }

    @Override
    public CouponDto coupon_select(String coupon_id) throws Exception {
        return mypageDAO.coupon_select(coupon_id);
    }

    @Override
    public List<TicketingDto> selectAll(Map map) throws Exception {
        return mypageDAO.selectAll(map);
    }

    @Override
    public List<MyUserCouponDto> coupon_list(Map map) throws Exception {
        return mypageDAO.coupon_list(map);
    }

    @Override
    public List<TicketingDto> select_list() throws Exception {
        return mypageDAO.select_list();
    }

    @Override
    public List<TicketingDto> selectLimit(Map map) throws Exception {
        return mypageDAO.selectLimit(map);
    }
    @Override
    public List<TicketingDto> select_view(Map map) throws Exception {
        return mypageDAO.select_view(map);
    }
    @Override
    public TicketingDto ticket_detail(String ticketing_id) throws Exception {
        return mypageDAO.ticket_detail(ticketing_id);
    }

    @Override
    public UserDto user_info(String id) throws Exception {
        return mypageDAO.user_info(id);
    }


    @Override
    public Integer update_coupon(CouponDto couponDto) throws Exception {
        return mypageDAO.update_coupon(couponDto);
    }

    @Override
    public Integer withdraw(UserDto userDto) throws Exception {
        return mypageDAO.withdraw(userDto);
    }

    @Override
    public Integer ticket_cancel(String ticket_id) throws Exception {
        return mypageDAO.ticket_cancel(ticket_id);
    }

    @Override
    public Integer coupon_update() throws Exception {
        return mypageDAO.coupon_update();
    }

    @Override
    public Integer user_update(UserDto userDto) throws Exception {
        return mypageDAO.user_update(userDto);
    }



}
