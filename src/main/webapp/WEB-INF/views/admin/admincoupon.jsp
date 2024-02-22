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

        <jsp:include page="/WEB-INF/views/admin/common/admincouponnav.jsp"/>


        <div class="admin-common-content">
            <div class="admin-common-title">
                <h1>쿠폰 관리</h1>
                <h2>쿠폰 검색</h2>
                <hr>
                <form id="userSearch" action="/admin/coupon">
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
                                        <option value="I">쿠폰아이디</option>
                                        <option value="N">쿠폰명</option>
                                    </select>
                                    <input type="text" name="keyword" id="input_keyword" value="" class="user-form-input" size="30">
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">사용기간</th>
                                <td>
                                    <input name="start_at" id="coupon_useable_start_at" type="date"  class="frm_input required" > ~ <input name="end_at" id="coupon_useable_end_at" type="date"  class="frm_input required" >
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="btn-confirm">
                        <input type="submit" value="검색" class="btn-medium">
                        <input type="button" value="초기화" class="btn-medium grey" onclick="clearInput()">
                    </div>
                </form>
                <div class="local_ov mart30">
                    총 쿠폰수 : <b class="fc_red">${couponListCnt}</b>개
                </div>
                <div class="local_frm01">
                    <a href="#" class="btn_lsmall bx-white">엑셀저장</a>
                </div>
                <div class="tbl_header">
                    <table>
                        <colgroup>
                            <col class="w80">
                            <col class="w200">
                            <col class="w200">
                            <col class="w200">
                            <col class="w80">
                            <col class="w200">
                            <col class="w80">
                            <col class="w200">
                        </colgroup>
                        <thead>
                        <tr>
                            <th scope="col">쿠폰아이디</th>
                            <th scope="col">쿠폰명</th>
                            <th scope="col">사용가능 시작 일자</th>
                            <th scope="col">사용가능 종료 일자</th>
                            <th scope="col">할인 금액</th>
                            <th scope="col">사용 조건</th>
                            <th scope="col">상태</th>
                            <th scope="col">등록일</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${list}" var="CouponDto">
                            <tr class="list">
                                <td>${CouponDto.coupon_id}</td>
                                <td>${CouponDto.coupon_name}</td>
                                <td>${CouponDto.coupon_useable_start_at}</td>
                                <td>${CouponDto.coupon_useable_end_at}</td>
                                <td>${CouponDto.coupon_discount_amount}</td>
                                <td>${CouponDto.coupon_use_condition}</td>
                                <td>${CouponDto.coupon_status}</td>
                                <td>${CouponDto.coupon_reg_at}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="notice-paging">
                    <c:if test="${paging.showPrev}">
                        <%-- 1페이지가 아닌 경우는 [이전] 클릭하면 현재 페이지보다 1작은 페이지 요청 --%>
                        <a class="notice-paging-pageitems" href="/admin/coupon?page=${paging.page-1}&option=${paging.option}&keyword=${paging.keyword}&start_at=${pagin.start_at}&end_at=${paging.end_at}"> < </a>
                    </c:if>

                    <%-- for(int i=startPage; i<=endPage; i++) --%>
                    <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
                        <c:if test="${i eq paging.page}">
                            <%-- 요청한 페이지에 있는 경우 현재 페이지 번호는 강조  --%>
                            <a class="notice-paging-pageitems ${i eq paging.page? "active" : ""}" >${i}</a>
                        </c:if>
                        <c:if test="${i ne paging.page}">
                            <%-- 요청한 페이지가 아닌 다른 페이지번호 클릭시 이동  --%>
                            <a class="notice-paging-pageitems" href="/admin/coupon?page=${i}&option=${paging.option}&keyword=${paging.keyword}&start_at=${pagin.start_at}&end_at=${paging.end_at}">${i}</a>
                        </c:if>
                    </c:forEach>

                    <c:if test="${paging.showNext}">
                        <%-- page가 maxPage보다 작으면 클릭시 현재 page에서 1증가된 페이지로 이동 --%>
                        <a class="notice-paging-pageitems" href="/admin/coupon?page=${paging.page+1}&option=${paging.option}&keyword=${paging.keyword}&start_at=${pagin.start_at}&end_at=${paging.end_at}"> > </a>
                    </c:if>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/admin/common/adminfooter.jsp"/>

    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
    <script src="/resources/js/admin/admin.js"></script>

<script>
    function clearInput() {
        document.getElementById("input_keyword").value = "" // input 요소의 값 초기화
    }
</script>
</body>
</html>
