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
    private List<String> listaAreas;

    /**
     * Creates a new instance of ListasDados
     */
    public ListasDados() {
        listaClientes = new ArrayList<>();
        populaListaClientes();
        listaConsultores = new ArrayList<>();
        populaListaConsultores();
        listaAreas = new ArrayList<>();
        populaListaAreas();
        listaAdmin = new ArrayList<>();
        populaListaAdmin();
    }

    public void populaListaClientes() {
        Cliente[] clientes = new Cliente[]{
            new Cliente("a", "a", "a", "a", "a", "a", "a", "a", "a", "a"),
            new Cliente("b", "b", "b", "b", "b", "b", "b", "b", "b", "b"),
            new Cliente("c", "c", "c", "c", "c", "c", "c", "c", "c", "c")
        };
        listaClientes.addAll(Arrays.asList(clientes));
    }

    public void populaListaConsultores() {
        Consultor[] consultores = new Consultor[]{
            new Consultor("d", "d", "d", "d", "d", "d", "d", "d", "d", "d", "d"),
            new Consultor("e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "e"),
            new Consultor("f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f"),
            new Consultor("Teste1", "Teste1", "Teste1", "Teste1", "Teste1",
            "Teste1", "Teste1", "Teste1", "Tecnologia da Informação", "Teste1", "Teste1"),
            new Consultor("Consultor", "Porto Alegre", "RS", "Av. etc etc 1400", "(51)2222-2222",
            "consultor@consultor.com", "515151515151", "Blablablalba. Blablalbalblabllalb, blklblblblblalblblbl."
                    + " Blablablalba. Blablalbalblabllalb, blklblblblblalblblbl. Blablablalba. Blablalbalblabllalb,"
                    + " blklblblblblalblblbl.", "Artes", "cons", "cons"),
            new Consultor("Consultor", "Porto Alegre", "RS", "Av. etc etc 1400", "(51)2222-2222",
            "consultor@consultor.com", "515151515151", "Blablablalba. Blablalbalblabllalb, blklblblblblalblblbl."
                    + " Blablablalba. Blablalbalblabllalb, blklblblblblalblblbl. Blablablalba. Blablalbalblabllalb,"
                    + " blklblblblblalblblbl.", "Artes", "cons", "cons"),
            new Consultor("Consultor", "Porto Alegre", "RS", "Av. etc etc 1400", "(51)2222-2222",
            "consultor@consultor.com", "515151515151", "Blablablalba. Blablalbalblabllalb, blklblblblblalblblbl."
                    + " Blablablalba. Blablalbalblabllalb, blklblblblblalblblbl. Blablablalba. Blablalbalblabllalb,"
                    + " blklblblblblalblblbl.", "Artes", "cons", "cons"),
            new Consultor("Consultor", "Porto Alegre", "RS", "Av. etc etc 1400", "(51)2222-2222",
            "consultor@consultor.com", "515151515151", "Blablablalba. Blablalbalblabllalb, blklblblblblalblblbl."
                    + " Blablablalba. Blablalbalblabllalb, blklblblblblalblblbl. Blablablalba. Blablalbalblabllalb,"
                    + " blklblblblblalblblbl.", "Artes", "cons", "cons"),
            new Consultor("Consultor", "Porto Alegre", "RS", "Av. etc etc 1400", "(51)2222-2222",
            "consultor@consultor.com", "515151515151", "Blablablalba. Blablalbalblabllalb, blklblblblblalblblbl."
                    + " Blablablalba. Blablalbalblabllalb, blklblblblblalblblbl. Blablablalba. Blablalbalblabllalb,"
                    + " blklblblblblalblblbl.", "Artes", "cons", "cons"),
            new Consultor("Consultor", "Porto Alegre", "RS", "Av. etc etc 1400", "(51)2222-2222",
            "consultor@consultor.com", "515151515151", "Blablablalba. Blablalbalblabllalb, blklblblblblalblblbl."
                    + " Blablablalba. Blablalbalblabllalb, blklblblblblalblblbl. Blablablalba. Blablalbalblabllalb,"
                    + " blklblblblblalblblblBlablablalba. Blablalbalblabllalb, blklblblblblalblblbl. Blablablalba. Blablalbalblabllalb,"
                    + " blklblblblblalblblblBlablablalba. Blablalbalblabllalb, blklblblblblalblblbl. Blablablalba. Blablalbalblabllalb,"
                    + " blklblblblblalblblbl.", "Artes", "cons", "cons"),
            new Consultor("Teste3", "Teste3", "Teste3", "Teste3", "Teste3",
            "Teste3", "Teste3", "Teste3", "Engenharia", "Teste3", "Teste3")
        };
        listaConsultores.addAll(Arrays.asList(consultores));
    }

    public void populaListaAreas() {
        String[] categorias = new String[]{
            "Tecnologia da Informação", "Engenharia", "Artes"
        };
        listaAreas.addAll(Arrays.asList(categorias));
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

    public void adicionarArea(String area) {
        listaAreas.add(area);
    }

    public List<String> getListaAreas() {
        return listaAreas;
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
