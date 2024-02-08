// <%--    datepicker 제이쿼리 달력--%>
    $(document).ready(function() {

        var availableDates = ["2024-02-10", "2024-02-11"]; //선택 가능한 날짜

        $("#datepicker").datepicker({
        //오늘부터 날짜 선택 가능하도록 함
        minDate: 0,
        //최대 선택 가능한 날짜는 1년
        maxDate: "1Y",
        //특정일만 선택하게한다
        beforeShowDay: function (date) {
            var thismonth = date.getMonth()+1;
            var thisday = date.getDate();

            if(thismonth<10){
                thismonth = "0"+thismonth;
            }
            if(thisday<10){
                thisday = "0"+thisday;
            }

            ymd = date.getFullYear() + "-" + thismonth + "-" + thisday;

            if ($.inArray(ymd, availableDates) >= 0) {
                return [true,"",""];
            } else {
                return [false,"",""];
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
                    url: "/viewdetail",
                    data: dateText,
                    // 태그를 만들어서 가져올 순 없고 컨트롤러에서 메세지를 리턴해서 가져옴,
                    // 가져온 메세지(msg)를 이용해서 a태그 만들것
                    success: function(res) {
                        //a태그 생성 이벤트
                        // 1. ajax로 dateTaxt를 컨트롤러로 보냄,
                        // 2. 컨트롤러에서 dateTaxt를 이용해서 sql문을 돌려서 나온 결과를 msg로 리턴함 res로 받음 (배열)
                        // 3. 리턴받은 res를 사용해서 a태그를 만듦

                        var showing = document.querySelector('.showing');

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
    });





        // URL복사 이벤트
        var copyURL = document.getElementById('url_image');

        copyURL.onclick = function () {
            var dummy   = document.createElement("input");
            var url    = location.href;

            document.body.appendChild(dummy);
            dummy.value = url;
            dummy.select();
            document.execCommand("copy");
            document.body.removeChild(dummy);
            alert('주소가 복사되었습니다.');
        }

        // 스크롤 이동 이벤트
        var stagename = document.getElementById('stage_name');
        var movemap = document.getElementById('map');

        stagename.onclick = function () {
            movemap.scrollIntoView();
        }

    });

    // datepicker 설정
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
    yearSuffix: '.'
});
    // datepicker 제이쿼리 달력 끝


    //카카오맵 스크립트
    new daum.roughmap.Lander({
    "timestamp" : "1707022341823",
    "key" : "2hy9x",
    "mapWidth" : "1200",
    "mapHeight" : "700"
}).render();


