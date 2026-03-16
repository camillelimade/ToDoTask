package service;
import model.Task;
import java.util.ArrayList;

// util ao implementar subtarefas em atualizações posteriores
public interface Completavel {
    public void completaTask(int ID, ArrayList<Task> tasks);
}
