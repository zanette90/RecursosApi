package com.example.recursos.com.example.recursos.controller;

import com.example.recursos.com.example.recursos.dto.recursos.DadosRecursos;
import com.example.recursos.com.example.recursos.service.RecursosService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/Recursos")
public class RecursosController {

    @Autowired
    private RecursosService recursosService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosRecursos dados, UriComponentsBuilder uriComponentsBuilder) {
        return recursosService.cadastrar(dados, uriComponentsBuilder);
    }

    @GetMapping
    public ResponseEntity listar(@PageableDefault(size = 20,sort = "descricao") Pageable pagina) {
        return recursosService.listar(pagina);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable long id) {
        return recursosService.excluir(id);
    }
}
