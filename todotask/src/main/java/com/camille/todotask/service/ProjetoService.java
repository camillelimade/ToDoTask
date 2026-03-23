package service;
import model.Projeto;
import model.Usuario;
public interface ProjetoService {
    public Projeto criaProjeto(int id, Usuario usuario);
    public boolean listaVazia(Usuario usuario);
    public void listaProjetos(Usuario usuario);
}
