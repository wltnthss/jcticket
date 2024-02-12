<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="/resources/css/components/header.css">
</head>
<body>
<header class="play-top" id = "play-top">
  <!-- 좌측 -->
  <div class="play-top-left">
    <h1>
      <a href="/" class="top-main-logo">
        <img src="/resources/img/components/로고1.png" alt class="fixed"/>
        <img src="/resources/img/components/로고2.png" alt class="trans"/>
      </a>
    </h1>
  </div>

  <!-- 가운데 -->
  <div class="play-top-center" style="left : 500px; transform: none;">
    <h2><a href="콘서트 페이지">콘서트</a></h2>
    <h2><a href="뮤지컬 페이지">뮤지컬</a></h2>
    <h2><a href="연극 페이지">연극</a></h2>
    <h2><a href="클래식 페이지">클래식</a></h2>
  </div>
  <!-- 오른쪽 -->
    <div class="play-top-right">
        <a href="마이페이지" class="my-page" style="width: 22px;">
            <img src="/resources/img/components/마이페이지.png" class="mp_icon">
        </a>
        <a href="고객센터 이동" class="customer-service" style="width: 22px;">
            <img src="/resources/img/components/고객센터.png" class="cs_icon">
        </a>
        <a href="/notice/paging" class="notice" style="width: 22px;">
            <img src="/resources/img/components/공지사항.png" class="notice_icon">
        </a>
        <c:choose>
            <c:when test="${empty sessionScope.user_id}">
                <!-- 로그인 상태가 아니면(세션이 없으면) 로그인 링크를 보여줌 -->
                <a href="/login" class="login" style="width: 22px;">
                    <img src="/resources/img/components/로그인.png" class="login_icon">
                </a>
            </c:when>
            <c:otherwise>
                <!-- 로그인 상태이면(세션이 있으면) 로그아웃 링크를 보여줌 -->
                <a href="/logout" class="logout" style="width: 22px;">
                    <img src="/resources/img/components/로그아웃.png" class="logout_icon">
                </a>
            </c:otherwise>
        </c:choose>
    </div>

</header>
</body>
</html>
