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
        <a id="notice-order1" class="on">번호순</a>
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

<<<<<<< HEAD
    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
    <script src="/resources/js/notice/notice.js"></script>
</head>

=======
            <c:forEach items="${list}" var="NoticeDto">
                <tr class="notice-tr">
                    <td class="notice-td">${NoticeDto.notice_seq}</td>
                    <td class="notice-td title"><a href="/notice/${NoticeDto.notice_seq}?page=${paging.page}">${NoticeDto.notice_title}</a></td>
                    <td class="notice-td content"><a href="/notice/${NoticeDto.notice_seq}?page=${paging.page}">${NoticeDto.notice_content}</a></td>
                    <td class="notice-td"><fmt:formatDate value="${NoticeDto.notice_reg_at}" pattern="yyyy-MM-dd" type="date"/></td>
                    <td class="notice-td">${NoticeDto.notice_view_cnt}</td>
                </tr>
            </c:forEach>
        </table>
    </div >

    <div class="notice-paging">
        <%-- 현재 페이지가 1페이지면 이전 글자만 보여줌 --%>
        <c:if test="${paging.page<=1}">
            <a class="notice-paging-pageitems"> < </a>
        </c:if>
        <%-- 1페이지가 아닌 경우는 [이전] 클릭하면 현재 페이지보다 1작은 페이지 요청 --%>
        <c:if test="${paging.page>=2}">
            <a class="notice-paging-pageitems" href="/notice/paging?page=${paging.page-1}"> < </a>
        </c:if>

        <%-- for(int i=startPage; i<=endPage; i++) --%>
        <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
            <%-- 요청한 페이지에 있는 경우 현재 페이지 번호는 텍스트만 보이게 --%>
            <c:if test="${i eq paging.page}">
                <a class="notice-paging-pageitems ${i eq paging.page? "active" : ""}" >${i}</a>
            </c:if>

            <c:if test="${i ne paging.page}">
                <a class="notice-paging-pageitems" href="/notice/paging?page=${i}">${i}</a>
            </c:if>
        </c:forEach>

        <c:if test="${paging.page >= paging.maxPage}">
            <a class="notice-paging-pageitems"> > </a>
        </c:if>

        <c:if test="${paging.page < paging.maxPage}">
            <a class="notice-paging-pageitems" href="/notice/paging?page=${paging.page+1}"> > </a>
        </c:if>
    </div>

</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="/resources/js/notice/notice.js"></script>
</body>
</html>
