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


    <style>
        #client_top {
            border: 1px solid;
            height: 100px;
            font-size: 24px;
            font-weight: bold;
        }

        #client_top > h3 {
            display: inline-block;
            margin: 25px;
        }

        #client_top > a {
            padding: 10px;
            text-decoration: none;
            border: 1px solid;
            font-size: 18px;
            margin-left: 330px;
        }

        #client_list_box {
            margin: 30px 0px;
            width: 100%;
            height: 600px;
        }

        #client_left_top {
            text-align: center;
            float: left;
            border: 1px solid;
            width: 170px;
            height: 90px;
        }
        #client_left_top > h3 {
            margin: 33px;
        }

        #client_right_top {
            float: left;
            border: 1px solid;
            width: 535px;
            height: 90px;
        }

        #client_right_top > input {
            padding: 10px;
            border-radius: 5px;
            width: 515px;
            margin: 20px 10px;
            height: 50px;
        }

        #client_left_mid {
            text-align: center;
            float: left;
            border: 1px solid;
            width: 170px;
            height: 300px;
        }
        #client_left_mid > h3 {
            margin: 138px 0px;
        }

        #client_right_mid {
            float: left;
            border: 1px solid;
            width: 535px;
            height: 300px;
        }

        #client_right_mid > textarea {
            font-size: 18px;
            resize: none;
            padding: 10px;
            border-radius: 5px;
            width: 515px;
            margin: 20px 10px;
            height: 260px;
        }


        #client_left_bottom {
            text-align: center;
            float: left;
            border: 1px solid;
            width: 170px;
            height: 205px;
        }

        #client_left_bottom > h3 {
            margin: 91px 0px;
        }

        #client_right_bottom {
            float: left;
            border: 1px solid;
            width: 535px;
            height: 205px;
        }



        #text1, #text2{
            padding: 10px;
            border-radius: 5px;
            width: 255px;
            margin: 26px 10px;
            height: 50px;
        }

        #client_select {
            margin: 20px 0px;
            width: 100%;
            height: 50px;
        }

        #client_select > select {
            width: 50%;
            height: 50px;
        }

        #email, #phone {
            height: 20px;
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
                    <div id="client_top">
                        <h3 id="client_top_h3">1:1 문의하기</h3>

                        <a href="mypageclient">1:1 문의내역</a>
                    </div>

                    <div id="client_select">
                        <select>
                            <option>선택사항</option>
                            <option>반품문의</option>
                            <option>상품문의</option>
                            <option>기타문의</option>
                        </select>
                    </div>


                    <div id="client_list_box">
                        <div id="client_left_top">
                            <h3>문의사항</h3>
                        </div>
                        <div id="client_right_top">
                            <input type="text">
                        </div>
                        <div id="client_left_mid">
                            <h3>문의내용</h3>
                        </div>
                        <div id="client_right_mid">
                            <textarea></textarea>
                        </div>
                        <div id="client_left_bottom">
                            <h3>답변알림</h3>
                        </div>
                        <div id="client_right_bottom">
                            <div id="text_box">
                                <input id="text1" type="text" value="wjswotmd2@naver.com"> <input id="email" type="checkbox"> 이메일로 답변받기
                                <input id="text2" type="text" value="010-3348-1395"> <input id="phone" type="checkbox"> 핸드폰으로 답변받기
                            </div>


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
