<%--
  Created by IntelliJ IDEA.
  User: joyoungsang
  Date: 2/5/24
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="Pragma" content="no-cache">
    <title>JCTicket 에매</title>
    <link href="/resources/css/ticketing/ticketing.css" rel="stylesheet" type="text/css">

</head>
<body>
    <!-- 팝업창 전체 감싸는 영역 -->
    <div id="wrap">
    <!-- header 영역 -->
        <div id="header" class="header">
            <h1>
                <img src="/resources/img/ticketing/logo.png" alt="logo">
            </h1>
            <ul>
                <li class="progress-1">
                    <span>날짜 선택</span>
                </li>
                <li class="progress-2">
                    <span>좌석 선택</span>
                </li>
                <li class="progress-3">
                    <span>할인/쿠폰</span>
                </li>
                <li class="progress-4">
                    <span>결제방법</span>
                </li>
            </ul>
        </div>

    <!-- contents 영역 -->
        <div id="contents">
            <div id="contents-header">
                <div id="nav1" class="nav">
                    <span>날짜 선택</span>
                </div>
                <div id="nav2" class="nav">
                    <span>회차 선택</span>
                </div>
            </div>
            <div id="step1">
                <div id="step1-calendar">

                </div>
            </div>
            <div id="step2">

            </div>
            <div id="step3">

            </div>
            <div id="step4">

            </div>
        </div>

    <!-- result 영역 (선택결과)-->
        <div id="result">

        </div>
    </div>

</body>
</html>
