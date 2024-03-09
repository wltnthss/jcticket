<%--
  Created by IntelliJ IDEA.
  User: Gram17
  Date: 2024-02-06
  Time: 오후 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/admin.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
</head>
<body>

    <jsp:include page="/WEB-INF/views/admin/common/adminheader.jsp"/>

    <div class="admin-common-wrap">

        <jsp:include page="/WEB-INF/views/admin/common/adminsettingnav.jsp"/>

        <div class="admin-common-content">
            <div class="admin-common-title">
                <h1>환경 설정</h1>
                <h2>관리자 정보 수정</h2>
            </div>
            <form action="${pageContext.request.contextPath}/admin/setting" method="post">
                <div class="tbl_frm01">
                    <table>
                        <colgroup>
                            <col class="w180">
                            <col>
                        </colgroup>
                        <tbody>
                        <tr>
                            <th scope="row">아이디</th>
                            <td>
                                <input type="text" value="${sessionScope.adminId}" placeholder="4글자 이상 입력." minlength="4" maxlength="20" class="frm_input required" size="20" style="background-position: right top; background-repeat: no-repeat;" disabled>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">패스워드</th>
                            <td>
                                <input type="password" value="${adminDto.admin_password}" placeholder="4글자 이상 입력." name="admin_password" minlength="4" class="frm_input required" size="20" style="background-position: right top; background-repeat: no-repeat;">
                                <p class="valid">${valid_admin_password}</p>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">이메일</th>
                            <td>
                                <input type="text" value="${adminDto.admin_email}" maxlength="20" name="admin_email" class="frm_input required" size="20" style="background-position: right top; background-repeat: no-repeat;">
                                <p class="valid">${valid_admin_email}</p>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">핸드폰</th>
                            <td>
                                <input type="text" value="${adminDto.admin_phone}" maxlength="30" name="admin_phone" class="frm_input required" size="30" style="background-position: right top; background-repeat: no-repeat;">
                                <p class="valid">${valid_admin_phone}</p>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">닉네임</th>
                            <td>
                                <input type="text" value="${adminDto.admin_nickname}" name="admin_nickname" class="frm_input required" size="30" maxlength="100" style="background-position: right top; background-repeat: no-repeat;">
                                <p class="valid">${valid_admin_nickname}</p>
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="btn-confirm">
                    <input type="submit" value="수정" id="btn_submit" class="btn-large">
                </div>
            </form>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/admin/common/adminfooter.jsp"/>

    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/admin/admin.js"></script>

</body>
</html>
