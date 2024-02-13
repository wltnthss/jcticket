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
