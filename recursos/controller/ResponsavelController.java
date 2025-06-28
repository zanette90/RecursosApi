package com.example.recursos.com.example.recursos.controller;

import com.example.recursos.com.example.recursos.dto.responsavel.DadosResponsavel;
import com.example.recursos.com.example.recursos.service.ResponsavelService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/Responsavel")
public class ResponsavelController {

    @Autowired
    private ResponsavelService responsavelService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosResponsavel dados, UriComponentsBuilder uriComponentsBuilder) {
        return responsavelService.cadastrar(dados, uriComponentsBuilder);
    }

    @GetMapping
    public ResponseEntity listar(@PageableDefault(size = 20,sort = "descricao") Pageable pagina) {
        return responsavelService.listar(pagina);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosResponsavel dados) {
        return responsavelService.atualizar(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable long idReserva) {
        return responsavelService.excluir(idReserva);
    }
}
