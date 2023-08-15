package com.projeto.biblioteca.repositories.pessoajuridicacriteria.criteria.impl;

import com.projeto.biblioteca.model.PessoaFisica;
import com.projeto.biblioteca.model.PessoaJuridica;
import com.projeto.biblioteca.repositories.pessoafisicacriteria.criteria.params.PessoaFisicaFilterParam;
import com.projeto.biblioteca.repositories.pessoajuridicacriteria.criteria.PessoaJuridicaRepositoryCustom;
import com.projeto.biblioteca.repositories.pessoajuridicacriteria.criteria.params.PessoaJuridicaFilterParam;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaRepositoryCustomImpl implements PessoaJuridicaRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<PessoaJuridica> getFilter(PessoaJuridicaFilterParam param) {

        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<PessoaJuridica> query = criteriaBuilder.createQuery(PessoaJuridica.class);

        Root<PessoaJuridica> pessoaFisica = query.from(PessoaJuridica.class);

        List<Predicate> predicates = new ArrayList<>();

        if ( param.getNmPessoa() != null) {
            predicates.add(criteriaBuilder.like(pessoaFisica.get("pessoa").get("nmPessoa"), "%" + param.getNmPessoa() + "%"));
        }
        if ( param.getNrCnpj() != null) {
            predicates.add(criteriaBuilder.like(pessoaFisica.get("nrCnpj"), "%" + param.getNrCnpj() + "%"));
        }
        if (!predicates.isEmpty()) {
            query.where( predicates.stream().toArray( Predicate[]::new ) );
        }
        TypedQuery<PessoaJuridica> queryResult = this.entityManager.createQuery(query);

        return queryResult.getResultList();
    }
}