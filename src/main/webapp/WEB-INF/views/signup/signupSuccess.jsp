<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>400</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            text-align: center;
            padding: 20px;
            border-radius: 10px;
            background-color: #fff;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            width: 520px;
        }
        h1 {
            color: orangered;
            margin-bottom: 10px;
        }
        p {
            color: #6c757d;
            margin-bottom: 20px;
        }
        a {
            color: #007bff;
            text-decoration: none;
            transition: color 0.3s;
        }
        a:hover {
            color: orangered;
        }

        .goLogin{
            background-color: black;
            opacity: 0.7;
            color: #fff;
            height: 40px;
            display: inline-block;
            line-height: 40px;
            border-radius: 5px;
            width: 150px;
        }

        .goIndex{
            background-color: black;
            opacity: 0.7;
            color: #fff;
            height: 40px;
            display: inline-block;
            line-height: 40px;
            border-radius: 5px;
            width: 150px;
            margin-left: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="sucImg">
        <img src="/resources/img/signup/회원가입성공.jpg">
    </div>
    <div class="sucCon">
        <h1>회원가입 성공</h1>
        <p>회원가입을 축하합니다!</p>
        <p>제이씨티켓에서는 보다 좋은 서비스를 받으실 수 있도록 노력하겠습니다.</p>
        <p><a href="/login" class="goLogin">로그인하러가기</a>
            <a href="/" class="goIndex">홈으로 가기</a></p>
    </div>
</div>
</body>
</html>
