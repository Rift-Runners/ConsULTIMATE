$(function () {
    $("#clientes-cadastrados-btn").click(function () {
        $(this).addClass("active");
        $(this).closest("ul").find("#consultores-cadastrados-btn").removeClass("active");
        $(this).closest("body").find("#clientes-cadastrados").show();
        $(this).closest("body").find("#consultores-cadastrados").hide();
    });
    $("#consultores-cadastrados-btn").click(function () {
        $(this).addClass("active");
        $(this).closest("ul").find("#clientes-cadastrados-btn").removeClass("active");
        $(this).closest("body").find("#consultores-cadastrados").show();
        $(this).closest("body").find("#clientes-cadastrados").hide();
    });
});

