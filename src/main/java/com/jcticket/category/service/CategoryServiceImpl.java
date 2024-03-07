package com.jcticket.category.service;

import com.jcticket.category.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * packageName :  com.jcticket.category.service
 * fileName : CategoryServiceImpl
 * author :  jisoo Son
 * date : 2024-03-06
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-03-06             jisoo Son             최초 생성
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<Map<String, Object>> selectConcertList() throws Exception {
        return categoryDao.selectConcertList();
    }

    @Override
    public List<Map<String, Object>> selectMusicalList() throws Exception {
        return categoryDao.selectMusicalList();
    }

    @Override
    public List<Map<String, Object>> selectTheaterList() throws Exception {
        return categoryDao.selectTheaterList();
    }

    @Override
    public List<Map<String, Object>> selectClassicList() throws Exception {
        return categoryDao.selectClassicList();
    }

    @Override
    public List<Map<String, Object>> selectMusicalAndPlayList() throws Exception {
        return categoryDao.selectMusicalAndPlayList();
    }

    @Override
    public List<Map<String, Object>> selectConcertAndClassicList() throws Exception {
        return categoryDao.selectConcertAndClassicList();
    }
}