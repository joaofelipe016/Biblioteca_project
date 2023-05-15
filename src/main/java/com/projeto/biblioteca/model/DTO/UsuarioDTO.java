package com.projeto.biblioteca.model.DTO;

import com.projeto.biblioteca.model.Matricula;
import com.projeto.biblioteca.model.PessoaFisica;
import com.projeto.biblioteca.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO{

    private Usuario usuario;

    private PessoaFisica pessoaFisica;

    private Matricula matricula;

}
