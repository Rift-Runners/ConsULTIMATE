/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.model.dao;

import com.riftrunners.consultimate.model.entity.Teste;
import javax.persistence.EntityManager;

/**
 *
 * @author Guilherme
 */
public class TesteDAO extends GenericDAO<Long, Teste>{
    
    public TesteDAO(EntityManager entityManager){
        super(entityManager);
    }
}
