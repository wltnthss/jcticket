package com.jcticket.mypage.dto;

import org.junit.Test;

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
public class MyPagingDTOTest {

    @Test
    public void print() {
        MyPagingDTO ph = new MyPagingDTO(250, 1);

        assertTrue(ph.getBeginPage() == 1);
        assertTrue(ph.getEndPage() == 10);
    }

    @Test
    public void print2() {
        MyPagingDTO ph = new MyPagingDTO(250, 11);

        ph.print();
        assertTrue(ph.getBeginPage() == 11);
        assertTrue(ph.getEndPage() == 20);
    }

    @Test
    public void print3() {
        MyPagingDTO ph = new MyPagingDTO(255, 25);

        ph.print();
        assertTrue(ph.getBeginPage() == 21);
        assertTrue(ph.getEndPage() == 26);
    }



}