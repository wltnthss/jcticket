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

    <jsp:include page="/WEB-INF/views/admin/common/adminproductnav.jsp"/>

    <div class="admin-common-content">
        <div class="admin-common-title">
            <h1>상품 관리</h1>
            <h2>공연 등록</h2>
        </div>
        <form action="${pageContext.request.contextPath}/admin/playregister" method="post" enctype="multipart/form-data">
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
                            <input type="text" name="play_name" class="frm_input required" size="50" required>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">공연표지</th>
                        <td>
                            <input type="file" name="play_poster" class="frm_input required" size="30" >
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">공연정보</th>
                        <td>
                            <input type="file" name="play_info" class="frm_input required" size="30" >
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">공연슬라이드이미지</th>
                        <td>
                            <input type="file" name="play_slide" class="frm_input required" size="30" >
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">공연시간안내</th>
                        <td>
                            <input type="text" name="play_time_info" class="frm_input required" size="50" >
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">공연/전시 대분류</th>
                        <td>
                            <input type="text" name="play_major_cat" class="frm_input required" size="10" required>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">공연/전시 중분류</th>
                        <td>
                            <input type="text" name="play_middle_cat" class="frm_input required" size="10" >
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">공연/전시 소분류</th>
                        <td>
                            <input type="text" name="play_small_cat" class="frm_input required" size="10" >
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
            <div class="btn-confirm">
                <input type="submit" value="등록" class="btn-large">
            </div>
        </form>
        <form action="${pageContext.request.contextPath}/admin/showingregister" method="post">
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
                        <th scope="row">공연장아이디 선택</th>
                        <td>
                            <input type="text" name="stage_id" id="inputSearchStage" class="frm_input required" size="20" style="cursor: pointer" readonly required><span class="search-btn" onclick="openStagePopup()"></span>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">공연아이디 선택</th>
                        <td>
                            <input type="text" name="play_id" id="inputSearchPlay" class="frm_input required" size="20" style="cursor: pointer" readonly required><span class="search-btn" onclick="openPlayPopup()"></span>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">회차 시작 일시</th>
                        <td>
                            <input type="date" name="showing_start_at" class="frm_input required" size="20" required>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">회차 종료 일시</th>
                        <td>
                            <input type="date" name="showing_end_at" class="frm_input required" size="20" required>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">회차 정보</th>
                        <td>
                            <input type="text" name="showing_info" class="frm_input required" size="60" placeholder="ex) [1회] 13시 00분,[2회] 17시 00분" required>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">회차 일시</th>
                        <td>
                            <input type="text" name="showing_date" class="frm_input required" size="20" placeholder="ex) 2024-11-25" required>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">회차 요일</th>
                        <td>
                            <input type="text" name="showing_day" class="frm_input required" size="10" placeholder="ex) 월,화,수" required>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">회차 상태</th>
                        <td>
                            <select name="showing_status">
                                <option value="BS">상영전</option>
                                <option value="IS">상영중</option>
                                <option value="AS">상영종료</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">회차 좌석수</th>
                        <td>
                            <input type="text" id="showingSeat" name="showing_seat_cnt" class="frm_input required" size="5" readonly required>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">회차 좌석가격</th>
                        <td>
                            <input type="text" name="showing_seat_price" class="frm_input required" size="10" required>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="btn-confirm">
                <input type="submit" value="등록" class="btn-large">
            </div>
        </form>
        <%-- 공연장명 입력 팝업 창 --%>
        <div id="stagePopup" class="popup">
            <div class="popup-content">
                <p class="close-popup" ><span class="close-btn" onclick="closePopup()">X</span></p>
                <h2>공연장명 검색</h2>
                <div class="popup-content-detail">
                    <div class="popup-content-search">
                            <input type="text" name="keyword" value="" placeholder="공연장명을 입력하세요" class="frm_input required" id="inputStage" size="30">
                            <button class="search-btn" id="search-stage"></button>
                    </div>
                    <div class="tbl_header">
                        <table>
                            <colgroup>
                                <col class="w80">
                                <col class="w200">
                                <col class="w300">
                                <col class="w50">
                                <col class="w150">
                                <col class="w60">
                            </colgroup>
                            <thead>
                            <tr>
                                <th scope="col">공연장 아이디</th>
                                <th scope="col">공연장명</th>
                                <th scope="col">주소</th>
                                <th scope="col">좌석수</th>
                                <th scope="col">번호</th>
                                <th scope="col">담당자</th>
                            </tr>
                            </thead>
                            <tbody id="stageList">

                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="popup-btn-line">
                    <button class="popup-btn-medium" onclick="closePopup()">닫기</button>
                </div>
            </div>
        </div>
        <%-- 공연명 입력 팝업 창--%>
        <div id="playPopup" class="popup">
            <div class="popup-content">
                <p class="close-popup" ><span class="close-btn" onclick="closePopup()">X</span></p>
                <h2>공연명 검색</h2>
                <div class="popup-content-detail">
                    <div class="popup-content-search">
                        <input type="text" name="keyword" placeholder="공연명을 입력하세요" class="frm_input required" id="inputPlay" size="30">
                        <button class="search-btn" id="search-play"></button>
                    </div>
                    <div class="tbl_header">
                        <table>
                            <colgroup>
                                <col class="w80">
                                <col class="w300">
                                <col class="w60">
                                <col class="w60">
                            </colgroup>
                            <thead>
                            <tr>
                                <th scope="col">공연아이디</th>
                                <th scope="col">공연명</th>
                                <th scope="col">대분류</th>
                                <th scope="col">공연시간</th>
                            </tr>
                            </thead>
                            <tbody id="playList">

                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="popup-btn-line">
                    <button class="popup-btn-medium" onclick="closePopup()">닫기</button>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/views/admin/common/adminfooter.jsp"/>

