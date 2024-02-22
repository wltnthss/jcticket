package com.jcticket.agency.service;

import com.jcticket.agency.dto.EnrollDto;
import com.jcticket.agency.dao.AgencyDao;
import com.jcticket.agency.dto.AgencyDto;
import com.jcticket.viewdetail.dto.ShowingDto;
import com.jcticket.viewdetail.dto.PlayDto;
import com.jcticket.agency.dto.StageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;

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

//    @Autowired//AgencyDao 빈을 주입받음
//    private AgencyDao agencyDao;
private final AgencyDao agencyDao;

    @Autowired
    public AgencyServiceImpl(AgencyDao agencyDao) {
        this.agencyDao = agencyDao;
    }

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
//---------------------------------------------------------------------------





//    @Override
//    public String uploadImage(MultipartFile file) throws Exception {
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename()); // 파일명에서 경로 제거
//        String uploadDir = "/경로/설절/"; // 업로드 디렉토리 경로
//        String filePath = uploadDir + fileName;
//        File dest = new File(filePath);
//        file.transferTo(dest); // 파일 저장
//
//        // 업로드된 이미지 파일의 경로를 반환
//        return filePath;
//    }

    @Override//processEnrollment() 메서드 처리. EnrollDto에서 데이터를 가져와 PlayDto, ShowingDto, StageDto를 생성
    //@Transactional  사용하려면 의존성 추가 필요해 보임. 해 줘
    public void processEnrollment(EnrollDto enrollDto) {
        try {

            // 이미지 업로드
//            String imagePath = uploadImage(enrollDto.getPlay_poster());

            // 이미지 경로 설정
//            enrollDto.setPlay_poster(imagePath);


            // PlayDto 생성 및 설정
            PlayDto playDto = new PlayDto();
            playDto.setPlay_id(enrollDto.getPlay_id());
            playDto.setPlay_name(enrollDto.getPlay_name());
            playDto.setPlay_poster(enrollDto.getPlay_poster());
            playDto.setPlay_info(enrollDto.getPlay_info());
            playDto.setPlay_major_cat(enrollDto.getPlay_major_cat());
            playDto.setPlay_middle_cat(enrollDto.getPlay_middle_cat());
            playDto.setPlay_small_cat(enrollDto.getPlay_small_cat());
            playDto.setPlay_run_time(enrollDto.getPlay_run_time());
            playDto.setAgency_id(enrollDto.getAgency_id());
            playDto.setCreated_at(new Timestamp(System.currentTimeMillis()));
            playDto.setCreated_id(enrollDto.getCreated_id());
            playDto.setUpdated_at(new Timestamp(System.currentTimeMillis()));
            playDto.setUpdated_id(enrollDto.getUpdated_id());

// ShowingDto 생성 및 설정
            ShowingDto showingDto = new ShowingDto();
            showingDto.setPlay_id(enrollDto.getPlay_id());
            showingDto.setShowing_seq(enrollDto.getShowing_seq());
            showingDto.setShowing_start_at(enrollDto.getShowing_start_at());
            showingDto.setShowing_end_at(enrollDto.getShowing_end_at());
            showingDto.setShowing_info(enrollDto.getShowing_info());
            showingDto.setShowing_date(enrollDto.getShowing_date());
            showingDto.setShowing_day(enrollDto.getShowing_day());
            showingDto.setShowing_status(enrollDto.getShowing_status());
            showingDto.setShowing_seat_cnt(enrollDto.getShowing_seat_cnt());
            showingDto.setStage_id(enrollDto.getStage_id());
            showingDto.setCreated_at(new Timestamp(System.currentTimeMillis()));
            showingDto.setCreated_id(enrollDto.getCreated_id());
            showingDto.setUpdated_at(new Timestamp(System.currentTimeMillis()));
            showingDto.setUpdated_id(enrollDto.getUpdated_id());


            StageDto stageDto = new StageDto();
            stageDto.setStage_id(enrollDto.getStage_id());
            stageDto.setStage_name(enrollDto.getStage_name());
            stageDto.setStage_address(enrollDto.getStage_address());
            stageDto.setStage_seat_cnt(enrollDto.getStage_seat_cnt());
            stageDto.setStage_manager(enrollDto.getStage_manager());
            stageDto.setStage_type(enrollDto.getStage_type());
            stageDto.setStage_tel(enrollDto.getStage_tel());
            stageDto.setCreated_at(new Timestamp(System.currentTimeMillis()));
            stageDto.setCreated_id(enrollDto.getCreated_id());
            stageDto.setUpdated_at(new Timestamp(System.currentTimeMillis()));
            stageDto.setUpdated_id(enrollDto.getUpdated_id());

            // DAO를 통해 각 DTO를 저장
            agencyDao.insertPlay(playDto);
            agencyDao.insertShowing(showingDto);
            agencyDao.insertStage(stageDto);
        } catch (Exception e) {
            e.printStackTrace();
            // 예외 처리.. 로그 사용 하려면 의존성 추가 해 줘야 함 임시로 이렇게 작성.
        }
    }














// catch (Exception e) {
//        logger.error("An error occurred during enrollment process", e);
//        // 예외 처리
//    }로그 사용 하려면 의존성 추가 해 줘야 함
//}



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
