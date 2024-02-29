<%--
  Created by IntelliJ IDEA.
  User: 82109
  Date: 2024-02-09
  Time: 오후 6:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>신규등록신청</title>
    <link rel="stylesheet" href="/resources/css/agency/agency.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/views/agency/agencyheader.jsp"/>

<%--나는 nav 없어서 허전해 --%>
<div class="agency-common-wrap">
    <div class="agency-common-content">
        <div class="agency-common-title">
            <h1>신규등록</h1>
            <h2>기본정보입력</h2>
            <hr>
            <form id="playEnroll" action="/agency/enroll" method="post"  enctype="multipart/form-data">
                <div class="enroll-box">
                    <table>
                        <colgroup>
                            <col class="enroll-w100">
                            <col>
                        </colgroup>
                        <tbody>
<%--                        <tr>--%>
<%--                            <th scope="row">공연예술통합전산망<br> 정보제공 동의</th>--%>
<%--                            <td>--%>
<%--                                해당 상품의 판매 데이터를 공연예술통합전산망에 제공하여 공연시장 소비현황 동계자료로 활용하는 것에 기획사의 의견을 대표하여--%>
<%--                                동의하십니까? 동의하지 않으실 경우 각종 정부 지원 사업 참여에 제한이 있을 수 있습니다.<br>--%>
<%--                                &nbsp;> 제공 기간: 동의 시점부터 해당 상품의 공연 종료 시 까지 ( 일 단위로 데이터 제공)<br>--%>
<%--                                &nbsp;> 제공 항목 상세 보기 > 활용 방안 <br>--%>
<%--                                &nbsp;&nbsp; 단, 초대권 (0원 판매)데이터가 포함되며, 유료 판매없이 모든 좌석에 대한 발권으로만 진행한 경우는 제공되지 않음.<br>--%>
<%--                                <label><input type="radio" name="agree" value="yes"> ㅇ</label>--%>
<%--                                <label><input type="radio" name="agree" value="no"> ㄴ</label>--%>
<%--                            </td>--%>
<%--                        </tr>--%>

                        <%--   play_id공연아이디>관리자가 발급?    agency_id기획사>로그인 세션     created_at, created_id, updated_at, updated_id 시간은나우 아이디는 세션    --%>

                        <%--
                          showing_seq,  회차일련번호 헷갈려.   ( showing_date,일시   showing_day,요일 )   showing_status,상태는bs로 고정      showing_seat_cnt,좌석수가뭘까?


                          이건 입력된 공연장 이름 으로 디비에서 정보 가져오도록 수정.
                            stage_id,공연장아이디   stage_seat_cnt,공연장 좌석수    stage_manager,공연장 담당자    stage_type,공연장유형   stage_tel공연장전번 --%>



                        <tr>
                            <th scope="row">상품명</th>
                            <td>
                                <input type="text" name="play_name" placeholder="공연명을 입력해주세요." value="" id="play_name" class="enroll-box-input w80 " maxlength="100">
                                &nbsp;&nbsp;&nbsp;&nbsp;부제목(선택입력)
                                <input type="text" name="play_sub_name" placeholder="부제목을을 입력해주세요." value="" id="play_sub_name" class="enroll-box-input w80 " maxlength="100">
                                <%--                                    공연명 부제목은 입력 시 제목 뒤에 따라붙도록? --%>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">1차분류</th>
                            <td>
                                <select name="play_major_cat">
                                    <option selected disabled>선택해주세요</option>
                                    <option value="con">콘서트</option>
                                    <option value="the">연극</option>
                                    <option value="mus">뮤지컬</option>
                                    <option value="cla">클래식</option>
                                </select>
                            </td>


                        </tr>
                        <tr>
                            <th scope="row">2차분류</th>
                            <td>
                                <select name="play_middle_cat">
                                    <option selected disabled>선택해주세요</option>
                                    <option value="con">콘서트</option>
                                    <option value="the">연극</option>
                                    <option value="mus">뮤지컬</option>
                                    <option value="cla">클래식</option>
                                </select>
                            </td>


                        </tr>

<%--                       dto에 stage_id로 넣어서 우선 아이디를 받았지만 네임을 적는게 자연스러운데, 보조키를 받아야하나 네임을 받아야하나. 고민--%>

                        <tr>
                            <th scope="row">공연장</th>
                            <td>
                                <input type="text" name="stage_id" placeholder="공연장명을 작성해주세요" id="stage_name" class="enroll-box-input w80 " size="30"><br><br>
