package com.projeto.biblioteca.recursos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
public class SearchCriterios {

    private Map<String, Object> criteria;

    public SearchCriterios() {
        this.criteria = new HashMap<>();
    }

    public void addCriterio(String chave, Object valor) {
        criteria.put(chave, valor);
    }
}