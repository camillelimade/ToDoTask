package app;

import controller.ToDoController;
import model.Usuario;

import java.util.InputMismatchException;
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

        while(desejaContinuar){
            try {
                int opcao = executar.menu();
                switch (opcao){
                    case 1:
                        // 1 - Criar task
                        // Tratamento de erros [x]
                        novoUsuario.getTasks().add(executar.criaTask(idTask));
                        idTask++;
                        break;
                    case 2:
                        // 2 - Editar task
                        // Tratamento de erros [x]
                        int idEditar = 0;
                        try {
                            // tenta receber o ID para edição
                            System.out.println("Digite o ID da task que deseja editar: ");
                            idEditar = input.nextInt();
                        } catch (InputMismatchException e) {
                            // pega a entrada errada e retorna mensagem
                            input.nextLine(); // fix: limpa buffer
                            executar.divisor();
                            System.out.println("Digite uma entrada númerica válida. Tente novamente.");
                            continue;
                        }
                        executar.editarTask(idEditar, novoUsuario.getTasks());
                        break;
                    case 3:
                        // 3 - Excluir task
                        // Tratamento de erros [ ]
                        int taskId = 0;
                        try {
                            System.out.println("Digite o ID da task que deseja excluir: ");
                            taskId = input.nextInt();
                        } catch (InputMismatchException e) {
                            // pega entrada errada
                            input.nextLine();
                            executar.divisor();
                            System.out.println("Digite uma entrada númerica válida. Tente novamente.");
                            continue;
                        }
                        if (taskId <= 0) {
                            System.out.println("Digite um ID válido.");
                            continue;
                        }
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
            } catch (RuntimeException e) {
                executar.divisor();
                System.out.println("Ocorreu um erro inesperado. Tente novamente.");
            }
        }
    }
}
