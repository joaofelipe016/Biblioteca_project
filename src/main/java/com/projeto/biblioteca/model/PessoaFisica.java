package com.projeto.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class PessoaFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa_fisica")
    private Long idPessoaFisica;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false, name = "dt_nascimento")
    private LocalDate dtNascimento;

    @Column(nullable = false, name = "nr_cpf")
    private String nrCpf;

    @OneToOne(cascade = CascadeType.ALL)
    private Pessoa pessoa;
}