package com.jcticket.category.service;

import java.util.List;
import java.util.Map;

/**
 * packageName :  com.jcticket.category.service
 * fileName : CategoryService
 * author :  jisoo Son
 * date : 2024-03-06
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-03-06             jisoo Son             최초 생성
 */
public interface CategoryService {

    // 카테고리별 회차 조회
    List<Map<String, Object>> selectConcertList() throws Exception;
    List<Map<String, Object>> selectMusicalList() throws Exception;
    List<Map<String, Object>> selectTheaterList() throws Exception;
    List<Map<String, Object>> selectClassicList() throws Exception;

    // 메인 2개쌍 회차별 조회
    List<Map<String, Object>> selectMusicalAndPlayList() throws Exception;
    List<Map<String, Object>> selectConcertAndClassicList() throws Exception;

    // 메인 search 기능
    List<Map<String, Object>> mainSearchShowingList(String word) throws Exception;
}