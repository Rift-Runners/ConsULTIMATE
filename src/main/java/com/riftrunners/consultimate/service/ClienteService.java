/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.service;

import com.riftrunners.consultimate.manager.SimpleEntityManager;
import com.riftrunners.consultimate.model.dao.ClienteDAO;
import com.riftrunners.consultimate.model.entity.Cliente;
import com.riftrunners.consultimate.util.ConsultimateUtil;
import com.riftrunners.consultimate.util.Validador;
import java.util.List;
import org.primefaces.context.RequestContext;

/**
 * @author Diego Peixoto
 * @author Guilherme Matuella
 */
@SuppressWarnings("FieldMayBeFinal")
public class ClienteService {

    private ClienteDAO dao;
    private SimpleEntityManager sem;
    private Validador validador;
    private ConsultimateUtil consultimateUtil;

    public ClienteService(SimpleEntityManager sem) {
        this.sem = sem;
        dao = new ClienteDAO(this.sem.getEntityManager());
        this.validador = new Validador();
        this.consultimateUtil = new ConsultimateUtil();
    }

    public void save(Cliente cliente, String comparaSenha) {
        try {
            if (validador.validaCliente(cliente) && consultimateUtil.confirmaSenha(cliente.getSenha(), comparaSenha)) {
                sem.beginTransaction();
                dao.save(cliente);
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

    public void edit(Cliente cliente) {
        try {
            if (validador.validaCliente(cliente)) {
                sem.beginTransaction();
                dao.update(cliente);
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

    public List<Cliente> findAll() {
        return dao.findAll();
    }

    public Cliente getClienteLogin(String usuario, String senha) {
        for (Cliente clienteCadastrado : dao.findAll()) {
            if (clienteCadastrado.getUsuario().equals(usuario)
                    && clienteCadastrado.getSenha().equals(senha)) {
                return clienteCadastrado;
            }
        }
        return null;
    }
}
