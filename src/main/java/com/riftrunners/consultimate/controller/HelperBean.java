/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;

/**
 * @author Diego Peixoto
 * @author Guilherme Matuella
 */
@ManagedBean
@RequestScoped
public class HelperBean implements Serializable {

    private String emailRecuperaSenha, pergunta;

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

    public String maskStatus(Boolean status) {
        return status ? "Ativo" : "Inativo";
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

    public String redirecionaContato() {
        return "contato.xhtml?faces-redirect=true";
    }

    public String redirecionaCadastro() {
        return "cadastro.xhtml?faces-redirect=true";
    }

    public String redirecionaLogin() {
        return "login.xhtml?faces-redirect=true";
    }

    public String redirecionaMinhaConta() {
        return "minha-conta.xhtml?faces-redirect=true";
    }

    public void perguntarConsultor() {
        this.pergunta = "";
        RequestContext.getCurrentInstance().execute("PF('dialogPergunta').show()");
    }

    public boolean isPaginaPrincipal() {
        HttpServletRequest servletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return servletRequest.getRequestURI().contains("index");
    }

    public String getEmailRecuperaSenha() {
        return emailRecuperaSenha;
    }

    public void setEmailRecuperaSenha(String emailRecuperaSenha) {
        this.emailRecuperaSenha = emailRecuperaSenha;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

}
