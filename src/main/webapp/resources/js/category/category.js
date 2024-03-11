

$(function(){

    sessionStorage.setItem("contextpath", "${pageContext.request.contextPath}");

    console.log('TTTTTTEEEEESSSSSTTTTT ' + sessionStorage.getItem("contextpath"));

    $("#searchBtn").on('click', function () {

        let word = $("#searchWord").val();

        if(word === null || word === ""){
            alert('검색어를 입력해주세요.')
            return false;
        }

        $.ajax({
            type: 'GET',
            uri: sessionStorage.getItem("contextpath") + '/search',
            contentType: 'application/json',
            data: {word: word},
            success: function (res){
                console.log('응답 성공', res)
                location.href = sessionStorage.getItem("contextpath") + "/search?word=" + word;
            },
            error: function (err) {
                console.error("에러", err);
            }
        })
    });

    let mySwiper = new Swiper('.swiper-container', {
        autoplay: {
            delay: 3000,
            disableOnInteraction: false,
        },
        loop: true,
        loopAdditionalSlides : 1,
        spaceBetween: 40, // 슬라이드 사이 간격 설정
        slidesPerView: 1,
        initialSlide: 0,
        slideToClickedSlide : true,
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
        },
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
    });
});