<%--
  Created by IntelliJ IDEA.
  User: joyoungsang
  Date: 2/10/24
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>JCticket 예매하기</title>
<%--    jQuery--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<%--    bootstrap--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<%--    datepicker--%>
    <link rel="stylesheet" href="/resources/css/ticketing/datepicker-ui.css">
    <style>
        * {
            margin: 0;
            padding: 0;
            font-family: montserrat;
        }
        html {
            height: 100%
        }
        p {
            color: grey
        }
        td{
            color: gray;
        }
        #heading {
            text-transform: uppercase;
            color: #673AB7;
            font-weight: normal;
            padding-bottom: 10px;
            border-bottom: dashed rgba(103, 58, 183, 0.2);
        }
        #msform {
            text-align: center;
            position: relative;
            padding-top: 20px;
        }
        #msform fieldset {
            background: white;
            border: 0 none;
            border-radius: 0.5rem;
            box-sizing: border-box;
            width: 100%;
            margin: 0;
            padding-bottom: 20px;
            position: relative
        }
        .form-card {
            margin-top: 10px;
            text-align: center;
            display: flex;
            flex-flow: column nowrap;
        }
        #msform fieldset:not(:first-of-type) {
            display: none
        }
        #msform input,
        #msform textarea {
            padding: 8px 15px 8px 15px;
            border: 1px solid #ccc;
            border-radius: 0px;
            margin-bottom: 25px;
            margin-top: 2px;
            width: 100%;
            box-sizing: border-box;
            font-family: montserrat;
            color: #2C3E50;
            background-color: #ECEFF1;
            font-size: 16px;
            letter-spacing: 1px
        }
        #msform input:focus,
        #msform textarea:focus {
            -moz-box-shadow: none !important;
            -webkit-box-shadow: none !important;
            box-shadow: none !important;
            border: 1px solid #673AB7;
            outline-width: 0
        }
        #msform .action-button {
            width: 100px;
            background: #673AB7;
            font-weight: bold;
            color: white;
            border: 0 none;
            border-radius: 0px;
            cursor: pointer;
            padding: 10px 5px;
            margin: 10px 0px 10px 5px;
            float: right
        }
        #msform .action-button:hover,
        #msform .action-button:focus {
            background-color: #311B92
        }
        #msform .action-button-previous {
            width: 100px;
            background: #616161;
            font-weight: bold;
            color: white;
            border: 0 none;
            border-radius: 0px;
            cursor: pointer;
            padding: 10px 5px;
            margin: 10px 5px 10px 0px;
            float: right
        }
        #msform .action-button-previous:hover,
        #msform .action-button-previous:focus {
            background-color: #000000
        }
        .card {
            z-index: 0;
            border: none;
            position: relative
        }
        .fs-title {
            font-size: 20px;
            color: #673AB7;
            margin-bottom: 30px;
            font-weight: normal;
            text-align: center;
        }
        .fs-title2{
            font-size: 20px;
            color: #673AB7;
            margin-bottom: 30px;
            font-weight: normal;
            text-align: center;
        }
        .purple-text {
            color: #673AB7;
            font-weight: normal
        }
        .fieldlabels {
            color: gray;
            text-align: left
        }
        #progressbar {
            margin-bottom: 30px;
            overflow: hidden;
            color: lightgrey
        }
        #progressbar .active {
            color: #673AB7
        }
        #progressbar li {
            list-style-type: none;
            font-size: 15px;
            width: 25%;
            float: left;
            position: relative;
            font-weight: 400
        }
        #progressbar #date:before {
            font-family: FontAwesome;
            font-size: small;
            content: "step1"
        }
        #progressbar #seat:before {
            font-family: FontAwesome;
            font-size: small;
            content: "step2"
        }
        #progressbar #coupon:before {
            font-family: FontAwesome;
            font-size: small;
            content: "step3"
        }
        #progressbar #payment:before {
            font-family: FontAwesome;
            font-size: small;
            content: "step4"
        }
        #progressbar li:before {
            width: 50px;
            height: 50px;
            line-height: 45px;
            display: block;
            font-size: 20px;
            color: #ffffff;
            background: lightgray;
            border-radius: 50%;
            margin: 0 auto 10px auto;
            padding: 2px
        }
        #progressbar li:after {
            content: '';
            width: 100%;
            height: 2px;
            background: lightgray;
            position: absolute;
            left: 0;
            top: 25px;
            z-index: -1
        }
        #progressbar li.active:before,
        #progressbar li.active:after {
            background: #673AB7
        }
        .fit-image {
            width: 100%;
            object-fit: cover
        }
        #datepicker{
            border-right: solid rgba(0, 0, 0, 0.1);
        }

        #round{

        }
        #posterinfo {
            width: 100px;
        }
        .form-card .row .col-8{
            display: flex;
            flex-wrap: nowrap;
            justify-content: center;
        }
        .form-card .row .col-4{
            display: flex;
            width: 100%;
            justify-content: center;
            flex-flow: column nowrap;

        }
        .select-seat{
            display: flex;
            width: 70%;
            flex-flow: column nowrap;
        }
        #stage{
            width: 100%;
            color: white;
        }
        .seats{
            display: flex;
            flex-wrap: nowrap;
        }

        .seats span{
            width: 20px;
            height: 20px;
            margin: 0 5px 10px 0;
        }
        .selected-seats.head{
            text-align: center;
            height: 10%;

        }
        .selected-seats{
            height: 60%;
            border-left: solid 0.5px #673AB7;
            border-right: solid 0.5px #673AB7;
            border-top: solid 0.5px #673AB7;
        }
        .selected-seats p{
            margin: 0;
            height: 25px;
        }
        .selected-price.head{
            text-align: center;
            height: 10%;
            border-bottom: none;

        }
        .selected-price{
            height: 20%;
            border-left: solid 0.5px #673AB7;
            border-right: solid 0.5px #673AB7;
            border-top: solid 0.5px #673AB7;
            border-bottom: solid 0.5px #673AB7;
        }
        #ss span{
            height: 25px;
            margin-bottom: 5px;
        }
    </style>

