package com.jcticket.signup.service;

import com.jcticket.signup.dto.TermsDto;

/**
 * packageName    : com.jcticket.signup.service
 * fileName       : TermsService
 * author         : jinwook Song
 * date           : 2024-02-11
 * description    : TermsService
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        jinwook Song       최초 생성
 */
public interface TermsService {
    int insertUserTerm(TermsDto termsDto) throws Exception;

}
