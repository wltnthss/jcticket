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

    <jsp:include page="/WEB-INF/views/admin/common/adminheader.jsp"/>

    <div class="admin-common-wrap">

        <%--좌측 nav 페이지--%>
        <jsp:include page="/WEB-INF/views/admin/common/adminusernav.jsp"/>

        <div class="admin-common-content">
            <div class="admin-common-title">
                <h1>회원 등록하기</h1>
                <h2>개인정보 입력</h2>
            </div>
            <form action="/admin/userregister" method="post">
                <div class="tbl_frm01">
                    <table>
                        <colgroup>
                            <col class="w180">
                            <col>
                        </colgroup>
                        <tbody>
                        <tr>
                            <th scope="row">회원 아이디</th>
                            <td>
                                <input type="text" value="${userDto.user_id}" placeholder="4글자 이상 입력." name="user_id" minlength="4" maxlength="20" class="frm_input required" size="20" style="background-position: right top; background-repeat: no-repeat;">
                                <p class="valid">${valid_user_id}</p>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">회원 패스워드</th>
                            <td>
                                <input type="password" value="${userDto.user_password}" placeholder="4글자 이상 입력." name="user_password" minlength="4" class="frm_input required" size="20" style="background-position: right top; background-repeat: no-repeat;">
                                <p class="valid">${valid_user_password}</p>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">이름(실명)</th>
                            <td>
                                <input type="text" value="${userDto.user_name}" maxlength="20" name="user_name" class="frm_input required" size="20" style="background-position: right top; background-repeat: no-repeat;">
                                <p class="valid">${valid_user_name}</p>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">닉네임</th>
                            <td>
                                <input type="text" value="${userDto.user_nickname}" maxlength="30" name="user_nickname" class="frm_input required" size="30" style="background-position: right top; background-repeat: no-repeat;">
                                <p class="valid">${valid_user_nickname}</p>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">이메일</th>
                            <td>
                                <input type="email" value="${userDto.user_email}" placeholder="email@gmail.com" pattern="[a-zA-Z0-9]*[@][a-zA-Z0-9]*\.[a-zA-Z]*" name="user_email" class="frm_input required" size="40" maxlength="100" style="background-position: right top; background-repeat: no-repeat;">
                                <p class="valid">${valid_user_email}</p>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">휴대폰번호</th>
                            <td>
                                <input type="text" value="${userDto.user_tel}" placeholder="ex) 010-0000-0000" pattern="(010|016|011)-[0-9]{3,4}-[0-9]{4}" name="user_tel" class="frm_input" size="20" maxlength="20">
                                <p class="valid">${valid_user_tel}</p>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">주소</th>
                            <td>
                                <input type="text" value="${userDto.user_address}" name="user_address" class="frm_input frm_address" size="100">
                                <p class="valid">${valid_user_address}</p>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">생년월일</th>
                            <td>
                                <input type="text" value="${userDto.user_birth}" name="user_birth" maxlength="8" placeholder="ex) 20000101" class="frm_input required" style="background-position: right top; background-repeat: no-repeat;">
                                <p class="valid">${valid_user_birth}</p>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">성별</th>
                            <td>
                                <input type="text" value="${userDto.user_gender}" pattern="M|W" placeholder="M 또는 W 입력." maxlength="1" name="user_gender" class="frm_input required"  size="20" style="background-position: right top; background-repeat: no-repeat;">
                                <p class="valid">${valid_user_gender}</p>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">관심장르</th>
                            <td>
                                <select name="user_interested_genre">
                                    <option value="콘서트">콘서트</option>
                                    <option value="뮤지컬">뮤지컬</option>
                                    <option value="연극">연극</option>
                                    <option value="클래식">클래식</option>
                                </select>
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="btn-confirm">
                    <input type="submit" value="저장" id="btn_submit" class="btn-large">
                </div>
            </form>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/admin/common/adminfooter.jsp"/>

    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
    <script src="/resources/js/admin/admin.js"></script>

    <script>
        let msg = "${msg}";
        if(msg=="INS_ERR")  alert("회원 등록에 실패했습니다. 재신청해주세요.");
    </script>
</body>
</html>
