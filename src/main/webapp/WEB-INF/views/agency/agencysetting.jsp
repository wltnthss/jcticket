<%--
  Created by IntelliJ IDEA.
  User: 82109
  Date: 2024-02-12
  Time: 오후 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <%--                <section class="agency-dashboard-side1">--%>
            <%--                   --%>

            <%--                </section>--%>
            <section class="agency-dashboard-side2" style="width: 1100px">

            </section>
        </div>
    </div>
    <hr>

    <jsp:include page="/WEB-INF/views/agency/agencyfooter.jsp"/>

</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>


</body>
</html>
