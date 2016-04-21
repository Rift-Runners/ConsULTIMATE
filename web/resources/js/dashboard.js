$(function () {
    $("#analise-de-negocios").hide();
    
    $("#clientes-cadastrados-btn").click(function () {
        $(this).addClass("active-btn");
        $(this).next().removeClass("active-btn");
        $(this).next().next().removeClass("active-btn");
        $(this).closest("body").find(".panel").hide();
        $(this).closest("body").find("#clientes-cadastrados").show();
    });
    $("#consultores-cadastrados-btn").click(function () {
        $(this).addClass("active-btn");
        $(this).prev().removeClass("active-btn");
        $(this).next().removeClass("active-btn");
        $(this).closest("body").find(".panel").hide();
        $(this).closest("body").find("#consultores-cadastrados").show();
    });
    $("#analise-de-negocios-btn").click(function () {
        $(this).addClass("active-btn");
        $(this).prev().removeClass("active-btn");
        $(this).prev().prev().removeClass("active-btn");
        $(this).closest("body").find(".panel").hide();
        $(this).closest("body").find("#analise-de-negocios").show();
    });
});

