/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Entity;

/**
 *
 * @author Guilherme
 */
public class Area {
 
    public String nome;
    public int qtdConsultores;
    public int qtdTransacoes;

    public Area(String nome) {
        this.nome = nome;
    }    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdConsultores() {
        return qtdConsultores;
    }

    public void setQtdConsultores(int qtdConsultores) {
        this.qtdConsultores = qtdConsultores;
    }

    public int getQtdTransacoes() {
        return qtdTransacoes;
    }

    public void setQtdTransacoes(int qtdTransacoes) {
        this.qtdTransacoes = qtdTransacoes;
    }
    
}
