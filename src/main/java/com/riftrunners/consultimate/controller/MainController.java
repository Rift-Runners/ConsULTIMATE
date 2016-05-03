/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import com.riftrunners.consultimate.model.entity.Cliente;
import com.riftrunners.consultimate.model.entity.Consultor;
import com.riftrunners.consultimate.model.entity.ListasDados;
import org.primefaces.context.RequestContext;
import com.riftrunners.consultimate.utils.Validators;

/**
 * @author Guilherme Matuella
 * @author Diego Peixoto
 */
@ManagedBean(eager = true)
@ApplicationScoped
public class MainController {

    private String usuario, senha, emailRecuperaSenha, tempSenhaRepete, consultoresAreaSelecionada,
            contatoNome, contatoEmail, contatoDescricao;
    private ListasDados listasDeDados;
    private Consultor consultor;
    private Cliente cliente;
    private Validators validador;

    public MainController() {
        consultor = new Consultor();
        cliente = new Cliente();
        listasDeDados = new ListasDados();
        validador = new Validators();
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

    public String getContatoNome() {
        return contatoNome;
    }

    public void setContatoNome(String contatoNome) {
        this.contatoNome = contatoNome;
    }

    public String getContatoEmail() {
        return contatoEmail;
    }

    public String getContatoDescricao() {
        return contatoDescricao;
    }

    public void setContatoDescricao(String contatoDescricao) {
        this.contatoDescricao = contatoDescricao;
    }

    public void setContatoEmail(String contatoEmail) {
        this.contatoEmail = contatoEmail;
    }

    public String stringMinimizada(String texto, int tamanhoMaximo) {
        return texto.substring(0, Math.min(texto.length(), tamanhoMaximo));
    }

    public Map<String, Integer> consultorPorArea() {
        Map<String, Integer> mapaAreas = new HashMap();
        for (Consultor cons : listasDeDados.getListaConsultores()) {
            if (!mapaAreas.containsKey(cons.getArea())) {
                mapaAreas.put(cons.getArea(), 1);
            } else {
                mapaAreas.put(cons.getArea(), mapaAreas.get(cons.getArea()) + 1);
            }
        }
        return mapaAreas;
    }

    public Map<String, Integer> transacoesPorArea() {
        Map<String, Integer> mapaAreas = new TreeMap();

        listasDeDados.getListaConsultores().stream().forEach((cons) -> {
            if (!mapaAreas.containsKey(cons.getArea())) {
                mapaAreas.put(cons.getArea(), cons.getTransacoesEfetuadas().size());
            } else {
                mapaAreas.put(cons.getArea(), mapaAreas.get(cons.getArea()) + cons.getTransacoesEfetuadas().size());
            }
        });
        return mapaAreas;
    }

    public Map<String, Integer> consultoresMaisVendem() {
        Map<String, Integer> mapaAreas = new TreeMap();

        listasDeDados.getListaConsultores().stream().forEach((cons) -> {
            int valorTotalTransacoes = 0;
            valorTotalTransacoes = cons.getTransacoesEfetuadas().stream().map((transacao) -> transacao.getValor()).reduce(valorTotalTransacoes, Integer::sum);

            if (!mapaAreas.containsKey(cons.getNome())) {
                mapaAreas.put(cons.getNome(), valorTotalTransacoes);
            } else {
                mapaAreas.put(cons.getNome(), mapaAreas.get(cons.getNome()) + valorTotalTransacoes);
            }
        });
        return mapaAreas;
    }

    public List<String> listaEstados() {
        List<String> estados = new ArrayList();
        estados.add("RS");
        estados.add("SC");
        estados.add("SP");
        estados.add("RJ");
        return estados;
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
                return redirecionaLogin();
            }
        }
        for (Consultor consultorCadastrado : listasDeDados.getListaConsultores()) {
            if (consultorCadastrado.getEmail().equals(emailRecuperaSenha)) {
                return redirecionaLogin();
            }
        }
        return redirecionaLogin();
    }

    public void enviarContato() {
        this.contatoDescricao = "";
        this.contatoEmail = "";
        this.contatoNome = "";
        RequestContext.getCurrentInstance().execute("PF('dialogContato').show()");
    }

    public void deletarContaDialog() {
        RequestContext.getCurrentInstance().execute("PF('dialogDeletar').show()");
    }

    public String redirecionaLogin() {
        return "login.xhtml?faces-redirect=true";
    }

    public String redirecionaContato() {
        return "contato.xhtml?faces-redirect=true";
    }

    public String redirecionaCadastro() {
        return "cadastro.xhtml?faces-redirect=true";
    }

    public void registrarCliente() {
        if (confirmaSenha(cliente.getSenha(), tempSenhaRepete)) {
            if (validador.validaCliente(cliente)) {
                listasDeDados.adicionarCliente(cliente);
                this.cliente = new Cliente();
                RequestContext.getCurrentInstance().execute("PF('dialogSucesso').show()");
            } else {
                RequestContext.getCurrentInstance().execute("PF('dialogErro').show()");
            }
        } else {
            RequestContext.getCurrentInstance().execute("PF('dialogErro').show()");
        }
    }

    public void registrarConsultor() {
        if (confirmaSenha(consultor.getSenha(), tempSenhaRepete)) {
            if (validador.validaConsultor(consultor)) {
                listasDeDados.adicionarConsultor(consultor);
                this.consultor = new Consultor();
                RequestContext.getCurrentInstance().execute("PF('dialogSucesso').show()");
            } else {
                RequestContext.getCurrentInstance().execute("PF('dialogErro').show()");
            }
        } else {
            RequestContext.getCurrentInstance().execute("PF('dialogErro').show()");
        }
    }

}
