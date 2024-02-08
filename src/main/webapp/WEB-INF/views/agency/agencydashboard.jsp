<%--
  Created by IntelliJ IDEA.
  User: 82109
  Date: 2024-02-07
  Time: 오전 11:24
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/components/header.css">
    <link rel="stylesheet" href="/resources/css/notice/notice.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
        <a href="/login" class="login" style="width: 22px;">
            <img src="/resources/img/components/로그인.png" class="login_icon">
        </a>
        <a href="로그아웃" class="logout" style="width: 22px;">
            <img src="/resources/img/components/로그아웃.png" class="logout_icon">
        </a>
    </div>

</header>

<%-- content area    --%>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>
