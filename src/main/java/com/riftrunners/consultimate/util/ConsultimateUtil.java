/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.util;

/**
 * @author Diego Peixoto
 * @author Guilherme Matuella
 */
public class ConsultimateUtil {

    public boolean confirmaSenha(String senha, String repeteSenha) {
        return senha.equals(repeteSenha);
    }

    public int calculaHoraSelecionado(double valor, double valorSelecionado) {
        if (valor == valorSelecionado) {
            return 1;
        } else if (valor * 4 == valorSelecionado) {
            return 5;
        } else if (valor * 7 == valorSelecionado) {
            return 10;
        } else {
            return 20;
        }
    }
    
}