<script src="https://code.jquery.com/jquery-3.5.0.js"></script>

<script>
    // 공연장 선택 검색 버튼 선택 이벤트
    $('#search-stage').on('click', function () {

        let keyword = $("#inputStage").val();

        let sendData = {
            keyword: keyword,
        };

        $.ajax({
            type: 'GET',
            url: sessionStorage.getItem("contextpath") + '/admin/stage',
            data: sendData,
            contentType: "application/json",
            success: function (res){
                // alert('res => ' + res)

                let listHtml = '';

                // controller에서 받은 공연장 조회 쿼리 결과 수만큼 공연장 결과 Html 결과에 출력
                for (let i = 0; i < res.length; i++) {
                    console.log(res[i]);
                    listHtml += '<tr class="list">'
                    listHtml += '<td style="cursor: pointer" class="stage-id-list">' + res[i].stage_id + '</td>';
                    listHtml += '<td>' + res[i].stage_name + '</td>';
                    listHtml += '<td>' + res[i].stage_address + '</td>';
                    listHtml += '<td class="stage-seat-list">' + res[i].stage_seat_cnt + '</td>';
                    listHtml += '<td>' + res[i].stage_tel + '</td>';
                    listHtml += '<td>' + res[i].stage_manager + '</td>';
                    listHtml += '</tr>'
                }

                $('#stageList').html(listHtml);

                // 공연장명 선택 시 팝업창이 닫히면서 공연장 아이디 input창에 데이터 삽입
                let stageLists = document.querySelectorAll(".stage-id-list");
                let stageSeatLists = document.querySelectorAll(".stage-seat-list");

                for (let i = 0; i < stageLists.length; i++) {
                    stageLists[i].addEventListener('click', function () {

                        // 공연장, 회차 좌석수 인풋창에 선택한 공연장의 DB정보 삽입
                        document.getElementById("inputSearchStage").value = stageLists[i].innerHTML;
                        document.getElementById("showingSeat").value = stageSeatLists[i].innerHTML;

                        // 팝업창 종료
                        closePopup();
                    });
                }
            },
            error: function (e) {
                console.error("Controller 오류", e);
            }
        })
    })

    // 공연명 선택 검색 버튼 선택 이벤트
    $('#search-play').on('click', function () {

        let keyword = $("#inputPlay").val();

        let sendData = {
            keyword: keyword,
        };

        $.ajax({
            type: 'GET',
            url: sessionStorage.getItem("contextpath") + '/admin/play',
            data: sendData,
            contentType: "application/json",
            success: function (res){
                // alert('res => ' + res)

                let listHtml = '';

                // controller에서 받은 공연 조회 쿼리 결과 수만큼 공연 결과 Html 결과에 출력
                for (let i = 0; i < res.length; i++) {
                    console.log(res[i]);
                    listHtml += '<tr class="list">'
                    listHtml += '<td style="cursor: pointer" class="play-id-list">' + res[i].play_id + '</td>';
                    listHtml += '<td>' + res[i].play_name + '</td>';
                    listHtml += '<td>' + res[i].play_major_cat + '</td>';
                    listHtml += '<td>' + res[i].play_run_time + '</td>';
                    listHtml += '</tr>'
                }

                $('#playList').html(listHtml);

                // 공연명 선택 시 팝업창이 닫히면서 공연명 input창에 데이터 삽입
                let playLists = document.querySelectorAll(".play-id-list");

                for (let i = 0; i < playLists.length; i++) {
                    playLists[i].addEventListener('click', function () {

                        // 1. 공연아이디 인풋창에 선택한 공연아이디의 DB정보 삽입
                        document.getElementById("inputSearchPlay").value = playLists[i].innerHTML;

                        // 팝업창 종료
                        closePopup();
                    });
                }
            },
            error: function (e) {
                console.error("Controller 오류", e);
            }
        })
    });
</script>

<script src="${pageContext.request.contextPath}/resources/js/admin/admin.js"></script>


</body>
</html>
