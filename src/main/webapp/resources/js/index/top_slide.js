$(function () {
    //슬라이드 텍스트 애니메이션
    var textMove1;
    var textMove2;
    var textMove3;
    var textMove;
    textMove1 = function (num){
        $(".kv-item").eq(num).find(".pf-kv-text").find("p").eq(0).stop().animate({
            opacity: 1,
            paddingLeft:0
        }, 400);
    };
    textMove2 = function (num){
        setTimeout(function() {
            $(".kv-item").eq(num).find(".pf-kv-text").find("p").eq(1).stop().animate({
                opacity: 1,
                paddingLeft:0
            }, 400);
        }, 400);
    };
    textMove3 = function (num){
        setTimeout(function() {
            $(".kv-item").eq(num).find(".pf-kv-text").find("p").eq(2).stop().animate({
                opacity: 1,
                paddingLeft:0
            }, 400);
        }, 800);
    };
    var textMove = async function (num){
        await textMove1(num);
        await textMove2(num);
        await textMove3(num);
    };
    textMove(0);
    /*메인비주얼*/
    var kvLeng = $(".kv-item").length; //슬라이드총갯수
    for (var i = 0; i <= kvLeng; i++) {
        $(".pager-bg a").eq(i).find("span").text((i + 1) + "/" + kvLeng); //아래서 올라오는 갤러리 인디게이터? 에 1/8 이런식으로 현재 숫자랑 총 갯수 표시
    }
    var kvCurrent = 0; //임의의 변수

    function autoSlide() { //슬라이드 자동으로 돌아가는 함수, 자동롤링할때만 fade 함수 사용, 그외 버튼으로 움직일시 대기열문제때문에 딜레이 걸리는거 안쓰고 바로표시되는 display:none과 block 으로 제어
        if (kvCurrent < kvLeng - 1) { //넥스트 버튼과 동일
            kvCurrent = kvCurrent + 1;
            var crtItem = $(".kv-item").eq(kvCurrent);
            $(".pf-kvslide-wrap").css("background", $(".kv-item").eq(kvCurrent).attr("colorbg"));
            $(".kv-item").not(crtItem).css("z-index", "");
            $(".kv-item").not(crtItem).stop().animate({
                opacity: 0
            }, 400);
            $(".kv-item").eq(kvCurrent).css("z-index", "1");
            $(".kv-item").eq(kvCurrent).stop().animate({
                opacity: 1
            }, 400);
            $(".pager-bg a").removeClass("on");
            $(".pager-bg a").eq(kvCurrent).addClass("on");
            $(".kv-item").not(crtItem).find(".pf-kv-text").find("p").css({ "opacity": "0", "padding-left": "20px" });
            $(".kv-item").eq(kvCurrent).find(".pf-kv-text").find("p").eq(0).stop().animate({
                opacity: 1,
                paddingLeft: 0
            }, 400, function () {
                $(".kv-item").eq(kvCurrent).find(".pf-kv-text").find("p").eq(1).stop().animate({
                    opacity: 1,
                    paddingLeft: 0
                }, 400, function () {
                    $(".kv-item").eq(kvCurrent).find(".pf-kv-text").find("p").eq(2).stop().animate({
                        opacity: 1,
                        paddingLeft: 0
                    }, 400);
                });
            });
        } else {
            kvCurrent = 0;
            var crtItem = $(".kv-item").eq(kvCurrent);
            $(".pf-kvslide-wrap").css("background", $(".kv-item").eq(kvCurrent).attr("colorbg"));
            $(".kv-item").not(crtItem).css("z-index", "");
            $(".kv-item").not(crtItem).stop().animate({
                opacity: 0
            }, 400);
            $(".kv-item").eq(kvCurrent).css("z-index", "1");
            $(".kv-item").eq(kvCurrent).stop().animate({
                opacity: 1
            }, 400);
            $(".pager-bg a").removeClass("on");
            $(".pager-bg a").eq(kvCurrent).addClass("on");
            $(".kv-item").not(crtItem).find(".pf-kv-text").find("p").css({ "opacity": "0", "padding-left": "20px" });
            $(".kv-item").eq(kvCurrent).find(".pf-kv-text").find("p").eq(0).stop().animate({
                opacity: 1,
                paddingLeft: 0
            }, 400, function () {
                $(".kv-item").eq(kvCurrent).find(".pf-kv-text").find("p").eq(1).stop().animate({
                    opacity: 1,
                    paddingLeft: 0
                }, 400, function () {
                    $(".kv-item").eq(kvCurrent).find(".pf-kv-text").find("p").eq(2).stop().animate({
                        opacity: 1,
                        paddingLeft: 0
                    }, 400);
                });
            });
        }
    }
    var autoS;
    clearInterval(autoS);
    autoS = setInterval(autoSlide, 4000); //슬라이드 자동함수를 4초마다 반복실행

    $(".pf-kv-next").on('click', function (e) {
        e.preventDefault();
        if (kvCurrent < kvLeng - 1) { // kvCurrent가 총갯수 보다 작을때
            kvCurrent = kvCurrent + 1; //버튼클릭할때마다 kvCurrent는 1씩 증가
            var crtItem = $(".kv-item").eq(kvCurrent); //현재 아이템을 변수에 담음
            $(".pf-kvslide-wrap").css("background", $(".kv-item").eq(kvCurrent).attr("colorbg"));
            $(".kv-item").css({ "opacity": "0", "z-index": "" }); //전체슬라이드를 안보이게 한다음
            $(".kv-item").eq(kvCurrent).css({ "opacity": "1", "z-index": "1" }); //kvCurrent와 같은 인덱스를 가지고있는 슬라이드만 보이게 표시
            $(".pager-bg a").removeClass("on"); //갤러리인디게이터 모두에서 on클래스 제거후
            $(".pager-bg a").eq(kvCurrent).addClass("on"); //kvCurrent와 같은 인덱스를 가지고있는 갤러리인디게이터에만 on 클래스 부여 (상당 주황색바랑 이미지 밝아짐)
            $(".kv-item").not(crtItem).find(".pf-kv-text").find("p").css({ "opacity": "0", "padding-left": "20px" }); //kv-item 중 현재아이템이 아닌 다른애들한테 css스타일
            //현재 아이템의 텍스트 애니메이션
            $(".kv-item").eq(kvCurrent).find(".pf-kv-text").find("p").eq(0).stop().animate({
                opacity: 1,
                paddingLeft: 0
            }, 400, function () {
                $(".kv-item").eq(kvCurrent).find(".pf-kv-text").find("p").eq(1).stop().animate({
                    opacity: 1,
                    paddingLeft: 0
                }, 400, function () {
                    $(".kv-item").eq(kvCurrent).find(".pf-kv-text").find("p").eq(2).stop().animate({
                        opacity: 1,
                        paddingLeft: 0
                    }, 400);
                });
            });
            $(".kv-play").css("display", "block"); /*0621추가*/
        } else { //kvCurrent가 총갯수에 도달했을때
            kvCurrent = 0; //kvCurrent를 다시 0으로 초기화
            var crtItem = $(".kv-item").eq(kvCurrent);
            $(".pf-kvslide-wrap").css("background", $(".kv-item").eq(kvCurrent).attr("colorbg"));
            $(".kv-item").css({ "opacity": "0", "z-index": "" });
            $(".kv-item").eq(kvCurrent).css({ "opacity": "1", "z-index": "1" });
            $(".pager-bg a").removeClass("on");
            $(".pager-bg a").eq(kvCurrent).addClass("on");
            $(".kv-item").not(crtItem).find(".pf-kv-text").find("p").css({ "opacity": "0", "padding-left": "20px" });
            $(".kv-item").eq(kvCurrent).find(".pf-kv-text").find("p").eq(0).stop().animate({
                opacity: 1,
                paddingLeft: 0
            }, 400, function () {
                $(".kv-item").eq(kvCurrent).find(".pf-kv-text").find("p").eq(1).stop().animate({
                    opacity: 1,
                    paddingLeft: 0
                }, 400, function () {
                    $(".kv-item").eq(kvCurrent).find(".pf-kv-text").find("p").eq(2).stop().animate({
                        opacity: 1,
                        paddingLeft: 0
                    }, 400);
                });
            });
            $(".kv-play").css("display", "block"); /*0621추가*/
        }
        //동영상 재생시켰다가 넥스트 버튼을 눌렀을때 동작들
        $("a.movie").css("display", "block"); //재생시키면서 사라졌던 버튼 보이게
        $(".pf-kv-text").css("display", "block"); //재생시키면서 사라졌던 텍스트 보이게
        $(".perform-top").removeClass("movie"); //재생시키면서 바꿨던 헤더 다시 반전
        $(".kvPlayer-wrap").css("display", "none"); //동영상 사라지게
        $(".kv-player").css("display", "none"); //동영상 사라지게
        playerBigBanner.stopVideo();
    });
    $(".pf-kv-next").on('mouseenter', function () {
        clearInterval(autoS); //넥스트 버튼에 마우스 오버시 슬라이드 자동롤링 정지
    });
    $(".pf-kv-next").on('mouseleave', function () {
        clearInterval(autoS);
        autoS = setInterval(autoSlide, 4000); //넥스트 버튼에 마우스 아웃시 슬라이드 자동롤링 ㅈㅐ가동
    });
    $(".pf-kv-prev").on('click', function (e) { //넥스트 버튼과 같은 원리로 kvCurrent가 1씩 감소
        e.preventDefault();
        if (kvCurrent <= 0) {
            kvCurrent = kvLeng - 1;
            var crtItem = $(".kv-item").eq(kvCurrent);
            $(".pf-kvslide-wrap").css("background", $(".kv-item").eq(kvCurrent).attr("colorbg"));
            $(".kv-item").css({ "opacity": "0", "z-index": "" });
            $(".kv-item").eq(kvCurrent).css({ "opacity": "1", "z-index": "1" });
            $(".pager-bg a").removeClass("on");
            $(".pager-bg a").eq(kvCurrent).addClass("on");
            $(".kv-item").not(crtItem).find(".pf-kv-text").find("p").css({ "opacity": "0", "padding-left": "20px" });
            $(".kv-item").eq(kvCurrent).find(".pf-kv-text").find("p").eq(0).stop().animate({
                opacity: 1,
                paddingLeft: 0
            }, 400, function () {
                $(".kv-item").eq(kvCurrent).find(".pf-kv-text").find("p").eq(1).stop().animate({
                    opacity: 1,
                    paddingLeft: 0
                }, 400, function () {
                    $(".kv-item").eq(kvCurrent).find(".pf-kv-text").find("p").eq(2).stop().animate({
                        opacity: 1,
                        paddingLeft: 0
                    }, 400);
                });
            });
            $(".kv-play").css("display", "block"); /*0621추가*/
        } else {
            kvCurrent = kvCurrent - 1;
            var crtItem = $(".kv-item").eq(kvCurrent);
            $(".pf-kvslide-wrap").css("background", $(".kv-item").eq(kvCurrent).attr("colorbg"));
            $(".kv-item").css({ "opacity": "0", "z-index": "" });
            $(".kv-item").eq(kvCurrent).css({ "opacity": "1", "z-index": "1" });
            $(".pager-bg a").removeClass("on");
            $(".pager-bg a").eq(kvCurrent).addClass("on");
            $(".kv-item").not(crtItem).find(".pf-kv-text").find("p").css({ "opacity": "0", "padding-left": "20px" });
            $(".kv-item").eq(kvCurrent).find(".pf-kv-text").find("p").eq(0).stop().animate({
                opacity: 1,
                paddingLeft: 0
            }, 400, function () {
                $(".kv-item").eq(kvCurrent).find(".pf-kv-text").find("p").eq(1).stop().animate({
                    opacity: 1,
                    paddingLeft: 0
                }, 400, function () {
                    $(".kv-item").eq(kvCurrent).find(".pf-kv-text").find("p").eq(2).stop().animate({
                        opacity: 1,
                        paddingLeft: 0
                    }, 400);
                });
            });
            $(".kv-play").css("display", "block"); /*0621추가*/
        }
        //동영상 재생시켰다가 이전보기 버튼을 눌렀을때 동작들, 넥스트 버튼과 같음
        $("a.movie").css("display", "block");
        $(".pf-kv-text").css("display", "block");
        $(".perform-top").removeClass("movie");
        $(".kvPlayer-wrap").css("display", "none");
        $(".kv-player").css("display", "none");
        playerBigBanner.stopVideo();
    });
    $(".pf-kv-prev").on('mouseenter', function () {
        clearInterval(autoS); //넥스트 버튼과 동일하게 자동롤링 정지
    });
    $(".pf-kv-prev").on('mouseleave', function () {
        clearInterval(autoS);
        autoS = setInterval(autoSlide, 4000); //넥스트 버튼과 동일하게 자동롤링 재시작
    });
    $(".pager-bg a").on('click', function (e) { //갤러리 인디게이터 클릭했을때
        e.preventDefault();
        var pbIdx = $(this).index(); //갤러리 인디게이터의 인덱스를 가져와서
        kvCurrent = pbIdx; //액티브 슬라이드를 결정하는 kvCurrent의 값을 클릭한 인디게이터의 값과 동일하게 맞춰줌
        var crtItem = $(".kv-item").eq(pbIdx);
        $(".kv-item").css({ "opacity": "0", "z-index": "" }); //전체슬라이드를 안보이게 한다음
        $(".kv-item").eq(pbIdx).css({ "opacity": "1", "z-index": "1" }); //클릭한 인디게이터와 동일순번의 슬라이드를 노출
        $(".pf-kvslide-wrap").css("background", $(".kv-item").eq(pbIdx).attr("colorbg")); //갤러리 인디게이터 클릭하면 bg 컬러 변경
        $(".kv-item").not(crtItem).find(".pf-kv-text").find("p").css({ "opacity": "0", "padding-left": "20px" });
        $(".kv-item").eq(pbIdx).find(".pf-kv-text").find("p").eq(0).stop().animate({
            opacity: 1,
            paddingLeft: 0
        }, 400, function () {
            $(".kv-item").eq(pbIdx).find(".pf-kv-text").find("p").eq(1).stop().animate({
                opacity: 1,
                paddingLeft: 0
            }, 400, function () {
                $(".kv-item").eq(pbIdx).find(".pf-kv-text").find("p").eq(2).stop().animate({
                    opacity: 1,
                    paddingLeft: 0
                }, 400);
            });
        });
    });
    $(".pager-bg a").on('mouseenter', function (e) { //갤러리 인디게이터 마우스오버했을때 클래스 on 붙였다
        e.preventDefault();
        $(".pager-bg a").removeClass("on");
        $(this).addClass("on");
    });
    $(".pager-bg").on('mouseleave', function (e) {//갤러리 인디게이터 마우스오버했을때 클래스 on 뗐다
        e.preventDefault();
        $(".pager-bg a").removeClass("on");
        $(".pager-bg a").eq(kvCurrent).addClass("on");
    });


    setTimeout(function () {
        //페이지 오픈시 0.5초뒤에 갤러리인디게이터에 붙어있던 on2클래스를 삭제하고 off2 클래스를 붙임 (on2클래스는 0.5초동안 갤러리인디게이터가 반정도 올라오는 css3애니메이션/off2는 다시 내려가는 css3애니메이션)
        $(".pf-kvslide-pager").removeClass("on2").addClass("off2");
    }, 500);

    var stope = 0; //임의선언
    $(".pf-kvslide-pager").on('mouseenter', function () { // 갤러리인디게이터에 마우스오버하면 height 값이 커지면서 인디게이터가 위로 올라오는...
        if (stope === 0) {
            stope = 1; //stope를 1로 바꿔서 애니메이션 중복 동작을 못하게 막음
            $(".pf-kvslide-pager").removeClass("off2");
            $(".pf-kvslide-pager").removeClass("off");
            $(".pf-kvslide-pager").addClass("on");
            $(".pf-kvslide-pager").stop().animate({
                height: "160px"
            }, 500);
            clearInterval(autoS); // 마우스오버시 자동롤링멈춤
            stope = 0; //애니메이션 끝나면 0으로 돌려와서 다시 애니메이션 동작 가능하도록
        }
    });
    $(".pf-kvslide-pager").on('mouseleave', function () { //위의 마우스 오버와 반대
        if (stope === 0) {
            stope = 1;
            $(".pf-kvslide-pager").removeClass("off2");
            $(".pf-kvslide-pager").removeClass("on");
            $(".pf-kvslide-pager").addClass("off");
            $(".pf-kvslide-pager").stop().animate({
                height: "18px"
            }, 500, function () {
                $(this).css("overflow", "visible"); //클래스 조절로 span 안의 숫자가 보여야 되는게 애니메이션 끝나면서 자동으로 overflow:hidden;이 붙어서 숫자가 안보여가지고 추가
            });
            clearInterval(autoS);
            autoS = setInterval(autoSlide, 4000);
            stope = 0;
        }
    });


    $("a.kv-play").on('click', function (e) { //키비주얼 재생버튼 클릭하면
        e.preventDefault();
        //playerBigBanner.playVideo();
        playYoutube($(this).attr("data-video"));
        $(".kvPlayer-wrap").css("display", "block"); //동영상 백그라운드를 보여주고
        $(".kv-player").css("display", "block"); // 숫자와 같은 인텍스의 동영상만 보이게
        $(this).fadeOut(400); //재생버튼 사라지게
        $(this).parent(".kv-item").find(".pf-kv-text").fadeOut(400); //해당슬라이드 텍스트 사라지게
        $(".perform-top").addClass("movie"); // 헤더 컬러들 변경
        clearInterval(autoS); //슬라이드 자동롤링 멈춤
    });

    $(".movie-close").on('click', function (e) { //동영상 닫기버튼 누르면
        e.preventDefault();
        playerBigBanner.stopVideo();
        $("a.kv-play").css("display", "block"); //버튼 다시보이게
        $(".pf-kv-text").css("display", "block"); //텍스트 다시 보이게
        $(".perform-top").removeClass("movie"); //헤더 다시 원상복귀
        $(".kvPlayer-wrap").css("display", "none"); //동영상 백그라운드 안보이게
        $(".kv-player").css("display", "none"); //동영상 다 안보이게
        clearInterval(autoS);
        autoS = setInterval(autoSlide, 4000); //자동롤링 다시 시작
    });

    function playYoutube(videoID) {
        playerBigBanner.loadVideoById(
            {
                'videoId': videoID,
                'startSeconds': 0,
                'endSeconds': 0,
                'suggestedQuality': 'large'
            });
    }

});

