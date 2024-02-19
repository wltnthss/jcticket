<%--
  Created by IntelliJ IDEA.
  User: jisoo son
  Date: 2024-02-05
  Time: 오전 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/admin/admin.css">
</head>
<body>

    <div class="admin-login-container">
        <div class="loginbox">
            <div class="loginleft">
                <p class="blind">Welcome Ticket Manager</p>
            </div>
            <div class="loginright">
                <h1>티켓매니저 관리자 로그인</h1>
                <form class="loginform form-group" id="loginform" action="<c:url value="/admin"/>" method="POST">
                    <fieldset>
                        <legend class="blind">로그인</legend>
                        <div class="inputwrap">
                            <label class="loginform idform">
                                <input id="admin_id" name="admin_id" placeholder="아이디" type="text" value="${adminValidLoginDto.admin_id}">
                                <p class="valid">${valid_admin_id}</p>
                            </label>
                        </div>
                        <div>
                        </div>
                        <div class="inputwrap">
                            <label class="loginform passwordform">
                                <input autocomplete="current-password" id="admin_password" name="admin_password" placeholder="비밀번호" type="password" value="${adminValidLoginDto.admin_password}">
                                <p class="valid">${valid_admin_password}</p>
                            </label>
                        </div>
                        <div>
                            <span id="loginfail"></span>
                        </div>
                        <div class="btnwrap">
                            <p class="valid">${failLogin}</p>
                            <button type="submit" class="btnLogin">로그인</button>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</body>

<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<%--<script src="/resources/js/admin/admin.js"></script>--%>

</html>
