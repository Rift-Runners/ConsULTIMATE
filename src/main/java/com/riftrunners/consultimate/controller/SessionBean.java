/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.controller;

import com.riftrunners.consultimate.manager.SimpleEntityManager;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import com.riftrunners.consultimate.model.entity.Admin;
import com.riftrunners.consultimate.model.entity.Cliente;
import com.riftrunners.consultimate.model.entity.Consultor;
import com.riftrunners.consultimate.service.ClienteService;
import com.riftrunners.consultimate.service.ConsultorService;
import org.primefaces.context.RequestContext;

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

    /**
     * Creates a new instance of SessionBean
     */
    public SessionBean() {
        cliente = new Cliente();
        consultor = new Consultor();
        consultorVisualizado = new Consultor();
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

//    public String visualizaConsultor() {
//        //AINDA NÃO IMPLEMENTADO!
//        return "consultor-detalhes.xhtml?faces-redirect=true";
//    }
//
//    public String adicionarSaldo() {
//        cliente.setSaldo(cliente.getSaldo() + valorSaldo);
//        valorSaldo = 0;
//        return "";
//    }
//
    
    public String login() {
        SimpleEntityManager simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
        ClienteService clienteService = new ClienteService(simpleEntityManager);
        Cliente clienteCadastrado = clienteService.getClienteLogin(usuario, senha);
        if (clienteCadastrado != null) {
            clienteLogged = true;
            logged = true;
            cliente = clienteCadastrado;
            clienteEditado = new Cliente(cliente);
            return "index.xhtml?faces-redirect=true";
        } else {
            ConsultorService consultorService = new ConsultorService(simpleEntityManager);
            Consultor consultorCadastrado = consultorService.getConsultorLogin(usuario, senha);
            if (consultorCadastrado != null) {
                consultorLogged = true;
                logged = true;
                consultor = consultorCadastrado;
                consultorEditado = new Consultor(consultor);
                return "index.xhtml?faces-redirect=true";
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

//    public void perguntarConsultor() {
//        this.perguntaConsultor = "";
//        RequestContext.getCurrentInstance().execute("PF('dialogPergunta').show()");
//    }
//
//
//    public boolean isListaTransacoesVazia() {
//        if (clienteLogged) {
//            return cliente.getTransacoesEfetuadas().isEmpty();
//        } else {
//            return consultor.getTransacoesEfetuadas().isEmpty();
//        }
//    }
}
