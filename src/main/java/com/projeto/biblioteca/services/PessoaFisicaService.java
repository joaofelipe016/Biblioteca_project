package com.projeto.biblioteca.services;

import com.projeto.biblioteca.model.Bairro;
import com.projeto.biblioteca.model.PessoaFisica;
import com.projeto.biblioteca.repositories.BairroRepository;
import com.projeto.biblioteca.repositories.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    private BairroRepository bairroRepository;

    public PessoaFisica salvar(PessoaFisica pessoaFisica) {
        return this.pessoaFisicaRepository.save(pessoaFisica);
    }

    public PessoaFisica atualizar(PessoaFisica pessoaFisicaUpdate, Long id) {
        PessoaFisica pessoaFisica = pessoaFisicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PessoaFisica não encontrada com id " + id));
        return this.pessoaFisicaRepository.save(PopularPessoaFisica(pessoaFisicaUpdate, pessoaFisica));
    }

    private PessoaFisica PopularPessoaFisica(PessoaFisica pessoaFisicaUpdate, PessoaFisica pessoaFisica) {
        pessoaFisica.setNrCpf(pessoaFisicaUpdate.getNrCpf());
        pessoaFisica.setDtNascimento(pessoaFisicaUpdate.getDtNascimento());
        pessoaFisica.getPessoa().setNmPessoa(pessoaFisicaUpdate.getPessoa().getNmPessoa());
        pessoaFisica.getPessoa().setNmEmail(pessoaFisicaUpdate.getPessoa().getNmEmail());
        pessoaFisica.getPessoa().setNrTelefone(pessoaFisicaUpdate.getPessoa().getNrTelefone());
        pessoaFisica.getPessoa().getEndereco().setNrCep(pessoaFisicaUpdate.getPessoa().getEndereco().getNrCep());
        pessoaFisica.getPessoa().getEndereco().setNmLogradouro(pessoaFisicaUpdate.getPessoa().getEndereco().getNmLogradouro());
        pessoaFisica.getPessoa().getEndereco().setNrLogradouro(pessoaFisicaUpdate.getPessoa().getEndereco().getNrLogradouro());
        Bairro bairro = bairroRepository.findById(pessoaFisicaUpdate.getPessoa().getEndereco().getBairro().getIdBairro())
                .orElseThrow(() -> new RuntimeException("Bairro não encontrado com id " + pessoaFisicaUpdate.getPessoa().getEndereco().getBairro().getIdBairro()));
        pessoaFisica.getPessoa().getEndereco().setBairro(bairro);
        return pessoaFisica;
    }

    public PessoaFisica getById(Long id) {
        return this.pessoaFisicaRepository.getReferenceById(id);
    }
}