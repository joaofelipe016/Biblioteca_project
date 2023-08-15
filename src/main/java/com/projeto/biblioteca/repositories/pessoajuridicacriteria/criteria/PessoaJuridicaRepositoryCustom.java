package com.projeto.biblioteca.repositories.pessoajuridicacriteria.criteria;

import com.projeto.biblioteca.model.PessoaFisica;
import com.projeto.biblioteca.model.PessoaJuridica;
import com.projeto.biblioteca.repositories.pessoafisicacriteria.criteria.params.PessoaFisicaFilterParam;
import com.projeto.biblioteca.repositories.pessoajuridicacriteria.criteria.params.PessoaJuridicaFilterParam;

import java.util.List;

public interface PessoaJuridicaRepositoryCustom {
    List<PessoaJuridica> getFilter(PessoaJuridicaFilterParam param);
}