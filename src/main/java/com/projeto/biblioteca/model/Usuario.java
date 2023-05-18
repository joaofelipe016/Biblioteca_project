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
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(nullable = false, name = "nm_login")
    private String nmLogin;

    @Column(nullable = false, name = "nr_senha")
    private String nrSenha;

    @OneToOne
    private PessoaFisica pessoaFisica;

    @OneToOne
    private Matricula matricula;
}