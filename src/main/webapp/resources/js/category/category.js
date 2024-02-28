var mySwiper = new Swiper('.swiper-container', {
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