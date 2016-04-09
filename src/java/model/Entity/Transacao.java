/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Entity;

import java.util.Date;

/**
 *
 * @author Guilherme
 */
public class Transacao {

    private Cliente cliente;
    private Consultor consultor;
    private double valor;
    private int horas;
    private Date dataDaCompra;
//    Detalhes da transação combinada entre o cliente 
//    e o consultor -> o consultor settará e o cliente deve aceitar antes de finalizar a compra.
    private String detalhes;

    public Transacao(Cliente cliente, Consultor consultor, double valor, int horas, Date dataDaCompra, String detalhes) {
        this.cliente = cliente;
        this.consultor = consultor;
        this.valor = valor;
        this.horas = horas;
        this.dataDaCompra = dataDaCompra;
        this.detalhes = detalhes;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public Date getDataDaCompra() {
        return dataDaCompra;
    }

    public void setDataDaCompra(Date dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

}
