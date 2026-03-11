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
                    // 1 - Criar task
                    Tarefas.add(executar.criaTask(idTask));
                    idTask++;
                    break;
                case 2:
                    // 2 - Editar task
                    System.out.println("Digite o ID da task que deseja editar: ");
                    int idEditar = input.nextInt();
                    executar.editarTask(idEditar, Tarefas);
                    break;
                case 3:
                    // 3 - Excluir task
                    System.out.println("Digite o ID da task que deseja excluir: ");
                    int taskId = input.nextInt();
                    executar.excluirTask(taskId, Tarefas);
                    break;
                case 4:
                    // 4 - Completar task
                    System.out.println("Digite o ID da Task que deseja completar: ");
                    Scanner lerTaskComplete = new Scanner(System.in);
                    int idTaskComplete = input.nextInt();
                    executar.completaTask(idTaskComplete, Tarefas);
                    break;
                case 5:
                    // 5 - Listar todas as tasks
                    executar.listarTasks(Tarefas);
                    break;
                case 6:
                    //  6 - Sair
                    System.out.println("Encerrando...");
                    executar.divisor();
                    desejaContinuar = false;
                    break;
                default:
                    System.out.println("Digite uma opção válida!");

            }
        } while (desejaContinuar);
    }
}
