package com.projeto.biblioteca.services;

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
        PessoaFisica pessoaFisica = this.pessoaFisicaRepository.findById(id).orElseThrow(() -> new RuntimeException("PessoaFisica não encontrada com id " + id));
        popularPessoaFisica(pessoaFisica, pessoaFisicaAtualizada);
        return this.pessoaFisicaRepository.save(pessoaFisica);
    }

    private void popularPessoaFisica(PessoaFisica pessoaFisica, PessoaFisica pessoaFisicaAtualizada) {
        pessoaFisica.setNrCpf(pessoaFisicaAtualizada.getNrCpf());
        pessoaFisica.setDtNascimento(pessoaFisicaAtualizada.getDtNascimento());
        pessoaFisica.getPessoa().setNmPessoa(pessoaFisicaAtualizada.getPessoa().getNmPessoa());
        pessoaFisica.getPessoa().setNmEmail(pessoaFisicaAtualizada.getPessoa().getNmEmail());
        pessoaFisica.getPessoa().setNrTelefone(pessoaFisicaAtualizada.getPessoa().getNrTelefone());
        pessoaFisica.getPessoa().getEndereco().setNrCep(pessoaFisicaAtualizada.getPessoa().getEndereco().getNrCep());
        pessoaFisica.getPessoa().getEndereco().setNmLogradouro(pessoaFisicaAtualizada.getPessoa().getEndereco().getNmLogradouro());
        pessoaFisica.getPessoa().getEndereco().setNrLogradouro(pessoaFisicaAtualizada.getPessoa().getEndereco().getNrLogradouro());
        pessoaFisica.getPessoa().getEndereco().getBairro().setIdBairro(pessoaFisicaAtualizada.getPessoa().getEndereco().getBairro().getIdBairro());
    }
}