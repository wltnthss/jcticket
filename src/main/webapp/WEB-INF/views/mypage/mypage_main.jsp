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
    <link href="/resources/css/mypage/mypage.css" rel="stylesheet">
    <link rel="icon" href="/resources/img/mypage/KakaoTalk_20240131_192702986_02.ico">
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
                        <a href="mypageIndex"><img src="/resources/img/mypage/lnb_mypage.gif"></a>
                        
                        <div id="side_img">
                            <img src="/resources/img/mypage/1579237093699.jpg">
                        </div>

                        <div id="ticket">
                            <a href="/mypageticket"><h3>예매확인/취소</h3></a>
                            <a href="/mypagecupon"><h3>쿠폰/예매권</h3></a>
                            <a href="/mypageview"><h3>나의 관람 공연</h3></a>
                            <a href="/mypageclient"><h3>문의사항</h3></a>
                            <a href="/signup"><h3>회원정보 수정</h3></a>
                            <a href="/withdraw"><h3>회원탈퇴</h3></a>
                        </div>

                        <div id="client">
                            <h3>고객센터 전화상담</h3>

                            <h2>1588-8282</h2>
                            <ul>
                                <li>평일      09:00 ~ 18:00</li>
                                <li>토요일   09:00 ~ 17:00</li>
                                <li>일요일 공휴일 휴무</li>
                            </ul>
                        </div>
                    </div>
                </aside>
                <article id="con">
                    <div id="main_cupon">
                        <div id="main_cupon_h1">쿠폰입니다</div>
                        <ul>
                            <li>내가 가진 쿠폰 개수</li>
                            <li>내가 가진 쿠폰 개수</li>
                        </ul>
                    </div>
                    <div id="event">
                        <div id="event_h1">이벤트입니다</div>
                        <ul>
                            <li>내가 가진 쿠폰 개수</li>
                            <li>내가 가진 쿠폰 개수</li>
                        </ul>
                    </div>
                    
                    
                    <div id="center_img">
                        <img src="/resources/img/mypage/페페%20한잔해.jpg">

                        <img src="/resources/img/mypage/1579237090970.jpeg">
                    </div>

                    <h3>예매내역</h3>
                    <div id="ticketing">
                        <table>
                            <tr>
                                <th>예매일</th>
                                <th>예매번호</th>
                                <th>공연명</th>
                                <th>관람일시</th>
                                <th>매수</th>
                                <th>예매상태</th>
                            </tr>
                            <c:forEach items="${ticketList}" var="TicketingDto">
                                <tr>
                                    <td>${TicketingDto.ticketing_at}</td>
                                    <td>${TicketingDto.ticketing_id}</td>
                                    <td>${TicketingDto.play_name}</td>
                                    <td>${TicketingDto.viewing_at}</td>
                                    <td>${TicketingDto.ticketing_cnt}</td>
                                    <td>${TicketingDto.ticketing_status}</td>
                                </tr>
                            </c:forEach>
                        </table>

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