<%--                                <input type="text" name="stage_address" placeholder="공연장 주소를 작성해주세요" id="stage_address" class="enroll-box-input w80 " size="90"><br>--%>
                                <!-- 여기에 주소추가할지 말지 ~~ 나중에 시간 남으면 넣자구~ -->
                                <br><em>성남공연장, 예술의 전당은 검인과 대관료 납부를 필히 확인해 주세요.</em>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">공연일시</th>
                            <td>
                                시작일&emsp;<input type="date"
                                                id="fr_date"
                                                name="showing_start_at"
                                                max="2044-01-01"
                                                min="2023-01-01"
                                                value="2024-01-31"> &emsp;&emsp;
                                종료일 &emsp;<input type="date"
                                                 id="to_date"
                                                 name="showing_end_at"
                                                 max="2044-01-01"
                                                 min="2023-01-01"
                                                 value="2024-01-31">&emsp;
                                공연일 기준으로 작성해 주세요.

                            </td>
                        </tr>
                        <tr>
                            <th scope="row">공연시간</th>
                            <td>
                                <!-- 입력 숫자만 되도록 -->
                                러닝타입(인터미션 포함)
                                <input type="text" name="play_run_time" onkeydown="return checkNumber(event)" placeholder="120" value="" id="play_run_time" class="enroll-box-input w80 " size="3">분&emsp;&emsp;
<%--                                인터미션--%>
<%--                                <input type="text" name="play_run_time2" onkeydown="return checkNumber(event)" placeholder="20" value="" id="play_run_time2" class="enroll-box-input w80 " size="3">분<br>--%>

                                <br>
<%--                                <textarea rows="2" name="showing_info"--%>
<%--                                              placeholder="-공연 : 화목금 20시 / 수 15시 20시 / 토일 14시 19시 / 공휴일 18시--%>
<%--- 행사 및 전시 : 관람시간 : 오전9시 30분 ~ 오후 6시30분 (입장마감 오후 5시30분) 매주 월요일은 휴관일입니다.--%>
<%---스포트 경기 : 오후 5시"></textarea>--%>
<%--                                <script>--%>
                                    function checkNumber(event) {
                                        // 숫자 키, 백스페이스, 화살표 등을 허용
                                        if(event.key === 'Backspace' || event.key === 'ArrowLeft' || event.key === 'ArrowRight' || (event.key >= '0' && event.key <= '9')) {
                                            return true;
                                        }
                                        return false;
                                    }
                                </script>


                            </td>
                        </tr>
<%--                        <tr>--%>
<%--                            <th scope="row">구매 매수 제한</th>--%>
<%--                            <td>--%>
<%--                                <input name="radio-buttons" value="1" type="radio" class="enroll-box-input w80 ">회원별</input>--%>
<%--                                <input type="text" name="ticketinglimit" onkeydown="return checkNumber(event)" value="" id="ticketinglimit" class="enroll-box-input w80 " size="5">매 (--%>
<%--                                <input type="checkbox" name="admin_seal_del" value="1" id="admin_seal_del" class="marl5">--%>
<%--                                <label for="admin_seal_del">회차당</label>--%>
<%--                                )&emsp;&emsp;&emsp;--%>

<%--                                <input name="radio-buttons" value="1" type="radio" class="recommendation">주문건별</input>--%>
<%--                                <input type="text" name="ticketinglimit2" onkeydown="return checkNumber(event)" value="" id="ticketinglimit2" class="enroll-box-input w80 " size="5">매--%>

<%--                                <br><em>회원별 : 아이디당 구매 매수 제한<br>--%>
<%--                                주문건별 : 1회 주문시 구매 매수 제한--%>
<%--                            </em>--%>
<%--                            </td>--%>
<%--                        </tr>--%>


<%--                        <tr>--%>
<%--                            <th scope="row">좌석배치도</th>--%>
<%--                            <td>--%>
<%--                                &lt;%&ndash;                                    이거 뭐,, 필요한가? 테이블에 추가 할지 말지.. 어떡하지. &ndash;%&gt;--%>
<%--                                <input type="file" name="seatingchart" id="seatingchart"><br>--%>

