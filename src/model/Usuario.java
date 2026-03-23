package model;

import service.Autenticavel;

import java.util.ArrayList;

public class Usuario extends Entidade implements Autenticavel{
    private String nome;
    private String email;
    private String senha;
    private ArrayList<Task> tasks = new ArrayList<>();
    private ArrayList<Projeto> projetos = new ArrayList<>();

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }
    public void adicionarProjeto(Projeto projeto) {
        projetos.add(projeto);
    }
    public ArrayList<Projeto> getProjetos() {
        return projetos;
    }
    public Usuario() {
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    @Override
    public boolean autenticar(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }
}
