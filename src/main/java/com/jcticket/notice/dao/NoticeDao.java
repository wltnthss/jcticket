package com.jcticket.notice.dao;

import com.jcticket.notice.dto.NoticeDto;

import java.util.List;

/**
 * packageName :  com.jcticket.notice.dao
 * fileName : NoticeDao
 * author :  jisoo Son
 * date : 2024-01-31
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-01-31             jisoo Son             최초 생성
 */
public interface NoticeDao {
    String test() throws Exception;

    List<NoticeDto> list() throws Exception;

}