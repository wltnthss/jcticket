<%--
  Created by IntelliJ IDEA.
  User: 82109
  Date: 2024-02-13
  Time: 오전 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>관리자 페이지</title>
    <link rel="stylesheet" href="/resources/css/agency/agency.css">
</head>
<body class="agency-dashboard">
<div class="agency-dashboard-container">

    <jsp:include page="/WEB-INF/views/agency/agencyheader.jsp"/>

    <div class="agency-dashboard-body">
        <div class="agency-dashboard-main">
            <section class="agency-dashboard-side2">
                <h2>판매 종료</h2>

                <table>
                    <thead >
                    <tr>
                        <th scope="col">상품정보</th>
                        <th scope="col">일시</th>
                        <th scope="col">공연장</th>
                        <th scope="col">상품관리/수정</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr class="tr_alignc" id="dynamicRow">
                        <!-- 받는 칸 3개 까지만 늘어 나도록 -->
                        <td>(포스터랑 정보들 받아와야하는데.. 투명하게 칸 나눠서 받을지 고민해봐야함,)</td>
                        <td>(일시)</td>
                        <td>(공연장)</td>
                        <td>(버튼만들기)</td>

                    </tr>
                    </tbody>
                </table>
            </section>



        </div>
    </div>

</div>
</body>
</html>
