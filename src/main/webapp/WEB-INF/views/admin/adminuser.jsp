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
                <h1>회원 정보관리</h1>
                <h2>기본검색</h2>
                <hr>
                <form id="userSearch" action="/admin/user" method="get">
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
                                            <option value="I">아이디</option>
                                            <option value="N">회원명</option>
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
                    총 회원수 : <b class="fc_red">${userListCnt}</b>명
                </div>
                <div class="local_frm01">
                    <a href="#" class="btn_lsmall bx-white">엑셀저장</a>
                </div>
                <div class="tbl_header">
                    <table>
                        <colgroup>
                            <col class="w80">
                            <col class="w80">
                            <col class="w130">
                            <col class="w150">
                            <col class="w400">
                            <col class="w80">
                            <col class="w90">
                            <col class="w130">
                            <col class="w200">
                            <col class="w200">
                        </colgroup>
                        <thead>
                        <tr>
                            <th scope="col">이름</th>
                            <th scope="col">아이디</th>
                            <th scope="col">핸드폰</th>
                            <th scope="col">이메일</th>
                            <th scope="col">주소</th>
                            <th scope="col">성별</th>
                            <th scope="col">접속횟수</th>
                            <th scope="col">생년월일</th>
                            <th scope="col">가입일시</th>
                            <th scope="col">탈퇴일시</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${list}" var="UserDto">
                            <tr class="list">
                                <td>${UserDto.user_name}</td>
                                <td>${UserDto.user_id}</td>
                                <td>${UserDto.user_tel}</td>
                                <td>${UserDto.user_email}</td>
                                <td>${UserDto.user_address}</td>
                                <td>${UserDto.user_gender}</td>
                                <td>${UserDto.user_visit_cnt}</td>
                                <td>${UserDto.user_birth}</td>
                                <td>${UserDto.user_create_at}</td>
                                <td>${UserDto.user_retire_at}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="notice-paging">
                    <c:if test="${paging.showPrev}">
                        <%-- 1페이지가 아닌 경우는 [이전] 클릭하면 현재 페이지보다 1작은 페이지 요청 --%>
                        <a class="notice-paging-pageitems" href="/admin/user?page=${paging.page-1}&option=${paging.option}&keyword=${paging.keyword}"> < </a>
                    </c:if>

                    <%-- for(int i=startPage; i<=endPage; i++) --%>
                    <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
                        <c:if test="${i eq paging.page}">
                            <%-- 요청한 페이지에 있는 경우 현재 페이지 번호는 강조  --%>
                            <a class="notice-paging-pageitems ${i eq paging.page? "active" : ""}" >${i}</a>
                        </c:if>
                        <c:if test="${i ne paging.page}">
                            <%-- 요청한 페이지가 아닌 다른 페이지번호 클릭시 이동  --%>
                            <a class="notice-paging-pageitems" href="/admin/user?page=${i}&option=${paging.option}&keyword=${paging.keyword}">${i}</a>
                        </c:if>
                    </c:forEach>

                    <c:if test="${paging.showNext}">
                        <%-- page가 maxPage보다 작으면 클릭시 현재 page에서 1증가된 페이지로 이동 --%>
                        <a class="notice-paging-pageitems" href="/admin/user?page=${paging.page+1}&option=${paging.option}&keyword=${paging.keyword}"> > </a>
                    </c:if>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/admin/common/adminfooter.jsp"/>

    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
    <script src="/resources/js/admin/admin.js"></script>
</body>
</html>
