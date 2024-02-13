package com.jcticket.agency.service;

import com.jcticket.agency.dto.AgencyDto;
import com.jcticket.agency.dto.PlayDto;
import com.jcticket.agency.dto.ShowingDto;
import com.jcticket.agency.dto.StageDto;
import java.util.List;

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
    AgencyDto selectAgency(String agency_id) throws Exception;
//    List<AgencyDto> getAllAgencies() throws Exception;
//    void addAgency(AgencyDto agency) throws Exception;
//    void updateAgency(AgencyDto agency) throws Exception;
//    void deleteAgency(String agencyId) throws Exception;
//
//    PlayDto getPlay(String playId) throws Exception;
//    List<PlayDto> getAllPlays() throws Exception;
//    void addPlay(PlayDto play) throws Exception;
//    void updatePlay(PlayDto play) throws Exception;
//    void deletePlay(String playId) throws Exception;
//
//    ShowingDto getShowing(int showingSeq) throws Exception;
//    List<ShowingDto> getAllShowings() throws Exception;
//    void addShowing(ShowingDto showing) throws Exception;
//    void updateShowing(ShowingDto showing) throws Exception;
//    void deleteShowing(int showingSeq) throws Exception;
//
//    StageDto getStage(String stageId) throws Exception;
//    List<StageDto> getAllStages() throws Exception;
//    void addStage(StageDto stage) throws Exception;
//    void updateStage(StageDto stage) throws Exception;
//    void deleteStage(String stageId) throws Exception;

}
//5.AgencyService 생성 : DAO와 코드가 동일 하지만 DAO는 db와의 직접적인 상호 작용을 하고,
//Service는  DAO로 부터 가져온 데이터를 컨트롤러에 반환하는 역할
//코드가 동일해서  DAO에서도 예외처리를 하고 Service에서도 예외처리를 하는데 이 부분 뇌 정지 옴 컨트롤러에서 예외처리 받는건 서비스의 예외처리를 받는건가??