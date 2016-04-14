$(function () {    
    $(".perfil-cliente").click(function () {
        $(this).addClass("btn-primary");
        $(this).closest("body").find(".perfil-consultor").removeClass("btn-primary");
        $(this).closest("body").find("#formulario-cliente").slideDown();
        $(this).closest("body").find("#formulario-consultor").slideUp();
    });
    $(".perfil-consultor").click(function () {
        $(this).addClass("btn-primary");
        $(this).closest("body").find(".perfil-cliente").removeClass("btn-primary");
        $(this).closest("body").find("#formulario-consultor").slideDown();
        $(this).closest("body").find("#formulario-cliente").slideUp();
    });
});

