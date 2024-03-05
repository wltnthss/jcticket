<%--
  Created by IntelliJ IDEA.
  User: kyd54
  Date: 2024-02-20
  Time: 오전 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>error.jsp</title>
</head>
<body>
<h1>예외가 발생했습니다.</h1>
발생한 예외 : ${error}<br>
예외 메시지 : ${error.message}<br>
<ol>
    <c:forEach items="${error.stackTrace}" var="i">
        <li>${i.toString()}</li>
    </c:forEach>
</ol>
</body>
</html>