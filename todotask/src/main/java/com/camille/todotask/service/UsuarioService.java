package com.camille.todotask.service;

import com.camille.todotask.model.Usuario;
import com.camille.todotask.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }
    public Usuario login(String email, String senha){
        Usuario usuario = repository.findByEmail(email).orElseThrow(() -> new RuntimeException("E-mail de usuário não encontrado. "));

        if (!usuario.autenticar(email, senha)){
            throw new RuntimeException("Senha inválida. ");
        }
        return usuario;
    }
}
