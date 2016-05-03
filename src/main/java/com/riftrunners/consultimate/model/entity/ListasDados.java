/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.model.entity;

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
            new Cliente("cliente1", "Cidade1", "RS", "Av. Teste", "(33) 2222-2222", "cliente@gmail.com", "165.515.151-52", "1515151515", "cliente1", "cliente1"),
            new Cliente("cliente2", "Cidade2", "SC", "Av. Teste", "(33) 2222-2222", "cliente@gmail.com", "165.515.151-52", "1515151515", "cliente2", "cliente2"),
            new Cliente("cliente3", "Cidade3", "SP", "Av. Teste", "(33) 2222-2222", "cliente@gmail.com", "165.515.151-52", "1515151515", "cliente3", "cliente3"),
            new Cliente("cliente4", "Cidade4", "SP", "Av. Teste", "(33) 2222-2222", "cliente@gmail.com", "165.515.151-52", "1515151515", "cliente4", "cliente4"),
            new Cliente("cliente5", "Cidade5", "SC", "Av. Teste", "(33) 2222-2222", "cliente@gmail.com", "165.515.151-52", "1515151515", "cliente5", "cliente5"),
            new Cliente("cliente6", "Cidade6", "RS", "Av. Teste", "(33) 2222-2222", "cliente@gmail.com", "165.515.151-52", "1515151515", "cliente6", "cliente6"),
            new Cliente("cliente7", "Cidade7", "SP", "Av. Teste", "(33) 2222-2222", "cliente@gmail.com", "165.515.151-52", "1515151515", "cliente7", "cliente7"),
            new Cliente("cliente8", "Cidade8", "RS", "Av. Teste", "(33) 2222-2222", "cliente@gmail.com", "165.515.151-52", "1515151515", "cliente8", "cliente8"),
            new Cliente("cliente9", "Cidade9", "RS", "Av. Teste", "(33) 2222-2222", "cliente@gmail.com", "165.515.151-52", "1515151515", "cliente9", "cliente9"),
            new Cliente("cliente10", "Cidade10", "SP", "Av. Teste", "(33) 2222-2222", "cliente@gmail.com", "165.515.151-52", "1515151515", "cliente10", "cliente10"),
            new Cliente("cliente11", "Cidade11", "RS", "Av. Teste", "(33) 2222-2222", "cliente@gmail.com", "165.515.151-52", "1515151515", "cliente11", "cliente11"),};
        listaClientes.addAll(Arrays.asList(clientes));
    }

    public void populaListaConsultores() {
        Consultor[] consultores = new Consultor[]{
            new Consultor("consultor1", "Cidade1", "RS", "Av. Teste", "(33) 2222-2222", "consultor@gmail.com", "25.834.573/0001-41",
            "ddddddd ddddddddddddddddddddd ddddddddddd ddddddddddddddddddddddddd ddddddddddd", "Engenharia", "consultor1", "consultor1", 100),
            new Consultor("consultor2", "Cidade1", "RS", "Av. Teste", "(33) 2222-2222", "consultor@gmail.com", "25.834.573/0001-41",
            "ddddddd ddddddddddddddddddddd ddddddddddd ddddddddddddddddddddddddd ddddddddddd", "TI", "consultor2", "consultor2", 120),
            new Consultor("consultor3", "Cidade1", "RS", "Av. Teste", "(33) 2222-2222", "consultor@gmail.com", "25.834.573/0001-41",
            "ddddddd ddddddddddddddddddddd ddddddddddd ddddddddddddddddddddddddd ddddddddddd", "Artes", "consultor3", "consultor3", 140),
            new Consultor("consultor4", "Cidade1", "RS", "Av. Teste", "(33) 2222-2222", "consultor@gmail.com", "25.834.573/0001-41",
            "ddddddd ddddddddddddddddddddd ddddddddddd ddddddddddddddddddddddddd ddddddddddd", "TI", "consultor4", "consultor4", 160),
            new Consultor("consultor5", "Cidade1", "RS", "Av. Teste", "(33) 2222-2222", "consultor@gmail.com", "25.834.573/0001-41",
            "ddddddd ddddddddddddddddddddd ddddddddddd ddddddddddddddddddddddddd ddddddddddd", "Filosofia", "consultor5", "consultor5", 200),
            new Consultor("consultor6", "Cidade1", "RS", "Av. Teste", "(33) 2222-2222", "consultor@gmail.com", "25.834.573/0001-41",
            "ddddddd ddddddddddddddddddddd ddddddddddd ddddddddddddddddddddddddd ddddddddddd", "Filosofia", "consultor6", "consultor6", 110),
            new Consultor("consultor7", "Cidade1", "RS", "Av. Teste", "(33) 2222-2222", "consultor@gmail.com", "25.834.573/0001-41",
            "ddddddd ddddddddddddddddddddd ddddddddddd ddddddddddddddddddddddddd ddddddddddd", "Filosofia", "consultor7", "consultor7", 80),
            new Consultor("consultor8", "Cidade1", "RS", "Av. Teste", "(33) 2222-2222", "consultor@gmail.com", "25.834.573/0001-41",
            "ddddddd ddddddddddddddddddddd ddddddddddd ddddddddddddddddddddddddd ddddddddddd", "Psicologia", "consultor8", "consultor8", 70),
            new Consultor("consultor9", "Cidade1", "RS", "Av. Teste", "(33) 2222-2222", "consultor@gmail.com", "25.834.573/0001-41",
            "ddddddd ddddddddddddddddddddd ddddddddddd ddddddddddddddddddddddddd ddddddddddd", "Artes", "consultor9", "consultor9", 120),
            new Consultor("consultor10", "Cidade1", "RS", "Av. Teste", "(33) 2222-2222", "consultor@gmail.com", "25.834.573/0001-41",
            "ddddddd ddddddddddddddddddddd ddddddddddd ddddddddddddddddddddddddd ddddddddddd", "Engenharia", "consultor10", "consultor10", 130),
            new Consultor("consultor11", "Cidade1", "RS", "Av. Teste", "(33) 2222-2222", "consultor@gmail.com", "25.834.573/0001-41",
            "ddddddd ddddddddddddddddddddd ddddddddddd ddddddddddddddddddddddddd ddddddddddd", "Biologia", "consultor11", "consultor11", 110),
            new Consultor("consultor12", "Cidade1", "RS", "Av. Teste", "(33) 2222-2222", "consultor@gmail.com", "25.834.573/0001-41",
            "ddddddd ddddddddddddddddddddd ddddddddddd ddddddddddddddddddddddddd ddddddddddd", "Biologia", "consultor12", "consultor12", 100),
        };
        listaConsultores.addAll(Arrays.asList(consultores));
    }

    public void populaListaAreas() {
        String[] categorias = new String[]{
            "TI", "Engenharia", "Artes", "Matematica", "Fisica",
            "Quimica", "Geociencias", "Biologia", "Saude", "Psicologia",
            "Filosofia", "Historia"
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
