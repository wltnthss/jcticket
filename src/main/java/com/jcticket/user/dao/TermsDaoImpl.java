package com.jcticket.user.dao;

import com.jcticket.user.dto.TermsDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * packageName    : com.jcticket.signup.dao
 * fileName       : TermsDaoImpl
 * author         : jinwook Song
 * date           : 2024-02-11
 * description    : TermsDao구현
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        jinwook Song       최초 생성
 */
@Repository
public class TermsDaoImpl implements TermsDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "TermsMapper.";

    //user_term에 insert
    @Override
    public int insertTerm(TermsDto termsDto) throws Exception {
        return session.insert(namespace+"terms1",termsDto);
    }

}
