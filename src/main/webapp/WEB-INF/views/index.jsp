<%--
  Created by IntelliJ IDEA.
  User: 82109
  Date: 2024-01-29
  Time: 오후 7:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/resources/css/components/header.css">
    <link rel="stylesheet" href="/resources/css/components/index.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/6.8.4/swiper-bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="/resources/js/category/category.js"></script>
</head>

<body>
<div class="top-wrap">
    <%-- 헤더시작 --%>
    <header class="play-top_main" id = "play-top">
        <!-- 좌측 -->
        <div class="play-top-left">
                <a href="/" class="top-main-logo">
                    <img src="/resources/img/components/로고2.png" alt class="fixed"/>
                    <img src="/resources/img/components/로고1.png" alt class="trans"/>
                </a>
        </div>

        <!-- 가운데 -->
        <div class="play-top-center-main" style="left : 500px; transform: none;">
            <a href="/concert">콘서트
                <span class="concert-sp"></span>
            </a>
            <a href="/musical">뮤지컬
                <span class="musical-sp"></span>
            </a>
            <a href="/play">연극
                <span class="play-sp"></span>
            </a>
            <a href="/classic">클래식
                <span class="classic-sp"></span>
            </a>
        </div>
        <!-- 오른쪽 -->
        <div class="play-top-right">
            <a href="mypageIndex" class="my-page">
                <img src="/resources/img/components/마이페이지_백.png" class="mp_icon">
            </a>

            <a href="/notice/paging" class="notice">
                <img src="/resources/img/components/공지사항_백.png" class="notice_icon">
            </a>
            <c:choose>
                <c:when test="${empty sessionScope.sessionId}">
                    <!-- 로그인 상태가 아니면(세션이 없으면) 로그인 링크를 보여줌 -->
                    <a href="/login" class="login">
                        <img src="/resources/img/components/로그인_백.png" class="login_icon">
                    </a>
                </c:when>
                <c:otherwise>
                    <!-- 로그인 상태이면(세션이 있으면) 로그아웃 링크를 보여줌 -->
                    <a href="/logout" class="logout" style="width: 22px;">
                        <img src="/resources/img/components/로그아웃_백.png" class="logout_icon">
                    </a>
                </c:otherwise>
            </c:choose>
            <a class="search">
                <input type="text" id="searchWord" autocomplete="off">
                <img src="http://tkfile.yes24.com/imgNew/common/pf-srch.png" alt="" style="margin-left: 8px; cursor:pointer;" id="searchBtn">
            </a>
        </div>
    </header>
