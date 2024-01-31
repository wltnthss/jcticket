package com.jcticket.notice.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * packageName :  com.jcticket.notice.dao
 * fileName : NoticeDaoImplTest
 * author :  jisoo Son
 * date : 2024-01-31
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-01-31             jisoo Son             최초 생성
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class NoticeDaoImplTest {

    @Autowired
    NoticeDao noticeDao;

    @Test
    public void test() throws Exception {
        System.out.println("noticeDao.test() => " + noticeDao.test());
    }
}