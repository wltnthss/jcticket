<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IndexOutofBounds</title>
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
        }
        h1 {
            color: #dc3545;
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
            color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>참조하려는 배열의 길이를 벗어났으므로 에러가 발생했습니다.</h1>
    <p>시스템 관리자에게 문의해주세요.</p>
    <p><a href="/">홈으로 이동</a></p>
</div>
</body>
</html>
