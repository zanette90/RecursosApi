package com.example.recursos.com.example.recursos.controller;

import com.example.recursos.com.example.recursos.dto.autenticacao.AutenticacaoDto;
import com.example.recursos.com.example.recursos.dto.autenticacao.RegistrarDTO;
import com.example.recursos.com.example.recursos.model.Usuario;
import com.example.recursos.com.example.recursos.service.ServiceUsuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/auth")
public class UsuarioController {

    @Autowired
    private ServiceUsuario serviceUsuario;

    @PostMapping("/registrar")
    public ResponseEntity cadastrar(@RequestBody @Valid RegistrarDTO dados, UriComponentsBuilder uriComponentsBuilder) {
        return serviceUsuario.cadastrar(dados, uriComponentsBuilder);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AutenticacaoDto dados) {
        return serviceUsuario.buscarUsuarios(dados);
    }
}
