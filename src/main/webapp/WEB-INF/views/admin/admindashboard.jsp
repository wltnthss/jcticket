<%--
  Created by IntelliJ IDEA.
  User: jisoo son
  Date: 2024-02-05
  Time: 오전 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>관리자 페이지</title>
    <link rel="stylesheet" href="/resources/css/admin/admin.css">
</head>
<body class="admin-dashboard">
    <div class="admin-dashboard-container">

        <jsp:include page="/WEB-INF/views/admin/common/adminheader.jsp"/>

        <div class="admin-dashboard-body">
            <div class="admin-dashboard-main">
                <section class="admin-dashboard-side1">
                    <h2>
                        진행중 공연
                    </h2>
                    <canvas id="myChart" width="400" height="400"></canvas>
                </section>
                <section class="admin-dashboard-side2" style="width: 1100px">
                    <h2>
                        상품 요청현황
                    </h2>
                    <a href="/admin/product" style="float: right" class="admin-btn_small2">상품관리 바로가기</a>
                    <table>
                        <thead >
                        <tr>
                            <th scope="col">기획사 이름</th>
                            <th scope="col">기획사 담당자</th>
                            <th scope="col">공연명</th>
                            <th scope="col">공연장</th>
                            <th scope="col">이메일</th>
                            <th scope="col">핸드폰</th>
                            <th scope="col">요청상태</th>
                            <th scope="col">요청일시</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr class="tr_alignc">
                            <td>정석코딩 에이전시</td>
                            <td>최산하</td>
                            <td>오페라의 유령들</td>
                            <td>올림픽공원</td>
                            <td>wltnthss@gmail.com</td>
                            <td>010-6306-1756</td>
                            <td>등록요청</td>
                            <td>2020-10-04 18:05 (일)</td>
                        </tr>
                        </tbody>
                    </table>
                </section>
                <section class="admin-dashboard-side3">
                    <h2>
                        최근 회원가입
                    </h2>
                    <a href="/admin/user" class="admin-btn_small3">회원관리 바로가기</a>
                    <table>
                        <thead>
                            <tr>
                                <th scope="col">이름</th>
                                <th scope="col">아이디</th>
                                <th scope="col">핸드폰</th>
                                <th scope="col">이메일</th>
                                <th scope="col">주소</th>
                                <th scope="col">성별</th>
                                <th scope="col">접속횟수</th>
                                <th scope="col">생년월일</th>
                                <th scope="col">가입일시</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${userLists}" var="UserDto">
                            <tr class="tr_alignc">
                                <td>${UserDto.user_name}</td>
                                <td>${UserDto.user_id}</td>
                                <td>${UserDto.user_tel}</td>
                                <td>${UserDto.user_email}</td>
                                <td>${UserDto.user_address}</td>
                                <td>${UserDto.user_gender}</td>
                                <td>${UserDto.user_visit_cnt}</td>
                                <td>${UserDto.user_birth}</td>
                                <td>${UserDto.user_create_at}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </section>
            </div>
        </div>
        <hr>

        <jsp:include page="/WEB-INF/views/admin/common/adminfooter.jsp"/>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>
        let data = {
            labels: ["콘서트", "뮤지컬", "연극", "클래식"],
            datasets: [{
                data: [20, 40, 10, 30], // 각 데이터의 비율
                backgroundColor: ["#FF6384", "#36A2EB", "#FFCE56", "#e9967a"], // 각 데이터에 대한 색상
                borderColor: ["#FF6384", "#36A2EB", "#FFCE56", "#e9967a"] // 각 border에 대한 색상

            }]
        };

        // 차트 설정
        let options = {
            cutout: 90, // 중심에서 뚫릴 부분 설정
            responsive: false,
            maintainAspectRatio: false
        };

        // Canvas 엘리먼트 가져오기
        let ctx = document.getElementById("myChart").getContext("2d");

        // 원 차트 생성
        let myPieChart = new Chart(ctx, {
            type: 'doughnut',
            data: data,
            options: options
        });
    </script>
</body>
</html>
