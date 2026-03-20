package model;

public class Projeto extends Entidade {
    private int id;
    private String nome;

    public Projeto(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    @Override
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
}
