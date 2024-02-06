package com.jcticket.admin.dao;

import com.jcticket.admin.dto.AdminDto;
import com.jcticket.user.dto.UserDto;

import java.util.List;

/**
 * packageName :  com.jcticket.admin.dao
 * fileName : AdminDao
 * author :  jisoo Son
 * date : 2024-02-05
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05             jisoo Son             최초 생성
 */
public interface AdminDao {
    AdminDto login(AdminDto adminDto) throws Exception;

    List<UserDto> userstatics() throws Exception;
}