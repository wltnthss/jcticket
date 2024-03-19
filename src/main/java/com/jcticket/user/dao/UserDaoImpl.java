package com.jcticket.user.dao;

import com.jcticket.user.dto.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * packageName    : com.jcticket.user
 * fileName       : UserDaoImpl
 * author         : jinwook Song
 * date           : 2024-02-01
 * description    : Dao 구현한 클래스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-01        jinwook Song       최초 생성
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "UserMapper.";

    // user_id로 user정보를 가져옴
    @Override
    public UserDto select(String user_id){
        return session.selectOne(namespace+"select", user_id);
    }

    // user가 로그인 시 1씩 증가. 방문횟수
    @Override
    public int increaseLoginCnt(String user_id) {return session.update(namespace+"increase_visit_cnt", user_id);}

    //아이디 중복검사
    @Override
    public int selectIdDupl(String user_id) throws Exception {
        return session.selectOne(namespace+"chkIdDupl",user_id);
    }

    //닉네임 중복검사
    @Override
    public int selectNickNameDupl(String user_nickname) throws Exception {
        return session.selectOne(namespace+"chk_NickName_Dupl",user_nickname);
    }

    @Override
    public int selectEmailDupl(String user_email) throws Exception {
        return session.selectOne(namespace+"chk_Email_Dupl",user_email);
    }

    //회원가입
    @Override
    public int insert(UserDto userDto) throws Exception {
        return session.insert(namespace+"insert",userDto);
    }

    @Override
    public List<Map<String, Object>> selectImg() throws Exception {
        return session.selectList(namespace+"selectImg");
    }

    @Override
    public int insertSNS(UserDto userDto) throws Exception {
        return session.insert(namespace+"signupSNS",userDto);
    }

    @Override
    public int count() throws Exception {
        return session.selectOne(namespace+"count");
    }

    @Override
    public int delete(String user_id) throws Exception {
        return session.delete(namespace+"delete",user_id);
    }


    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace+"deleteAll");
    }
}
