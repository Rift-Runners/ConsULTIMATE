/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.service;

import com.riftrunners.consultimate.manager.SimpleEntityManager;
import com.riftrunners.consultimate.model.dao.ClienteDAO;
import com.riftrunners.consultimate.model.dao.TransacaoDAO;
import com.riftrunners.consultimate.model.entity.Cliente;
import com.riftrunners.consultimate.model.entity.Consultor;
import com.riftrunners.consultimate.model.entity.Transacao;
import java.util.List;
import org.primefaces.context.RequestContext;

/**
 * @author Diego Peixoto
 * @author Guilherme Matuella
 */
@SuppressWarnings("FieldMayBeFinal")
public class TransacaoService {

    private TransacaoDAO dao;
    private SimpleEntityManager sem;

    public TransacaoService(SimpleEntityManager sem) {
        this.sem = sem;
        dao = new TransacaoDAO(this.sem.getEntityManager());
    }

    public void save(Transacao transacao) {
        try {
            if (transacao.getCliente().getSaldo() >= 0 && transacao.getValor() > 0) {
                sem.beginTransaction();
                dao.save(transacao);
                
                ClienteDAO cliDao = new ClienteDAO(this.sem.getEntityManager());
                cliDao.update(transacao.getCliente());
                
                sem.commit();
                RequestContext.getCurrentInstance().execute("PF('dialogTransacao').show()");
            } else {
                RequestContext.getCurrentInstance().execute("PF('dialogSaldoInsuficiente').show()");
            }
        } catch (Exception e) {
            sem.rollBack();
        } finally {
            if (sem != null) {
                sem.close();
            }
        }
    }

    public List<Transacao> findAll() {
        return dao.findAll();
    }
    
    public List<Transacao> transacoesDoCliente(Cliente cliente){
        return dao.getByClienteId(cliente.getId());
    }
    
    public List<Transacao> transacoesDoConsultor(Consultor consultor){
        return dao.getByConsultorId(consultor.getId());
    }
}
