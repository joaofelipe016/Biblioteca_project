package com.projeto.biblioteca.builders;

import com.projeto.biblioteca.recursos.SearchCriterios;

public class PessoaFisicaSearchBuilder {

    private SearchCriterios searchCriterios;

        public PessoaFisicaSearchBuilder addNmPessoa(String nmPessoa) {
            searchCriterios.addCriterio("nmPessoa", nmPessoa);
            return this;
        }

    public SearchCriterios build() {
        return searchCriterios;
    }
}