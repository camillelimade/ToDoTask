package controller;

import model.Task;
import model.Usuario;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ToDoController {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void divisor() {
        System.out.println("-----------------------------------------");
    }

    private boolean emailValido(String email) {
        if (email == null) return false;

        return email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");
    }

    public Usuario cadastro() {
        divisor();
        System.out.println("Bem vindo(a) ao Cadastro do ToDoTask! ");
        divisor();
        Scanner cadUser = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nomeUser = cadUser.nextLine();

        System.out.println("Digite seu e-mail: ");
        String emailUser = cadUser.nextLine();
        // validação de entradas

        if (nomeUser.isBlank() || emailUser.isBlank() || !emailValido(emailUser)) {
            throw new NullPointerException("Erro ao cadastrar: Nome ou E-mail inválidos, tente novamente!");
        } else {
            divisor();
            System.out.println("Parabéns " + nomeUser + ", você foi cadastrado(a) com sucesso!");
            return new Usuario(nomeUser, emailUser);
        }

    }

    public int menu() {
        divisor();
        System.out.println("Seja bem vindo(a) ao ToDoTask! 📋");
        divisor();
        System.out.println("Essas são suas opções: \n" +
                " 1. Criar uma nova task\n" +
                " 2. Completar task\n" +
                " 3. Editar task\n" +
                " 4. Excluir task\n" +
                " 5. Listar todas as tasks\n" +
                " 6. Sair"
        );
        divisor();
        int opcao;

        while (true) {
            // recebe entrada do usuário
            Scanner leitor = new Scanner(System.in);
            System.out.println("Digite o indice da opção desejada: ");
            // validação de tipo de entrada
            if (leitor.hasNextInt()) {
                opcao = leitor.nextInt();
                leitor.nextLine();
                divisor();
                break;
            } else {
                System.out.println("Digite uma entrada válida! Tente novamente.");
                leitor.nextLine();
            }
        }
        return opcao;
    }
}
