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

    $('#selectedItemsAll').on('click', function(){
        let t = document.querySelector('.list');
        console.log('t => ' + t);
        for (const tKey in t) {
            console.log("tKey => " + tKey);
        }
    })

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