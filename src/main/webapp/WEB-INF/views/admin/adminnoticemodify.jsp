<%--
  Created by IntelliJ IDEA.
  User: Gram17
  Date: 2024-02-06
  Time: 오후 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/admin.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
</head>
<body>

<jsp:include page="/WEB-INF/views/admin/common/adminheader.jsp"/>

<div class="admin-common-wrap">

    <jsp:include page="/WEB-INF/views/admin/common/adminnoticenav.jsp"/>

    <div class="admin-common-content">
        <div class="admin-common-title">
            <h1>공지사항 수정하기</h1>
            <h2>공지사항 수정 정보 입력</h2>
        </div>
        <form action="${pageContext.request.contextPath}/admin/noticemodify" method="POST">
            <input type="hidden" name="notice_seq" value="${dto.notice_seq}">
            <input type="hidden" name="page" value="${page}">
            <div class="tbl_frm01">
                <table>
                    <colgroup>
                        <col class="w180">
                        <col>
                    </colgroup>
                    <tbody>
                    <tr>
                        <th scope="row">제목</th>
                        <td>
                            <label>
                                <input type="text" id="title" value="${dto.notice_title}" name="notice_title" maxlength="50" class="frm_input required" size="20" style="background-position: right top; background-repeat: no-repeat;">
                            </label>
                            <p class="valid">${valid_notice_title}</p>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">내용</th>
                        <td>
                            <textarea name="notice_content" id="content" rows="10" cols="53" maxlength="500" class="frm_input required" style="height: 200px !important;">${dto.notice_content}</textarea>
                            <p class="valid">${valid_notice_content}</p>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="btn-confirm">
                <input type="button" value="수정" id="btn_submit" class="btn-large">
                <input type="button" value="목록" id="btn_goList" class="btn-large grey">
            </div>
        </form>
    </div>
</div>

<jsp:include page="/WEB-INF/views/admin/common/adminfooter.jsp"/>

<script src="https://code.jquery.com/jquery-3.5.0.js"></script>

<script>

    let page = ${page}

    $("#btn_goList").on('click', function (){
        location.href = "/admin/notice?page=" + page
    });

    $("#btn_submit").on('click', function (){

        let form = document.querySelector("form");

        if(document.getElementById('title').value == ''){
            alert("제목을 입력해주세요");
            return false;
        }
        if(document.getElementById('content').value == ''){
            alert("내용을 입력해주세요");
            return false;
        }else{
            form.submit();
        }
    });

    let msg = "${msg}"
    if(msg=="MODIFY_ERR")  alert("수정에 실패했습니다.");

</script>

</body>
</html>
