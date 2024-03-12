<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 82109
  Date: 2024-02-28
  Time: 오전 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/components/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/category/category.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/components/index.css">
    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
<%--<jsp:include page="../common/header.jsp"></jsp:include>--%>
<div class="top-wrap">
    <%-- 헤더시작 --%>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
</div>
<hr>
<div class="m2-kv-hidden">
    <div class="m2-kv-wrap">
        <div class="m2-kv">
            <div class="swiper-container m2-kvs">
                <div class="swiper-wrapper">
                    <c:forEach items="${list}" var="li">
                        <div class="swiper-slide">
                            <a href="${pageContext.request.contextPath}/viewdetail?this_play_id=${li.play_id}" target="_self" style="cursor: pointer">
                                <img src="<c:url value='/index/upload/${li.img_name}'/>" alt="" width="120" height="120">
                                <div class="m2-kvs-txt">
                                    <p class="m2-kvs-tit">${li.play_name}</p>
                                    <p class="m2-kvs-detail">${li.showing_period_date}</p>
                                </div>
                            </a>
                        </div>
                    </c:forEach>
                </div>
                <span class="swiper-notification" aria-live="assertive" aria-atomic="true"></span>
            </div>
        </div>
    </div>
    <div class="swiper-button-next m2-kvs" tabindex="0" role="button" aria-label="Next slide"></div>
    <div class="swiper-button-prev m2-kvs" tabindex="0" role="button" aria-label="Previous slide"></div>
    <div class="swiper-pagination"></div>
</div>

<section class="sec04">
    <p class="cont-tit num6l">
        <img src="${pageContext.request.contextPath}/resources/img/category/뮤지컬.png" alt>
    </p>

    <div class="wing-wrap">
        <div class="wing-list" id="divGenre_N_A0-006-01">
            <c:forEach items="${list}" var="li" begin="1" end="5">
                <a href="${pageContext.request.contextPath}/viewdetail?this_play_id=${li.play_id}" target="_self" style="cursor: pointer">
                    <div class="wing-box">
                        <img src="<c:url value='/index/upload/${li.img_name}'/>" alt="" width="100" height="120">
                        <div class="wing-list-txt">
                            <p class="wlist-tit">${li.play_name}</p>
                        </div>
                    </div>
                </a>
            </c:forEach>
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/6.8.4/swiper-bundle.min.js"></script>

</html>
