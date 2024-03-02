package com.jcticket.user.sns;

import com.github.scribejava.core.builder.api.DefaultApi20;

/**
 * packageName    : com.jcticket.user.sns
 * fileName       : KakaoLoginApi
 * author         : jinwook Song
 * date           : 2024-03-02
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-02        jinwook Song       최초 생성
 */
public class KakaoLoginApi extends DefaultApi20 {
    protected KakaoLoginApi() {
    }

    private static class InstanceHolder {
        private static final KakaoLoginApi INSTANCE = new KakaoLoginApi();
    }

    public static KakaoLoginApi instance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public String getAccessTokenEndpoint() {
        return "https://kauth.kakao.com/oauth/token";
    }

    @Override
    protected String getAuthorizationBaseUrl() {
        return "https://kauth.kakao.com/oauth/authorize";
    }

}
