/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.Cliente;
import model.Consultor;
import model.ListasDados;

/**
 *
 * @author 631420063
 */
@ManagedBean(eager = true)
@ApplicationScoped
public class PessoaController {

    private String usuario, senha;
    private ListasDados listasDeDados;

    /**
     * Creates a new instance of PessoaController
     */
    public PessoaController() {
        listasDeDados = new ListasDados();
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

    public String autenticar() {
        for (Cliente cliente : listasDeDados.getlistaClientes()) {
            if(cliente.getUsuario().equals(usuario)){
                if(cliente.getSenha().equals(senha)){
                    return "indexCli";
                }
            }
        }
        for (Consultor consultor : listasDeDados.getListaConsultores()){
            if(consultor.getUsuario().equals(usuario)){
                if(consultor.getSenha().equals(senha)){
                    return "indexCons";
                }
            }            
        }
        return "index";
    }
}
