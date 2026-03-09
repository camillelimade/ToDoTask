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
        try{
            novoUsuario = executar.cadastro();
        }catch (Exception e){
            System.out.println("Erro no cadastro: " +  e.getMessage());
            return;
        }

        // execução do menu principal do gerenciador
        int opcao = executar.menu();
//        switch (opcao) {
//            case 1:
//                // função de adicionar tasks no próximo commit
//        }

    }
}