</div>
    <%-- 헤더끝 --%>

    <%-- 상단 공연 슬라이드 시작--%>
    <div class="pf-kvslide-wrap">
        <div class="pf-kvslide">
                <%--슬라이드-공연1--%>
            <div class="kv-item" id="kv-item1">
                <a href="공연상세페이지1">
                    <img src="http://tkfile.yes24.com/Upload2/Display/202401/20240125/wel_mv_48485_349fd8.jpg/dims/quality/70/" alt class="lazyload">
                </a>
                <a class="pf-kv-text white" href="공연상세페이지1">
                    <p class="sub-tit"></p>
                    <p class="main-tit"></p>
                    <p class="info-tit"></p>
                </a>
            </div>
                <%--슬라이드-공연2--%>
            <div class="kv-item">
                <a href="공연상세페이지2">
                    <img src="http://tkfile.yes24.com/Upload2/Display/202402/20240206/wel_mv_48552.jpg/dims/quality/70/" alt class="lazyload">
                </a>
                <a class="pf-kv-text white" href="공연상세페이지2">
                    <p class="sub-tit"></p>
                    <p class="main-tit"></p>
                    <p class="info-tit"></p>
                </a>
            </div>
                <%--슬라이드-공연2--%>
            <div class="kv-item">
                <a href="공연상세페이지3">
                    <img src="http://tkfile.yes24.com/Upload2/Display/202401/20240119/wel_mv_48398_82559c.jpg/dims/quality/70/" alt class="lazyload">
                </a>
                <a class="pf-kv-text white" href="공연상세페이지2">
                    <p class="sub-tit"></p>
                    <p class="main-tit"></p>
                    <p class="info-tit"></p>
                </a>
            </div>
        </div>
                <%-- 슬라이드 페이징 1--%>
        <div class="pf-kvslide-pager">
            <div class="pager-bg">
                <a href="#" class>
                    <img src="http://tkfile.yes24.com/Upload2/Display/202401/20240125/wel_mv_48485_s.jpg/dims/quality/70/" alt class="lazyload">
                    <span>1/10</span>
                </a>
                <a href="#" class>
                    <img src="http://tkfile.yes24.com/Upload2/Display/202402/20240206/wel_mv_48552.jpg/dims/quality/70/" alt class="lazyload">
                    <span>2/10</span>
                </a>
                <a href="#" class>
                    <img src="http://tkfile.yes24.com/Upload2/Display/202401/20240119/wel_mv_48398_s.jpg/dims/quality/70/" alt class="lazyload">
                    <span>3/10</span>
                </a>
            </div>
        </div>


                <%-- 슬라이드 방향키--%>
        <div class="pf-kvslide-dir">
            <a href="#" class="pf-kv-prev">
                <img src="http://tkfile.yes24.com/imgNew/common/slide-dir-prev.png">
            </a>
            <a href="#" class="pf-kv-next">
                <img src="http://tkfile.yes24.com/imgNew/common/slide-dir-next.png">
            </a>
        </div>
    </div>
        <%-- 상단 공연 슬라이드 끝--%>

    <%-- content area    --%>
<%--section1 시작--%>
<section class="sec01">
    <p class="cont-tit">
        <img src="http://tkfile.yes24.com/imgNew/main/tit1.png" alt>
    </p>
    <div class="cont">
        <div class="whot-area">
            <ul id="ulWhatshot">
                <%-- 왓츠핫 큰항목 --%>
                <li>
                    <div class="big-one">
                        <a href="/viewdetail?this_play_id=공연아이디1" target="_self" style="z-index: 0">
                            <img src="/resources/img/viewdetail/testposter.jpg" alt>
                            <div class="big-one-txt">
                                <p class="big-tit">제목</p>
                                <p class="big-detail">공연날짜, 공연장소
                                <span></span>
                                </p>
                            </div>
                        </a>
                    </div>
                </li>
                    <%-- 왓츠핫 작은항목1 --%>
                    <c:forEach items="${list}" var="p">
                    <li>
                        <div class="whot-list">
                            <a>
                                <img src="<c:url value='/index/upload/${p.img_name}'/>" alt="" width="100" height="120">
                                <div class="whot-list-txt">
                                    <div>
                                        <p class="whot-tit">${p.play_name}</p>
                                        <p class="whot-detail">
                                                ${p.showing_period_date}
                                            <br>
                                                ${p.stage_name}
                                        </p>
                                        <p class="whot-event"></p>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </li>
                    </c:forEach>

            </ul>
        </div>
    </div>
</section>
<%--section1끝--%>