<%--                                <br><em>위의 [좌석판매형태]항목에서 '지정석'을 선택했다면 필수로 배치도가 그려진 파일을 첨부하셔야 합니다.--%>
<%--                                <br>(jpg. gif, wmv, zip, flv, doc, docx, txt, pdf, ai, xls, xlsx, ppt, pptx, mp3 / 10M이하)--%>
<%--                            </em>--%>
<%--                            </td>--%>
<%--                        </tr>--%>


                        </tbody>
                    </table>
                </div>

                <h2>공연상세정보</h2>
                <div class="enroll-box">
                    <table>
                        <colgroup>
                            <col class="w180">
                            <col>
                        </colgroup>
                        <tbody>
                        <tr>
                            <th scope="row">공지사항 <br> <em>(웹 '알립니다'에 <br>노출되는 부분입니다</em></th>
                            <td>

                                <textarea rows="4"  placeholder=""></textarea>

                            </td>
                        </tr>
                        <tr>
                            <th scope="row">작품설명<br> <em>(포스터, 상세정보)</em></th>
                            <td>
                                <%--                                description text..?필요 할려나?--%>
                                <input type="file" name="play_poster_file" id="play_poster_file">
                                    <input type="file" name="play_info_file" id="play_info_file">
<%--                                    <input type="file" name="play_poster" id="play_poster3">--%>
                                <br><br><em>파일이 업로드 되기까지 일정시간이 소요됩니다. 업로드 후 해당 파일 첨부되신 부분을 꼭 체크해주시기 바랍니다.<br>
                                공연 상세 안내 페이지에 등록될 포스터, 상세정보 파일을 첨부해 주시기 바랍니다.<br>
                                (jpg, gif, zip /1회 최대 10ㅡ 이하 등록 가능)
                            </em>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">캐스팅 일정</th>
                            <td>
                                <%--                                우선 회차라고 가정하고 [1회] 17시 00분 와 같은 VARCHAR 받아 오기--%>
                                캐스팅유형 :<input type="text" name="showing_info" value="" id="showing_info" class="enroll-box-input w80 " size="60">
                                <br><br><em>캐스팅 캘린더는 예매창/ 확인페이지에서 회차별 출연진 확인 및 기간/배우 검색이 가능한 서비스입니다.<br>
                                뮤지컬/연극 장르 상품은 캐스팅캘린더 서비스를 사용해주시기 바랍니다.
                            </em>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>

                <h2>기획사 정보</h2>
                <div class="enroll-box">
                    <table>
                        <colgroup>
                            <col class="enroll-w100">
                            <col>
                        </colgroup>
                        <tbody>
                        <tr>
                            <th scope="row">기획사명</th>
                            <td>
                                <input type="text" name="agency_name" placeholder="기획사명을 입력해주세요." id="agency_name" class="enroll-box-input w80 " maxlength="100">
                                <br><br>
                            </td>
                        </tr>

                        <tr>
                            <th scope="row">담당자명</th>
                            <td>
                                <input type="text" name="agency_manager_name" placeholder="담당자명을 입력해주세요." id="agency_manager_name" class="enroll-box-input w80 " maxlength="50">
                                <br><br>
                            </td>
                        </tr>

                        <tr>
                            <th scope="row">이메일</th>
                            <td>
                                <input type="email" name="agency_email" placeholder="이메일을 입력해주세요." id="agency_email" class="enroll-box-input w80 ">
                                <br><br>
                            </td>
                        </tr>

                        <tr>
                            <th scope="row">전화번호</th>
                            <td>
                                <input type="tel" name="agency_tel" placeholder="전화번호를 입력해주세요." id="agency_tel" class="enroll-box-input w80 ">
                            </td>
                        </tr>

<%--                        <tr>--%>
<%--                            <th scope="row">현금영수증</th>--%>
<%--                            <td>--%>
<%--                                <input name="cash_receipits" value="1" type="radio" class="enroll-box-input w80 ">신청</input>--%>
<%--                                <select class="right dropdown" id="dropdown" name="dropdown">--%>
<%--                                    <option selected disabled>현금영수증사용 과세</option>--%>
<%--                                    <option value="first">뭐가</option>--%>
<%--                                    <option value="never">있더라</option>--%>
<%--                                    <option value="never">나중에</option>--%>
<%--                                    <option value="never">찾자~!</option>--%>
<%--                                </select>   &emsp;&emsp;&emsp;--%>
<%--                                <input name="radio-buttons" value="1" type="radio" class="enroll-box-input w80 ">신청안함</input>--%>
<%--                            </td>--%>
<%--                        </tr>--%>

                        </tbody>
                    </table>
                </div>

                <h2>담당자 진행 현황</h2>


                <div class="btn_confirm">
                    <input type="submit" value="신청" class="btn_large" accesskey="s">
                </div>
            </form>
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