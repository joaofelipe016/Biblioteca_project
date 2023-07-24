package com.projeto.biblioteca.controllers;

import com.projeto.biblioteca.model.PessoaJuridica;
import com.projeto.biblioteca.services.PessoaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoasJuridicas")
public class PessoaJuridicaController {

    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;

    @PostMapping
    public PessoaJuridica salvar(@RequestBody PessoaJuridica pessoaJuridica) {
        this.pessoaJuridicaService.salvar(pessoaJuridica);
        return ResponseEntity.ok(pessoaJuridica).getBody();
    }

    @PutMapping(path = "/{id}")
    public PessoaJuridica atualizar(@PathVariable("id") Long id, @RequestBody PessoaJuridica pessoaJuridica) {
        this.pessoaJuridicaService.atualizar(pessoaJuridica, id);
        return ResponseEntity.ok(pessoaJuridica).getBody();
    }

    @GetMapping(path = "/{id}")
    public PessoaJuridica getById(@PathVariable("id") Long id, @RequestBody PessoaJuridica pessoaJuridica) {
        return this.pessoaJuridicaService.getById(id);
    }
}