<%--
  Created by IntelliJ IDEA.
  User: Gram17
  Date: 2024-02-06
  Time: 오전 1:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/admin/adminheader.css">
</head>
<body>
    <header class="admin-dashboard-header">
        <div class="admin-dashboard-wrap">
            <div class="admin-dashboard-logo">
                <a href="#">
                    <img src="http://demofran.com/admin/img/logo.gif"  alt class="trans"/>
                </a>
            </div>
            <div class="header-stat">
                <ul>
                    <li><a style="cursor: default">관리자님 환영합니다</a></li>
                    <li><a href="#">관리자정보</a></li>
                    <li><a href="/admin/dashboard">관리자홈</a></li>
                    <li><a href="/index">메인홈</a></li>
                    <li><a href="/admin" class="admin-logout">로그아웃</a></li>
                </ul>
            </div>
            <nav class="header-nav">
                <ul class="header-nav-ul">
                    <li class="header-nav-li">
                        <a href="#" class="header_nav-a">회원관리</a>
                    </li>
                    <li class="header-nav-li">
                        <a href="#" class="header_nav-a">기획사관리</a>
                    </li>
                    <li class="header-nav-li">
                        <a href="#" class="header_nav-a">상품관리</a>
                    </li>
                    <li class="header-nav-li">
                        <a href="#" class="header_nav-a">공지사항관리</a>
                    </li>
                    <li class="header-nav-li">
                        <a href="#" class="header_nav-a">문의관리</a>
                    </li>
                    <li class="header-nav-li">
                        <a href="#" class="header_nav-a">쿠폰관리</a>
                    </li>
                    <li class="header-nav-li">
                        <a href="#" class="header_nav-a">통계분석</a>
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
