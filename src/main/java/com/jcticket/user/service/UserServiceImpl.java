package com.jcticket.user.service;

import com.jcticket.user.dao.UserDao;
import com.jcticket.user.dto.UserDto;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
