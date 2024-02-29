
<!-- 로그인실패 창 버튼 시작 -->
$('.closeButtonWrap').click(function (){
    $('.maskUI').toggle();
})

// 유저탭,기획사탭 클릭 시 변화
$('#userTab').click(function (){
    $('.memLoginForm').css('display','block')
    $('.agencyLoginForm').css('display','none')
    $('#userTabA').css('border','solid 1.5px black')
    $('#agencyTabA').css('border','solid 1.0px black')
})

$('#agencyTab').click(function (){
    $('.agencyLoginForm').css('display','block')
    $('.memLoginForm').css('display','none')
    $('#agencyTabA').css('border','solid 1.5px black')
    $('#userTabA').css('border','solid 1.0px black')
})

//네이버 로그인 시작

