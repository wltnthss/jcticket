package com.jcticket.ticketing.dao;

import com.jcticket.admin.dao.AdminDao;
import com.jcticket.ticketing.dto.TicketingDto;
import com.jcticket.viewdetail.dto.ShowingDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * packageName :  com.jcticket.ticketing.dao
 * fileName : TicketingDaoImplTest
 * author :  jisoo Son
 * date : 2024-02-10
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-10             jisoo Son             최초 생성
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TicketingDaoImplTest {

    @Autowired
    TicketingDao ticketingDao;

    @Test
    public void insertTest() throws Exception{
        // given -> 임의의 데이터를 주입
        ShowingDto dto = new ShowingDto()
        // when -> 데이터의 조건 dao, service

        // then -> 검증하는 절차
    }
}