package com.jcticket.payment.dao;

import com.jcticket.payment.dto.PaymentDto;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * packageName    : com.jcticket.payment.dao
 * fileName       : PaymentDaoImpl
 * author         : 조영상
 * date           : 3/10/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/10/24         조영상        최초 생성
 */
@Repository
@RequiredArgsConstructor
public class PaymentDaoImpl implements PaymentDao{
    private final SqlSession session;

    public final String namespace = "PaymentMapper.";


    // 결제 테이블 삽입
    @Override
    public int insertPayment(PaymentDto dto) throws Exception {
        return session.insert(namespace + "insertPayment", dto);
    }


    // 결제테이블의 결제상태 실패로 변경
    @Override
    public int updatePaymentStatusF(String paymentId) throws Exception {
        return session.update(namespace + "updatePaymentStatusFail", paymentId);
    }
}
