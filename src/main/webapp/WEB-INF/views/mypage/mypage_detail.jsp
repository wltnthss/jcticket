<%@ page import="com.jcticket.mypage.dao.mypageDAO" %>
<%@ page import="com.jcticket.mypage.dao.mypageImpl" %>
<%@ page import="com.jcticket.ticketing.dto.TicketingDto" %>
<%--
  Created by IntelliJ IDEA.
  User: wjswo
  Date: 2024-02-04
  Time: PM 9:11
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>MyPage</title>
    <link href="${pageContext.request.contextPath}/resources/css/mypage/mypage.css" rel="stylesheet">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/mypage/KakaoTalk_20240131_192702986_02.ico">

    <style>
        #detail_info {
            display: inline-flex;
            margin: 20px 0px;
            border: 5px solid #dddddd;
            width: 100%;
            height: 363px;
            flex-wrap: wrap;
            border-radius: 3px;
        }

        #detail_header {
            border: 3px solid #FAFAF0;
            width: 100%;
            height: 60px;
        }

        #detail_header > p {
            margin: 20px 10px;
        }

        #derail_left {
            width: 213px;
            height: 300px;
        }

        #derail_left > img {
            width: 100%;
            height: 300px;
        }


        #derail_right {
            border: 3px solid #FAFAFA;
            width: 731px;
            height: 292px;
        }

        #derail_right > table {
            margin: 30px 0px;
        }

        #derail_right > table > tr {
            margin: 10px 0px;
        }


        #tr1 > th {
            width: 100px;
            padding: 10px 0px;
        }

        #tr2 > th {
            width: 100px;
            padding: 10px 0px;
        }


        #tr3 > th {
            width: 100px;
            padding: 10px 0px;
        }

        #tr4 > th {
            width: 100px;
            padding: 10px 0px;
        }


        #payment_detail {
            margin: 20px 0px;
            width: 100%;
            height: 150px;
        }

        #seat_info {
            margin: 20px 0px;
            width: 100%;
            height: 90px;
        }

        #table_gbox {
            width: 950px;
            border: 5px solid #dddddd;
            margin: 5px;
            background-color: #FAFAFAFA;
        }

        #table_gbox > tbody > tr > th {
            padding: 10px 5px;
        }

        #seat_info_table > thead > tr > th {
            padding: 5px;
        }

        #seat_info_table > tbody > tr > td {
            padding: 5px;
        }

        #seat_info > table {
            width: 100%;
            border: 5px solid #FAFAFA;
            padding: 20px;
            text-align: center;
        }


        #cancel_info {
            margin: 50px 0px;
            border: 5px solid #FAFAFA;
            width: 940px;
            height: 275px;
        }

        #cancel_header {
            width: 100%;
            height: 45px;
        }

        #cancel_header > p {
            margin: 10px 10px;
        }

        #cancel_mid > h3 {
            margin: 10px 5px;
        }

        #cancel_mid > ul {
            font-size: 13px;
            list-style: none;
            margin: 5px 5px;
        }

        #cancel_mid > ul > li {
            margin: 5px 5px;
        }

        #notice_info {
            padding: 5px;
            margin: 15px 0px;
            border: 5px solid #FAFAFA;
            width: 930px;
            height: 285px;
        }

        #notice_info > ul {
            margin: 10px 10px;
            font-size: 12px;
            list-style: none;
        }

        #notice_info > ul > li {
            margin: 5px 0px;
        }

        .table_sm {
            margin: 10px 0px;
            width: 100%;
        }

        #divDeliveryNone > ul {
            margin: 0px 10px;
            list-style: none;
        }

        #divDeliveryNone > ul > li {
            margin: 5px 0px;
        }


        #cancel_btn {
            display: flex;
            justify-content: center;
        }

        #cancel_btn  button {
            width: 100px;
            height: 34px;
        }

        .table_sm > tbody > tr{
            text-align: center;
        }




    </style>
</head>

<body>
<jsp:include page="../common/header.jsp"></jsp:include>

<hr>
<br>
<br>

