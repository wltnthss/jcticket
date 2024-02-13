package com.jcticket.signup.dao;

import com.jcticket.signup.dto.SignupDto;
import com.jcticket.user.dto.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * packageName    : com.jcticket.signup.dao
 * fileName       : SignupDaoImpl
 * author         : jinwook Song
 * date           : 2024-02-07
 * description    : SignupDao구현
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-07        jinwook Song       최초 생성
 */
@Repository
public class SignupDaoImpl implements SignupDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "SignupMapper.";

    // user 테이블에 insert
    @Override
    public int insertUser(SignupDto signupDto) throws Exception {
        return session.insert(namespace+"signup",signupDto);
    }

    //아이디 중복검사
    @Override
    public int selectOne(String user_id) throws Exception {
        return session.selectOne(namespace+"chkIdDupl",user_id);
    }

    //닉네임 중복검사
    @Override
    public int selectNickName(String user_nickname) throws Exception {
        return session.selectOne(namespace+"chk_NickName_Dupl",user_nickname);
    }
}
