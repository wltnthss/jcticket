<%--
  Created by IntelliJ IDEA.
  User: 82109
  Date: 2024-02-07
  Time: 오전 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/agency/agencyheader.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
</head>
<body>
    <header class="agency-dashboard-header">
        <div class="agency-dashboard-wrap">
            <div class="agency-dashboard-logo">
                <a href="/agency/dashboard">
                    <img src="http://demofran.com/admin/img/logo.gif"  alt class="trans"/>
                </a>
            </div>
            <div class="header-stat">
                <ul>
                    <li><a style="cursor: default">${sessionScope.agencyNickName}님 환영합니다</a></li>
                    <li><a href="/agency/setting">사용자정보</a></li>
                    <li><a href="/agency/dashboard">홈</a></li>
                    <li><a href="/index">메인홈</a></li>
                    <li><a href="/login" class="agency-logout">로그아웃</a></li>
                </ul>
            </div>
            <nav class="header-nav">
                <ul class="header-nav-ul">
                    <li class="header-nav-li">
                        <a href="/agency/productlist" class="header_nav-a">상품등록내역</a>
                    </li>
                    <li class="header-nav-li">
                        <a href="/agency/sale" class="header_nav-a">판매중</a>
                    </li>
                    <li class="header-nav-li">
                        <a href="/agency/rollout" class="header_nav-a">신규/판매예정</a>
                    </li>
                    <li class="header-nav-li">
                        <a href="/agency/soldout" class="header_nav-a">판매종료</a>
                    </li>
                    <li class="header-nav-li">
                        <a href="/agency/enroll" class="header_nav-a">신규등록</a>
                    </li>
                    <li class="header-nav-li">
                        <a href="#" class="header_nav-a">상품관리</a>
                    </li>
                    <li class="header-nav-li">
                        <a href="#" class="header_nav-a">오픈공지</a>
                    </li>
                    <li class="header-nav-li">
                        <a href="#" class="header_nav-a">환경설정</a>
                    </li>
                </ul>
            </nav>
        </div>
    </header>
</body>
</html>
