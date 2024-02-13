<%--
  Created by IntelliJ IDEA.
  User: wjswo
  Date: 2024-02-04
  Time: PM 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

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
                        <img src="/resources/img/mypage/페페%20한잔해.jpg">
                    </div>

                    <div id="ticket">
                        <a href="/mypageticket"><h3>예매확인/취소</h3></a>
                        <a href="/mypagecupon"><h3>쿠폰/예매권</h3></a>
                        <a href="/mypageview"><h3>나의 관람 공연</h3></a>
                        <a href="/mypageclient"><h3>문의사항</h3></a>
                        <a href=""><h3>회원정보 수정</h3></a>
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

                <div id="viewing">
                    <p>전재승님의 관람 공연은 총 1건 입니다.(2024년 02월 05일 기준) / 관람후기 작성 1건, 미작성 0건</p>
                    <hr>

                    <div id="view-date">
                        기간별 <input type="date"> ~ <input type="date">
                        <div id="view-select">장르별 <select>
                                <option>뮤지컬</option>
                                <option>공연</option>
                                <option>콘서트</option>
                                <option>관람</option>
                                <option>뮤지컬</option>
                                </select>
                        </div>

                        <div id="view-nmae">공연명 <input type="text"> <a href="">조회</a></div>
                    </div>
                </div>


                <div id="show-img">
                    <a href=""><img src="/resources/img/mypage/페페%20한잔해.jpg"></a>
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
