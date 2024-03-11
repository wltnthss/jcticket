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
    <link href="/resources/css/mypage/mypage.css?after" rel="stylesheet">
    <link rel="icon" href="/resources/img/mypage/KakaoTalk_20240131_192702986_02.ico">

    <style>

        <%--  공통부분 CSS      --%>
        #container {
            width: 1200px;
            height: 900px;
            margin: auto;
        }

        #con {
            width: 950px;
            height: 1200px;
            float: left;
            margin: 0px 20px;
        }

        <%--        --%>

        #center_img {
            margin: 20px 0px;
            display: flex;
            justify-content: center;
        }

        .slider {
            position: relative;
            overflow: hidden;
            width: 850px;
            height: 500px;
            border-radius: 10px
        }

        .slide {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-size: cover;
            background-position: center;

            animation: slider 7.5s infinite linear;
        }

        .slide:nth-child(1) {
            background-image: url("/resources/img/mypage/랄죠_사토루(무량공처).png");
            animation-delay: 0s;
        }
        .slide:nth-child(2) {
            background-image: url("/resources/img/mypage/랄샘_무라사키.png");
            animation-delay: -5s;
        }
        .slide:nth-child(3) {
            background-image: url("/resources/img/mypage/IMG_2641.jpg");
            animation-delay: -10s;
        }

        @keyframes slider {
            0% {
                transform: translateX(0);
            }

            26% {
                transform: translateX(0);
            }
            33% {
                transform: translateX(-100%);
                animation-timing-function: step-end;
            }
            93% {
                transform: translateX(100%);
            }

            100% {
                transform: translateX(0);
            }
        }

        td:nth-child(2n), th:nth-child(2n){
            background-color: #fafafa;
        }
        td:nth-child(2n-1), th:nth-child(2n-1){
            background-color: #eeeeee;
        }

        #ticketing {
            display: flex;
            margin: 10px;
            justify-content: center;
        }

        #ticketing > table {
            margin: 10px 0px;
            width: 850px;
            text-align: center;
            font-size: 15px;
        }

        #ticketing th {
            padding: 10px;
            border-top: 1px solid;
            border-bottom: 1px solid;
        }

        #ticketing td {
            font-size: 14px;
            font-weight: bold;
            padding: 10px;
            border-bottom: 1px solid;
        }

        #show_img {
            margin: auto;
            width: 870px;
            display: flex;
            flex-direction: row-reverse;
        }


        .showing_img {
            border: 1px solid;
            width: 280px;
            height: 350px;
            background-color: orange;
            padding: 5px 5px;
        }

        #main_cupon > #main_cupon_h1, #event_h1 {
            padding: 8px 10px 6px 13px;
            font-size: 20px;
            font-weight: bold;
            border: 5px solid;
            width: 425px;
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
                        <a href="mypageIndex"><img src="/resources/img/mypage/lnb_mypage.gif"></a>
                        
                        <div id="side_img">
                            <img src="/resources/img/mypage/1579237093699.jpg">
                        </div>

                        <div id="ticket">
                            <a href="/mypageticket"><h3>예매확인/취소</h3></a>
                            <a href="/mypagecupon"><h3>쿠폰/예매권</h3></a>
                            <a href="/mypageview"><h3>나의 관람 공연</h3></a>
                            <a href="/mypageclient"><h3>문의사항</h3></a>
                            <a href="/Modifying"><h3>회원정보 수정</h3></a>
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
                        <div class="slider">
                            <div class="slide"></div>
                            <div class="slide"></div>
                            <div class="slide"></div>
                        </div>
                    </div>

                    <h3>예매내역</h3>
                    <br>
                    <div id="ticketing">
                        <table>
                            <thead>
                            <tr>
                                <th>예매일</th>
                                <th>예매번호</th>
                                <th>공연명</th>
                                <th>관람일시</th>
                                <th>매수</th>
                                <th>예매상태</th>
                            </tr>
                            </thead>
                            <c:forEach items="${ticketList}" var="TicketingDto">
                                <tbody>
                                <tr>
                                    <td>${TicketingDto.ticketing_at}</td>
                                    <td>${TicketingDto.ticketing_id}</td>
                                    <td>${TicketingDto.play_name}</td>
                                    <td>${TicketingDto.showing_date}</td>
                                    <td>${TicketingDto.ticketing_cnt}</td>
                                    <td>${TicketingDto.ticketing_status}</td>
                                </tr>
                                </tbody>
                            </c:forEach>
                        </table>
                    </div>

                    <h3>관람공연</h3>

                    <br>

                    <ul id="show_img">
                        <il><div class="showing_img">aa</div></il>
                        <il><div class="showing_img">aa</div></il>
                        <il><div class="showing_img">aa</div></il>
                    </ul>

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
