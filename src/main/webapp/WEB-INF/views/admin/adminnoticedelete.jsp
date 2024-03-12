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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/admin.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
</head>
<body>

<jsp:include page="/WEB-INF/views/admin/common/adminheader.jsp"/>

<div class="admin-common-wrap">

    <jsp:include page="/WEB-INF/views/admin/common/adminnoticenav.jsp"/>

    <div class="admin-common-content">
        <div class="admin-common-title">
            <h1>공지사항 삭제하기</h1>
            <h2>기본검색</h2>
            <hr>
            <form id="userSearch" action="${pageContext.request.contextPath}/admin/noticedelete?keyword=${paging.keyword}">
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
                                <input type="text" class="user-form-input" size="30" value="${paging.keyword}" name="keyword" placeholder="궁금하신 내용을 입력해주세요" id="input_keyword" >
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
                총 게시물수 : <b class="fc_red">${noticeListCnt}</b>개
            </div>
            <div class="tbl_header">
                <table>
                    <colgroup>
                        <col class="w80">
                        <col class="w80">
                        <col class="w100">
                        <col class="w700">
                        <col class="w200">
                        <col class="w80">
                        <col class="w80">
                        <col class="w100">
                    </colgroup>
                    <thead>
                    <tr>
                        <th scope="col"><input type="checkbox" id="selectedItemsAll"> </th>
                        <th scope="col">번호</th>
                        <th scope="col">제목</th>
                        <th scope="col">내용</th>
                        <th scope="col">작성일</th>
                        <th scope="col">조회수</th>
                        <th scope="col">사용여부</th>
                        <th scope="col">관리자 아이디</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="NoticeDto">
                        <tr class="list">
                            <td><input type="checkbox" name="selectedItems" value="${NoticeDto.notice_seq}"></td>
                            <td>${NoticeDto.notice_seq}</td>
                            <td>${NoticeDto.notice_title}</td>
                            <td>${NoticeDto.notice_content}</td>
                            <td>${NoticeDto.notice_reg_at}</td>
                            <td>${NoticeDto.notice_view_cnt}</td>
                            <td>${NoticeDto.notice_use_yn}</td>
                            <td>${NoticeDto.admin_id}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="notice-paging">
                <c:if test="${paging.showPrev}">
                    <%-- 1페이지가 아닌 경우는 < 클릭하면 현재 페이지보다 1작은 페이지 요청 --%>
                    <a class="notice-paging-pageitems" href="${pageContext.request.contextPath}/admin/noticedelete?page=${paging.page-1}&keyword=${paging.keyword}"> < </a>
                </c:if>

                <%-- for(int i=startPage; i<=endPage; i++) --%>
                <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
                    <c:if test="${i eq paging.page}">
                        <%-- 요청한 페이지에 있는 경우 현재 페이지 번호는 강조  --%>
                        <a class="notice-paging-pageitems ${i eq paging.page? "active" : ""}" >${i}</a>
                    </c:if>
                    <c:if test="${i ne paging.page}">
                        <%-- 요청한 페이지가 아닌 다른 페이지번호 클릭시 이동  --%>
                        <a class="notice-paging-pageitems" href="${pageContext.request.contextPath}/admin/noticedelete?page=${i}&keyword=${paging.keyword}">${i}</a>
                    </c:if>
                </c:forEach>

                <c:if test="${paging.showNext}">
                    <%-- page가 maxPage보다 작으면 클릭시 현재 page에서 1증가된 페이지로 이동 --%>
                    <a class="notice-paging-pageitems" href="${pageContext.request.contextPath}/admin/noticedelete?page=${paging.page+1}&keyword=${paging.keyword}"> > </a>
                </c:if>
                <div class="btn-confirm">
                    <input type="button" value="삭제" id="notice-delete-btn" class="btn-large" style="background: red">
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/views/admin/common/adminfooter.jsp"/>

<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/admin/admin.js"></script>
<script>
    let contextPath = "${pageContext.request.contextPath}";

    sessionStorage.setItem("contextpath", contextPath)

    function clearInput() {
        document.getElementById("input_keyword").value = "" // input 요소의 값 초기화
    }

    // 관리자 공지사항 삭제 버튼 클릭 이벤트
    $('#notice-delete-btn').on('click', function(){

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
                    url: contextPath + '/admin/noticedelete',
                    data: JSON.stringify(valueArr),
                    contentType: "application/json",
                    success: function (res){
                        console.log('res => ' + res)
                        if(res > 0){
                            alert('삭제되었습니다.');
                            location.href = contextPath + "/admin/noticedelete";
                        }else{
                            alert('삭제 실패');
                            location.href = contextPath + "/admin/noticedelete";
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
