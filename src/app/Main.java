package app;

import controller.ToDoController;
import model.Usuario;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
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
                    novoUsuario.getTasks().add(executar.criaTask(idTask));
                    idTask++;
                    break;
                case 2:
                    // 2 - Editar task
                    System.out.println("Digite o ID da task que deseja editar: ");
                    int idEditar = input.nextInt();
                    executar.editarTask(idEditar, novoUsuario.getTasks());
                    break;
                case 3:
                    // 3 - Excluir task
                    System.out.println("Digite o ID da task que deseja excluir: ");
                    int taskId = input.nextInt();
                    input.nextLine();
                    executar.excluirTask(taskId, novoUsuario.getTasks());
                    break;
                case 4:
                    // 4 - Completar task
                    System.out.println("Digite o ID da Task que deseja completar: ");
                    int idTaskComplete = input.nextInt();
                    input.nextLine();
                    executar.completaTask(idTaskComplete, novoUsuario.getTasks());
                    break;
                case 5:
                    // 5 - Listar todas as tasks
                    executar.listarTasks(novoUsuario.getTasks());
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
