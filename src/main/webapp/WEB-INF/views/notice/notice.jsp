<%--
  Created by IntelliJ IDEA.
  User: Gram17
  Date: 2024-01-30
  Time: 오후 1:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/notice/notice.css">
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

    <hr>
    <div class="notice-container">
        <h1 class="notice-text">공지사항</h1>

        <div class="notice-table">
            <table>
                <tr>
                    <th>구분</th>
                    <th style="width: 600px">제목</th>
                    <th style="width: 200px">티켓오픈 일시</th>
                    <th>조회수</th>
                </tr>
            </table>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>
