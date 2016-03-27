$(function () {
    $(".perfil-cliente").click(function () {
        $(this).addClass("btn-primary");
        $(this).closest("body").find(".perfil-consultor").removeClass("btn-primary");
        $(this).closest("body").find("#formulario-cliente").addClass("visivel");
        $(this).closest("body").find("#formulario-consultor").removeClass("visivel");
    });
    $(".perfil-consultor").click(function () {
        $(this).addClass("btn-primary");
        $(this).closest("body").find(".perfil-cliente").removeClass("btn-primary");
        $(this).closest("body").find("#formulario-consultor").addClass("visivel");
        $(this).closest("body").find("#formulario-cliente").removeClass("visivel");
    });
});

