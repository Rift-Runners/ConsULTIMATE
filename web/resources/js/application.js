$(function () {
    $(".perfil-cliente").click(function () {
        $(this).addClass("btn-primary");
        $(this).closest("body").find(".perfil-consultor").removeClass("btn-primary");
        $(this).closest("body").find("#formulario-cliente").addClass("perfil-selecionado");
        $(this).closest("body").find("#formulario-consultor").removeClass("perfil-selecionado");
    });
    $(".perfil-consultor").click(function () {
        $(this).addClass("btn-primary");
        $(this).closest("body").find(".perfil-cliente").removeClass("btn-primary");
        $(this).closest("body").find("#formulario-consultor").addClass("perfil-selecionado");
        $(this).closest("body").find("#formulario-cliente").removeClass("perfil-selecionado");
    });
});

