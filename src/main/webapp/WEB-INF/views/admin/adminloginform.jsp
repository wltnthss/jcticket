<%--
  Created by IntelliJ IDEA.
  User: jisoo son
  Date: 2024-02-05
  Time: 오전 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Title</title>
</head>
<style>
    /*관리자 로그인 페이지 시작*/
    *{
        margin: 0;
        padding: 0;
        border: 0;
        outline: 0;
        font-size: 100%;
        vertical-align: baseline;
        background: transparent;
    }
    .admin-login-container{
        min-width: 1080px;
    }
    .admin-login-container .loginbox{
        position: absolute;
        width: 825px;
        height: 497px;
        top: 50%;
        left: 50%;
        margin-top: -248.5px;
        margin-left: -412.5px;
        border-radius: 30px;
        z-index: 1;
    }
    .blind{
        overflow: hidden;
        position: absolute;
        width: 1px;
        height: 1px;
        padding: 0;
        font-size: 10px;
        text-indent: 100%;
        white-space: nowrap;
    }
    .admin-login-container .loginbox > div{
        height: 100%;
    }
    .admin-login-container .loginleft{
        position: relative;
        float: left;
        width: 400px;
        background: url(//openimage.interpark.com/admin/ticket-manager/login/loginLeft.jpg) no-repeat center;
        border-radius: 30px 0 0 30px;
        text-align: center;
    }
    .admin-login-container .loginright{
        position: relative;
        float: left;
        width: 460px;
        padding: 85px 60px;
        background-color: #fff;
        box-sizing: border-box;
        margin-left: -35px;
        z-index: 1;
        border-radius: 30px;
        box-shadow: 0 7px 20px 0 rgba(0, 0, 0, 0.2);
    }
    .admin-login-container .loginright h1{
        margin-bottom: 42px;
        font-size: 20px;
        font-weight: bold;
        word-break: keep-all;
        font-family: -apple-system, BlinkMacSystemFont, "Apple SD Gothic Neo", "맑은 고딕", "Malgun Gothic", "돋움", Dotum, Helvetica, sans-serif;
    }
    input[type="text"]{
        width: 100%;
        height: 50px;
        padding: 0 8px;
        font-size: 14px;
        color: #333;
        border: none;
        border-bottom: 1px solid #dfe5ed;
        letter-spacing: inherit;
        box-sizing: border-box;
        box-shadow: none;
        border-radius: 0;
    }
    input[type="text"], input[type="password"] {
        width: 100%;
        height: 50px;
        padding: 0 8px;
        font-size: 14px;
        color: #333;
        border: none;
        border-bottom: 1px solid #dfe5ed;
        letter-spacing: inherit;
        box-sizing: border-box;
        box-shadow: none;
        border-radius: 0;
    }
    .admin-login-container .loginright .btnLogin {
        width: 100%;
        height: 55px;
        margin: 30px 0 23px;
        font-size: 18px;
        background: #ef3e43;
        border-radius: 10px;
        color: #fff;
        transition: width .2s;
        border: none;
        cursor: pointer;
    }
</style>
<body>

    <div class="admin-login-container">
        <div class="loginbox">
            <div class="loginleft">
                <p class="blind">Welcome Ticket Manager</p>
            </div>
            <div class="loginright">
                <h1>티켓매니저 관리자 로그인</h1>
                <form class="loginform form-group" id="loginform">
                    <fieldset>
                        <legend class="blind">로그인</legend>
                        <div class="inputwrap">
                            <label class="loginform idform">
                                <input id="admin_id" name="admin_id" placeholder="아이디" type="text" value="">
                            </label>
                        </div>
                        <div>
                        </div>
                        <div class="inputwrap">
                            <label class="loginform passwordform">
                                <input autocomplete="current-password" id="admin_password" name="admin_password" placeholder="비밀번호" type="password" value="">
                            </label>
                        </div>
                        <div>
                            <span id="loginfail"></span>
                        </div>
                        <div class="btnwrap">
                            <button type="button" class="btnLogin">로그인</button>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</body>

<script src="https://code.jquery.com/jquery-3.5.0.js"></script>

<script>
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
</script>
</html>
