/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.service;

import com.riftrunners.consultimate.manager.SimpleEntityManager;
import com.riftrunners.consultimate.model.dao.ClienteDAO;
import com.riftrunners.consultimate.model.entity.Cliente;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class ClienteService {
    private ClienteDAO dao;
    private SimpleEntityManager sem;
    
    public ClienteService(SimpleEntityManager sem){
        this.sem = sem;
        dao = new ClienteDAO(this.sem.getEntityManager());
    }
    
    public void save(Cliente cliente){
        try{
            sem.beginTransaction();
            dao.save(cliente);
            sem.commit();
        }catch(Exception e){
            e.printStackTrace();
            sem.rollBack();
        }
    }
     
    public List<Cliente> findAll(){
        return dao.findAll();
    }
}
