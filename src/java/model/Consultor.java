/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 631420063
 */
public class Consultor extends Pessoa{

    String categoria, cnpj, descricao, area;

    public Consultor(String categoria, String cnpj, String descricao, String area, String nome, String cidade, String uf, String endereco, String telefone, String email, String usuario, String senha) {
        super(nome, cidade, uf, endereco, telefone, email, usuario, senha);
        this.categoria = categoria;
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.area = area;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
    
}
