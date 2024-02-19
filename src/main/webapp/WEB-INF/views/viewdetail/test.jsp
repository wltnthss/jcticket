<%--
  Created by IntelliJ IDEA.
  User: kyd54
  Date: 2024-02-14
  Time: 오후 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .buttonimg {
            background: url('/resources/img/viewdetail/testposter.jpg') no-repeat;
            background-size: cover;
            width: 210px;
            height: 300px;
        }
    </style>
</head>
<body>
<form id="viewDetailForm" action="/viewdetail" method="get">
    <button type="button" id="공연아이디1" class="buttonimg" onclick="moveToPlay1()"></button>
</form>

<script>
    function moveToPlay1() {
        // 공연1의 아이디를 가져와서 URL에 추가
        var playId = '공연아이디1';
        // var url = '/viewdetail?this_play_id=' + encodeURIComponent(playId);
        var url = '/viewdetail?this_play_id=' + playId;
        // URL로 이동
        window.location.href = url;
    }
</script>
</body>
</html>
