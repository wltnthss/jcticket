<%--
  Created by IntelliJ IDEA.
  User: Gram17
  Date: 2024-02-06
  Time: 오후 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/admin/admin.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
</head>
<body>

    <jsp:include page="/WEB-INF/views/admin/common/adminheader.jsp"/>

    <div class="admin-common-wrap">

        <jsp:include page="/WEB-INF/views/admin/common/adminproductnav.jsp"/>

        <div class="admin-common-content">
            <div class="admin-common-title">
                <h1>상품 관리</h1>
                <h2>공연 검색</h2>
            <hr>
            <form id="userSearch" action="/admin/product" method="get">
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
                                <select name="option">
                                    <option value="A">전체</option>
                                    <option value="I">공연아이디</option>
                                    <option value="N">공연명</option>
                                </select>
                                <input type="text" name="keyword" value="" class="user-form-input" size="30">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="btn-confirm">
                    <input type="submit" value="검색" class="btn-medium">
                    <input type="reset" value="초기화" class="btn-medium grey">
                </div>
            </form>
            <div class="local_ov mart30">
                총 공연수 : <b class="fc_red">${userListCnt}</b>개
            </div>
            <div class="local_frm01">
                <a href="#" class="btn_lsmall bx-white">엑셀저장</a>
            </div>
            <div class="tbl_header">
                <table>
                    <colgroup>
                        <col class="w80">
                        <col class="w400">
                        <col class="w200">
                        <col class="w180">
                        <col class="w80">
                    </colgroup>
                    <thead>
                    <tr>
                        <th scope="col">공연포스터</th>
                        <th scope="col">상품정보</th>
                        <th scope="col">일시</th>
                        <th scope="col">공연장</th>
                        <th scope="col">상태</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="p">
                        <tr class="list">
                            <td style="padding: 5px 0 !important;">
                                <img src="<c:url value='/upload/${p.img_name}'/>" alt="" width="100" height="120">
                            </td>
                            <td style="text-align: left">
                                <span style="font-weight: bold">${p.play_name}</span><br>
                                    ${p.play_cat} | ${p.play_run_time} | ${p.stage_address}
                            </td>
                            <td>${p.showing_period_date}</td>
                            <td>${p.stage_name}</td>
                            <td>${p.showing_status}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>

    <jsp:include page="/WEB-INF/views/admin/common/adminfooter.jsp"/>

    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
    <script src="/resources/js/admin/admin.js"></script>

<script>

</script>

</body>
</html>
