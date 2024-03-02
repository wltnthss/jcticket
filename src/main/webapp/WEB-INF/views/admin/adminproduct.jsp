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
                                    <option value="P">공연명</option>
                                    <option value="S">공연장</option>
                                </select>
                                <input type="text" name="keyword" class="user-form-input" size="30">
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">상태</th>
                            <td>
                                <select name="status">
                                    <option value="A">전체</option>
                                    <option value="BS">상영전</option>
                                    <option value="IS">상영중</option>
                                    <option value="AS">상영종료</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">카테고리</th>
                            <td>
                                <select name="category">
                                    <option value="A">전체</option>
                                    <option value="콘서트">콘서트</option>
                                    <option value="뮤지컬">뮤지컬</option>
                                    <option value="연극">연극</option>
                                    <option value="클래식">클래식</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">공연기간</th>
                            <td>
                                <input name="start_at" id="showing_start_at" type="date"  class="frm_input required" > ~ <input name="end_at" id="showing_end_at" type="date"  class="frm_input required" >
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
               총 회차수 : <b class="fc_red">${showingListCnt}</b>개
            </div>
            <div class="local_frm01">
                <a href="#" class="btn_lsmall bx-white">엑셀저장</a>
            </div>
            <div class="tbl_header">
                <table>
                    <colgroup>
                        <col class="w50">
                        <col class="w80">
                        <col class="w500">
                        <col class="w150">
                        <col class="w180">
                        <col class="w80">
                    </colgroup>
                    <thead>
                    <tr>
                        <th scope="col"><input type="checkbox" id="selectedItemsAll"> </th>
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
                            <td><input type="checkbox" name="selectedItems" value="${p.play_id}"></td>
                            <td style="padding: 5px 0 !important;">
                                <img src="<c:url value='/upload/${p.img_name}'/>" alt="" width="100" height="120">
                            </td>
                            <td style="text-align: left">
                                <span style="font-weight: bold; font-size: 14px">${p.play_name}</span><br>
                                    ${p.play_cat} | ${p.play_run_time} 분 | ${p.showing_info} | ${p.showing_date} | ${p.stage_address}
                            </td>
                            <td>${p.showing_period_date}</td>
                            <td>${p.stage_name}</td>
                            <td>${p.showing_status}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
<%--            페이징 기능--%>
            <div class="btn-confirm">
                <input type="button" value="삭제" id="user-delete-btn" class="btn-large" style="background: red">
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
