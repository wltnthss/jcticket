<%--
  Created by IntelliJ IDEA.
  User: wjswo
  Date: 2024-01-31
  Time: 오후 7:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>마이페이지</title>

    <style>

        #wrap {
            text-align: center;
        }

        #wrap-center {
            width: 1300px;
            display: inline-block;
        }

        #top {
            display: inline;
            text-align: left;
            height: 500px;
        }

        #ticket {
            text-align: left;
        }

        #ticket_img > a {
            float: left;
        }

        #my_ticket {

        }

        #my_ticket > ul {
            padding-left: 0px;
            width: 210px;
            border: 1px solid;
            float: left;
            list-style: none;
        }

        #middle {
            display: inline;
        }

    </style>
</head>
    <link rel="icon" href="/resources/css/img/KakaoTalk_20240131_192702986_02.ico">
<body>

    <jsp:include page="../common/header.jsp"></jsp:include>

    <hr>

    <div id="wrap">
        <div id="wrap-center">
            <div id="top">
                <div id="ticket"><img src="/resources/css/img/lnb_mypage.gif" alt="my_ticket"></div>
            </div>
            <div id="middle"></div>
                <div id="my_ticket">
                    <ul>
                        <li>예매확인/취소</li>
                        <hr>
                        <li>할인쿠폰/예매권</li>
                        <hr>
                        <li>나의 관람 공연</li>
                        <hr>
                        <li>나의 맞춤 설정</li>
                    </ul>
                </div>
            <div id="bottom"></div>
        </div>
    </div>

    <jsp:include page="../common/footer.jsp"></jsp:include>

</body>
</html>
