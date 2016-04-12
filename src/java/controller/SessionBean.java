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
    private Cliente cliente;
    private Consultor consultor, consultorVisualizado;
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

    public String visualizaConsultor() {
        return "consultor-detalhes.xhtml";
    }

    public ListasDados listaControladorAplicacao() {
        MainController controladorPrincipal = (MainController) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("mainController");
        return controladorPrincipal.getListasDeDados();
    }

    public String adicionarSaldo() {
        ListasDados listasDeDados = listaControladorAplicacao();
        for (Cliente c : listasDeDados.getListaClientes()) {
            if (c.getUsuario().equals(cliente.getUsuario())) {
                c.setSaldo(c.getSaldo() + valorSaldo);
            }
        }
        valorSaldo = 0d;
        return "minha-conta.xhtml?faces-redirect=true";
    }

    public String criarTransacao() {
        ListasDados listasDeDados = listaControladorAplicacao();
        for (Cliente cli : listasDeDados.getListaClientes()) {
            if (cli.getUsuario().equals(cliente.getUsuario())) {
                for (Consultor cons : listasDeDados.getListaConsultores()) {
                    if (cons.getUsuario().equals(consultorVisualizado.getUsuario())) {
                        if (cli.getSaldo() >= 100) {
                            cli.setSaldo(cli.getSaldo() - 100);
                            cli.addTransacao(new Transacao(cli, cons, 100, 1, Date.valueOf(LocalDate.now())));
                        }
                    }
                }
            }
        }
        return "minha-conta.xhtml?faces-redirect=true";
    }

    public String entrar() {
        ListasDados listasDeDados = listaControladorAplicacao();
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
        return "login.xhtml?faces-redirect=true";
    }

    public String perguntarConsultor() {
        return "index.xhtml?faces-redirect=true";
    }

    public String deletarConta() {
        ListasDados listasDeDados = listaControladorAplicacao();
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
        //return "index.xhtml?faces-redirect=true";
        return sair();
    }

    public String editarConta() {
        ListasDados listasDeDados = listaControladorAplicacao();
        Cliente clienteEditado = new Cliente();
        Consultor consultorEditado = new Consultor();

        if (clienteLogged) {
            for (Cliente cli : listasDeDados.getListaClientes()) {
                if (cli.getUsuario().equals(cliente.getUsuario())) {
                    clienteEditado = cli;
                }
            }
            if (validador.validaCliente(cliente)) {
                listasDeDados.getListaClientes().set(listasDeDados.getListaClientes().indexOf(clienteEditado), cliente);
            } else {
                cliente = clienteEditado;
                RequestContext.getCurrentInstance().update("j_idt65"); //Não está funcionando
                return "index.xhtml?faces-redirect=true";
            }
        } else {
            for (Consultor cons : listasDeDados.getListaConsultores()) {
                if (cons.getUsuario().equals(consultor.getUsuario())) {
                    consultorEditado = cons;
                }
            }
            if (validador.validaConsultor(consultor)) {
                listasDeDados.getListaConsultores().set(listasDeDados.getListaConsultores().indexOf(consultorEditado), consultor);
            } else {
                consultor = consultorEditado;
            }
        }
        return "minha-conta.xhtml?faces-redirect=true";
    }

}
