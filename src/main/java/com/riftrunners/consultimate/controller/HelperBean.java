/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Guilherme
 */
@ManagedBean(eager = true)
@ApplicationScoped
public class HelperBean {

    /**
     * Creates a new instance of HelperBean
     */
    public HelperBean() {
    }

    public List<String> listaEstados() {
        List<String> estados = new ArrayList();
        estados.add("RS");
        estados.add("SC");
        estados.add("SP");
        estados.add("RJ");
        return estados;
    }

}
