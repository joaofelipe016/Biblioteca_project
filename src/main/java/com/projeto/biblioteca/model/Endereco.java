package com.projeto.biblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco", unique = true)
    private Long idEndereco;

    @Column(nullable = false, name = "nr_cep")
    private String nrCep;

    @Column(nullable = false, name = "nm_logradouro")
    private String nmLogradouro;

    @Column(nullable = false, name = "nr_logradouro")
    private int nrLogradouro;

    @OneToOne
    private Bairro bairro;
}