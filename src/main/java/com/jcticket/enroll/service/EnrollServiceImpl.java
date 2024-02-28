package com.jcticket.enroll.service;

import com.jcticket.enroll.dao.EnrollDAO;
import com.jcticket.enroll.dto.EnrollDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.jcticket.mypage.service
 * fileName       : MyServiceImpl
 * author         : JJS
 * date           : 2024-02-10
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-10        JJS       최초 생성
 */


@Service
public class EnrollServiceImpl implements EnrollService {


    @Autowired
    EnrollDAO enrollDAO;


    @Override
    public int insertEnroll(EnrollDto enrollDto) throws Exception {
        return enrollDAO.insertEnroll(enrollDto);
    }
}
