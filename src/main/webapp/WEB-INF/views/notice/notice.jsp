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
        <a id="notice-order1" href="/notice/paging?page=${paging.page}&keyword=${paging.keyword}&sort=seq">번호순</a>
        <a id="notice-order2" href="/notice/paging?page=${paging.page}&keyword=${paging.keyword}&sort=view">조회순</a>
        <div class="notice-search">
            <form action="/notice/paging?page=${paging.page}?keyword=${paging.keyword}">
                <input type="text" value="${paging.keyword}" name="keyword" placeholder="궁금하신 내용을 입력해주세요" >
                <button type="submit" class="notice-search-btn"></button>
            </form>
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
                    <td class="notice-td title"><a href="/notice/${NoticeDto.notice_seq}?page=${paging.page}">${NoticeDto.notice_title}</a></td>
                    <td class="notice-td content"><a href="/notice/${NoticeDto.notice_seq}?page=${paging.page}">${NoticeDto.notice_content}</a></td>
                    <td class="notice-td"><fmt:formatDate value="${NoticeDto.notice_reg_at}" pattern="yyyy-MM-dd" type="date"/></td>
                    <td class="notice-td">${NoticeDto.notice_view_cnt}</td>
                </tr>
            </c:forEach>
        </table>
    </div >

    <div class="notice-paging">
        <c:if test="${paging.showPrev}">
            <%-- 1페이지가 아닌 경우는 < 클릭하면 현재 페이지보다 1작은 페이지 요청 --%>
            <a class="notice-paging-pageitems" href="/notice/paging?page=${paging.page-1}&keyword=${paging.keyword}"> < </a>
        </c:if>

        <%-- for(int i=startPage; i<=endPage; i++) --%>
        <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
            <c:if test="${i eq paging.page}">
                <%-- 요청한 페이지에 있는 경우 현재 페이지 번호는 강조  --%>
                <a class="notice-paging-pageitems ${i eq paging.page? "active" : ""}" >${i}</a>
            </c:if>
            <c:if test="${i ne paging.page}">
                <%-- 요청한 페이지가 아닌 다른 페이지번호 클릭시 이동  --%>
                <a class="notice-paging-pageitems" href="/notice/paging?page=${i}&keyword=${paging.keyword}">${i}</a>
            </c:if>
        </c:forEach>

        <c:if test="${paging.showNext}">
            <%-- page가 maxPage보다 작으면 클릭시 현재 page에서 1증가된 페이지로 이동 --%>
            <a class="notice-paging-pageitems" href="/notice/paging?page=${paging.page+1}&keyword=${paging.keyword}"> > </a>
        </c:if>
    </div>

</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="/resources/js/notice/notice.js"></script>

<script>
    let msg = "${msg}";
    if(msg=="READ_ERR")  alert("삭제되었거나 없는 게시물입니다.");
</script>
<body>
</body>
</html>
