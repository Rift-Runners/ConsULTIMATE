/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.util;

/**
 *
 * @author 631420063
 */
public class ConsultimateUtil {

    public boolean confirmaSenha(String senha, String repeteSenha) {
        return senha.equals(repeteSenha);
    }
}
