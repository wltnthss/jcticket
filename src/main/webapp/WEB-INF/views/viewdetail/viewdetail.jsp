<%--
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
    <style>
        body {
            /*margin: 0;*/
            /*place-items: center;*/
            margin-right: 5%;
            margin-left: 30px;
        }

        .container{
            display: grid;
            width: 100%;
            padding-top: 80px;
            border-top: solid rgba(0, 0, 0, 0.1);
            padding-left: 24px;
            padding-right: 24px;
            place-items: center;
        }

        .category {
            width: 1200px;
            font-size: 14px;
            /*float: left;*/
        }

        .two {
            width: 1200px;
            font-size: 40px;
            /*float: left;*/
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
            width: 400px;
        }

        .three {
            display: flex;
            position: relative;
            right: 90px;
            /*place-items: normal;*/
            /*float: left;*/
        }

        .three-one-left {
            /*display: flex;*/
            float: left;
            flex-direction: column;
            margin-right: 60px;
        }

        .star-review {
            display: flex;
            flex-direction: row;
        }

        .review {
            margin-left: auto;
        }

        .three-one-right {
            display: flex;
            flex-direction: column;
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
                        <img src='/resources/images/viewdetail/testposter.jpg'/>
    <%--                    <a href="#" class="rn-product-movie" style="display:none;"><img src="http://tkfile.yes24.com/imgNew/common/kv-movie.png" alt="" /></a>--%>
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
                            <dt style="float: left">등급</dt>
                            <dd>&nbsp;12세 이상 관람가</dd>
                            <dt>관람시간</dt>
                            <dd>&nbsp;150분</dd>
                            <dt>출연</dt>
                            <dd>-</dd>
                            <dt id="dtPrice" style="float: left">가격</dt>
                            <dd id="ddPrice">

    <%--                            price-zone 마진 없애면 동일선상으로 나옴--%>
                                <ul class="price-zone">
                                    <div id="seat-grade">
                                        <li>
                                            VIP석
                                            <span class="price-red">99,000</span>
                                            원
                                        </li>
                                        <li>
                                            R석
                                            <span class="price-red">79,000</span>
                                            원
                                        </li>
                                        <li>
                                            S석
                                            <span class="price-red">59,000</span>
                                            원
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
                            <dd>화·목·금 7시 30분 / 수 3시, 7시 30분 / 토·일·공휴일 2시, 6시 30분(월 쉼)</dd>
                            <dt>배송정보</dt>
                            <dd>현장 수령만 가능</dd>
                        </dl>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <jsp:include page="../common/footer.jsp"></jsp:include>

</body>
</html>