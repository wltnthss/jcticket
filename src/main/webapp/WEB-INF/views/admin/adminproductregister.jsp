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

    <jsp:include page="/WEB-INF/views/admin/common/adminproductnav.jsp"/>

    <div class="admin-common-content">
        <div class="admin-common-title">
            <h1>상품 관리</h1>
            <h2>공연 등록</h2>
        </div>
        <form action="/admin/productregister" method="post">
            <div class="tbl_frm01">
                <table>
                    <colgroup>
                        <col class="w180">
                        <col>
                    </colgroup>
                    <tbody>
                    <tr>
                        <th scope="row">공연명</th>
                        <td>
                            <input type="text" name="play_name" class="frm_input required" size="20" required>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">공연표지</th>
                        <td>
                            <input type="file" name="play_poster" class="frm_input required" size="20" required>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">공연정보</th>
                        <td>
                            <input type="file" name="play_info" class="frm_input required" size="20" required>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">공연/전시 대분류</th>
                        <td>
                            <input type="text" name="play_major_cat" class="frm_input required" size="20" required>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">공연/전시 중분류</th>
                        <td>
                            <input type="text" name="play_middle_cat" class="frm_input required" size="20" required>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">공연/전시 소분류</th>
                        <td>
                            <input type="text" name="play_small_cat" class="frm_input required" size="20" required>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">공연시간</th>
                        <td>
                            <input type="text" name="play_run_time" class="frm_input required" size="2" required> <span>  분</span>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="admin-common-title">
                <h2>좌석 등록</h2>
            </div>
            <div class="tbl_frm01">
                <table>
                    <colgroup>
                        <col class="w180">
                        <col>
                    </colgroup>
                    <tbody>
                    <tr>
                        <th scope="row">좌석가격</th>
                        <td>
                            <input type="text" name="play_name" class="frm_input required" size="5" required><span>  원</span>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">좌석번호</th>
                        <td>
                            <input type="text" name="play_poster" class="frm_input required" size="20" required>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="btn-confirm">
                <input type="submit" value="등록" id="btn_submit" class="btn-large">
            </div>
        </form>
        <form action="/admin/productregister" method="post">
            <div class="admin-common-title">
                <h2>회차 등록</h2>
            </div>
            <div class="tbl_frm01">
                <table>
                    <colgroup>
                        <col class="w180">
                        <col>
                    </colgroup>
                    <tbody>
                    <tr>
                        <th scope="row">공연장 선택</th>
                        <td>
                            <input type="text" name="play_poster" class="frm_input required" size="20" required>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">공연명 선택</th>
                        <td>
                            <input type="text" name="play_poster" class="frm_input required" size="20" required>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">회차 정보</th>
                        <td>
                            <input type="text" name="play_poster" class="frm_input required" size="20" required>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">회차 일시</th>
                        <td>
                            <input type="text" name="play_poster" class="frm_input required" size="20" required>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">회차 요일</th>
                        <td>
                            <input type="text" name="play_poster" class="frm_input required" size="20" required>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">회차 선택</th>
                        <td>
                            <input type="text" name="play_poster" class="frm_input required" size="20" required>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">회차 좌석수</th>
                        <td>
                            <input type="text" name="play_poster" class="frm_input required" size="20" required>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="btn-confirm">
                <input type="submit" value="등록" id="btn_submit" class="btn-large">
            </div>
        </form>
    </div>
</div>

<jsp:include page="/WEB-INF/views/admin/common/adminfooter.jsp"/>

<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="/resources/js/admin/admin.js"></script>

</body>
</html>
