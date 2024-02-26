package com.jcticket.enroll;

import com.jcticket.agency.dto.EnrollDto;
import com.jcticket.enroll.dao.EnrollDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;

import static org.junit.Assert.assertTrue;

/**
 * packageName    : com.jcticket.enroll
 * fileName       : EnrollDaoImplTest
 * author         : {sana}
 * date           : 2024-02-25
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-25        {sana}       최초 생성
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class EnrollDaoImplTest {
    @Autowired
    EnrollDAO enrollDAO;

    @Test
    public void insertEnroll() throws Exception {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        EnrollDto enrollDto = new EnrollDto(1,null, "1", 1, currentTimestamp,currentTimestamp,"20240204회차",null,
                100000, 200, "1", "aaa", "poster", "info","a", "b",120, "agency", "manager",
                "agency@email.com","01098765432", currentTimestamp,"sana",currentTimestamp,"sana");

        System.out.println("enrollDto = " + enrollDto);
        //assertTrue(enrollDAO.insertEnroll(enrollDto)==1); // EnrollDAO를 직접 호출하여 db에 삽입. dto호출시 dto에 추가할게 너무 많아짐
    }
    @Test
    public void insertEnrollpk() throws Exception {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        EnrollDto enrollDto = new EnrollDto(4,null, "1", 1, currentTimestamp,currentTimestamp,"20240204회차",null,
                100000, 200, "1", "aaa", "poster", "info","a", "b",120, "agency", "manager",
                "agency@email.com","01098765432", currentTimestamp,"sana",currentTimestamp,"sana");

        System.out.println("enrollDto222 = " + enrollDto);

    }

}
