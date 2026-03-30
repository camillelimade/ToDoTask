package com.camille.todotask.model;
import jakarta.persistence.*;

import java.util.ArrayList;
@Entity
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    private Usuario usuario;
    @OneToMany(mappedBy = "projeto")
    private ArrayList<Task> tasks;
}