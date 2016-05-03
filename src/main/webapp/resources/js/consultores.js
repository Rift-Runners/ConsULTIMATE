$(function () {
    $("select").change(function () {
        var option = $(this).find("option:selected").text();

        $(this).closest("body").find(".consultores").find("div").hide(700);
        $(this).closest("body").find("." + option).show(700);
    }).change();
});