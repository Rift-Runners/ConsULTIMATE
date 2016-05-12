/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.controller;

import com.riftrunners.consultimate.manager.SimpleEntityManager;
import com.riftrunners.consultimate.model.entity.Consultor;
import com.riftrunners.consultimate.service.ConsultorService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author Diego Peixoto
 * @author Guilherme Matuella
 */
@ManagedBean
@SessionScoped
public class ConsultorBean {

    private Consultor consultor = new Consultor();
    private String tempSenhaRepete;

    /**
     * Creates a new instance of ConsultorBean
     */
    public ConsultorBean() {
    }

    public void registrarConsultor() {
        SimpleEntityManager simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
        ConsultorService consultorService = new ConsultorService(simpleEntityManager);
        consultorService.save(consultor, tempSenhaRepete);
        this.consultor = new Consultor();
    }

    public Consultor getConsultor() {
        return consultor;
    }

    public void setConsultor(Consultor consultor) {
        this.consultor = consultor;
    }

    public String getTempSenhaRepete() {
        return tempSenhaRepete;
    }

    public void setTempSenhaRepete(String tempSenhaRepete) {
        this.tempSenhaRepete = tempSenhaRepete;
    }
}
