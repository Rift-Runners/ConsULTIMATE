/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.model.dao;

import com.riftrunners.consultimate.model.entity.Cliente;
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
public class ClienteDAO extends GenericDAO<Long, Cliente> {

    public ClienteDAO(EntityManager entityManager) {
        super(entityManager);
    }

    public Integer getTotalClientesAtivos() {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Cliente> query = builder.createQuery(Cliente.class); //Select * 
        Root<Cliente> from = query.from(Cliente.class);//from cliente
        TypedQuery<Cliente> typedQuery = this.getEntityManager().createQuery(
                query.select(from)
                .where(builder.isTrue(from.get("status")))
        );
        return typedQuery.getResultList().size();
    }

}
