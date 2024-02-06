package com.jcticket.agency.dao;

import com.jcticket.user.dto.UserDto;
import com.jcticket.agency.dto.AgencyDto;
import org.springframework.stereotype.Repository;


/**
 * packageName    : com.jcticket.agency.dao
 * fileName       : AgencyDao
 * author         : {sana}
 * date           : 2024-02-05
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-05        {sana}       최초 생성
 */

public interface AgencyDao {
    AgencyDto agencylogin(AgencyDto agencyDto) throws Exception;
//    public void saveAgency(AgencyDto agencyDto) {
//        // db에 기획사 정보를 저장
//    }
//
//    public AgencyDto selectAgency(String agencyId) {
//        // db에서 기획사 정보를 조회
//        return null;
//    }

    // 다른 메서드들 추가 가능
}