package com.jcticket.viewdetail.dto;

import com.fasterxml.jackson.databind.util.StdDateFormat;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * packageName    : com.jcticket.viewdetail.dto
 * fileName       : pageHandlerTest
 * author         : sungjun
 * date           : 2024-02-14
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-14        kyd54       최초 생성
 */
public class pageHandlerTest {

    @Test
    public void startPageTest() {
        pageHandler ph = new pageHandler(11,260,10);
        System.out.println("ph = " +ph);
        assertTrue(ph.getTotalPage()==26);
        assertTrue(ph.getStartPage()==11);
        assertTrue(ph.getEndPage()==20);
    }
}