/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.model.dao;

import com.riftrunners.consultimate.model.entity.Cliente;
import javax.persistence.EntityManager;

/**
 * @author Diego Peixoto
 * @author Guilherme Matuella
 */
public class ClienteDAO extends GenericDAO<Long, Cliente> {

    public ClienteDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
}
