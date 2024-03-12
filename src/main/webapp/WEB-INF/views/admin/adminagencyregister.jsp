<%--
  Created by IntelliJ IDEA.
  User: Gram17
  Date: 2024-02-13
  Time: 오후 1:19
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
        <%--좌측 nav 페이지--%>
        <jsp:include page="/WEB-INF/views/admin/common/adminagencynav.jsp"/>

        <div class="admin-common-content">
            <div class="admin-common-title">
                <h1>기획사 등록하기</h1>
                <h2>개인정보 입력</h2>
            </div>
            <form action="${pageContext.request.contextPath}/admin/agencyregister" method="post">
                <div class="tbl_frm01">
                    <table>
                        <colgroup>
                            <col class="w180">
                            <col>
                        </colgroup>
                        <tbody>
                        <tr>
                            <th scope="row">기획사 아이디</th>
                            <td>
                                <input type="text" value="${agencyDto.agency_id}" name="agency_id" placeholder="4글자 이상 입력." minlength="4" maxlength="20" class="frm_input required" size="20" style="background-position: right top; background-repeat: no-repeat;">
                                <p class="valid">${valid_agency_id}</p>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">기획사 패스워드</th>
                            <td>
                                <input type="password" value="${agencyDto.agency_password}" name="agency_password" placeholder="4글자 이상 입력." minlength="4" class="frm_input required" size="20" style="background-position: right top; background-repeat: no-repeat;">
                                <p class="valid">${valid_agency_password}</p>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">기획사 이름</th>
                            <td>
                                <input type="text" value="${agencyDto.agency_name}" maxlength="20" name="agency_name" class="frm_input required" size="20" style="background-position: right top; background-repeat: no-repeat;">
                                <p class="valid">${valid_agency_name}</p>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">이메일</th>
                            <td>
                                <input type="text" value="${agencyDto.agency_email}" maxlength="30" name="agency_email" placeholder="email@gmail.com" class="frm_input required" size="30" style="background-position: right top; background-repeat: no-repeat;">
                                <p class="valid">${valid_agency_email}</p>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">휴대폰번호</th>
                            <td>
                                <input type="text" value="${agencyDto.agency_tel}" name="agency_tel" placeholder="000-0000-0000" class="frm_input required" size="20" maxlength="100" style="background-position: right top; background-repeat: no-repeat;">
                                <p class="valid">${valid_agency_tel}</p>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">사업자등록번호</th>
                            <td>
                                <input type="text" value="${agencyDto.agency_register_num}" name="agency_register_num" placeholder="ex) 00-000-00000" class="frm_input" size="20" maxlength="20">
                                <p class="valid">${valid_agency_register_num}</p>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">담당자이름</th>
                            <td>
                                <input type="text" value="${agencyDto.agency_manager_name}" name="agency_manager_name" class="frm_input frm_address" size="20">
                                <p class="valid">${valid_agency_manager_name}</p>
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
<script src="${pageContext.request.contextPath}/resources/js/admin/admin.js"></script>

<script>
    let msg = "${msg}";
    if(msg=="INS_ERR")  alert("기획사 등록에 실패했습니다. 재신청해주세요.");
</script>
</body>
</html>
