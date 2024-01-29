<%--
  Created by IntelliJ IDEA.
  User: 82109
  Date: 2024-01-29
  Time: 오후 7:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <style>
        .play-top{
            color: white;
            display: block;
            width: 100%;
            height: 100px;
            min-width: 1300px;
            position: relative;
            top: 0;
            left: 0;
            z-index: 50;
        }

        .play-top-left h1 img{
            display: inline-block;
            vertical-align: top;
            width: 90px;
            padding: 3px 0 0 5px;
        }

        .play-top-left h1 img.trans{
            display: none;
        }

        .play-top-left h1 img.fixed{
            display: inline-block;
        }

        .play-top-left{
            position: absolute;
            left: 30px;
            top: 40px;
            width: 150px;
            height: 30px;
            z-index: 10;
            background: rgba(0,0,0,0);
        }

        .play-top-left h1{
            display: inline;
            position: absolute;
            left: 30px;
            top: -10px;
            transform: translate(0,-50%);
        }

        .play-top-center{
            position: absolute;
            left: 50%;
            transform: translate(-50%,0);
            top: 33px;
            transform: translate(0,-50%);
        }

        .play-top-center h2{
            display: inline-block;
            transform: translate(0,-50%);
            margin-right: 100px;
        }

        .play-top-center h2>a{
            text-decoration: none;
            color: white;
        }

        .play-top-right{
            position: absolute;
            width: 620px;
            right: 40px;
            top: 40px;
            z-index: 10;
        }

        .play-top-right .my-page{
            background: url(https://lh3.google.com/u/0/d/1cRbX274bQ-RYPx2fTo5_kCmQiZdr0-is=w1680-h1398-iv1)no-repeat center top;
            background-size: contain;
            right: 33px;
            padding-top: 22px

        }

        .play-top-right .customer-service{
            background: url(https://lh3.google.com/u/0/d/1pUPrt2Do7EeDCYQ5PblA2EIJqI2Z0_ln=w2560-h1398-iv1)no-repeat center top;;
            background-size: contain;
            right: -11px;
            padding-top: 22px
        }

        .play-top-right .login{
            background: url(https://lh3.google.com/u/0/d/1lm3__8bTghnamlFXm6SHAIVNobxkwIOU=w2560-h1398-iv1)no-repeat center top;;
            background-size: contain;
            right: 75px;
            padding-top: 22px
        }

        .play-top-right .logout{
            display: none;
            background: url(https://lh3.google.com/u/0/d/1pN1jpIWmEaydd1QTOBox9EhBqeUpr6kZ=w2560-h1398-iv1)no-repeat center top;;
            background-size: contain;
            right: 81px;
            padding-top: 22px
        }

        .play-top-right a{
            display: inline-block;
            height: 22px;
            line-height: 24px;
            font-size: 12px;
            position: absolute;
            top: 0;
        }

        .play-bottom{
            position: relative;
            height: 165px;
            width: 100%;
            min-width: 1300px;
            padding-bottom: 25px;
            border-top: 1px solid #ddd;
            padding-bottom: 25px;
        }

        .play-bottom .cont{
            width: 1200px;
            margin: 0 auto;
        }
        .play-bottom-txt{
            position: relative;
            height: 165px;
        }

        .play-bottom-txt .bottom-main-logo{
            display: block;
            position: absolute;
            top: 30px;
            left: 2px;
        }

        .play-bottom-txt .play-bottom-copyright{
            position: absolute;
            top: 10px;
            left: 221px
        }

        .play-bottom-copyright .cr1{
            font-size: 15px;
            color: black;
            line-height: 23px;
            margin-bottom: 0px;
        }

        .play-bottom-copyright .cr2{
            font-size: 13px;
            color: gray;
        }

        .play-bottom-copyright .cr3{
            font-size: 13px;
            color: black;
        }

        .test{
            position: absolute;
            width: 1920px;
            top: 0;
            left: 50%;
            transform: translate(-50%,0);
        }

        .test-image .test-slideimg{
            position:absolute;
            width: 1920px;
            height: 720px;
            display: block;
        }
    </style>
</head>
<body style="margin: 0;">

<header class="play-top" id = "play-top">
    <!-- 좌측 -->
    <div class="play-top-left">
        <h1>
            <a href="메인페이지 이동" class="top-main-logo">
                <img src="https://lh3.google.com/u/0/d/11bTCKMYdqnoLT2uxl9rPDg2GF6aUqDQz=w2560-h1398-iv1" alt class="fixed"/>
                <img src="https://lh3.google.com/u/0/d/13ae-NtB5g7QhfSQ_J7I5LcDF4zMKYu3l=w1680-h1398-iv1" alt class="trans"/>
            </a>
        </h1>
    </div>

    <!-- 가운데 -->
    <div class="play-top-center" style="left : 500px; transform: none;">
        <h2><a href="콘서트 페이지">콘서트</a></h2>
        <h2><a href="뮤지컬 페이지">뮤지컬</a></h2>
        <h2><a href="연극 페이지">연극</a></h2>
        <h2><a href="클래식 페이지">클래식</a></h2>
    </div>
    <!-- 오른쪽 -->
    <div class="play-top-right">
        <a href="마이페이지 이동" class="my-page" style="width: 22px;"></a>
        <a href="고객센터 이동" class="customer-service" style="width: 22px;"></a>
        <a href="로그인" class="login" style="width: 22px;"></a>
        <a href="로그아웃" class="logout" style="width: 18px;"></a>
    </div>
</header>
<div class="test">
    <div class="test-image">
        <a href="공연상세페이지">
            <img src="https://lh3.google.com/u/0/d/1HVNR_tCo1KlrAFr6ruMYPa0z57u9Hj8t=w2560-h1398-iv1" alt class="test-slideimg"/>
        </a>
    </div>
</div>
<div class="ctt">
    <h1>내용입니다</h1>
    <h1>여기 내용들어가요</h1>
    <h1>content입니다</h1>
    <h1>여기 content들어가요</h1>
    <h1>디스이스 컨텐트</h1>
    <h1>this is content</h1>
    <h1>내용입니다</h1>
    <h1>여기 내용들어가요</h1>
    <h1>content입니다</h1>
    <h1>여기 content들어가요</h1>
    <h1>디스이스 컨텐트</h1>
    <h1>this is content</h1>
    <h1>내용입니다</h1>
    <h1>여기 내용들어가요</h1>
    <h1>content입니다</h1>
    <h1>여기 content들어가요</h1>
    <h1>디스이스 컨텐트</h1>
    <h1>this is content</h1>
</div>
<footer class="play-bottom" id="play-bottom">
    <div class="cont">
        <div class="play-bottom-txt">
            <a href="메인페이지 이동" class="bottom-main-logo">
                <img src="https://lh3.google.com/u/0/d/11bTCKMYdqnoLT2uxl9rPDg2GF6aUqDQz=w2560-h1398-iv1" alt class="fixed"/>
            </a>
            <div class="play-bottom-copyright">
                <p class="cr1">제이씨티켓</p>
                <p class="cr2">
                    서울시 영등포구 은행로 11, 5층~6층(여의도동,일신빌딩) | 대표 손지수, 조영상<br>
                    개인정보보호책임자 : 손지수 | e-mail : jctickethelp@jc.com   |  고객센터 : 7777-7777<br>
                    사업자등록번호 777-77-77777  | 통신판매업신고 제 7777-77777호<br>
                    호스팅 서비스사업자 : 제이씨티켓
                </p>
                <p class="cr3">Copyright © JC TICKET Corp. All Rights Reserved.</p>
            </div>
        </div>
    </div>
</footer>
</body>
</html>
