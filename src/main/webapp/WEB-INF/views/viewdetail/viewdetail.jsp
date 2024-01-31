<%--
  Created by IntelliJ IDEA.
  User: kyd54
  Date: 2024-01-31
  Time: 오후 2:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<%--    <style>--%>
<%--        .url-image {--%>
<%--            width: 100px;--%>
<%--            height: 100px;--%>
<%--            position: absolute;--%>
<%--            background: url("https://lh3.google.com/u/0/d/1SmiUAaDs829IOthlFJHUTLQT8GQF_lyI=w2880-h1462-iv1") no-repeat center;--%>
<%--        }--%>
<%--    </style>--%>
</head>
<body>
    <jsp:include page="../common/header.jsp"></jsp:include>

    <%-- content area    --%>
    <div class="one">
        <a class="major-cat">
            뮤지컬
        </a>
        <a class="middle-cat">
            창작
        </a>
    </div>

<%--    나중에 two 아래 css로 밑줄 만들것--%>
    <div class="two">
    <%--제목--%>
        <p class="big-title">2023 <우와우> -서울</p>
        <div class="two-one">
            <p>
                <span class="play-period">
                    2024.02.01~2024.02.03
                </span>
                <span class="stage-name">
                    홍익대 대학로 아트센터 대극장
                </span>

<%--            나중에 아래에 있는 a태그 공백 없앨것--%>
                <a href="javascript:void(0);" class="url-image">
                    <img src="https://lh3.google.com/u/0/d/1SmiUAaDs829IOthlFJHUTLQT8GQF_lyI=w2880-h1462-iv1" alt="">
                </a>
            </p>

        </div>
    </div>

    <div class="three">
        <div class="three-one">
            <div class="three-one-left">
                <div class="play-img">
                    <img src='https://lh3.google.com/u/0/d/1AgnL7BoMFDS7N_oQ3y4ZX5Q316gcENNt=w2880-h1462-iv1' style="width: 400px"/>
<%--                    <a href="#" class="rn-product-movie" style="display:none;"><img src="http://tkfile.yes24.com/imgNew/common/kv-movie.png" alt="" /></a>--%>
                </div>
<%--                review-mini안에 별점, 평균별점, 리뷰 수 등등 들어감--%>
                <div class="review-mini">
                    <div class="review-container">
                        <div class="review-star">

                        </div>
                    </div>
                    <span>
                        <em>5</em>
                         *123
                        <span>Reviews</span>
                    </span>
                </div>
            </div>
<%--            three-one-left--%>
            <div class="three-one-right">
                <div class="play-info">
                    <dl>
                        <dt>등급</dt>
                        <dd>12세 이상 관람가</dd>
                        <dt>관람시간</dt>
                        <dd>150분</dd>
                    </dl>
                </div>
            </div>
        </div>
    </div>



    <jsp:include page="../common/footer.jsp"></jsp:include>

</body>
</html>