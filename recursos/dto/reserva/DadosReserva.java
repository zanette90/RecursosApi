package com.example.recursos.com.example.recursos.dto.reserva;

import com.example.recursos.com.example.recursos.model.Recursos;
import com.example.recursos.com.example.recursos.model.Reserva;
import com.example.recursos.com.example.recursos.model.Responsavel;

import java.time.LocalDateTime;

public record DadosReserva(
        long idReserva,
        Recursos recursos,
        Responsavel descricao,
        LocalDateTime dataHoraReserva,
        LocalDateTime dataHoraDevolucao
) {

    public DadosReserva(Reserva reserva) {
        this(reserva.getIdReserva(), reserva.getRecursos(),reserva.getDescricao(),reserva.getDataHoraReserva(),reserva.getDataHoraDevolucao());
    }
}
