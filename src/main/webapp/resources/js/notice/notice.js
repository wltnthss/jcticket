$(function(){

    // 등록순, 조회순 toggle click 이벤트
    $('#notice-order1').on('click', switchToggleClass);
    $('#notice-order2').on('click', switchToggleClass);

    // 등록순, 조회순 toggle click 이벤트
    function switchToggleClass(){
        $('#notice-order1').toggleClass("on")
        $('#notice-order2').toggleClass("on")

        console.log('==== ajax 통신 테스트 전 ====')

        $.ajax({

        })

    };

});
