/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.Entity.Admin;
import model.Entity.Cliente;
import model.Entity.Consultor;
import model.Entity.ListasDados;

/**
 * @author Guilherme Matuella
 * @author Diego Peixoto
 */

@Named
@SessionScoped
public class SessionBean implements Serializable {

    private String usuario, senha;
    private Cliente cliente;
    private Consultor consultor;
    private Admin admin;
    private ListasDados listasDeDados;
    private boolean logged, clienteLogged, consultorLogged, adminLogged;

    /**
     * Creates a new instance of SessionBean
     */
    public SessionBean() {
        listasDeDados = new ListasDados();
        cliente = new Cliente();
        consultor = new Consultor();
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

    public String entrar() {
        for (Cliente clienteCadastrado : listasDeDados.getListaClientes()) {
            if (clienteCadastrado.getUsuario().equals(usuario)) {
                if (clienteCadastrado.getSenha().equals(senha)) {
                    clienteLogged = true;
                    logged = true;
                    cliente = clienteCadastrado;
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
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário e/ou senha inválidos.", null));
        return "login.xhtml";
    }

    public String sair() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.getExternalContext().invalidateSession();
        return ("login.xhtml?faces-redirect=true");
    }
}
