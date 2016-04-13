/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import controller.MainController;
import java.util.regex.Pattern;
import javax.faces.context.FacesContext;
import model.Entity.Cliente;
import model.Entity.Consultor;
import model.Entity.ListasDados;

/**
 *
 * @author Guilherme
 */
public class Validators {

    public Validators() {
    }

    public ListasDados listaControladorAplicacao() {
        MainController controladorPrincipal = (MainController) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("mainController");
        return controladorPrincipal.getListasDeDados();
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

    public boolean validaCliente(Cliente cli) {
        if (validaEmail(cli.getEmail())) {
            if (validaUsuario(cli.getUsuario())) {
                if (validaSenha(cli.getSenha())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean validaConsultor(Consultor cons) {
        if (validaEmail(cons.getEmail())) {
            if (validaUsuario(cons.getUsuario())) {
                if (validaSenha(cons.getSenha())) {
                    return true;
                }
            }
        }
        return false;
    }
}
