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
    <title>Title</title>

    <link href="/resources/css/mypage/mypage.css" rel="stylesheet">
    <link rel="icon" href="/resources/img/mypage/KakaoTalk_20240131_192702986_02.ico">

    <style>
        #paging {
            text-align: center;
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
                    <h3>할인쿠폰/예매권</h3>


                    <div id="cupon-input">
                        <form action="/mypagecupon" method="get">
                        <h2>공연 할인쿠폰</h2>

                        <input type="text" name="coupon_id">
                        <input type="submit" value="등록">
                        </form>
                    </div>

                    <div id="h2-tag">
                    <form action="/mypagecupon">
                    <button name="button" value="on"><h3>사용 가능한 쿠폰</h3></button>
                    <button name="button" value="off"><h3>사용 완료된 쿠폰</h3></button>
                    </form>
                    </div>



                    <div id="cupon-list">
                        <table>
                                <c:choose>
                                    <c:when test="${param.botton eq 'on'}">
                                        <tr>
                                            <th>쿠폰</th>
                                            <th>할인금액</th>
                                            <th>사용조건</th>
                                            <th>사용기간</th>
                                            <th>등록일</th>
                                        </tr>
                                        <c:forEach items="${coupon_list}" var="UserCouponDto">
                                        <tr>
                                            <td>${UserCouponDto.coupon_name}</td>
                                            <td>${UserCouponDto.coupon_discount_amount}원</td>
                                            <td>${UserCouponDto.coupon_use_condition}</td>
                                            <td>${UserCouponDto.coupon_expire_at} ! </td>
                                            <td>${UserCouponDto.coupon_issue_at}</td>
                                        </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:when test="${param.botton eq 'off'}">
                                        <tr>
                                            <th>쿠폰</th>
                                            <th>할인금액</th>
                                            <th>사용조건</th>
                                            <th>사용기간</th>
                                            <th>등록일</th>
                                        </tr>
                                        <c:forEach items="${coupon_list}" var="UserCouponDto">
                                        <tr>
                                            <td>${UserCouponDto.coupon_name}</td>
                                            <td>${UserCouponDto.coupon_discount_amount}원</td>
                                            <td>${UserCouponDto.coupon_use_condition}</td>
                                            <td>${UserCouponDto.coupon_expire_at}</td>
                                            <td>${UserCouponDto.coupon_issue_at}</td>
                                        </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <tr>
                                            <th>쿠폰</th>
                                            <th>할인금액</th>
                                            <th>사용조건</th>
                                            <th>사용기간</th>
                                            <th>등록일</th>
                                        </tr>
                                        <c:forEach items="${coupon_list}" var="UserCouponDto">
                                        <tr>
                                            <td>${UserCouponDto.coupon_name}</td>
                                            <td>${UserCouponDto.coupon_discount_amount}</td>
                                            <td>${UserCouponDto.coupon_use_condition}</td>
                                            <td>${UserCouponDto.coupon_expire_at}</td>
                                            <td>${UserCouponDto.coupon_issue_at}</td>
                                        </tr>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>

                        </table>

                        <div id="paging">
                            <c:if test="${ph.showPrev}">
                                <a href="<c:url value="/mypagecupon?page=${ph.beginPage - 1}&pageSize=${ph.pageSize}&button=${ph.button}"/>">&lt;</a>
                            </c:if>
                            <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                                <a href="<c:url value="/mypagecupon?page=${i}&pageSize=${ph.pageSize}&button=${ph.button}"/>">${i}</a>
                            </c:forEach>
                            <c:if test="${ph.showNext}">
                                <a href="<c:url value="/mypagecupon?page=${ph.endPage + 1}&pageSize=${ph.pageSize}&button=${ph.button}"/>">&gt;</a>
                            </c:if>
                        </div>

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
