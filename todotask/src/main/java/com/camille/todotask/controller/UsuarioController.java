package com.camille.todotask.controller;

import com.camille.todotask.model.Usuario;
import com.camille.todotask.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }
    @PostMapping("/login")
    public Usuario login(@RequestParam String email, @RequestParam String senha){
        return service.login(email, senha);
    }
}
