package com.jcticket.user.sns;

import com.github.scribejava.core.builder.api.DefaultApi20;

/**
 * packageName    : com.jcticket.user.sns
 * fileName       : NaverLoginApi
 * author         : jinwook Song
 * date           : 2024-02-26
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-26        jinwook Song       최초 생성
 */
public class NaverLoginApi extends DefaultApi20 {

    protected NaverLoginApi(){}


    private static class InstanceHolder{
        private static final NaverLoginApi INSTANCE = new NaverLoginApi();
    }

    public static NaverLoginApi instance(){
        return InstanceHolder.INSTANCE;
    }

    @Override
    public String getAccessTokenEndpoint() {
        return "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code";
    }

    @Override
    protected String getAuthorizationBaseUrl() {
        return "https://nid.naver.com/oauth2.0/authorize";
    }
}