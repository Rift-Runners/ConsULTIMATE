/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.model.dao;

import com.riftrunners.consultimate.model.entity.Transacao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * @author Diego Peixoto
 * @author Guilherme Matuella
 */
public class TransacaoDAO extends GenericDAO<Long, Transacao> {

    private EntityManager em;

    public TransacaoDAO(EntityManager entityManager) {
        super(entityManager);
        this.em = entityManager;
    }

    public List<Transacao> getByConsultorId(Long id) {
        TypedQuery<Transacao> query = em.createQuery(
                "SELECT t FROM transacao t WHERE t.consultor_id=:consultor_id", Transacao.class);
        query.setParameter("consultor_id", id);
        return (List<Transacao>) query.getResultList();
    }

    public List<Transacao> getByClienteId(Long id) {
        TypedQuery<Transacao> query = em.createQuery(
                "SELECT t FROM transacao t WHERE t.cliente_id=:cliente_id", Transacao.class);
        query.setParameter("cliente_id", id);
        return (List<Transacao>) query.getResultList();
    }
}
