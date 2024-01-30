package com.jcticket.example.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * packageName    : com.jcticket.example.dao
 * fileName       : exampleDaoImplTest
 * author         : jinwook Song
 * date           : 2024-01-29
 * description    : 테스트케이스를 테스트
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-29        jinwook Song       최초 생성
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class exampleDaoImplTest {
@Autowired
exampleDao exampleDao;

    @Test
    public void test1() {
        System.out.println("exampleDao = " + exampleDao);
        assertTrue(exampleDao!=null);
    }
}