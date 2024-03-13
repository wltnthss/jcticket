<%@ page import="java.util.List" %>
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
<%--    <link rel="icon" href="/resources/img/viewdetail/god.ico">--%>

<%--    별점 아이콘--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>제이씨티켓 상세</title>
<%--    jQuery--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<%--    datepicker css--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/viewdetail/jquery-ui.css">

<%--    viewdetail 페이지 css--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/viewdetail/viewdetail.css">

</head>
<body>
    <jsp:include page="../common/header.jsp"></jsp:include>

    <div class="container">
        <%-- content area    --%>
        <div class="category">
            <a href="${pageContext.request.contextPath}/${major_cat}" style="color:black;">
                <span class="major-cat">
                    <c:if test="${not empty viewDetail}">
                        ${viewDetail[0].play_major_cat}
                    </c:if>
                </span>
                <c:if test="${not empty viewDetail[0].play_middle_cat}">></c:if>
                <span class="middle-cat">
                    <c:if test="${not empty viewDetail}">
                        ${viewDetail[0].play_middle_cat}
                    </c:if>
                </span>
            </a>
        </div>

    <%--    나중에 two 아래 css로 밑줄 만들것--%>
        <div class="two">
        <%--제목--%>
            <p class="big-title">
                <c:if test="${not empty viewDetail}">
                    <a id="for_ticketing_play_name">${viewDetail[0].play_name}</a>
                </c:if>
            </p>
                <div class="two-one">
        <%--            <p>--%>
                        <span class="play-period">
<%--                            상영기간 출력--%>
                            <c:if test="${not empty viewDetailTime}">
                                ${viewDetailTime.get(0).showing_start_at}
                                <c:if test="${viewDetailTime.get(0).showing_start_at != viewDetailTime.get(0).showing_end_at}">~</c:if>
                                <c:if test="${viewDetailTime.get(0).showing_start_at != viewDetailTime.get(0).showing_end_at}">${viewDetailTime.get(0).showing_end_at}</c:if>
                            </c:if>
                        </span>

                        <a href="javascript:void(0);" id="stage_name">
                            <c:if test="${not empty viewDetail}">
                                <span id="for_ticketing_stage_name">${viewDetail[0].stage_name}</span>
                            </c:if>
                            <img src="${pageContext.request.contextPath}/resources/img/viewdetail/location.png" class="location_img">
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
                    <c:if test="${not empty viewDetail}">
                        <div class="play-img">
                            <img src="<c:url value='/index/upload/${viewDetail[0].play_poster_stored_file_name}'/>" alt="">
                        </div>
                    </c:if>
    <%--                review-mini안에 별점, 평균별점, 리뷰 수 등등 들어감--%>
                    <div class="star-review">
                        <div class="review-star">
                            <div class="review-star-info">
                                <i class="rating__star far fa-star"></i><i class="rating__star far fa-star"></i><i class="rating__star far fa-star"></i><i class="rating__star far fa-star"></i><i class="rating__star far fa-star"></i>
                            </div>
                            <div class="real_star" style="width:calc((${review[0].review_avg}/5) * 90px);">
                                <i class="rating__star fas fa-star"></i><i class="rating__star fas fa-star"></i><i class="rating__star fas fa-star"></i><i class="rating__star fas fa-star"></i><i class="rating__star fas fa-star"></i>
                            </div>
                        </div>
                        <span id="review_mini" class="review" style="cursor: pointer">
                            <em>${review[0].review_avg}</em>
                             *${review[0].review_count}
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
                            <c:if test="${not empty viewDetail}">
                                <dd>&nbsp;${viewDetail[0].play_run_time}분</dd>
                            </c:if>
                            <dt id="dtPrice">가격</dt>
                            <dd id="ddPrice">
    <%--                            price-zone 마진 없애면 동일선상으로 나옴--%>
                                <ul class="price-zone">
                                    <div class="seat-price">
                                        <li>
                                            VIP석
                                            <c:if test="${not empty viewDetail}">
                                                <span class="text_red">${viewDetail[0].seat_price}</span>원
                                            </c:if>
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
                            <c:if test="${not empty viewDetailTime}">
                                ${viewDetailTime.get(0).play_time_info}
                            </c:if>
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
                                <c:if test="${not empty viewDetail}">
                                    <span class="text_red">${viewDetail[0].seat_price}</span>원
                                </c:if>
                            </li>
                        </dl>
                    </div>
                </div>
            </div>
        </div>

