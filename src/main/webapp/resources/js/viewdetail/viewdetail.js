// <%--    datepicker 제이쿼리 달력--%>
    $(document).ready(function() {
    var disabledDates = ["2024-02-20", "2024-02-21", "2024-02-22"]; // 선택 못하게 막을 날짜 배열

        $("#datepicker").datepicker({
        //오늘부터 날짜 선택 가능하도록 함
        minDate: 0,
        //최대 선택 가능한 날짜는 1년
        maxDate: "1Y",
        //특정일 선택 못하게 막음

            beforeShowDay: function(date) {
                var dateString = $.datepicker.formatDate('yy-mm-dd', date);
                return [disabledDates.indexOf(dateString) === -1]; // 선택 가능한 날짜는 true, 선택 불가능한 날짜는 false

                // var isDisabled = disabledDates.indexOf(dateString) !== -1;
                // return [!isDisabled, isDisabled ? 'disabled-date' : 'abled-date']; // 선택 가능한 날짜는 true, 선택 불가능한 날짜는 false 및 'disabled-date' 클래스 추가
            },

            // 일자 선택된 후 이벤트 발생
            onSelect: function (dateText, inst) {
                alert(dateText+'입니다');
                //dateText날짜가 DB에 저장된 회차테이블의 회차일시와 같으면 a태그 생성

                var testparent = document.querySelector('.showing');

                testparent.insertAdjacentHTML('afterbegin', "<a>"+dateText+"</a>");
            }
    });
});

    // datepicker 설정
    $.datepicker.setDefaults({
    dateFormat: 'yy.mm.dd',
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


window.onload = function () {
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

}