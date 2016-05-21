/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.controller;

import javax.faces.bean.ManagedBean;
import com.riftrunners.consultimate.model.entity.Cliente;
import com.riftrunners.consultimate.model.entity.Consultor;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;

/**
 * @author Diego Peixoto
 * @author Guilherme Matuella
 */
@ManagedBean
@ViewScoped
public class AdministradorBean implements Serializable {

    private Consultor consultorEditado, consultorExcluido;
    private Cliente clienteEditado, clienteExcluido;

    public AdministradorBean() {
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

    public String editarSelecionado() {
        return "dashboard.xhtml?faces-redirect=true";
    }
}
