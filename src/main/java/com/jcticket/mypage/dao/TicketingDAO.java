package com.jcticket.mypage.dao;

import com.jcticket.mypage.dto.TicketingDTO;
import com.jcticket.notice.dto.NoticeDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * packageName    : com.jcticket.mypage.dao
 * fileName       : TicketingDAO
 * author         : JJS
 * date           : 2024-02-08
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-08        JJS       최초 생성
 */
public interface TicketingDAO {

        String test() throws Exception;

        List<TicketingDTO> list() throws Exception;
        TicketingDTO select(int no) throws Exception;

        // 전체 notice 리스트 개수 조회
        int count(String keyword) throws Exception;

        // 상세보기 진입시 조회수 1씩 증가
        int addViewCnt(int no) throws Exception;
        List<TicketingDTO> pagingList(Map<String, Object> pagingParams);

        List<TicketingDTO> pagingViewOrderList(Map<String, Object> pagingParams);

    }

