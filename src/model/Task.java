package model;

public class Task extends Entidade {
    private int id;
    private String nomeTask;
    private boolean completa = false;
    private Categoria categoria;
    private String descricao;

    public Task(int id, String texto, Categoria categoria, String descricao) {
        this.id = id;
        this.nomeTask = texto;
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

    public String getNomeTask() {
        return nomeTask;
    }

    public void setNomeTask(String nomeTask) {
        this.nomeTask = nomeTask;
    }

    public boolean isCompleta() {
        return completa;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public String verificaStatus(){
        if (isCompleta()){
            return "Completa";
        }else {
            return "Incompleta";
        }
    }
    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Nome: " + nomeTask + "\n" +
                "Status: " + verificaStatus() + "\n" +
                "Categoria: " + categoria + "\n" +
                "Descrição: " + descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
