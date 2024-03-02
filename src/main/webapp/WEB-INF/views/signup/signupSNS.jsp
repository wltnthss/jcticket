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
    <div class="signup-content">
        <h1 class="signupFont">회원가입</h1>

        <%-- 회원가입 폼 시작 --%>
        <form action="<c:url value="/signup/signupSNS"/>" id="signupForm" class="signupForm" method="POST">
            <input id="sns_provider" type="hidden" name="user_sns_provider" value="${requestScope.n_sns_provider}">
            <!-- 이메일 부분 시작 -->
            <input id="totalEmail" type="hidden" name="user_email" value="${requestScope.n_email}">
            <!-- 이메일 부분 끝 -->

            <!-- 아이디 입력 인풋창 시작-->
            <input type="hidden" id="userIdInput" value="${requestScope.n_id}" class="css_idPwdNickTelAddGenBir_input" name="user_id" placeholder="아이디" >
            <!-- 아이디 입력 인풋창 끝-->

            <!-- 닉네임 입력 인풋창 시작 -->
            <div class="idPwdNickTelAddGenBir_Wrap">
                <label class="css_idPwdNickTelAddGenBir_label">닉네임</label>
                <div class="css_idPwdNickTelAddGenBir_div">
                    사용할 닉네임을 입력해주세요.
                </div>
                <label>
                    <input type="text" id="userNicknameInput" class="css_idPwdNickTelAddGenBir_input" name="user_nickname" placeholder="닉네임" maxlength="30">
                </label>
                <div id="nickname_warnMsg">${valid_user_nickname}</div>
            </div>
            <!-- 닉네임 입력 인풋창 끝 -->

            <!-- 이름 입력 인풋창 시작 -->
            <input type="hidden" id="userNameInput" class="css_idPwdNickTelAddGenBir_input" value="${requestScope.n_name}" name="user_name" placeholder="이름" maxlength="20">
            <!-- 이름 입력 인풋창 끝 -->

            <!-- 전화번호 입력 인풋창 시작 -->
            <input type="hidden" id="user_tel" value="${requestScope.n_tel}" class="css_idPwdNickTelAddGenBir_input" name="user_tel" placeholder="전화번호" maxlength="13" minlength="13">
            <!-- 전화번호 입력 인풋창 끝 -->

            <!-- 생년월일 입력 인풋창 시작 -->
            <input type="hidden" id="user_birth_input" value="${requestScope.n_birth}" class="css_idPwdNickTelAddGenBir_input" name="user_birth" placeholder="생년월일" maxlength="8">

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
            <input type="hidden" id="user_gender_input" value="${requestScope.n_gender}" class="css_idPwdNickTelAddGenBir_input" name="user_gender" placeholder="M / W"  maxlength="1">
            <!-- 성별 입력 인풋창 끝 -->

            <!-- 관심장르 입력 인풋창 시작 -->
            <div class="idPwdNickTelAddGenBir_Wrap">
                <label class="css_idPwdNickTelAddGenBir_label">관심장르</label>
                <div class="css_idPwdNickTelAddGenBir_div">
                    콘서트, 뮤지컬, 연극, 클래식 중 1개를 입력해주세요.
                </div>
                <label>
                    <select class="selGenre" name="user_interested_genre" >
                        <option class="disabledOpt" value selected disabled hidden>선택해주세요</option>
                        <option class="genreOpt" value="콘서트">콘서트</option>
                        <option class="genreOpt" value="뮤지컬">뮤지컬</option>
                        <option class="genreOpt" value="연극">연극</option>
                        <option class="genreOpt" value="클래식">클래식</option>
                    </select>
                </label>
                <div id="genre_warnMsg">${valid_user_interested_genre}</div>
            </div>
            <!-- 관심장르 입력 인풋창 끝 -->

            <!-- 약관동의 부분 시작 -->
            <div class="idPwdNickTelAddGenBir_Wrap">
                <label class="css_idPwdNickTelAddGenBir_label">약관동의</label>
                <div class="termsWrap">
                    <!-- 약관 전체동의 시작 -->
                    <div class="termsAll">
                        <label class="termLabel">
                            <div class="termsChk_div">
                                <div class="termsChk_div2">
                                    <span class="termsChk_span">
                                    </span>
                                </div>
                                <input name="agreeAll" id="agreeAll" type="checkbox" class="termsChkBoxAll">
                            </div>
                            <span class="termsChkCon">
                                <span class="termsChkCon2">
                                    전체동의
                                    <span class="termsChkCon2Detail">
                                        선택항목에 대한 동의 포함
                                    </span>
                                </span>
                            </span>
                        </label>
                    </div>
                    <hr class="termsGuideLine">
                    <!-- 약관 전체동의 끝 -->

                    <!-- 이용약관(필수) 시작 -->
                    <div class="terms">
                        <label class="termLabel">
                            <div class="termsChk_div">
                                <div class="termsChk_div2">
                                    <span class="termsChk_span">
                                    </span>
                                </div>
                                <input name="agree1" type="checkbox" class="termsChkBox" value="약관1 동의" required="required">
                            </div>
                            <span class="termsChkCon">
                                <span class="essentialTerm">
                                    이용약관
                                </span>
                            </span>
                        </label>
                    </div>
                    <!-- 이용약관(필수) 끝 -->

                    <!-- 개인정보수집 및 이용동의 약관(필수) 시작 -->
                    <div class="terms">
                        <label class="termLabel">
                            <div class="termsChk_div">
                                <div class="termsChk_div2">
                                    <span class="termsChk_span">
                                    </span>
                                </div>
                                <input name="agree2" type="checkbox" class="termsChkBox" value="Y" required="required">
                            </div>
                            <span class="termsChkCon">
                                <span class="essentialTerm">
                                    개인정보수집 및 이용동의
                                </span>
                            </span>
                        </label>
                    </div>
                    <!-- 개인정보수집 및 이용동의 약관(필수) 끝 -->

                    <!-- 이벤트,쿠폰,특가 알림 메일 및 SMS 등 수신 약관(선택) 시작 -->
                    <div class="terms">
                        <label class="termLabel">
                            <div class="termsChk_div">
                                <div class="termsChk_div2">
                                    <span class="termsChk_span">
                                    </span>
                                </div>
                                <input id="selTermChkbox" type="checkbox" class="termsChkBox">
                                <input id="selTerm" type="hidden" name="agreement" value="N">
                            </div>
                            <span class="termsChkCon">
                                <span class="selectiveTerm">
                                    이벤트,쿠폰,특가 알림 메일 및 SMS 등 수신
                                </span>
                            </span>
                        </label>
                    </div>
                    <!-- 이벤트,쿠폰,특가 알림 메일 및 SMS 등 수신 약관(선택) 끝 -->

                </div>
            </div>
            <!-- 약관동의 부분 끝 -->

            <!-- 회원가입하기 버튼 부분 시작 -->
            <div class="signupBtnWrap">
                <button class="signupBtn" name="signup" type="submit">회원가입하기</button>
            </div>
            <!-- 회원가입하기 버튼 부분 끝 -->
        </form>
        <%-- 회원가입 폼 끝 --%>

        <p class="signupChkP">
            이미 아이디가 있으신가요?
            <a href="/login" class="goLoginFromSignUp">로그인</a>
        </p>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/resources/js/signup/signup.js"></script>
<script>
    let naverId = "${requestScope.n_id}";
    let naverName = "${requestScope.n_name}";
    let naverEmail = "${requestScope.n_email}";
    let naverTel = "${requestScope.n_tel}";
    let naverBirth = "${requestScope.n_birth}";
    let naverGender = "${requestScope.n_gender}";
    let provider = "${requestScope.n_sns_provider}";


</script>
</body>
</html>
