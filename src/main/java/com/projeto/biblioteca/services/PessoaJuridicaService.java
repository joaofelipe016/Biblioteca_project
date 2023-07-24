package com.projeto.biblioteca.services;

import com.projeto.biblioteca.model.PessoaJuridica;
import com.projeto.biblioteca.repositories.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaJuridicaService {

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    public PessoaJuridica salvar(PessoaJuridica pessoaJuridica) {
        return this.pessoaJuridicaRepository.save(pessoaJuridica);
    }

    public PessoaJuridica atualizar(PessoaJuridica pessoaJuridicaAtualizada, Long id) {
        PessoaJuridica pessoaJuridica = this.pessoaJuridicaRepository.findById(id).orElseThrow(() -> new RuntimeException("PessoaFisica não encontrada com id " + id));
        popularPessoaJuridica(pessoaJuridica, pessoaJuridicaAtualizada);
        return this.pessoaJuridicaRepository.save(pessoaJuridica);
    }

    private void popularPessoaJuridica(PessoaJuridica pessoaJuridica, PessoaJuridica pessoaJuridicaAtualizada) {
        pessoaJuridica.setNrCnpj(pessoaJuridicaAtualizada.getNrCnpj());
        pessoaJuridica.getPessoa().setNmPessoa(pessoaJuridicaAtualizada.getPessoa().getNmPessoa());
        pessoaJuridica.getPessoa().setNmEmail(pessoaJuridicaAtualizada.getPessoa().getNmEmail());
        pessoaJuridica.getPessoa().setNrTelefone(pessoaJuridicaAtualizada.getPessoa().getNrTelefone());
        pessoaJuridica.getPessoa().getEndereco().setNrCep(pessoaJuridicaAtualizada.getPessoa().getEndereco().getNrCep());
        pessoaJuridica.getPessoa().getEndereco().setNmLogradouro(pessoaJuridicaAtualizada.getPessoa().getEndereco().getNmLogradouro());
        pessoaJuridica.getPessoa().getEndereco().setNrLogradouro(pessoaJuridicaAtualizada.getPessoa().getEndereco().getNrLogradouro());
        pessoaJuridica.getPessoa().getEndereco().getBairro().setIdBairro(pessoaJuridicaAtualizada.getPessoa().getEndereco().getBairro().getIdBairro());
    }

    public PessoaJuridica getById(Long id) {
        return this.pessoaJuridicaRepository.getById(id);
    }
}