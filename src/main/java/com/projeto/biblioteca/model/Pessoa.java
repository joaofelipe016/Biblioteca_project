package com.projeto.biblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa", unique = true)
    private Long idPessoa;

    @Column(nullable = false, name = "nm_pessoa")
    private String nmPessoa;

    @Column(nullable = false, name = "nr_telefone")
    private String nrTelefone;

    @Column(nullable = false, name = "nm_email")
    private String nmEmail;

    @OneToOne (cascade = CascadeType.ALL)
    private Endereco endereco;

}