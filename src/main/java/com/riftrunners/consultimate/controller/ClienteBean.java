/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.controller;

import com.riftrunners.consultimate.manager.SimpleEntityManager;
import com.riftrunners.consultimate.model.entity.Cliente;
import com.riftrunners.consultimate.model.entity.Transacao;
import com.riftrunners.consultimate.service.ClienteService;
import com.riftrunners.consultimate.service.TransacaoService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 * @author Diego Peixoto
 * @author Guilherme Matuella
 */
@ManagedBean
@RequestScoped
public class ClienteBean implements Serializable {

    private Cliente cliente = new Cliente();
    @ManagedProperty(value = "#{sessionBean.cliente}")
    private Cliente clienteEditado;
    private String tempSenhaRepete;
    private Integer valorSaldo;

    /**
     * Creates a new instance of ClienteBean
     */
    public ClienteBean() {
    }

    public void registrarCliente() {
        SimpleEntityManager simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
        ClienteService clienteService = new ClienteService(simpleEntityManager);
        this.cliente.setSaldo(0D);
        try {
            clienteService.save(cliente, tempSenhaRepete);
        } catch (IllegalStateException uniqueError) {
            RequestContext.getCurrentInstance().execute("PF('dialogErroDuplicado').show()");
        }
        this.cliente = new Cliente();
    }

    public void editarCliente() {
        SimpleEntityManager simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
        ClienteService clienteService = new ClienteService(simpleEntityManager);
        try {
            clienteService.edit(clienteEditado);
        } catch (IllegalStateException uniqueError) {
            RequestContext.getCurrentInstance().execute("PF('dialogErroDuplicado').show()");
        }
        this.clienteEditado = new Cliente();
    }

    public String deletarCliente() {
        SimpleEntityManager simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
        ClienteService clienteService = new ClienteService(simpleEntityManager);
        clienteService.remove(clienteEditado);
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.getExternalContext().invalidateSession();
        return "index.xhtml?faces-redirect=true";
    }

    public String adicionarSaldo() {
        clienteEditado.setSaldo(clienteEditado.getSaldo() + valorSaldo);
        SimpleEntityManager simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
        ClienteService clienteService = new ClienteService(simpleEntityManager);
        clienteService.edit(clienteEditado);
        valorSaldo = 0;
        return "minha-conta.xhtml?faces-redirect=true";
    }

    public List<Transacao> transacoesDoCliente() {
        SimpleEntityManager simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
        TransacaoService transacaoService = new TransacaoService(simpleEntityManager);
        return transacaoService.transacoesDoCliente(clienteEditado);
    }

    public List<Cliente> listarClientes() {
        SimpleEntityManager simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
        ClienteService clienteService = new ClienteService(simpleEntityManager);
        return clienteService.findAll();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getClienteEditado() {
        return clienteEditado;
    }

    public void setClienteEditado(Cliente clienteEditado) {
        this.clienteEditado = clienteEditado;
    }

    public String getTempSenhaRepete() {
        return tempSenhaRepete;
    }

    public void setTempSenhaRepete(String tempSenhaRepete) {
        this.tempSenhaRepete = tempSenhaRepete;
    }

    public Integer getValorSaldo() {
        return valorSaldo;
    }

    public void setValorSaldo(Integer valorSaldo) {
        this.valorSaldo = valorSaldo;
    }

}
