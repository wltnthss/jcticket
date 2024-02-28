<%--
  Created by IntelliJ IDEA.
  User: 82109
  Date: 2024-02-13
  Time: 오전 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>관리자 페이지</title>
    <link rel="stylesheet" href="/resources/css/agency/agency.css">
</head>
<body class="agency-dashboard">
<div class="agency-dashboard-container">

    <jsp:include page="/WEB-INF/views/agency/agencyheader.jsp"/>

    <div class="agency-dashboard-body">
        <div class="agency-dashboard-main">
            <section class="agency-dashboard-side2">
                <h2>신규/ 판매 예정</h2>


            </section>

            <form id="userSearch" action="/admin/notice?keyword=${paging.keyword}" >
                <div class="agency-form" style="display: flex; justify-content: space-between; align-items: center;" >
                    <div class="local_ov mart30" >
                        총 게시물수 : <b class="fc_red">${AgencyListCnt}</b>개
                    </div>
                    <table>
                        <colgroup>
                            <col class="agency-w100">
                            <col>
                        </colgroup>
                        <tbody>
                        <tr>
                            <td>
                                <input type="text" class="agency-form-input" size="30" value="${paging.keyword}" name="keyword" placeholder="공연명을 입력해 주세요." id="input_keyword">
                            </td>
                            <td>
                                <input type="submit" value="검색" class="btn-medium">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </form>
            <hr>

            <div class="tbl_header">
                <table>
                    <colgroup>
                        <col class="w1" style="width:10%">
                        <col class="w2" style="width:50%">
                        <col class="w3" style="width:15%">
                        <col class="w4" style="width:15%">
                        <col class="w5" style="width:10%">
                    </colgroup>
                    <thead>
                    <tr>
                        <th scope="col">번호</th>
                        <th scope="col">상품정보</th>
                        <th scope="col">일시</th>
                        <th scope="col">공연장</th>
                        <th scope="col">상품관리/수정</th>
                    </tr>
                    </thead>

                    <c:forEach items="${list}" var="EnrollDto">
                        <tr class="sale-tr">
                            <td class="sale-td">${enrollDto.notice_seq}</td>
                            <td class="sale-td title">
                                    ${enrollDto.play_poster}, ${enrollDto.play_name}, ${enrollDto.play_major_cat}, ${enrollDto.play_run_time}</td>
                            <td class="sale-td content">
                                    ${enrollDto.showing_start_at}~${enrollDto.showing_end_at}</td>
                            <td class="sale-td">${enrollDto.stage_id}</td>
                            <td class="sale-td">
                                <form action="/agencyproductmanagement" method="GET">
                                    <input type="hidden" name="notice_seq" value="${enrollDto.notice_seq}">
                                    <button type="submit">Agency Product Management</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>

                </table>
            </div>

        </div>
    </div>

</div>
</body>
</html>
