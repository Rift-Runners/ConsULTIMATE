/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Entity.Consultor;

/**
 *
 * @author Guilherme
 */
@ManagedBean
@SessionScoped
public class AdminBean {

    Consultor consultorEditado;

    public AdminBean() {
        consultorEditado = new Consultor();
    }

    public Consultor getConsultorEditado() {
        return consultorEditado;
    }

    public void setConsultorEditado(Consultor consultorEditado) {
        this.consultorEditado = consultorEditado;
    }

    public String adminEditarConsultor() {
        return "admEditar.xhtml?faces-redirect=true";
    }

    public String salvarEdicao() {
        consultorEditado = new Consultor();
        return "dashboard.xhtml?faces-redirect=true";
    }
}
