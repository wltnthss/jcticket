package com.jcticket.enroll.dao;

import com.jcticket.enroll.dto.EnrollDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * packageName    : com.jcticket.mypage.dao
 * fileName       : mypageImpl
 * author         : JJS
 * date           : 2024-02-10
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-10        JJS       최초 생성
 */
@Repository
public class EnrollDAOImpl implements EnrollDAO {

    @Autowired
    private SqlSession session;


    public final String namespace = "agencyMapper.";


    @Override
    public int insertEnroll(EnrollDto enrollDto) throws Exception {
        return session.insert(namespace+"insertenroll", enrollDto);
    }

    @Override
    public int insertEnrollpk(EnrollDto enrollDto) throws Exception {
        return session.insert(namespace+"insertenrollpk", enrollDto);
    }
}
