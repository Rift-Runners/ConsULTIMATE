/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.model.dao;

import com.riftrunners.consultimate.model.entity.Consultor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * @author Diego Peixoto
 * @author Guilherme Matuella
 */
public class ConsultorDAO extends GenericDAO<Long, Consultor> {

    public ConsultorDAO(EntityManager entityManager) {
        super(entityManager);
    }

     public List<Consultor> getConsultoresAtivos() {
        TypedQuery<Consultor> query = this.getEntityManager().createQuery(
                "SELECT c FROM consultor c WHERE c.status=true", Consultor.class);
       
        return (List<Consultor>) query.getResultList();
    }
    
}
