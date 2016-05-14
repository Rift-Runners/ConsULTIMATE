/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.service;

import com.riftrunners.consultimate.manager.SimpleEntityManager;
import com.riftrunners.consultimate.model.dao.ConsultorDAO;
import com.riftrunners.consultimate.model.entity.Consultor;
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
public class ConsultorService {

    private ConsultorDAO dao;
    private SimpleEntityManager sem;
    private Validador validador;
    private ConsultimateUtil consultimateUtil;

    public ConsultorService(SimpleEntityManager sem) {
        this.sem = sem;
        dao = new ConsultorDAO(this.sem.getEntityManager());
        this.validador = new Validador();
        this.consultimateUtil = new ConsultimateUtil();
    }

    public void save(Consultor consultor, String comparaSenha) {
        try {
            if (validador.validaConsultor(consultor) && consultimateUtil.confirmaSenha(consultor.getSenha(), comparaSenha)) {
                sem.beginTransaction();
                dao.save(consultor);
                sem.commit();
                RequestContext.getCurrentInstance().execute("PF('dialogSucesso').show()");
            } else {
                RequestContext.getCurrentInstance().execute("PF('dialogErro').show()");
            }
        } catch (Exception e) {
            sem.rollBack();
            RequestContext.getCurrentInstance().execute("PF('dialogErro').show()");
        } finally {
            if (sem != null) {
                sem.close();
            }
        }
    }

    public void edit(Consultor consultor) {
        try {
            if (validador.validaConsultor(consultor)) {
                sem.beginTransaction();
                dao.update(consultor);
                sem.commit();
                RequestContext.getCurrentInstance().execute("PF('dialogEditarSucesso').show()");
            } else {
                RequestContext.getCurrentInstance().execute("PF('dialogEditarErro').show()");
            }
        } catch (Exception e) {
            sem.rollBack();
            RequestContext.getCurrentInstance().execute("PF('dialogErro').show()");
        } finally {
            if (sem != null) {
                sem.close();
            }
        }
    }

    public void remove(Consultor consultor) {
        try {
            sem.beginTransaction();
            dao.delete(dao.getById(consultor.getId()));
            sem.commit();
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.getExternalContext().invalidateSession();
        } catch (Exception e) {
            sem.rollBack();
        } finally {
            sem.close();
        }
    }

    public List<Consultor> findAll() {
        return dao.findAll();
    }

    public Consultor getConsultorLogin(String usuario, String senha) {
        for (Consultor consultorCadastrado : dao.findAll()) {
            if (consultorCadastrado.getUsuario().equals(usuario)
                    && consultorCadastrado.getSenha().equals(senha)) {
                return consultorCadastrado;
            }
        }
        return null;
    }

}
