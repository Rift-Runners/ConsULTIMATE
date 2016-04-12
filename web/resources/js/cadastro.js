$(function () {    
    $(".perfil-cliente").click(function () {
        $(this).addClass("btn-primary");
        $(this).closest("body").find(".perfil-consultor").removeClass("btn-primary");
        $(this).closest("body").find("#formulario-cliente").show();
        $(this).closest("body").find("#formulario-consultor").hide();
    });
    $(".perfil-consultor").click(function () {
        $(this).addClass("btn-primary");
        $(this).closest("body").find(".perfil-cliente").removeClass("btn-primary");
        $(this).closest("body").find("#formulario-consultor").show();
        $(this).closest("body").find("#formulario-cliente").hide();
    });
});

