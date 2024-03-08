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
    <title>Title</title>

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

        #client > ul {
            list-style: none;
        }

        #select-date {
            width: 850px;
            height: 150px;
            margin: 20px auto;
            border-style: outset;
            border: 1px solid #BDBDBD;
            background-color: #eeeeee;
            border-radius: 10px;
            text-align: center;
        }

        .month {
            width: 50px;
            height: 30px;
        }

        #select-date > p {
            font-size: 20px;
            font-weight: bold;
            margin: 5px 5px;
            display: inline-block;
        }

        #select-date > ul {
            margin: 0px 300px;
            display: flex;
            flex-direction: row;
            justify-content: space-evenly;
            list-style: none;
        }

        #select-date > ul > li {
            margin: 3px;
            float: left;
        }

        #select-date > input {
            width: 180px;
        }

        #note {
            padding-left: 5px;
            text-align: left;
            font-size: 15px;
            margin: 20px 0;
        }

        #note > hr {
            height: 2px;
            background: black;
        }

        #note > ul {
            list-style: none;
        }

        #note > ul > li {
            margin: 5px;
        }



        #search {
            display: inline-block;
            padding-left: 550px;
        }

        #search > select {
            width: 100px;
            height: 25px;
        }

        #search > input {
            font-size: 16px;
            bottom: 40px;
            color: #666;
            font-weight: bold;
        }

        #submit {
            background-color: #fafafa;
            border-radius: 5px;
            width: 100px;
            height: 25px;
            font-weight: bold;
        }

        #start_date, #end_date {
            width: 202px;
            height: 25px;
        }
        #option {
            width: 150px;
            height: 25px;
        }

        #ticketing {
            text-align: center;
            margin: 20px 0px;
        }

        #ticketing > table {
            width: 820px;
            margin: 0px 51px;
            text-align: center;
            font-size: 15px;
        }

        td:nth-child(2n), th:nth-child(2n){
            background-color: #fafafa;
        }
        td:nth-child(2n-1), th:nth-child(2n-1){
            background-color: #eeeeee;
        }

        #paging {
            font-size: 20px;
            font-weight: bold;
        }

        #paging > a {
            text-decoration-line: none;
            color: black;
        }


    </style>


</head>
<body>
    <jsp:include page="../common/header.jsp"></jsp:include>

    <hr>
    <br>
    <br>

    <script>
        window.onload = function () {
            const one = document.getElementById("1month");
            const three = document.getElementById("3month");
            const six = document.getElementById("6month");
            one.onclick = function () {
                var today = new Date();
                var start = new Date(today);
                start.setMonth(today.getMonth() - 1);
                var end = new Date();

                // document.getElementById("start_date").value = start.toISOString().substring(0, 10);
                document.getElementById("end_date").value = end.toISOString().substring(0, 10);
                document.getElementById("start_date").value = start.toISOString().substring(0, 10);
            }


            three.onclick = function () {
                var today = new Date();
                var start = new Date(today);
                start.setMonth(today.getMonth() - 3);
                var end = new Date();

                // document.getElementById("start_date").value = start.toISOString().substring(0, 10);
                document.getElementById("end_date").value = end.toISOString().substring(0, 10);
                document.getElementById("start_date").value = start.toISOString().substring(0, 10);


            }
            six.onclick = function () {
                var today = new Date();
                var start = new Date(today);
                start.setMonth(today.getMonth() - 6);
                var end = new Date();

                // document.getElementById("start_date").value = start.toISOString().substring(0, 10);
                document.getElementById("end_date").value = end.toISOString().substring(0, 10);
                document.getElementById("start_date").value = start.toISOString().substring(0, 10);
            }
        }
    </script>


    <div id="wrap">
        <div id="container">
            <div id="contents">
                <aside id="side">
                    <div id="side-mypage">
                        <a href="mypageIndex"><img src="/resources/img/mypage/lnb_mypage.gif"></a>

                        <div id="side_img">
                            <img src="/resources/img/mypage/페페%20한잔해.jpg">
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

                        <h3>예매확인/취소</h3>
                    <div id="select-date">
                        <p>전재승님의 예매내역입니다. 지난 예매확인을 원하시면 조회조건을 선택해 주세요.</p>
                        <br>
                        <p>기간별 조회</p>
                        <ul>
                        <li><button class="month" id="1month">1개월</button></li>
                        <li><button class="month" id="3month">3개월</button></li>
                        <li><button class="month" id="6month">6개월</button></li>
                       </ul>
                        <form action="/mypageticket" method="get">
                            <input name="start_date" id="start_date" type="date"> ~ <input name="end_date" id="end_date" type="date">
                            <select name="option" id="option">
                                <option value="A">전체</option>
                                <option value="Y">예매확인</option>
                                <option value="C">예매취소</option>
                            </select>
                            <input id="submit" type="submit" value="조회">
                        </form>
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
                                <td><a href="/mypagedetail?ticketing_id=${TicketingDto.ticketing_id}">${TicketingDto.ticketing_status}</a></td>
                            </tr>
                            </c:forEach>
                        </table>

                        <br>

                        <div id="paging">
                            <c:if test="${ph.showPrev}">
                                <a href="<c:url value="/mypageticket?page=${ph.beginPage - 1}&pageSize=${ph.pageSize}&option=${ph.option}&start_date=${ph.start_date}&end_date=${ph.end_date}"/>">&lt;</a>
                            </c:if>
                            <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                                <a href="<c:url value="/mypageticket?page=${i}&pageSize=${ph.pageSize}&option=${ph.option}&start_date=${ph.start_date}&end_date=${ph.end_date}"/>">${i}</a>
                            </c:forEach>
                            <c:if test="${ph.showNext}">
                                <a href="<c:url value="/mypageticket?page=${ph.endPage + 1}&pageSize=${ph.pageSize}&option=${ph.option}&start_date=${ph.start_date}&end_date=${ph.end_date}"/>">&gt;</a>
                            </c:if>
                        </div>
                    </div>

                    <h3>유의사항</h3>

                    <div id="note">
                        <hr>

                        <ul>
                            <li>- 취소 시 예매수수료는 예매 당일 밤 12시 이전까지 환불되며, 그 이후 기간에는 환불되지 않습니다.</li>
                            <li>- 티켓 수령 방법 변경(현장수령 -> 배송)은 예매 완료된 건에 한하며, 배송비 결제는 신용카드만 결제 가능합니다.(단 공연일 기준 12일 전까지 / 일부 공연 불가)</li>
                            <li>- 다음과 같은 경우 PC/모바일에서는 취소 또는 부분취소가 불가하오니 고객센터로 문의해주시기 바랍니다.
                                1) YES머니, YES상품권, 쿠폰 등 예스24 결제수단을 사용하여 예매한 경우
                                2) 무통장입금 예매 후 신용카드로 배송비를 추가 결제한 경우
                                3) 티켓 배송이 완료되었거나 시작된 경우
                                (취소마감시간 이전에 고객센터로 반송되어야 취소 가능, 취소 수수료는 티켓 도착일 기준으로 부과되며 배송비는 환불 불가)</li>
                        </ul>

                        <hr>
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
