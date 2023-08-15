package com.projeto.biblioteca.repositories;

import com.projeto.biblioteca.model.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BairroRepository extends JpaRepository<Bairro, Long> {
}
