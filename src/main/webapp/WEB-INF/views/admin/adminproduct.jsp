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
                    <input type="reset" value="초기화" class="btn-medium grey"  onclick="clearInput()">
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
                                <span style="font-weight: bold; text-decoration-line: underline"><a style="font-size: 14px !important;" href="/admin/productmodify/${p.play_id}/${p.showing_seq}?page=${paging.page}">${p.play_name}</a></span><br>
<%--                                    <span style="font-weight: bold; font-size: 14px">${p.play_name}</span><br>--%>
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
            <div class="notice-paging">
                <c:if test="${paging.showPrev}">
                    <%-- 1페이지가 아닌 경우는 [이전] 클릭하면 현재 페이지보다 1작은 페이지 요청 --%>
                    <a class="notice-paging-pageitems" href="/admin/product?page=${paging.page-1}&option=${paging.option}&keyword=${paging.keyword}&start_at=${paging.start_at}&end_at=${paging.end_at}&status=${paging.status}&category=${paging.category}"> < </a>
                </c:if>

                <%-- for(int i=startPage; i<=endPage; i++) --%>
                <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
                    <c:if test="${i eq paging.page}">
                        <%-- 요청한 페이지에 있는 경우 현재 페이지 번호는 강조  --%>
                        <a class="notice-paging-pageitems ${i eq paging.page? "active" : ""}" >${i}</a>
                    </c:if>
                    <c:if test="${i ne paging.page}">
                        <%-- 요청한 페이지가 아닌 다른 페이지번호 클릭시 이동  --%>
                        <a class="notice-paging-pageitems" href="/admin/product?page=${i}&option=${paging.option}&keyword=${paging.keyword}&start_at=${paging.start_at}&end_at=${paging.end_at}&status=${paging.status}&category=${paging.category}">${i}</a>
                    </c:if>
                </c:forEach>

                <c:if test="${paging.showNext}">
                    <%-- page가 maxPage보다 작으면 클릭시 현재 page에서 1증가된 페이지로 이동 --%>
                    <a class="notice-paging-pageitems" href="/admin/product?page=${paging.page+1}&option=${paging.option}&keyword=${paging.keyword}&start_at=${paging.start_at}&end_at=${paging.end_at}&status=${paging.status}&category=${paging.category}"> > </a>
                </c:if>
            </div>
            <div class="btn-confirm">
                <input type="button" value="삭제" id="product-delete-btn" class="btn-large" style="background: red">
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

    // 관리자 상품 삭제 버튼 클릭 이벤트
    $('#product-delete-btn').on('click', function(){

        // 체크박스 리스트 전체
        let checkList = $("input[name=selectedItems]:checked");
        let valueArr = [];

        // checkList가 check 된 상태이면 배열에 값 저장
        checkList.each(function () {
            valueArr.push($(this).val());
        });

        console.log('valueArr => ' + valueArr);

        if(valueArr.length === 0){
            alert("삭제할 항목을 선택해주세요");
            return false;
        }else{
            if(confirm("정말 삭제하시겠습니까?")){

                $.ajax({
                    type: 'DELETE',
                    url: '/admin/productdelete',
                    data: JSON.stringify(valueArr),
                    contentType: "application/json",
                    success: function (res){
                        console.log('res => ' + res)
                        if(res > 0){
                            alert('삭제되었습니다.');
                            location.href= "/admin/product";
                        }else{
                            alert('삭제 실패');
                            location.href= "/admin/product";
                        }
                    },
                    error: function (e) {
                        console.error("삭제 실패", e);
                    }
                });
            }
        }
    });
</script>

</body>
</html>
