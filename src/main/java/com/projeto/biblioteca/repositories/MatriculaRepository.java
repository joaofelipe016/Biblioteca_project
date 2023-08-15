package com.projeto.biblioteca.repositories;

import com.projeto.biblioteca.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> { }