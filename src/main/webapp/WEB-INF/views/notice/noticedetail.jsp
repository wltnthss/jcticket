<%--
  Created by IntelliJ IDEA.
  User: Gram17
  Date: 2024-02-01
  Time: 오전 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/notice/notice.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

    <hr>
    <div class="notice-detail-container">
        <h1 class="notice-detail-text">공지사항</h1>

        <input type="text" value="${dto.notice_title}" placeholder="제목을 입력해 주세요." readonly>
        <textarea cols="60" rows="20" placeholder="내용을 입력해 주세요." readonly>${dto.notice_content}</textarea>

        <button type="button" id="notice-detail-container-btn" class="notice-detail-container btn"><i class="fa fa-bars"></i> 목록</button>

    </div>


    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

</body>
    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>

    <script>
        $(function(){

            const page = '${page}';

            // 목록 버튼 클릭시 현재 page 로 이동
            $('#notice-detail-container-btn').on('click', () => {
                location.href = "/notice/paging?page=" + page;
            });
        });
    </script>

</html>
