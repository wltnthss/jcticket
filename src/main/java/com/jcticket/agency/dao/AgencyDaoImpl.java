package com.jcticket.agency.dao;

import com.jcticket.agency.dto.AgencyDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * packageName    : com.jcticket.agency.dao
 * fileName       : AgencyDaoImpl
 * author         : {sana}
 * date           : 2024-02-06
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-06        {sana}       최초 생성
 */

@Repository
public class AgencyDaoImpl implements AgencyDao{

    @Autowired
    SqlSession sqlSession;
    private static String namespace = "AgencyMapper.";

    @Override
    public AgencyDto agencylogin(AgencyDto agencyDto) throws Exception {
        return sqlSession.selectOne(namespace + "AgencyLogin", agencyDto);
    }
}
