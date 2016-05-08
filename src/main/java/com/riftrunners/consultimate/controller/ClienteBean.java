/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.controller;

import com.riftrunners.consultimate.manager.SimpleEntityManager;
import com.riftrunners.consultimate.model.entity.Cliente;
import com.riftrunners.consultimate.model.entity.Consultor;
import com.riftrunners.consultimate.service.ClienteService;
import com.riftrunners.consultimate.service.ConsultorService;
import com.riftrunners.consultimate.utils.Validators;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Guilherme
 */
@ManagedBean
@SessionScoped
public class ClienteBean {

    private Cliente cliente = new Cliente();
    private Validators validador = new Validators();
    private String tempSenhaRepete;

    /**
     * Creates a new instance of ClienteBean
     */
    public ClienteBean() {
    }

    public void registrarCliente() {
        if (confirmaSenha(cliente.getSenha(), tempSenhaRepete)) {
            if (validador.validaCliente(cliente)) {
                SimpleEntityManager simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
                ClienteService clienteService = new ClienteService(simpleEntityManager);
                clienteService.save(cliente);
                simpleEntityManager.close();
                this.cliente = new Cliente();
                RequestContext.getCurrentInstance().execute("PF('dialogSucesso').show()");
            } else {
                RequestContext.getCurrentInstance().execute("PF('dialogErro').show()");
            }
        } else {
            RequestContext.getCurrentInstance().execute("PF('dialogErro').show()");
        }
    }

    public boolean confirmaSenha(String senha, String repeteSenha) {
        return senha.equals(repeteSenha);
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
