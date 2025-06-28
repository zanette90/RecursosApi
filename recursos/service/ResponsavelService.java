package com.example.recursos.com.example.recursos.service;

import com.example.recursos.com.example.recursos.dto.responsavel.DadosResponsavel;
import com.example.recursos.com.example.recursos.model.Responsavel;
import com.example.recursos.com.example.recursos.repository.RepositoryResponsavel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ResponsavelService {

    @Autowired
    private RepositoryResponsavel repositoryResponsavel;

    @Transactional
    public ResponseEntity cadastrar (DadosResponsavel dados, UriComponentsBuilder uriComponentsBuilder) {
        var responsavel = new Responsavel(dados);
        repositoryResponsavel.save(responsavel);
        var uri = uriComponentsBuilder.path("/responsavel/{id}").buildAndExpand(responsavel.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosResponsavel(responsavel));
    }

    @Transactional
    public ResponseEntity atualizar(DadosResponsavel dados) {
        return ResponseEntity.ok(dados);
    }

    @Transactional
    public ResponseEntity excluir(long idReserva) {
        var responsavel = repositoryResponsavel.findById(idReserva);
        if (responsavel.isPresent()) {
            repositoryResponsavel.deleteById(idReserva);
        }
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Page<DadosResponsavel>> listar(Pageable pagina) {
        var page = repositoryResponsavel.findAll(pagina).map(DadosResponsavel::new);
        return ResponseEntity.ok(page);
    }

}
