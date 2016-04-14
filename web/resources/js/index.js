$(function () {
    var toggleFunc = function () {
        $(this).stop(true, true).toggleClass("rede-social-active", 550);
        $(this).find("h3").stop(true, true).toggleClass("rede-social-active", 550);
    };
    $(".rede-social").hover(toggleFunc, toggleFunc);
});