function displayDonut() {
    config.data.datasets[0].data = [12.5 * (8 - 0), 12.5 * 0];
    new Chart(document.getElementById('chart-area14063').getContext('2d'), config);
    config.data.datasets[0].data = [12.5 * (8 - 2), 12.5 * 2];
    new Chart(document.getElementById('chart-area14061').getContext('2d'), config);
    config.data.datasets[0].data = [12.5 * (8 - 1), 12.5 * 1];
    new Chart(document.getElementById('chart-area14058').getContext('2d'), config);
    config.data.datasets[0].data = [12.5 * (8 - 3), 12.5 * 3];
    new Chart(document.getElementById('chart-area14051').getContext('2d'), config);
    config.data.datasets[0].data = [12.5 * (8 - 3), 12.5 * 3];
    new Chart(document.getElementById('chart-area14040').getContext('2d'), config);
}

    var config = {
        type: 'doughnut',
        data: {
            datasets: [{
                data: [50, 50], //주황색,흰색
                backgroundColor: [
                    '#ed8844', '#ebebeb'
                ],
                borderWidth: [0, 0],
                cutout : "90%",
            }]
        },
        options: {
            responsive: false,
            animation: {
                animateRotate: true,
                duration: 2000
            },
            cutoutPercentage: 90,
            tooltips: {
                enabled: false
            }
        }
    };

