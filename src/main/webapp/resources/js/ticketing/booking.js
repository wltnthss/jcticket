// step.1 일정선택
$(document).ready(function() {
    let dateShow = $(".dateShow");
    //선택 가능한 날짜 ex)
    // var availableDates = ["2024-02-28", "2024-02-29"];
    let availableDates = [];
    for (let i = 0; i < dateShow.length; i++) {
        availableDates.push(dateShow[i].innerHTML);
    }

    $("#datepicker").datepicker({
        //오늘부터 날짜 선택 가능하도록 함
        minDate: 0,
        //최대 선택 가능한 날짜는 1년
        maxDate: "1Y",
        //특정일만 선택하게한다
        beforeShowDay: function (date) {
            let thismonth = date.getMonth() + 1;
            let thisday = date.getDate();

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
            //콜백함수사용,ticketing으로 보낼 데이터
            //dateTextCallback(dateText)
            console.log("=======onSelect 실행=======")
            // ajax를 통해 Map으로 전송할 데이터 셋팅하기
            const reqData = {
                'play_id': $("#play_id").val(),
                'date_text': dateText
            };

            //dateText날짜가 DB에 저장된 회차테이블의 회차일시와 같으면 a태그 생성
            // ajax를 통해 컨트롤러로 dateText 보냄 -->
            $.ajax({
                type: "POST",
                url: "/ticketing/detail",
                data: JSON.stringify(reqData),
                contentType : 'application/json; charset=utf-8',
                // 태그를 만들어서 가져올 순 없고 컨트롤러에서 메세지를 리턴해서 가져옴,
                // 가져온 메세지(msg)를 이용해서 a태그 만들것
                success: function (resMap) {
                    console.log(resMap);
                    //a태그 생성 이벤트
                    // 1. ajax로 reqData(map)를 컨트롤러로 보냄,
                    // 2. 컨트롤러에서 reqData를 이용해서 sql문을 돌려서 나온 결과를 res로 리턴함
                    // 3. 리턴받은 arrayList를 사용해서 div,a태그를 만들기

                    const round = $("#round");
                    // res를 arrayList로 변환
                    // const arrayList = res;
                    const seqList = resMap.showing_seq;
                    const infoList = resMap.showing_info;
                    //const showing = document.querySelector('.showing');


                    //.round 안에 있는 요소들 지우기 (태그 쌓임 방지)
                    round.empty();
                    console.log("a Tag removed");
                    console.log(`resMap ==> ${resMap}`);
                    console.log(`seqList ==> ${seqList}`);
                    console.log(`infoList ==> ${infoList}` );

                    // bootstrap 으로 감싸서 a 태그를 생성하는 코드
                    $.each(infoList, function (i, item){
                        const divTag = $("<div></div>")
                            .addClass("shadow p-2 mb-2 rounded box")
                            .appendTo(round);
                        console.log("======divTag generated======");
                        console.log("infoList ==> "+ infoList[i]);
                        const aTag = $("<a></a>")
                            .append(item)
                            .addClass('aTag')
                            .attr('id', seqList[i])
                            .attr('href', 'javascript:void(0);')
                            .appendTo(divTag);
                        console.log("======aTag generated======");
                    });

                    // 클릭했을때 div태그 배경색 바꾸기 & a태그 글자색 바꾸기
                    $('.aTag').click(function() {
                        let $clickedTag = $(this);$('.aTag').not($clickedTag).removeClass('clicked').css('color','').closest('.box').css('background-color', 'white');
                        $clickedTag.toggleClass('clicked').css('color','white').closest('.box').css('background-color', '#673AB7');
                        //$('.box').css('background-color', 'blue');
                    });
                },
                error: function (error) {

                    console.log('error => ', error)
                }
            });
        }
    });
})


