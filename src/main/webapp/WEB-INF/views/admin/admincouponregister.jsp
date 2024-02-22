<%--
  Created by IntelliJ IDEA.
  User: Gram17
  Date: 2024-02-13
  Time: 오후 1:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <jsp:include page="/WEB-INF/views/admin/common/admincouponnav.jsp"/>

    <div class="admin-common-content">
        <div class="admin-common-title">
            <h1>쿠폰 등록하기</h1>
            <h2>쿠폰정보 입력 <span style="font-size: 12px !important; color: grey">(쿠폰은 중복 사용이 불가능합니다.)</span></h2>
        </div>
        <form action="/admin/couponregister" method="post">
            <div class="tbl_frm01">
                <table>
                    <colgroup>
                        <col class="w180">
                        <col>
                    </colgroup>
                    <tbody>
                    <tr>
                        <th scope="row">쿠폰명</th>
                        <td>
                            <input type="text" name="coupon_name" class="frm_input required" size="20" style="background-position: right top; background-repeat: no-repeat;" required>
                            <p class="valid">${valid_coupon_name}</p>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">설명</th>
                        <td>
                            <input type="text" name="coupon_description" class="frm_input required" size="80" style="background-position: right top; background-repeat: no-repeat;" required>
                            <p class="valid">${valid_coupon_description}</p>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">사용 여부</th>
                        <td>
                            <input type="radio" value="Y" checked name="coupon_use_yn"> 사용 <input type="radio" value="N" name="coupon_use_yn"> 중지
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">사용기간</th>
                        <td>
                            <input name="coupon_useable_start_at" required id="coupon_useable_start_at" type="date"  class="frm_input required" > ~ <input name="coupon_useable_end_at" required id="coupon_useable_end_at" type="date"  class="frm_input required" >
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">쿠폰 할인금액</th>
                        <td>
                            <input type="text" name="coupon_discount_amount" class="frm_input required" size="20" maxlength="100" style="background-position: right top; background-repeat: no-repeat;" required> <span>원</span>
                            <p class="valid">${valid_coupon_discount_amount}</p>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">쿠폰 최소 주문 금액</th>
                        <td>
                            <input type="text" name="coupon_min_order_amount" class="frm_input" size="20" maxlength="20" required> <span>원 이상 구매시</span>
                            <p class="valid">${valid_coupon_min_order_amount}</p>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">쿠폰 사용 조건</th>
                        <td>
                            <input type="text" placeholder="ex) 20,000원 이상 결제 시 사용 가능" name="coupon_use_condition" class="frm_input frm_address" size="40" required>
                            <p class="valid">${valid_coupon_use_condition}</p>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="btn-confirm">
                <input type="submit" value="저장" id="btn_submit" class="btn-large">
            </div>
        </form>
    </div>
</div>

<jsp:include page="/WEB-INF/views/admin/common/adminfooter.jsp"/>

<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="/resources/js/admin/admin.js"></script>

    <script>
        let msg = "${msg}";
        if(msg=="INS_ERR")  alert("회원 등록에 실패했습니다. 재신청해주세요.");
    </script>
</body>
</html>
