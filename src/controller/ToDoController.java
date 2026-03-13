package controller;

import model.Task;
import model.Usuario;

import java.util.ArrayList;
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
                " 2. Editar task\n" +
                " 3. Excluir task\n" +
                " 4. Completar task\n" +
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

    public Task criaTask(int ID) {
        Scanner lerTask = new Scanner(System.in);
        System.out.println("ToDoTask - Adicione aqui uma nova task: ");
        String nomeTask = lerTask.nextLine();
        divisor();
        System.out.println("ToDoTask - Digite uma categoria para sua task");
        String categoria = lerTask.nextLine();
        divisor();
        System.out.println("ToDoTask - Descreva sua Task:");
        String descricao = lerTask.nextLine();

        if (nomeTask.isBlank() || categoria.isBlank()) {
            throw new NullPointerException("Erro ao criar task: parâmetros inválidos, tente novamente. ");
        } else {
            divisor();
            System.out.println("Task " + nomeTask + " registrada com sucesso! ");
            return new Task(ID, nomeTask, categoria, descricao);
        }


    }

    public void listarTasks(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("Erro ao listar: Não foi encontrado nenhuma task registrada. ");
            return;
        }
        System.out.println("ToDoTask — Sua lista de Task's");
        divisor();
        for (Task task : tasks) {
            System.out.println(task.toString());
            System.out.println(" ");
        }

    }
    public void excluirTask(int ID,  ArrayList<Task> tasks) {
        for (Task task : tasks) {
            if (task.getId() == ID) {
                System.out.println("Task "+ task.getNomeTask() +" removida com sucesso! ");
                tasks.remove(task);
                return;
            }
        }
    }
public void completaTask(int ID, ArrayList<Task> tasks) {
        // int indice = ID - 1;
    for (Task task : tasks) {
        if (task.getId() == ID) {
            task.setCompleta(true);
            System.out.println("Task " + task.getNomeTask() + " completada com sucesso! ");
            return;
        }
    }
    System.out.println("Não foi possível completar a Task! Tente novamente.");
}
public void editarTask(int ID, ArrayList<Task> tasks) {
        for (Task task : tasks) {
            if (task.getId() == ID) {
                Scanner lerEdicaoTask = new Scanner(System.in);

                System.out.println("ToDoTask - Altere o nome da task selecionada: ");
                String nomeEdit = lerEdicaoTask.nextLine();
                divisor();


                System.out.println("ToDoTask - Altere a categoria da task selecionada: ");
                String categoriaEdit = lerEdicaoTask.nextLine();
                divisor();

                System.out.println("ToDoTask - Descreva sua Task:");
                String descricaoEdit = lerEdicaoTask.nextLine();

                if (nomeEdit.isBlank() || categoriaEdit.isBlank()) {
                    throw new NullPointerException("Erro ao editar task: parâmetros inválidos.");
                }
                task.setNomeTask(nomeEdit); // nome da task
                task.setCategoria(categoriaEdit);
                task.setDescricao(descricaoEdit);
                divisor();
                System.out.println("Task " + nomeEdit + " editada com sucesso!");

                return;
            }
        }
    System.out.println("Task não encontrada.");
}

}
