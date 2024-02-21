package com.jcticket.admin.service;

import com.jcticket.admin.dao.AdminDao;
import com.jcticket.admin.dto.AdminDto;
import com.jcticket.admin.dto.CouponDto;
import com.jcticket.admin.dto.PageDto;
import com.jcticket.agency.dto.AgencyDto;
import com.jcticket.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * packageName :  com.jcticket.admin.service
 * fileName : AdminServiceImpl
 * author :  jisoo Son
 * date : 2024-02-05
 * description : 관리자 ServiceImpl
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05             jisoo Son             최초 생성
 */
@Controller
public class AdminServiceImpl implements AdminService {

    final int pageLimit = 10;   // 한 페이지당 보여줄 글 개수
    final int blockLimit = 10;  // 하단에 보여줄 페이지 번호

    @Autowired
    AdminDao adminDao;

    @Override
    public AdminDto adminLogin(Map<String, Object> map) throws Exception {
        return adminDao.adminLogin(map);
    }

    @Override
    public List<UserDto> userstatics() throws Exception {
        return adminDao.userstatics();
    }

    @Override
    public int usercnt(String option, String keyword) throws Exception {

        Map<String, Object> pagingParams = new HashMap<>();

        pagingParams.put("option", option);
        pagingParams.put("keyword", keyword);

        return adminDao.usercnt(pagingParams);
    }

    @Override
    public List<UserDto> userPaingList(int page, String option, String keyword) throws Exception {
        // 1 page 당 보여주는 글 개수 10
        /*
            1page => 0
            2page => 10
            3page => 20
         */

        // 1page 는 0부터 2page는 10부터 3page는 20부터 시작
        int pagingStart = (page - 1) * pageLimit;
        List<UserDto> pagingList = null;

        Map<String, Object> pagingParams = new HashMap<>();

        pagingParams.put("start", pagingStart);
        pagingParams.put("limit", pageLimit);
        pagingParams.put("option", option);
        pagingParams.put("keyword", keyword);

        pagingList = adminDao.userPaingList(pagingParams);

        return pagingList;
    }

    @Override
    public PageDto userPagingParam(int page, String option, String keyword) throws Exception {

        // 전체 글 개수 조회
        Map<String, Object> pagingParams = new HashMap<>();

        pagingParams.put("option", option);
        pagingParams.put("keyword", keyword);

        int userCount = adminDao.usercnt(pagingParams);

        // 전체 페이지 갯수 계산 ex) 24 / 10 => 2.4 => 3
        int maxPage = (int) (Math.ceil((double) userCount / pageLimit));
        // 시작 페이지 값 계산 (1, 11, 21 ...)
        int startPage = (((int) (Math.ceil((double) page / blockLimit))) -1 ) * blockLimit + 1;
        // 끝 페이지 값 계산 (10, 20, 30...)
        int endPage = startPage + blockLimit - 1;
        // 이전, 다음 링크 계산
        boolean showPrev = page != 1;
        boolean showNext = page != maxPage;

        if(endPage > maxPage){
            endPage = maxPage;
        }

        PageDto pageDto = new PageDto();
        pageDto.setPage(page);
        pageDto.setMaxPage(maxPage);
        pageDto.setStartPage(startPage);
        pageDto.setEndPage(endPage);
        pageDto.setShowPrev(showPrev);
        pageDto.setShowNext(showNext);
        pageDto.setOption(option);
        pageDto.setKeyword(keyword);

        return pageDto;
    }

    @Override
    public int userInsert(UserDto userDto) throws Exception {
        return adminDao.insertUser(userDto);
    }

    @Override
    public int userDelete(String user_id) throws Exception {
        return adminDao.userRetireUpdate(user_id);
    }

    @Override
    public int insertAgency(AgencyDto agencyDto) throws Exception {
        return adminDao.insertAgency(agencyDto);
    }

    @Override
    public int agencyCnt(String option, String keyword) throws Exception {
        Map<String, Object> pagingParams = new HashMap<>();

        pagingParams.put("option", option);
        pagingParams.put("keyword", keyword);

        return adminDao.usercnt(pagingParams);
    }

    @Override
    public List<AgencyDto> agencyPaingList(int page, String option, String keyword) throws Exception {
        // 1 page 당 보여주는 글 개수 10
        /*
            1page => 0
            2page => 10
            3page => 20
         */

        // 1page 는 0부터 2page는 10부터 3page는 20부터 시작
        int pagingStart = (page - 1) * pageLimit;
        List<AgencyDto> pagingList = null;

        Map<String, Object> pagingParams = new HashMap<>();

        pagingParams.put("start", pagingStart);
        pagingParams.put("limit", pageLimit);
        pagingParams.put("option", option);
        pagingParams.put("keyword", keyword);

        pagingList = adminDao.agencyPaingList(pagingParams);

        return pagingList;
    }

    @Override
    public PageDto agencyPagingParam(int page, String option, String keyword) throws Exception {

        // 전체 글 개수 조회
        Map<String, Object> pagingParams = new HashMap<>();

        pagingParams.put("option", option);
        pagingParams.put("keyword", keyword);

        int agencyCnt = adminDao.agencyCnt(pagingParams);

        // 전체 페이지 갯수 계산 ex) 24 / 10 => 2.4 => 3
        int maxPage = (int) (Math.ceil((double) agencyCnt / pageLimit));
        // 시작 페이지 값 계산 (1, 11, 21 ...)
        int startPage = (((int) (Math.ceil((double) page / blockLimit))) -1 ) * blockLimit + 1;
        // 끝 페이지 값 계산 (10, 20, 30...)
        int endPage = startPage + blockLimit - 1;
        // 이전, 다음 링크 계산
        boolean showPrev = page != 1;
        boolean showNext = page != maxPage;

        if(endPage > maxPage){
            endPage = maxPage;
        }

        PageDto pageDto = new PageDto();
        pageDto.setPage(page);
        pageDto.setMaxPage(maxPage);
        pageDto.setStartPage(startPage);
        pageDto.setEndPage(endPage);
        pageDto.setShowPrev(showPrev);
        pageDto.setShowNext(showNext);
        pageDto.setOption(option);
        pageDto.setKeyword(keyword);

        return pageDto;
    }

    @Override
    public int noticeDelete(int notice_seq) throws Exception {
        return adminDao.noticeDelete(notice_seq);
    }

    @Override
    public int dupleAdminId(String admin_id) throws Exception {
        return adminDao.dupleAdminId(admin_id);
    }

    @Override
    public int updateAdminInfo(AdminDto adminDto) throws Exception {
        return adminDao.updateAdminInfo(adminDto);
    }

    @Override
    public AdminDto showAdminInfo(String admin_id) throws Exception {
        return adminDao.showAdminInfo(admin_id);
    }

    @Override
    public int insertCoupon(CouponDto couponDto) throws Exception {

        // 쿠폰 아이디 랜덤 난수 8글자 insert 하기 위함
        UUID uuid = UUID.randomUUID();
        String couponCode = uuid.toString().replace("-", "").substring(0, 8);
        couponDto.setCoupon_id(couponCode);

        System.out.println("couponDto.getCoupon_id() = " + couponDto.getCoupon_id());

        return adminDao.insertCoupon(couponDto);
    }

}