package com.jcticket.enroll.dao;

import com.jcticket.enroll.dto.EnrollDto;

/**
 * packageName    : com.jcticket.mypage.dao
 * fileName       : mypageDAO
 * author         : JJS
 * date           : 2024-02-10
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-10        JJS       최초 생성
 */

public interface EnrollDAO {
    int insertEnroll(EnrollDto enrollDto) throws Exception;
    int insertEnrollpk(EnrollDto enrollDto) throws Exception;
}
