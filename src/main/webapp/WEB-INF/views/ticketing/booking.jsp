<%--
  Created by IntelliJ IDEA.
  User: joyoungsang
  Date: 2/10/24
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                        </div> <input type="button" name="next" class="next action-button" value="다음단계" />
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
                                    <div class="select-seat">
                                        <div id="stage" class="shadow-sm p-1 mb-2 bg-dark rounded">STAGE</div>
                                        <div class="seats">
                                            <span>A</span>
                                            <span id="a1" class="border border-primary"></span>
                                            <span id="a2" class="border border-primary"></span>
                                            <span id="a3" class="border border-primary"></span>
                                            <span id="a4" class="border border-primary"></span>
                                            <span id="a5" class="border border-primary"></span>
                                            <span id="a6" class="border border-primary"></span>
                                            <span id="a7" class="border border-primary"></span>
                                            <span id="a8" class="border border-primary"></span>
                                            <span id="a9" class="border border-primary"></span>
                                            <span id="a10" class="border border-primary"></span>
                                        </div>
                                        <div class="seats">
                                            <span>B</span>
                                            <span id="b1" class="border border-primary"></span>
                                            <span id="b2" class="border border-primary"></span>
                                            <span id="b3" class="border border-primary"></span>
                                            <span id="b4" class="border border-primary"></span>
                                            <span id="b5" class="border border-primary"></span>
                                            <span id="b6" class="border border-primary"></span>
                                            <span id="b7" class="border border-primary"></span>
                                            <span id="b8" class="border border-primary"></span>
                                            <span id="b9" class="border border-primary"></span>
                                            <span id="b10" class="border border-primary"></span>
                                        </div>
                                        <div class="seats">
                                            <span>C</span>
                                            <span id="c1" class="border border-primary"></span>
                                            <span id="c2" class="border border-primary"></span>
                                            <span id="c3" class="border border-primary"></span>
                                            <span id="c4" class="border border-primary"></span>
                                            <span id="c5" class="border border-primary"></span>
                                            <span id="c6" class="border border-primary"></span>
                                            <span id="c7" class="border border-primary"></span>
                                            <span id="c8" class="border border-primary"></span>
                                            <span id="c9" class="border border-primary"></span>
                                            <span id="c10" class="border border-primary"></span>
                                        </div>
                                        <div class="seats">
                                            <span>D</span>
                                            <span id="d1" class="border border-primary"></span>
                                            <span id="d2" class="border border-primary"></span>
                                            <span id="d3" class="border border-primary"></span>
                                            <span id="d4" class="border border-primary"></span>
                                            <span id="d5" class="border border-primary"></span>
                                            <span id="d6" class="border border-primary"></span>
                                            <span id="d7" class="border border-primary"></span>
                                            <span id="d8" class="border border-primary"></span>
                                            <span id="d9" class="border border-primary"></span>
                                            <span id="d10" class="border border-primary"></span>
                                        </div>
                                        <div class="seats">
                                            <span>E</span>
                                            <span id="e1" class="border border-primary"></span>
                                            <span id="e2" class="border border-primary"></span>
                                            <span id="e3" class="border border-primary"></span>
                                            <span id="e4" class="border border-primary"></span>
                                            <span id="e5" class="border border-primary"></span>
                                            <span id="e6" class="border border-primary"></span>
                                            <span id="e7" class="border border-primary"></span>
                                            <span id="e8" class="border border-primary"></span>
                                            <span id="e9" class="border border-primary"></span>
                                            <span id="e10" class="border border-primary"></span>
                                        </div>
                                        <div class="seats">
                                            <span>F</span>
                                            <span id="f1" class="border border-primary"></span>
                                            <span id="f2" class="border border-primary"></span>
                                            <span id="f3" class="border border-primary"></span>
                                            <span id="f4" class="border border-primary"></span>
                                            <span id="f5" class="border border-primary"></span>
                                            <span id="f6" class="border border-primary"></span>
                                            <span id="f7" class="border border-primary"></span>
                                            <span id="f8" class="border border-primary"></span>
                                            <span id="f9" class="border border-primary"></span>
                                            <span id="f10" class="border border-primary"></span>
                                        </div>
                                        <div class="seats">
                                            <span>G</span>
                                            <span id="g1" class="border border-primary"></span>
                                            <span id="g2" class="border border-primary"></span>
                                            <span id="g3" class="border border-primary"></span>
                                            <span id="g4" class="border border-primary"></span>
                                            <span id="g5" class="border border-primary"></span>
                                            <span id="g6" class="border border-primary"></span>
                                            <span id="g7" class="border border-primary"></span>
                                            <span id="g8" class="border border-primary"></span>
                                            <span id="g9" class="border border-primary"></span>
                                            <span id="g10" class="border border-primary"></span>
                                        </div>
                                        <div class="seats">
                                            <span>H</span>
                                            <span id="h1" class="border border-primary"></span>
                                            <span id="h2" class="border border-primary"></span>
                                            <span id="h3" class="border border-primary"></span>
                                            <span id="h4" class="border border-primary"></span>
                                            <span id="h5" class="border border-primary"></span>
                                            <span id="h6" class="border border-primary"></span>
                                            <span id="h7" class="border border-primary"></span>
                                            <span id="h8" class="border border-primary"></span>
                                            <span id="h9" class="border border-primary"></span>
                                            <span id="h10" class="border border-primary"></span>
                                        </div>

                                    </div>
                                </div>
                                <div class="col-4">
                                    <div class="selected-seats head">
                                        <p>선택좌석내역</p>
                                    </div>
                                    <div id="ss" class="selected-seats">
<%--                                        선택된 좌석 아이디 들어갈 자리--%>
<%--                                        <span>a7</span>--%>

                                    </div>
                                    <div class="selected-price head">
                                        <p>선택좌석가격</p>
                                    </div>
                                    <div class="selected-price"></div>
                                </div>

                            </div>
                        </div> <input type="button" name="next" class="next action-button" value="다음단계" /> <input type="button" name="previous" class="previous action-button-previous" value="이전단계" />
                    </fieldset>
                    <fieldset>
                        <div class="form-card">
                            <div class="row">
                                <div class="col-12">
                                    <h2 class="fs-title">쿠폰/할인</h2>
                                </div>
                            </div>
                        </div> <input type="button" name="next" class="next action-button" value="다음단계" /> <input type="button" name="previous" class="previous action-button-previous" value="이전단계" />
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
