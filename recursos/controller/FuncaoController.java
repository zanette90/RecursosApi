package com.example.recursos.com.example.recursos.controller;

import com.example.recursos.com.example.recursos.dto.funcao.DadosFuncao;
import com.example.recursos.com.example.recursos.service.FuncaoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/funcao")
public class FuncaoController {

    @Autowired
    private FuncaoService funcaoService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosFuncao dados, UriComponentsBuilder uriComponentsBuilder) {
        return funcaoService.cadastrar(dados, uriComponentsBuilder);
    }

    @GetMapping
    public ResponseEntity listar(@PageableDefault(size = 20,sort = "descricao") Pageable pagina) {
        return funcaoService.listar(pagina);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable long id, @RequestBody @Valid DadosFuncao dados) {
        return funcaoService.atualizar(id,dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable long id) {
        return funcaoService.excluir(id);
    }
}
