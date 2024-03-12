package com.jcticket.payment.dao;

import com.jcticket.admin.dto.ShowSeatDto;
import com.jcticket.payment.dto.PaymentDto;
import com.jcticket.payment.dto.UserPayDto;
import org.springframework.stereotype.Repository;

/**
 * packageName    : com.jcticket.payment.dao
 * fileName       : PaymentDao
 * author         : 조영상
 * date           : 1/31/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 1/31/24         조영상        최초 생성
 */

public interface PaymentDao {
    int insertPayment(PaymentDto dto) throws Exception;

    int updateSeatStatusN(ShowSeatDto dto) throws Exception;

    int updateUserCouponStatusY(String user_coupon_id) throws Exception;

    // ticketing table delete
    int deleteTicketing(String ticketing_id) throws Exception;

    UserPayDto selectUserInfo(String user_id) throws Exception;
    int updatePaymentStatusF(String paymentId) throws Exception;

    String selectedSeats(String ticketing_id) throws Exception;
}
