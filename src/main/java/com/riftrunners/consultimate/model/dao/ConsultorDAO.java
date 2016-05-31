/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.model.dao;

import com.riftrunners.consultimate.model.entity.Cliente;
import com.riftrunners.consultimate.model.entity.Consultor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * @author Diego Peixoto
 * @author Guilherme Matuella
 */
public class ConsultorDAO extends GenericDAO<Long, Consultor> {

    public ConsultorDAO(EntityManager entityManager) {
        super(entityManager);
    }

//     public List<Consultor> getConsultoresAtivos() {
//        TypedQuery<Consultor> query = this.getEntityManager().createQuery(
//                "SELECT c FROM consultor c WHERE c.status=true", Consultor.class);
//       
//        return (List<Consultor>) query.getResultList();
//    }
     
    public List<Consultor> getConsultoresAtivos() {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Consultor> query = builder.createQuery(Consultor.class); //Select * 
        Root<Consultor> from = query.from(Consultor.class);//from cliente
        TypedQuery<Consultor> typedQuery = this.getEntityManager().createQuery(
                query.select(from)
                .where(builder.isTrue(from.get("status")))
        );
        return typedQuery.getResultList();
    }
    
    public Integer getTotalConsultoresAtivos() {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Consultor> query = builder.createQuery(Consultor.class); //Select * 
        Root<Consultor> from = query.from(Consultor.class);//from cliente
        TypedQuery<Consultor> typedQuery = this.getEntityManager().createQuery(
                query.select(from)
                .where(builder.isTrue(from.get("status")))
        );
        return typedQuery.getResultList().size();
    }
    
}
