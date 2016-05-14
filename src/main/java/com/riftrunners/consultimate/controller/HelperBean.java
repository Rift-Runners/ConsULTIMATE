/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Diego Peixoto
 * @author Guilherme Matuella
 */
@ManagedBean
@ViewScoped
public class HelperBean implements Serializable {

    private String emailRecuperaSenha;

    /**
     * Creates a new instance of HelperBean
     */
    public HelperBean() {
    }

    public List<String> listaEstados() {
        List<String> estados = new ArrayList();
        estados.add("RS");
        estados.add("SC");
        estados.add("SP");
        estados.add("RJ");
        return estados;
    }

    public List<String> listaAreas() {
        List<String> areas = new ArrayList();
        areas.add("TI");
        areas.add("Engenharia");
        areas.add("Artes");
        return areas;
    }

    public String redirecionaContato() {
        return "contato.xhtml?faces-redirect=true";
    }
    
    public String redirecionaCadastro() {
        return "cadastro.xhtml?faces-redirect=true";
    }

    public String redirecionaLogin() {
        return "login.xhtml?faces-redirect=true";
    }

    public String getEmailRecuperaSenha() {
        return emailRecuperaSenha;
    }

    public void setEmailRecuperaSenha(String emailRecuperaSenha) {
        this.emailRecuperaSenha = emailRecuperaSenha;
    }

}
