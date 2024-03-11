package com.jcticket.mypage.service;

import com.jcticket.admin.dto.CouponDto;
import com.jcticket.mypage.dto.MyUserCouponDto;
import com.jcticket.ticketing.dto.TicketingDto;
import com.jcticket.user.dto.UserDto;

import java.util.List;
import java.util.Map;

/**
 * packageName    : com.jcticket.mypage.service
 * fileName       : mypageService
 * author         : JJS
 * date           : 2024-02-10
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-10        JJS       최초 생성
 */
public interface mypageService {
    Integer count(Map map) throws Exception;
    Integer coupon_count(Map map) throws Exception;
    Integer view_count(Map map) throws Exception;
    Integer coupon_insert(MyUserCouponDto userCouponDto) throws Exception;
    CouponDto coupon_select(String coupon_id) throws Exception;
    List<TicketingDto> selectAll(Map map) throws Exception;
    List<MyUserCouponDto> coupon_list(Map map) throws Exception;
    List<TicketingDto> select_list() throws Exception;
    List<TicketingDto> selectLimit(Map map) throws Exception;
    List<TicketingDto> select_view(Map map) throws Exception;
    TicketingDto ticket_detail(String ticketing_id) throws Exception;

    UserDto user_info(String id) throws Exception;
    Integer update_coupon (CouponDto couponDto) throws Exception;
    Integer withdraw (UserDto userDto) throws Exception;
    Integer ticket_cancel (String ticket_id) throws Exception;

    Integer coupon_update () throws Exception;
    Integer user_update (UserDto userDto) throws Exception;

}