// 팝업창 제어하는 부분.
$(document).ready(function(){
    const selectedSeatList = [];
    let selectedPrice = 0;
    $(".next").click(function(){
        let current_fs, next_fs, previous_fs; //fieldsets
        let opacity;
        let current = 1;
        let steps = $("fieldset").length;
        current_fs = $(this).parent();
        next_fs = $(this).parent().next();
        //Add Class Active
        $("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
        //다음단계 넘어가기
        next_fs.show();
        //현재 단계 태그, 스타일 숨기기
        current_fs.animate({opacity: 0}, {
            step: function(now) {
        // 다음단계 넘어갈때 애니메이션 적용하기
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
    // 일정선택 후 다음단계 눌렀을때 발생하는 이벤트
    //
    $("#first-bnt").click(function(){
        //selectedSeatList.splice(0,selectedSeatList.length);
        // 선택한 좌석 관련 정보들 초기화
        selectedPrice = 0;
        selectedSeatList.length = 0;

        // ajax에 json 으로 보낼 데이터 생성
        const data1 = {
            'showing_seq': $(".aTag.clicked").attr("id"),
        }
        console.log("seq => "+data1.showing_seq);

        // ajax 요청을 컨트롤러로 보낸다.
        $.ajax({
            url: "detail/seat",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(data1),
            success: function (res) {

                // 컨트롤러에서 받아온 응답으로 부터 사용할 데이터를 변수에 저장한다.
                const seatIdList = res.seat_id;
                const statusList = res.seat_status;
                const endRowNum = res.end_row;
                const endColNum = res.end_col;
                const seatPrice = res.seat_price;
                console.log("seatIdList => " + seatIdList);
                console.log("statusList => " + statusList);
                console.log("endRowNum => " + endRowNum);
                console.log("endColNum => " + endColNum);
                console.log("seatPrice => " + seatPrice);

                // 동적으로 seats - span - a 태그를 생성한다.
                // 만들어야 할 태그의 형태 >>
                const seatsArea = $("#seatsArea");
                seatsArea.empty();
                console.log("== seatsArea Tag removed ===");
                const divTag = $("<div></div>")
                    .attr("id", "stage")
                    .addClass("shadow-sm p-1 mb-2 bg-dark rounded")
                    .append("STAGE")
                    .appendTo(seatsArea);
                console.log("===== #stage 태그 생성 =====")
                for (let i = 0; i < endRowNum; i++) {
                    const divSeatsTag = $("<div></div>")
                        .addClass("seats")
                        .appendTo(seatsArea);
                    console.log("===== .seats 태그 생성 "+(i+1)+" =====");
                }

                // 선택 좌석, 가격 정보를 표시하는 태그를 초기화하기.
                const seats = $(".seats");
                seats.empty();
                $("#ss").empty();
                $("#sp").empty();
                console.log("seats Tag removed");

                // 좌석태그를 동적으로 만들어 화면에 표시한다.
                seats.each(function(i){
                    // 행을 표시하기 위한 반복문
                    const currentSeats = $(this);
                    let asciiVal = 'A'.charCodeAt(0) + i;
                    let rowChar = String.fromCharCode(asciiVal);
                    const spanTag = $("<span></span>")
                        .append(rowChar)
                        .appendTo(currentSeats);
                    for (let j = 0; j < endColNum; j++) {
                    // 열을 표시하기 위한 반복문
                        const spanTag = $("<span></span>")
                            .attr("id", seatIdList[endColNum * i + j])
                            .addClass("border border-primary")
                            .appendTo(currentSeats);

                        // 예매상태가 N이면 클릭이 불가하다.
                        if(statusList[endColNum * i + j] === "N"){
                            spanTag.addClass("disabled");
                        }
                        console.log("===== "+(endColNum*i+j)+"번 좌석 생성 =====");
                    }
                })

                // 마우스를 좌석에 올려놨을때 이벤트.
                $("span.border-primary").hover(
                    function() {
                        // 마우스를 올렸을 때 포인터 커서로 변경
                        $(this).css("cursor", "pointer");
                    },
                    function() {
                        // 마우스를 벗어났을 때 기본 커서로 변경
                        $(this).css("cursor", "auto");
                    }
                );
                $(".disabled").off("click").css("background-color", "gray");

                // 클릭 이벤트를 추가하여 클릭 가능하도록 설정
                $("span.border-primary").click(function() {
                    // 이미 예약된 좌석은 이벤트를 발생시키지 않는다.
                    if ($(this).hasClass("disabled")) {
                        return false; // 클릭 이벤트를 처리하지 않음
                    }
                    // 클릭 이벤트 처리 코드를 작성한다.
                    if($(this).hasClass("clicked")){
                        // 이미 클릭된 경우 클릭을 해제한다.
                        $(this).removeClass("clicked");
                        const thisId = $(this).attr("id");
                        const index = selectedSeatList.indexOf(thisId);
                        // 선탹좌석 리스트에 현재 좌석ID가 들어있는 경우
                        if(index !== -1){
                            selectedSeatList.splice(index, 1);
                            selectedPrice = selectedSeatList.length * seatPrice;
                        }
                        $("#ss").text(selectedSeatList.join(", "));
                        $("#sp").text(seatPrice+"원 x "+selectedSeatList.length+"석 >> "+selectedPrice+"원");
                        console.log(`해제한 좌석의 ID => ${thisId}`);
                        console.log(selectedSeatList + " 리스트 길이 :"+selectedSeatList.length);
                        console.log(`가격 => ${selectedPrice}`);
                    }else {
                        // 클릭하는 경우 clicked 상태가 된다.
                        $(this).addClass("clicked");
                        let thisId = $(this).attr("id");
                        selectedSeatList.push(thisId);
                        selectedPrice = selectedSeatList.length * seatPrice;
                        $("#ss").text(selectedSeatList.join(", "));
                        $("#sp").text(seatPrice+"원 x "+selectedSeatList.length+"석 >> "+selectedPrice+"원");
                        console.log(`선택된 좌석의 ID => ${thisId}`);
                        console.log(selectedSeatList + " 리스트 길이 :"+selectedSeatList.length);                    }
                        console.log(`가격 => ${selectedPrice}`);
                });
            },
            // ajax 응답 실패시 예외처리
            error: function (error) {
                alert(`${error.status} error! 회차를 선택해 주세요! `);
                console.log("error => "+ error.body + error.status);
                // 처음 선택으로 돌아가기 위해 새로고침 한다.
                location.reload();
            }
        })
    })

    // 좌석선택 후 다음단계 버튼 클릭했을 때 쿠폰선택 화면
    $("#second-btn").click(function (){
        // 데이터가 잘 넘어왔나 확인한다.
        console.log(`selectedSeatList => ${selectedSeatList}`);
        console.log(`selectedPrice => ${selectedPrice}`);

        // 쿠폰조회 버튼 클릭시 ajax 에 넘길 데이터 구성하기
        // 넘길때 필요한 정보 = {유저아이디, 쿠폰아이디}
        // 받아와야 하는 정보 = {쿠폰할인금액, 쿠폰, 유저쿠폰 아이디}

        const userId = $("#user_id").val();
        $.ajax({
            url: "detail/coupon", // 요청을 보낼 URL
            type: "GET", // 요청 방식 (GET, POST 등)
            data: {
                // 요청에 포함할 데이터
                userId: userId
            },
            success: function(response) {
                // 요청이 성공했을 때의 처리
                console.log("Success:", response);
                console.log("list[0]", response[0]);


            },
            error: function(error) {
                // 요청이 실패했을 때의 처리
                console.log("Error:", error.status);
            }
        });


        // 쿠폰조회 버튼 클릭시 ajax 요청 전송하기


    })


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

// jquery 캘린더 설정
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