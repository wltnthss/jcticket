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

    <link href="${pageContext.request.contextPath}/resources/css/mypage/mypage.css" rel="stylesheet">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/mypage/KakaoTalk_20240131_192702986_02.ico">

    <style>

        <%--  공통부분 CSS      --%>
        #container {
            width: 1200px;
            height: 900px;
            margin: auto;
        }

        #con {
            width: 950px;
            height: 1200px;
            float: left;
            margin: 0px 20px;
        }

        <%--        --%>

        #cupon {
            margin: 10px 0px;
            font-size: 13px;
        }

        #cupon > p {
            margin-top: 15px;
        }


        #cupon-input {
            border: 5px solid lightgray;
            margin: 20px 0px;
            width: auto;
            height: 110px;
            background-color: #FAFAFA;
            display: flex;
            align-content: flex-start;
            align-items: center;
            justify-content: space-around;
            flex-direction: column;
            border-radius: 5px;
        }

        #cupon-input > input {
            width: 200px;
        }



        #cupon-input > input {
            font-size: 20px;
            margin: 45px 0px;
            margin-left: 10px;
            width: 300px;
            height: 45px;
            border: 3px solid;
        }

        #cupon-input > button {
            font-size: 20px;
            margin: 45px 0px;
            margin-left: 10px;
            width: 100px;
            height: 45px;
            border: 3px solid;
        }

        #h2-tag {
            margin-left: 5px;

            display: flex;
        }

        #h2-tag > a {
            text-decoration: none;
            margin: 10px;

        }

        #h2-tag  h3 {
            border-radius: 5px;
            width: 200px;
            height: 25px;
        }


        #cupon-list {
            border-top: 3px solid;
        }

        #cupon_list > table {
            width: 940px;
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

        #cupon-use {
            text-align: center;
            border: 1px solid;
            margin: 20px 10px;
            width: 923px;
            height: 250px;
            background-color: #FAFAE9;
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

        #coupon_insert {
            width: 300px;
            height: 35px;
            font-size: 20px;
            font-weight: bold;
            border-radius: 3px;
        }

        #insert_btn {
            width: 100px;
            height: 35px;
        }

        #coupon_table {
            width: 940px;
        }

        #paging {
            text-align: center;
            font-size: 20px;
            font-weight: bold;
            color: black;
        }

        #paging > a {
            text-decoration-line: none;
            color: black;
        }

        td:nth-child(2n), th:nth-child(2n){
            background-color: #fafafa;
        }
        td:nth-child(2n-1), th:nth-child(2n-1){
            background-color: #eeeeee;
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
                        <a href="mypageIndex"><img src="${pageContext.request.contextPath}/resources/img/mypage/lnb_mypage.gif"></a>

                        <div id="side_img">
                            <img src="${pageContext.request.contextPath}/resources/img/mypage/img.jpg">
                        </div>



                        <div id="ticket">
                            <a href="${pageContext.request.contextPath}/mypageticket"><h3>예매확인/취소</h3></a>
                            <a href="${pageContext.request.contextPath}/mypagecupon"><h3>쿠폰/예매권</h3></a>
                            <a href="${pageContext.request.contextPath}/mypageview"><h3>나의 관람 공연</h3></a>
                            <a href="${pageContext.request.contextPath}/mypageclient"><h3>문의사항</h3></a>
                            <a href="${pageContext.request.contextPath}/Modifying"><h3>회원정보 수정</h3></a>
                            <a href="${pageContext.request.contextPath}/withdraw"><h3>회원탈퇴</h3></a>
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
                        <h2>공연 할인쿠폰</h2>
                        <form action="${pageContext.request.contextPath}/mypagecupon" method="get">
                        <input id="coupon_insert" type="text" name="coupon_id">
                        <input id="insert_btn" type="submit" value="등록">
                        </form>
                    </div>

                    <div id="h2-tag">
                    <form action="${pageContext.request.contextPath}/mypagecupon">
                    <button name="button" value="on"><h3>사용 가능한 쿠폰</h3></button>
                    <button name="button" value="off"><h3>사용 완료된 쿠폰</h3></button>
                    </form>
                    </div>



                    <div id="cupon-list">
                        <table id="coupon_table">
                                <c:choose>
                                    <c:when test="${param.button eq 'on'}">
                                        <tr>
                                            <th>쿠폰</th>
                                            <th>할인금액</th>
                                            <th>사용조건</th>
                                            <th>사용기간</th>
                                            <th>등록일</th>
                                        </tr>
                                        <c:forEach items="${coupon_list}" var="MyUserCouponDto">
                                        <tr>
                                            <td>${MyUserCouponDto.coupon_name}</td>
                                            <td>${MyUserCouponDto.coupon_discount_amount}원</td>
                                            <td>${MyUserCouponDto.coupon_use_condition}</td>
                                            <td>${MyUserCouponDto.user_coupon_expire_at} </td>
                                            <td>${MyUserCouponDto.user_coupon_issue_at}</td>
                                        </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:when test="${param.button eq 'off'}">
                                        <tr>
                                            <th>쿠폰</th>
                                            <th>할인금액</th>
                                            <th>사용조건</th>
                                            <th>사용일자</th>
                                            <th>등록일</th>
                                        </tr>
                                        <c:forEach items="${coupon_list}" var="MyUserCouponDto">
                                        <tr>
                                            <td>${MyUserCouponDto.coupon_name}</td>
                                            <td>${MyUserCouponDto.coupon_discount_amount}원</td>
                                            <td>${MyUserCouponDto.coupon_use_condition}</td>
                                            <td>기간만료</td>
                                            <td>${MyUserCouponDto.user_coupon_issue_at}</td>
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
                                            <td>${UserCouponDto.user_coupon_expire_at}</td>
                                            <td>${UserCouponDto.user_coupon_issue_at}</td>
                                        </tr>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>

                        </table>

                        <div id="paging">
                            <c:if test="${ph.showPrev}">
                                <a href="<c:url value="${pageContext.request.contextPath}/mypagecupon?page=${ph.beginPage - 1}&pageSize=${ph.pageSize}&button=${ph.button}"/>">&lt;</a>
                            </c:if>
                            <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                                <a href="<c:url value="${pageContext.request.contextPath}/mypagecupon?page=${i}&pageSize=${ph.pageSize}&button=${ph.button}"/>">${i}</a>
                            </c:forEach>
                            <c:if test="${ph.showNext}">
                                <a href="<c:url value="${pageContext.request.contextPath}/mypagecupon?page=${ph.endPage + 1}&pageSize=${ph.pageSize}&button=${ph.button}"/>">&gt;</a>
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
