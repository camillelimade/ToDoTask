package model;

public class Task {
    private int id;
    private String texto;
    private boolean completa = false;
    private String categoria;
    private String descricao;

    public Task(int id, String texto, String categoria, String descricao) {
        this.id = id;
        this.texto = texto;
        this.completa = false;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isCompleta() {
        return completa;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
