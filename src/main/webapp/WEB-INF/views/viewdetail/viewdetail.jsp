git <%--
  Created by IntelliJ IDEA.
  User: kyd54
  Date: 2024-01-31
  Time: 오후 2:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<%--    jQuery--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="/resources/css/viewdetail/jquery-ui.css">
    <style>
        body {
            margin-right: 5%;
            margin-left: 30px;
        }

        .container{
            display: grid;
            width: 100%;
            margin-top: 20px;
            padding: 80px 24px 0 24px;
            border-top: solid rgba(0, 0, 0, 0.1);
            place-items: center;
        }

        .category {
            width: 1200px;
            font-size: 14px;
        }

        .two {
            width: 1200px;
            font-size: 40px;
        }
        .big-title{
            margin-top: 10px;
            margin-bottom: 0px;
            font-weight: bold;
        }

        .two-one {
            border-bottom: solid 2px rgba(0, 0, 0);
            padding-bottom: 10px;
            margin-bottom: 30px;
        }

        .play-period {
            border-right: solid rgba(0, 0, 0, 0.1);
            font-size: 16px;
        }

        .stage-name {
            padding-left: 5px;
            font-size: 16px;
        }

        .url-image{
            float: right;
        }

        .play-img img {
            width: 430px;
        }

        .three {
            display: flex;
            width: 1200px;
            place-items: center;
        }

        .three-one-left {
            float: left;
            flex-direction: column;
            margin-right: 70px;
            width: 430px;
        }

        .star-review {
            display: flex;
            flex-direction: row;
            margin-top: 10px;
            margin-bottom: 10px;
            padding-bottom: 15px;
            border-bottom: solid rgba(0, 0, 0, 0.1);
        }

        .review {
            margin-left: auto;
        }

        .three-one-right {
            display: flex;
            flex-direction: column;
            width: 700px;
        }

        .play-info dt {
            font-weight: bold;
            float: left;
        }

        .play-info dd {
            margin-left: 100px;
            margin-bottom: 15px;
        }

        .playtime-info dt {
            font-weight: bold;
            margin-top: 15px;
            margin-bottom: 5px;
        }

        .playtime-info dd {
            margin-left: 0;
            margin-bottom: 5px;
            font-size: 14px;
        }

        .playtime-info {
            border-top: solid rgba(0, 0, 0, 0.5);
            border-bottom: solid rgba(0, 0, 0, 0.5);
            padding-top: 16px;
            padding-bottom: 16px;
        }


        ul {
            float: left;
            list-style-type: none;
        }

        li {
            list-style-type: none;
            margin-bottom: 10px;
        }
        .price-zone {
            width: 560px;
            background-color: rgba(0, 0, 0, 0.03);
            padding: 10px 0 10px 20px;
            margin-top: 0;
        }
        .price-red {
            color: red;
        }

        .four-one {
            display: flex;
            width: 1200px;
        }

        .fourLeft {
            border-top: solid 1px rgba(0, 0, 0, 0.3);
            border-right: solid 1px darkorange;
            border-bottom: solid 1px rgba(0, 0, 0, 0.3);
            border-left: solid 1px rgba(0, 0, 0, 0.3);
            padding: 30px 50px;
            margin-top: 40px;
        }

        .four-text {
            font-size: 16px;
            font-weight: bold;
            margin-top: 0;
            margin-bottom: 30px;
            padding-bottom: 10px;
            border-bottom: solid 2px black;
        }

        .calender {
            display: flex;
        }

        #datepicker {
            width: 320px;
            border-right: solid rgba(0, 0, 0, 0.1);
        }

        .showing {
            width: 230px;
        }

        .showing a {
            display: block;
            margin-left: 30px;
            margin-bottom: 10px;
            border: solid rgba(0, 0, 0, 0.1);
            padding: 5px 20px;
            text-align: center;
        }

        .fourRight {
            border-right: solid 1px rgba(0, 0, 0, 0.3);
            border-bottom: solid 1px rgba(0, 0, 0, 0.3);
            border-top: solid 1px rgba(0, 0, 0, 0.3);
            padding: 30px 50px;
            margin-top: 40px;
        }

        .fourLeft, .fourRight {
            flex: 1;
        }

        .seatRemain dt{
            float: left;
        }

        .seatRemain dd {
            float: left;
            margin-left: 5px;
        }


    </style>
