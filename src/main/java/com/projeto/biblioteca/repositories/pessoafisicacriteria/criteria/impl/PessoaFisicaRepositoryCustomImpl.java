package com.projeto.biblioteca.repositories.pessoafisicacriteria.criteria.impl;

import com.projeto.biblioteca.model.PessoaFisica;
import com.projeto.biblioteca.repositories.pessoafisicacriteria.criteria.PessoaFisicaRepositoryCustom;
import com.projeto.biblioteca.repositories.pessoafisicacriteria.criteria.params.PessoaFisicaFilterParam;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaRepositoryCustomImpl implements PessoaFisicaRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<PessoaFisica> getFilter(PessoaFisicaFilterParam param) {

        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<PessoaFisica> query = criteriaBuilder.createQuery(PessoaFisica.class);

        Root<PessoaFisica> pessoaFisica = query.from(PessoaFisica.class);

        List<Predicate> predicates = new ArrayList<>();

        if ( param.getNmPessoa() != null) {
            predicates.add(criteriaBuilder.like(pessoaFisica.get("pessoa").get("nmPessoa"), "%" + param.getNmPessoa() + "%"));
        }
        if ( param.getNrCpf() != null) {
            predicates.add(criteriaBuilder.like(pessoaFisica.get("nrCpf"), "%" + param.getNrCpf() + "%"));
        }
        if (!predicates.isEmpty()) {
            query.where( predicates.stream().toArray( Predicate[]::new ) );
        }
        TypedQuery<PessoaFisica> queryResult = this.entityManager.createQuery(query);

        return queryResult.getResultList();
    }
}