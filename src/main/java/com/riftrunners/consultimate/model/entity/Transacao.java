/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.model.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Guilherme
 */
public class Transacao {

    @ManyToOne(targetEntity = Cliente.class, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne(targetEntity = Consultor.class, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "consultor_id")
    private Consultor consultor;
    private Double valor;
    private Integer horas;
    @Column(name="data_da_compra")
    private Date dataDaCompra;

    public Transacao(Cliente cliente, Consultor consultor, Double valor, Integer horas) {
        this.cliente = cliente;
        this.consultor = consultor;
        this.valor = valor;
        this.horas = horas;
        this.dataDaCompra = new Date();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Consultor getConsultor() {
        return consultor;
    }

    public void setConsultor(Consultor consultor) {
        this.consultor = consultor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public Date getDataDaCompra() {
        return dataDaCompra;
    }

    public void setDataDaCompra(Date dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }

}
