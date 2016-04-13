/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.Entity.Admin;
import model.Entity.Cliente;
import model.Entity.Consultor;
import model.Entity.ListasDados;
import model.Entity.Transacao;
import org.primefaces.context.RequestContext;
import utils.Validators;

/**
 * @author Guilherme Matuella
 * @author Diego Peixoto
 */
@Named
@SessionScoped
public class SessionBean implements Serializable {

    private String usuario, senha;
    private Cliente cliente, clienteEditado;
    private Consultor consultor, consultorEditado, consultorVisualizado;
    private Admin admin;
    private boolean logged, clienteLogged, consultorLogged, adminLogged;
    private double valorSaldo;
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

    public double getValorSaldo() {
        return valorSaldo;
    }

    public void setValorSaldo(double valorSaldo) {
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

    public String visualizaConsultor() {
        return "consultor-detalhes.xhtml?faces-redirect=true";
    }

    public String adicionarSaldo() {
        cliente.setSaldo(cliente.getSaldo() + valorSaldo);
        valorSaldo = 0d;
        return "minha-conta.xhtml?faces-redirect=true";
    }

    public String criarTransacao() {
        if (cliente.getSaldo() >= 100) {
            cliente.setSaldo(cliente.getSaldo() - 100);
            cliente.addTransacao(new Transacao(cliente, consultorVisualizado, 100, 1, Date.valueOf(LocalDate.now())));
        }
        return "minha-conta.xhtml?faces-redirect=true";
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
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário e/ou senha inválidos.", null));
        return "login.xhtml";
    }

    public String sair() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.getExternalContext().invalidateSession();
        return "login.xhtml?faces-redirect=true";
    }

    public String perguntarConsultor() {
        return "index.xhtml?faces-redirect=true";
    }

    public String deletarConta() {
        ListasDados listasDeDados = validador.listaControladorAplicacao();
        Cliente clienteDeletado = new Cliente();
        Consultor consultorDeletado = new Consultor();

        if (clienteLogged) {
            for (Cliente cli : listasDeDados.getListaClientes()) {
                if (cli.getUsuario().equals(cliente.getUsuario())) {
                    clienteDeletado = cli;
                }
            }
            listasDeDados.deletarCliente(clienteDeletado);
        } else {
            for (Consultor cons : listasDeDados.getListaConsultores()) {
                if (cons.getUsuario().equals(consultor.getUsuario())) {
                    consultorDeletado = cons;
                }
            }
            listasDeDados.deletarConsultor(consultorDeletado);
        }

        return sair();
    }

    public String editarConta() {
        ListasDados listasDeDados = validador.listaControladorAplicacao();
        if (clienteLogged) {
            if (validador.validaCliente(clienteEditado)) {
                listasDeDados.getListaClientes().set(listasDeDados.getListaClientes().indexOf(cliente), clienteEditado);
                cliente = clienteEditado;
                return "contato.xhtml?faces-redirect=true";
            } else {
                clienteEditado = new Cliente(cliente);
                return "index.xhtml?faces-redirect=true";
            }
        } else {
            if (validador.validaConsultor(consultorEditado)) {
                listasDeDados.getListaConsultores().set(listasDeDados.getListaConsultores().indexOf(consultor), consultorEditado);
                consultor = consultorEditado;
                return "contato.xhtml?faces-redirect=true";
            } else {
                consultorEditado = new Consultor(consultor);
                return "index.xhtml?faces-redirect=true";
            }
        }
    }

}
