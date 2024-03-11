<%--
  Created by IntelliJ IDEA.
  User: wjswo
  Date: 2024-02-04
  Time: PM 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>2
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

        #viewing {
            width: 945px;
            height: 150px;
            border: 3px solid #E8EAF6;
            background-color: #FAFAFA;
        }

        #viewing > p {
            font-size: 18px;
            padding: 15px;
            font-weight: bold;
        }

        #view-date > input {
            width: 160px;
            height: 25px;
        }


        #view-select > select {
            width: 165px;
            height: 25px;
        }


        #view-nmae > input {
            width: 230px;
            height: 25px;
        }

        #view-nmae > a {
            border-radius: 3px;
            color: #dddddd;
            text-decoration: none;
            margin-left: 5px;
            padding-left: 5px;
            padding-right: 5px;
            padding-bottom: 5px;
            border: 1px solid #444444;
            background-color: #444444;
        }


        #show-all {
            border: 5px solid #FAFAE9;
            width: 940px;
            text-align: left;
            display: flex;
            background-color: #FAFAFA;
            border-radius: 5px;
        }

        #show-all  span {
            font-size: 18px;
            font-weight: bold;
        }

        #show-all  em {
            font-size: 20px;

        }

        #show-all > #show-img{
            display: inline-block;
            width: 230px;
        }

        #show-all > #show-img > a > img {
            display: inline-block;
            width: 200px;
            height: 250px;
        }

        #show-all > #show-text {
            display: flex;
            margin: 20px 20px;
            width: 850px;
            flex-direction: row;
            align-items: flex-start;
            flex-wrap: wrap;
        }
        #show-all > #show-text > span,em {
            margin: 6px 28px
        }
        #paging {
            text-align: center;
        }

        #title {
            text-align: center;
            border: 3px solid #dddddd;
            margin: 15px 0px 0px 0px;
            background-color: #FAFAFA;
            padding: 2px;
            border-radius: 5px;
        }

        #paging {
            text-align: center;
            font-size: 20px;
            font-weight: bold;
            color: black;
            margin: 20px 0px;
        }

        #paging > a {
            text-decoration-line: none;
            color: black;
        }

        .line {
            width: 720px;
        }

        .form_tag {
            margin: 15px 25px;
        }

        .form_tag > select {
            width: 130px;
            height: 25px;
        }

        .submit {
            width: 60px;
            height: 25px;
        }

        #start_date, #end_date {
            width: 250px;
            height: 25px;
        }

        .form_tag > p {
            display: inline-block;
            font-weight: bold;
        }

        #keyword {
            font-weight: bold;
            width: 200px;
            height: 25px;
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
                <h3>나의 관람 공연</h3>

                <br>

                <div id="viewing">
                    <p>전재승님의 관람 공연은 총 1건 입니다.(2024년 02월 05일 기준) / 관람후기 작성 1건, 미작성 0건</p>
                    <hr>

                    <form class="form_tag" action="/mypageview" method="get">
                        <input name="start_date" id="start_date" type="date"> ~ <input name="end_date" id="end_date" type="date">
                        <select name="option">
                            <option value="A">전체</option>
                            <option value="G">연극</option>
                            <option value="C">콘서트</option>
                            <option value="J">전시</option>
                            <option value="M">뮤지컬</option>
                        </select>
                        <input class="submit" type="submit" value="조회">
                    </form>

                    <form class="form_tag" action="/mypageview" method="get">
                        <p>공연명 :</p> <input id="keyword" type="text" name="keyword">
                        <input class="submit" type="submit" value="조회" >
                    </form>

                </div>




                <c:forEach items="${view_list}" var="TicketingDto">
                <h2 id="title">${TicketingDto.play_name}</h2>
                <div id="show-all">
                    <div id="show-img"><a href=""><img src="/resources/img/mypage/페페%20한잔해.jpg"></a></div>
                    <div id="show-text">
                        <div class="line"><span>예매번호 :</span> <em>${TicketingDto.ticketing_id}</em></div>
                        <div class="line"><span>장르 :</span> <em>${TicketingDto.play_major_cat}</em></div>
                        <div class="line"><span>관람일시: </span> <em>${TicketingDto.ticketing_at}</em></div>
                        <div class="line"><span>공연장 : </span> <em>${TicketingDto.stage_name}</em></div>
                        <div class="line"><span>좌석 : </span> <em>${TicketingDto.selected_seats}</em></div>
                    </div>
                </div>
                </c:forEach>

                <div id="paging">
                    <c:if test="${ph.showPrev}">
                        <a href="<c:url value="/mypageview?page=${ph.beginPage - 1}&pageSize=${ph.pageSize}&option=${ph.option}&start_date=${ph.start_date}&end_date=${ph.end_date}&keyword=${ph.keyword}"/>">&lt;</a>
                    </c:if>
                    <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                        <a href="<c:url value="/mypageview?page=${i}&pageSize=${ph.pageSize}&option=${ph.option}&start_date=${ph.start_date}&end_date=${ph.end_date}&keyword=${ph.keyword}"/>">${i}</a>
                    </c:forEach>
                    <c:if test="${ph.showNext}">
                        <a href="<c:url value="/mypageview?page=${ph.endPage + 1}&pageSize=${ph.pageSize}&option=${ph.option}&start_date=${ph.start_date}&end_date=${ph.end_date}&keyword=${ph.keyword}"/>">&gt;</a>
                    </c:if>
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
