package service;

import model.Categoria;
import java.util.ArrayList;

public class CategoriaService {

    private ArrayList<Categoria> categorias = new ArrayList<>();

    public CategoriaService() {
        categoriasBase();
    }

    private void categoriasBase() {

        categorias.add(new Categoria("Estudos"));
        categorias.add(new Categoria("Pessoal"));
        categorias.add(new Categoria("Trabalho"));

    }

    public ArrayList<Categoria> listarCategorias() {
        return categorias;
    }

    public Categoria criarCategoria(String nome) {
        Categoria nova = new Categoria(nome);
        categorias.add(nova);
        return nova;
    }

}