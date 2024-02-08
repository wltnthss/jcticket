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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="/resources/css/viewdetail/jquery-ui.css">

</head>
<body>
    <!-- 팝업창에서 사용할 영역크기 정의-->
    <div class="area">
    <!-- left section -->
    <div class="left-section">
    <!-- header 영역 -->
        <div class="header">
            <div class="item-logo">
                <img src="/resources/img/ticketing/logo.png" alt="logo">
            </div>
            <div class="item-header nav1">
                <b>step.1<br/>날짜선택</b>
            </div>
            <div class="item-header nav2">
                <b>step.2<br/>좌석선택</b>
            </div>
            <div class="item-header nav3">
                <b>step.3<br/>쿠폰/할인</b>
            </div>
            <div class="item-header nav4">
                <b>step.4<br/>결제방법</b>
            </div>
        </div>

    <!-- contents 영역 -->
        <div class="contents">
            <div class="step-01">
                <div class="contents-header">
                    <div class="ch first">
                        <a>일정선택</a>
                    </div>
                    <div class="ch second">
                        <a>회차선택</a>
                    </div>
                </div>
                <div class="contents-body">
                    <div class="contents-body-left">
                        <div id="datepicker"></div>
                    </div>
                    <div class="contents-body-right">
                        <div class="round">
                            <a>1회 오후 1시 00분</a>
                            <a>2회 오후 4시 00분</a>
                            <a>testetstetstset</a>
                            <a>testetstetstset</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="step-02"></div>
            <div class="step-03"></div>
            <div class="step-04"></div>
        </div>
    </div>
    <div class="right-section">

    </div>



<%--    <!-- contents 영역 -->--%>
<%--        <div class="contents-container">--%>

<%--        <!-- contents-main 영역 -->--%>
<%--            <div class="contents-main">--%>
<%--                <div id="step1">--%>
<%--                    <div class="contents-main-header">--%>
<%--                        <div class="select date">--%>
<%--                            <p>일정 선택</p>--%>
<%--                        </div>--%>
<%--                        <div class="select round">--%>
<%--                            <p>회차선택</p>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="calender">--%>
<%--                        &lt;%&ndash;datepicker 캘린더&ndash;%&gt;--%>
<%--                        <div id="datepicker">--%>
<%--                        </div>--%>
<%--                        <div class="show-round">--%>
<%--                            <a>1부 오후 1시 00분</a>--%>
<%--                            <a>2부 오후 3시 00분</a>--%>
<%--                            <a>testtesttesttest</a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div id="step2">--%>

<%--                </div>--%>
<%--                <div id="step3">--%>

<%--                </div>--%>
<%--                <div id="step4">--%>

<%--                </div>--%>
<%--            </div>--%>

<%--        <!-- contents-side 영역 -->--%>
<%--            <div class="contents-side">--%>

<%--            </div>--%>
<%--        </div>--%>

    </div>

        <%--    datepicker 제이쿼리 달력--%>
        <script type="text/javascript" src="/resources/js/viewdetail/jquery-ui.min.js"></script>
        <script>
            $(document).ready(function() {
                $("#datepicker").datepicker();
            });

            $.datepicker.setDefaults({
                dateFormat: 'yy-mm-dd',
                prevText: '이전 달',
                nextText: '다음 달',
                monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
                monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
                dayNames: ['일', '월', '화', '수', '목', '금', '토'],
                dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
                dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
                showMonthAfterYear: true,
                yearSuffix: '년'
            });
        </script>
</body>
</html>
