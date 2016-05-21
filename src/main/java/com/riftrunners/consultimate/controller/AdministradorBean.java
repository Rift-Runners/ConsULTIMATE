/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.controller;

import com.riftrunners.consultimate.manager.SimpleEntityManager;
import javax.faces.bean.ManagedBean;
import com.riftrunners.consultimate.model.entity.Cliente;
import com.riftrunners.consultimate.model.entity.Consultor;
import com.riftrunners.consultimate.service.ClienteService;
import com.riftrunners.consultimate.service.ConsultorService;
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

    public String editarCliente() {
        SimpleEntityManager simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
        ClienteService clienteService = new ClienteService(simpleEntityManager);
        clienteService.edit(clienteEditado);
        this.clienteEditado = new Cliente();
        return "dashboard.xhtml?faces-redirect=true";
    }

    public String editarConsultor() {
        SimpleEntityManager simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
        ConsultorService consultorService = new ConsultorService(simpleEntityManager);
        consultorService.edit(consultorEditado);
        this.consultorEditado = new Consultor();
        return "dashboard.xhtml?faces-redirect=true";
    }

    public String deletarCliente() {
        SimpleEntityManager simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
        ClienteService clienteService = new ClienteService(simpleEntityManager);
        clienteService.remove(clienteEditado);
        return "dashboard.xhtml?faces-redirect=true";
    }

    public String deletarConsultor() {
        SimpleEntityManager simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
        ConsultorService consultorService = new ConsultorService(simpleEntityManager);
        consultorService.remove(consultorEditado);
        return "dashboard.xhtml?faces-redirect=true";
    }
}
