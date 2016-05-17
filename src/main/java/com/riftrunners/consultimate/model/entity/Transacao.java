/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Diego Peixoto
 * @author Guilherme Matuella
 */
@Entity
@Table(name = "transacao")
public class Transacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transacao_id")
    private Long id;

    @ManyToOne(targetEntity = Cliente.class, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne(targetEntity = Consultor.class, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "consultor_id")
    private Consultor consultor;
    private Integer valor;
    private Integer horas;
    @Column(name = "data_da_compra")
    @Temporal(TemporalType.DATE)
    private Date dataDaCompra;

    public Transacao() {
    }

    public Transacao(Cliente cliente, Consultor consultor, Integer valor, Integer horas) {
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

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.cliente);
        hash = 83 * hash + Objects.hashCode(this.consultor);
        hash = 83 * hash + Objects.hashCode(this.valor);
        hash = 83 * hash + Objects.hashCode(this.horas);
        hash = 83 * hash + Objects.hashCode(this.dataDaCompra);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transacao other = (Transacao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.consultor, other.consultor)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.horas, other.horas)) {
            return false;
        }
        if (!Objects.equals(this.dataDaCompra, other.dataDaCompra)) {
            return false;
        }
        return true;
    }

}
