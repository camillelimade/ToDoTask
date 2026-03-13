package service;
import model.Task;
import java.util.ArrayList;
public interface TaskService {
    Task criaTask(int ID);
    void editarTask(int ID, ArrayList<Task> tasks);
    void excluirTask(int ID,  ArrayList<Task> tasks);
    void listarTasks(ArrayList<Task> tasks);
}