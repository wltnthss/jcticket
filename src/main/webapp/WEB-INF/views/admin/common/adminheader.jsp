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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/adminheader.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
</head>
<body>
    <header class="admin-dashboard-header">
        <div class="admin-dashboard-wrap">
            <div class="admin-dashboard-logo">
                <a href="${pageContext.request.contextPath}/admin/dashboard">
                    <img src="http://demofran.com/admin/img/logo.gif"  alt class="trans"/>
                </a>
            </div>
            <div class="header-stat">
                <ul>
                    <li><a style="cursor: default" id="timer"></a></li>
                    <li><a style="cursor: default">${sessionScope.adminNickName}님 환영합니다</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/setting">관리자정보</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/dashboard">관리자홈</a></li>
                    <li><a href="${pageContext.request.contextPath}/index">메인홈</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/logout" class="admin-logout">로그아웃</a></li>
                </ul>
            </div>
            <nav class="header-nav">
                <ul class="header-nav-ul">
                    <li class="header-nav-li">
                        <a href="${pageContext.request.contextPath}/admin/user" class="header_nav-a">회원관리</a>
                    </li>
                    <li class="header-nav-li">
                        <a href="${pageContext.request.contextPath}/admin/agency" class="header_nav-a">기획사관리</a>
                    </li>
                    <li class="header-nav-li">
                        <a href="${pageContext.request.contextPath}/admin/product" class="header_nav-a">상품관리</a>
                    </li>
                    <li class="header-nav-li">
                        <a href="${pageContext.request.contextPath}/admin/notice" class="header_nav-a">공지사항관리</a>
                    </li>
<%--                    <li class="header-nav-li">--%>
<%--                        <a href="/admin/inquiry" class="header_nav-a">문의관리</a>--%>
<%--                    </li>--%>
                    <li class="header-nav-li">
                        <a href="${pageContext.request.contextPath}/admin/coupon" class="header_nav-a">쿠폰관리</a>
                    </li>
                    <li class="header-nav-li">
                        <a href="${pageContext.request.contextPath}/admin/setting" class="header_nav-a">환경설정</a>
                    </li>
                </ul>
            </nav>
        </div>
    </header>

    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/admin/admin.js"></script>

<script>
    $(function () {

        // 세션 유효시간 카운트 다운 기능
        let startTime = "${sessionScope.startTime}";
        console.log("전역변수 유효시간 startTime => " + startTime);

        // 세션 만료 시간 (60분 후)을 계산하는 함수
        function calculateExpirationTime() {
            let expirationTime = new Date(startTime);
            expirationTime.setMinutes(expirationTime.getMinutes() + 60);

            return expirationTime;
        }
        // 세션 타이머 업데이트 함수
        function updateSessionTimer() {
            let currentTime = new Date();
            let timeLeft = calculateExpirationTime() - currentTime;

            // 시간을 분, 초로 변환
            let minutes = Math.floor(timeLeft / (60 * 1000));
            let seconds = Math.floor((timeLeft / 1000) % 60);

            // 남은 시간을 표시
            document.getElementById('timer').innerHTML = minutes + "분 " + seconds + "초 남았습니다.";

            // 만약 시간이 종료되면 로그아웃 또는 세션 만료 처리
            if (timeLeft <= 0) {
                // 로그아웃 처리
                document.getElementById('timer').innerHTML = "세션이 만료되었습니다.";
                alert('세션이 만료되었습니다. 다시 로그인해주세요.');
                location.href = "/admin/logout";
                // 만료 시 다시 세션 시작 시간 초기화
                startTime = null;
            }
        }
        // 세션 시작 함수
        function startSession() {

            startTime = new Date();
            console.log("세션 시작 유효시간 startTime => " + startTime);

            updateSessionTimer();
            // 1초마다 세션 타이머 업데이트
            setInterval(updateSessionTimer, 1000);
        }
        // 세션 시작 함수 호출
        startSession();
    })
</script>

</body>
</html>
