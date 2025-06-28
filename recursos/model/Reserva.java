package com.example.recursos.com.example.recursos.model;

import com.example.recursos.com.example.recursos.dto.reserva.DadosReserva;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "recursoId")
    private Recursos recursos;
    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private Responsavel descricao;
    private LocalDateTime dataHoraReserva;
    private LocalDateTime dataHoraDevolucao;
    private boolean Ativo;

    public Reserva() {
    }

    public Reserva(DadosReserva dados) {
        this.recursos = dados.recursos();
        this.descricao = dados.descricao();
        this.dataHoraReserva = LocalDateTime.now();

    }

    public long getIdReserva() {
        return id;
    }

    public Recursos getRecursos() {
        return recursos;
    }

    public Responsavel getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataHoraReserva() {
        return dataHoraReserva;
    }

    public LocalDateTime getDataHoraDevolucao() {
        return dataHoraDevolucao;
    }

    public boolean isAtivo() {
        return Ativo;
    }

    public long getId() {
        return id;
    }

    public void setRecursos(Recursos recursos) {
        this.recursos = recursos;
    }

    public void setDescricao(Responsavel descricao) {
        this.descricao = descricao;
    }

    public void setDataHoraReserva(LocalDateTime dataHoraReserva) {
        this.dataHoraReserva = dataHoraReserva;
    }

    public void setAtivo(boolean ativo) {
        Ativo = ativo;
    }

    public void setDataHoraDevolucao(LocalDateTime dataHoraDevolucao) {
        this.dataHoraDevolucao = dataHoraDevolucao;
    }
}
