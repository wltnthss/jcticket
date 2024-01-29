<%--
  Created by IntelliJ IDEA.
  User: 82109
  Date: 2024-01-29
  Time: 오후 8:00
  To change this template use File | Settings | File Templates.
--%>
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
      <a href="메인페이지 이동" class="top-main-logo">
        <img src="https://lh3.google.com/u/0/d/11bTCKMYdqnoLT2uxl9rPDg2GF6aUqDQz=w2560-h1398-iv1" alt class="fixed"/>
        <img src="https://lh3.google.com/u/0/d/13ae-NtB5g7QhfSQ_J7I5LcDF4zMKYu3l=w1680-h1398-iv1" alt class="trans"/>
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
    <a href="마이페이지 이동" class="my-page" style="width: 22px;"></a>
    <a href="고객센터 이동" class="customer-service" style="width: 22px;"></a>
    <a href="로그인" class="login" style="width: 22px;"></a>
    <a href="로그아웃" class="logout" style="width: 18px;"></a>
  </div>
</header>
</body>
</html>
