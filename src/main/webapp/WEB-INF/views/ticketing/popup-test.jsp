<%--
  Created by IntelliJ IDEA.
  User: joyoungsang
  Date: 1/31/24
  Time: 5:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%-- ********팝업창으로 띄우기********* --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!-- <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> -->

    <link href="/resources/css/ticketing/ticketing.css" rel="stylesheet" type="text/css">
    <script>
        function showPopup(){
            let popupW = 900;
            let popupH = 800;
            let left = Math.ceil((window.screen.width - popupW)/2);
            let top = Math.ceil((window.screen.height - popupH)/2);
            window.open('ticketing-detail','','width='+popupW+',height='+popupH+',left='+left+',top='+top+',scrollbars=yes,resizable=no,toolbar=no,titlebar=no,menubar=no,location=no')
        }
    </script>
</head>
<body>
 <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <input type="button" value="예매하기" onclick="showPopup();">
</body>
</html>



<%-- ********모달창으로 띄우기********* --%>

<%--    <div class="modal">--%>
<%--        <div class="modal_body">--%>
<%--            modal test modal test modal test modal test <br>--%>
<%--            modal test modal test modal test modal test <br>--%>
<%--            modal test modal test modal test modal test <br>--%>
<%--            modal test modal test modal test modal test <br>--%>
<%--            modal test modal test modal test modal test <br>--%>
<%--            <c:forEach items="${list}" var="ticketingDto">--%>
<%--                <h3>${ticketingDto.ticketingId} ${ticketingDto.ticketingAt} ${ticketingDto.ticketingCnt} ${ticketingDto.showingInfo} ${ticketingDto.showingDate} ${ticketingDto.playPrice} ${ticketingDto.stageName} ${ticketingDto.choiceShowSeat} ${ticketingDto.ticketingPrice} ${ticketingDto.userName} ${ticketingDto.playName}</h3>--%>
<%--            </c:forEach>--%>
<%--            <button class="btn-close-modal">닫기</button>--%>
<%--        </div>--%>
<%--    </div>--%>
<%-- <script src="/resources/js/ticketing/ticketing.js"></script>--%>
<%-- <script>--%>
<%--     // 예매하기 버튼 -> 모달창 보이기--%>
<%--     $(".btn-open-modal").click(function (){--%>
<%--         $(".modal").fadeIn();--%>
<%--     })--%>
<%--     // 닫기 버튼 -> 모달칭 숨기기--%>
<%--     $(".btn-close-modal").click(function (){--%>
<%--         $(".modal").fadeOut();--%>
<%--     })--%>
<%-- </script>--%>
