package controller;

import model.*;
import service.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoController implements UsuarioService, TaskService, ProjetoService {
    private ArrayList<Task> tasks = new ArrayList<>();
    private CategoriaService categoriaService = new CategoriaService();
    private final Scanner scanner = new Scanner(System.in);

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

        System.out.println("Digite seu nome: ");
        String nomeUser = scanner.nextLine();

        System.out.println("Digite seu e-mail: ");
        String emailUser = scanner.nextLine();

        System.out.println("Digite sua senha: ");
        String senhaUser = scanner.nextLine();
        // validação de entradas

        if (nomeUser.isBlank() || emailUser.isBlank() || !emailValido(emailUser)) {
            throw new NullPointerException("Erro ao cadastrar: Nome ou E-mail inválidos, tente novamente!");
        } else {
            divisor();
            System.out.println("Parabéns " + nomeUser + ", você foi cadastrado(a) com sucesso!");
            return new Usuario(nomeUser, emailUser, senhaUser);
        }

    }

    @Override
    public Usuario login(String email, String senha) {
        while (true) {
            // recebe atributos
            divisor();
            System.out.println("Digite seu e-mail: ");
            String email = scanner.nextLine();
            divisor();
            System.out.println("Digite sua senha: ");
            String senha = scanner.nextLine();
            divisor();
            if (email.isBlank() || senha.isBlank()) {
                System.out.println("O e-mail e senha não podem ser vazios. Tente novamente.");
                continue;
            }
            if (usuario.autenticar(email, senha)) {
                divisor();
                System.out.println("Login de " + usuario.getNome() + " realizado com sucesso!");
                return usuario;
            } else {
                System.out.println("Erro no Login: E-mail ou Senha inválidos. Tente novamente.");
            }
        }
    }

    public Categoria menuCategorias() {
        while (true) {

            int i = 1;
            for (Categoria cat : categoriaService.listarCategorias()) {
                System.out.println(i + ". " + cat.getNome());
                i++;
            }
            System.out.println(i + ". Criar nova categoria");
            divisor();
            System.out.println("Escolha uma categoria:");
            String entrada = scanner.nextLine();
            int opcao;
            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
                continue;
            }
            if (opcao == i) {
                divisor();
                System.out.println("Digite o nome da nova categoria:");
                divisor();
                String nome = scanner.nextLine();
                if (!nome.isBlank()) {
                    return categoriaService.criarCategoria(nome);
                }
                System.out.println("Nome inválido. Tente novamente.");
                continue;
            }
            if (opcao > 0 && opcao <= i) {
                return categoriaService.listarCategorias().get(opcao - 1);
            }
            System.out.println("Opção inválida. Tente novamente.");
        }
    }

    public void excluirTask(int ID, ArrayList<Task> tasks) {
        // verifica se o ID é válido
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == ID) {
                System.out.println("Task " + tasks.get(i).getNomeTask() + " removida com sucesso!");
                tasks.remove(i);
                return;
            }
        }
        System.out.println("Task com ID " + ID + " não encontrada. Tente novamente.");
    }


    public int menu(Projeto projeto) {
        divisor();
        System.out.println("Seja bem vindo(a) ao ToDoTask! 📋");
        divisor();
        System.out.println("--- Esse é o seu gerenciador de Task's! ---\n" +
                "--- Projeto: " + projeto.getNome() + "\n" +
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
            System.out.println("Digite o indice da opção desejada: ");
            // validação de tipo de entrada
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
                divisor();
                break;
            } else {
                divisor();
                System.out.println("Digite uma entrada válida! Tente novamente.");
                divisor();
                scanner.nextLine();
            }
        }
        return opcao;
    }

    public Task criaTask(int ID) {
        // cria nome da Task
        String nomeTask;
        while (true) {
            // recebe nome da task
            System.out.println("ToDoTask - Adicione aqui o nome de sua task: ");
            nomeTask = scanner.nextLine();
            // lê e trata
            if (nomeTask.isBlank()) {
                divisor();
                System.out.println("O nome da task não pode ser vazio. Tente novamente.");
                divisor();
            } else {
                break;
            }
        }
        divisor();
        // recebe categoria, com o menu da própria entidade por meio da função chamada
        Categoria categoria = menuCategorias();
        divisor();
        // cria variavel de descricao
        String descricao;
        while (true) {
            // recebe descricao da task
            System.out.println("ToDoTask - Descreva sua Task: ");
            descricao = scanner.nextLine();
            // lê e trata
            if (descricao.isBlank()) {
                divisor();
                System.out.println("A descrição não pode estar vazia. Tente novamente.");
                divisor();
            } else {
                break;
            }
        }
        divisor();
        System.out.println("Task " + nomeTask + " registrada com sucesso! ");
        return new Task(ID, nomeTask, categoria, descricao);
    }

    public void listarTasks(ArrayList<Task> tasks, Projeto projeto) {
        if (tasks.isEmpty()) {
            System.out.println("Erro ao listar: Não foi encontrado nenhuma task registrada. ");
            return;
        }
        System.out.println("ToDoTask — Sua lista de Task's | Projeto " + projeto.getNome());
        divisor();
        for (Task task : tasks) {
            System.out.println(task.toString());
            System.out.println(" ");
        }

    }

    @Override
    public Task criaTaskProjeto(int id, Projeto projeto) {
        String nomeTask;
        while (true) {
            // recebe nome da Task
            System.out.println("Nome da Task: ");
            nomeTask = scanner.nextLine();
            // verifica nome da Task
            if (nomeTask.isBlank()) {
                divisor();
                System.out.println("O nome da Task não pode ser vazio. Tente novamente.");
                divisor();
                continue;
            }
            // recebe categoria da task
            Categoria categoria = menuCategorias();
            String descricao;
            while (true) {
                // recebe descricao
                divisor();
                System.out.println("Descrição da Task: ");
                divisor();
                descricao = scanner.nextLine();
                // verifica nome da Task
                if (descricao.isBlank()) {
                    divisor();
                    System.out.println("A descrição não pode ser vazia. Tente novamente.");
                    divisor();
                    continue;
                }
                // instancia task
                Task novaTask = new Task(id, nomeTask, categoria, descricao);
                // set a task em projeto
                novaTask.setProjeto(projeto);
                // agrega task a projeto
                projeto.adicionarTask(novaTask);
                // avisa ação anterior
                divisor();
                System.out.println("Task " + nomeTask + " adicionada a " + projeto.getNome() + " com sucesso!");
                // retorna resultado da função
                return novaTask;
            }
        }
    }

    public void completaTask(int ID, ArrayList<Task> tasks) {
        // int indice = ID - 1;
        for (Task task : tasks) {
            if (task.getId() == ID) {
                task.setStatus(Status.CONCLUIDA);
                divisor();
                System.out.println("Task " + task.getNomeTask() + " completada com sucesso! ");
                return;
            }
        }
        System.out.println("Não foi possível completar a Task! Tente novamente.");
    }

    public void editarTask(int ID, ArrayList<Task> tasks) {
        for (Task task : tasks) {
            if (task.getId() == ID) {
                // nome
                divisor();
                System.out.println("ToDoTask - Altere o nome da task selecionada: ");
                String nomeEdit = scanner.nextLine();
                divisor();
                // categoria
                System.out.println("ToDoTask - Escolha a nova categoria da task: ");
                Categoria categoriaEdit = menuCategorias();
                divisor();

                System.out.println("ToDoTask - Descreva sua Task:");
                String descricaoEdit = scanner.nextLine();

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
        divisor();
        System.out.println("Task não encontrada.");
        divisor();
    }

    @Override
    public Projeto criaProjeto(int id, Usuario usuario) {
        while (true) {
            // recebe nome do projeto
            divisor();
            System.out.println("Nome do Projeto: ");
            String nomeProj = scanner.nextLine();
            // verifica o nome do projeto
            if (nomeProj.isBlank()) {
                divisor();
                System.out.println("O nome do projeto não pode ser vazio. Tente novamente.");
                divisor();
                continue;
            }
            // pós verificação, instancia novo Projeto
            Projeto projeto = new Projeto(id, nomeProj);
            // associa projeto ao usuário
            usuario.adicionarProjeto(projeto);
            // avisa sobre a ação anterior
            divisor();
            System.out.println(projeto.getNome() + " criado com sucesso!");
            // retorna resultado da função
            return projeto;
        }
    }

    @Override
    public boolean listaVazia(Usuario usuario) {
        return usuario.getProjetos().isEmpty();
        // se true -> lista vazia
        // se false -> lista povoada
    }

    @Override
    public void listaProjetos(Usuario usuario) {
        if (listaVazia(usuario)) {
            divisor();
            System.out.println("Os Projetos de  " + usuario.getNome() + " não foram encontrados.");
            divisor();
            return;
        }
        divisor();
        System.out.println("ToDoTask - Aqui estão os Projetos de " + usuario.getNome());
        divisor(); // separa mensagem dos projetos
        for (Projeto projeto : usuario.getProjetos()) {
            System.out.println("Projeto: " + projeto.getNome());
            divisor(); // separa um projeto do outro
        }
    }

    public int menuProjetos() {
        System.out.println("Seja bem vindo(a) ao ToDoTask! 📋 \n" +
                "----------------------------------------------\n" +
                "--- Esse é o seu gerenciador de Projetos! ---\n" +
                "1. Criar projeto \n" +
                "2. Listar projetos \n" +
                "3. Entrar em projeto \n" +
                "4. Sair");
        divisor();
        System.out.println("Digite qual serviço deseja: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
