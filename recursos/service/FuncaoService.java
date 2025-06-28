package com.example.recursos.com.example.recursos.service;

import com.example.recursos.com.example.recursos.dto.funcao.DadosFuncao;
import com.example.recursos.com.example.recursos.model.Funcao;
import com.example.recursos.com.example.recursos.repository.RepositoryFuncao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class FuncaoService {

    @Autowired
    private RepositoryFuncao repositoryFuncao;

    @Transactional
    public ResponseEntity cadastrar (DadosFuncao dados, UriComponentsBuilder uriComponentsBuilder) {
        var funcao = new Funcao(dados);
        repositoryFuncao.save(funcao);
        var uri = uriComponentsBuilder.path("/funcao/{id}").buildAndExpand(funcao.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosFuncao(funcao));
    }

    @Transactional
    public ResponseEntity atualizar (long id, DadosFuncao dados) {
        var funcao = repositoryFuncao.findById(id);
        if (funcao.isPresent()) {
            funcao.get().atualizar(dados);
        }
        return ResponseEntity.ok(dados);
    }

    @Transactional
    public ResponseEntity excluir(long id) {
        var funcao = repositoryFuncao.findById(id);
        if (funcao.isPresent()) {
            repositoryFuncao.deleteById(id);
        }
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Page<DadosFuncao>> listar(Pageable pagina) {
        var page = repositoryFuncao.findAll(pagina).map(DadosFuncao::new);
        return ResponseEntity.ok(page);
    }
}
