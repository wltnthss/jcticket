package com.jcticket.viewdetail.dao;

import com.jcticket.viewdetail.dto.SeatClassDto;
import com.jcticket.viewdetail.dto.ShowingDto;
import com.jcticket.viewdetail.service.ViewDetailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * packageName    : com.jcticket.viewdetail.dao
 * fileName       : ViewDetailDaoTest
 * author         : sungjun
 * date           : 2024-02-11
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        kyd54       최초 생성
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ViewDetailDaoTest {

    @Autowired
    ViewDetailDao viewDetailDao;

    @Test
    public void remain_seat() throws Exception {
        List<String> showingDate = viewDetailDao.showing_date();

        for (String asd : showingDate) {
            List<ShowingDto> showinginfo = viewDetailDao.select_showing_info(asd);
            System.out.print("dto.getShowing_date() => ");
            for (ShowingDto infoDto : showinginfo) {
                System.out.print(infoDto.getShowing_seq() + ", ");
            }
            System.out.println();
        }
    }

    @Test
    public void select_showing_info() throws Exception {
        List<String> showingDate = viewDetailDao.showing_date();

        for (String dto : showingDate) {
            List<ShowingDto> showinginfo = viewDetailDao.select_showing_info(dto);


            System.out.println(showinginfo);
            System.out.println("showingDto => " + dto);
        }
    }
}