<div id="wrap">
    <div id="container">
        <div id="contents">
            <aside id="side">
                <div id="side-mypage">
                    <a href="mypageIndex"><img src="${pageContext.request.contextPath}/resources/img/mypage/lnb_mypage.gif"></a>

                    <div id="side_img">
                        <img src="${pageContext.request.contextPath}/resources/img/mypage/1579237093699.jpg">
                    </div>

                    <div id="ticket">
                        <a href="${pageContext.request.contextPath}/mypageticket"><h3>예매확인/취소</h3></a>
                        <a href="${pageContext.request.contextPath}/mypagecupon"><h3>쿠폰/예매권</h3></a>
                        <a href="${pageContext.request.contextPath}/mypageview"><h3>나의 관람 공연</h3></a>
                        <a href="${pageContext.request.contextPath}/mypageclient"><h3>문의사항</h3></a>
                        <a href="${pageContext.request.contextPath}/Modifying"><h3>회원정보 수정</h3></a>
                        <a href="${pageContext.request.contextPath}/withdraw"><h3>회원탈퇴</h3></a>
                    </div>

                    <div id="client">
                        <h3>고객센터 전화상담</h3>

                        <h2>1588-8282</h2>
                        <ul>
                            <li>평일 09:00 ~ 18:00</li>
                            <li>토요일 09:00 ~ 17:00</li>
                            <li>일요일 공휴일 휴무</li>
                        </ul>
                    </div>
                </div>
            </aside>
            <article id="con">
                <h3>예매확인/취소</h3>
                <div id="detail_info">
                    <div id="detail_header">
                        <p class="tit">
                            ${ticketingDto.play_name}
                        </p>
                    </div>

                    <div id="derail_left">
                        <img src="<c:url value='/index/upload/${ticketingDto.play_poster_stored_file_name}'/>">

                    </div>
                    <div id="derail_right">
                        <table>
                            <tbody>
                            <tr id="tr1">
                                <th>예매번호</th>
                                <td><strong>${ticketingDto.ticketing_id}</strong></td>
                                <th>예매자</th>
                                <td>${ticketingDto.user_name}</td>
                            </tr>
                            <tr id="tr2">
                                <th>관람일</th>
                                <td colspan="3" class="ri"><strong>${ticketingDto.showing_date}</strong></td>
                            </tr>
                            <tr id="tr3">
                                <th>공연장</th>
                                <td colspan="3">${ticketingDto.stage_name}</td>
                            </tr>
                            <tr id="tr4">
                                <th>좌석<p></p></th>
                                <td colspan="3">
                                    <div class="scroll">
                                        ${ticketingDto.selected_seats}
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th class="le">티켓수령방법<p></p></th>
                                <td colspan="3">


                                    <div id="divDeliveryNone">

                                        <ul>
                                            <li>- 공연 당일 티켓교부처에서 티켓을 받으시면 됩니다.(현장수령)</li>
                                            <li>- 예매내역서(프린트)와 신분증을 지참해주세요.</li>
                                        </ul>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>

                <h3>결제내역</h3>
                <div id="total_payment">
                    <div id="payment_detail">
                        <table id="table_gbox">
                            <colgroup>
                                <col width="13%">
                                <col width="*">
                                <col width="13%">
                                <col width="27%">
                            </colgroup>
                            <tbody>
                            <tr>
                                <th>예매일시</th>
                                <td>${ticketingDto.ticketing_at}</td>
                                <th>예매상태</th>
                                <td>${ticketingDto.ticketing_status}</td>
                            </tr>
                            <tr>
                                <th>총결제금액</th>
                                <td colspan="3" class="ri"><span class="red tit"><strong>2,500 - 100</strong>원</span><br><span
                                        class="sm">(티켓금액 <strong>2,500</strong>원 + 예매수수료 <strong>0</strong>원 + 배송비 <strong>0</strong>원)</span>
                                </td>
                            </tr>
                            <tr>
                                <th>결제수단</th>
                                <td colspan="3" class="ri">
                                    <div>
                                        <div class="sub_list">YES머니 <strong>2,500</strong>원</div>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div id="seat_info">
                        <table id="seat_info_table" class="tmypage"
                               summary="해당 공연의 좌석등급, 좌석번호, 가격, 공연일시, 예매상태를 나타내고 취소여부를 선택할 수 있는 표입니다.">
                            <colgroup>
                                <col width="12%">
                                <col width="25%">
                                <col width="*">
                                <col width="15%">
                                <col width="15%">
                                <col width="15%" style="display:none;">
                            </colgroup>
                            <thead>
                            <tr>
                                <th scope="row" class="fst">좌석등급</th>
                                <th scope="row">좌석번호</th>
                                <th scope="row">할인</th>
                                <th scope="row">가격</th>
                                <th scope="row" class="end">상태</th>
                                <th scope="row" class="end" style="display:none;">전체취소<input id="cbxAllCancelSeat"
                                                                                             type="checkbox"
                                                                                             title="전체취소"
                                                                                             onclick="jsf_otv_CheckAllCancelSeat();"
                                                                                             style="display:none;"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td class="le">성인</td>
                                <td>비지정석</td>
                                <td>50% 할인</td>
                                <td>2,500 원</td>
                                <td class="ri">예매</td>
                                <td style="display:none;"><input id="cbxCancelSeat1" type="checkbox" title="취소"
                                                                 style="display:none;">
                            </tbody>
                        </table>
                    </div>
                    <div id="cancel_info">
                        <div id="cancel_header">
                            <p>※ 취소 마감시간 : 2024.01.16 (화) 23:00 까지</p>
                        </div>
                        <div id="cancel_mid">
                            <h3>취소 수수료안내</h3>
                            <ul>
                                <li>- 취소 일자에 따라서 취소수수료가 달라집니다 <span>* 단, 예매 당일 밤 12시 이전 취소시에는 취소수수료 없음(취소기한내에한함)</span>
                                </li>
                                <li>- 취소 시 예매수수료는 예매 당일 밤 12시 이전까지 환불되며, 그 이후 기간에는 환불되지 않습니다.</li>
                                <li class="f_n">- 취소수수료 관련 기타 자세한 내용은 예매 <a
                                        href="http://ticket.yes24.com/Pages/UserGuide/Cancel.aspx"><em>이용안내 &gt;수수료</em></a>
                                    안내를 확인해주세요.
                                </li>
                            </ul>

                            <table class="table_sm">
                                <colgroup>
                                    <col width="30%">
                                    <col width="30%">
                                    <col width="*">
                                </colgroup>
                                <tbody>
                                <tr>
                                    <th>내용</th>
                                    <th>취소일</th>
                                    <th>취소수수료</th>
                                </tr>
                                <tr>
                                    <td>미부과 기간</td>
                                    <td>2024.01.16 ~ 2024.01.16</td>
                                    <td>없음</td>
                                </tr>
                                </tbody>
                            </table>
                            <c:if test="${ticketingDto.ticketing_status eq '예매완료'}">
                            <ul class="gbox_notice">
                                <li id="liGuide_CancelOnly">
                                    ※ 취소를 원하시면 <em>취소하고자 하는 티켓을 선택한 후 </em><strong class="red">[예매취소] </strong>버튼을
                                    클릭해주세요.<br>&nbsp;
                                </li>
                            </ul>
                            </c:if>
                        </div>
                    </div>






                    <c:if test="${ticketingDto.ticketing_status eq '예매완료'}">
                        <div id="cancel_btn">
                        <form action="${pageContext.request.contextPath}/mypageticket">
                            <button value="${ticketingDto.ticketing_id}" name="cancel" type="submit">예매취소</button>
                        </form>
                        </div>
                    </c:if>




                    <div id="notice_info">
                        <ul>
                            <li class="red">- 취소 시 예매수수료는 예매 당일 밤 12시 이전까지 환불되며, 그 이후 기간에는 환불되지 않습니다.</li>
                            <li>- 티켓 수령 방법 변경(현장수령 -&gt; 배송)은 예매 완료된 건에 한하며, 배송비 결제는 신용카드만 결제 가능합니다.(단 공연일 기준 12일 전까지 /
                                일부 공연 불가)
                            </li>
                            <li>- 다음과 같은 경우 PC/모바일에서는 취소 또는 부분취소가 불가하오니 고객센터로 문의해주시기 바랍니다.<br>
                                &nbsp;&nbsp; 1) YES머니, YES상품권, 쿠폰 등 예스24 결제수단을 사용하여 예매한 경우<br>
                                &nbsp;&nbsp; 2) 무통장입금 예매 후 신용카드로 배송비를 추가 결제한 경우<br>
                                &nbsp;&nbsp; 3) 티켓 배송이 완료되었거나 시작된 경우<br>
                                &nbsp;&nbsp;&nbsp;&nbsp;(취소마감시간 이전에 고객센터로 반송되어야 취소 가능, 취소 수수료는 티켓 도착일 기준으로 부과되며 배송비는 환불
                                불가)
                            </li>
                            <li>- 예매 티켓 배송은 예매완료 후 4~5일 이내(영업일 기준) 배송해드립니다. 티켓 분실 시 재발권이 불가하오니, 보관에 주의해주시기 바랍니다.<br>
                                &nbsp;&nbsp;&nbsp;(일괄배송 공연일 경우 일괄배송일 기준 4~5일(영업일 기준) 이내에 수령 가능)
                            </li>
                            <li>- 예매 취소 시 결제 금액에서 수수료를 제외한 금액만큼 환불 처리 됩니다.(부분 취소 시에는 잔여 티켓 금액 + 수수료 등을 제외하고 환불 처리
                                됩니다.)
                            </li>
                            <li>- 복합결제로 예매한 경우 전체 취소 시 각 결제 수단(YES머니, YES상품권 등)으로 자동환급됩니다. 단 YES상품권, 예매권 등 사용기한이
                                <br>
                                &nbsp;&nbsp;&nbsp;만료된 경우 재사용하실 수 없습니다.
                            </li>
                            <li>- 예매 취소 시점과 해당 카드사의 환불 처리 기준에 따라 환급방법과 환급일은 다소 차이가 있을 수 있습니다.</li>

                        </ul>
                    </div>
                </div>
            </article>
        </div>
    </div>
</div>

<br>
<br>
<hr>

<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
