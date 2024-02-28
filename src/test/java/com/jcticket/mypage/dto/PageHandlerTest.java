package com.jcticket.mypage.dto;

import com.jcticket.mypage.controller.PageHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * packageName    : com.jcticket.mypage.dto
 * fileName       : MyPagingDTOTest
 * author         : JJS
 * date           : 2024-02-13
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-13        JJS       최초 생성
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class PageHandlerTest {



    @Test
    public void print() {
        PageHandler ph = new PageHandler(250, 1);


        ph.print();
        assertTrue(ph.getBeginPage() == 1);
        assertTrue(ph.getEndPage() == 10);
    }

    @Test
    public void print2() {
        PageHandler ph = new PageHandler(250, 11);

        ph.print();
        assertTrue(ph.getBeginPage() == 11);
        assertTrue(ph.getEndPage() == 20);
    }

    @Test
    public void print3() {
        PageHandler ph = new PageHandler(255, 25);

        ph.print();
        assertTrue(ph.getBeginPage() == 21);
        assertTrue(ph.getEndPage() == 26);
    }

    @Test
    public void print4() {
        PageHandler ph = new PageHandler(101, 1);

        ph.print();
        assertTrue(ph.getBeginPage() == 1);
        assertTrue(ph.getEndPage() == 10);
    }



}