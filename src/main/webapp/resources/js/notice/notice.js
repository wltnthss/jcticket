$(function(){

    // 등록순, 조회순 toggle click 이벤트
    $('#notice-order1').on('click', switchToggleClass);
    $('#notice-order2').on('click', switchToggleClass);

    function switchToggleClass(){
        $('#notice-order1').toggleClass("on")
        $('#notice-order2').toggleClass("on")
    };

});
