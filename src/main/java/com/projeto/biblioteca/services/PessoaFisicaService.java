package com.projeto.biblioteca.services;

import com.projeto.biblioteca.builders.PessoaFisicaBuilder;
import com.projeto.biblioteca.model.PessoaFisica;
import com.projeto.biblioteca.repositories.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    public PessoaFisica salvar(PessoaFisica pessoaFisica) {
        return this.pessoaFisicaRepository.save(pessoaFisica);
    }

    public PessoaFisica atualizar(PessoaFisica pessoaFisicaAtualizada, Long id) {
        PessoaFisica pessoaFisica = pessoaFisicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PessoaFisica não encontrada com id " + id));
        PessoaFisica pessoaFisicaAtualizadaComId = new PessoaFisicaBuilder()
                .withNrCpf(pessoaFisicaAtualizada.getNrCpf())
                .withDtNascimento(pessoaFisicaAtualizada.getDtNascimento())
                .withNmPessoa(pessoaFisica.getPessoa().getNmPessoa())
                .withNmEmail(pessoaFisica.getPessoa().getNmEmail())
                .withNrTelefone(pessoaFisica.getPessoa().getNrTelefone())
                .withNrCep(pessoaFisica.getPessoa().getEndereco().getNrCep())
                .withNmLogradouro(pessoaFisica.getPessoa().getEndereco().getNmLogradouro())
                .withNrLogradouro(pessoaFisica.getPessoa().getEndereco().getNrLogradouro())
                .withIdBairro(pessoaFisica.getPessoa().getEndereco().getBairro().getIdBairro())
                .build();
        return pessoaFisicaRepository.save(pessoaFisicaAtualizadaComId);
    }
}