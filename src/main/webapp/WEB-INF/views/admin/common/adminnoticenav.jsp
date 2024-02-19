<%--
  Created by IntelliJ IDEA.
  User: Gram17
  Date: 2024-02-17
  Time: 오후 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="admin-common-snb">
        <div class="snb-header">
            <h2>
                공지사항
            </h2>
            <i class="fas fa-solid fa-paperclip"></i>
        </div>
        <dl>
            <dt class="menu_toggle-u10">공지사항관리
                <i class="fas fa-solid fa-arrow-down"></i>
            </dt>

            <div id="u10" style="display: block">
                <dd class="u10">
                    <a href="/admin/notice">공지사항 정보관리</a>
                </dd>
                <dd class="u10">
                    <a href="/admin/noticeregister">공지사항 등록하기</a>
                </dd>
                <dd class="u10">
                    <a href="/admin/noticedelete">공지사항 삭제하기</a>
                </dd>
            </div>
        </dl>
    </div>
</body>
</html>
