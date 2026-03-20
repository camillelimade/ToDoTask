package service;
import model.Projeto;
import model.Task;
import java.util.ArrayList;
public interface TaskService {
    Task criaTask(int ID);
    void editarTask(int ID, ArrayList<Task> tasks);
    void excluirTask(int ID,  ArrayList<Task> tasks);
    void listarTasks(ArrayList<Task> tasks);
    // começo dos métodos que se referem ao agregamento de tasks em projetos
    public Task criaTaskProjeto(int id, Projeto projeto);
}