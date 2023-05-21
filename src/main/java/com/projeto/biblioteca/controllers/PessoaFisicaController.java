package com.projeto.biblioteca.controllers;

import com.projeto.biblioteca.model.PessoaFisica;
import com.projeto.biblioteca.services.PessoaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoasFisicas")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @PostMapping
    public PessoaFisica salvar(@RequestBody PessoaFisica pessoaFisica) {
        this.pessoaFisicaService.salvar(pessoaFisica);
        return ResponseEntity.ok(pessoaFisica).getBody();
    }

    @PutMapping(path = "/{id}")
    public PessoaFisica atualizar(@PathVariable("id") Long id, @RequestBody PessoaFisica pessoaFisica) {
        this.pessoaFisicaService.atualizar(pessoaFisica, id);
        return ResponseEntity.ok(pessoaFisica).getBody();
    }

    @GetMapping(path = "/{id}")
    public PessoaFisica getById(@PathVariable("id") Long id) {
        return this.pessoaFisicaService.getById(id);
    }
}