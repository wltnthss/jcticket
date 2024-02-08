<%--
  Created by IntelliJ IDEA.
  User: joyoungsang
  Date: 1/31/24
  Time: 5:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!-- <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> -->

    <link href="/resources/css/ticketing/ticketing.css" rel="stylesheet" type="text/css">
</head>
<body>
 <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <button class="btn-open-modal">예매하기</button>
    <div class="modal">
        <div class="modal_body">
            modal test modal test modal test modal test <br>
            modal test modal test modal test modal test <br>
            modal test modal test modal test modal test <br>
            modal test modal test modal test modal test <br>
            modal test modal test modal test modal test <br>
            <c:forEach items="${list}" var="ticketingDto">
                <h3>${ticketingDto.ticketingId} ${ticketingDto.ticketingAt} ${ticketingDto.ticketingCnt} ${ticketingDto.showingInfo} ${ticketingDto.showingDate} ${ticketingDto.playPrice} ${ticketingDto.stageName} ${ticketingDto.choiceShowSeat} ${ticketingDto.ticketingPrice} ${ticketingDto.userName} ${ticketingDto.playName}</h3>
            </c:forEach>
            <button class="btn-close-modal">닫기</button>
        </div>
    </div>
 <script src="/resources/js/ticketing/ticketing.js"></script>
 <script>
     // 예매하기 버튼 -> 모달창 보이기
     $(".btn-open-modal").click(function (){
         $(".modal").fadeIn();
     })
     // 닫기 버튼 -> 모달칭 숨기기
     $(".btn-close-modal").click(function (){
         $(".modal").fadeOut();
     })
 </script>
</body>
</html>
