package com.jcticket.admin.dao;

import com.jcticket.admin.dto.*;
import com.jcticket.agency.dto.AgencyDto;
import com.jcticket.ticketing.dto.TicketingDto;
import com.jcticket.user.dto.UserDto;
import com.jcticket.viewdetail.dto.ShowingDto;

import java.util.List;
import java.util.Map;

/**
 * packageName :  com.jcticket.admin.dao
 * fileName : AdminDao
 * author :  jisoo Son
 * date : 2024-02-05
 * description : 관리자 Dao
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05             jisoo Son             최초 생성
 */
public interface AdminDao {
    AdminDto adminLogin(Map<String, Object> map) throws Exception;
    // 최근 회원가입 기능 가입순 limit3 List 조회
    List<UserDto> userstatics() throws Exception;
    // 회원 테이블 총 개수 조회
    int usercnt(Map<String, Object> options) throws Exception;
    // 회원 페이징 리스트 조회
    List<UserDto> userPaingList(Map<String, Object> pagingParams) throws Exception;
    // 회원 가입
    int insertUser(UserDto userDto) throws Exception;
    // 회원 탈퇴
    int userRetireUpdate(String user_id) throws Exception;
    // 회원 삭제
    int userDelete(String user_id) throws Exception;
    // 공지사항 삭제
    int noticeDelete(int notice_seq) throws Exception;
    // 관리자 회원가입
    int insertAdmin(AdminDto adminDto) throws Exception;
    // 관리자 삭제
    int deleteAdmin(String admin_id) throws Exception;
    // 관리자 전체 삭제
    void adminAllDelete() throws Exception;
    // 기획사 등록
    int insertAgency(AgencyDto agencyDto) throws Exception;
    // 기획사 전체 삭제
    int deleteAllAgency() throws Exception;
    // 기획사 전체 조회
    int countAllAgency() throws Exception;
    // 기획사 테이블 총 개수 조회
    int agencyCnt(Map<String, Object> options) throws Exception;
    // 기획사 페이징 리스트 조회
    List<AgencyDto> agencyPaingList(Map<String, Object> pagingParams) throws Exception;
    // 관리자 수정폼 아이디 중복체크
    int dupleAdminId(String admin_id) throws Exception;
    // 관리자 정보 수정
    int updateAdminInfo(AdminDto adminDto) throws Exception;
    // 관리자 정보 리스트 조회
    AdminDto showAdminInfo(String admin_id) throws Exception;
    // 관리자 쿠폰 등록
    int insertCoupon(CouponDto couponDto) throws Exception;
    // 관리자 쿠폰 전체 삭제
    int deleteAllCoupon() throws Exception;
    // 관리자 쿠폰 전체 카운트
    int countAllCoupon() throws Exception;
    // 관리자 쿠폰 전체 리스트 조회
    List<CouponDto> selectAllCoupon() throws Exception;
    // 관리자 쿠폰 옵션,keyword,date 카운트 조회
    int countOptionCoupon(Map<String, Object> map) throws Exception;
    // 관리자 쿠폰 옵션,keyword,date 리스트 조회
    List<CouponDto> selectAllOptionCoupon(Map<String, Object> map) throws Exception;
    // 관리자 쿠폰 삭제
    void deleteCoupon(String coupon_id) throws Exception;
    // 공연장 데이터 등록 (공연장은 별도의 입력창에서 입력하는 값 없이 DB내에 존재하는 값 사용)
    int insertStage(StageDto stageDto) throws Exception;
    // 공연장 데이터 전체 삭제
    void deleteAllStage() throws Exception;
    // 상품 관리 팝업창 공연장명 검색 조회
    List<StageDto> selectKeywordStage(String keyword) throws Exception;
    // 상품 관리 팝업창 공연명 검색 조회
    List<PlayDto> selectKeywordPlay(String keyword) throws Exception;
    // 관리자 상품 관리 회차 등록
    int insertShowing(ShowingDto showingDto) throws Exception;
    // 관리자 상품 관리 회차 전체 삭제
    void deleteAllShoiwing() throws Exception;
    // 관리자 상품 관리 공연 좌석 등록
    int insertShowSeat(ShowSeatDto showSeatDto) throws Exception;
    // 관리자 상품 관리 공연 등록
    PlayDto insertPlay(PlayDto playDto) throws Exception;
    // 관리자 상품 관리 공연이미지 등록
    void insertPlayImg(PlayImgDto playImgDto) throws Exception;
    // 관리자 상품 조회
    List<Map<String, Object>> selectAllProduct() throws Exception;

}