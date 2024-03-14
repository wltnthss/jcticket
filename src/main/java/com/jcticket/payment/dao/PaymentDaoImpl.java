package com.jcticket.payment.dao;

import com.jcticket.admin.dto.ShowSeatDto;
import com.jcticket.payment.dto.PaymentDto;
import com.jcticket.payment.dto.UserPayDto;
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

    // 결제 완료 후 회차-좌석 테이블 상태 업데이트
    @Override
    public int updateSeatStatusN(ShowSeatDto dto) throws Exception {
        return session.update(namespace + "updateSeatStatusN", dto);
    }

    // 결제 완료 후 사용된 유저-쿠폰 테이블 사용여부, 사용일자 업데이트
    @Override
    public int updateUserCouponStatusY(String user_coupon_id) throws Exception {
        return session.update(namespace + "updateUserCouponStatusY", user_coupon_id);
    }


    // 결제 과정에서 결제 실패시 예매되었던 테이블에 해당 ticketing_id delete!
    @Override
    public int deleteTicketing(String ticketing_id) throws Exception {
        return session.delete(namespace + "deleteTicketing",ticketing_id);
    }

    // 결제테이블의 결제상태 실패로 변경
    @Override
    public int updatePaymentStatusF(String paymentId) throws Exception {
        return session.update(namespace + "updatePaymentStatusFail", paymentId);
    }

//    <!-- 유저아이디로 유저이름, 이메일, 연락처, 주소 가져오기 -->
    @Override
    public UserPayDto selectUserInfo(String user_id) throws Exception {
        return session.selectOne(namespace + "selectUserInfo",user_id);
    }

    // 예매 아이디로 선택된 좌석 리스트 (문자열) 가져오기
    @Override
    public String selectedSeats(String ticketing_id) throws Exception {
        return session.selectOne(namespace + "selectedSeats", ticketing_id);
    }
}
