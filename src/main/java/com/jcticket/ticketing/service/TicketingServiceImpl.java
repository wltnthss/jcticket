package com.jcticket.ticketing.service;

import com.jcticket.ticketing.dao.TicketingDao;
import com.jcticket.ticketing.dto.TicketingDto;
import com.jcticket.viewdetail.dto.ShowingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * packageName    : com.jcticket.ticketing.service
 * fileName       : TicketingServiceImpl
 * author         : 조영상
 * date           : 2/1/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/1/24         조영상        최초 생성
 */
@Service
@RequiredArgsConstructor
public class TicketingServiceImpl implements TicketingService{
    private final TicketingDao ticketingDao;

    // 서비스에서 어떤 (DAO처럼 단순 쿼리와는 다른) 작업을 구현하고 데이터 가공을 어떻게 할지에 대한 고민이 생각보단 복잡하네여..

    // Step1. 일정선택

    // 리턴타입이 같고 처리 결과가 비슷하며 파라미터가 연관깊은 두 메서드를 하나의 작업으로 묶을지....말지...
    // List<HashMap<String,Object>> getShowTimeInfo(String play_id, String dateText) throws Exception;
    @Override
    public List<HashMap<String,Object>> getShowingDate(String play_id) throws Exception{
        return ticketingDao.selectShowingDate(play_id);
    }

    @Override
    public List<HashMap<String,Object>> getShowingRound(String dateText) throws Exception{
        HashMap<String,Object> hm = new HashMap<>();{
            //해시맵 데이터 생성하는 부분.
        }
        return ticketingDao.selectShowingRound(hm);
    }

    @Override
    public HashMap<String,Object> getPlayStageName(String play_id) throws Exception{
        return ticketingDao.selectPlayStageName(play_id);
    }


    //Next step...
}

