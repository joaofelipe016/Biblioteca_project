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
@Table(name = "pessoa_juridica")
public class PessoaJuridica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa_juridica")
    private Long idPessoaFisica;

    @Column(nullable = false, name = "nr_cnpj")
    private String nrCnpj;

    @OneToOne(cascade = CascadeType.ALL)
    private Pessoa pessoa;

}
