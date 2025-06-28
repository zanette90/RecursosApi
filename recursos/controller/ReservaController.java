package com.example.recursos.com.example.recursos.controller;

import com.example.recursos.com.example.recursos.dto.reserva.DadosReserva;
import com.example.recursos.com.example.recursos.service.ReservaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/Reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosReserva dados, UriComponentsBuilder uriComponentsBuilder) {
        return reservaService.cadastrar(dados, uriComponentsBuilder);
    }

    @GetMapping
    public ResponseEntity listar(@PageableDefault(size = 20,sort = "descricao") Pageable pagina) {
        return reservaService.listar(pagina);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable long idReserva) {
        return reservaService.excluir(idReserva);
    }
}
