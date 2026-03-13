package model;

import java.util.ArrayList;

public class Categoria {
    private String nome;
    ArrayList<Categoria> categorias;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Categoria(String nome, ArrayList<Categoria> categorias) {
        this.nome = nome;
        this.categorias = categorias;
    }
}
