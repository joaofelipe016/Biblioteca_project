package com.projeto.biblioteca.repositories.pessoafisicacriteria.criteria;

import com.projeto.biblioteca.model.PessoaFisica;
import com.projeto.biblioteca.repositories.pessoafisicacriteria.criteria.params.PessoaFisicaFilterParam;

import java.util.List;

public interface PessoaFisicaRepositoryCustom   {

    List<PessoaFisica> getFilter(PessoaFisicaFilterParam param);
}