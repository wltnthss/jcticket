<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <div class="notice-category">
            <a id="notice-order1" class="on">등록순</a>
            <a id="notice-order2" class="">조회순</a>
            <div class="notice-search">
                <input type="text" placeholder="궁금하신 내용을 입력해주세요"><a style="cursor: pointer"></a>
            </div>
        </div>

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
                        <td class="notice-td title"><a href="<c:url value="/notice/notice_seq=${NoticeDto.notice_seq}"/>">${NoticeDto.notice_title}</a></td>
                        <td class="notice-td content"><a href="<c:url value="/notice/notice_seq=${NoticeDto.notice_seq}"/>">${NoticeDto.notice_content}</a></td>
                        <td class="notice-td"><fmt:formatDate value="${NoticeDto.notice_reg_at}" pattern="yyyy-MM-dd" type="date"/></td>
                        <td class="notice-td">${NoticeDto.notice_view_cnt}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
    <script src="/resources/js/notice/notice.js"></script>
</head>
<body>
</body>
</html>
