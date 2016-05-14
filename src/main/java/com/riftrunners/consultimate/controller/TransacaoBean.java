/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.controller;

import com.riftrunners.consultimate.manager.SimpleEntityManager;
import com.riftrunners.consultimate.model.entity.Cliente;
import com.riftrunners.consultimate.model.entity.Consultor;
import com.riftrunners.consultimate.model.entity.Transacao;
import com.riftrunners.consultimate.service.ClienteService;
import com.riftrunners.consultimate.service.ConsultorService;
import com.riftrunners.consultimate.service.TransacaoService;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * @author Diego Peixoto
 * @author Guilherme Matuella
 */
@ManagedBean
@ViewScoped
public class TransacaoBean implements Serializable {

    @ManagedProperty(value = "#{sessionBean.consultorVisualizado}")
    private Consultor consultor;
    @ManagedProperty(value = "#{sessionBean.cliente}")
    private Cliente cliente;
    private Integer valorSelecionado;

    /**
     * Creates a new instance of ClienteBean
     */
    public TransacaoBean() {
    }

    public void registrarTransacao() {
        SimpleEntityManager simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
        TransacaoService transacaoService = new TransacaoService(simpleEntityManager);
        transacaoService.save(cliente, consultor, valorSelecionado);
//        simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
//        ClienteService clienteService = new ClienteService(simpleEntityManager);
//        cliente.addTransacao(transacao);
//        clienteService.edit(cliente);
//        simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
//        ConsultorService consultorService = new ConsultorService(simpleEntityManager);
//        consultorVisualizado.addTransacao(transacao);
//        consultorService.edit(consultor);
        valorSelecionado = 0;
    }

    public Consultor getConsultor() {
        return consultor;
    }

    public void setConsultor(Consultor consultor) {
        this.consultor = consultor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getValorSelecionado() {
        return valorSelecionado;
    }

    public void setValorSelecionado(Integer valorSelecionado) {
        this.valorSelecionado = valorSelecionado;
    }

}
