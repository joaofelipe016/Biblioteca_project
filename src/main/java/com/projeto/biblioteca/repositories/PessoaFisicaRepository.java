package com.projeto.biblioteca.repositories;

import com.projeto.biblioteca.model.Pessoa;
import com.projeto.biblioteca.model.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> { }
