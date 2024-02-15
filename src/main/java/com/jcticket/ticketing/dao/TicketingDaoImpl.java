package com.jcticket.ticketing.dao;

import com.jcticket.ticketing.dto.TicketingDto;
import com.jcticket.viewdetail.dto.ShowingDto;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * packageName    : com.jcticket.ticketing.dao
 * fileName       : TicketingDaoImpl
 * author         : 조영상
 * date           : 2/1/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/1/24         조영상        최초 생성
 */
@Repository
@RequiredArgsConstructor
public class TicketingDaoImpl implements TicketingDao{
    private final SqlSession session;

    public final String namespace = "com.jcticket.ticketing.mybatis.mapper.ticketing.TicketingMapper.";
    @Override
    public int insertShowing(ShowingDto dto) throws Exception{
        return session.insert(namespace+"insertShowing", dto);
    }
    @Override
    public int deleteShowing(String play_id) throws Exception{
        return session.delete(namespace+"deleteShowing", play_id);
    }
    @Override
    public int deleteAll() throws Exception{
        return session.delete(namespace+"deleteAll");
    }
//    @Override
//    public int countShowingAll() throws Exception{
//        return session.selectOne(namespace+"countShowingAll");
//    }
    @Override
    public List<HashMap<String,Object>> selectShowingDate(String play_id) throws Exception{
        List<HashMap<String,Object>> list = session.selectList(namespace+"selectShowingDate", play_id);
        return list;
    }

    @Override
    public List<HashMap<String,Object>> selectShowingRound(HashMap<String,Object> hm) throws Exception{
        List<HashMap<String,Object>> list = session.selectList(namespace+"selectShowingInfo", hm);
        return list;
    }

    public HashMap<String,Object> selectPlayStageName(String play_id) throws Exception{
        HashMap<String,Object> hm = session.selectOne(namespace+"selectPlayStageName", play_id);
        return hm;
    }

}
