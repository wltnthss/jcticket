$(function (){

    // admin 세션 카운트다운

    // admin 관리 페이지 ↓ 버튼 클릭시 toggle 이벤트
    $('.menu_toggle-u10').on('click', u10Toggle);
    $('.menu_toggle-u20').on('click', u20Toggle);

    function u10Toggle(){
        let u10List = document.getElementById('u10');
        let u10ListDisplay = u10List.style.display;

        if(u10ListDisplay === 'block'){
            u10List.style.display = 'none';
        }else if(u10ListDisplay === 'none'){
            u10List.style.display = 'block';
        }
    }
    function u20Toggle(){
        let u20List = document.getElementById('u20');
        let u20ListDisplay = u20List.style.display;

        if(u20ListDisplay === 'block'){
            u20List.style.display = 'none';
        }else if(u20ListDisplay === 'none'){
            u20List.style.display = 'block';
        }
    }

    $('.btnLogin').on('click', function (){
        let adminId = $('#admin_id').val();
        let adminPwd = $('#admin_password').val();
        let loginfail = $('#loginfail');

        console.log('adminId => ', adminId);
        console.log('adminPwd => ', adminPwd);

        if(adminId === null || adminId === ""){
            alert("아이디를 입력해주세요.");
            $('#admin_id').focus();
            return false;
        }
        if(adminPwd === null || adminPwd === ""){
            alert("비밀번호를 입력해주세요.");
            $('#admin_password').focus();
            return false;
        }

        let adminDto = {
            admin_id: adminId,
            admin_password: adminPwd
        };

        $.ajax({
            type: 'POST',
            uri: sessionStorage.getItem("contextpath") + '/admin',
            contentType: 'application/json',
            data: JSON.stringify(adminDto),
            success: function (res) {

                if(res == "ok"){
                    location.href = sessionStorage.getItem("contextpath") + "/admin/dashboard";
                }else {
                    loginfail.html('아이디와 비밀번호가 틀렸습니다.')
                    loginfail.css('color', 'red');
                }
            },
            error: function (err) {
                console.error("로그인 에러", err);
            }

        });
    })

    // 전체 체크박스 선택 시 자식 체크박스 전체 선택 on/off 기능
    $('#selectedItemsAll').on('click', function(){

        // 1. $(this).prop('checked') -> 전체 선택/해제 체크박스의 현재 상태를 나타냄(true/false)
        // 2. prop('checked', true/false) -> 체크박스의 선택 상태를 변경
        $("input[name='selectedItems']").prop('checked', $(this).prop('checked'));

    })
});

//  공연장 팝업창 오픈
function openStagePopup() {
    document.getElementById("stagePopup").style.display = "block";
}
// 공연 팝업창 오픈
function openPlayPopup() {
    document.getElementById("playPopup").style.display = "block";
}
// 팝업창 닫기, 변수 초기화
function closePopup() {
    document.querySelectorAll(".popup").forEach(function (e) {
        e.style.display = "none";
    });
    // 팝업창 공연장명, 공연명 인풋창 초기화
    document.getElementById("inputStage").value = '';
    document.getElementById("inputPlay").value = '';

    // 팝업창 공연장, 공연 리스트 초기화
    $('#stageList').html('');
    $('#playList').html('');
}