<%--section2시작--%>
<section class="sec02">
    <p class="cont-tit">
        <img src="http://tkfile.yes24.com/imgNew/main/tit2-1.png">
    </p>
        <div class="cont">
            <div class="swiper-container ticketo swiper-container-initialized swiper-container-horizontal">
                <div class="swiper-wrapper">
                    <div class="swiper-slide">
                        <a href="티켓 오픈 항목1">
                            <img src="/resources/img/index/test2.png" alt class="lazyload">
                            <div class="donut-area">
                                <canvas id="chart-area14063" class="donut"></canvas>
                            </div>
                            <div class="donut-dday1">
                                D-DAY
                            </div>
                            <div class="ticket-txt">
                                <p class="ticket-date">
                                    날짜
                                </p>
                                <p class="ticket-tit">
                                    제목
                                </p>
                            </div>
                        </a>
                    </div>

                    <div class="swiper-slide">
                        <a href="티켓 오픈 항목2">
                            <img src="/resources/img/index/test1.png" alt class="lazyload">
                            <div class="donut-area">
                                <canvas id="chart-area14061" class="donut"></canvas>
                            </div>
                            <div class="donut-dday2">
                                D-2
                            </div>
                            <div class="ticket-txt">
                                <p class="ticket-date">
                                    날짜
                                </p>
                                <p class="ticket-tit">
                                    제목
                                </p>
                            </div>
                        </a>
                    </div>

                    <div class="swiper-slide">
                        <a href="티켓 오픈 항목3">
                            <img src="/resources/img/index/test2.png" alt class="lazyload">
                            <div class="donut-area">
                                <canvas id="chart-area14058" class="donut"></canvas>
                            </div>
                            <div class="donut-dday3">
                                D-1
                            </div>
                            <div class="ticket-txt">
                                <p class="ticket-date">
                                    날짜
                                </p>
                                <p class="ticket-tit">
                                    제목
                                </p>
                            </div>
                        </a>
                    </div>

                    <div class="swiper-slide">
                        <a href="티켓 오픈 항목4">
                            <img src="/resources/img/index/test1.png" alt class="lazyload">
                            <div class="donut-area">
                                <canvas id="chart-area14051" class="donut"></canvas>
                            </div>
                            <div class="donut-dday4">
                                D-3
                            </div>
                            <div class="ticket-txt">
                                <p class="ticket-date">
                                    날짜
                                </p>
                                <p class="ticket-tit">
                                    제목
                                </p>
                            </div>
                        </a>
                    </div>

                    <div class="swiper-slide">
                        <a href="티켓 오픈 항목5">
                            <img src="/resources/img/index/test2.png" alt class="lazyload">
                            <div class="donut-area">
                                <canvas id="chart-area14040" class="donut"></canvas>
                            </div>
                            <div class="donut-dday5">
                                D-3
                            </div>
                            <div class="ticket-txt">
                                <p class="ticket-date">
                                    날짜
                                </p>
                                <p class="ticket-tit">
                                    제목
                                </p>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <div class="bnr-slide">
            <div class="bnrslide">
                <div class="swiper-slide2 active">
                    <a href="중간 슬라이드 상세페이지1">
                        <img src="http://tkfile.yes24.com/Upload2/Display/202311/20231127/wel_wide_47873_2.png/dims/quality/70/" alt class="lazyload">
                    </a>
                </div>
                <div class="swiper-slide2">
                    <a href="중간 슬라이드 상세페이지2">
                        <img src="http://tkfile.yes24.com/Upload2/Display/202312/20231205/wel_wide_47595.png/dims/quality/70/" alt class="lazyload">
                    </a>
                </div>
                <div class="swiper-slide2">
                    <a href="중간 슬라이드 상세페이지3">
                        <img src="http://tkfile.yes24.com/Upload2/Display/202401/20240125/wel_wide_48277_f9dfdf.png/dims/quality/70/" alt class="lazyload">
                    </a>
                </div>
            </div>
        </div>

</section>
<%--section2끝--%>

<%--section4시작 musical/play--%>
<section class="sec04">
    <p class="cont-tit num6l">
        <img src="http://tkfile.yes24.com/imgNew/main/tit4.png" alt>
    </p>

    <div class="wing-wrap">
        <div class="wing-list" id="divGenre_N_A0-006-01">
            <c:forEach items="${musiCalAndPlayList}" var="li" begin="1" end="6">
                <a href="musical/play 항목 1">
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
<%--section4시작--%>

