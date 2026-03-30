package com.camille.todotask.model;

import jakarta.persistence.*;

@Entity
public class Task  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeTask;
    private String descricao;
    private boolean completa = false;

    @ManyToOne
    private Projeto projeto;

    @ManyToOne
    private model.Categoria categoria;

    @Enumerated(EnumType.STRING)
    private Status status;
        @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Task: " + nomeTask + "\n" +
                "Categoria: " + categoria.getNome() + "\n" +
                "Descrição: " + descricao + "\n" +
                "Status: " + status;
    }
}
