<%--
  Created by IntelliJ IDEA.
  User: 82109
  Date: 2024-02-01
  Time: 오전 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/login/login.css">
</head>
<body>
<div class="loginpage">
    <!-- 헤더 시작 -->
    <div class="login-header">
        <div class="login-headerArea">
            <h1>
                <a href="/" class="login-top-left" >
                    <img src="/resources/img/components/로고1.png" alt="JC TICKET" >
                </a>
                <span class="login-top-center">로그인</span>
            </h1>
            <div class="login-top-right">
                <a class="signup-logo" href="회원가입페이지">
                    <span class="signup-wrap"> 회원가입</span>
                </a>
            </div>
        </div>
    </div>
    <!-- 헤더 끝 -->

    <!-- 콘텐트영역 시작 -->
    <div class="login-content">
        <div class="login-form-wrap">
            <!-- 로그인 유저/기획사 선택 탭 시작 -->
            <div id="userAgency_Tab">
                <ul id="ulTab">
                    <li id="userTab">
                        <a id="userTabA" href="회원로그인탭">
                            <span class="tabTxt">회원 로그인</span>
                        </a>
                    </li>
                    <li id="agencyTab">
                        <a id="agencyTabA" href="기획사로그인탭">
                            <span class="tabTxt">기획사 로그인</span>
                        </a>
                    </li>
                </ul>
            </div>
            <!-- 로그인 유저/기획사 선택 탭 끝 -->
            <!-- 로그인 영역 시작 -->
            <div class="loginForm">
                <div class="memLoginForm">
                    <form method="post" name="LoginSub" autocomplete="off">
                        <fieldset class="formFieldSet">
                                <span id = spanMemID>
                                    <label for="SMemID">아이디</label>
                                    <input id="SMemID" name="SMemID" type="text" autocomplete="off" placeholder="아이디">
                                </span>
                            <span id = spanMemPWD>
                                    <label for="SMemID">패스워드</label>
                                    <input id="SMemPWD" name="SMemPWD" type="text" autocomplete="off" placeholder="비밀번호">
                                </span>
                            <div class="loginForm-chk">
                                    <span class="loginKeep">
                                        <label for="chkAutoLogin">
                                            로그인 상태 유지
                                        </label>
                                        <input id="chkAutoLogin" name="chkAutoLogin" type="checkbox" autocapitalize="off" class="iptChk" style="zoom: 1.5;">
                                    </span>
                                <span class="loginKeep">
                                        <label for="chkrememberID">
                                            아이디 저장
                                        </label>
                                        <input id="chkrememberID" name="chkrememberID" type="checkbox" autocapitalize="off" class="iptChk" style="zoom: 1.5;">
                                    </span>
                            </div>
                            <button type="button" id="loginBtn" title="로그인">
                                    <span class="btnWrap">
                                        <em class="txt">로그인</em>
                                    </span>
                            </button>
                        </fieldset>
                    </form>
                    <!-- 아이디 비번 찾기영역 시작-->
                    <div class="loginEtc">
                        <a href="아이디 찾기페이지" class="lnk_etc">아이디 찾기</a>
                        <a href="비밀번호 찾기페이지" class="lnk_etc">비밀번호 찾기</a>
                    </div>
                    <!-- 아이디 비번 찾기영역 끝 -->

                    <!-- 소셜 로그인 영역 시작  -->
                    <ul class="loginSocial">
                        <li class="loginNaver">
                            <a href="네이버로그인페이지" class="btn_social">
                                    <span class="socialWrap">
                                        <em class="social_icon_naver">
                                            <img src="/resources/img/login/네이버.png" class="naver_icon">
                                        </em>
                                        <em class="txt">네이버 아이디로 로그인</em>
                                    </span>
                            </a>
                        </li>
                        <li class="loginKakao">
                            <a href="카카오로그인페이지" class="btn_social">
                                    <span class="socialWrap">
                                        <em class="social_icon_kakao">
                                            <img src="/resources/img/login/카카오.png" class="kakao_icon" style="width: 22px; height: 21px;">
                                        </em>
                                        <em class="txt">카카오 아이디로 로그인</em>
                                    </span>
                            </a>
                        </li>
                        <li class="loginGoogle">
                            <a href="구글로그인페이지" class="btn_social">
                                    <span class="socialWrap">
                                        <em class="social_icon_google">
                                            <img src="/resources/img/login/구글.png" class="google_icon" style="width: 22px; height: 21px;">
                                        </em>
                                        <em class="txt">구글 아이디로 로그인</em>
                                    </span>
                            </a>
                        </li>
                    </ul>
                    <!-- 소셜 로그인 영역 끝 -->
                </div>
            </div>

            <!-- 로그인화면 포스터 시작 -->
            <div class="adArea">
                <div class="ad">
                    <img src="/resources/img/login/로그인화면_포스터.png" class="ad_img">
                </div>
            </div>
        </div>
    </div>
    <!-- 로그인 화면 하단배너 시작 -->
    <div id = loginBotBn>
        <img src="/resources/img/login/로그인_하단배너.gif">
    </div>
    <!-- 로그인 화면 하단배너 끝 -->

    <!-- 로그인 화면 Footer 시작 -->
    <div class="login-footer">
        <div class="login-bottom-copyright">
            <address>
                Copyright ©
                <strong>JC TICKET Corp.</strong>
                All Rights Reserved.
            </address>
        </div>
    </div>
</div>
</body>
</html>
