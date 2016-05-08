/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.service;

import com.riftrunners.consultimate.manager.SimpleEntityManager;
import com.riftrunners.consultimate.model.dao.TesteDAO;
import com.riftrunners.consultimate.model.entity.Teste;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class TesteService {
    private TesteDAO dao;
    private SimpleEntityManager sem;
    
    public TesteService(SimpleEntityManager sem){
        this.sem = sem;
        dao = new TesteDAO(this.sem.getEntityManager());
    }
    
    public void save(Teste teste){
        try{
            sem.beginTransaction();
            dao.save(teste);
            sem.commit();
        }catch(Exception e){
            e.printStackTrace();
            sem.rollBack();
        }
    }
     
    public List<Teste> findAll(){
        return dao.findAll();
    }
}
