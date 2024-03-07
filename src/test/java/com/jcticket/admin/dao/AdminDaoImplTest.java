package com.jcticket.admin.dao;

import com.jcticket.admin.dto.AdminDto;
import com.jcticket.admin.dto.CouponDto;
import com.jcticket.admin.dto.ShowSeatDto;
import com.jcticket.admin.dto.StageDto;
import com.jcticket.agency.dto.AgencyDto;
import com.jcticket.ticketing.dao.TicketingDao;
import com.jcticket.user.dao.UserDao;
import com.jcticket.user.dto.UserDto;
import com.jcticket.viewdetail.dto.ShowingDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;

/**
 * packageName :  com.jcticket.admin.dao
 * fileName : AdminDaoImplTest
 * author :  jisoo Son
 * date : 2024-02-05
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05             jisoo Son             최초 생성
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class AdminDaoImplTest {

    @Autowired
    AdminDao adminDao;

    @Autowired
    UserDao userDao;

    @Autowired
    TicketingDao ticketingDao;

    final static Timestamp CURRENT_TIMESTAMP = new Timestamp(System.currentTimeMillis());

    @Test
    public void insertAdmin() throws Exception{

        adminDao.adminAllDelete();

        // given
        for (int i = 1; i < 10; i++) {
            AdminDto adminDto = new AdminDto("jcticket"+i, "admin"+i+"@gmail.com", "smgsmg12!@", "010-1257-7845", "jcticket"+i+" 관리자", "Y", CURRENT_TIMESTAMP, "S", CURRENT_TIMESTAMP, "JISOO", CURRENT_TIMESTAMP, "JISOO");
            // when, then
            assertEquals(1, adminDao.insertAdmin(adminDto));
        }
    }
    @Test
    public void login() throws Exception{

        // given
        AdminDto adminDto = new AdminDto("admin", "admin@gmail.com", "1111", "010-1257-7845", "jcticket 관리자", "Y", CURRENT_TIMESTAMP, "S", CURRENT_TIMESTAMP, "JISOO", CURRENT_TIMESTAMP, "JISOO");
        Map<String, Object> map = new HashMap<>();
        map.put("admin_id", adminDto.getAdmin_id());
        map.put("admin_password", adminDto.getAdmin_password());
        // when
        int result = adminDao.insertAdmin(adminDto);
        AdminDto validateNickName = adminDao.adminLogin(map);
        // then
        assertEquals(result, 1);
        assertEquals("jcticket 관리자", validateNickName.getAdmin_nickname());

        // after data delete
        int deleteCnt = adminDao.deleteAdmin(validateNickName.getAdmin_id());
        assertEquals(1, deleteCnt);
    }
    @Test
    public void userstatics() throws Exception{

        // given, when
        List<UserDto> userlists = adminDao.userstatics();
        System.out.println("userlists => "+ userlists);
        // then
//        assertEquals(3, userlists.size());
    }
    @Test
    public void insertAndDeleteUser() throws Exception {

        // given
        for (int i = 1; i < 9; i++) {
            UserDto userDto = new UserDto("jisoo"+i, "1111", "지수", "soodal"+i , "wltn@naver.com", "010-2521-341"+i,
                    "서울 성동구", "19990219", "M", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, null, "N", 0, "공연", "고수","", CURRENT_TIMESTAMP, "userAdmin", CURRENT_TIMESTAMP, "userAdmin");
            // when
            int deleteResult = adminDao.userDelete("jisoo" + i);
            int insertResult = adminDao.insertUser(userDto);
            // then
            assertEquals(1, insertResult);
            assertEquals(1, deleteResult);
        }
    }
    @Test
    public void insertUser() throws Exception {

        // given
        for (int i = 1; i < 9; i++) {
            UserDto userDto = new UserDto("jisoo"+i, "1111", "지수", "soodal"+i , "wltn@naver.com", "010-2521-341"+i,
                    "서울 성동구", "19990219", "M", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, null, "N", 0, "공연", "고수","", CURRENT_TIMESTAMP, "userAdmin", CURRENT_TIMESTAMP, "userAdmin");
            // when
            int result = adminDao.insertUser(userDto);
            // then
            assertEquals(1, result);
        }
    }
    @Test
    public void deleteUser() throws Exception {

        // given
        for (int i = 1; i < 9; i++) {
            UserDto userDto = new UserDto("jisoo"+i, "1111", "지수", "soodal"+i , "wltn@naver.com", "010-2521-341"+i,
                    "서울 성동구", "19990219", "M", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, null, "N", 0, "공연", "고수","", CURRENT_TIMESTAMP, "userAdmin", CURRENT_TIMESTAMP, "userAdmin");
            // when
            int result = adminDao.userDelete("jisoo" + i);
            // then
            assertEquals(1, result);
        }
    }
    @Test
    public void userRetireUpdate() throws Exception {
        // given
        UserDto userDto = new UserDto("jisoo", "1111", "지수", "soodall" , "wltn@naver.com", "010-2521-3435",
                "서울 성동구", "19990219", "M", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, null, "N", 0, "공연", "고수","", CURRENT_TIMESTAMP, "userAdmin", CURRENT_TIMESTAMP, "userAdmin");
        int insertUser = adminDao.insertUser(userDto);
        UserDto loginUser = userDao.select(userDto.getUser_id());

        // when
        int updateResult = adminDao.userRetireUpdate(loginUser.getUser_id());
        UserDto afterUpdateTestUser = userDao.select(userDto.getUser_id());

        // then
        assertEquals(1, insertUser);
        assertEquals(1, updateResult);
        assertEquals("Y", afterUpdateTestUser.getUser_retire_yn());

        // after Delete
        int deleteUser = adminDao.userDelete(userDto.getUser_id());
        assertEquals(1, deleteUser);
    }

    @Test
    public void insertAgency() throws Exception {

        adminDao.deleteAllAgency();

        // given
        for (int i = 1; i < 11; i++) {
            AgencyDto agencyDto = new AgencyDto("agency"+i, "1111", "정석코딩(주)", "castello@gmail.com", "010-5789-1548", "98-578-48751", CURRENT_TIMESTAMP, "R", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, "정석코딩", "남궁성", CURRENT_TIMESTAMP, "JISOO", CURRENT_TIMESTAMP, "JISOO");
            // when
            int result = adminDao.insertAgency(agencyDto);
            // then
            assertTrue(1 == result);
        }
        assertTrue(10 == adminDao.countAllAgency());
    }

    @Test
    public void insertCoupon() throws Exception {

//        adminDao.deleteAllCoupon();

        String start_at = "2024-02-01";
        String end_at = "2024-03-01";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start_date;
        Date end_date;

        start_date = sdf.parse(start_at);
        end_date = sdf.parse(end_at);

        // Date 객체 Timestamp 객체 변환
        Timestamp start_timestamp = new Timestamp(start_date.getTime());
        Timestamp end_timestamp = new Timestamp(end_date.getTime());

        // 날짜별 사용가능한 쿠폰 31개 생성ㅁ
        for (int i = 0; i < 31; i++) {

            // given
            // 쿠폰 코드 난수 생성 => 중복 발생을 대비한 로직이 필요할까?
            UUID uuid = UUID.randomUUID();
            String couponCode = uuid.toString().replace("-", "").substring(0, 8);
            System.out.println("생성된 쿠폰 코드: " + couponCode);

            CouponDto couponDto = CouponDto.builder()
                    .coupon_id(couponCode)
                    .coupon_reg_at(CURRENT_TIMESTAMP)
                    .coupon_name("[웰컴 쿠폰] 1000원 할인")
                    .coupon_discount_amount(1000)
                    .coupon_min_order_amount(20000)
                    .coupon_use_yn("Y")
//                    .coupon_status("A") DEFAULT A 인서트
                    .coupon_useable_start_at("2024-02-01")
                    .coupon_useable_end_at("2026-02-01")
                    .coupon_use_condition("20000원 이상 구매시 사용 가능")
                    .coupon_description("중복 쿠폰 사용 불가한 쿠폰입니다")
//                    .created_at(CURRENT_TIMESTAMP) DEFAULT 현재시간
//                    .created_id("JISOO") DEFAULT "JISOO"
//                    .updated_at(CURRENT_TIMESTAMP) DEFAULT 현재시간
//                    .updated_id("JISOO")  DEFAULT "JISOO"
                    .build();

            // when
            adminDao.insertCoupon(couponDto);
        }

        // 날짜별 유효만료된 쿠폰 31개 생성
        for (int i = 0; i < 3; i++) {
            // given
            // 쿠폰 코드 난수 생성 => 중복 발생을 대비한 로직이 필요할까?
            UUID uuid = UUID.randomUUID();
            String couponCode = uuid.toString().replace("-", "").substring(0, 8);
            System.out.println("생성된 쿠폰 코드: " + couponCode);

            CouponDto couponDto = CouponDto.builder()
                    .coupon_id(couponCode)
                    .coupon_reg_at(CURRENT_TIMESTAMP)
                    .coupon_name("[웰컴 쿠폰] 2000원 할인")
                    .coupon_discount_amount(2000)
                    .coupon_min_order_amount(30000)
                    .coupon_use_yn("Y")
//                    .coupon_status("A") DEFAULT A 인서트
                    .coupon_useable_start_at("2023-01-01")
                    .coupon_useable_end_at("2024-02-01")
                    .coupon_use_condition("30000원 이상 구매시 사용 가능")
                    .coupon_description("중복 쿠폰 사용 불가한 쿠폰입니다")
//                    .created_at(CURRENT_TIMESTAMP) DEFAULT 현재시간
//                    .created_id("JISOO") DEFAULT "JISOO"
//                    .updated_at(CURRENT_TIMESTAMP) DEFAULT 현재시간
//                    .updated_id("JISOO")  DEFAULT "JISOO"
                    .build();

            // when
            adminDao.insertCoupon(couponDto);
            List<CouponDto> list = adminDao.selectAllCoupon();

            // then
            assertEquals(list.size(), adminDao.countAllCoupon());
            assertEquals(list.size(), adminDao.countAllCoupon());
        }

        // then
        assertTrue(adminDao.countAllCoupon() == 62);
    }

    @Test
    public void selectAllCoupon() throws Exception {


    }
    @Test
    public void countOptionNCoupon() throws Exception {
        // given
        Map<String, Object> map = new HashMap<>();
        map.put("option", "N");
        map.put("keyword", "1000원");
        map.put("start_date", "2023-02-01");
        map.put("end_date", "2026-03-05");

        // when
        int cnt = adminDao.countOptionCoupon(map);

        // then
        assertEquals(31, cnt);
    }

    @Test
    public void selectAllOptionCoupon() throws Exception {
        // given
        Map<String, Object> map = new HashMap<>();
        map.put("option", "N");
        map.put("keyword", "1000원");
        map.put("start_date", "2023-02-01");
        map.put("end_date", "2026-03-05");
        map.put("start", 0);
        map.put("limit", 10);

        // when
        List<CouponDto> list = adminDao.selectAllOptionCoupon(map);
        System.out.println("list = " + list);

        // then
//        assertEquals(10, list.size());
    }

    @Test
    public void insert5StageData() throws Exception {

        adminDao.deleteAllStage();

        // given => DB내에 존재한다 가정하는 공연장 테스트 데이터 5개 생성
        StageDto stageDto1 = new StageDto("1ad62b31", "올림픽공원 체조경기장", "서울특별시 송파구 올림픽로 424", 80, "조영상", "02-6000-0114", CURRENT_TIMESTAMP, "JISOO", CURRENT_TIMESTAMP, "JISOO");
        StageDto stageDto2 = new StageDto("2ad62b31", "서울예술의전당", "서울특별시 서초구 서초동 700", 900, "이철수", "02-580-1300", CURRENT_TIMESTAMP, "JISOO", CURRENT_TIMESTAMP, "JISOO");
        StageDto stageDto3 = new StageDto("3ad62b31", "세종문화회관", "서울특별시 종로구 세종로 175", 500, "박미영", "02-399-1114", CURRENT_TIMESTAMP, "JISOO", CURRENT_TIMESTAMP, "JISOO");
        StageDto stageDto4 = new StageDto("4ad62b31", "블루스퀘어", "서울특별시 용산구 이태원로 294", 700, "정성호", "02-1588-5212", CURRENT_TIMESTAMP, "JISOO", CURRENT_TIMESTAMP, "JISOO");
        StageDto stageDto5 = new StageDto("5ad62b31", "디큐브아트센터", "서울특별시 구로구 신도림동 360-51", 200, "조영상", "02-2211-3660", CURRENT_TIMESTAMP, "JISOO", CURRENT_TIMESTAMP, "JISOO");
        StageDto stageDto6 = new StageDto("6ad62b31", "올림픽공원 테니스장", "서울특별시 송파구 올림픽로 424", 40, "조영상", "02-6000-0114", CURRENT_TIMESTAMP, "JISOO", CURRENT_TIMESTAMP, "JISOO");

        // when, then
        assertEquals(1, adminDao.insertStage(stageDto1));
        assertEquals(1, adminDao.insertStage(stageDto2));
        assertEquals(1, adminDao.insertStage(stageDto3));
        assertEquals(1, adminDao.insertStage(stageDto4));
        assertEquals(1, adminDao.insertStage(stageDto5));
        assertEquals(1, adminDao.insertStage(stageDto6));
    }

    @Test
    public void selectKeywordStage() throws Exception {

        adminDao.deleteAllStage();

        // given => DB내에 존재한다 가정하는 공연장 테스트 데이터 5개 생성
        StageDto stageDto1 = new StageDto("1ad62b31", "올림픽공원 체조경기장", "서울특별시 송파구 올림픽로 424", 80, "조영상", "02-6000-0114", CURRENT_TIMESTAMP, "JISOO", CURRENT_TIMESTAMP, "JISOO");
        StageDto stageDto2 = new StageDto("2ad62b31", "서울예술의전당", "서울특별시 서초구 서초동 700", 900, "이철수", "02-580-1300", CURRENT_TIMESTAMP, "JISOO", CURRENT_TIMESTAMP, "JISOO");
        StageDto stageDto3 = new StageDto("3ad62b31", "세종문화회관", "서울특별시 종로구 세종로 175", 500, "박미영", "02-399-1114", CURRENT_TIMESTAMP, "JISOO", CURRENT_TIMESTAMP, "JISOO");
        StageDto stageDto4 = new StageDto("4ad62b31", "블루스퀘어", "서울특별시 용산구 이태원로 294", 700, "정성호", "02-1588-5212", CURRENT_TIMESTAMP, "JISOO", CURRENT_TIMESTAMP, "JISOO");
        StageDto stageDto5 = new StageDto("5ad62b31", "디큐브아트센터", "서울특별시 구로구 신도림동 360-51", 200, "조영상", "02-2211-3660", CURRENT_TIMESTAMP, "JISOO", CURRENT_TIMESTAMP, "JISOO");

        adminDao.insertStage(stageDto1);
        adminDao.insertStage(stageDto2);
        adminDao.insertStage(stageDto3);
        adminDao.insertStage(stageDto4);
        adminDao.insertStage(stageDto5);

        String keyword = "올림픽공원";

        // when
        List<StageDto> list = adminDao.selectKeywordStage(keyword);
        System.out.println("list = " + list);

        // then
        assertEquals(list.get(0).getStage_seat_cnt(), 80);
    }

//    @Test
//    public void showingRegisterSeatClass() throws Exception {
//
//        adminDao.deleteAllShoiwing();
//
//        // given
//        ShowingDto showingDto = new ShowingDto(0, "2024-02-27 13:53:00.0", "2024-03-27 13:53:00.0", "[1회] 13시 00분", "2024-03-15", "월,수,금", "BS", 80, 40000, "공연아이디1", "1ad62b31",
//                CURRENT_TIMESTAMP, "JISOO", CURRENT_TIMESTAMP, "JISOO");
//
//        int showingSeat = showingDto.getShowing_seat_cnt();
//        int showingSeq = showingDto.getShowing_seq();
//        String showingStageId = showingDto.getStage_id();
//        System.out.println("showSeat = " + showingSeat);
//
//        // 공연장 좌석 수에 따른 행과 열 계산
//        final int COL = 10;         // 좌석 수를 열의 총 개수 10으로 나눔.
//        int rows = showingSeat / COL;   // 80 / 10 => 8 행수 계산
//        char startRow = 'A';
//        char endRow = (char) (startRow + rows - 1);
//
//        ShowSeatDto showSeatDto = new ShowSeatDto();
//
//
//        System.out.println("========= 좌석 수 검증 시작 ===========");
//
//        System.out.println("열 개수 = " + COL);
//        System.out.println("총 행의 개수 = " + rows);
//        System.out.println("시작 Row 알파벳 startRow = " + startRow);
//        System.out.println("끝나는 Row 알파벳 endRow = " + endRow);
//
//        for (char row = startRow; row <= endRow; row++) {
//            for (int column = 1; column <= COL; column++) {
//                String seat = String.format("%c%d", row, column);
//                System.out.print(seat + " ");
//                showSeatDto.setShowing_seq(showingSeq);
//                showSeatDto.setSeat_row(new String(String.valueOf(row)));
//                showSeatDto.setSeat_col(column);
//                showSeatDto.setStage_id(showingStageId);
//                adminDao.insertShowSeat(showSeatDto);
//            }
//            System.out.println();
//        }
//
//        System.out.println("========= 좌석 수 검증 끝 ===========");
//
//        // when
//        int insertShoiwng = adminDao.insertShowing(showingDto);
//        System.out.println("testShowingDto = " + insertShoiwng);
//
//        // then
//        assertEquals(insertShoiwng, 1);
//    }
}