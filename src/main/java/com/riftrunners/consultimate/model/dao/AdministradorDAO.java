/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.model.dao;

import com.riftrunners.consultimate.model.entity.Administrador;
import javax.persistence.EntityManager;

/**
 * @author Diego Peixoto
 * @author Guilherme Matuella
 */
public class AdministradorDAO extends GenericDAO<Long, Administrador> {

    public AdministradorDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
}
