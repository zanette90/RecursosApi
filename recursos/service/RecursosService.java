package com.example.recursos.com.example.recursos.service;

import com.example.recursos.com.example.recursos.dto.recursos.DadosRecursos;
import com.example.recursos.com.example.recursos.model.Recursos;
import com.example.recursos.com.example.recursos.repository.RepositoryRecursos;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class RecursosService {

    @Autowired
    private RepositoryRecursos repositoryRecursos;

    @Transactional
    public ResponseEntity cadastrar (DadosRecursos dados, UriComponentsBuilder uriComponentsBuilder) {
        var recurso = new Recursos(dados);
        repositoryRecursos.save(recurso);
        var uri = uriComponentsBuilder.path("/recurso/{id}").buildAndExpand(recurso.getId()).toUri();
        return ResponseEntity.created(uri).body(dados);
    }

    @Transactional
    public ResponseEntity excluir(long id) {
        var recurso = repositoryRecursos.findById(id);
        if (recurso.isPresent()) {
            repositoryRecursos.deleteById(id);
        }
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Page<DadosRecursos>> listar(Pageable pagina) {
        var page = repositoryRecursos.findAll(pagina).map(DadosRecursos::new);
        return ResponseEntity.ok(page);
    }
}
