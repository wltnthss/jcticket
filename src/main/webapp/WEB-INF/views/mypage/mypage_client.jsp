<%--
  Created by IntelliJ IDEA.
  User: wjswo
  Date: 2024-02-04
  Time: PM 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link href="/resources/css/mypage/mypage.css?after" rel="stylesheet">
    <link rel="icon" href="/resources/img/mypage/KakaoTalk_20240131_192702986_02.ico">

    <style>
        .qustion_box {
            width: 700px;
            height: 500px;
        }

        .qustion_box_img {
            width: 100%;
            height: 100%;
        }

        #question {
            width: 100%;
            height: 300px;
            background-color: white;
        }

        #question > h2 {
            margin-bottom: 10px;
        }

        #question > details > summary {
            margin: 10px;
        }


        #question > p {
            margin: 10px;
        }

        #question > details > p {

            margin: 10px;
        }

        #question > details  > ul {
            padding-left: 5px;
            list-style: none;
        }
        #question > details > ul > li {
            margin: 10px;
        }
    </style>

</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>

<hr>
<br>
<br>


<div id="wrap">
    <div id="container">
        <div id="contents">
            <aside id="side">
                <div id="side-mypage">
                    <a href="mypageIndex"><img src="/resources/img/mypage/lnb_mypage.gif"></a>

                    <div id="side_img">
                        <img src="/resources/img/mypage/페페%20한잔해.jpg">
                    </div>

                    <div id="ticket">
                        <a href="/mypageticket"><h3>예매확인/취소</h3></a>
                        <a href="/mypagecupon"><h3>쿠폰/예매권</h3></a>
                        <a href="/mypageview"><h3>나의 관람 공연</h3></a>
                        <a href="/mypageclient"><h3>문의사항</h3></a>
                        <a href=""><h3>회원정보 수정</h3></a>
                    </div>

                    <div id="client">
                        <h3>고객센터 전화상담</h3>

                        <h2>1588-8282</h2>
                        <ul>
                            <li>평일 09:00 ~ 18:00</li>
                            <li>토요일 09:00 ~ 17:00</li>
                            <li>일요일 공휴일 휴무</li>
                        </ul>
                    </div>
                </div>
            </aside>
            <article id="con">

                <div class="qustion_box">
                    <img class="qustion_box_img" src="/resources/img/mypage/랄죠_사토루(무량공처).png">
                </div>

                <div id="question">
                    <h2>자주 뭍는 질문 TOP 10</h2>
                    <hr>
                    <details>
                        <summary>[리뷰/한줄평] 어떻게 작성하나요?</summary>
                        <p>리뷰/한줄평은 다음의 방법을 통해 작성하실 수 있습니다.</p>

                        <p>● 리뷰

                            1. 마이페이지(PC) - 나의 리뷰/한줄평 - 작성 가능한 리뷰/한줄평 - [리뷰쓰기] (▶ 바로 가기)

                            2. 상품 페이지(PC/M) - [리뷰쓰기]

                            3. 내블로그(PC/M) - 글쓰기- '리뷰' 카테고리 선택 - 상품 직접 검색하여 작성</p>


                        <p>● 한줄평

                            1. 마이페이지(PC) - 나의 리뷰/한줄평 - 작성 가능한 리뷰/한줄평 - [한줄평쓰기] (▶ 바로 가기)

                            2. 상품 페이지(PC/M) - [한줄평쓰기]</p>
                    </details>

                    <hr>

                    <details>
                        <summary>[리뷰/한줄평] 포인트는 언제 받을 수 있나요?</summary>
                        <p>리뷰/한줄평은 다음의 방법을 통해 작성하실 수 있습니다.</p>


                        <p>● 등록된 리뷰/한줄평 포인트는 모니터링을 거쳐 2일 이후 지급됩니다. (영업일 기준)

                            금, 토, 일요일에 작성된 건은 다음 주 화요일에 포인트 지급됩니다.


                            단, 예약 판매 기간 중에 등록된 리뷰/한줄평은 출고 완료 후 익일에 포인트가 지급됩니다.

                            출고 완료 익일이 영업일이 아닌 경우에는 그 다음 영업일에 포인트가 지급됩니다.</p>

                    </details>

                    <hr>

                    <details>
                        <summary>[많이 묻는 질문]주문 확인,주소 변경,배송 확인,교환/반품 방법/취소 방법,회수 조회 방법 안내드립니다.</summary>
                        <p>가장 많이 궁금해하시는 아래 문의를 요약하여 안내드리오니 문의 전 참고 부탁드립니다.</p>
                        <ul>
                            <li>1. 주문 : 마이페이지 주문내역에서 확인이 가능합니다.</li>
                            <li>2. 주소 변경: 마이페이지 주문 내역에서 상품 준비 중 상태까지 직접 가능합니다.</li>
                            <li>3. 배송 : 마이페이지 주문내역/ 배송조회 항목에서 도착 예상일 확인, 배송 조회가 가능합니다.</li>
                            <li>4. 교환 : 마이페이지 반품/교환 항목에서 직접 접수 및 접수내역 조회가 가능합니다.</li>
                            <li>5. 반품 : 마이페이지 반품/교환 항목에서 출고 후 10일 이내 직접 접수 및 접수 내역 조회가 가능합니다.</li>
                            <li>6. 취소 : 마이페이지 주문내역에서 발송 준비 중 단계까지 직접 취소가 가능합니다. 단, 부분 취소는 PC 버전에서만 처리됩니다.</li>
                            <li>7. 회수 : 교환/ 반품 접수 내역의 회수는 마이페이지 반품/교환 항목에서 반송장 확인이 가능합니다.</li>

                        </ul>
                    </details>

                    <hr>

                    <details>
                        <summary>[티켓 수령/배송] 현장수령으로 예매한 경우 대리인 수령이 가능한가요?</summary>
                        <p>티켓의 경우 원칙적으로 타인에게 양도가 불가합니다.</p>

                        <p>단, 불가피하게 예매한 본인 이외의 다른 사람이 티켓을 수령&관람하실 경우, 예매자의 신분증 (혹은 신분증 사본)과 예매번호를 공연장에 제시하셔야 합니다.

                            장애유공/국가유공 할인을 받으신 경우 본인 외에는 관람하실 수 없습니다.</p>

                        <p>* 공연에 따라 수령방법이 달라질 수 있습니다.

                            자세한 내용은 공연 상세 정보에서 확인 부탁드립니다.</p>

                    </details>

                    <hr>
                    <details>
                        <summary>[리뷰/한줄평] 어떻게 작성하나요?</summary>
                        <p>리뷰/한줄평은 다음의 방법을 통해 작성하실 수 있습니다.</p>


                        <p>● 리뷰

                            1. 마이페이지(PC) - 나의 리뷰/한줄평 - 작성 가능한 리뷰/한줄평 - [리뷰쓰기] (▶ 바로 가기)

                            2. 상품 페이지(PC/M) - [리뷰쓰기]

                            3. 내블로그(PC/M) - 글쓰기- '리뷰' 카테고리 선택 - 상품 직접 검색하여 작성</p>


                        <p>● 한줄평

                            1. 마이페이지(PC) - 나의 리뷰/한줄평 - 작성 가능한 리뷰/한줄평 - [한줄평쓰기] (▶ 바로 가기)

                            2. 상품 페이지(PC/M) - [한줄평쓰기]</p>
                    </details>

                    <hr>

                    <details>
                        <summary>[리뷰/한줄평] 포인트는 언제 받을 수 있나요?</summary>
                        <p>리뷰/한줄평은 다음의 방법을 통해 작성하실 수 있습니다.</p>


                        <p>● 등록된 리뷰/한줄평 포인트는 모니터링을 거쳐 2일 이후 지급됩니다. (영업일 기준)

                            금, 토, 일요일에 작성된 건은 다음 주 화요일에 포인트 지급됩니다.


                            단, 예약 판매 기간 중에 등록된 리뷰/한줄평은 출고 완료 후 익일에 포인트가 지급됩니다.

                            출고 완료 익일이 영업일이 아닌 경우에는 그 다음 영업일에 포인트가 지급됩니다.</p>

                    </details>

                    <hr>

                    <details>
                        <summary>[많이 묻는 질문]주문 확인,주소 변경,배송 확인,교환/반품 방법/취소 방법,회수 조회 방법 안내드립니다.</summary>
                        <p>가장 많이 궁금해하시는 아래 문의를 요약하여 안내드리오니 문의 전 참고 부탁드립니다.</p>
                        <ul>
                            <li>1. 주문 : 마이페이지 주문내역에서 확인이 가능합니다.</li>
                            <li>2. 주소 변경: 마이페이지 주문 내역에서 상품 준비 중 상태까지 직접 가능합니다.</li>
                            <li>3. 배송 : 마이페이지 주문내역/ 배송조회 항목에서 도착 예상일 확인, 배송 조회가 가능합니다.</li>
                            <li>4. 교환 : 마이페이지 반품/교환 항목에서 직접 접수 및 접수내역 조회가 가능합니다.</li>
                            <li>5. 반품 : 마이페이지 반품/교환 항목에서 출고 후 10일 이내 직접 접수 및 접수 내역 조회가 가능합니다.</li>
                            <li>6. 취소 : 마이페이지 주문내역에서 발송 준비 중 단계까지 직접 취소가 가능합니다. 단, 부분 취소는 PC 버전에서만 처리됩니다.</li>
                            <li>7. 회수 : 교환/ 반품 접수 내역의 회수는 마이페이지 반품/교환 항목에서 반송장 확인이 가능합니다.</li>

                        </ul>
                    </details>

                    <hr>

                    <details>
                        <summary>[티켓 수령/배송] 현장수령으로 예매한 경우 대리인 수령이 가능한가요?</summary>
                        <p>티켓의 경우 원칙적으로 타인에게 양도가 불가합니다.</p>

                        <p>단, 불가피하게 예매한 본인 이외의 다른 사람이 티켓을 수령&관람하실 경우, 예매자의 신분증 (혹은 신분증 사본)과 예매번호를 공연장에 제시하셔야 합니다.

                            장애유공/국가유공 할인을 받으신 경우 본인 외에는 관람하실 수 없습니다.</p>

                        <p>* 공연에 따라 수령방법이 달라질 수 있습니다.

                            자세한 내용은 공연 상세 정보에서 확인 부탁드립니다.</p>

                    </details>

                    <hr>


                </div>

            </article>


        </div>
    </div>
</div>

<br>
<br>
<hr>

<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
