<%--
  Created by IntelliJ IDEA.
  User: Gram17
  Date: 2024-02-07
  Time: 오후 6:47
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
            회원 관리
        </h2>
        <i class="fas fa-solid fa-user"></i>
    </div>
    <dl>
        <dt class="menu_toggle-u10">회원관리
            <i class="fas fa-solid fa-arrow-down"></i>
        </dt>

        <div id="u10" style="display: block">
            <dd class="u10">
                <a href="/admin/user">회원 정보관리</a>
            </dd>
            <dd class="u10">
                <a href="/admin/register">회원 등록하기</a>
            </dd>
            <dd class="u10">
                <a href="/admin/delete">회원 삭제하기</a>
            </dd>
            <dd class="u10">
                <a href="#">회원 일괄등록하기</a>
            </dd>
        </div>
        <dt class="menu_toggle-u20">가입통계
            <i class="fas fa-solid fa-arrow-down"></i>
        </dt>
        <div id="u20" style="display: block">
            <dd class="u20">
                <a href="#">월별 가입통계분석</a>
            </dd>
            <dd class="u20">
                <a href="#">일별 가입통계분석</a>
            </dd>
        </div>
    </dl>
</div>
</body>
</html>
