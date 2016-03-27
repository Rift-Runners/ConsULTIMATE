$(function () {
    $("#clientes-cadastrados-btn").click(function () {
        $(this).addClass("active");
        $(this).closest("ul").find("#consultores-cadastrados-btn").removeClass("active");
        $(this).closest("body").find("#clientes-cadastrados").addClass("visivel");
        $(this).closest("body").find("#consultores-cadastrados").removeClass("visivel");
    });
    $("#consultores-cadastrados-btn").click(function () {
        $(this).addClass("active");
        $(this).closest("ul").find("#clientes-cadastrados-btn").removeClass("active");
        $(this).closest("body").find("#consultores-cadastrados").addClass("visivel");
        $(this).closest("body").find("#clientes-cadastrados").removeClass("visivel");
    });
});

