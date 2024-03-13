package com.jcticket.payment.service;

import com.jcticket.admin.dto.ShowSeatDto;
import com.jcticket.payment.dao.PaymentDao;
import com.jcticket.payment.dto.PaymentDto;
import com.jcticket.payment.dto.PaymentRequestDto;
import com.jcticket.payment.dto.UserPayDto;
import com.jcticket.ticketing.dto.TicketingRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * packageName    : com.jcticket.payment.service
 * fileName       : PaymentServiceImpl
 * author         : 조영상
 * date           : 3/13/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/13/24         조영상        최초 생성
 */

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{

    private final PaymentDao paymentDao;

    // 결제성공시 Payment 테이블 Insert
    @Override
    public int createPayment(PaymentRequestDto requestDto) throws Exception {
        // 결제번호 생성하기
        UUID uuid = UUID.randomUUID();
        String paymentId = uuid.toString().replace("-","").substring(0, 8);
        System.out.println("결제ID 생성 >> "+ paymentId);

        //API 에서 받은 결제승인시각 UNIX Timestamp --> Timestamp 로 변환하기
        String unixTimeStamp = requestDto.getPaid_at();
        long timestamp = Long.parseLong(unixTimeStamp);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(timestamp * 1000);
        String paidAt = sdf.format(date);
        //String userId = paymentDao.selectUserByTicketingId(requestDto.getMerchant_uid());
        Timestamp CUR_TS = new Timestamp(System.currentTimeMillis());
        // 결제 테이블 DTO 빌드
        PaymentDto dto = PaymentDto.builder()
                .payment_id(paymentId)
                .payment_approval_id(requestDto.getPg_tid())
                .payment_amount(requestDto.getPaid_amount())
                .payment_at(paidAt)
                .payment_method(requestDto.getPay_method())
                .payment_status(requestDto.getStatus())
                .receipt_url(requestDto.getReceipt_url())
                .ticketing_id(requestDto.getMerchant_uid())
                .user_id(requestDto.getBuyer_name())
//                .created_id("sys")
//                .updated_id("sys")
//                .created_at(CUR_TS)
//                .updated_at(CUR_TS)
                .build();
        System.out.println("==========>"+dto.toString());
        return paymentDao.insertPayment(dto);
    }

    // 결제 성공시 show_seat 테이블과 user_coupon 테이블의 각각 상태를 업데이트하는 서비스:
    //  (파라미터로 한번에 두 개의 Dao에서 필요한 값들을 받는다)
    @Override
    public String setBookingStatus(String ticketingId, String userCouponId, int showingSeq) throws Exception {
        try{
            String seats = paymentDao.selectedSeats(ticketingId);
            String[] seatArr = seats.split(",");
            for(String seat : seatArr){
                String seatRow = String.valueOf(seat.charAt(0));
                int seatCol = Integer.parseInt(seat.substring(1));
                ShowSeatDto ssDto = ShowSeatDto.builder()
                        .showing_seq(showingSeq)
                        .seat_row(seatRow)
                        .seat_col(seatCol)
                        .build();
                paymentDao.updateSeatStatusN(ssDto);
                System.out.println("좌석의 행: " + seatRow + ", 좌석의 열: " + seatCol);
            }
            paymentDao.updateUserCouponStatusY(userCouponId);
            return "success";
        }catch (Exception e){
            return "fail";
        }

    }

    // 결제 or 결제 사전검증 실패시 만들어진 ticketing DB 삭제
    @Override
    public String removeTicketing(String ticketingId) throws Exception {
        try{
            int res = paymentDao.deleteTicketing(ticketingId);
            if(res == 1){
                System.out.println("<<삭제완료>>");
            }
        }catch (Exception e){
            return e.getMessage();
        }
        return ticketingId+" delete success";
    }

    @Override
    public UserPayDto getUserInfo(String userId) throws Exception {
        return paymentDao.selectUserInfo(userId);
    }
}
