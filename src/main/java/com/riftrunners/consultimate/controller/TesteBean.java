/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.controller;

import com.riftrunners.consultimate.manager.SimpleEntityManager;
import com.riftrunners.consultimate.model.entity.Teste;
import com.riftrunners.consultimate.service.TesteService;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Guilherme
 */
@ManagedBean
@SessionScoped
public class TesteBean {

    private Teste teste = new Teste();
    
    public TesteBean() {
    }
    
    public String salvarTeste(){
        SimpleEntityManager simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
        TesteService testeService = new TesteService(simpleEntityManager);
        testeService.save(teste);
        simpleEntityManager.close();
        teste = new Teste();
        return "teste-add.xhtml?faces-redirect=true";
    }
    
    public List<Teste> listarTeste(){
        SimpleEntityManager simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
        TesteService testeService = new TesteService(simpleEntityManager);
        List<Teste> testeList = testeService.findAll();
        simpleEntityManager.close();
        return testeList;
    }

    public Teste getTeste() {
        return teste;
    }

    public void setTeste(Teste teste) {
        this.teste = teste;
    }
}
