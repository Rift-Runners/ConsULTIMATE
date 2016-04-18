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
            new Cliente("aaaaaa", "aaaaaa", "aaaaaa", "aaaaaa", "(33) 2222-2222", "aaaa@ggg.com", "12312312312", "1323142356", "aaaaaa", "aaaaaa"),
            new Cliente("bbbbbb", "bbbbbb", "bbbbbb", "bbbbbb", "(33) 2222-2222", "bbbb@ggg.com", "12312312312", "1323142356", "bbbbbb", "bbbbbb"),
            new Cliente("cccccc", "cccccc", "cccccc", "cccccc", "(33) 2222-2222", "cccc@ggg.com", "12312312312", "1323142356", "cccccc", "cccccc")
        };
        listaClientes.addAll(Arrays.asList(clientes));
    }

    public void populaListaConsultores() {
        Consultor[] consultores = new Consultor[]{
            new Consultor("d", "d", "d", "d", "d", "d", "d", "d", "d", "d", "d", 100),
            new Consultor("e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "e", 120),
            new Consultor("f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", 140),
            new Consultor("Teste1", "Teste1", "Teste1", "Teste1", "Teste1",
            "Teste1", "Teste1", "Teste1", "TI", "Teste1", "Teste1", 160),
            new Consultor("Consultor", "Porto Alegre", "RS", "Av. etc etc 1400", "(51)2222-2222",
            "consultor@consultor.com", "515151515151", "Blablablalba. Blablalbalblabllalb, blklblblblblalblblbl."
            + " Blablablalba. Blablalbalblabllalb, blklblblblblalblblbl. Blablablalba. Blablalbalblabllalb,"
            + " blklblblblblalblblbl.", "Artes", "cons", "cons", 180),
            new Consultor("Consultor", "Porto Alegre", "RS", "Av. etc etc 1400", "(51)2222-2222",
            "consultor@consultor.com", "515151515151", "Blablablalba. Blablalbalblabllalb, blklblblblblalblblbl."
            + " Blablablalba. Blablalbalblabllalb, blklblblblblalblblbl. Blablablalba. Blablalbalblabllalb,"
            + " blklblblblblalblblblBlablablalba. Blablalbalblabllalb, blklblblblblalblblbl. Blablablalba. Blablalbalblabllalb,"
            + " blklblblblblalblblblBlablablalba. Blablalbalblabllalb, blklblblblblalblblbl. Blablablalba. Blablalbalblabllalb,"
            + " blklblblblblalblblbl.", "Artes", "cons", "cons", 200),
            new Consultor("Teste3", "Teste3", "Teste3", "Teste3", "Teste3",
            "Teste3", "Teste3", "Teste3", "Engenharia", "Teste3", "Teste3", 50)
        };
        listaConsultores.addAll(Arrays.asList(consultores));
    }

    public void populaListaAreas() {
        String[] categorias = new String[]{
            "TI", "Engenharia", "Artes"
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

    public void deletarCliente(Cliente cliente) {
        listaClientes.remove(cliente);
    }

    public void deletarConsultor(Consultor consultor) {
        listaConsultores.remove(consultor);
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
