package service;
import model.Usuario;
public interface UsuarioService {
    public boolean emailValido(String email);
    public Usuario cadastro();
    public Usuario login(Usuario usuario);
}