<%--  그리드 컨테이너   --%>

<%--  그리드 아이템    --%>
</head>
<body>

<!-- Horizontal Steppers -->
<div class="container-fluid">
    <div class="row justify-content-center" >
        <div class="col-11 col-sm-9 col-md-7 col-lg-6 col-xl-5 text-center p-0 mt-3 mb-2">
            <div class="card px-0 pt-4 pb-0 mt-3 mb-3">
                <h2 id="heading">예매하기</h2>
                <div class="row align-items-center mb-1">
                    <div class="col-4">
                        <%-- 이미지 들어갈 자리--%>
                        <img id="posterinfo" src='/resources/img/viewdetail/testposter.jpg'/>
                    </div>
                    <div class="col-8 text-left">
                        <table class="table table-borderless">
                            <tbody>
                            <tr>
                                <th scope="row" style="width: 30%">공연명</th>
                                <%--데이터 받아오기: playname --%>
                                <td>나는 오늘도 혼자 산다</td>
                            </tr>
                            <tr>
                                <th scope="row">공연일시</th>
                                <%-- 데이터 받아오기: showing_info, showing_day--%>
                                <td>조영상</td>
                            </tr>
                            <tr>
                                <th scope="row">공연장</th>
                                <%--데이터 받아오기: stagename --%>
                                <td>쉼표도서관</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <form id="msform">
                    <!-- progressbar -->
                    <ul id="progressbar">
                        <li class="active" id="date"><strong>일정선택</strong></li>
                        <li id="seat"><strong>좌석선택</strong></li>
                        <li id="coupon"><strong>할인/쿠폰</strong></li>
                        <li id="payment"><strong>결제방법</strong></li>
                    </ul>
                    <fieldset>
                        <div class="form-card">
                            <div class="row">
                                <div class="col-7">
                                    <h3 class="fs-title">날짜선택</h3>
                                </div>
                                <div class="col-5">
                                    <h3 class="fs-title2">회차선택</h3>
                                </div>
                            </div>
                            <div class="calendar row">
                                <div id="datepicker" class="col-7"></div>
                                <div id="round" class="col-5">
