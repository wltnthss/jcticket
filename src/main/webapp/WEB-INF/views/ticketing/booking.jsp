<%--
  Created by IntelliJ IDEA.
  User: joyoungsang
  Date: 2/10/24
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>JCticket 예매하기</title>
    <script>console.log("bookig.jsp 진입")</script>
<%--    jQuery--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<%--    bootstrap--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<%--    datepicker--%>
    <link rel="stylesheet" href="/resources/css/ticketing/datepicker-ui.css">
    <link rel="stylesheet" href="/resources/css/ticketing/booking.css">
    <style>

    </style>

<%--  그리드 컨테이너   --%>

<%--  그리드 아이템    --%>
</head>
<body>
<%
    String name = (String)session.getAttribute("sessionId");
%>
<input id="user_id" value="<%=name%>" type="hidden">
<!-- Horizontal Steppers -->
<div class="container-fluid">
    <div class="row justify-content-center" >
        <div class="col-11 col-sm-9 col-md-7 col-lg-6 col-xl-5 text-center p-0 mt-3 mb-2">
            <div class="card px-0 pt-4 pb-0 mt-3 mb-3">
                <h2 id="heading">예매하기</h2>
                <div class="row align-items-center mb-1">
                    <div class="col-4">
                        <%-- 이미지 들어갈 자리--%>
                        <img id="posterinfo" src='/resources/img/viewdetail/testposter.jpg'/>
                    </div>
                    <div class="col-8 text-left">
                        <input type="hidden" id="play_id" value="${play_id}">
                        <table class="table table-borderless">
                            <tbody>
                            <tr>
                                <th scope="row" style="width: 30%">공연명</th>
                                <%--데이터 받아오기: playname --%>
                                <td>${play_name}</td>
                            </tr>
                            <tr>
                                <th scope="row">공연일시</th>
                                <%-- 데이터 받아오기: showing_info, showing_day--%>
                                <td>
                                    <c:forEach var="date" items="${list}" varStatus="loop">
                                        <a class="dateShow"><c:out value="${date}" /></a>
                                        <c:if test="${!loop.last}">,</c:if>
                                    </c:forEach>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">공연장</th>
                                <%--데이터 받아오기: stagename --%>
                                <td>${stage_name}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <form id="msform">
                    <!-- progressbar -->
                    <ul id="progressbar">
                        <li class="active" id="date"><strong>일정선택</strong></li>
                        <li id="seat"><strong>좌석선택</strong></li>
                        <li id="coupon"><strong>할인/쿠폰</strong></li>
                        <li id="payment"><strong>결제방법</strong></li>
                    </ul>
                    <fieldset>
                        <div class="form-card">
                            <div class="row">
                                <div class="col-7">
                                    <h3 class="fs-title">날짜선택</h3>
                                </div>
                                <div class="col-5">
                                    <h3 class="fs-title2">회차선택</h3>
                                </div>
                            </div>
                            <div class="calendar row">
                                <div id="datepicker" class="col-7"></div>
                                <div id="round" class="col-5">
                                        <div class="shadow p-2 mb-2 rounded box"><a></a></div>
<%--                                    회차 들어갈 자리--%>
<%--                                    <div class="shadow p-2 mb-2 bg-white rounded"><a>${date_text}</a></div>--%>
<%--                                    <div class="shadow p-2 mb-2 bg-white rounded"></div>--%>
<%--                                    <div class="shadow p-2 mb-2 bg-white rounded"></div>--%>
                                </div>
                            </div>
                        </div> <input id="first-bnt" type="button" name="next" class="next action-button" value="다음단계" />
                    </fieldset>

                    <%-- step2. 좌석선택 --%>
                    <fieldset>
                        <div class="form-card">
                            <div class="row">
                                <div class="col-12">
                                    <h2 class="fs-title">좌석선택</h2>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-8">
                                    <div id="seatsArea" class="select-seat">
                                    </div>
                                </div>
                                <div class="col-4">
                                    <div class="selected-seats head">
                                        <p>선택좌석내역</p>
                                    </div>
                                    <div id="ss" class="selected-seats">
                                    </div>
                                    <div class="selected-price head">
                                        <p>선택좌석가격</p>
                                    </div>
                                    <div id="sp" class="selected-price"></div>
                                </div>

                            </div>
                        </div> <input id="second-btn" type="button" name="next" class="next action-button" value="다음단계" /> <input type="button" name="previous" class="previous action-button-previous" value="이전단계" />
                    </fieldset>
                    <fieldset>
                        <div class="form-card">
                            <div class="row">
                                <div class="col-12">
                                    <h2 class="fs-title">쿠폰/할인</h2>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <h3 class="couponList">선택 가능한 쿠폰</h3>
                                </div>
                            </div>
                        </div> <input id="third-btn" type="button" name="next" class="next action-button" value="다음단계" /> <input type="button" name="previous" class="previous action-button-previous" value="이전단계" />
                    </fieldset>
                    <fieldset>
                        <div class="form-card">
                            <div class="row">
                                <div class="col-12">
                                    <h2 class="fs-title">결제방법</h2>
                                </div>
                            </div> <br><br>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>



<script src="/resources/js/ticketing/booking.js"></script>
<%--<script type="text/javascript" src="/resources/js/viewdetail/jquery-ui.min.js"></script>--%>
</body>
</html>
