package controller;
import service.CategoriaService;
import model.Task;
import model.Usuario;
import model.Categoria;
import service.Completavel;
import service.TaskService;
import service.UsuarioService;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoController implements UsuarioService, Completavel, TaskService {
    private ArrayList<Task> tasks = new ArrayList<>();
    private CategoriaService categoriaService = new CategoriaService();
    public void divisor() {
        System.out.println("-----------------------------------------");
    }
    // UsuarioService
    public boolean emailValido(String email) {
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
    public Categoria menuCategorias() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha uma categoria:");

        int i = 1;
        for (Categoria cat : categoriaService.listarCategorias()) {
            System.out.println(i + ". " + cat.getNome());
            i++;
        }

        System.out.println(i + ". Criar nova categoria");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        if (opcao == i) {

            System.out.println("Digite o nome da nova categoria:");
            String nome = scanner.nextLine();

            return categoriaService.criarCategoria(nome);

        } else {

            return categoriaService.listarCategorias().get(opcao - 1);

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
        Categoria categoria = menuCategorias();
        divisor();
        System.out.println("ToDoTask - Descreva sua Task:");
        String descricao = lerTask.nextLine();

        if (nomeTask.isBlank()) {
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
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == ID) {
                System.out.println("Task " + tasks.get(i).getNomeTask() + " removida com sucesso!");
                tasks.remove(i);
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
                // nome
                System.out.println("ToDoTask - Altere o nome da task selecionada: ");
                String nomeEdit = lerEdicaoTask.nextLine();
                divisor();
                // categoria
                System.out.println("ToDoTask - Escolha a nova categoria da task: ");
                Categoria categoriaEdit = menuCategorias();
                divisor();

                System.out.println("ToDoTask - Descreva sua Task:");
                String descricaoEdit = lerEdicaoTask.nextLine();

                if (nomeEdit.isBlank()) {
                    throw new IllegalArgumentException("Erro ao editar task: parâmetros inválidos.");
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
