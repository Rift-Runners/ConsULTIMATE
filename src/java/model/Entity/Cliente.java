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
public class Cliente {

    private String nome, cidade, uf, endereco, telefone, email, cpf, rg, usuario, senha;
    private List<Transacao> transacoesEfetuadas;
    private double saldo;

    public Cliente() {
    }

    //CopyConstructor
    public Cliente(Cliente outroCliente) {
        this.nome = outroCliente.getNome();
        this.cidade = outroCliente.getCidade();
        this.uf = outroCliente.getUf();
        this.endereco = outroCliente.getEndereco();
        this.telefone = outroCliente.getTelefone();
        this.email = outroCliente.getEmail();
        this.cpf = outroCliente.getCpf();
        this.rg = outroCliente.getRg();
        this.usuario = outroCliente.getUsuario();
        this.senha = outroCliente.getSenha();
        this.saldo = outroCliente.getSaldo();
        this.transacoesEfetuadas = outroCliente.getTransacoesEfetuadas();
    }

    public Cliente(String nome, String cidade, String uf, String endereco, String telefone, String email, String cpf, String rg, String usuario, String senha) {
        this.nome = nome;
        this.cidade = cidade;
        this.uf = uf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.rg = rg;
        this.usuario = usuario;
        this.senha = senha;
        this.saldo = 0d;
        this.transacoesEfetuadas = new ArrayList();
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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
