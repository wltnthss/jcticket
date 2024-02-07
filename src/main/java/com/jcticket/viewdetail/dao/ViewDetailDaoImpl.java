package com.jcticket.viewdetail.dao;

import com.jcticket.viewdetail.dto.ShowingDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName    : com.jcticket.viewdetail.dao
 * fileName       : ViewDetailDaoImpl
 * author         : sungjun
 * date           : 2024-02-06
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-06        kyd54       최초 생성
 */
@Repository
public class ViewDetailDaoImpl implements ViewDetailDao{
    @Autowired
    private SqlSession session;

    private static String namespace="com.jcticket.viewdetail.viewdetailMapper.";

    @Override
    public List<ShowingDto> test(String dateText) throws Exception {
        return session.selectList(namespace + "test", dateText);
    }
}
