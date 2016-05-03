/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.model.entity;

/**
 * @author Guilherme Matuella
 * @author Diego Peixoto
 */
public class Admin {

    private String usuario, senha;
    private boolean administrador;

    public Admin(String usuario, String senha, boolean administrador) {
        this.usuario = usuario;
        this.senha = senha;
        this.administrador = administrador;
    }

    public Admin() {}

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

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    } 
}
