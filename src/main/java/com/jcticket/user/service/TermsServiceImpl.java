package com.jcticket.user.service;

import com.jcticket.user.dao.TermsDao;
import com.jcticket.user.dto.TermsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.jcticket.signup.service
 * fileName       : TermsServiceImpl
 * author         : jinwook Song
 * date           : 2024-02-11
 * description    : TermsService구현클래스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        jinwook Song       최초 생성
 */
@Service
public class TermsServiceImpl implements TermsService {
    @Autowired
    TermsDao termsDao;

    @Override
    public int insertUserTerm(TermsDto termsDto) throws Exception {
        return termsDao.insertTerm(termsDto);
    }
}
