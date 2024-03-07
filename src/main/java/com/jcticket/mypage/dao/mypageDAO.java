package com.jcticket.mypage.dao;

import com.jcticket.admin.dto.CouponDto;
import com.jcticket.mypage.dto.UserCouponDto;
import com.jcticket.ticketing.dto.TicketingDto;
import com.jcticket.mypage.dto.InquiryDto;
import com.jcticket.user.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * packageName    : com.jcticket.mypage.dao
 * fileName       : mypageDAO
 * author         : JJS
 * date           : 2024-02-10
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-10        JJS       최초 생성
 */

@Repository
public interface mypageDAO {

    int count(Map map) throws Exception;
    int view_count(Map map) throws Exception;
    List<TicketingDto> selectAll(Map map) throws  Exception;
    List<TicketingDto> selectLimit(Map map) throws  Exception;

    List<TicketingDto> select_list() throws Exception;
    List<TicketingDto> select_view(Map map) throws Exception;
    List<UserCouponDto> coupon_list(Map map) throws Exception;
    int insert(TicketingDto ticketingDto)  throws Exception;
    int insert_InquiryDto(InquiryDto inquiryDto) throws Exception;
    int coupon_insert(UserCouponDto userCouponDto) throws Exception;
    int coupon_count(Map map) throws Exception;
    CouponDto coupon_select(String coupon_id) throws Exception;

    UserDto user_info(String id) throws Exception;


    TicketingDto ticket_detail(String ticketing_at) throws Exception;

    int update_coupon(CouponDto CouponDto) throws Exception;
    int user_update(UserDto userDto) throws Exception;

    int coupon_update() throws Exception;


}
