/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.controller;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import com.riftrunners.consultimate.model.entity.Admin;
import com.riftrunners.consultimate.model.entity.Cliente;
import com.riftrunners.consultimate.model.entity.Consultor;
import com.riftrunners.consultimate.model.entity.ListasDados;
import com.riftrunners.consultimate.model.entity.Transacao;
import org.primefaces.context.RequestContext;
import com.riftrunners.consultimate.utils.Validators;

/**
 * @author Guilherme Matuella
 * @author Diego Peixoto
 */
@Named
@SessionScoped
public class SessionBean implements Serializable {

    private String usuario, senha, perguntaConsultor;
    private Cliente cliente, clienteEditado;
    private Consultor consultor, consultorEditado, consultorVisualizado;
    private Admin admin;
    private boolean logged, clienteLogged, consultorLogged, adminLogged;
    private int valorSaldo, valorSelecionado;
    private Validators validador;

    /**
     * Creates a new instance of SessionBean
     */
    public SessionBean() {
        cliente = new Cliente();
        consultor = new Consultor();
        consultorVisualizado = new Consultor();
        validador = new Validators();
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

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public boolean isClienteLogged() {
        return clienteLogged;
    }

    public void setClienteLogged(boolean clienteLogged) {
        this.clienteLogged = clienteLogged;
    }

    public boolean isConsultorLogged() {
        return consultorLogged;
    }

    public void setConsultorLogged(boolean consultorLogged) {
        this.consultorLogged = consultorLogged;
    }

    public boolean isAdminLogged() {
        return adminLogged;
    }

    public void setAdminLogged(boolean adminLogged) {
        this.adminLogged = adminLogged;
    }

    public int getValorSaldo() {
        return valorSaldo;
    }

    public void setValorSaldo(int valorSaldo) {
        this.valorSaldo = valorSaldo;
    }

    public Consultor getConsultorVisualizado() {
        return consultorVisualizado;
    }

    public void setConsultorVisualizado(Consultor consultorVisualizado) {
        this.consultorVisualizado = consultorVisualizado;
    }

    public Cliente getClienteEditado() {
        return clienteEditado;
    }

    public void setClienteEditado(Cliente clienteEditado) {
        this.clienteEditado = clienteEditado;
    }

    public Consultor getConsultorEditado() {
        return consultorEditado;
    }

    public void setConsultorEditado(Consultor consultorEditado) {
        this.consultorEditado = consultorEditado;
    }

    public int getValorSelecionado() {
        return valorSelecionado;
    }

    public void setValorSelecionado(int valorSelecionado) {
        this.valorSelecionado = valorSelecionado;
    }

    public String getPerguntaConsultor() {
        return perguntaConsultor;
    }

    public void setPerguntaConsultor(String perguntaConsultor) {
        this.perguntaConsultor = perguntaConsultor;
    }

    public String visualizaConsultor() {
        //AINDA NÃO IMPLEMENTADO!
        return "consultor-detalhes.xhtml?faces-redirect=true";
    }

    public String adicionarSaldo() {
        cliente.setSaldo(cliente.getSaldo() + valorSaldo);
        valorSaldo = 0;
        return "";
    }

    public int[] valoresConsultorVisualizado() {
        int valorBase = consultorVisualizado.getValorHora();
        return new int[]{valorBase, valorBase * 4, valorBase * 7, valorBase * 12};
    }

    public int calculaHoraSelecionado(int valor) {
        if (valor == valorSelecionado) {
            return 1;
        } else if (valor * 4 == valorSelecionado) {
            return 5;
        } else if (valor * 7 == valorSelecionado) {
            return 10;
        } else {
            return 20;
        }
    }

    public void criarTransacao() {
        if (cliente.getSaldo() >= valorSelecionado && valorSelecionado > 0) {
            cliente.setSaldo(cliente.getSaldo() - valorSelecionado);

            Transacao transacao = new Transacao(cliente, consultorVisualizado, valorSelecionado, calculaHoraSelecionado(consultorVisualizado.getValorHora()));
            cliente.addTransacao(transacao);
            consultorVisualizado.addTransacao(transacao);
            RequestContext.getCurrentInstance().execute("PF('dialogTransacao').show()");
        } else {
            RequestContext.getCurrentInstance().execute("PF('dialogSaldoInsuficiente').show()");
        }
        valorSelecionado = 0;
    }

    public String entrar() {
        ListasDados listasDeDados = validador.listaControladorAplicacao();
        for (Cliente clienteCadastrado : listasDeDados.getListaClientes()) {
            if (clienteCadastrado.getUsuario().equals(usuario)) {
                if (clienteCadastrado.getSenha().equals(senha)) {
                    clienteLogged = true;
                    logged = true;
                    cliente = clienteCadastrado;
                    clienteEditado = new Cliente(cliente);
                    return "index.xhtml?faces-redirect=true";
                }
            }
        }

        for (Consultor consultorCadastrado : listasDeDados.getListaConsultores()) {
            if (consultorCadastrado.getUsuario().equals(usuario)) {
                if (consultorCadastrado.getSenha().equals(senha)) {
                    consultorLogged = true;
                    logged = true;
                    consultor = consultorCadastrado;
                    consultorEditado = new Consultor(consultor);
                    return "index.xhtml?faces-redirect=true";
                }
            }
        }

        for (Admin adminCadastrado : listasDeDados.getListaAdmin()) {
            if (adminCadastrado.getUsuario().equals(usuario)) {
                if (adminCadastrado.getSenha().equals(senha)) {
                    adminLogged = true;
                    logged = true;
                    admin = adminCadastrado;
                    return "index.xhtml?faces-redirect=true";
                }
            }
        }
        RequestContext.getCurrentInstance().execute("PF('dialogInvalida').show()");
        return "";
    }

    public String sair() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.getExternalContext().invalidateSession();
        return "login.xhtml?faces-redirect=true";
    }

    public void perguntarConsultor() {
        this.perguntaConsultor = "";
        RequestContext.getCurrentInstance().execute("PF('dialogPergunta').show()");
    }

    public String deletarConta() {
        ListasDados listasDeDados = validador.listaControladorAplicacao();
        if (clienteLogged) {
            listasDeDados.deletarCliente(cliente);
        } else {
            listasDeDados.deletarConsultor(consultor);
        }
        return sair();
    }

    public String editarConta() {
        ListasDados listasDeDados = validador.listaControladorAplicacao();
        if (clienteLogged) {
            if (validador.validaCliente(clienteEditado)) {
                listasDeDados.getListaClientes().set(listasDeDados.getListaClientes().indexOf(cliente), clienteEditado);
                cliente = clienteEditado;
                RequestContext.getCurrentInstance().execute("PF('dialogEditarSucesso').show()");
            } else {
                clienteEditado = new Cliente(cliente);
                RequestContext.getCurrentInstance().execute("PF('dialogEditarErro').show()");
            }
        } else if (validador.validaConsultor(consultorEditado)) {
            listasDeDados.getListaConsultores().set(listasDeDados.getListaConsultores().indexOf(consultor), consultorEditado);
            consultor = consultorEditado;
            RequestContext.getCurrentInstance().execute("PF('dialogEditarSucesso').show()");
            return "";
        } else {
            consultorEditado = new Consultor(consultor);
            RequestContext.getCurrentInstance().execute("PF('dialogEditarErro').show()");
            return "";
        }
        return "";
    }

    public boolean isListaTransacoesVazia() {
        if (clienteLogged) {
            return cliente.getTransacoesEfetuadas().isEmpty();
        } else {
            return consultor.getTransacoesEfetuadas().isEmpty();
        }
    }

}
