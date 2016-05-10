/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.controller;

import com.riftrunners.consultimate.manager.SimpleEntityManager;
import com.riftrunners.consultimate.model.entity.Cliente;
import com.riftrunners.consultimate.service.ClienteService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Guilherme
 */
@ManagedBean
@ViewScoped
public class ClienteBean {

    private Cliente cliente = new Cliente();
    private String tempSenhaRepete;

    /**
     * Creates a new instance of ClienteBean
     */
    public ClienteBean() {
    }

    public void registrarCliente() {
        SimpleEntityManager simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
        ClienteService clienteService = new ClienteService(simpleEntityManager);
        clienteService.save(cliente, tempSenhaRepete);
        this.cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTempSenhaRepete() {
        return tempSenhaRepete;
    }

    public void setTempSenhaRepete(String tempSenhaRepete) {
        this.tempSenhaRepete = tempSenhaRepete;
    }
}
