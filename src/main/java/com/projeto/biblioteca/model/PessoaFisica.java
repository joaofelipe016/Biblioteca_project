package com.projeto.biblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pessoa_fisica")
public class PessoaFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa_fisica")
    Long idPessoaFisica;

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    @Column(nullable = false, name = "dt_nascimento")
    private LocalDate dtNascimento;

    @Column(nullable = false, name = "nr_cpf")
    String nrCpf;

    @OneToOne (cascade = CascadeType.ALL)
    private Pessoa pessoa;

}