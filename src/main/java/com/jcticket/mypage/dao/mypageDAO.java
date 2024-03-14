package com.jcticket.mypage.dao;

import com.jcticket.admin.dto.CouponDto;
import com.jcticket.dto.UserCouponDto;
import com.jcticket.payment.dto.PaymentDto;
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
    List<TicketingDto> selectLimit_img(Map map) throws  Exception;

    List<TicketingDto> select_list() throws Exception;
    List<TicketingDto> select_view(Map map) throws Exception;
    List<UserCouponDto> coupon_list(Map map) throws Exception;
    int insert(TicketingDto ticketingDto)  throws Exception;
    int insert_InquiryDto(InquiryDto inquiryDto) throws Exception;
    
    TicketingDto ticket_detail(String ticketing_at) throws Exception;


    
    //유저 관련
    
    UserDto user_info(String id) throws Exception;

    int user_update(UserDto userDto) throws Exception;
    int ticket_cancel(String ticket_id) throws Exception;

    int withdraw(UserDto userDto) throws Exception;

    
    
//    쿠폰 관련 
    int coupon_update() throws Exception;

    int update_coupon(CouponDto CouponDto) throws Exception;

    int coupon_insert(UserCouponDto userCouponDto) throws Exception;
    int coupon_count(Map map) throws Exception;
    int possible_coupon(String user_id) throws Exception;
    int impossible_coupon(String user_id) throws Exception;
    CouponDto coupon_select(String coupon_id) throws Exception;
    UserCouponDto coupon_amount(String coupon_id) throws Exception;
    CouponDto coupon_discount(String coupon_id) throws Exception;

    
//   페이먼트 관련

    PaymentDto user_payment(String user_id) throws Exception;

}
