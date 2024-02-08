
<!-- 주소검색 시작 -->
function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

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

            var guideTextBox = document.getElementById("guide");
            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            if(data.autoRoadAddress) {
                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                guideTextBox.style.display = 'block';

            } else if(data.autoJibunAddress) {
                var expJibunAddr = data.autoJibunAddress;
                guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                guideTextBox.style.display = 'block';
            } else {
                guideTextBox.innerHTML = '';
                guideTextBox.style.display = 'none';
            }
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
    const inputCode = $('#authNum').val();
    const $resultMsg = $('.authMsg');

    console.log(inputCode);

    if(inputCode===code && code!=="" && inputCode!==""){
        $($resultMsg).css('display','block')
        $resultMsg.html('인증에 성공하였습니다.')
        $resultMsg.css('color','rgb(0, 159, 206)');
        $('#authNum').attr('disabled','true')
    }else if(inputCode!==code){
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
