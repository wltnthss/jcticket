package com.jcticket.viewdetail.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * packageName    : com.jcticket.viewdetail.dao
 * fileName       : ViewDetailDaoImpl
 * author         : sungjun
 * date           : 2024-02-05
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-05        kyd54       최초 생성
 */
@Repository
public class ViewDetailDaoImpl implements ViewDetailDao{
    @Autowired
    private SqlSession sqlSession;

    private static String namespace = "com.jcticket.viewdetail.viewdetailMapper.";

    @Override
    public String test() throws Exception {
        return sqlSession.selectOne(namespace + "test");
    }
}
