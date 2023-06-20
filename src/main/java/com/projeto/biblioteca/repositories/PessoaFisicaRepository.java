package com.projeto.biblioteca.repositories;

import com.projeto.biblioteca.model.Pessoa;
import com.projeto.biblioteca.model.PessoaFisica;
import com.projeto.biblioteca.repositories.pessoafisicacriteria.criteria.PessoaFisicaRepositoryCustom;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long>, PessoaFisicaRepositoryCustom {
}
