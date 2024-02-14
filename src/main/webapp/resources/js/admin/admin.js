$(function (){
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
            uri: '/admin',
            contentType: 'application/json',
            data: JSON.stringify(adminDto),
            success: function (res) {

                if(res == "ok"){
                    location.href = "/admin/dashboard";
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

    // 관리자 회원 삭제 버튼 클릭 이벤트
    $('#user-delete-btn').on('click', function(){

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
                    url: '/admin/userdelete',
                    data: JSON.stringify(valueArr),
                    contentType: "application/json",
                    success: function (res){
                        console.log('res => ' + res)
                        if(res > 0){
                            alert('삭제되었습니다.');
                            location.href= "/admin/user";
                        }else{
                            alert('삭제 실패');
                            location.href= "/admin/delete";
                        }
                    },
                    error: function (e) {
                        console.error("삭제 실패", e);
                    }
                });


            }
        }
    });

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

})