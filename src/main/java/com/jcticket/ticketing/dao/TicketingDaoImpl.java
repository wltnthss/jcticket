package com.jcticket.ticketing.dao;

import com.jcticket.ticketing.dto.TicketingDto;
import com.jcticket.viewdetail.dto.ShowingDto;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
<<<<<<< HEAD
@RequiredArgsConstructor
public class TicketingDaoImpl implements TicketingDao{
    private final SqlSession session;

=======
public class TicketingDaoImpl implements TicketingDao {
    @Autowired
    SqlSession session;
>>>>>>> mypage
    public final String namespace = "com.jcticket.ticketing.mybatis.mapper.ticketing.TicketingMapper.";
    // 삽입
    @Override
    public int insert(ShowingDto dto) throws Exception{
        return session.insert(namespace+"insert", dto);
    }

    // 공연아이디별 삭제
    @Override
    public int deleteByPlayId(String play_id) throws Exception{
        return session.delete(namespace+"deleteByPlayId", play_id);
    }

<<<<<<< HEAD
    // 회차 시퀀스별 삭제
=======


>>>>>>> mypage
    @Override
    public int deleteBySeq(int seq) throws Exception {
        return session.delete(namespace+"deleteBySeq", seq);
    }

    // 전체 삭제
    @Override
    public int deleteAll() throws Exception{
        return session.delete(namespace+"deleteAll");
    }

    // 공연아이디별 회차 수 카운트
    @Override
    public int countByPlayId(String play_id) throws Exception{
        return session.selectOne(namespace+"countByPlayId", play_id);
    }

    // 공연아이디별 조회
    @Override
    public List<ShowingDto> selectByPlayId(String play_id) throws Exception{
        return session.selectList(namespace+"selectByPlayId", play_id);
    }

    // 공연아이디별 공연일정 조회
    @Override
    public List<Map<String,String>> selectDateByPlayId(String play_id) throws Exception{
        return session.selectList(namespace+"selectDateByPlayId",play_id);
    }

    // 공연아이디 && 공연일정별 회차정보 리스트 조회
    @Override
    public List<Map<String,String>> selectRound(Map<String,String> map) throws Exception{
        return session.selectList(namespace+"selectRound", map);
    }

    // 공연아이디별 공연명, 공연포슽터,  공연장명 조회 (단일 행 반환)
    public Map<String,Object> selectPlayStageName(String play_id) throws Exception{
        return session.selectOne(namespace+"selectPlayStageName", play_id);
    }

}
