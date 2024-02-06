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
            height: 820px;
            float: left;
            margin: 0px 20px;
        }

        <%--     mypage시작   --%>


        #container {
            width: 960px;
            height: 921px;
        }

        #side-mypage, #side-ticket, #side-client {
            display: inline-block;
        }

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
        <%--    클라이언트 시작    --%>

        <%--    select-date 시작    --%>

        #select-date {
            width: 690px;
            height: 100px;
            margin: 20px auto;
            border: 1px solid #dddddd;
            background-color: #dddddd;
        }

        #select-date > p {
            margin: 5px 5px;
            display: inline-block;
        }

        #select-date > ul {
            list-style: none;
        }

        #select-date > ul > li {
            margin: 3px;
            float: left;
        }

        #select-date > input {
            width: 180px;
        }
        <%--    select-date 끝    --%>

        <%--    ticketing 시작    --%>
        #ticketing {
            margin: 10px;
        }

        #ticketing > table{
            margin: auto;
            text-align: center;
            font-size: 15px;
        }

        #ticketing th {
            padding: 10px;
            border-top: 1px solid;
            border-bottom: 1px solid;
        }
        #ticketing td {
            padding: 10px;
            border-bottom: 1px solid;
        }
        <%--    ticketing 끝    --%>

        <%--    note 시작    --%>

        #note {
            padding-left: 5px;
            text-align: left;
            font-size: 12px;
            margin: 10px 0;
        }

        #note > hr{
            height: 2px;
            background: black;
        }

        #note > ul {
            list-style: none;
        }

        #note > ul > li{
            margin: 5px;
        }
        <%--    note 끝    --%>



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

                        <h3>예매확인/취소</h3>
                    <div id="select-date">
                        <p>전재승님의 최근 1개월 예매내역입니다. 지난 예매확인을 원하시면 조회조건을 선택해 주세요.</p>
                        <br>
                        <p>기간별 조회</p>
                        <ul>
                        <li><button>1개월</button></li>
                        <li><button>3개월</button></li>
                        <li><button>6개월</button></li>
                       </ul>
                        <p>주문일자별 조회</p>
                        <input type="date"> ~ <input type="date">
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
                            <tr>
                                <td>2024.01.16</td>
                                <td>Y7275193880</td>
                                <td>국립중앙박물관 특별전 ‘탕탕평평-글과 그림의 힘’</td>
                                <td>2024.01.17-10:00</td>
                                <td>1</td>
                                <td>예매</td>
                            </tr>
                            <tr>
                                <td>2024.01.16</td>
                                <td>Y7275193880</td>
                                <td>국립중앙박물관 특별전 ‘탕탕평평-글과 그림의 힘’</td>
                                <td>2024.01.17-10:00</td>
                                <td>1</td>
                                <td>취소</td>
                            </tr>
                        </table>

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
