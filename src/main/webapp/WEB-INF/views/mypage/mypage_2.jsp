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
            text-align: center;
        }

        #wrap-center {
            width: 1300px;
            display: inline-block;
        }

        #top {
            display: inline;
            height: 500px;
        }

        #ticket {
            float: left;
            display: inline-block;
        }

        #ticket_img > a {
            float: left;
        }

        #my_ticket {
            display: inline-block;
            width: 208px;
            border: 1px solid;
            background-color: lightgray;
        }

        #my_ticket > #grade {
            margin-top: 2px;
            font-size: 12px;

        }

        #middle {
            display: inline;
        }

        #point {
            display: block;
            margin: 5px;
            font-size: 14px;
            border: 2px solid blueviolet;
            border-radius: 5px;
            background-color: white;
        }

        #point > ul {
            display: block;
            padding-left: 0;
            list-style: none;
            text-align: center;
        }

        #cupon {
            width: 300px;
            display: inline-block;
        }

        #event {
            width: 300px;
            display: inline-block;
        }

    </style>
</head>
    <link rel="icon" href="/resources/css/img/KakaoTalk_20240131_192702986_02.ico">
<body>

    <jsp:include page="../common/header.jsp"></jsp:include>

    <hr>

    <div id="wrap">
        <div id="wrap-center">
            <div id="top">
                <div id="ticket"><img src="/resources/css/img/lnb_mypage.gif" alt="my_ticket"></div>
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
                </div>

                <div id="cupon">
                    <h2>COUPON</h2>
                </div>
                <div id="event">
                    <h2>EVENT</h2>
                </div>
            </div>
            <div id="middle"></div>

            <div id="bottom"></div>
        </div>
    </div>

    <jsp:include page="../common/footer.jsp"></jsp:include>

</body>
</html>
