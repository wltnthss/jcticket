package com.jcticket.ticketing.dao;

import com.jcticket.admin.dto.CouponDto;
import com.jcticket.admin.dto.ShowSeatDto;
import com.jcticket.dto.SeatDto;
import com.jcticket.dto.TicketingDto2;
import com.jcticket.mypage.dto.UserCouponDto;
import com.jcticket.ticketing.dto.TicketingDto;
import com.jcticket.viewdetail.dto.ShowingDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * packageName    : com.jcticket.ticketing.dao
 * fileName       : TicketDao
 * author         : 조영상
 * date           : 1/31/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 1/31/24         조영상        최초 생성
 */
public interface TicketingDao {

    // 삽입
    int insert(ShowingDto dto) throws Exception;

    // 공연아이디별 삭제
    int deleteByPlayId(String play_id) throws Exception;

    // 회차시퀀스별 삭제
    int deleteBySeq(int seq) throws Exception;

    // 전체 삭제
    int deleteAll() throws Exception;


    // 공연아이디별 회차 수 카운트
    int countByPlayId(String play_id) throws Exception;

    // 공연아이디별 조회
    List<ShowingDto> selectByPlayId(String play_id) throws Exception;

    // 공연아이디별 공연일정 조회
    List<Map<String, String>> selectDateByPlayId(String play_id) throws Exception;

    // 공연아이디 && 공연일정별로 회차시퀀스,회차정보 조회
    List<Map<String, Object>> selectRound(Map<String, String> map) throws Exception;

    // 공연아이디로 공연명과 공연표지, 공연장명 조회
    Map<String, Object> selectPlayStageName(String play_id) throws Exception;

    // 회차좌석테이블 삽입
    int insertShowSeat(ShowSeatDto dto) throws Exception;

    // 좌석테이블 삽입
    int insertSeat(SeatDto dto) throws Exception;

    // 좌석테이블 공연장Id 별로 삭제
    int deleteSeatByStageId(String stage_id) throws Exception;

    // 회차좌석테이블 삭제
    int deleteShowSeat() throws Exception;

    // 회차시퀀스로 회차좌석수 조회
    int selectSeatCnt(int showing_seq) throws Exception;

    // 회차시퀀스로 회차좌석가격 조회
    int selectPrice(int showing_seq) throws Exception;

    // 회차시퀀스로 좌석번호, 좌석상태리스트 조회
    List<Map<String, String>> selectSeatList(int showing_seq) throws Exception;

    // 회차시퀀스로 행, 열의 마지막 번호 구하기
    Map<String, Object> selectEndNum(int showing_seq) throws Exception;

    // 쿠폰 테이블 삽입
    int insertCoupon(CouponDto couponDto) throws Exception;

    // 쿠폰 테이블 삭제
    int deleteAllCoupon() throws Exception;

    // 유저-쿠폰 테이블 삽입
    int insertUserCoupon(UserCouponDto userCouponDto) throws Exception;

    // 유저-쿠폰 테이블 삭제
    int deleteAllUserCoupon() throws Exception;

    // 유저아이디로 유저-쿠폰 테이블에서 유저-쿠폰 아이디, 쿠폰아이디 리스트 조회
    List<UserCouponDto> selectUserCouponList(String user_id) throws Exception;

    // 쿠폰아이디로 쿠폰 테이블에서 쿠폰명, 쿠폰할인가격, 쿠폰사용조건, 쿠폰사용가능시작일, 쿠폰사용가능종료일 조회
    CouponDto selectCoupon(String coupon_id) throws Exception;

    // ticketing table insert
    int insertTicketing(TicketingDto2 dto) throws Exception;

    // ticketing table delete
    int deleteTicketing(String ticketing_id) throws Exception;

    // select User Name by user id
    String selectUserNameById(String user_id) throws Exception;

    int selectTicketingAmount(String ticketing_id) throws Exception;

    int updateSeatStatusN(ShowSeatDto dto) throws Exception;

    int updateUserCouponStatusY(String user_coupon_id) throws Exception;
}
