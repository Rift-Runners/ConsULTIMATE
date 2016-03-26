/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.Entity.Cliente;
import model.Entity.Consultor;
import model.Entity.ListasDados;

/**
 *
 * @author 631420063
 */
@ManagedBean(eager = true)
@ApplicationScoped
public class MainController {

    private String usuario, senha;
    private ListasDados listasDeDados;
    private Consultor consultor;
    private Cliente cliente;

    public MainController() {
        consultor = new Consultor();
        cliente = new Cliente();
        listasDeDados = new ListasDados();
    }

    public ListasDados getListasDeDados() {
        return listasDeDados;
    }

    public void setListasDeDados(ListasDados listasDeDados) {
        this.listasDeDados = listasDeDados;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String registrarCliente() {
        listasDeDados.adicionarCliente(cliente);
        this.cliente = new Cliente();
        return "indexCli";
    }

    public String registarConsultor() {
        listasDeDados.adicionarConsultor(consultor);
        this.consultor = new Consultor();
        return "indexCons";
    }

    public String logar() {
        for (Cliente clienteCadastrado : listasDeDados.getListaClientes()) {
            if (clienteCadastrado.getUsuario().equals(usuario)) {
                if (clienteCadastrado.getSenha().equals(senha)) {
                    return "indexCons";
                }
            }
        }

        for (Consultor consultorCadastrado : listasDeDados.getListaConsultores()) {
            if (consultorCadastrado.getUsuario().equals(usuario)) {
                if (consultorCadastrado.getSenha().equals(senha)) {
                    return "indexCli";
                }
            }
        }
        return "index";
    }
}
