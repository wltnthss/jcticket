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


//3.DAO 생성: db에서  agency_id 를 가져온 dto 객체를 반환?
    // 그래서 interface로 쓴 이유는 유지 보수성 때문인가요?  와 진짜 트루리셋됨
public interface AgencyDao {
    AgencyDto selectAgency(String agency_id) throws Exception;
}