<%--                                    회차 들어갈 자리--%>
                                    <div class="shadow p-2 mb-2 bg-white rounded">1회 오후 1시 00분</div>
                                    <div class="shadow p-2 mb-2 bg-white rounded">2회 오후 4시 30분</div>
                                    <div class="shadow p-2 mb-2 bg-white rounded">3회 오후 6시 30분</div>
                                </div>
                            </div>
                        </div> <input type="button" name="next" class="next action-button" value="다음단계" />
                    </fieldset>

                    <%-- step2. 좌석선택 --%>
                    <fieldset>
                        <div class="form-card">
                            <div class="row">
                                <div class="col-12">
                                    <h2 class="fs-title">좌석선택</h2>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-8">
                                    <div class="select-seat">
                                        <div id="stage" class="shadow-sm p-1 mb-2 bg-dark rounded">STAGE</div>
                                        <div class="seats">
                                            <span>A</span>
                                            <span id="a1" class="border border-primary"></span>
                                            <span id="a2" class="border border-primary"></span>
                                            <span id="a3" class="border border-primary"></span>
                                            <span id="a4" class="border border-primary"></span>
                                            <span id="a5" class="border border-primary"></span>
                                            <span id="a6" class="border border-primary"></span>
                                            <span id="a7" class="border border-primary"></span>
                                            <span id="a8" class="border border-primary"></span>
                                            <span id="a9" class="border border-primary"></span>
                                            <span id="a10" class="border border-primary"></span>
                                        </div>
                                        <div class="seats">
                                            <span>B</span>
                                            <span id="b1" class="border border-primary"></span>
                                            <span id="b2" class="border border-primary"></span>
                                            <span id="b3" class="border border-primary"></span>
                                            <span id="b4" class="border border-primary"></span>
                                            <span id="b5" class="border border-primary"></span>
                                            <span id="b6" class="border border-primary"></span>
                                            <span id="b7" class="border border-primary"></span>
                                            <span id="b8" class="border border-primary"></span>
                                            <span id="b9" class="border border-primary"></span>
                                            <span id="b10" class="border border-primary"></span>
                                        </div>
                                        <div class="seats">
                                            <span>C</span>
                                            <span id="c1" class="border border-primary"></span>
                                            <span id="c2" class="border border-primary"></span>
                                            <span id="c3" class="border border-primary"></span>
                                            <span id="c4" class="border border-primary"></span>
                                            <span id="c5" class="border border-primary"></span>
                                            <span id="c6" class="border border-primary"></span>
                                            <span id="c7" class="border border-primary"></span>
                                            <span id="c8" class="border border-primary"></span>
                                            <span id="c9" class="border border-primary"></span>
                                            <span id="c10" class="border border-primary"></span>
                                        </div>
                                        <div class="seats">
                                            <span>D</span>
                                            <span id="d1" class="border border-primary"></span>
                                            <span id="d2" class="border border-primary"></span>
                                            <span id="d3" class="border border-primary"></span>
                                            <span id="d4" class="border border-primary"></span>
                                            <span id="d5" class="border border-primary"></span>
                                            <span id="d6" class="border border-primary"></span>
                                            <span id="d7" class="border border-primary"></span>
                                            <span id="d8" class="border border-primary"></span>
                                            <span id="d9" class="border border-primary"></span>
                                            <span id="d10" class="border border-primary"></span>
                                        </div>
                                        <div class="seats">
                                            <span>E</span>
                                            <span id="e1" class="border border-primary"></span>
                                            <span id="e2" class="border border-primary"></span>
                                            <span id="e3" class="border border-primary"></span>
                                            <span id="e4" class="border border-primary"></span>
                                            <span id="e5" class="border border-primary"></span>
                                            <span id="e6" class="border border-primary"></span>
                                            <span id="e7" class="border border-primary"></span>
                                            <span id="e8" class="border border-primary"></span>
                                            <span id="e9" class="border border-primary"></span>
                                            <span id="e10" class="border border-primary"></span>
                                        </div>
                                        <div class="seats">
                                            <span>F</span>
                                            <span id="f1" class="border border-primary"></span>
                                            <span id="f2" class="border border-primary"></span>
                                            <span id="f3" class="border border-primary"></span>
                                            <span id="f4" class="border border-primary"></span>
                                            <span id="f5" class="border border-primary"></span>
                                            <span id="f6" class="border border-primary"></span>
                                            <span id="f7" class="border border-primary"></span>
                                            <span id="f8" class="border border-primary"></span>
                                            <span id="f9" class="border border-primary"></span>
                                            <span id="f10" class="border border-primary"></span>
                                        </div>
                                        <div class="seats">
                                            <span>G</span>
                                            <span id="g1" class="border border-primary"></span>
                                            <span id="g2" class="border border-primary"></span>
                                            <span id="g3" class="border border-primary"></span>
                                            <span id="g4" class="border border-primary"></span>
                                            <span id="g5" class="border border-primary"></span>
                                            <span id="g6" class="border border-primary"></span>
                                            <span id="g7" class="border border-primary"></span>
                                            <span id="g8" class="border border-primary"></span>
                                            <span id="g9" class="border border-primary"></span>
                                            <span id="g10" class="border border-primary"></span>
                                        </div>
                                        <div class="seats">
                                            <span>H</span>
                                            <span id="h1" class="border border-primary"></span>
                                            <span id="h2" class="border border-primary"></span>
                                            <span id="h3" class="border border-primary"></span>
                                            <span id="h4" class="border border-primary"></span>
                                            <span id="h5" class="border border-primary"></span>
                                            <span id="h6" class="border border-primary"></span>
                                            <span id="h7" class="border border-primary"></span>
                                            <span id="h8" class="border border-primary"></span>
                                            <span id="h9" class="border border-primary"></span>
                                            <span id="h10" class="border border-primary"></span>
                                        </div>

                                    </div>
                                </div>
                                <div class="col-4">
                                    <div class="selected-seats head">
                                        <p>선택좌석내역</p>
                                    </div>
                                    <div id="ss" class="selected-seats">
                                        <span>a7</span>
                                        <span>a5</span>
                                        <span>a2</span>
                                        <span>b10</span>
                                        <span>d3</span>
                                        <span>d4</span>
                                        <span>f9</span>
                                        <span>h2</span>
                                        <span>g1</span>
                                        <span>g2</span>
                                    </div>
                                    <div class="selected-price head">
                                        <p>선택좌석가격</p>
                                    </div>
                                    <div class="selected-price"></div>
                                </div>

                            </div>
                        </div> <input type="button" name="next" class="next action-button" value="다음단계" /> <input type="button" name="previous" class="previous action-button-previous" value="이전단계" />
                    </fieldset>
                    <fieldset>
                        <div class="form-card">
                            <div class="row">
                                <div class="col-12">
                                    <h2 class="fs-title">쿠폰/할인</h2>
                                </div>
                            </div>
                        </div> <input type="button" name="next" class="next action-button" value="다음단계" /> <input type="button" name="previous" class="previous action-button-previous" value="이전단계" />
                    </fieldset>
                    <fieldset>
                        <div class="form-card">
                            <div class="row">
                                <div class="col-12">
                                    <h2 class="fs-title">결제방법</h2>
                                </div>
                            </div> <br><br>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>




