package com.jcticket.user.sns;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.oauth.OAuth20Service;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Verb;


import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * packageName    : com.jcticket.user.sns
 * fileName       : KakaoLoginBO
 * author         : jinwook Song
 * date           : 2024-03-02
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-02        jinwook Song       최초 생성
 */
@Repository
public class KakaoLoginBO {
    // 카카오 로그인 정보
    private final static String KAKAO_CLIENT_ID = "ed620bc3417c6ec5d0e93f903ebdb659";
    private final static String KAKAO_CLIENT_SECRET = "hmGh2OcPtXB210YZkmOZkE5SL2sVK7Ty";
    private final static String KAKAO_REDIRECT_URI = "http://localhost:8080/login/kakaoCb";

    private final static String SESSION_STATE = "kakao_oauth_state";
    private final static String PROFILE_API_URL = "https://kapi.kakao.com/v2/user/me";

    public String getAuthorizationUrl(HttpSession session) {
        String state = generateRandomString();
        setSession(session, state);
        OAuth20Service oauthService = new ServiceBuilder()
                .apiKey(KAKAO_CLIENT_ID).apiSecret(KAKAO_CLIENT_SECRET)
                .callback(KAKAO_REDIRECT_URI)
                .state(state)
                .build(KakaoLoginApi.instance());
        return oauthService.getAuthorizationUrl();
    }

    public OAuth2AccessToken getAccessToken(HttpSession session, String code, String state) throws Exception {
        String sessionState = getSession(session);
        if (StringUtils.pathEquals(sessionState, state)) {
            OAuth20Service oauthService = new ServiceBuilder()
                    .apiKey(KAKAO_CLIENT_ID)
                    .apiSecret(KAKAO_CLIENT_SECRET)
                    .callback(KAKAO_REDIRECT_URI)
                    .state(state).build(KakaoLoginApi.instance());
            OAuth2AccessToken accessToken = oauthService.getAccessToken(code);
            return accessToken;
        }
        return null;
    }

    public String getUserProfile(OAuth2AccessToken oauthToken) throws Exception {
        OAuth20Service oauthService = new ServiceBuilder().apiKey(KAKAO_CLIENT_ID)
                .apiSecret(KAKAO_CLIENT_SECRET)
                .callback(KAKAO_REDIRECT_URI)
                .build(KakaoLoginApi.instance());
        OAuthRequest request = new OAuthRequest(Verb.GET, PROFILE_API_URL, oauthService);
        oauthService.signRequest(oauthToken, request);
        Response response = request.send();
        return response.getBody();
    }

    private String generateRandomString() {
        return UUID.randomUUID().toString();
    }

    private void setSession(HttpSession session, String state) {
        session.setAttribute(SESSION_STATE, state);
    }

    private String getSession(HttpSession session) {
        return (String) session.getAttribute(SESSION_STATE);
    }
}
