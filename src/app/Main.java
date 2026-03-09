package app;

import controller.ToDoController;
import model.Task;
import model.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Task> Tarefas = new ArrayList<Task>();
        ToDoController executar = new ToDoController();

        boolean desejaContinuar = true;
        int idTask = 1;

        Usuario novoUsuario;
        try {
            novoUsuario = executar.cadastro();
        } catch (Exception e) {
            System.out.println("Erro no cadastro: " + e.getMessage());
            return;
        }

        // execução do menu principal do gerenciador
        do {
            int opcao = executar.menu();
            switch (opcao) {
                case 1:
                    Tarefas.add(executar.criaTask(idTask));
                    idTask++;
                    break;
                case 2:
                    // listar tasks
                    executar.listarTasks(Tarefas);
                    break;
                case 6:
                    System.out.println("Encerrando...");
                    executar.divisor();
                    desejaContinuar = false;
                    return;
                default:
                    System.out.println("Digite uma opção válida!");

            }
        } while (desejaContinuar);
    }
}
