<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kyd54
  Date: 2024-03-29
  Time: 오후 2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script>
    alert('관람후기는 관람일자당 하나씩만 작성할 수 있습니다.');
    var referer = "<c:out value='${referer}'/>";
    window.location.href = referer+"#review_place"; // 리다이렉트할 페이지
</script>
</body>
</html>
