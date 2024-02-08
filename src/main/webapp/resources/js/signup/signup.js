
<!-- 주소검색 시작 -->
function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            const roadAddr = data.roadAddress; // 도로명 주소 변수
            let extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
                extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample4_postcode').value = data.zonecode;
            document.getElementById("sample4_roadAddress").value = roadAddr;
            document.getElementById("sample4_jibunAddress").value = data.jibunAddress;

            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
            if(roadAddr !== ''){
                document.getElementById("sample4_extraAddress").value = extraRoadAddr;
            } else {
                document.getElementById("sample4_extraAddress").value = '';
            }

            // var guideTextBox = document.getElementById("guide");
            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            // if(data.autoRoadAddress) {
            //     var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
            //     guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
            //     guideTextBox.style.display = 'block';
            //
            // } else if(data.autoJibunAddress) {
            //     var expJibunAddr = data.autoJibunAddress;
            //     guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
            //     guideTextBox.style.display = 'block';
            // } else {
            //     guideTextBox.innerHTML = '';
            //     guideTextBox.style.display = 'none';
            // }
        }
    }).open();
}
<!-- 주소검색 끝 -->

<!-- 전화번호 자동 하이픈 시작 -->
$(document).on("keyup", "#user_tel", function() {
    $(this).val( $(this).val().replace(/[^0-9]/g, "").replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-") );
});
<!-- 전화번호 자동 하이픈 끝 -->


// <!-- 이메일 인증번호 발송 시작 -->
let code = "";
$('#emailBtn').on('click',function (){
    const totalEmail = $('.idInput').val()+$('.emailSep').text()+$('.selDomain').val();
    $.ajax({
        type:"GET",
        url:"/signup/emailChk?totalEmail="+totalEmail,
        cache:false,
        success:function(data){
            if(data==="error"){
                alert("이메일 주소가 올바르지 않습니다. 유효한 이메일 주소를 입력해주세요.");
            }else{
                alert("인증번호 발송이 완료되었습니다.\n입력한 이메일에서 인증번호를 확인해주세요.");
            }
            code=data;
            console.log(code);
        }
    })
})
// <!-- 이메일 인증번호 발송 끝 -->

// 인증번호 비교 시작
$('#AuthBtn').on('click',function (){
    let inputCode = $('#authNum').val();
    const $resultMsg = $('.authMsg');

    console.log(inputCode);

    if(inputCode===code && code!=="" && inputCode!==""){
        $($resultMsg).css('display','block')
        $resultMsg.html('인증에 성공하였습니다.')
        $resultMsg.css('color','rgb(0, 159, 206)');
        $('#totalEmail').val($('.idInput').val()+$('.emailSep').text()+$('.selDomain').val());
        console.log($('#totalEmail').val());
        $('#authNum').attr('disabled','true')
    }else if(inputCode!==code && code!==""){
        $($resultMsg).css('display','block')
        $resultMsg.html('인증에 실패하였습니다. 인증번호를 다시 확인해주세요.')
        $resultMsg.css('color','orangered')
    }else if(code===""){
        $($resultMsg).css('display','block')
        $resultMsg.html('이메일 인증하기 버튼을 눌러 인증번호를 받으세요.')
        $resultMsg.css('color','orangered')
    }
})
// 인증번호 비교 끝

// 풀주소 얻기 시작
$('#sample4_detailAddress').on('keyup',function(){
    $('#user_address').val($('#sample4_roadAddress').val()+', '+$('#sample4_detailAddress').val())
    console.log($('#user_address').val())
})
// 풀주소 얻기 끝

// ------------------------------유효성검사 시작---------------------//

// 1.아이디 유효성 검사 시작
// 영문 소문자, 숫자 만을 사용하여 4~20자리의 아이디여야함
// 아이디 길이검사,특수문자,공백검사,아이디 중복체크
$('#userIdInput').on('keyup',function(){
    const idLength= $('#userIdInput').val().length
    const idValue = $('#userIdInput').val()
    const regEx = /^[a-z0-9]+$/ //특수문자 및 공백 포함 여부 확인

    if(idLength===0){
        $('#id_warnMsg').css('display','none')
    }else if(!(regEx.test(idValue))){
        $('#id_warnMsg').css('display','block')
        $('#id_warnMsg').css('color','orangered')
        $('#id_warnMsg').html("특수문자 또는 공백을 사용할 수 없습니다.");
    } else if(idLength<4){
        $('#id_warnMsg').css('display','block')
        $('#id_warnMsg').css('color','orangered')
        $('#id_warnMsg').html("4글자 이상의 아이디를 입력해주세요.");
    }else if(idLength>=4 && idLength <=20){
            // 아이디 중복체크
            $.ajax({
                url: '/signup/chk_id_dupl',
                method: 'POST',
                data:{user_id:idValue},
                success:function(data){
                    if(data){
                        $('#id_warnMsg').css('display', 'block');
                        $('#id_warnMsg').css('color', 'orangered');
                        $('#id_warnMsg').html("이미 사용 중인 아이디입니다.");
                    } else {
                        $('#id_warnMsg').css('display', 'block');
                        $('#id_warnMsg').css('color','rgb(0, 159, 206)');
                        $('#id_warnMsg').html("사용 가능한 아이디입니다.");
                    }
                },
                error: function(xhr, status, error) {
                    console.error('AJAX Error:', error);
                }
            })
    }else if(idLength>20){
        $('#id_warnMsg').css('display','block')
        $('#id_warnMsg').css('color','orangered')
        $('#id_warnMsg').html("20글자 이하의 아이디를 입력해주세요.");
    }
})
//아이디 유효성 검사 끝


//비밀번호 유효성 검사 시작
//소문자,대문자,숫자,특수문자 한번씩 포함하여 8자리 이상의 비밀번호여야함
$('#userPwdInput').on('keyup', function(){
    const regEx = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[~?!@#$%^&*_\-]).{8,}$/;
    const pwdLength = $('#userPwdInput').val().length;
    const pwdValue = $('#userPwdInput').val();

    if(pwdLength===0) {
        $('#pwd_warnMsg').css('display', 'none')
    }else if(pwdLength<8){
        $('#pwd_warnMsg').css('display', 'block');
        $('#pwd_warnMsg').css('color', 'orangered');
        $('#pwd_warnMsg').html("8자리 이상의 비밀번호를 입력해주세요.");
    }else if(regEx.test(pwdValue)){
        $('#pwd_warnMsg').css('display', 'block');
        $('#pwd_warnMsg').css('color', 'rgb(0, 159, 206)');
        $('#pwd_warnMsg').html("사용 가능한 비밀번호입니다.");
    }else if(!(regEx.test(pwdValue))){
        $('#pwd_warnMsg').css('display', 'block');
        $('#pwd_warnMsg').css('color', 'orangered');
        $('#pwd_warnMsg').html("사용 할 수 없는 비밀번호입니다.");
    }
})
//비밀번호 유효성 검사 끝

//비밀번호 재확인 유효성 검사 시작
$('#userPwdChkInput').on('keyup',function (){
    const pwdValue = $('#userPwdInput').val();
    const pwdChkValue = $('#userPwdChkInput').val();
    const pwdChkLength = $('#userPwdChkInput').val().length;

    // if(pwdChkValue.val()===''){
    //     $('#pwd_chkWarnMsg').css('display','block')
    // }
    if(pwdChkLength===0) {
        $('#pwd_chkWarnMsg').css('display', 'none')
    }else if(pwdValue===pwdChkValue){
        $('#pwd_chkWarnMsg').css('display','block')
        $('#pwd_chkWarnMsg').css('color', 'rgb(0, 159, 206)');
        $('#pwd_chkWarnMsg').html('비밀번호가 일치합니다.')
    }else{
        $('#pwd_chkWarnMsg').css('display','block')
        $('#pwd_chkWarnMsg').css('color', 'orangered');
        $('#pwd_chkWarnMsg').html('비밀번호가 일치하지 않습니다.')
    }
})
//비밀번호 재확인 유효성 검사 끝

//닉네임 중복 체크 시작
    $('#userNicknameInput').on('keyup',function (){
        const nicknameValue = $('#userNicknameInput').val();
        $.ajax({
            url:'/signup/chk_nickname_dupl',
            method: 'POST',
            data:{user_nickname:nicknameValue},
            success:function(data){
                if(data){
                    $('#nickname_warnMsg').css('display', 'block');
                    $('#nickname_warnMsg').css('color', 'orangered');
                    $('#nickname_warnMsg').html("이미 사용 중인 닉네임입니다.");
                } else {
                    $('#nickname_warnMsg').css('display', 'block');
                    $('#nickname_warnMsg').css('color','rgb(0, 159, 206)');
                    $('#nickname_warnMsg').html("사용 가능한 닉네임입니다.");
                }
            },
            error:function(xhr, status, error) {
            console.error('AJAX Error:', error);
        }
        })

    })

//닉네임 중복 체크 끝


//전화번호 유효성 검사 시작
// 숫자와 하이픈만 입력받게 ..

$('#user_tel').on('keyup', function (){
    const telValue = $('#user_tel').val();
    const telValueLength = $('#user_tel').val().length;
    const regEx = /^[0-9\-]+$/ //숫자와 하이픈만 입력가능

    if(telValueLength===0) {
        $('#pwd_chkWarnMsg').css('display', 'none')
    } else if(regEx.test(telValue)){
        $('#tel_warnMsg').css('display', 'none');
    }else{
        $('#tel_warnMsg').css('display', 'block');
        $('#tel_warnMsg').css('color', 'orangered');
        $('#tel_warnMsg').html("숫자만 입력 가능합니다.");
    }
})
//전화번호 유효성 검사 끝

