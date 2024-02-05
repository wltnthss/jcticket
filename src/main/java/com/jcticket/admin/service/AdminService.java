package com.jcticket.admin.service;

import com.jcticket.admin.dto.AdminDto;

/**
 * packageName :  com.jcticket.admin.service
 * fileName : AdminService
 * author :  jisoo Son
 * date : 2024-02-05
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05             jisoo Son             최초 생성
 */
public interface AdminService {
    AdminDto login(AdminDto adminDto) throws Exception;
}