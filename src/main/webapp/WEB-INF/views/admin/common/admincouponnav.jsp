<%--
  Created by IntelliJ IDEA.
  User: Gram17
  Date: 2024-02-06
  Time: 오후 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="admin-common-wrap">
    <div class="admin-common-snb">
        <div class="snb-header">
            <h2>
                쿠폰관리
            </h2>
            <i class="fas fa-solid fa-gift"></i>
        </div>
        <dl>
            <dt class="menu_toggle-u10">쿠폰관리
                <i class="fas fa-solid fa-arrow-down"></i>
            </dt>

            <div id="u10" style="display: block">
                <dd class="u10">
                    <a href="${pageContext.request.contextPath}/admin/coupon">쿠폰 정보관리</a>
                </dd>
                <dd class="u10">
                    <a href="${pageContext.request.contextPath}/admin/couponregister">쿠폰 등록하기</a>
                </dd>
                <dd class="u10">
                    <a href="${pageContext.request.contextPath}/admin/coupondelete">쿠폰 삭제하기</a>
                </dd>
            </div>
        </dl>
    </div>
</div>



</body>
</html>
