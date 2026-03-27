package model;
import java.util.ArrayList;
public class Projeto extends Entidade {
    private int id;
    private String nome;
    private ArrayList<Task> tasks = new ArrayList<>();
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
    public void adicionarTask(Task task) {
        tasks.add(task);
    }
    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
