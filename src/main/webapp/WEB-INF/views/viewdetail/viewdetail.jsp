<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
=======
git <%--
>>>>>>> f53ca12cc5c5bb6db892356ba083f284d2750c98
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
<%--    페이지 아이콘--%>
    <link rel="icon" href="/resources/img/viewdetail/god.ico">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>제이씨티켓 상세</title>
<%--    jQuery--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<%--    datepicker css--%>
    <link rel="stylesheet" href="/resources/css/viewdetail/jquery-ui.css">

<%--    viewdetail 페이지 css--%>
    <link rel="stylesheet" href="/resources/css/viewdetail/viewdetail.css">

</head>
<body>
    <jsp:include page="../common/header.jsp"></jsp:include>

    <div class="container">
        <%-- content area    --%>
        <div class="category">
            <a class="major-cat">
                <c:forEach var="play" items="${viewDetail}">
                    <a>${play.play_major_cat}</a>
                </c:forEach>
            </a>
            >
            <a class="middle-cat">
                <c:forEach var="play" items="${viewDetail}">
                    <a>${play.play_middle_cat}</a>
                </c:forEach>
            </a>
        </div>

    <%--    나중에 two 아래 css로 밑줄 만들것--%>
        <div class="two">
        <%--제목--%>
            <p class="big-title">
                <c:forEach var="play" items="${viewDetail}">
                    <a id="for_ticketing_play_name">${play.play_name}</a>
                </c:forEach>
            </p>
                <div class="two-one">
        <%--            <p>--%>
                        <span class="play-period">
<%--                            대괄호 제거하고 상영날짜 출력--%>
                            <c:forEach var="date" items="${viewDetailTime}" varStatus="loop">
                                <a class="dateShow"><c:out value="${date.showing_date}" /></a>
                                <c:if test="${!loop.last}">,</c:if>
                            </c:forEach>
                        </span>

                        <a href="javascript:void(0);" id="stage_name">
<%--                            <span>쉼표 도서관 2층</span>--%>
                            <c:forEach var="stage" items="${viewDetail}">
                                <span id="for_ticketing_stage_name">${stage.stage_name}</span>
                            </c:forEach>
                            <img src="/resources/img/viewdetail/location.png" class="location_img">
                        </a>

                        <a href="javascript:void(0);" id="url_image">
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
                            <c:forEach var="play" items="${viewDetail}">
                                <dd>&nbsp;${play.play_run_time}분</dd>
                            </c:forEach>
                            <dt>출연</dt>
                            <dd>&nbsp;개</dd>
                            <dt id="dtPrice">가격</dt>
                            <dd id="ddPrice">
    <%--                            price-zone 마진 없애면 동일선상으로 나옴--%>
                                <ul class="price-zone">
                                    <div class="seat-price">
                                        <li>
                                            VIP석
                                            <c:forEach var="price" items="${viewDetail}">
                                                <span class="text_red">${price.seat_price}</span>원
                                            </c:forEach>
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
                            <c:forEach var="info" items="${viewDetailTime}">
                                <dd>${info.showing_date} ${info.showing_info}</dd>
                            </c:forEach>
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

                        </div>
                    </div>
                </div>
                <div class="fourRight" id="rightH">
                    <p class="four-text">
                        예매 가능 좌석
                    </p>
                    <div class="seat_info">
                        <dl class="seatRemain">
                            <li id="seatPrice1">
                                VIP석
                                <c:forEach var="price" items="${viewDetail}">
                                    <span class="text_red">${price.seat_price}</span>원
                                </c:forEach>
                            </li>
                        </dl>
                    </div>
                </div>
            </div>
        </div>

<%--        <div class="five" onclick="location.href='javascript:void(0);'">--%>
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
                <div class="eight_map" id="mapa">
<%--                    <p class="map_name">쉼표도서관</p>--%>
                    <c:forEach var="stage" items="${viewDetail}">
                        <p class="map_name">&nbsp;${stage.stage_name}</p>
                    </c:forEach>
                    <p class="map_location">경기도 시흥시 은행로 173번길 14</p>
                </div>
                <div class="map_icon_box">
                    <img src="/resources/img/viewdetail/path_icon.png"/><br>찾아가는길
                </div>

<%--                카카오 지도 api--%>
                <div id="map" style="width: 1200px; height: 700px;"></div>
            </div>

            <div class="nine">
                <div class="comment">
                    <div class="comment_name">
                        <span>관람후기</span>
                    </div>
                    <div class="comment_warning">
                        <img src="/resources/img/viewdetail/comment_icon.png/">
                        <div class="span_box">
                            <span class="text_red">매매, 욕설 등 제이씨티켓 게시판 운영 규정에 위반되는 글은 사전 통보없이 삭제될 수 있습니다.</span><br>
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
                            <%--        ph는 BoardController에 정의되어있음, ph = PageHandler--%>
                            <c:if test="${ph.showPrev}">
                                <a href="<c:url value='/viewdetail?page=${ph.startPage-1}&pageSize=${ph.pageSize}'/>">&lt;</a>
                            </c:if>
                            <c:forEach var="i" begin="${ph.startPage}" end="${ph.endPage}">
                                <a href="<c:url value='/viewdetail?page=${i}&pageSize=${ph.pageSize}'/>">${i}</a>
                            </c:forEach>
                            <c:if test="${ph.showNext}">
                                <a href="<c:url value='/viewdetail?page=${ph.endPage+1}&pageSize=${ph.pageSize}'/>">&gt;</a>
                            </c:if>
                        </div>
<%--                        <div>--%>
<%--                            <a><span>1</span></a>--%>
<%--                            <a><span>2</span></a>--%>
<%--                            <a><span>3</span></a>--%>
<%--                            <a><span>4</span></a>--%>
<%--                            <a><span>5</span></a>--%>
<%--                            <a><span>6</span></a>--%>
<%--                            <a><span>7</span></a>--%>
<%--                            <a><span>8</span></a>--%>
<%--                            <a><span>9</span></a>--%>
<%--                            <a><span>10</span></a>--%>
<%--                        </div>--%>
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


<%--    카카오 지도 api 스크립트--%>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=69ecfd6866e9fbc699032449e3c3d5ae"></script>

    <%--    js파일--%>
    <script src="/resources/js/viewdetail/viewdetail.js"></script>

</body>
</html>