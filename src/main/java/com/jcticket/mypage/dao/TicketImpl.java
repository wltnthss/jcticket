package com.jcticket.mypage.dao;

import com.jcticket.mypage.dto.TicketingDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * packageName    : com.jcticket.mypage.dao
 * fileName       : TicketImpl
 * author         : JJS
 * date           : 2024-02-08
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-08        JJS       최초 생성
 */
public class TicketImpl implements TicketingDAO{


    private static String namespace = "com.jcticket.notice.mybatis.mapper.mypage.mypageMapper";
    private SqlSession sqlSession;

    @Override
    public String test() throws Exception {
        return null;
    }

    @Override
    public List<TicketingDTO> list() throws Exception {
        return null;
    }

    @Override
    public TicketingDTO select(int no) throws Exception {
        return null;
    }

    @Override
    public int count(String keyword) throws Exception {
        return 0;
    }

    @Override
    public int addViewCnt(int no) throws Exception {
        return 0;
    }

    @Override
    public List<TicketingDTO> pagingList(Map<String, Object> pagingParams) {
        return null;
    }

    @Override
    public List<TicketingDTO> pagingViewOrderList(Map<String, Object> pagingParams) {
        return null;
    }
}
