package com.jcticket.user.service;

import com.jcticket.user.dao.UserDao;
import com.jcticket.user.dto.UserDto;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * packageName    : com.jcticket.login.service
 * fileName       : LoginServiceImpl
 * author         : jinwook Song
 * date           : 2024-02-01
 * description    : LoginService 구현클래스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-01        jinwook Song       최초 생성
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    private JavaMailSender mailSender;

    //user_id에 맞는 유저 정보 가져옴
    @Override
    public UserDto getUser(String user_id)throws Exception{
        return userDao.select(user_id);
    }

    // user가 로그인 할때마다 1씩 증가. 방문횟수
    @Override
    public int increaseLoginCnt(String user_id) throws Exception {
        return userDao.increaseLoginCnt(user_id);
    }

    //회원가입(insert)
    @Override
    public int signup(UserDto userDto) throws Exception {
        return userDao.insert(userDto);
    }

    //아이디 중복검사
    @Override
    public int signupSNS(UserDto userDto) throws Exception {
        return userDao.insertSNS(userDto);
    }

    //아이디 중복검사
    @Override
    public int chkIdDupl(String user_id) throws Exception {
        return userDao.selectIdDupl(user_id);
    }

    //닉네임 중복검사
    @Override
    public int chkNickNameDupl(String user_nickname) throws Exception {
        return userDao.selectNickNameDupl(user_nickname);
    }

    @Override
    public int chkEmailDupl(String user_email) throws Exception {
        return userDao.selectEmailDupl(user_email);
    }

    @Override
    public void sendEmail(String user_email,int authNum) throws Exception {

        String from = "wlsdnr1233@naver.com"; // 보내는사람
        String to = user_email; // 받는사람
        String title = "회원가입시 필요한 인증번호 입니다."; //메일 제목
        String content = "[인증번호] "+authNum+" 입니다. <br/> 인증번호 확인란에 기입해주세요."; // 메일 내용

        MimeMessage mail = mailSender.createMimeMessage();
        MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "utf-8");

        mailHelper.setFrom(from);
        mailHelper.setTo(to);
        mailHelper.setSubject(title);
        mailHelper.setText(content, true);

        mailSender.send(mail);
    }

    @Override
    public boolean chkBirth(String user_birth) throws Exception {
        //검증할 날짜 포맷 설정
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        //false일경우 처리시 입력한 값이 잘못된 형식일 시 오류가 발생
        sdf.setLenient(false);

        //user_birth를 날짜로 parsing
        Date formatDate = sdf.parse(user_birth);

        // 입력한 생년월일이 1900년 1월 1일 이후인지 확인
        Calendar minDate = Calendar.getInstance();
        minDate.set(1900, Calendar.JANUARY, 1);

        if(formatDate.after(minDate.getTime())) {
            return true; // 유효한 범위 내에 있음
        }else{
            return false; // 범위를 벗어남
        }
    }

    //로그인 검사. 입력한 아이디의 비밀번호 일치하는지
    @Override
    public boolean loginCheck(String user_id, String user_password) throws Exception {
        if (user_id == null || user_id.isEmpty()) {
            System.out.println("아이디가 빈 값입니다.");
            return false;
        }

        if (user_password == null || user_password.isEmpty()) {
            System.out.println("비밀번호가 빈 값입니다.");
            return false;
        }

        try {
            UserDto userDto = null;
            userDto = userDao.select(user_id);
            System.out.println(userDto);
            return BCrypt.checkpw(user_password, userDto.getUser_password());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("false");
        return false;
    }

    //탈퇴회원이면 로그인 안되게
    @Override
    public boolean isUserRetired(String user_id) throws Exception {
        UserDto userDto = userDao.select(user_id);
        String retireYN = userDto.getUser_retire_yn();
        System.out.println("retireYN = " + retireYN);
        System.out.println(retireYN.equals("Y"));
        if (retireYN.equals("Y")){
            return true;
        }
        return false;
    }

    @Override
    public int deleteAll() throws Exception {
        return userDao.deleteAll();
    }

    @Override
    public int count() throws Exception {
        return userDao.count();
    }

    @Override
    public List<Map<String, Object>> selectImg() throws Exception {
        return userDao.selectImg();
    }
}
