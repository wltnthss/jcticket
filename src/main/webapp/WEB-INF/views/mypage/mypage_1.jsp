<%--
  Created by IntelliJ IDEA.
  User: wjswo
  Date: 2024-01-31
  Time: 오후 7:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>마이페이지</title>

    <style>

        html {
            margin: 0;
            padding: 0;
        }

        #wrap {
            display: block;
            width: 980px;
            height: 800px;
            margin: 0 auto;
            text-align: center;
        }

        #left-contents {
            float: left;
        }

        #my_ticket {
            font-size: 12px;
            border: 1px solid;
            margin: auto;
            background-color: lightgray;
        }

        #point {
            border: 2px solid violet;
            border-radius: 10px;
            margin: 5px 5px;
            background: white;
        }

        #point > ul {
            list-style: none;
            padding-left: 0;
        }

        #information_change {
            border: 1px solid #dddddd;
            border-radius: 10px;
            padding: 5px 5px;
            margin: 5px 0px;
            display: inline-block;
            background-color: white;
        }

        #information_change > a {
            text-decoration: none;
        }

        #ticketing {
            margin-top: 10px;
            border: 5px solid darkcyan;
            float: left;
            display: inline;
            margin-bottom: 5px;
        }

        #ticketing > ul {
            list-style: none;
            padding-left: 0;
        }

        #telNum > ul {
            text-align: left;
            list-style: none;
            padding-left: 10px;
        }

        #center-contents {
            display: flex;
        }

        #coupon, #event {
            text-align: left;
            width: 520px;
            height: 35px;
            margin: 0px 10px;
            background-color: slateblue;
        }

        #event > h2 {
            margin: 1px;
            padding-left: 5px;
        }

        #coupon > h2 {
            margin: 1px;
            padding-left: 5px;
        }

        #coupon > ul{
            margin: auto;
            border: 1px solid;
            font-size: 10px;
            padding: 10px;
            list-style: none;
        }
        #event > ul{
            margin: auto;
            border: 1px solid;
            font-size: 10px;
            padding: 10px;
            list-style: none;
        }

        #banner {
            position: relative;
            top: 75px;
            left: 225px;
            width: 740px;
            height: 150px;
            
        }

        #banner > a > img {
            position: relative;
            top: -540px;
            width: 100%;
            height: 100%;
            object-fit: cover;
        }


        #middle_list {
            text-align: center;
            position: relative;
            width: 733px;
            left: 15px;
            top: 90px;
            border: 1px solid #444444;
            border-collapse: collapse;
        }
        th {
            border: 1px solid #444444;
            padding: 5px;
            background-color: lightgray;
        }
        td {
            font-size: 12px;
            border-bottom: 1px solid #444444;
            padding: 15px;
        }



    </style>
</head>
    <link rel="icon" href="/resources/img/mypage/KakaoTalk_20240131_192702986_02.ico">
<body>

    <jsp:include page="../common/header.jsp"></jsp:include>

    <hr>

    <div id="wrap">
        <div id="cotainer">
            <div id="left-contents">
                <div><a href=""><img src="/resources/img/mypage/lnb_mypage.gif"></a></div>
                <div id="my_ticket">
                    <div id="grade"><span>Ralo님은 일반회원입니다.</span></div>

                    <div id="point">
                        <ul>
                            <li>YES포인트 : 250원 <a style="font-size: 8px" href="">안내</a></li>
                            <li>YES머니 : 250원</li>
                            <li>YES상품권 : 250원</li>
                            <li>예치금 : 250원</li>
                        </ul>
                    </div>


                    <div id="information_change"><a href="">회원정보 수정</a></div>
                </div>
                <div id="ticketing">
                    <ul>
                        <li><a href=""><img src="/resources/img/mypage/lmenu_01_ov.gif"></a></li>
                        <li><a href=""><img src="/resources/img/mypage/lmenu_02.gif"></a></li>
                        <li><a href=""><img src="/resources/img/mypage/lmenu_04.gif"></a></li>
                        <li><a href=""><img src="/resources/img/mypage/lmenu_05.gif"></a></li>
                    </ul>
                </div>

                <div id="telNum">
                    <h1>고객 센터</h1>
                    <span><img src="http://tkfile.yes24.com/img/guide/txt_telnum.gif" alt=""></span>
                    <ul>
                        <li>평일&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;09:00 ~ 18:00</li>
                        <li>토요일&nbsp;&nbsp;&nbsp;09:00 ~ 17:00</li>
                        <li>일요일 공휴일 휴무</li>
                    </ul>
                </div>
            </div>
            <div id="center-contents">
                <div id="coupon">
                    <h2>COUPOM</h2>
                    <ul>
                        <li>공연 할인쿠폰 : 사용가능 0 매</li>
                        <li>공연 예매권 : 사용가능 0 매</li>
                    </ul>
                </div>
                <div id="event">
                    <h2>EVENT</h2>
                    <ul>
                        <li>뮤지컬 [디어 에반 핸슨] 기대평 이벤트</li>
                        <li>창작가무극 다윈 영의 악의 기원기대평 이벤트</li>
                    </ul>
                </div>
            </div>

            <div id="banner">
                <a href=""><img src="/resources/css/img/페페%20한잔해.jpg"></a>
            </div>

                <div></div>
                <table id="middle_list">
                    <tr>
                        <th>예매일</th><th>예매번호</th><th>공연명</th><th>관람일시</th><th>매수</th><th>예매상태</th>
                    </tr>
                    <tr>
                        <td>2024.01.16</td><td>Y7275193880</td><td>국립중앙박물관 특별전 ‘탕탕평평-글과 그림의 힘’</td><td>2024.01.17-10:00</td><td>1</td><td>예매</td>
                    </tr>
                </table>



        </div>
    </div>

    <hr>
    <jsp:include page="../common/footer.jsp"></jsp:include>

</body>
</html>
