/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.service;

import com.riftrunners.consultimate.manager.SimpleEntityManager;
import com.riftrunners.consultimate.model.dao.ConsultorDAO;
import com.riftrunners.consultimate.model.entity.Consultor;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class ConsultorService {
    private ConsultorDAO dao;
    private SimpleEntityManager sem;
    
    public ConsultorService(SimpleEntityManager sem){
        this.sem = sem;
        dao = new ConsultorDAO(this.sem.getEntityManager());
    }
    
    public void save(Consultor consultor){
        try{
            sem.beginTransaction();
            dao.save(consultor);
            sem.commit();
        }catch(Exception e){
            e.printStackTrace();
            sem.rollBack();
        }
    }
     
    public List<Consultor> findAll(){
        return dao.findAll();
    }
}
