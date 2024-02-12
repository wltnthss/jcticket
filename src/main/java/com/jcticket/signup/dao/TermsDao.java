package com.jcticket.signup.dao;

import com.jcticket.signup.dto.TermsDto;

/**
 * packageName    : com.jcticket.signup.dao
 * fileName       : termsDao
 * author         : jinwook Song
 * date           : 2024-02-11
 * description    : TermsDao
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        jinwook Song       최초 생성
 */
public interface TermsDao {
    int insertTerm(TermsDto termsDto) throws Exception;
}
