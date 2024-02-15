package com.jcticket.agency.dao;


import com.jcticket.user.dto.UserDto;
import com.jcticket.agency.dto.AgencyDto;
import com.jcticket.agency.dto.EnrollDto;
import org.springframework.stereotype.Repository;
import com.jcticket.agency.dto.ShowingDto;
import com.jcticket.agency.dto.StageDto;
import com.jcticket.agency.dto.PlayDto;
import java.util.List;

/**
 * packageName    : com.jcticket.agency.dao
 * fileName       : AgencyDao
 * author         : {sana}
 * date           : 2024-02-05
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-05        {sana}       최초 생성
 */


//3.DAO 생성: db에서  agency_id 를 가져온 dto 객체를 반환?
    // 그래서 interface로 쓴 이유는 유지 보수성 때문인가요?  와 진짜 트루리셋됨
public interface AgencyDao {
    AgencyDto selectAgency(String agency_id) throws Exception;

    int insertAgency(AgencyDto agencyDto) throws Exception;

    int deleteAgency() throws Exception;

    int agencyCount() throws Exception;



    void saveAgency(String agencyName);
    void savePlay(String playName);
    void saveShowing(String showingName);
    void saveStage(String stageName);
//CRUD;;
//    void insertAgency(AgencyDto agencyDto) throws Exception;
//    void updateAgency(AgencyDto agencyDto) throws Exception;
//    void deleteAgency(String agency_id) throws Exception;


















//    List<AgencyDto> selectAllAgencies() throws Exception;
//    void insertAgency(AgencyDto agency) throws Exception;
//    void updateAgency(AgencyDto agency) throws Exception;
//    void deleteAgency(String agencyId) throws Exception;
//
//    // 공연 정보 관련 메서드
//    PlayDto selectPlay(String playId) throws Exception;
//    List<PlayDto> selectAllPlays() throws Exception;
//    void insertPlay(PlayDto play) throws Exception;
//    void updatePlay(PlayDto play) throws Exception;
//    void deletePlay(String playId) throws Exception;
//
//    // 공연 일정 정보 관련 메서드
//    ShowingDto selectShowing(int showingSeq) throws Exception;
//    List<ShowingDto> selectAllShowings() throws Exception;
//    void insertShowing(ShowingDto showing) throws Exception;
//    void updateShowing(ShowingDto showing) throws Exception;
//    void deleteShowing(int showingSeq) throws Exception;
//
//    // 공연장 정보 관련 메서드
//    StageDto selectStage(String stageId) throws Exception;
//    List<StageDto> selectAllStages() throws Exception;
//    void insertStage(StageDto stage) throws Exception;
//    void updateStage(StageDto stage) throws Exception;
//    void deleteStage(String stageId) throws Exception;
}


