package com.jcticket.signup.service;

import com.jcticket.signup.dao.TermsDao;
import com.jcticket.signup.dto.TermsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.jcticket.signup.service
 * fileName       : TermsServiceImpl
 * author         : jinwook Song
 * date           : 2024-02-11
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        jinwook Song       최초 생성
 */
@Service
public class TermsServiceImpl implements TermsService{
    @Autowired
    TermsDao termsDao;

    @Override
    public int insertUserTerm(TermsDto termsDto) throws Exception {
        return termsDao.insertTerm(termsDto);
    }
}
