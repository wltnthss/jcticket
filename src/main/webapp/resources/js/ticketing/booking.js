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
                success: function (res) {
                    //a태그 생성 이벤트
                    // 1. ajax로 dateTaxt를 컨트롤러로 보냄,
                    // 2. 컨트롤러에서 dateTaxt를 이용해서 sql문을 돌려서 나온 결과를 msg로 리턴함 res로 받음 (배열)
                    // 3. 리턴받은 res를 사용해서 a태그를 만듦

                    // alert(res);
                    console.log("response ==> "+res);
                    const round = $("#round");
                    const arrayList = res;
                    console.log("roundList ==> "+ arrayList);
                    //const showing = document.querySelector('.showing');


                    //.round 안에 있는 요소들 지우기 (태그 쌓임 방지)
                    // while (round.firstChild){
                    //     round.removeChild(round.firstChild);
                    // }
                    $('#round').empty();
                    console.log("a Tag removed");
                    // bootstrap 으로 감싸서 a 태그를 생성하는 코드
                    $.each(arrayList, function (i, item){
                        const divTag = $("<div></div>")
                            .addClass("shadow p-2 mb-2 rounded box")
                            .appendTo(round);
                        console.log("======divTag generated======");
                        const aTag = $("<a></a>")
                            .append(item)
                            .addClass('aTag')
                            .attr('id', i)
                            .attr('href', 'javascript:void(0);')
                            .appendTo(divTag);
                        console.log("======aTag generated======");
                    });


                    // $.each(arrayList, function(i, item) {
                    //     const aTag = $("<a></a>");
                    //     aTag.append(item);
                    //     aTag.appendTo(round);
                    //     aTag.addClass('aTag');
                    //     aTag.attr('id', i);
                    //     aTag.attr('href', 'javascript:void(0);');
                    //     console.log("a Tag generated")
                    // });


                    // 생성한 a태그 클릭했을때 클래스이름 aTag clicked으로 바꾸기
                    // const aTags = $('.aTag');
                    // aTags.forEach(function (aTag) {
                    //     aTag.addEventListener('click', function () {
                    //         // forEach를 한번 더 돌려서 클릭한 태그 이외의 다른 태그의 클래스명에 clicked가 있다면 지움
                    //         // 선택한 a태그의 클래스이름이 aTag과 똑같지 않으면 해당 태그의 클래스이름을 없앰
                    //         aTags.forEach(function (tag) {
                    //             if (tag !== aTag) {
                    //                 tag.classList.remove('clicked');
                    //             }
                    //         });
                    //         // 클릭한 태그의 클래스명 토글
                    //         this.classList.toggle('clicked');
                    //     });
                    // });
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