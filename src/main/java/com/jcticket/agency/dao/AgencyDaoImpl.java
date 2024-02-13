package com.jcticket.agency.dao;

import com.jcticket.agency.dto.*;
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


//4.DaoImpl : AgencyDao의 interface를  implements한 AgencyDaoImpl class 라는 말 같음.
//그러니까 AgencyDao의 interface를 구현해서 db와 상호작용하며, SqlSession 객체를 주입받고
//그를 사용하여 매퍼에서 정의된 SQL 쿼리를 실행
@Repository
public class AgencyDaoImpl implements AgencyDao {

    private static final String namespace = "AgencyMapper.";
    //AgencyMapper.xml랑 연결?


    //SqlSession객체를  자동 연결해서 주입받음 (의존성 주입)
    @Autowired
    private SqlSession sqlSession;

    @Override
    public AgencyDto selectAgency(String agency_id) throws Exception {
        return sqlSession.selectOne(namespace + "AgencyLogin", agency_id);
    }//selectAgency 메서드는 SqlSession 객체를 사용해 db에서 쿼리를 실행?

//    @Override //데이터를 데이터베이스에 저장할 save 메서드를 추가
//    public void save(AgencyDto agencyDto) throws Exception {
//        sqlSession.insert(namespace + "insertAgency", agencyDto);
//
//
//    }
//    @Override
//    public void deleteStage(String stage_id) throws Exception {
//        sqlSession.delete(namespace + "deleteStage", stage_id);
//    }
//
//    @Override
//    public void updateStage(StageDto stageDto) throws Exception {
//        sqlSession.update(namespace + "updateStage", stageDto);
//    }

}//selectOne 메서드를 사용해 db에서 한 개의 결과를 가져오는 쿼리를 실행하고, 결과를 AgencyDto 객체로 매핑해서 return