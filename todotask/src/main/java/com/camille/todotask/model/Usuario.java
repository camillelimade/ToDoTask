package com.camille.todotask.model;
import jakarta.persistence.*;
import java.util.ArrayList;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;

    @OneToMany(mappedBy = "usuario")
    private ArrayList<Projeto> projetos;
}