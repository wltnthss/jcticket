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
    <link rel="stylesheet" href="/resources/css/admin/admin.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
</head>
<body>

    <jsp:include page="/WEB-INF/views/admin/adminheader.jsp"/>

    <div class="admin-common-wrap">

        <%--좌측 nav 페이지--%>
        <jsp:include page="/WEB-INF/views/admin/adminnav.jsp"/>

        <div class="admin-common-content">
            <div class="admin-common-title">
                <h1>회원 정보등록하기</h1>
                <h2>개인정보 입력</h2>
            </div>
            <form action="/admin/register" method="post">
                <div class="tbl_frm01">
                    <table>
                        <colgroup>
                            <col class="w180">
                            <col>
                        </colgroup>
                        <tbody>
                        <tr>
                            <th scope="row">회원 아이디</th>
                            <td><input type="text" placeholder="4글자 이상 입력." minlength="4" name="user_id" maxlength="20" required="" class="frm_input required" size="20" style="background-position: right top; background-repeat: no-repeat;"></td>
                        </tr>
                        <tr>
                            <th scope="row">회원 패스워드</th>
                            <td><input type="password" placeholder="4글자 이상 입력." minlength="4" name="user_password" required="" class="frm_input required" size="20" style="background-position: right top; background-repeat: no-repeat;"></td>
                        </tr>
                        <tr>
                            <th scope="row">이름(실명)</th>
                            <td><input type="text" maxlength="20" placeholder="한글만 입력." pattern="[ㄱ-ㅎ ㅏ-ㅣ 가-힣0 -9]*" name="user_name" required="" class="frm_input required" size="20" style="background-position: right top; background-repeat: no-repeat;"></td>
                        </tr>
                        <tr>
                            <th scope="row">닉네임</th>
                            <td><input type="text" maxlength="30" name="user_nickname" required="" class="frm_input required" size="30" style="background-position: right top; background-repeat: no-repeat;"></td>
                        </tr>
                        <tr>
                            <th scope="row">이메일</th>
                            <td>
                                <input type="email" placeholder="email@gmail.com" pattern="[a-zA-Z0-9]*[@][a-zA-Z0-9]*\.[a-zA-Z]*" name="user_email" required="" class="frm_input required" size="40" maxlength="100" style="background-position: right top; background-repeat: no-repeat;">
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">휴대폰번호</th>
                            <td><input type="text" placeholder="ex) 010-0000-0000" required pattern="(010|016|011)-[0-9]{3,4}-[0-9]{4}" name="user_tel" class="frm_input" size="20" maxlength="20"></td>
                        </tr>
                        <tr>
                            <th scope="row">주소</th>
                            <td>
                                <input type="text" name="user_address" required class="frm_input frm_address" size="100">
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">생년월일</th>
                            <td><input type="text" name="user_birth" maxlength="8" placeholder="ex) 20000101" required="" class="frm_input required" style="background-position: right top; background-repeat: no-repeat;"></td>
                        </tr>
                        <tr>
                            <th scope="row">성별</th>
                            <td><input type="text" pattern="M|F" placeholder="M 또는 F 입력." maxlength="1" name="user_gender" required="" class="frm_input required"  size="20" style="background-position: right top; background-repeat: no-repeat;"></td>
                        </tr>
                        <tr>
                            <th scope="row">관심장르</th>
                            <td><input type="text" name="user_interested_genre" required="" class="frm_input required" style="background-position: right top; background-repeat: no-repeat;"></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="btn-confirm">
                    <input type="submit" value="저장" id="btn_submit" class="btn-large">
                </div>
            </form>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/admin/adminfooter.jsp"/>

    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
    <script src="/resources/js/admin/admin.js"></script>
</body>
</html>