</head>
<body>
    <jsp:include page="../common/header.jsp"></jsp:include>
    <div class="container">
        <%-- content area    --%>
        <div class="category">
            <a class="major-cat">
                콘서트
            </a>
            >
            <a class="middle-cat">
                강연
            </a>
        </div>

    <%--    나중에 two 아래 css로 밑줄 만들것--%>
        <div class="two">
        <%--제목--%>
            <p class="big-title">2022 <나는 오늘도 혼자서 논다> -시흥</p>
                <div class="two-one">
        <%--            <p>--%>
                        <span class="play-period">
                            2022.07.24
                        </span>
                        <span class="stage-name">
                            쉼표 도서관 2층
                        </span>

                        <a href="javascript:void(0);" class="url-image">
                            <img src="https://lh3.google.com/u/0/d/1SmiUAaDs829IOthlFJHUTLQT8GQF_lyI=w2880-h1462-iv1" alt="">
                        </a>
        <%--            </p>--%>
                </div>
        </div>

        <div class="three">
            <div class="three-one">
                <div class="three-one-left">
                    <div class="play-img">
                        <img src='/resources/img/viewdetail/testposter.jpg'/>
<%--                        <a href="#" class="rn-product-movie" style="display:none;"><img src="http://tkfile.yes24.com/imgNew/common/kv-movie.png" alt="" /></a>--%>
                    </div>
    <%--                review-mini안에 별점, 평균별점, 리뷰 수 등등 들어감--%>
                    <div class="star-review">
                        <div class="review-star">
                            <div class="review-star-info">
                                ★★★★★
                            </div>
                        </div>
                        <span class="review">
                            <em>5</em>
                             *123
                            <span>Reviews</span>
                        </span>
                    </div>
                </div>
    <%--            three-one-left--%>
                <div class="three-one-right">
                    <div class="play-info">
                        <dl>
    <%--                        dt에 float : left 주면 dt dd 일렬로 나옴--%>
                            <dt>등급</dt>
                            <dd>&nbsp;전체이용가</dd>
                            <dt>관람시간</dt>
                            <dd>&nbsp;60분</dd>
                            <dt>출연</dt>
                            <dd>&nbsp;개</dd>
                            <dt id="dtPrice">가격</dt>
                            <dd id="ddPrice">
    <%--                            price-zone 마진 없애면 동일선상으로 나옴--%>
                                <ul class="price-zone">
                                    <div id="seat-grade">
                                        <li>
                                            VIP석
                                            <span class="price-red">99,000</span>원
                                        </li>
                                        <li>
                                            R석
                                            <span class="price-red">79,000</span>원
                                        </li>
                                        <li>
                                            S석
                                            <span class="price-red">59,000</span>원
                                        </li>
                                    </div>
                                </ul>
                            </dd>
                        </dl>
                    </div>
    <%--                등급, 관람시간, 출연, 가격--%>
                    <div class="playtime-info">
                        <dl>
                            <dt>공연시간 안내</dt>
    <%--                        <dd> left margin 지우면 옆으로 딱 붙음--%>
                            <dd>1부: 13:00, 2부: 15:00</dd>
                            <dt>배송정보</dt>
                            <dd>현장 수령만 가능</dd>
                        </dl>
                    </div>
                </div>
            </div>
        </div>

        <div class="four">
            <div class="four-one">
                <div class="fourLeft" id="leftH">
                    <p class="four-text">
                        날짜/시간 선택
                    </p>
                    <div class="calender">
<%--                        datepicker 캘린더--%>
                        <div id="datepicker"></div>
                        <div class="showing">
                            <a>1부 오후 1시 00분</a>
                            <a>2부 오후 3시 00분</a>
                        </div>
                    </div>
                </div>
                <div class="fourRight" id="rightH">
                    <p class="four-text">
                        예매 가능 좌석
                    </p>
                    <div class="seat_info">
                        <dl class="seatRemain">
                            <li>
                                VIP석
                                <span class="price-red">99,000</span>원
                            </li>
                            <li>
                                R석
                                <span class="price-red">79,000</span>원
                            </li>
                            <li>
                                S석
                                <span class="price-red">59,000</span>원
                            </li>

<%--                            <dt>VIP석</dt>--%>
<%--                            <dd>99,000원--%>
<%--                                <span>&nbsp;(잔여:0석)</span>--%>
<%--                            </dd><br>--%>
<%--                            <dt>R석</dt>--%>
<%--                            <dd>79,000원--%>
<%--                                <span>&nbsp;(잔여:2석)</span>--%>
<%--                            </dd><br>--%>
<%--                            <dt>S석</dt>--%>
<%--                            <dd>59,000원--%>
<%--                                <span>&nbsp;(잔여:1석)</span>--%>
<%--                            </dd><br>--%>
                        </dl>
                    </div>
                </div>
            </div>

        </div>


    </div>
    <jsp:include page="../common/footer.jsp"></jsp:include>

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