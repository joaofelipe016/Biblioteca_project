package com.projeto.biblioteca.controllers;

import com.projeto.biblioteca.DTO.UsuarioDTO;
import com.projeto.biblioteca.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        this.usuarioService.salvar(usuarioDTO);
        return ResponseEntity.ok(usuarioDTO).getBody();
    }
}