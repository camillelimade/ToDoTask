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
                        System.out.println("Digite o ID da Task que deseja editar: ");
                        String entrada = input.nextLine();

                        if (entrada.isBlank()){
                            executar.divisor();
                            System.out.println("O ID não pode ser vazio. Tente novamente.");
                            executar.divisor();
                            continue;
                        }
                        int idEditar; // variavel que guarda a conversão
                        try{
                            // tenta converter pra Int
                            idEditar = Integer.parseInt(entrada);
                        }catch (NumberFormatException e) {
                            // se não consegue é pq digitaram algum texto
                            executar.divisor();
                            System.out.println("Digite um número válido. Tente novamente.");
                            executar.divisor();
                            continue;
                        }
                        if (idEditar <= 0) {
                            System.out.println("Digite um ID válido.");
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
                            input.nextLine(); // limpa buffer
                        } catch (InputMismatchException e) {
                            // pega entrada errada
                            input.nextLine();
                            executar.divisor();
                            System.out.println("Digite uma entrada númerica válida. Tente novamente.");
                            continue;
                        }
                        if (taskId <= 0) {
                            executar.divisor();
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
