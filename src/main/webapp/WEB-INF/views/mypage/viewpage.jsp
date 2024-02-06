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

    <style>
        * {
            margin: 0;
            padding: 0;
        }

        #container {
            width: 960px;
            height: 900px;
            margin: auto;
        }


        #side {
            width: 210px;
            height: 900px;
            float: left;
        }

        #con {
            width: 700px;
            height: 900px;
            float: left;
            margin: 0px 20px;
        }

        <%--     mypage시작   --%>


        #infor {
            width: 208px;
            height: 150px;
            border: 1px solid;
            background-color: #e9e8e8;
        }

        #infor-name {
            margin: 3px;
        }

        #infor-point {
            width: 195px;
            height: 85px;
            border: 1px solid;
            border-radius: 5px;
            margin: auto;
            background-color: white;
        }

        #infor-point > ul {
            font-size: 15px;
            margin: 2px;
            list-style: none;
            padding-left: 10px;
            border-radius: 5px;
        }

        #infor-update  {
            margin: 5px;
            display: flex;
            justify-content: center;
        }
        <%--     mypage끝   --%>

        <%--    예약관리 시작    --%>
        #ticket {
            margin: 20px 0px;
            padding-left: 5px;
            border: 5px solid darkorchid;
            border-radius: 5px;
            list-style: none;
        }

        #ticket > a {
            text-decoration-line: none;
        }
        #ticket > a > h3 {
            margin: 10px;
        }
        <%--    예약관리 끝    --%>

        <%--    클라이언트 시작    --%>
        #client {
            border: 5px solid #6699cc;
            border-radius: 5px;
            padding-left: 5px;
        }

        #client > ul {
            list-style: none;
        }
        <%--    클라이언트 끝    --%>


        #con > h3 {
            margin-bottom: 15px;
        }

        #viewing {
            width: 700px;
            height: 150px;
            border: 1px solid;
        }

        #viewing > p {
            font-size: 14px;
            padding: 15px;
        }

        #view-date {
            margin: 5px 15px;
        }


        #view-date > input {
            width:160px;
            height: 25px;
        }

        #view-select {
            display: inline-block;
            margin-left: 40px;
        }

        #view-select > select {
            width: 165px;
            height: 25px;
        }

        #view-nmae {
            display: inline-block;
            margin: 20px;
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

        <%--    끝    --%>

        #show-img {
            width: 100%;
            display: flex;
        }

        #show-img > a > img {
            margin: 10px 5px;
            width: 700px;
            height: 300px;
        }


    </style>
</head>
<link rel="icon" href="/resources/img/mypage/KakaoTalk_20240131_192702986_02.ico">
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
                    <img src="/resources/img/mypage/lnb_mypage.gif">
                    <div id="infor">
                        <div id="infor-name"><span>전재승님은일반회원입니다.</span></div>
                        <div id="infor-point">
                            <ul>
                                <li>yes포인트: 250원</li>
                                <li>yes포인트: 250원</li>
                                <li>yes포인트: 250원</li>
                                <li>yes포인트: 250원</li>
                            </ul>
                        </div>
                        <div id="infor-update"><button>회원정보수정</button></div>
                    </div>

                    <div id="ticket">
                        <a href=""><h3>예매확인/취소</h3></a>
                        <a href=""><h3>쿠폰/예매권</h3></a>
                        <a href=""><h3>나의 관람 공연</h3></a>
                        <a href=""><h3>문의사항</h3></a>
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
