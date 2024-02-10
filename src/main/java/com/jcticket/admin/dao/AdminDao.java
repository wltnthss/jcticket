package com.jcticket.admin.dao;

import com.jcticket.admin.dto.AdminDto;
import com.jcticket.user.dto.UserDto;

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
    AdminDto login(AdminDto adminDto) throws Exception;
    // 최근 회원가입 기능 가입순 limit3 List 조회
    List<UserDto> userstatics() throws Exception;
    // 회원 테이블 총 개수 조회
    int usercnt(Map<String, Object> options) throws Exception;
    // 회원 페이징 리스트 조회
    List<UserDto> userPaingList(Map<String, Object> pagingParams) throws Exception;
}