/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author 631420063
 */
public class ListasDados {

    private ArrayList<Cliente> listaClientes;
    private ArrayList<Consultor> listaConsultores;

    /**
     * Creates a new instance of ListasDados
     */
    public ListasDados() {
        listaClientes = new ArrayList<>();
        populaListaClientes();
        listaConsultores = new ArrayList<>();
        populaListaConsultores();
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

    public void adicionarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void adicionarConsultor(Consultor consultor) {
        listaConsultores.add(consultor);
    }

    public ArrayList<Cliente> getlistaClientes() {
        return listaClientes;
    }

    public ArrayList<Consultor> getListaConsultores() {
        return listaConsultores;
    }
}
