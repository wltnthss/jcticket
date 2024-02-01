<%--
  Created by IntelliJ IDEA.
  User: wjswo
  Date: 2024-01-30
  Time: 오후 4:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>마이페이지</title>

    <style>

        #my_info {
            width: 208px;
            border: 1px solid;
        }

        #point_part {
            padding: 2px;
            list-style: none;
            margin: 5px;
            width: 190px;
            border: 1px solid cadetblue;
            border-radius: 10px;
        }

        #modify_part {
            border: 1px solid black;
            border-radius: 5px;
            margin: 5px 50px;
        }

        #modify_part > a {
            padding-left: 2px;
            text-decoration-line: none;
        }

        #reservation_part {
            border: 3px solid cadetblue;
            width: 203px;
        }

        #reservation_part > ul {
            padding-left: 5px;
            list-style: none;
        }

        #client_part {
            padding-left: 15px;
        }

        #client_part > li {
            list-style: none;
        }

        #client_info {
            padding-left: 15px;
        }


    </style>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>


    <hr>
    <br>

    <img src="/resources/css/img/lnb_mypage.gif">
    <div id="my_info">
        <h5 id="client_info">전재승님은 일반회원입니다.</h5>

    <ul id="point_part">
        <li>YES포인트: 250원 <a href="">>안내</a></li>
        <li>YES머니: 250원 </li>
        <li>YES상품권: 250원 </li>
        <li>예치금: 250원 </li>
    </ul>

    <div id="modify_part"><a  href="">회원 정보수정</a></div>
    </div>

    <br>

    <div id="reservation_part">
        <ul>
            <li> 예매확인/취소</li>
            <hr>
            <li> 할인쿠폰/예매권</li>
            <hr>
            <li> 나의 관람 공연</li>
            <hr>
            <li> 나의 맞춤 설정</li>
            <hr>
        </ul>
    </div>



    <div id="client_part">
        <p class="title">
            <strong>고객센터 전화상담</strong>
        </p>

        <img src="/resources/css/img/txt_telnum.gif">

        <br>
        <br>

        <li>평일  09:00 ~ 18:00</li>
        <li>평일  09:00 ~ 18:00</li>
        <li>일요일 공휴일 휴무</li>
    </div>

    <hr>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
