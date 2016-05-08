/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.controller;

import com.riftrunners.consultimate.manager.SimpleEntityManager;
import com.riftrunners.consultimate.model.entity.Consultor;
import com.riftrunners.consultimate.service.ConsultorService;
import com.riftrunners.consultimate.utils.Validators;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Guilherme
 */
@ManagedBean
@SessionScoped
public class ConsultorBean {

    private Consultor consultor = new Consultor();
    private Validators validador = new Validators();
    private String tempSenhaRepete;

    /**
     * Creates a new instance of ConsultorBean
     */
    public ConsultorBean() {
    }

    public void registrarConsultor() {
        if (confirmaSenha(consultor.getSenha(), tempSenhaRepete)) {
            if (validador.validaConsultor(consultor)) {
                SimpleEntityManager simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
                ConsultorService consultorService = new ConsultorService(simpleEntityManager);
                consultorService.save(consultor);
                simpleEntityManager.close();
                this.consultor = new Consultor();
                RequestContext.getCurrentInstance().execute("PF('dialogSucesso').show()");
            } else {
                RequestContext.getCurrentInstance().execute("PF('dialogErro').show()");
            }
        } else {
            RequestContext.getCurrentInstance().execute("PF('dialogErro').show()");
        }
    }

    public boolean confirmaSenha(String senha, String repeteSenha) {
        return senha.equals(repeteSenha);
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
