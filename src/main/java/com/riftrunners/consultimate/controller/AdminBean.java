/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.riftrunners.consultimate.model.entity.Cliente;
import com.riftrunners.consultimate.model.entity.Consultor;
import com.riftrunners.consultimate.model.entity.ListasDados;
import com.riftrunners.consultimate.utils.Validators;

/**
 *
 * @author Guilherme
 */
@ManagedBean
@SessionScoped
public class AdminBean {

    private Consultor consultorEditado, consultorExcluido;
    private Cliente clienteEditado, clienteExcluido;
    private Validators validador;

    public AdminBean() {
        validador = new Validators();
    }

    public Consultor getConsultorEditado() {
        return consultorEditado;
    }

    public void setConsultorEditado(Consultor consultorEditado) {
        this.consultorEditado = consultorEditado;
    }

    public Cliente getClienteEditado() {
        return clienteEditado;
    }

    public void setClienteEditado(Cliente clienteEditado) {
        this.clienteEditado = clienteEditado;
    }

    public Consultor getConsultorExcluido() {
        return consultorExcluido;
    }

    public void setConsultorExcluido(Consultor consultorExcluido) {
        this.consultorExcluido = consultorExcluido;
    }

    public Cliente getClienteExcluido() {
        return clienteExcluido;
    }

    public void setClienteExcluido(Cliente clienteExcluido) {
        this.clienteExcluido = clienteExcluido;
    }

    public String adminEditarConsultor() {
        return "admEditar.xhtml?faces-redirect=true";
    }

    public String deletarCliente() {
        ListasDados listasDeDados = validador.listaControladorAplicacao();
        listasDeDados.deletarCliente(clienteEditado);
        return "dashboard.xhtml?faces-redirect=true";
    }

    public String deletarConsultor() {
        ListasDados listasDeDados = validador.listaControladorAplicacao();
        listasDeDados.deletarConsultor(consultorEditado);
        return "dashboard.xhtml?faces-redirect=true";
    }

    public String editarSelecionado() {
        return "dashboard.xhtml?faces-redirect=true";
    }
}
