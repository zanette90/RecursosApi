package com.example.recursos.com.example.recursos.service;

import com.example.recursos.com.example.recursos.dto.reserva.DadosReserva;
import com.example.recursos.com.example.recursos.model.Reserva;
import com.example.recursos.com.example.recursos.repository.RepositoryReserva;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ReservaService {

    @Autowired
    private RepositoryReserva repositoryReserva;


    @Transactional
    public ResponseEntity cadastrar (DadosReserva dados, UriComponentsBuilder uriComponentsBuilder) {
        var reserva = new Reserva(dados);
        repositoryReserva.save(reserva);
        var uri = uriComponentsBuilder.path("/reserva/{id}").buildAndExpand(reserva.getIdReserva()).toUri();
        return ResponseEntity.created(uri).body(new DadosReserva(reserva));
    }

    @Transactional
    public ResponseEntity excluir(long idReserva) {
        var reserva = repositoryReserva.findById(idReserva);
        if (reserva.isPresent()) {
            repositoryReserva.deleteById(idReserva);
        }
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Page<DadosReserva>> listar(Pageable pagina) {
        var page = repositoryReserva.findAll(pagina).map(DadosReserva::new);
        return ResponseEntity.ok(page);
    }


}
