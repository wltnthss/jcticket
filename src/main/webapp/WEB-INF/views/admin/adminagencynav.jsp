<%--
  Created by IntelliJ IDEA.
  User: Gram17
  Date: 2024-02-13
  Time: 오후 1:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="admin-common-snb">
        <div class="snb-header">
            <h2>
                기획사관리
            </h2>
            <i class="fas fa-solid fa-city"></i>
        </div>
        <dl>
            <dt class="menu_toggle-u10">기획사관리
                <i class="fas fa-solid fa-arrow-down"></i>
            </dt>

            <div id="u10" style="display: block">
                <dd class="u10">
                    <a href="/admin/agency">기획사 정보관리</a>
                </dd>
                <dd class="u10">
                    <a href="/admin/agencyregister">기획사 등록하기</a>
                </dd>
            </div>
        </dl>
    </div>
</body>
</html>
