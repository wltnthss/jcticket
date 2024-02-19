// step.1 일정선택
$(document).ready(function() {
    var dateShow = document.querySelectorAll(".dateShow");

    //선택 가능한 날짜 ex)
    // var availableDates = ["2024-02-28", "2024-02-29"];
    var availableDates = [];
    for (var i = 0; i < dateShow.length; i++) {
        availableDates.push(dateShow[i].innerHTML);
    }

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
            //콜백함수사용,ticketing으로 보낼 데이터
            dateTextCallback(dateText)

            var left = document.querySelector('.fourLeft');
            var right = document.querySelector('.fourRight');

            // 잔여석 삭제
            var existSpan = document.querySelector("#seatPrice1 > span.remain_seat");
            var spanRemove = document.querySelector("#seatPrice1");
            if (existSpan != null) {
                spanRemove.removeChild(spanRemove.lastChild);
            }

            // 달력에 있는 날짜 누르면 left, right css 오프됨
            left.classList.remove('off');
            right.classList.remove('on');

            //dateText날짜가 DB에 저장된 회차테이블의 회차일시와 같으면 a태그 생성
            // ajax를 통해 컨트롤러로 dateText 보냄
            $.ajax({
                type: "POST",
                url: "/viewdetail",
                data: dateText,
                // 태그를 만들어서 가져올 순 없고 컨트롤러에서 메세지를 리턴해서 가져옴,
                // 가져온 메세지(msg)를 이용해서 a태그 만들것
                success: function (res) {
                    //a태그 생성 이벤트
                    // 1. ajax로 dateTaxt를 컨트롤러로 보냄,
                    // 2. 컨트롤러에서 dateTaxt를 이용해서 sql문을 돌려서 나온 결과를 msg로 리턴함 res로 받음 (배열)
                    // 3. 리턴받은 res를 사용해서 a태그를 만듦

                    // alert(res);

                    var showing = document.querySelector('.showing');

                    //.showing 안에 있는 요소들 지우기 (태그 쌓임 방지)
                    while (showing.firstChild) {
                        showing.removeChild(showing.firstChild);
                    }

                    // .showing 안에 a태그 만들어주기
                    for (var i = 0; i < res.length; i++) {
                        var aTag = document.createElement("a");
                        aTag.append(res[i].showing_info);
                        showing.appendChild(aTag);
                        aTag.className = 'aTag';
                        aTag.id = res[i].showing_seq;
                        aTag.href = 'javascript:void(0);';
                    }

                    // 생성한 a태그 클릭했을때 클래스이름 aTag clicked으로 바꾸기
                    var aTags = document.querySelectorAll('.aTag');
                    aTags.forEach(function (aTag) {
                        aTag.addEventListener('click', function () {
                            // forEach를 한번 더 돌려서 클릭한 태그 이외의 다른 태그의 클래스명에 clicked가 있다면 지움
                            // 선택한 a태그의 클래스이름이 aTag과 똑같지 않으면 해당 태그의 클래스이름을 없앰
                            aTags.forEach(function (tag) {
                                if (tag !== aTag) {
                                    tag.classList.remove('clicked');
                                }
                            });
                            // 클릭한 태그의 클래스명 토글
                            this.classList.toggle('clicked');


                            //fourLeft클래스(left)와 fourRight클래스(right) 상태 on/off
                            if (aTag.classList.contains('clicked')) {
                                left.classList.add('off');
                                right.classList.add('on');
                            } else {
                                left.classList.remove('off');
                                right.classList.remove('on');
                            }
                        });
                    });
                },
                error: function (error) {
                    console.log('error => ', error)
                }
            });
        }
    });
})


// 팝업창 제어
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