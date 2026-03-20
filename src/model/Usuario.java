package model;

import java.util.ArrayList;

public class Usuario extends Entidade{
    private String nome;
    private String email;
    private ArrayList<Task> tasks = new ArrayList<>();
    private ArrayList<Projeto> projetos = new ArrayList<>();

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
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

    public static void main(String[] args) {


    }
}
