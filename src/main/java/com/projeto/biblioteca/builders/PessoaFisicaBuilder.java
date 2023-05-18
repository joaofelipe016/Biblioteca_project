package com.projeto.biblioteca.builders;

import com.projeto.biblioteca.model.Bairro;
import com.projeto.biblioteca.model.Endereco;
import com.projeto.biblioteca.model.Pessoa;
import com.projeto.biblioteca.model.PessoaFisica;

import java.time.LocalDate;

public class PessoaFisicaBuilder {
    private PessoaFisica pessoaFisica;

    public PessoaFisicaBuilder() {
        pessoaFisica = new PessoaFisica();
        pessoaFisica.setPessoa(new Pessoa());
        pessoaFisica.getPessoa().setEndereco(new Endereco());
        pessoaFisica.getPessoa().getEndereco().setBairro(new Bairro());
    }

    public PessoaFisicaBuilder withNrCpf(String nrCpf) {
        pessoaFisica.setNrCpf(nrCpf);
        return this;
    }

    public PessoaFisicaBuilder withDtNascimento(LocalDate dtNascimento) {
        pessoaFisica.setDtNascimento(dtNascimento);
        return this;
    }

    public PessoaFisicaBuilder withNmPessoa(String nmPessoa) {
        pessoaFisica.getPessoa().setNmPessoa(nmPessoa);
        return this;
    }

    public PessoaFisicaBuilder withNmEmail(String nmEmail) {
        pessoaFisica.getPessoa().setNmEmail(nmEmail);
        return this;
    }

    public PessoaFisicaBuilder withNrTelefone(String nrTelefone) {
        pessoaFisica.getPessoa().setNrTelefone(nrTelefone);
        return this;
    }

    public PessoaFisicaBuilder withNrCep(String nrCep) {
        pessoaFisica.getPessoa().getEndereco().setNrCep(nrCep);
        return this;
    }

    public PessoaFisicaBuilder withNmLogradouro(String nmLogradouro) {
        pessoaFisica.getPessoa().getEndereco().setNmLogradouro(nmLogradouro);
        return this;
    }

    public PessoaFisicaBuilder withNrLogradouro(int nrLogradouro) {
        pessoaFisica.getPessoa().getEndereco().setNrLogradouro(nrLogradouro);
        return this;
    }

    public PessoaFisicaBuilder withIdBairro(Long idBairro) {
        pessoaFisica.getPessoa().getEndereco().getBairro().setIdBairro(idBairro);
        return this;
    }

    public PessoaFisica build() {
        return pessoaFisica;
    }
}