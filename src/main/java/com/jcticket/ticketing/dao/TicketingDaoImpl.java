package com.jcticket.ticketing.dao;

import com.jcticket.admin.dto.CouponDto;
import com.jcticket.admin.dto.ShowSeatDto;
import com.jcticket.dto.SeatDto;
import com.jcticket.dto.UserCouponDto;
import com.jcticket.ticketing.dto.TicketingDto;
import com.jcticket.viewdetail.dto.ShowingDto;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * packageName    : com.jcticket.ticketing.dao
 * fileName       : TicketingDaoImpl
 * author         : 조영상
 * date           : 2/1/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/1/24         조영상        최초 생성
 */
@Repository
@RequiredArgsConstructor
public class TicketingDaoImpl implements TicketingDao {

    @Autowired
    private final SqlSession session;


    public final String namespace = "com.jcticket.ticketing.mybatis.mapper.ticketing.TicketingMapper.";

    // 삽입
    @Override
    public int insert(ShowingDto dto) throws Exception {
        return session.insert(namespace + "insert", dto);
    }

    // 공연아이디별 삭제
    @Override
    public int deleteByPlayId(String play_id) throws Exception {
        return session.delete(namespace + "deleteByPlayId", play_id);
    }


    // 회차 시퀀스별 삭제


    @Override
    public int deleteBySeq(int seq) throws Exception {
        return session.delete(namespace + "deleteBySeq", seq);
    }

    // 전체 삭제
    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace + "deleteAll");
    }

    // 공연아이디별 회차 수 카운트
    @Override
    public int countByPlayId(String play_id) throws Exception {
        return session.selectOne(namespace + "countByPlayId", play_id);
    }

    // 공연아이디별 조회
    @Override
    public List<ShowingDto> selectByPlayId(String play_id) throws Exception {
        return session.selectList(namespace + "selectByPlayId", play_id);
    }

    // 공연아이디별 공연일정 조회
    @Override
    public List<Map<String, String>> selectDateByPlayId(String play_id) throws Exception {
        return session.selectList(namespace + "selectDateByPlayId", play_id);
    }

    // 공연아이디 && 공연일정별 회차시퀀스, 회차정보 리스트 조회
    @Override
    public List<Map<String, Object>> selectRound(Map<String, String> map) throws Exception {
        return session.selectList(namespace + "selectRound", map);
    }

    // 공연아이디별 공연명, 공연포슽터,  공연장명 조회 (단일 행 반환)
    public Map<String, Object> selectPlayStageName(String play_id) throws Exception {
        return session.selectOne(namespace + "selectPlayStageName", play_id);
    }

    // 회차좌석 테이블 삽입
    @Override
    public int insertShowSeat(ShowSeatDto dto) throws Exception {
        return session.insert(namespace+"insertShowSeat", dto);
    }

    // 회차좌석 테이블 삭제
    @Override
    public int deleteShowSeat() throws Exception {
        return session.delete(namespace+"deleteShowSeat");
    }

    // 좌석 테이블 삽입
    @Override
    public int insertSeat(SeatDto dto) throws Exception {
        return session.insert(namespace+"insertSeat", dto);
    }

    // 좌석 테이블 공연장ID별 삭제
    @Override
    public int deleteSeatByStageId(String stage_id) throws Exception {
        return session.delete(namespace+"deleteSeatByStageId",stage_id);
    }

    // 회차시퀀스로 회차좌석수 조회
    @Override
    public int selectSeatCnt(int showing_seq) throws Exception {
        return session.selectOne(namespace+"selectSeatCnt", showing_seq);
    }

    // 회차시퀀스별 회차좌석가격 조회
    @Override
    public int selectPrice(int showing_seq) throws Exception {
        return session.selectOne(namespace+"selectPrice", showing_seq);
    }

    // 회차시퀀스별 좌석번호, 좌석상태리스트 조회
    @Override
    public List<Map<String, String>> selectSeatList(int showing_seq) throws Exception {
        return session.selectList(namespace+"selectSeatList", showing_seq);
    }

    // 회차시퀀스로 회차좌석의  행, 열의 마지막 번호 구하기
    @Override
    public Map<String, Object> selectEndNum(int showing_seq) throws Exception {
        return session.selectOne(namespace+"selectEndNum", showing_seq);
    }

    // 쿠폰테이블 삽입
    @Override
    public int insertCoupon(CouponDto couponDto) throws Exception {
        return session.insert(namespace+"insertCoupon", couponDto);
    }

    // 쿠폰테이블 삭제
    @Override
    public int deleteAllCoupon() throws Exception {
        return session.delete(namespace+"deleteAllCoupon");
    }
    // 유저-쿠폰 테이블 삭제
    @Override
    public int deleteAllUserCoupon() throws Exception {
        return session.delete(namespace+"deleteAllUserCoupon");
    }

    // 유저-쿠폰 테이블 삽입
    @Override
    public int insertUserCoupon(UserCouponDto userCouponDto) throws Exception {
        return session.insert(namespace+"insertUserCoupon", userCouponDto);
    }

    // 유저아이디로 유저-쿠폰 테이블에서 유저-쿠폰 아이디, 쿠폰아이디 리스트 조회
    @Override
    public List<UserCouponDto> selectUserCouponList(String user_id) throws Exception {
        return session.selectList(namespace+"selectUserCouponList", user_id);
    }

    // 쿠폰아이디로 쿠폰 테이블에서 쿠폰명, 쿠폰할인가격, 쿠폰사용조건, 쿠폰사용가능시작일, 쿠폰사용가능종료일 조회
    @Override
    public CouponDto selectCoupon(String coupon_id) throws Exception {
        return session.selectOne(namespace+"selectCoupon", coupon_id);
    }
}