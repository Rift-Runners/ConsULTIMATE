/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Guilherme Matuella
 * @author Diego Peixoto
 */
public class Consultor{

    private String nome, cidade, uf, endereco, telefone, email, cnpj, descricao, area, usuario, senha;
    private List<Transacao> transacoesEfetuadas;
    
    public Consultor(){
    }
    
    public Consultor(String nome, String cidade, String uf, String endereco, String telefone, String email, String cnpj, String descricao, String area, String usuario, String senha) {
        this.nome = nome;
        this.cidade = cidade;
        this.uf = uf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.area = area;
        this.usuario = usuario;
        this.senha = senha;
        this.transacoesEfetuadas = new ArrayList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public List<Transacao> getTransacoesEfetuadas() {
        return transacoesEfetuadas;
    }

    public void addTransacao(Transacao transacao) {
        this.transacoesEfetuadas.add(transacao);
    }   
}
