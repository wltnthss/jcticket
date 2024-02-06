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
})