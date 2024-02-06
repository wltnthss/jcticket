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
        .text_red {
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
        .seatRemain {
            border: solid 1px rgba(0, 0, 0, 0.1);
            padding: 20px 50px 125px 20px;
        }

        .five {
            border: solid black;
            padding: 10px 80px;
            margin-top: 50px;
        }

        .taketic {
            font-size: 18px;
        }

        .six {
            display: flex;
            width: 1200px;
            border-bottom: solid black;
            padding-top: 100px;
        }

        .six a > span {
            margin: 0;
            font-size: 18px;
            padding: 10px 40px 10px 40px;
            height : 60px;
            line-height: 60px;
        }

        .comment_cnt {
            font-size: 14px;
        }

        .info_box {
            width: 1200px;
        }

        .seven_text {
            text-align: center;
            font-size: 30px;
            font-weight: bold;
            padding: 30px 0 30px 0;
        }

        #seven_text_one {
            text-align: center;
            font-size: 30px;
            font-weight: bold;
            padding: 50px 0 40px 0;
            margin-bottom: 0;
        }

        .seven_con {
            margin-top: 50px;
            text-align: center;
        }

        .seven_table_main {
            width: 960px;
            margin: 0 auto 100px auto;
            border-collapse: collapse;
            border-spacing: 0;
            border-right: solid 1px rgba(0,0,0,0.1);
            border-top: solid rgba(0,0,0);
        }

        .seven_table_main tr {
            border-bottom: solid 1px rgba(0,0,0,0.1);
            height: 50px;
        }

        .seven_table_main td {
            text-align: left;
            padding-left: 16px;
            font-size: 13px;
        }

        .seven_table_main p {
            font-size: 13px;
            line-height: 25px;
        }

        .seven_table {
            background-color: rgba(0,0,0,0.05);
            font-size: 13px;
        }

        .seven_table_mini {
            width: 600px;
            border-collapse: collapse;
            border-spacing: 0;
            text-align: center;
        }

        .seven_table_mini tr {
            height: 15px;
            font-size: 13px;
        }

        .seven_table_mini th {
            padding-top: 5px;
            padding-bottom: 5px;
            background-color: rgba(81, 110, 253, 0.3);
        }

        .seven_table_mini td{
            font-size: inherit;
            text-align: center !important;
            padding-left: 0 !important;
            padding-top: 5px;
            padding-bottom: 5px;
        }

        .eight {
            border-top: solid;
            width: 1200px;
        }

        .eight_map {
            margin-top: 100px;
        }

        .map_name {
            font-size: 30px;
            font-weight: bold;
            text-align: center;
        }

        .map_location {
            font-size: 16px;
            text-align: center;
        }

        .map_icon_box {
            width: 800px;
            margin: 40px auto 0 auto;
            color: #ec7d2c;
            font-size: 13px;
            text-align: center;
            border-top: solid 1px rgba(0,0,0,0.1);
            padding: 50px 0 40px 0;
        }

        .comment_name {
            padding: 50px 0 50px 0;
            text-align: center;
            font-size: 30px;
        }

        .comment_name span {
            border-bottom: solid 4px black;
        }

        .comment_warning {
            display: flex;
            float: left;
            width: 1200px;
            padding-bottom: 10px;
        }

        .comment_warning img {
            width: 39px;
            height: 35px;
        }

        .span_box {
            font-size: 14px;
            margin-left: 10px;
        }

        #review_create {
            margin-left: auto;
            width: 178px;
            height: 34px;
        }

        .comment_board {
            width: 1200px;
            padding: 14px;
            margin: 0;
            border-top: solid 1px black ;
        }

        .comment_board > li {
            border-bottom: solid 1px rgba(0,0,0,0.1);
            padding-bottom: 19px;
        }

        .comment_board > li:last-child {
            border-bottom: solid 1px black;
        }

        .comment_page {
            display: flex;
            width: 1200px;
            justify-content: center;
        }

        .comment_page > a {
            display: inline-block;
            width: 30px;
            height: 30px;
            border: 1px solid rgba(0,0,0,0.1);
            text-align: center;
            line-height: 30px;
            margin: 5px 3px;
        }

        .comment_page div > a {
            display: inline-block;
            width: 30px;
            height: 30px;
            border: 1px solid rgba(0,0,0,0.1);
            text-align: center;
            line-height: 30px;
            margin: 5px 1px;
        }

        .comment_page div {
            margin: 0 20px;
        }

        .page_next img, .page_last img{
            transform: scaleX(-1);
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
                                            <span class="text_red">99,000</span>원
                                        </li>
                                        <li>
                                            R석
                                            <span class="text_red">79,000</span>원
                                        </li>
                                        <li>
                                            S석
                                            <span class="text_red">59,000</span>원
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
                                <span class="text_red">99,000</span>원
                            </li>
                            <li>
                                R석
                                <span class="text_red">79,000</span>원
                            </li>
                            <li>
                                S석
                                <span class="text_red">59,000</span>원
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

        <div class="five">
            <a class="taketic">예매하기</a>
        </div>


<%--            a태그마다 링크 걸어야함--%>
        <div class="six">
            <a>
                <span>상세정보</span>
            </a>
            <a>
<%--                댓글수 가져와야됨--%>
                <span>
                    관람후기
                    <span class="comment_cnt">(123)</span>
                </span>
            </a>
            <a>
                <span>예매/취소 안내</span>
            </a>
        </div>


        <div class="info_box">
            <div class="seven_one">
                <p class="seven_text">유의사항</p>
                <div class="seven_con">
                    <p>이미지 들어갈 자리</p>
<%--                    이미지 사이 공백--%>
                    <p><br></p>
                    <p>이미지 들어갈 자리</p>
                    <p><br></p>
                    <p>이미지 들어갈 자리</p>
                </div>
            </div>

            <div class="seven_two">
                <p class="seven_text">공연정보</p>
                <div class="seven_con">
                    <p>이미지 들어갈 자리</p>
                    <%--                    이미지 사이 공백--%>
                    <p><br></p>
                    <p>이미지 들어갈 자리</p>
                    <p><br></p>
                    <p>이미지 들어갈 자리</p>
                </div>
            </div>

            <div class="seven_three">
                <p id="seven_text_one">상품정보제공 고시</p>
                <div class="seven_con_table">
                    <div>
                        <table class="seven_table_main">
                            <colgroup>
                                <col width="18.5%">
                                <col width="31.5">
                                <col width="18.5%">
                                <col width="31.5">
                            </colgroup>
                            <tbody>
                                <tr>
                                    <th scope="row" class="seven_table">주최/기획</th>
                                    <td>제이씨티켓(주)_나는 오늘도 혼자서 논다</td>
                                    <th scope="row" class="seven_table">소비자상담</th>
                                    <td>제이씨티켓(주) 7777-7777</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="seven_table">주연</th>
                                    <td>개</td>
                                    <th scope="row" class="seven_table">관람등급</th>
                                    <td>전체이용가</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="seven_table">공연시간</th>
                                    <td>60분</td>
                                    <th scope="row" class="seven_table">공연장소</th>
                                    <td>쉼표도서관 2층</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="seven_table">취소/환불방법</th>
                                    <td colspan="3">
                                        <p>
                                            취소 일자에 따라 아래와 같이 취소수수료가 부과됩니다. 예매일보다 관람일 기준이 우선 적용되오니 유의해주시기 바랍니다.<br>
                                            단, 예매 후 7일 이내라도 취소시점이 공연일로부터 10일 이내라면 그에 해당하는 취소수수료가 부과됩니다.<br>
                                            (단, 상품에 따라 취소 정책이 달라질 수 있고, 각 공연이 공지하는 취소 정책이 우선 적용되므로, 예매 시 참고하시기 바랍니다.)
                                        </p>
                                        <div>
                                            <table class="seven_table_mini">
                                                <colgroup>
                                                    <col width="50">
                                                    <col width="50">
                                                </colgroup>
                                                <tbody>
                                                    <tr>
                                                        <th scope="col">취소일</th>
                                                        <th scope="col">취소수수료</th>
                                                    </tr>
                                                    <tr>
                                                        <td scope="col">예매 후 7일 이내</td>
                                                        <td scope="col">없음</td>
                                                    </tr>
                                                    <tr>
                                                        <td scope="col">예매 후 8일 ~ 관람일 10일 전까지</td>
                                                        <td scope="col">
                                                            <span class="text_red">장당 4,000원</span>
                                                            (단, 티켓 금액의 10% 이내)
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td scope="col">관람일 9일 전 ~ 관람일 7일 전까지</td>
                                                        <td scope="col">티켓 금액의 10%</td>
                                                    </tr>
                                                    <tr>
                                                        <td scope="col">관람일 6일 전 ~ 관람일 3일 전까지</td>
                                                        <td scope="col">티켓 금액의 20%</td>
                                                    </tr>
                                                    <tr>
                                                        <td scope="col">관람일 2일 전 ~ 취소마감일시까지</td>
                                                        <td scope="col">티켓 금액의 30%</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <p>
                                            예매수수료는 예매 당일 밤 12시 이전 취소 시에만 환불되며, 그 이후 기간에는 환불되지 않습니다.<br>
                                            취소는 MY공연>예매확인/취소 에서 직접 취소 또는 고객센터(7777-7777)를 통해 취소 가능합니다.<br>
                                            티켓이 배송된 후에는 PC/모바일 취소가 불가, 취소마감시간 이전에 제이씨티켓 고객센터로 티켓이 반송되어야 취소 가능합니다.<br>
                                            (취소수수료는 티켓 도착일 기준으로 부과되며, 배송비는 환불되지 않습니다.)<br>
                                        </p>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>

<%--                    <p>이미지 들어갈 자리</p>--%>
<%--                    &lt;%&ndash;                    이미지 사이 공백&ndash;%&gt;--%>
<%--                    <p><br></p>--%>
<%--                    <p>이미지 들어갈 자리</p>--%>
<%--                    <p><br></p>--%>
<%--                    <p>이미지 들어갈 자리</p>--%>
                </div>
            </div>

            <div class="eight">
                <div class="eight_map">
                    <p class="map_name">쉼표도서관</p>
                    <p class="map_location">경기도 시흥시 은행로 173번길 14</p>
                </div>
                <div class="map_icon_box">
                    <img src="/resources/img/viewdetail/path_icon.png"/><br>찾아가는길
                </div>

                <!-- 1. 지도 노드 -->
                <div id="daumRoughmapContainer1707022341823" class="root_daum_roughmap root_daum_roughmap_landing"></div>
            </div>

            <div class="nine">
                <div class="comment">
                    <div class="comment_name">
                        <span>관람후기</span>
                    </div>
                    <div class="comment_warning">
                        <img src="/resources/img/viewdetail/comment_icon.png/">
                        <div class="span_box">
                            <span class="text_red">매매, 욕설 등 예스24 게시판 운영 규정에 위반되는 글은 사전 통보없이 삭제될 수 있습니다.</span><br>
                            <span>개인정보가 포함된 내용은 삼가 주시기 바라며, 게시물로 인해 발생하는 문제는 작성자 본인에게 책임이 있습니다.</span>
                        </div>
                        <img id="review_create" src="/resources/img/viewdetail/review_create.png/"/>
                    </div>
                </div>
                <div class="comment_board_container">
                    <ul class="comment_board">
                        <li>
                            <div claas="comment_user">
<%--                                예매자만 후기 작성 가능하도록 할 것--%>
                                <span>예매자</span>
                                <span>유저아이디</span>
                                <span>후기등록일</span>
                                <span>별점</span>
                                <span>관람일자</span>
                            </div>
                            <div class="comment_text">
                                유익한 특강이었어요
                            </div>
<%--                            a태그는 후기 내용이 길때 더보기 기능/버튼--%>
                            <a>
                                <img src=""/>
                            </a>
                        </li>

<%--                        :last-child 테스트--%>
                        <li>
                            <div claas="comment_user">
                                <span>예매자</span>
                                <span>유저아이디</span>
                                <span>후기등록일</span>
                                <span>별점</span>
                                <span>관람일자</span>
                            </div>
                            <div class="comment_text">
                                대한민국 최고의 명강의 입니다 꼭 들으세요
                            </div>
                            <a>
                                <img src=""/>
                            </a>
                        </li>
<%--                        :last-child 테스트--%>

                    </ul>
                    <div class="comment_page">
                        <a class="page_first"><img src="/resources/img/viewdetail/backback.png/"/></a>
                        <a class="page_prev"><img src="/resources/img/viewdetail/back.png/"/></a>
<%--                        페이징--%>
                        <div>
                            <a><span>1</span></a>
                            <a><span>2</span></a>
                            <a><span>3</span></a>
                            <a><span>4</span></a>
                            <a><span>5</span></a>
                            <a><span>6</span></a>
                            <a><span>7</span></a>
                            <a><span>8</span></a>
                            <a><span>9</span></a>
                            <a><span>10</span></a>
                        </div>
                        <a class="page_next"><img src="/resources/img/viewdetail/backback.png/"/></a>
                        <a class="page_last"><img src="/resources/img/viewdetail/back.png/"/></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../common/footer.jsp"></jsp:include>

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
    <%--    datepicker 제이쿼리 달력 끝--%>

    <!--
    2. 지도 설치 스크립트
    * 지도 퍼가기 서비스를 2개 이상 넣을 경우, 설치 스크립트는 하나만 삽입합니다.
    -->
    <script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

    <!-- 3. 지도 실행 스크립트 -->
    <script charset="UTF-8">
        new daum.roughmap.Lander({
            "timestamp" : "1707022341823",
            "key" : "2hy9x",
            "mapWidth" : "1200",
            "mapHeight" : "700"
        }).render();
    </script>
</body>
</html>


