package com.jcticket.admin.service;

import com.jcticket.admin.dto.AdminDto;
import com.jcticket.admin.dto.CouponDto;
import com.jcticket.admin.dto.PageDto;
import com.jcticket.agency.dto.AgencyDto;
import com.jcticket.user.dto.UserDto;

import java.util.List;
import java.util.Map;

/**
 * packageName :  com.jcticket.admin.service
 * fileName : AdminService
 * author :  jisoo Son
 * date : 2024-02-05
 * description : 관리자 Service
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05             jisoo Son             최초 생성
 */
public interface AdminService {
    AdminDto adminLogin(Map<String, Object> map) throws Exception;
    List<UserDto> userstatics() throws Exception;
    // 총 회원수 조회
    int usercnt(String option, String keyword) throws Exception;
    // 회원 페이징 리스트 조회
    List<UserDto> userPaingList(int page, String option, String keyword) throws Exception;
    // 현재페이지, 전체, 시작, 끝, 검색값 전달 PageDto 전달
    PageDto userPagingParam(int page, String option, String keyword) throws Exception;
    // 유저 회원가입
    int userInsert(UserDto userDto) throws Exception;
    // 회원 탈퇴
    int userDelete(String user_id) throws Exception;
    // 기획사 등록
    int insertAgency(AgencyDto agencyDto) throws Exception;
    // 기획사 테이블 총 개수 조회
    int agencyCnt(String option, String keyword) throws Exception;
    // 기획사 페이징 리스트 조회
    List<AgencyDto> agencyPaingList(int page, String option, String keyword) throws Exception;
    // 현재페이지, 전체, 시작, 끝, 검색값 전달 PageDto 전달
    PageDto agencyPagingParam(int page, String option, String keyword) throws Exception;
    // 공지사항 삭제
    int noticeDelete(int notice_seq) throws Exception;
    // 관리자 수정폼 중복 아이디 체크
    int dupleAdminId(String admin_id) throws Exception;
    // 관리자 정보 수정
    int updateAdminInfo(AdminDto adminDto) throws Exception;
    // 관리자 정보 리스트 조회
    AdminDto showAdminInfo(String admin_id) throws Exception;
    // 관리자 쿠폰 등록
    int insertCoupon(CouponDto couponDto) throws Exception;

}