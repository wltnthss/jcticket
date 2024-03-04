<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/signup/signup.css">
</head>
<body>
<div class="page">
    <section class="section">
        <a href="/" class="mainLogoWrap">
            <img src="/resources/img/components/로고1.png" class="logoImg">
        </a>
    </section>



            <div class="idPwdNickTelAddGenBir_Wrap">
                <label class="css_idPwdNickTelAddGenBir_label">아이디</label>
                <div class="css_idPwdNickTelAddGenBir_div">
                    영문 소문자,숫자만을 사용한 4글자 이상, 20글자 이하
                </div>
                <label>
                    <input type="text" id="userIdInput" value="${userDto.user_id}" class="css_idPwdNickTelAddGenBir_input" name="user_id" placeholder="아이디" >
                </label>
                <div id="id_warnMsg">${valid_user_id}</div>
            </div>
            <!-- 아이디 입력 인풋창 끝-->

            <!-- 비밀번호 입력 인풋창 시작-->
            <div class="idPwdNickTelAddGenBir_Wrap">
                <label class="css_idPwdNickTelAddGenBir_label">비밀번호</label>
                <div class="css_idPwdNickTelAddGenBir_div">
                    영문 대문자, 소문자, 숫자,특수문자를 포함한 8자 이상
                </div>
                <label>
                    <input type="password" id="userPwdInput" value="${userDto.user_password}" class="css_idPwdNickTelAddGenBir_input" name="user_password" placeholder="비밀번호" >
                </label>
                <div id="pwd_warnMsg">${valid_user_password}</div>
            </div>
            <!-- 비밀번호 입력 인풋창 끝-->

            <!-- 비밀번호 재확인 입력 인풋창 시작-->
            <div class="idPwdNickTelAddGenBir_Wrap">
                <label class="css_idPwdNickTelAddGenBir_label">비밀번호 재확인</label>
                <div class="css_idPwdNickTelAddGenBir_div">
                    한번 더 입력해주세요.
                </div>
                <label>
                    <input type="password" id="userPwdChkInput" class="css_idPwdNickTelAddGenBir_input" name="user_pwdChk" placeholder="비밀번호 재확인" required="required">
                </label>
                <div id="pwd_chkWarnMsg"></div>
            </div>
            <!-- 비밀번호 재확인 입력 인풋창 끝-->

            <!-- 닉네임 입력 인풋창 시작 -->
            <div class="idPwdNickTelAddGenBir_Wrap">
                <label class="css_idPwdNickTelAddGenBir_label">닉네임</label>
                <div class="css_idPwdNickTelAddGenBir_div">
                    사용할 닉네임을 입력해주세요.
                </div>
                <label>
                    <input type="text" id="userNicknameInput" value="${userDto.user_nickname}" class="css_idPwdNickTelAddGenBir_input" name="user_nickname" placeholder="닉네임" maxlength="30">
                </label>
                <div id="nickname_warnMsg">${valid_user_nickname}</div>
            </div>
            <!-- 닉네임 입력 인풋창 끝 -->

            <!-- 이름 입력 인풋창 시작 -->
            <div class="idPwdNickTelAddGenBir_Wrap">
                <label class="css_idPwdNickTelAddGenBir_label">이름</label>
                <div class="css_idPwdNickTelAddGenBir_div">
                    이름을 입력해주세요.
                </div>
                <label>
                    <input type="text" id="userNameInput" class="css_idPwdNickTelAddGenBir_input" value="${userDto.user_name}" name="user_name" placeholder="이름" maxlength="20">
                </label>
                <div id="name_warnMsg">${valid_user_name}</div>
            </div>
            <!-- 이름 입력 인풋창 끝 -->

            <!-- 전화번호 입력 인풋창 시작 -->
            <div class="idPwdNickTelAddGenBir_Wrap">
                <label class="css_idPwdNickTelAddGenBir_label">전화번호</label>
                <div class="css_idPwdNickTelAddGenBir_div">
                    전화번호를 입력해주세요.
                </div>
                <label>
                    <input type="text" id="user_tel" value="${userDto.user_tel}" class="css_idPwdNickTelAddGenBir_input" name="user_tel" placeholder="전화번호" maxlength="13" minlength="13">
                </label>
                <div id="tel_warnMsg">${valid_user_tel}</div>
            </div>
            <!-- 전화번호 입력 인풋창 끝 -->

            <!-- 생년월일 입력 인풋창 시작 -->
            <div class="idPwdNickTelAddGenBir_Wrap">
                <label class="css_idPwdNickTelAddGenBir_label">생년월일</label>
                <div class="css_idPwdNickTelAddGenBir_div">
                    생년월일 8자리를 입력해주세요.
                </div>
                <label>
                    <input type="text" id="user_birth_input" value="${userDto.user_birth}" class="css_idPwdNickTelAddGenBir_input" name="user_birth" placeholder="생년월일" maxlength="8">
                </label>
                <div id="birth_warnMsg">${valid_user_birth}</div>
            </div>
            <!-- 생년월일 입력 인풋창 끝 -->

            <!-- 주소 입력 인풋창 시작 -->
            <div class="idPwdNickTelAddGenBir_Wrap">
                <label class="css_idPwdNickTelAddGenBir_label">주소</label>
                <div class="css_idPwdNickTelAddGenBir_div">
                </div>
                <label>
                    <input type="text" id="sample4_postcode" placeholder="우편번호" required="required">
                    <input type="button" id="addBtn" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
                    <input type="text" id="sample4_roadAddress" placeholder="도로명주소" >
                    <input type="text" id="sample4_jibunAddress" placeholder="지번주소">
                    <span id="guide" style="color:#999;display:none"></span>
                    <input type="text" id="sample4_detailAddress" placeholder="상세주소" >
                    <input type="text" id="sample4_extraAddress" placeholder="참고항목">
                </label>
                <input id="user_address" type="hidden" name="user_address" value="">
            </div>
            <!-- 주소 입력 인풋창 끝 -->

            <!-- 성별 입력 인풋창 시작 -->


            <!-- 회원가입하기 버튼 부분 시작 -->
            <div class="signupBtnWrap">
                <button class="signupBtn" name="signup" type="submit">회원정보수정</button>
            </div>
            <!-- 회원가입하기 버튼 부분 끝 -->
        </form>


    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/resources/js/signup/signup.js"></script>
</body>
</html>
