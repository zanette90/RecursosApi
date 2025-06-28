package com.example.recursos.com.example.recursos.service;

import com.example.recursos.com.example.recursos.dto.autenticacao.AutenticacaoDto;
import com.example.recursos.com.example.recursos.dto.autenticacao.DtoUsuario;
import com.example.recursos.com.example.recursos.dto.autenticacao.RegistrarDTO;
import com.example.recursos.com.example.recursos.dto.funcao.DadosFuncao;
import com.example.recursos.com.example.recursos.model.Usuario;
import com.example.recursos.com.example.recursos.repository.RepositoryUsuario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceUsuario {

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    @Transactional
    public ResponseEntity cadastrar (RegistrarDTO dados, UriComponentsBuilder uriComponentsBuilder) {
        var usuario = new Usuario(dados);
        repositoryUsuario.save(usuario);
        var uri = uriComponentsBuilder.path("/cadastrar/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DtoUsuario(usuario));
    }

    public ResponseEntity buscarUsuarios(AutenticacaoDto dados) {
        var usuario = repositoryUsuario.findByLogin(dados.login());
        if (usuario.getLogin().equalsIgnoreCase(dados.login()) && usuario.getSenha().equalsIgnoreCase(dados.senha())) {
            return ResponseEntity.ok("Login realizado com sucesso");
        }
        return ResponseEntity.notFound().build();
    }

}