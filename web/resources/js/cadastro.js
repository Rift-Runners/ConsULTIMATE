$(function () {
    $(".ufMask").mask('SS');
    $(".cpfMask").mask('000.000.000-00', {reverse: true});
    $(".rgMask").mask('AAAAAAAAAA', {reverse: true});
    $(".telefoneMask").mask('(00) 0000-0000');
    
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

