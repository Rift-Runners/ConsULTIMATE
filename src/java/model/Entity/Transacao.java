/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Guilherme
 */
public class Transacao {

    private Cliente cliente;
    private Consultor consultor;
    private int valor, horas;
    private Date dataDaCompra;

    public Transacao(Cliente cliente, Consultor consultor, int valor, int horas) {
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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
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

}
