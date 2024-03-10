package com.jcticket.payment.dao;

import com.jcticket.payment.dto.PaymentDto;
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

    int updatePaymentStatusF(String paymentId) throws Exception;
}
