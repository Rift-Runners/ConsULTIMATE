/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.service;

import com.riftrunners.consultimate.manager.SimpleEntityManager;
import com.riftrunners.consultimate.model.dao.ConsultorDAO;
import com.riftrunners.consultimate.model.dao.TransacaoDAO;
import com.riftrunners.consultimate.model.entity.Cliente;
import com.riftrunners.consultimate.model.entity.Consultor;
import com.riftrunners.consultimate.model.entity.Transacao;
import com.riftrunners.consultimate.util.ConsultimateUtil;
import com.riftrunners.consultimate.util.Validador;
import java.util.List;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 * @author Diego Peixoto
 * @author Guilherme Matuella
 */
@SuppressWarnings("FieldMayBeFinal")
public class TransacaoService {

    private TransacaoDAO dao;
    private SimpleEntityManager sem;
    private Validador validador;
    private ConsultimateUtil consultimateUtil;

    public TransacaoService(SimpleEntityManager sem) {
        this.sem = sem;
        dao = new TransacaoDAO(this.sem.getEntityManager());
        this.validador = new Validador();
        this.consultimateUtil = new ConsultimateUtil();
    }

    public void save(Cliente cliente, Consultor consultor, Integer valorSelecionado) {
        try {
            if (cliente.getSaldo() >= valorSelecionado && valorSelecionado > 0) {
                Transacao transacao = new Transacao(cliente, consultor, valorSelecionado, consultimateUtil.calculaHoraSelecionado(consultor.getValorHora(), valorSelecionado));
                sem.beginTransaction();
                dao.save(transacao);
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
}
