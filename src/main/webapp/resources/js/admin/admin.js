$(function (){

    sessionStorage.setItem("contextpath", "${pageContext.request.contextPath}");

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



    // 관리자 쿠폰 삭제 버튼 클릭 이벤트
    $('#coupon-delete-btn').on('click', function(){

        // 체크박스 리스트 전체
        let checkList = $("input[name=selectedItems]:checked");
        let valueArr = [];

        // checkList가 check 된 상태이면 배열에 값 저장
        checkList.each(function () {
            valueArr.push($(this).val());
        });

        console.log('valueArr => ' + valueArr);

        if(valueArr.length === 0){
            alert("삭제할 항목을 선택해주세요");
            return false;
        }else{
            if(confirm("정말 삭제하시겠습니까?")){

                $.ajax({
                    type: 'DELETE',
                    url: sessionStorage.getItem("contextpath") + '/admin/coupondelete',
                    data: JSON.stringify(valueArr),
                    contentType: "application/json",
                    success: function (res){
                        console.log('res => ' + res)
                        if(res > 0){
                            alert('삭제되었습니다.');
                            location.href = sessionStorage.getItem("contextpath")+ "/admin/coupondelete";
                        }else{
                            alert('삭제 실패');
                            location.href = sessionStorage.getItem("contextpath")+ "/admin/coupondelete";
                        }
                    },
                    error: function (e) {
                        console.error("삭제 실패", e);
                    }
                });
            }
        }
    });



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