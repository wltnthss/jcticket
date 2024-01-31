<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
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
                    <th>번호</th>
                    <th style="width: 200px">제목</th>
                    <th style="width: 500px">내용</th>
                    <th style="width: 200px">작성일</th>
                    <th>조회수</th>
                </tr>

                <c:forEach items="${list}" var="NoticeDto">
                    <tr class="notice-tr">
                        <td class="notice-td">${NoticeDto.notice_seq}</td>
                        <td class="notice-td">${NoticeDto.notice_title}</td>
                        <td class="notice-td">${NoticeDto.notice_content}</td>
                        <td class="notice-td"><fmt:formatDate value="${NoticeDto.notice_reg_at}" pattern="yyyy-MM-dd" type="date"/></td>
                        <td class="notice-td">${NoticeDto.notice_view_cnt}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</head>
<body>
</body>
</html>
