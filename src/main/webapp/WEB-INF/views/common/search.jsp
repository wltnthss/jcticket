<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Gram17
  Date: 2024-03-07
  Time: 오후 7:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/components/header.css">
    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>

<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

<div class="content-min-wrap">
    <div class="srch-top">
        <p>
            <span id="resultSearchWord">'${word}'</span>에 대한 검색 결과 입니다.
        </p>
    </div>

    <div class="srch-sec srch-sec01">
        <div class="srch-list">
            <c:forEach items="${list}" var="p">
                <div class="srch-list-item">
                        <div>
                            <a href="#" target="_blank">
                                <img src="<c:url value='/index/upload/${p.img_name}'/>" alt="" width="100" height="120">
                            </a>
                        </div>
                        <div>
                            <p class="item-state"><span class="item-state02">${p.showing_status}</span></p>
                            <p class="item-tit" style="font-weight: bold;"><a href="#" target="_blank" style="text-decoration-line: none">${p.play_name}</a></p>
                        </div>
                        <div>${p.showing_period_date}</div>
                        <div>${p.stage_name}</div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

</body>
</html>
