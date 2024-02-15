package com.jcticket.agency.service;

import com.jcticket.agency.dto.EnrollDto;
import com.jcticket.agency.dao.AgencyDao;
import com.jcticket.agency.dto.AgencyDto;
import com.jcticket.agency.dto.PlayDto;
import com.jcticket.agency.dto.ShowingDto;
import com.jcticket.agency.dto.StageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * packageName    : com.jcticket.agency.service
 * fileName       : AgencyServiceImpl
 * author         : {sana}
 * date           : 2024-02-07
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-07        {sana}       최초 생성
 */

//6. AgencyServiceImpl 생성 : Dao,DaoImpl과 마찬가지로 AgencyService interface를 implements한 AgencyServiceImpl.
@Service
public class AgencyServiceImpl implements AgencyService{

    @Autowired//AgencyDao 빈을 주입받음
    private AgencyDao agencyDao;




    @Override
    public boolean processAgencyLogin(String agency_id, String agency_pwd) {
        try {
            AgencyDto agencyDto = agencyDao.selectAgency(agency_id);
            return agencyDto != null && agencyDto.getAgency_password().equals(agency_pwd);
        } catch (Exception e) {
            e.printStackTrace();
            return false; // 예외 발생 시 로그인 실패 처리
        }
    }

    @Override
    public AgencyDto selectAgency(String agency_id) throws Exception {
        return agencyDao.selectAgency(agency_id);
    }

    @Override
    public void saveFormData(EnrollDto enrollDto) {
        // DTO에서 데이터 추출한다는 가정
        String agencyName = enrollDto.getAgencyName();
        String playName = enrollDto.getPlayName();
        String showingName = enrollDto.getShowingName();
        String stageName = enrollDto.getStageName();

        // 각 테이블에 데이터 저장
        agencyDao.saveAgency(agencyName);
        agencyDao.savePlay(playName);
        agencyDao.saveShowing(showingName);
        agencyDao.saveStage(stageName);
    }





//    @Override//selectAgency 메서드를 오버라이드.
//    public AgencyDto selectAgency(String agency_id) throws Exception {//또외처리
//        return agencyDao.selectAgency(agency_id); //AgencyDao를 사용하여 agency_id정보를 가져오고 반환?
//    }



//    @Override
//    public List<AgencyDto> getAllAgencies() throws Exception {
//        return agencyDao.selectAllAgencies();
//    }
//
//    @Override
//    public void addAgency(AgencyDto agency) throws Exception {
//        agencyDao.insertAgency(agency);
//    }
//
//    @Override
//    public void updateAgency(AgencyDto agency) throws Exception {
//        agencyDao.updateAgency(agency);
//    }
//
//    @Override
//    public void deleteAgency(String agencyId) throws Exception {
//        agencyDao.deleteAgency(agencyId);
//    }
}
