/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.service;

import com.riftrunners.consultimate.manager.SimpleEntityManager;
import com.riftrunners.consultimate.model.dao.AdministradorDAO;
import com.riftrunners.consultimate.model.entity.Administrador;
import java.util.List;

/**
 * @author Diego Peixoto
 * @author Guilherme Matuella
 */
public class AdministradorService {

    private AdministradorDAO dao;
    private SimpleEntityManager sem;

    public AdministradorService(SimpleEntityManager sem) {
        this.sem = sem;
        dao = new AdministradorDAO(this.sem.getEntityManager());
    }

    public List<Administrador> findAll() {
        return dao.findAll();
    }

    public Administrador getAdministradorLogin(String usuario, String senha) {
        for (Administrador administradorCadastrado : dao.findAll()) {
            if (administradorCadastrado.getUsuario().equals(usuario)
                    && administradorCadastrado.getSenha().equals(senha)) {
                return administradorCadastrado;
            }
        }
        return null;
    }
    
}
