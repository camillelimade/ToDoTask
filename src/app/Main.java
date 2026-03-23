package app;

import controller.ToDoController;
import model.Projeto;
import model.Usuario;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static int pedirID(Scanner input) {
        System.out.println("Digite o ID:");
        return Integer.parseInt(input.nextLine());
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ToDoController executar = new ToDoController();

        boolean desejaContinuar = true;
        int idTask = 1;

        boolean usuarioNaoCriado = true;
        Usuario novoUsuario = null;
        while (usuarioNaoCriado) {
            try {
                novoUsuario = executar.cadastro();
            } catch (Exception e) {
                System.out.println("Erro no cadastro: " + e.getMessage());
                return;
            }
            Usuario usuarioLogado = executar.login(novoUsuario.getEmail(), novoUsuario.getSenha());

            if (usuarioLogado == null) {
                System.out.println("Encerrando sistema...");
                return;
            } else {
                usuarioNaoCriado = false;
            }

        }
        // execução do menu principal do gerenciador
        int idProjeto = 1;
        while (desejaContinuar) {
            executar.divisor();
            int opcao = executar.menuProjetos();
            switch (opcao) {
                case 1: // cria projetos
                    executar.criaProjeto(idProjeto, novoUsuario);
                    idProjeto++;
                    break;
                case 2:
                    executar.listaProjetos(novoUsuario);
                    break;
                case 3:
                    if (novoUsuario.getProjetos().isEmpty()) {
                        executar.divisor();
                        System.out.println("Nenhum projeto de " + novoUsuario.getNome() + " foi encontrado.");
                        executar.divisor();
                        break;
                    }
                    // listagem de projetos vinculados ao usuário
                    System.out.println("ToDoTask - Esses são os projetos disponíveis: \n");
                    for (int i = 0; i < novoUsuario.getProjetos().size(); i++) {
                        System.out.println((i + 1) + ". " + novoUsuario.getProjetos().get(i).getNome());
                    }
                    executar.divisor();
                    System.out.println("Escolha o projeto: ");
                    int escolha = input.nextInt();
                    input.nextLine();
                    if (escolha <= 0 || escolha > novoUsuario.getProjetos().size()) {
                        System.out.println("Opção inválida.");
                        break;
                    }
                    Projeto projetoEscolhido = novoUsuario.getProjetos().get(escolha - 1);
                    boolean dentroProjeto = true;
                    while (dentroProjeto) {
                        int opTask = executar.menu(projetoEscolhido); // menu antigo para a manipulação de tasks
                        switch (opTask) {
                            case 1:
                                // cria nova task
                                executar.criaTaskProjeto(idTask, projetoEscolhido);
                                idTask++;
                                break;
                            case 2:
                                // edita uma task
                                executar.editarTask(
                                        pedirID(input),
                                        projetoEscolhido.getTasks()
                                );
                                break;
                            case 3:
                                // cria uma task
                                executar.excluirTask(
                                        pedirID(input),
                                        projetoEscolhido.getTasks()
                                );
                                break;
                            case 4:
                                // completar task
                                executar.completaTask(
                                        pedirID(input),
                                        projetoEscolhido.getTasks()
                                );
                                break;
                            case 5:
                                // lista as tasks de um projeto
                                executar.listarTasks(
                                        projetoEscolhido.getTasks(), projetoEscolhido
                                );
                                break;
                            case 6:
                                dentroProjeto = false;
                                break;
                        }
                    }
                    break;
                case 4:
                    desejaContinuar = false;
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

