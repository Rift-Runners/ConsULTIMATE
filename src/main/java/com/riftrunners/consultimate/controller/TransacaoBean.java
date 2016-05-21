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
import com.riftrunners.consultimate.service.TransacaoService;
import com.riftrunners.consultimate.util.ConsultimateUtil;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

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
    private ConsultimateUtil consultimateUtil = new ConsultimateUtil();

    /**
     * Creates a new instance of ClienteBean
     */
    public TransacaoBean() {
    }

    public void registrarTransacao() {
        SimpleEntityManager simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
        TransacaoService transacaoService = new TransacaoService(simpleEntityManager);
        if (cliente.getSaldo() >= valorSelecionado) {
            cliente.setSaldo(cliente.getSaldo() - valorSelecionado);
            Transacao transacao = new Transacao(cliente, consultor, valorSelecionado, consultimateUtil.calculaHoraSelecionado(consultor.getValorHora(), valorSelecionado));
            transacaoService.save(transacao);

            valorSelecionado = 0;
        } else {
            RequestContext.getCurrentInstance().execute("PF('dialogSaldoInsuficiente').show()");
        }
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
