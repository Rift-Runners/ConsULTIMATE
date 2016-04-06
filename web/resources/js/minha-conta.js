$(".botao-mostrar-dados").click(function () {
    $(this).closest("div").prev().find(".escondido").toggle("slow");
    $(this).toggleClass(".botao-mostrar-dados-alterado");
    $(this).text(function (i, text) {
        return text === "Mostrar tudo..." ? "Esconder conteúdo" : "Mostrar tudo...";
    });
    $(this).next().toggle("slow");
    $(this).closest("div").toggleClass();
});
