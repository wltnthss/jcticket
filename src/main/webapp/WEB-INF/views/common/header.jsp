<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="/resources/css/components/header.css">
</head>
<body>
<div class="top-wrap">
    <%-- 헤더시작 --%>
    <header class="play-top" id = "play-top">
        <!-- 좌측 -->
        <div class="play-top-left">
            <a href="/" class="top-main-logo">
                <img src="/resources/img/components/로고1.png" alt class="fixed"/>
                <img src="/resources/img/components/로고2.png" alt class="trans"/>
            </a>
        </div>
        <!-- 가운데 -->
        <div class="play-top-center" style="left : 500px; transform: none;">
            <a href="/concert">콘서트
                <span class="concert-sp"></span>
            </a>
            <a href="/musical">뮤지컬
                <span class="musical-sp"></span>
            </a>
            <a href="/play">연극
                <span class="play-sp"></span>
            </a>
            <a href="/classic">클래식
                <span class="classic-sp"></span>
            </a>
        </div>
        <!-- 오른쪽 -->
        <div class="play-top-right">
            <a href="/mypageIndex" class="my-page">
                <img src="/resources/img/components/마이페이지_흑.png" class="mp_icon">
            </a>
            <a href="/notice/paging" class="notice">
                <img src="/resources/img/components/공지사항_흑.png" class="notice_icon">
            </a>
            <c:choose>
                <c:when test="${empty sessionScope.sessionId}">
                    <!-- 로그인 상태가 아니면(세션이 없으면) 로그인 링크를 보여줌 -->
                    <a href="/login" class="login">
                        <img src="/resources/img/components/로그인_흑.png" class="login_icon">
                    </a>
                </c:when>
                <c:otherwise>
                    <!-- 로그인 상태이면(세션이 있으면) 로그아웃 링크를 보여줌 -->
                    <a href="/logout" class="logout" style="width: 22px;">
                        <img src="/resources/img/components/로그아웃_흑.png" class="logout_icon">
                    </a>
                </c:otherwise>
            </c:choose>
            <a class="search">
                <input type="text" id="searchWord" autocomplete="off" style="color: black">
                <img src="http://tkfile.yes24.com/imgNew/common/pf-srch-w.png" alt="" style="margin-left: 8px; cursor:pointer;" id="searchBtn">
            </a>
        </div>
    </header>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/6.8.4/swiper-bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="/resources/js/category/category.js"></script>

</body>
</html>
