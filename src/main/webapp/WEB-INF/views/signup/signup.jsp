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
        <!-- 소셜 회원가입 부분 시작 -->
        <div class="socialSignUpArea">
            <div class="socialSignUpContent">
                SNS계정으로 간편하게 회원가입
            </div>
            <ul class="signup-social-icon">
                <li class="ssc-icon">
                    <a href="네이버 회원가입" title="네이버로 가입하기" class="ssc">
                        <img src="/resources/img/signup/네이버_회원가입.png" class="sscImg">
                    </a>
                </li>
                <li class="ssc-icon">
                    <a href="카카오 회원가입" title="카카오로 가입하기" class="ssc">
                        <img src="/resources/img/signup/카카오_회원가입.png" class="sscImg">
                    </a>
                </li>
                <li class="ssc-icon">
                    <a href="구글 회원가입" title="구글로 가입하기" class="ssc">
                        <img src="/resources/img/signup/구글_회원가입.png" class="sscImg">
                    </a>
                </li>
            </ul>
        </div>
        <!-- 소셜 회원가입 부분 끝 -->

        <%-- 회원가입 폼 시작 --%>
        <form action="<c:url value="/signup/signup"/>" id="signupForm" class="signupForm" method="POST">
            <!-- 이메일 부분 시작 -->
            <div class="emailWrap">
                <label class="emailLabel">이메일</label>
                <div class="emailInputWrap">
                    <div class="emailInput">
                            <span class="emailId">
                                <label>
                                    <input class="idInput" placeholder="이메일" size="1" value required="required">
                                </label>
                            </span>
                        <span class="emailSep">@</span>
                        <span class="emailDomain">
                                <label>
                                    <select class="selDomain" required = "required">
                                        <option class="disabledOpt" value selected disabled hidden>선택해주세요</option>
                                        <option class="domainOpt" value="naver.com">naver.com</option>
                                        <option class="domainOpt" value="hanmail.net">hanmail.net</option>
                                        <option class="domainOpt" value="daum.net">daum.net</option>
                                        <option class="domainOpt" value="gmail.com">gmail.com</option>
                                        <option class="domainOpt" value="hotmail.com">hotmail.com</option>
                                        <option class="domainOpt" value="outlook.com">outlook.com</option>
                                        <option class="domainOpt" value="icloud.com">icloud.com</option>
                                    </select>
                                </label>
                            </span>
                    </div>
                    <input id="totalEmail" type="hidden" name="user_email" value="">
                </div>
            </div>
            <!-- 이메일 부분 끝 -->

            <!-- 이메일 버튼 시작-->
            <div class="emailBtnWrap">
                <button class="emailBtn" id="emailBtn" name="emailAuth" type="button">이메일인증하기</button>
            </div>
            <!-- 이메일 버튼 끝 -->

            <!-- 이메일 인증번호 시작-->
            <div class="idPwdNickTelAddGenBir_Wrap">
                <div class="css_idPwdNickTelAddGenBir_div">
                    인증번호 6자리를 입력해주세요.
                </div>
                <label>
                    <input type="text" id="authNum" class="css_idPwdNickTelAddGenBir_inputAuth" name="email_num" placeholder="인증번호" minlength="6" maxlength="6" required="required">
                </label>
                <input type="button" id="AuthBtn"  value="인증번호 확인"><br>
                <div class = authMsg></div>
            </div>

            <!-- 이메일 인증번호 끝-->

            <!-- 아이디 입력 인풋창 시작-->
            <div class="idPwdNickTelAddGenBir_Wrap">
                <label class="css_idPwdNickTelAddGenBir_label">아이디</label>
                <div class="css_idPwdNickTelAddGenBir_div">
                    영문 소문자,숫자만을 사용한 4글자 이상, 20글자 이하
                </div>
                <label>
                    <input type="text" id="userIdInput" class="css_idPwdNickTelAddGenBir_input" name="user_id" placeholder="아이디" required="required">
                </label>
                <div id="id_warnMsg"></div>
            </div>
            <!-- 아이디 입력 인풋창 끝-->

            <!-- 비밀번호 입력 인풋창 시작-->
            <div class="idPwdNickTelAddGenBir_Wrap">
                <label class="css_idPwdNickTelAddGenBir_label">비밀번호</label>
                <div class="css_idPwdNickTelAddGenBir_div">
                    영문 대문자, 소문자, 숫자,특수문자를 포함한 8자 이상
                </div>
                <label>
                    <input type="password" id="userPwdInput" class="css_idPwdNickTelAddGenBir_input" name="user_password" placeholder="비밀번호" required="required">
                </label>
                <div id="pwd_warnMsg"></div>
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
                    <input type="text" id="userNicknameInput" class="css_idPwdNickTelAddGenBir_input" name="user_nickname" placeholder="닉네임" required="required" maxlength="30">
                </label>
                <div id="nickname_warnMsg"></div>
            </div>
            <!-- 닉네임 입력 인풋창 끝 -->

            <!-- 이름 입력 인풋창 시작 -->
            <div class="idPwdNickTelAddGenBir_Wrap">
                <label class="css_idPwdNickTelAddGenBir_label">이름</label>
                <div class="css_idPwdNickTelAddGenBir_div">
                    이름을 입력해주세요.
                </div>
                <label>
                    <input type="text" class="css_idPwdNickTelAddGenBir_input" name="user_name" placeholder="이름" required="required" maxlength="20">
                </label>
            </div>
            <!-- 이름 입력 인풋창 끝 -->

            <!-- 전화번호 입력 인풋창 시작 -->
            <div class="idPwdNickTelAddGenBir_Wrap">
                <label class="css_idPwdNickTelAddGenBir_label">전화번호</label>
                <div class="css_idPwdNickTelAddGenBir_div">
                    전화번호를 입력해주세요.
                </div>
                <label>
                    <input type="text" id="user_tel" class="css_idPwdNickTelAddGenBir_input" name="user_tel" placeholder="전화번호" required="required" maxlength="13" minlength="13">
                </label>
                <div id="tel_warnMsg"></div>
            </div>
            <!-- 전화번호 입력 인풋창 끝 -->

            <!-- 생년월일 입력 인풋창 시작 -->
            <div class="idPwdNickTelAddGenBir_Wrap">
                <label class="css_idPwdNickTelAddGenBir_label">생년월일</label>
                <div class="css_idPwdNickTelAddGenBir_div">
                    생년월일 8자리를 입력해주세요.
                </div>
                <label>
                    <input type="text" id="user_birth_input" class="css_idPwdNickTelAddGenBir_input" name="user_birth" placeholder="생년월일" required="required" maxlength="8">
                </label>
                <div id="birth_warnMsg"></div>
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
                    <input type="text" id="sample4_roadAddress" placeholder="도로명주소" required="required">
                    <input type="text" id="sample4_jibunAddress" placeholder="지번주소">
                    <span id="guide" style="color:#999;display:none"></span>
                    <input type="text" id="sample4_detailAddress" placeholder="상세주소" required="required">
                    <input type="text" id="sample4_extraAddress" placeholder="참고항목">
                </label>
                <input id="user_address" type="hidden" name="user_address" value="">
            </div>
            <!-- 주소 입력 인풋창 끝 -->

            <!-- 성별 입력 인풋창 시작 -->
            <div class="idPwdNickTelAddGenBir_Wrap">
                <label class="css_idPwdNickTelAddGenBir_label">성별</label>
                <div class="css_idPwdNickTelAddGenBir_div">
                    남성 : M 여성 : W
                </div>
                <label>
                    <input type="text" id="user_gender_input" class="css_idPwdNickTelAddGenBir_input" name="user_gender" placeholder="M / W" required="required" maxlength="1">
                </label>
                <div id="gender_warnMsg"></div>
            </div>
            <!-- 성별 입력 인풋창 끝 -->

            <!-- 관심장르 입력 인풋창 시작 -->
            <div class="idPwdNickTelAddGenBir_Wrap">
                <label class="css_idPwdNickTelAddGenBir_label">관심장르</label>
                <div class="css_idPwdNickTelAddGenBir_div">
                    콘서트, 뮤지컬, 연극, 클래식 중 1개를 입력해주세요.
                </div>
                <label>
                        <select class="selGenre" name="user_interested_genre" required = "required">
                            <option class="disabledOpt" value selected disabled hidden>선택해주세요</option>
                            <option class="genreOpt" value="콘서트">콘서트</option>
                            <option class="genreOpt" value="뮤지컬">뮤지컬</option>
                            <option class="genreOpt" value="연극">연극</option>
                            <option class="genreOpt" value="클래식">클래식</option>
                        </select>
                </label>
                <div id="genre_warnMsg"></div>
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
</body>
</html>
