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
                <h1>회원 정보관리</h1>
                <h2>기본검색</h2>
                <hr>
                <form id="userSearch">
                    <div class="user-form">
                        <table>
                            <colgroup>
                                <col class="user-w100">
                                <col>
                            </colgroup>
                            <tbody>
                                <tr>
                                    <th scope="row">검색어</th>
                                    <td>
                                        <select>
                                            <option value="id" selected="selected">아이디</option>
                                            <option value="name">회원명</option>
                                            <option value="cellphone">핸드폰</option>
                                        </select>
                                        <input type="text" name="stx" value="" class="user-form-input" size="30">
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">기간검색</th>
                                    <td>
                                        <select name="spt">
                                            <option value="reg_time" selected="selected">가입날짜</option>
                                            <input type="text" name="fr_date" value="" id="fr_date" class="user-form-input w80 hasDatepicker" maxlength="10"
                                                   <span> ~ </span>
                                            <input type="text" name="to_date" value="" id="to_date" class="user-form-input w80 hasDatepicker" maxlength="10">
                                            <span class="btn_group">
                                                <input type="button" class="btn_small white" value="오늘">
                                                <input type="button" class="btn_small white" value="어제">
                                                <input type="button" class="btn_small white" value="일주일">
                                                <input type="button" class="btn_small white" value="지난달">
                                                <input type="button" class="btn_small white" value="1개월">
                                            </span>
                                        </select>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/admin/adminfooter.jsp"/>

    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
    <script src="/resources/js/admin/admin.js"></script>
</body>
</html>
