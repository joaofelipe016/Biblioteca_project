package com.projeto.biblioteca.services;

import com.projeto.biblioteca.DTO.UsuarioDTO;
import com.projeto.biblioteca.model.Usuario;
import com.projeto.biblioteca.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario salvar(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario = usuarioDTO.getUsuario();
        return this.usuarioRepository.save(usuario);
    }
}