<%--<script type="text/javascript" src="/resources/js/viewdetail/jquery-ui.min.js"></script>--%>
</body>



<%--    datepicker --%>
<script>
    $(document).ready(function(){
        let current_fs, next_fs, previous_fs; //fieldsets
        let opacity;
        let current = 1;
        let steps = $("fieldset").length;

        $(".next").click(function(){
            current_fs = $(this).parent();
            next_fs = $(this).parent().next();
//Add Class Active
            $("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
//show the next fieldset
            next_fs.show();
//hide the current fieldset with style
            current_fs.animate({opacity: 0}, {
                step: function(now) {
// for making fielset appear animation
                    opacity = 1 - now;
                    current_fs.css({
                        'display': 'none',
                        'position': 'relative'
                    });
                    next_fs.css({'opacity': opacity});
                },
                duration: 500
            });

        });
        $(".previous").click(function(){
            current_fs = $(this).parent();
            previous_fs = $(this).parent().prev();
//Remove class active
            $("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");
//show the previous fieldset
            previous_fs.show();
//hide the current fieldset with style
            current_fs.animate({opacity: 0}, {
                step: function(now) {
// for making fielset appear animation
                    opacity = 1 - now;
                    current_fs.css({
                        'display': 'none',
                        'position': 'relative'
                    });
                    previous_fs.css({'opacity': opacity});
                },
                duration: 500
            });

        });

        $(".submit").click(function(){
            return false;
        })
    });
</script>
<script>
    $(document).ready(function() {
        let availableDates = ["2024-02-11", "2024-02-12"];
        $("#datepicker").datepicker({
            //오늘부터 날짜 선택 가능하도록 함
            minDate: 0,
            //최대 선택 가능한 날짜는 1년
            maxDate: "1Y",
            //특정일만 선택하게한다
            beforeShowDay: function (date) {
                var thismonth = date.getMonth() + 1;
                var thisday = date.getDate();

                if (thismonth < 10) {
                    thismonth = "0" + thismonth;
                }
                if (thisday < 10) {
                    thisday = "0" + thisday;
                }

                ymd = date.getFullYear() + "-" + thismonth + "-" + thisday;

                if ($.inArray(ymd, availableDates) >= 0) {
                    return [true, "", ""];
                } else {
                    return [false, "", ""];
                }
            },
            // 일자 선택된 후 이벤트 발생
            onSelect: function (dateText) {
                var left = document.querySelector('.fourLeft');
                var right = document.querySelector('.fourRight');

                // 달력에 있는 날짜 누르면 left, right css 오프됨
                left.classList.remove('off');
                right.classList.remove('on');

                //dateText날짜가 DB에 저장된 회차테이블의 회차일시와 같으면 a태그 생성
                // ajax를 통해 컨트롤러로 dateText 보냄
                $.ajax({
                    type: "POST",
                    url: "/ticketing-detail",
                    data: dateText,
                    // 태그를 만들어서 가져올 순 없고 컨트롤러에서 메세지를 리턴해서 가져옴,
                    // 가져온 메세지(msg)를 이용해서 a태그 만들것
                    success: function(res) {
                        //a태그 생성 이벤트
                        // 1. ajax로 dateTaxt를 컨트롤러로 보냄,
                        // 2. 컨트롤러에서 dateTaxt를 이용해서 sql문을 돌려서 나온 결과를 msg로 리턴함 res로 받음 (배열)
                        // 3. 리턴받은 res를 사용해서 a태그를 만듦

                        var showing = document.querySelector('#round');

                        //.showing 안에 있는 요소들 지우기 (태그 쌓임 방지)
                        while(showing.firstChild)  {
                            showing.removeChild(showing.firstChild);
                        }

                        // .showing 안에 a태그 만들어주기
                        for(var i = 0;i<res.length;i++) {
                            var aTag = document.createElement("a");
                            aTag.append(res[i]);

                            showing.appendChild(aTag);
                            aTag.className = 'aTag';
                            aTag.href = 'javascript:void(0);';
                        }

                        // 생성한 a태그 클릭했을때 클래스이름 aTag clicked으로 바꾸기
                        var aTags = document.querySelectorAll('.aTag');
                        aTags.forEach(function(aTag) {
                            aTag.addEventListener('click', function() {
                                // forEach를 한번 더 돌려서 클릭한 태그 이외의 다른 태그의 클래스명에 clicked가 있다면 지움
                                aTags.forEach(function(tag) {
                                    if (tag !== aTag) {
                                        tag.classList.remove('clicked');
                                    }
                                });
                                // 클릭한 태그의 클래스명 토글
                                this.classList.toggle('clicked');

                                // 선택한 a태그의 클래스이름이 aTag과 똑같지 않으면 해당 태그의 아이디를 바꿈, 아니면 없앰
                                if(aTag.className !== 'aTag'){
                                    this.id = 'clicked';
                                } else {
                                    this.id = '';
                                }

                                //fourLeft클래스(left)와 fourRight클래스(right) 상태 on/off

                                if(aTag.id==='clicked') {
                                    left.classList.add('off');
                                    right.classList.add('on');
                                } else if (aTag.id!=='clicked') {
                                    left.classList.remove('off');
                                    right.classList.remove('on');
                                }
                            });
                        });
                    },
                    error: function( error ){
                        console.log('error => ', error)
                    }
                });
            }
        })
    })
    $.datepicker.setDefaults({
        dateFormat: 'yy-mm-dd',
        prevText: '이전 달',
        nextText: '다음 달',
        monthNames: ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12'],
        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
        showMonthAfterYear: true,
        yearSuffix: '.',
    });
</script>
</html>
