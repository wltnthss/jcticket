package com.jcticket.admin.service;

import com.jcticket.admin.dao.AdminDao;
import com.jcticket.admin.dto.*;
import com.jcticket.agency.dto.AgencyDto;
import com.jcticket.user.dto.UserDto;
import com.jcticket.viewdetail.dto.ShowingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
    public void adminAllDelete() throws Exception {
        adminDao.adminAllDelete();
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
    @Override
    public List<CouponDto> selectAllCoupon() throws Exception {
        return adminDao.selectAllCoupon();
    }
    @Override
    public int countAllCoupon() throws Exception {
        return adminDao.countAllCoupon();
    }
    @Override
    public int countOptionCoupon(Map<String, Object> map)throws Exception {

        return adminDao.countOptionCoupon(map);
    }
    @Override
    public List<CouponDto> selectAllOptionCoupon(int page, String option, String keyword, String start_at, String end_at) throws Exception {
        // 1 page 당 보여주는 글 개수 10
        /*
            1page => 0
            2page => 10
            3page => 20
         */

        // 1page 는 0부터 2page는 10부터 3page는 20부터 시작
        int pagingStart = (page - 1) * pageLimit;
        List<CouponDto> pagingList = null;

        Map<String, Object> pagingParams = new HashMap<>();

        pagingParams.put("start", pagingStart);
        pagingParams.put("limit", pageLimit);
        pagingParams.put("option", option);
        pagingParams.put("keyword", keyword);
        pagingParams.put("start_date", start_at);
        pagingParams.put("end_date", end_at);

        pagingList = adminDao.selectAllOptionCoupon(pagingParams);

        return pagingList;
    }

    @Override
    public PageDto couponPagingParam(int page, String option, String keyword, String start_at, String end_at) throws Exception {
        // 전체 글 개수 조회
        Map<String, Object> pagingParams = new HashMap<>();

        pagingParams.put("option", option);
        pagingParams.put("keyword", keyword);
        pagingParams.put("start_date", start_at);
        pagingParams.put("end_date", end_at);

        int couponCnt = adminDao.countOptionCoupon(pagingParams);

        // 전체 페이지 갯수 계산 ex) 24 / 10 => 2.4 => 3
        int maxPage = (int) (Math.ceil((double) couponCnt / pageLimit));
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
        pageDto.setStart_at(start_at);
        pageDto.setEnd_at(end_at);

        return pageDto;
    }

    @Override
    public void deleteCoupon(String coupon_id) throws Exception {
        adminDao.deleteCoupon(coupon_id);
    }

    @Override
    public List<StageDto> selectKeywordStage(String keyword) throws Exception {
        return adminDao.selectKeywordStage(keyword);
    }

    @Override
    public List<PlayDto> selectKeywordPlay(String keyword) throws Exception {
        return adminDao.selectKeywordPlay(keyword);
    }

    @Override
    public int insertShowing(ShowingDto showingDto) throws Exception {
        return adminDao.insertShowing(showingDto);
    }

    @Override
    public void deleteAllShoiwing() throws Exception {
        adminDao.deleteAllShoiwing();
    }

    @Override
    public int insertShowSeat(ShowSeatDto showSeatDto) throws Exception {
        return adminDao.insertShowSeat(showSeatDto);
    }

    @Override
    public void insertPlay(PlayDto playDto) throws Exception {

        final String FILE_PATH = "C:/play_img/";

        // 공연 아이디 랜덤 난수 8글자 insert 하기 위함
        UUID uuid = UUID.randomUUID();
        String idCode = uuid.toString().replace("-", "").substring(0, 8);
        playDto.setPlay_id(idCode);

        System.out.println("공연 Dto .. play_id = " + playDto.getPlay_id());

        // 임시 기획사 아이디 insert
        String agency_id = "agency1";
        playDto.setAgency_id(agency_id);

        System.out.println("공연 Dto .. agency_id = " + playDto.getAgency_id());

        if ((playDto.getPlay_poster().isEmpty() && playDto.getPlay_info().isEmpty())) {
            // 1. 파일 첨부를 하지 않은 경우

            // 파일 첨부 여부 판별 후 파일 첨부 없이 insert
            playDto.setPlay_file_yn("N");
            adminDao.insertPlay(playDto);
        } else{
            // 2. 파일 첨부를 진행한 경우

            // 파일 첨부 여부 판별
            playDto.setPlay_file_yn("N");
            adminDao.insertPlay(playDto);

            /*
                1. 파일 따로 가져옴
                2. 파일 이름 가져옴
                3. 서버 저장용 이름을 만듬
                4. PlayImgDto 세팅 (저장한 파일의 경로를 저장하기 위함)
                5. 저장 경로 설정
                6. 해당 경로에 파일 저장
                8. PlayImgTable에 해당 데이터 insert 처리
            */
            // 1.
            MultipartFile playPoster = playDto.getPlay_poster();
            MultipartFile playInfo = playDto.getPlay_info();
            // 2.
            String posterOriginalFileName = playPoster.getOriginalFilename();
            String infoOriginalFileName = playInfo.getOriginalFilename();
            // 3.
            String posterStoredFileName = System.currentTimeMillis() + "-" + posterOriginalFileName;
            String infoStoredFileName = System.currentTimeMillis() + "-" + infoOriginalFileName;
            // 4.
            PlayImgDto playImgDto = new PlayImgDto();
            playImgDto.setPlay_id(idCode);
            playImgDto.setPlay_poster_original_file_name(posterOriginalFileName);
            playImgDto.setPlay_poster_stored_file_name(posterStoredFileName);
            playImgDto.setPlay_info_original_file_name(infoOriginalFileName);
            playImgDto.setPlay_info_stored_file_name(infoStoredFileName);
            // 5.
            String savePosterPath = FILE_PATH + posterStoredFileName;
            String saveInfoPath = FILE_PATH + infoStoredFileName;
            // 6.
            playPoster.transferTo(new File(savePosterPath));
            playInfo.transferTo(new File(saveInfoPath));

            adminDao.insertPlayImg(playImgDto);
        }
    }
}