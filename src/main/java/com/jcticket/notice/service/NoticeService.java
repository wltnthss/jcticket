package com.jcticket.notice.service;

import com.jcticket.notice.dao.NoticeDao;
import com.jcticket.notice.dto.NoticeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName :  com.jcticket.notice.service
 * fileName : NoticeService
 * author :  jisoo Son
 * date : 2024-01-31
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-01-31             jisoo Son             최초 생성
 */
public interface NoticeService {
    List<NoticeDto> list() throws Exception;
}