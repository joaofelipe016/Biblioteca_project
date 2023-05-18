package com.projeto.biblioteca.services;

import com.projeto.biblioteca.model.Matricula;
import com.projeto.biblioteca.repositories.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {

    @Autowired
    MatriculaRepository matriculaRepository;

    public Matricula salvar(Matricula matricula) {
        return this.matriculaRepository.save(matricula);
    }

    public Matricula update(Matricula matriculaAtualiza, Long id) {
        Matricula matricula = this.matriculaRepository.findById(id).orElseThrow(() -> new RuntimeException("Matricula não encontrada com id " + id));
        return null;
    }
}