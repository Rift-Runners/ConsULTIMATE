/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Entity.Admin;
import model.Entity.Cliente;
import model.Entity.Consultor;
import model.Entity.ListasDados;

/**
 *
 * @author Guilherme
 */
@ManagedBean(name = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable {

    private String usuario, senha;
    private Cliente cliente;
    private Consultor consultor;
    private Admin admin;
    private ListasDados listasDeDados;
    public boolean isLogged, clienteIsLogged, consultorIsLogged, adminIsLogged;

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

    public boolean isIsLogged() {
        return isLogged;
    }

    public void setIsLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }

    public boolean isClienteIsLogged() {
        return clienteIsLogged;
    }

    public void setClienteIsLogged(boolean clienteIsLogged) {
        this.clienteIsLogged = clienteIsLogged;
    }

    public boolean isConsultorIsLogged() {
        return consultorIsLogged;
    }

    public void setConsultorIsLogged(boolean consultorIsLogged) {
        this.consultorIsLogged = consultorIsLogged;
    }

    public boolean isAdminIsLogged() {
        return adminIsLogged;
    }

    public void setAdminIsLogged(boolean adminIsLogged) {
        this.adminIsLogged = adminIsLogged;
    }

    public String entrar() {
        for (Cliente clienteCadastrado : listasDeDados.getListaClientes()) {
            if (clienteCadastrado.getUsuario().equals(usuario)) {
                if (clienteCadastrado.getSenha().equals(senha)) {
                    clienteIsLogged = true;
                    isLogged = true;
                    cliente = clienteCadastrado;
                    return "index.xhtml?faces-redirect=true";
                }
            }
        }

        for (Consultor consultorCadastrado : listasDeDados.getListaConsultores()) {
            if (consultorCadastrado.getUsuario().equals(usuario)) {
                if (consultorCadastrado.getSenha().equals(senha)) {
                    consultorIsLogged = true;
                    isLogged = true;
                    consultor = consultorCadastrado;
                    return "index.xhtml?faces-redirect=true";
                }
            }
        }
        
        for (Admin adminCadastrado : listasDeDados.getListaAdmin()) {
            if (adminCadastrado.getUsuario().equals(usuario)) {
                if (adminCadastrado.getSenha().equals(senha)) {
                    adminIsLogged = true;
                    isLogged = true;
                    admin = adminCadastrado;
                    return "index.xhtml?faces-redirect=true";
                }
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário e/ou senha inválidos.", null));
        return "login.xhtml";
    }
}
