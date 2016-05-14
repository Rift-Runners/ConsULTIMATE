/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.controller;

import com.riftrunners.consultimate.manager.SimpleEntityManager;
import com.riftrunners.consultimate.model.entity.Consultor;
import com.riftrunners.consultimate.service.ConsultorService;
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

    public String stringMinimizada(String texto, int tamanhoMaximo) {
        return texto.substring(0, Math.min(texto.length(), tamanhoMaximo));
    }

    public String redirecionaConsultorDetalhes() {
        return "consultor-detalhes.xhtml?faces-redirect=true";
    }

    public int[] valoresConsultorVisualizado(int valorBase) {
        return new int[]{valorBase, valorBase * 4, valorBase * 7, valorBase * 12};
    }
//
//    public int calculaHoraSelecionado(int valor) {
//        if (valor == valorSelecionado) {
//            return 1;
//        } else if (valor * 4 == valorSelecionado) {
//            return 5;
//        } else if (valor * 7 == valorSelecionado) {
//            return 10;
//        } else {
//            return 20;
//        }
//    }
//

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
