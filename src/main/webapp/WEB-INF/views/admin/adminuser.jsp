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
    <link rel="stylesheet" href="/resources/css/admin/admin.css">
</head>
<body>

    <jsp:include page="/WEB-INF/views/admin/adminheader.jsp"/>

    <div class="admin-common-wrap">
        <div class="admin-common-snb">
            <div class="snb-header">
                <h2>
                    회원 관리
                </h2>
            </div>
            <dl>
                <dt class="menu_toggle">회원관리</dt>
                <dd class="active">
                    <a href="/admin/user">회원 정보관리</a>
                </dd>
                <dd class="">
                    <a href="/admin/register">회원 등록하기</a>
                </dd>
                <dd class="">
                    <a href="/admin/register">회원 삭제하기</a>
                </dd>
                <dt class="menu_toggle">가입통계</dt>
                <dd class="">
                    <a href="/admin/register">월별 가입통계분석</a>
                </dd>
                <dd class="">
                    <a href="/admin/register">일별 가입통계분석</a>
                </dd>
            </dl>
        </div>
        <div class="admin-common-content">
            <div class="admin-common-title">
                <h1>회원 정보관리</h1>
                <p>test1</p>
                <p>test1</p>
                <p>test1</p>
                <p>test1</p>
                <p>test1</p>
                <p>test1</p>
                <p>test1</p>
                <p>test1</p>
                <p>test1</p>

            </div>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/admin/adminfooter.jsp"/>

</body>
</html>
