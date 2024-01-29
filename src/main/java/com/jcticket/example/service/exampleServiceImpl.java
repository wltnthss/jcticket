package com.jcticket.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jcticket.example.dao.exampleDao;

/**
 * packageName :  com.jcticket.example.service
 * fileName : exampleServiceImpl
 * author :  jisoo Son
 * date : 2024-01-29
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-01-29             jisoo Son             최초 생성
 */
@Service
public class exampleServiceImpl implements exampleService{

    @Autowired
    exampleDao dao;

    @Override
    public String test() throws Exception {
        return dao.test();
    }



}