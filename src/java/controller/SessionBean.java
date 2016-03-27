/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Guilherme
 */
@ManagedBean(name = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable{
    
    private String usuario, senha;
    public boolean isLogged;
    /**
     * Creates a new instance of SessionBean
     */
    public SessionBean() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isIsLogged() {
        return isLogged;
    }

    public void setIsLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }
    
    public String action(){
        isLogged = true;
        return "index.xhtml?faces-redirect=true";
    }
}
