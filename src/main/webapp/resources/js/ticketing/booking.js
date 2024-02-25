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
                url: "/ticketing-detail",
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
    let current_fs, next_fs, previous_fs; //fieldsets
    let opacity;
    let current = 1;
    let steps = $("fieldset").length;

    $(".next").click(function(){
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