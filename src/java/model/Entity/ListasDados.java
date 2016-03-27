/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Guilherme Matuella
 * @author Diego Peixoto
 */
public class ListasDados {

    private List<Cliente> listaClientes;
    private List<Consultor> listaConsultores;
    private List<Admin> listaAdmin;

    /**
     * Creates a new instance of ListasDados
     */
    public ListasDados() {
        listaClientes = new ArrayList<>();
        populaListaClientes();
        listaConsultores = new ArrayList<>();
        populaListaConsultores();
        listaAdmin = new ArrayList<>();
        populaListaAdmin();
    }

    public void populaListaClientes() {
        Cliente[] clientes = new Cliente[]{
            new Cliente("a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"),
            new Cliente("b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b"),
            new Cliente("c", "c", "c", "c", "c", "c", "c", "c", "c", "c", "c")
        };
        listaClientes.addAll(Arrays.asList(clientes));
    }

    public void populaListaConsultores() {
        Consultor[] consultores = new Consultor[]{
            new Consultor("d", "d", "d", "d", "d", "d", "d", "d", "d", "d", "d", "d"),
            new Consultor("e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "e"),
            new Consultor("f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f")
        };
        listaConsultores.addAll(Arrays.asList(consultores));
    }

    private void populaListaAdmin() {
        listaAdmin.add(new Admin("admin", "admin", true));
    }

    public void adicionarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void adicionarConsultor(Consultor consultor) {
        listaConsultores.add(consultor);
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public List<Consultor> getListaConsultores() {
        return listaConsultores;
    }

    public List<Admin> getListaAdmin() {
        return listaAdmin;
    }
}
