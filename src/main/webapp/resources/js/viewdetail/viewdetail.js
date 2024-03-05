// <%--    datepicker 제이쿼리 달력--%>
    $(document).ready(function() {
        var play_id = document.querySelector('.five').id;
        var dateShow = document.querySelectorAll(".dateShow");

        //선택 가능한 날짜 ex)
        // var availableDates = ["2024-02-28", "2024-02-29"];
        var availableDates = [];
        for(var i=0;i<dateShow.length;i++){
            availableDates.push(dateShow[i].innerHTML);
        }

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
            //콜백함수사용,ticketing으로 보낼 데이터
            dateTextCallback(dateText)



            // console.log('play_id =======>'+play_id);

            var left = document.querySelector('.fourLeft');
            var right = document.querySelector('.fourRight');

            // 잔여석 삭제
            var existSpan = document.querySelector("#seatPrice1 > span.remain_seat");
            var spanRemove = document.querySelector("#seatPrice1");
            if(existSpan!=null){
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
                data: {dateText:dateText,play_id:play_id},
                // 태그를 만들어서 가져올 순 없고 컨트롤러에서 메세지를 리턴해서 가져옴,
                // 가져온 메세지(msg)를 이용해서 a태그 만들것
                success: function(res) {
                    //a태그 생성 이벤트
                    // 1. ajax로 dateTaxt를 컨트롤러로 보냄,
                    // 2. 컨트롤러에서 dateTaxt를 이용해서 sql문을 돌려서 나온 결과를 msg로 리턴함 res로 받음 (배열)
                    // 3. 리턴받은 res를 사용해서 a태그를 만듦

                    // alert("res ========>"+res);

                    var showing = document.querySelector('.showing');

                    //.showing 안에 있는 요소들 지우기 (태그 쌓임 방지)
                    while(showing.firstChild)  {
                        showing.removeChild(showing.firstChild);
                    }

                    // .showing 안에 a태그 만들어주기
                    for(var i = 0;i<res.length;i++) {
                        var aTag = document.createElement("a");
                        aTag.append(res[i].showing_info);
                        showing.appendChild(aTag);
                        aTag.className = 'aTag';
                        aTag.id = res[i].showing_seq;
                        aTag.href = 'javascript:void(0);';
                    }

                    // 생성한 a태그 클릭했을때 클래스이름 aTag clicked으로 바꾸기
                    var aTags = document.querySelectorAll('.aTag');
                    aTags.forEach(function(aTag) {
                        aTag.addEventListener('click', function() {
                            // forEach를 한번 더 돌려서 클릭한 태그 이외의 다른 태그의 클래스명에 clicked가 있다면 지움
                            // 선택한 a태그의 클래스이름이 aTag과 똑같지 않으면 해당 태그의 클래스이름을 없앰
                            aTags.forEach(function(tag) {
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
                error: function( error ){
                    console.log('error => ', error)
                }
            });
        }
    });
        // 좌석 정보 가져오기
        $(document).on("click", ".aTag", function() {
            var remainSeat = $(this).attr("id");
            $.ajax({
                type: "POST",
                url: "/viewdetail/remainSeat",
                data: remainSeat,
                success: function(res) {
                    // 서버로부터 받은 응답 데이터를 처리
                    console.log('Response:', res);
                    
                    //res내용을 span태그로 묶어서 #seatPrice1 아래 추가 (잔여석)
                    // var seatRemain = document.createElement("span");
                    // var existSpan = document.querySelector("#seatPrice1 > span.remain_seat");
                    // var insertSpan = document.querySelector("#seatPrice1");
                    //
                    // if(!existSpan) {
                    //     seatRemain.textContent = "(잔여: "+res+"석)";
                    //     seatRemain.className = 'remain_seat'
                    //     insertSpan.insertAdjacentElement('beforeend',seatRemain);
                    // } else {
                    //     while(insertSpan.firstChild)  {
                    //         insertSpan.removeChild(existSpan);
                    //         seatRemain.textContent = "(잔여: "+res+"석)";
                    //         seatRemain.className = 'remain_seat'
                    //         insertSpan.insertAdjacentElement('beforeend',seatRemain);
                    //     }
                    // }

                    var existSpan = document.querySelector("#seatPrice1 > span.remain_seat");
                    var seatRemain = document.createElement("span");
                    seatRemain.textContent = "(잔여: "+res+"석)";
                    seatRemain.className = 'remain_seat';
                    var insertSpan = document.querySelector("#seatPrice1");

                    if(!existSpan) {
                        insertSpan.appendChild(seatRemain);
                    } else {
                        insertSpan.replaceChild(seatRemain, existSpan);
                    }
                },
                error: function(error) {
                    // 서버 통신 중 발생한 오류를 처리
                    console.log('Error:', error);
                    alert('Error =' + error)
                }
            });
        })

        // for ticketing 티켓팅으로!
        //콜백함수 사용해서 dateText (선택한 날짜) 가져옴
        function dateTextCallback(dateText) {
            var for_ticket = document.querySelector(".five");

            for_ticket.onclick = function () {

                // 클릭된 .aTag가 있을 경우에만 실행
                var atag_clicked = document.querySelector(".aTag.clicked");

                if(atag_clicked != null){
                    var atag_id = document.querySelectorAll(".aTag");

                    //회차시퀀스
                    var showing_seq = null;

                    for(var i=0;i<atag_id.length;i++) {
                        showing_seq = atag_id[i].id;
                    }

                    var play_name_id = document.getElementById("for_ticketing_play_name");
                    var stage_name_id = document.getElementById("for_ticketing_stage_name");
                    //공연이름 (<오늘도 혼자 논다>-시흥)
                    var play_name = play_name_id.innerHTML;
                    //공연장이름 (인천앞바다)
                    var stage_name = stage_name_id.innerHTML;

                    //쿼리스트링 이용
                    var url = '/ticketing/detail?play_id=' + for_ticket.id
                        + 'dateText='+dateText
                        +'&showing_seq='+showing_seq
                        +'&play_name='+play_name
                        +'&stage_name='+stage_name;

                    var name = "ticketing"
                    var option = "width = 500, height = 500, top = 100, left = 200, location = no"
                    window.open(url, name, option); //성공
                    // ticketing 창 띄우기
                }
            }
        }

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


        // 카카오 지도 api
        var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
        var options = { //지도를 생성할 때 필요한 기본 옵션
            center: new kakao.maps.LatLng(37.450701, 126.570667), //지도의 중심좌표.
            level: 3 //지도의 레벨(확대, 축소 정도)
        };
        var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

        // 마커가 표시될 위치입니다
        var markerPosition  = new kakao.maps.LatLng(37.450701, 126.570667);

        // 마커를 생성합니다
        var marker = new kakao.maps.Marker({
            position: markerPosition
        });

        // 마커가 지도 위에 표시되도록 설정합니다
        marker.setMap(map);

        
        //관람후기 ajax 페이징
        // var play_id = document.querySelector('.five').id
        var pageSize = document.querySelector('.pageSize').value
        var totalPage = document.querySelector('.totalPage').value
        var endPage = parseInt(document.querySelector('.endPage').value);
        // var startPage = parseInt(document.querySelector('.startPage').value);

        // console.log(totalPage);

        var nextPage = endPage + 1;
        // var prevPage = startPage-1;

        function loadPage(page) {
            $.ajax({
                type: "GET",
                url: "/viewdetail/page",
                data: {
            this_play_id: play_id,
                page: page,
                pageSize: pageSize
        },
            success: function(res) {
                $('.comment_board').empty(); // 기존의 게시물을 모두 지움 위치 중요
                // 데이터를 받아와서 처리하는 부분
                // console.log('res==========>'+res)
                var boardList = res.boardList;

                // console.log('boardList==========>'+boardList)
                for(var i=0;i<boardList.length;i++) {
                    var board = boardList[i];
                    //유닉스 시간으로 들어와서 일반시간으로 변환해줌
                    var reviewAt = new Date(board.review_at);
                    var review_upload_time = reviewAt.getFullYear() + '.' + (reviewAt.getMonth() + 1).toString().padStart(2,'0') + '.' + reviewAt.getDate().toString().padStart(2,'0');

                    var review_viewing_at = new Date(board.review_viewing_at);
                    var review_viewing_time = review_viewing_at.getFullYear() + '.' + (review_viewing_at.getMonth() + 1).toString().padStart(2,'0') + '.' + review_viewing_at.getDate().toString().padStart(2,'0');
                    var list =
                        '<li>' +
                        '<div class="comment_user">' +
                        '<span class="board_1">' + board.user_id + '</span>' +
                        '<span class="board_2">' + "&nbsp;" + review_upload_time + '</span>' +
                        '<span class="board_3">' + "&nbsp;" +
                        '<span class="rating" id='+board.review_star_rating+'>' +
                        '<i class="rating__star far fa-star"></i>' +
                        '<i class="rating__star far fa-star"></i>' +
                        '<i class="rating__star far fa-star"></i>' +
                        '<i class="rating__star far fa-star"></i>' +
                        '<i class="rating__star far fa-star"></i>' +
                        '</span>' +
                        '</span>' +
                        '<span class="board_4">' + "&nbsp;" + "(관람일:" + review_viewing_time + ")" + '</span>' +

                        '<div class="comment_text">' +
                        '<span class="board_5">' + board.review_content + '</span>' +
                        '</div>' +
                        '</div>' +
                        '</li>';
                    $('.comment_board').append(list);
                }

                //별점 보여주기
                var review_star = document.querySelectorAll(".rating");
                // console.log('review_star.length============>' + review_star.length)

                for (var i=0;i<review_star.length;i++) {
                    var rating = review_star[i];
                        rating.style.color = "#FF9100";

                    var star_rating = parseInt(rating.id);
                    // console.log('star_rating============>' + star_rating)

                    var stars = rating.querySelectorAll('i');

                    for (var j=0;j<stars.length;j++) {
                        var star = stars[j];
                        if (j < star_rating) {
                            star.classList.remove("far");
                            star.classList.add("fas");
                        } else {
                            star.classList.remove("fas");
                            star.classList.add("far");
                        }
                    }
                }
            },
            //에러처리 어떻게할지 생각해볼것
            error: function(error) {
                console.log('error => ', error);
            }
        });
        }

        loadPage(1); // 페이지가 로드될 때 첫 번째 페이지 데이터 로드
        // 페이지 번호 클릭 시 해당 페이지 데이터 로드 (관람후기)
        $(document).on('click', '.pagination a', function(e) {
            e.preventDefault();
            var page = $(this).text();

            loadPage(page);
        });


        // 관람후기 다음버튼 클릭이벤트
        $(document).on('click', '.next', function loadNextPageData(e) {
            e.preventDefault();
            var page_tag = document.querySelectorAll(".pagination a")
            var create_tag = document.querySelector('.pagination')

            // console.log('page_tag==========>'+page_tag[0].innerHTML);

            if(page_tag.length===10) {
                if(page_tag[0].innerHTML === "1") {
                    for(var i=0;i<page_tag.length;i++) {
                        page_tag[i].remove();
                        var tag = document.createElement("a");
                        if(i+11<=totalPage) {
                            tag.innerText = i + 11; //반복문 0부터 시작하니까 11더함
                            tag.classList.add('pageCss');

                            tag.setAttribute("href","/viewdetail?this_play_id="+play_id+"&page="+i+11+"&pageSize="+pageSize)
                            create_tag.appendChild(tag);
                        }
                    }
                    nextPage = parseInt(page_tag[0].innerHTML)+10;
                    loadPage(nextPage);
                } else {
                    // console.log('page_tag else==========>'+page_tag[0].innerHTML);
                    var page_save = parseInt(page_tag[0].innerHTML);

                    // console.log('page_save else==========>'+page_save);
                    // console.log("totalPage==========>" + typeof totalPage);

                    for(var i=0;i<page_tag.length;i++) {
                        if(page_tag[0].innerHTML!=="1" && parseInt(page_tag[9].innerHTML) !== parseInt(totalPage)) {
                            for(var i=0;i<pageSize;i++) {
                                page_save = parseInt(page_tag[i].innerHTML)+10;
                                page_tag[i].remove();
                                if(page_save<=totalPage) {
                                    // console.log("page_save==========>" + page_save);
                                    // console.log("totalPage==========>" + totalPage);
                                    var tag = document.createElement("a");
                                    tag.innerText = parseInt(page_save);
                                    tag.classList.add('pageCss');
                                    tag.setAttribute("href", "/viewdetail?this_play_id=" + play_id + "&page=" + page_save + "&pageSize=" + pageSize)
                                    create_tag.appendChild(tag);
                                }
                            }
                            nextPage = parseInt(page_tag[0].innerHTML)+10;
                            // console.log("new-nextPage=============>"+nextPage);
                            loadPage(nextPage);
                        }
                    }
                }
            }
        })
        // 관람후기 다음버튼 클릭이벤트 끝 -----------------------------

        // 관람후기 이전버튼 클릭이벤트
        $(document).on('click', '.prev', function loadPrevPageData(e) {
            e.preventDefault();

            var page_tag = document.querySelectorAll(".pagination a")
            var create_tag = document.querySelector('.pagination')
            if(page_tag.length===10) {
                if(page_tag[0].innerHTML!=="1") {
                    for(var i=pageSize;i>0;i--) {
                        var page_save = parseInt(page_tag[0].innerHTML)-i;
                        page_tag[pageSize-i].remove();
                        // console.log("page_save==========>" + page_save);
                        var tag = document.createElement("a");
                        tag.innerText = parseInt(page_save);
                        // console.log("page_save==========>"+page_save);
                        tag.classList.add('pageCss');
                        tag.setAttribute("href", "/viewdetail?this_play_id=" + play_id + "&page=" + page_save + "&pageSize=" + pageSize)
                        create_tag.appendChild(tag);
                    }
                    var prevPage = parseInt(page_tag[0].innerHTML)-10;
                    loadPage(prevPage);
                }
            } else {

                if(page_tag[0].innerHTML!=="1") {
                    // console.log("pageSize==========>"+pageSize);
                    // console.log("page_tag[0]==========>"+page_tag[0].innerHTML);
                    var page_save = page_tag[0].innerHTML;
                    for (var i=0;i<page_tag.length;i++) {
                        page_tag[i].remove();
                    }
                    for(var i=0;i<pageSize;i++) {
                        var tag = document.createElement("a");
                        tag.innerText = parseInt(page_save-10+i);
                        tag.classList.add('pageCss');
                        tag.setAttribute("href", "/viewdetail?this_play_id=" + play_id + "&page=" + page_save + "&pageSize=" + pageSize)
                        create_tag.appendChild(tag);
                    }
                    var prevPage = parseInt(page_tag[0].innerHTML)-10;
                    loadPage(prevPage);
                }
            }
        })

        // // 리뷰작성하기
        // var review_create = document.getElementById("review_create");
        //
        // review_create.onclick = function () {
        //     //쿼리스트링 이용
        //     var url = '/review_insert?play_id=' + play_id
        //         // + 'dateText='+dateText
        //         // +'&showing_seq='+showing_seq
        //         // +'&play_name='+play_name
        //         // +'&stage_name='+stage_name;
        //
        //     var name = "review_insert"
        //     var option = "width = 500, height = 500, top = 100, left = 200, location = no"
        //     window.open(url, name, option); //성공
        // };

        // 리뷰 별점 매기기
        var star_twinkle = document.querySelectorAll(".review_star i")

        star_twinkle.forEach(function (star){
            star.onclick = function (e) {
                var clicked_star = parseInt(e.target.id);
                for (var i = 0; i < star_twinkle.length; i++) {
                    var starToChange = star_twinkle[i];
                    
                    // 클릭한 별의 id(1~5)보다 i가 작으면 채워진 별, 아니면 빈 별
                    if (i < clicked_star) {
                        starToChange.classList.remove("far");
                        starToChange.classList.add("fas");
                    } else {
                        starToChange.classList.remove("fas");
                        starToChange.classList.add("far");
                    }
                }
            }
        })

    });
    //$(document).ready 끝--------------------------------------------------------------------------




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


    // 지도 다시 만들어야함
    //카카오맵 스크립트
    new daum.roughmap.Lander({
        "timestamp" : "1707022341823",
        "key" : "2hy9x",
        "mapWidth" : "1200",
        "mapHeight" : "700"
    }).render();

