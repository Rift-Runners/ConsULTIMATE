/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.regex.Pattern;

/**
 *
 * @author Guilherme
 */
public class Validators {

    public Validators() {
    }

    public boolean validaEmail(String emailInput) {
        String stringPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(stringPattern);
        return pattern.matcher(emailInput).matches();
    }

    public boolean validaUsuario(String usuarioInput) {
        String stringPattern = "(^[a-zA-Z0-9_]{6,16}$)";
        Pattern pattern = Pattern.compile(stringPattern);
        return pattern.matcher(usuarioInput).matches();
    }

    public boolean validaSenha(String senhaInput) {
        return (senhaInput.length() > 5 || senhaInput.length() < 17);
    }
}
