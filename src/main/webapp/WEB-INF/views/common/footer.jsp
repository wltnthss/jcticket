<%--
  Created by IntelliJ IDEA.
  User: 82109
  Date: 2024-01-29
  Time: 오후 8:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/components/footer.css">
</head>
<body>
<footer class="play-bottom" id="play-bottom">
    <div class="cont">
        <div class="play-bottom-txt">
            <a href="${pageContext.request.contextPath}/" class="bottom-main-logo">
                <img src="${pageContext.request.contextPath}/resources/img/components/로고1.png" class="logout_icon">
            </a>
            <div class="play-bottom-copyright">
                <p class="cr1">제이씨티켓</p>
                <p class="cr2">
                    서울시 영등포구 은행로 11, 5층~6층(여의도동,일신빌딩) | 대표 손지수, 조영상<br>
                    개인정보보호책임자 : 손지수 | e-mail : jctickethelp@jc.com   |  고객센터 : 7777-7777<br>
                    사업자등록번호 777-77-77777  | 통신판매업신고 제 7777-77777호<br>
                    호스팅 서비스사업자 : 제이씨티켓
                </p>
                <p class="cr3">Copyright © JC TICKET Corp. All Rights Reserved.</p>
            </div>
        </div>
        <div class="foo-right">
            <p class="mark">
                <img src="${pageContext.request.contextPath}http://tkfile.yes24.com/imgNew/common/fmark.png" alt>
            </p>
            <p class="fservice">
                고객님은 안전거래를 위한 현금 등으로 결제 시
                <br>
                저희 쇼핑몰에서 가입한 구매안전서비스를
                <br>
                이용하실 수 있습니다.
            </p>
        </div>
    </div>
</footer>
</body>
</html>
