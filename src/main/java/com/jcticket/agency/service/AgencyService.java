package com.jcticket.agency.service;

import com.jcticket.agency.dto.AgencyDto;
import com.jcticket.agency.dto.EnrollDto;
import com.jcticket.agency.dto.PosterDto;

/**
 * packageName    : com.jcticket.agency.service
 * fileName       : AgencyService
 * author         : {sana}
 * date           : 2024-02-07
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-07        {sana}       최초 생성
 */

public interface AgencyService {
    boolean processAgencyLogin(String agency_id, String agency_pwd) throws Exception;
    AgencyDto selectAgency(String agency_id) throws Exception;

  //  String uploadImage(MultipartFile file) throws Exception; // 이미지 업로드 메서드
//    void processEnrollment(EnrollDto enrollDto);//processEnrollment() 메서드를 호출

    int insertEnroll(EnrollDto enrollDto, PosterDto posterDto) throws Exception;


}
//5.AgencyService 생성 : DAO와 코드가 동일 하지만 DAO는 db와의 직접적인 상호 작용을 하고,
//Service는  DAO로 부터 가져온 데이터를 컨트롤러에 반환하는 역할
//코드가 동일해서  DAO에서도 예외처리를 하고 Service에서도 예외처리를 하는데 이 부분 뇌 정지 옴 컨트롤러에서 예외처리 받는건 서비스의 예외처리를 받는건가??