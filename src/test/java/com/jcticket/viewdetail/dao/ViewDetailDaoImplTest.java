package com.jcticket.viewdetail.dao;

import com.jcticket.notice.dao.NoticeDao;
import com.jcticket.notice.service.NoticeService;
import com.jcticket.viewdetail.dto.SeatClassDto;
import com.jcticket.viewdetail.service.ViewDetailService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * packageName    : com.jcticket.viewdetail.dao
 * fileName       : ViewDetailDaoImplTest
 * author         : sungjun
 * date           : 2024-02-09
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-09        kyd54       최초 생성
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ViewDetailDaoImplTest{
    @Autowired
    ViewDetailDao viewDetailDao;

    @Autowired
    ViewDetailService viewDetailService;

    SeatClassDto seatClassDto;
    @Test
    public void seat_price() throws Exception {
        String asd = "1회 20시 00분";

//        List<SeatClassDto> test = viewDetailDao.seat_price(asd);

//        assertNotNull(test);

//        assertTrue(test.get(0).getSeatPrice() == 30000);
    }
}