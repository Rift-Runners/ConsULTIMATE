/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.model.dao;

import com.riftrunners.consultimate.model.entity.Transacao;
import javax.persistence.EntityManager;

/**
 * @author Diego Peixoto
 * @author Guilherme Matuella
 */
public class TransacaoDAO extends GenericDAO<Long, Transacao> {

    public TransacaoDAO(EntityManager entityManager) {
        super(entityManager);
    }

}