<%--section4시작 musical/play--%>
<section class="sec04">
    <p class="cont-tit num6l">
        <img src="http://tkfile.yes24.com/imgNew/main/tit5.png" alt>
    </p>

    <div class="wing-wrap">
        <div class="wing-list" id="divGenre_N_A0-006-02">
            <c:forEach items="${concertAndClassicList}" var="li" begin="1" end="6">
                <a href="musical/play 항목 1">
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
<%--section4시작--%>

<%--section3시작--%>
<section class="sec03">
    <div class="focuson">
        <div class="focuson-wrap">
            <div class="focus-txt">
                <%-- 좌측 타이틀 --%>
                <p class="focus-tit">
                    <span href="#">
                        <img src="http://tkfile.yes24.com/imgNew/main/tit8.png">
                    </span>
                </p>
                <p class="focus-tit2">
                    <a href="포커스온 해당공연 상세페이지">
                        뮤지컬
                        <br>
                        스쿨 오브 락
                    </a>
                </p>
                <p class="focus-detail">
                    <a href="포커스온 해당공연 상세페이지">브로드웨이를 휩쓴 만장일치의 찬사!</a>
                </p>
            </div>

            <%-- 유튜브 --%>
            <div class="focus-con">
                <iframe width="640" height="360" src="https://www.youtube.com/embed/4SBywZkUkoI?si=YtoTnKgQ3V_hOxpQ" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
            </div>
        </div>
    </div>
</section>
<%--section3끝--%>

<%--section5시작--%>
<section class="sec05">
    <div class="cont">
        <div class="con-left">
            <p class="tel">
                7777-7777
            </p>
            <dl>
                <dt>평일</dt>
                <dd>09:00~18:00</dd>
                <dt>토요일</dt>
                <dd>09:00~17:00
                    <span>(일요일 및 공휴일 휴무)</span>
                </dd>
            </dl>
        </div>

        <div class="con-center">
            <div class="cca1">
            <a href="/notice/paging">
                <img src="/resources/img/components/공지사항.png">
            </a>
            <span>공지사항</span>
            </div>

            <div class="cca2">
            <a href="/notice/paging">
                <img src="data:image/png;base64,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">
            </a>
            <span>FAQ</span>
            </div>

            <div class="cca3">
                <c:choose>
                    <c:when test="${empty sessionScope.sessionId}">
                        <!-- 로그인 상태가 아니면(세션이 없으면) 로그인 링크를 보여줌 -->
                        <a href="/login">
                            <img src="/resources/img/components/로그인_흑.png">
                        </a>
                        <span>로그인</span>
                    </c:when>
                    <c:otherwise>
                        <!-- 로그인 상태이면(세션이 있으면) 로그아웃 링크를 보여줌 -->
                        <a href="/logout">
                            <img src="/resources/img/components/로그아웃_흑.png">
                        </a>
                        <span>로그아웃</span>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>

        <div class="con-right">
            <div class="social">
                <a href="#" class="soc1">
                    <img src="http://tkfile.yes24.com/imgNew/main/social1.png">
                </a>
                <a href="#" class="soc2">
                    <img src="http://tkfile.yes24.com/imgNew/main/social2.png">
                </a>
                <a href="#" class="soc3">
                    <img src="http://tkfile.yes24.com/imgNew/main/social3.png">
                </a>
            </div>
            <div class="appdown">
                <a href="#">
                    <img src="http://tkfile.yes24.com/imgNew/main/appdown1.png">
                </a>
                <a href="#">
                    <img src="http://tkfile.yes24.com/imgNew/main/appdown2.png">
                </a>
            </div>

            <a href="https://www.culture.go.kr/deduction/main.do" class="deduction" target="_blank">
                <img src="	http://tkfile.yes24.com/imgNew/main/deduction.png" alt>
            </a>
        </div>
    </div>
</section>
<script src="/resources/js/index/top_slide.js"></script>
<%--section5끝--%>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>

</html>
