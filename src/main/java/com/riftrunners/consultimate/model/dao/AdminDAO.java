/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.model.dao;

import com.riftrunners.consultimate.model.entity.Admin;
import javax.persistence.EntityManager;

/**
 *
 * @author Guilherme
 */
public class AdminDAO extends GenericDAO<Long, Admin>{
    
    public AdminDAO(EntityManager entityManager){
        super(entityManager);
    }
}
