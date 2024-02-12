package com.jcticket.admin.service;

import com.jcticket.admin.dao.AdminDao;
import com.jcticket.admin.dto.AdminDto;
import com.jcticket.admin.dto.UserPageDto;
import com.jcticket.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public AdminDto login(AdminDto adminDto) throws Exception {
        return adminDao.login(adminDto);
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
    public UserPageDto pagingParam(int page, String option, String keyword) throws Exception {

        System.out.println("serviceImpl option => " + option);
        System.out.println("serviceImpl keyword => " + keyword);

        // 전체 글 개수 조회
        Map<String, Object> pagingParams = new HashMap<>();

        pagingParams.put("option", option);
        pagingParams.put("keyword", keyword);

        int userCount = adminDao.usercnt(pagingParams);
        System.out.println("userCount => " + userCount);

        // 전체 페이지 갯수 계산 ex) 24 / 10 => 2.4 => 3
        int maxPage = (int) (Math.ceil((double) userCount / pageLimit));
        // 시작 페이지 값 계산 (1, 11, 21 ...)
        int startPage = (((int) (Math.ceil((double) page / blockLimit))) -1 ) * blockLimit + 1;
        // 끝 페이지 값 계산 (10, 20, 30...)
        int endPage = startPage + blockLimit - 1;

        if(endPage > maxPage){
            endPage = maxPage;
        }

        UserPageDto userPageDto = new UserPageDto();
        userPageDto.setPage(page);
        userPageDto.setMaxPage(maxPage);
        userPageDto.setStartPage(startPage);
        userPageDto.setEndPage(endPage);
        userPageDto.setOption(option);
        userPageDto.setKeyword(keyword);

        return userPageDto;
    }

    @Override
    public int userInsert(UserDto userDto) throws Exception {
        return adminDao.insertUser(userDto);
    }

    @Override
    public int userDelete(String user_id) throws Exception {
        return adminDao.userDelete(user_id);
    }
}