<%--        <div class="five" onclick="location.href='javascript:void(0);'">--%>
        <div class="five" id="${play_id}">
            <a class="taketic">예매하기</a>
        </div>


<%--            a태그마다 링크 걸어야함--%>
        <div class="six">
            <a href="javascript:void(0);" id="scroll_detail_info" style="color: black; background-color: rgba(81, 110, 253, 0.03)">
                <span>상세정보</span>
            </a>
            <a href="javascript:void(0);" id="scroll_review" style="color: black; background-color: rgba(81, 110, 253, 0.03)">
<%--                댓글수 가져와야됨--%>
                <span>
                    관람후기
                    <span class="comment_cnt">(${review[0].review_count})</span>
                </span>
            </a>
            <a href="javascript:void(0);" id="reservation_notice" style="color: black; background-color: rgba(81, 110, 253, 0.03)">
                <span>예매/취소 안내</span>
            </a>
        </div>


        <div id="info" class="info_box">
            <div class="seven_one">
<%--                <p class="seven_text">유의사항</p>--%>
            </div>

            <div class="seven_two">
                <p class="seven_text">공연정보</p>
                <div class="seven_con">
                    <c:if test="${not empty viewDetail}">
                        <img src="<c:url value='/index/upload/${viewDetail[0].play_info_stored_file_name}'/>" alt="">
                    </c:if>
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
                                    <td>제이씨티켓(주)_<br>
                                        <c:if test="${not empty viewDetail}">
                                        ${viewDetail[0].play_name}
                                    </c:if></td>

                                    <th scope="row" class="seven_table">소비자상담</th>
                                    <td>제이씨티켓(주) 7777-7777</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="seven_table">공연시간</th>
                                    <c:if test="${not empty viewDetail}">
                                        <td>&nbsp;${viewDetail[0].play_run_time}분</td>
                                    </c:if>
                                    <th scope="row" class="seven_table">공연장소</th>
                                    <c:if test="${not empty viewDetail}">
                                        <td>${viewDetail[0].stage_name}</td>
                                    </c:if>
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

                </div>
            </div>

            <div class="eight">
                <div class="eight_map" id="mapa">
                    <c:if test="${not empty viewDetail}">
                        <p class="map_name">${viewDetail[0].stage_name}</p>
                    </c:if>
                    <c:if test="${not empty viewDetail}">
                        <p class="map_location">${viewDetail[0].stage_address}</p>
                    </c:if>
                </div>
                <div class="map_icon_box">
                    <img src="${pageContext.request.contextPath}/resources/img/viewdetail/path_icon.png"/><br>찾아가는길
                </div>

<%--                카카오 지도 api--%>
                <div id="map" style="width: 1200px; height: 700px;"></div>
            </div>

            <div class="nine">
                <div class="comment">
                    <div class="comment_name">
                        <span id="review">관람후기</span>
                    </div>
                    <div class="comment_warning">
                        <img src="${pageContext.request.contextPath}/resources/img/viewdetail/comment_icon.png/">
                        <div class="span_box">
                            <span class="text_red">매매, 욕설 등 제이씨티켓 게시판 운영 규정에 위반되는 글은 사전 통보없이 삭제될 수 있습니다.</span><br>
                            <span>개인정보가 포함된 내용은 삼가 주시기 바라며, 게시물로 인해 발생하는 문제는 작성자 본인에게 책임이 있습니다.</span>
                        </div>
<%--                        <img id="review_create" style="cursor: pointer" src="/resources/img/viewdetail/review_create.png/"/>--%>
                    </div>
                </div>
                <div class="comment_board_container">
                    <ul class="comment_board">
