/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import model.Entity.Cliente;
import model.Entity.Consultor;
import model.Entity.ListasDados;

/**
 * @author Guilherme Matuella
 * @author Diego Peixoto
 */
@ManagedBean(eager = true)
@ApplicationScoped
public class MainController {

    private String usuario, senha, emailRecuperaSenha, tempSenhaRepete, consultoresAreaSelecionada;
    private ListasDados listasDeDados;
    private Consultor consultor;
    private Cliente cliente;

    public MainController() {
        consultor = new Consultor();
        cliente = new Cliente();
        listasDeDados = new ListasDados();
    }

    public String getConsultoresAreaSelecionada() {
        return consultoresAreaSelecionada;
    }

    public void setConsultoresAreaSelecionada(String consultoresAreaSelecionada) {
        this.consultoresAreaSelecionada = consultoresAreaSelecionada;
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

    public String getEmailRecuperaSenha() {
        return emailRecuperaSenha;
    }

    public void setEmailRecuperaSenha(String emailRecuperaSenha) {
        this.emailRecuperaSenha = emailRecuperaSenha;
    }

    public String getTempSenhaRepete() {
        return tempSenhaRepete;
    }

    public void setTempSenhaRepete(String tempSenhaRepete) {
        this.tempSenhaRepete = tempSenhaRepete;
    }

    public boolean confirmaSenha(String senha, String repeteSenha) {
        return senha.equals(repeteSenha);
    }

    public boolean isPaginaPrincipal() {
        HttpServletRequest servletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return servletRequest.getRequestURI().contains("index");
    }

    public String enviaDados() {
        for (Cliente clienteCadastrado : listasDeDados.getListaClientes()) {
            if (clienteCadastrado.getEmail().equals(emailRecuperaSenha)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Dados enviados para o e-mail.", null));
                //Enviar o usuario e a senha para o email.
                return "esqueceu-senha";
            }
        }
        for (Consultor consultorCadastrado : listasDeDados.getListaConsultores()) {
            if (consultorCadastrado.getEmail().equals(emailRecuperaSenha)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Dados enviados para o e-mail.", null));
                //Enviar o usuario e a senha para o email.
                return "esqueceu-senha";
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "E-mail não cadastrado.", null));
        return "esqueceu-senha";
    }

    public String registrarCliente() {
        if (confirmaSenha(cliente.getSenha(), tempSenhaRepete)) {
            listasDeDados.adicionarCliente(cliente);
            this.cliente = new Cliente();
            return "contato.xhtml?faces-redirect=true";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro no cadastro.", null));
        return "cadastro.xhtml";
    }

    public String registrarConsultor() {
        if (confirmaSenha(consultor.getSenha(), tempSenhaRepete)) {
            listasDeDados.adicionarConsultor(consultor);
            this.consultor = new Consultor();
            return "contato.xhtml?faces-redirect=true";
        }
        return "";
    }
  
}
