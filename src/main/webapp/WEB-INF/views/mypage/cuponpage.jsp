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

        <%--    쿠폰 시작    --%>
        #cupon {
            margin: 10px 0px;
            font-size: 13px;
        }

        #cupon > p {
            margin-top: 15px;
        }

        <%--    쿠폰 끝    --%>
        <%--    쿠폰인풋 시작    --%>
        #cupon-input {
            margin: 20px 0px;
            width: auto;
            height: 140px;
            background-color: lightgray;
            display: flex;
        }

        #cupon-input > h2 {
            margin-top: 52px;
            margin-left: 70px;
        }

        #cupon-input > input {
            font-size: 20px;
            margin: 45px 0px;
            margin-left: 10px;
            width: 300px;
            height: 45px;
            border: 3px solid ;
        }

        #cupon-input > button {
            font-size: 20px;
            margin: 45px 0px;
            margin-left: 10px;
            width: 100px;
            height: 45px;
            border: 3px solid ;
        }

        #h2-tag{
            margin-left: 5px;

            display: flex;
        }
        #h2-tag > a{
            text-decoration: none;
            margin: 10px;
        }

        <%--    쿠폰인풋 끝    --%>

        <%--    쿠폰리스트 시작    --%>

        #cupon-list {
            border-top: 3px solid;

        }

        #cupon-list th {
            border-bottom: 1px solid;
            padding: 10px;
        }

        #cupon-list td {
            font-size: 14px;
            border-bottom: 1px solid;
            padding: 10px;
        }
        <%--    쿠폰리스트 끝    --%>

        <%--    쿠폰사용유의 시작    --%>
        #cupon-use {
            border: 1px solid;
            margin: 20px 0px;
            width: 700px;
            height: 250px;
            background-color: #6699cc;
        }

        #cupon-use > h4 {
            margin: 10px;
        }

        #cupon-use > ul {
            list-style: none;
        }

        #cupon-use > ul > li {
            margin: 5px;
        }
        <%--    쿠폰사용유의 끝    --%>


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
                    <h3>할인쿠폰/예매권</h3>
                    <div id="cupon">
                        <a href=""><img src="/resources/img/mypage/tab_02_ov.gif"></a>
                        <a href=""><img src="/resources/img/mypage/tab_01_ov.gif"></a>
                        <p>전재승 님이 가지고 계신 할인쿠폰 번호 12자리를 입력해 주세요. 예매 시 쿠폰에 기재된 금액만큼 할인해드립니다.</p>
                    </div>

                    <div id="cupon-input">
                        <h2>공연 할인쿠폰</h2>

                        <input type="text">
                        <button>등록하기</button>
                    </div>

                    <div id="h2-tag">
                    <a href=""><h3>사용 가능한 쿠폰</h3></a>
                    <a href=""><h3>사용 완료된 쿠폰</h3></a>
                    </div>
                    <div id="cupon-list">

                        <table>
                            <tr>
                                <th>쿠폰</th>
                                <th>할인금액</th>
                                <th>사용조건</th>
                                <th>사용일자</th>
                                <th>등록일</th>
                            </tr>
                            <tr>
                                <td>[네이버] 2,500원 할인</td>
                                <td>2,500원</td>
                                <td>10,000원 이상 결제 시 사용 가능
                                    다운로드 당일만 사용 가능
                                    ID당 1일 1회 발급 가능
                                    전시/체험/행사는 쿠폰 적용 제외</td>
                                <td>유효기간만료</td>
                                <td>2024.01.15</td>
                            </tr>
                            <tr>
                                <td>[네이버] 2,500원 할인</td>
                                <td>2,500원</td>
                                <td>10,000원 이상 결제 시 사용 가능
                                    다운로드 당일만 사용 가능
                                    ID당 1일 1회 발급 가능
                                    전시/체험/행사는 쿠폰 적용 제외</td>
                                <td>유효기간만료</td>
                                <td>2024.01.15</td>
                            </tr>
                        </table>

                    </div>

                    <div id="cupon-use">
                        <h4> 공연 할일쿠폰 사용 안내</h4>

                        <ul>
                            <li>- 쿠폰은 사용조건에 따라 장르 , 특정 공연, 회차, 좌석등급 등에 대한 제한이 있을 수 있으니, 사용조건을 반드시 확인해주시기 바랍니다.</li>
                            <li>- 예매 시 사용하실 쿠폰을 클릭하시면 결제 시점에 자동으로 할인가격 만큼 차감되어 결제 총 금액에 표시됩니다.</li>
                            <li>- 예매 취소 시 해당 공연에 적용된 할인금액을 제외하고 실 결제금액만큼 환불됩니다.
                                (단, 쿠폰을 사용한 경우 부분취소는 불가합니다. 부분취소를 원할 경우 고객센터로 문의해주세요.)</li>
                            <li>- 사용기간이 지난 쿠폰은 사용하실 수 없습니다.</li>
                        </ul>
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