<%--                       게시판 내용은 스크립트에서 추가--%>
                    </ul>

                    <div class="comment_page">
<%--                        <a class="page_first"><img src="/resources/img/viewdetail/backback.png/"/></a>--%>
<%--                        <a class="page_prev"><img src="/resources/img/viewdetail/back.png/"/></a>--%>
                        <a class="prev pageCss" href="${pageContext.request.contextPath}/viewdetail?this_play_id=${play_id}&page=${ph.startPage-1}&pageSize=${ph.pageSize}">&lt;</a>
                        <div class="pagination">
                            <!-- 페이지 번호 및 Ajax 호출을 위한 부분 -->
                            <c:forEach var="i" begin="${ph.startPage}" end="${ph.endPage}">
                                <a class="num pageCss" href="${pageContext.request.contextPath}/viewdetail?this_play_id=${play_id}&page=${i}&pageSize=${ph.pageSize}">${i}</a>
                            </c:forEach>
                        </div>
                        <a class="next pageCss" href="javascript:void(0);">&gt;</a>
<%--                        <a class="page_next"><img src="/resources/img/viewdetail/backback.png/"/></a>--%>
<%--                        <a class="page_last"><img src="/resources/img/viewdetail/back.png/"/></a>--%>
                    </div>

                    <p id="review_place" style="font-size: 22px; margin-left: 30px">관람후기등록</p>
                        <form id="insert_form" action="${pageContext.request.contextPath}/review_insert" method="post">
                            <div class="review_form">
                                <input type="hidden" name="play_id" value="${play_id}"/>
                                <input type="hidden" id="form_user_id" name="user_id" value="${user_id}"/>
                                별점 : <span class="review_star">
                                    <i id="1" class="rating__star far fa-star"></i><i id="2" class="rating__star far fa-star"></i><i id="3" class="rating__star far fa-star"></i><i id="4" class="rating__star far fa-star"></i><i id="5" class="rating__star far fa-star"></i>
                                </span>
                                <input type="hidden" id="star_input" name="star" value=""/>
                                <span>
                                    관람일자 :
                                    <select name="viewing_at">
                                        <c:forEach var="item" items="${viewing_at}">
                                            <option>${item}</option>
                                        </c:forEach>
                                    </select>
                                </span>
                            </div>

                            <div>
                                <textarea class="review_box" name="review_content" placeholder="관람후기를 작성해주세요."></textarea>
                            </div>
                            <input type="submit" value="" class="review_submit" style="background-image: url('${pageContext.request.contextPath}/resources/img/viewdetail/review_create.png');"/>
                        </form>
                </div>
            </div>

<%--            endPage,pageSize,totalPage 저장--%>
            <c:if test="${not empty ph}">
                <input type="hidden" class="endPage" value="${ph.endPage}"/>
            </c:if>
            <c:if test="${not empty ph}">
                <input type="hidden" class="pageSize" value="${ph.pageSize}"/>
            </c:if>
            <c:if test="${not empty ph}">
                <input type="hidden" class="totalPage" value="${ph.totalPage}"/>
            </c:if>


<%--            <h1>${ph.totalPage}</h1>--%>
<%--            <h1>${ph.endPage}</h1>--%>
<%--            <h1>${ph.startPage}</h1>--%>
        </div>
    </div>
    <jsp:include page="../common/footer.jsp"></jsp:include>

    <script>
        sessionStorage.setItem("contextpath", "${pageContext.request.contextPath}");
    </script>
    <%--    datepicker 제이쿼리 달력--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/viewdetail/jquery-ui.min.js"></script>


<%--    카카오 지도 api 스크립트--%>
    <script type="text/javascript" src="/${pageContext.request.contextPath}/dapi.kakao.com/v2/maps/sdk.js?appkey=69ecfd6866e9fbc699032449e3c3d5ae&libraries=services"></script>

    <%--    js파일--%>
    <script src="${pageContext.request.contextPath}/resources/js/viewdetail/viewdetail.js"></script>

</body>
</html>