// function displayDonut() {
//     var config1 = {
//         type: 'doughnut',
//         data: {
//             datasets: [{
//                 data: [12.5 * (8 - 0), 12.5 * 0],
//                 backgroundColor: ['#ed8844', '#ebebeb'],
//                 borderWidth: [0, 0]
//             }]
//         },
//         options: {
//             animation: {
//                 animateRotate: true,
//                 duration: 2000
//             },
//             cutoutPercentage: 90,
//             tooltips: {
//                 enabled: false
//             }
//         }
//     };
//     new Chart(document.getElementById('chart-area14063').getContext('2d'), config1);
//
//     var config2 = {
//         type: 'doughnut',
//         data: {
//             datasets: [{
//                 data: [12.5 * (8 - 2), 12.5 * 2],
//                 backgroundColor: ['#ed8844', '#ebebeb'],
//                 borderWidth: [0, 0]
//             }]
//         },
//         options: {
//             animation: {
//                 animateRotate: true,
//                 duration: 2000
//             },
//             cutoutPercentage: 90,
//             tooltips: {
//                 enabled: false
//             }
//         }
//     };
//     new Chart(document.getElementById('chart-area14061').getContext('2d'), config2);
//
//     var config3 = {
//         type: 'doughnut',
//         data: {
//             datasets: [{
//                 data: [12.5 * (8 - 1), 12.5 * 1],
//                 backgroundColor: ['#ed8844', '#ebebeb'],
//                 borderWidth: [0, 0]
//             }]
//         },
//         options: {
//             animation: {
//                 animateRotate: true,
//                 duration: 2000
//             },
//             cutoutPercentage: 90,
//             tooltips: {
//                 enabled: false
//             }
//         }
//     };
//     new Chart(document.getElementById('chart-area14058').getContext('2d'), config3);
//
//     var config4 = {
//         type: 'doughnut',
//         data: {
//             datasets: [{
//                 data: [12.5 * (8 - 3), 12.5 * 3],
//                 backgroundColor: ['#ed8844', '#ebebeb'],
//                 borderWidth: [0, 0]
//             }]
//         },
//         options: {
//             animation: {
//                 animateRotate: true,
//                 duration: 2000
//             },
//             cutoutPercentage: 90,
//             tooltips: {
//                 enabled: false
//             }
//         }
//     };
//     new Chart(document.getElementById('chart-area14051').getContext('2d'), config4);
//
//     var config5 = {
//         type: 'doughnut',
//         data: {
//             datasets: [{
//                 data: [12.5 * (8 - 3), 12.5 * 3],
//                 backgroundColor: ['#ed8844', '#ebebeb'],
//                 borderWidth: [0, 0]
//             }]
//         },
//         options: {
//             animation: {
//                 animateRotate: true,
//                 duration: 2000
//             },
//             cutoutPercentage: 90,
//             tooltips: {
//                 enabled: false
//             }
//         }
//     };
//     new Chart(document.getElementById('chart-area14040').getContext('2d'), config5);
// }


    var num = 0;
    $(window).on('scroll', function () {
        var stop = $(this).scrollTop();
        if (stop > 1000) {
            if (num == 0) {
                num = 1;
                displayDonut();
            }
        } else {
            num = 0;
        }
    });



if ($(".swiper-container.ticketo > .swiper-wrapper > div").length < 3) {
        $(".sec02 > p").hide();
        $(".sec02 > .cont").hide();
        $(".sec02 > a").hide();
    }


document.addEventListener("DOMContentLoaded", function(event) {
    let currentSlide = 0;
    const slides = document.querySelectorAll('.swiper-slide2');
    const slideInterval = setInterval(nextSlide, 4000); // 4초마다 이미지 변경

    function nextSlide() {
        slides[currentSlide].classList.remove('active');
        currentSlide = (currentSlide + 1) % slides.length;
        slides[currentSlide].classList.add('active');
    }
});