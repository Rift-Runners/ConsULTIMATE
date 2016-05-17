/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author 631420063
 */
@ManagedBean
@RequestScoped
public class ContatoBean {

    private String nome, email, descricao;

    public ContatoBean() {
    }

        public void enviarContato() {
        this.nome = "";
        this.email = "";
        this.descricao = "";
        RequestContext.getCurrentInstance().execute("PF('dialogContato').show()");
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    

}
