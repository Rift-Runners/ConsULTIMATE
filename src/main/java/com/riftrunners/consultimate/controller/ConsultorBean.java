/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.controller;

import com.riftrunners.consultimate.manager.SimpleEntityManager;
import com.riftrunners.consultimate.model.entity.Consultor;
import com.riftrunners.consultimate.model.entity.Transacao;
import com.riftrunners.consultimate.service.ConsultorService;
import com.riftrunners.consultimate.service.TransacaoService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 * @author Diego Peixoto
 * @author Guilherme Matuella
 */
@ManagedBean
@RequestScoped
public class ConsultorBean implements Serializable {

    private Consultor consultor = new Consultor();
    @ManagedProperty(value = "#{sessionBean.consultor}")
    private Consultor consultorEditado;
    private String tempSenhaRepete;

    /**
     * Creates a new instance of ConsultorBean
     */
    public ConsultorBean() {
    }

    public void registrarConsultor() {
        SimpleEntityManager simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
        ConsultorService consultorService = new ConsultorService(simpleEntityManager);
        try {
            consultorService.save(consultor, tempSenhaRepete);
        } catch (IllegalStateException uniqueError) {
            RequestContext.getCurrentInstance().execute("PF('dialogErroDuplicado').show()");
        }
        this.consultor = new Consultor();
    }

    public void editarConsultor() {
        SimpleEntityManager simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
        ConsultorService consultorService = new ConsultorService(simpleEntityManager);
        try {
            consultorService.edit(consultorEditado);
        } catch (IllegalStateException uniqueError) {
            RequestContext.getCurrentInstance().execute("PF('dialogErroDuplicado').show()");
        }
        this.consultorEditado = new Consultor();
    }

    public String deletarConsultor() {
        SimpleEntityManager simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
        ConsultorService consultorService = new ConsultorService(simpleEntityManager);
        consultorService.remove(consultorEditado);
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.getExternalContext().invalidateSession();
        return "index.xhtml?faces-redirect=true";
    }

    public List<Consultor> listaConsultores() {
        SimpleEntityManager simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
        ConsultorService consultorService = new ConsultorService(simpleEntityManager);
        return consultorService.findAll();
    }

    public List<Transacao> transacoesDoConsultor() {
        SimpleEntityManager simpleEntityManager = new SimpleEntityManager("ConsultimatePU");
        TransacaoService transacaoService = new TransacaoService(simpleEntityManager);
        return transacaoService.transacoesDoConsultor(consultorEditado);
    }

    public Consultor getConsultor() {
        return consultor;
    }

    public void setConsultor(Consultor consultor) {
        this.consultor = consultor;
    }

    public Consultor getConsultorEditado() {
        return consultorEditado;
    }

    public void setConsultorEditado(Consultor consultorEditado) {
        this.consultorEditado = consultorEditado;
    }

    public String getTempSenhaRepete() {
        return tempSenhaRepete;
    }

    public void setTempSenhaRepete(String tempSenhaRepete) {
        this.tempSenhaRepete = tempSenhaRepete;
    }

}
