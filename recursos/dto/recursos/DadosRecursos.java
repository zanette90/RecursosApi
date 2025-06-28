package com.example.recursos.com.example.recursos.dto.recursos;

import com.example.recursos.com.example.recursos.model.Recursos;

public record DadosRecursos(
        long idRecursos,
        String TipoRecurso,
        String Descricao
) {

    public DadosRecursos(Recursos recursos) {
        this(recursos.getId(), recursos.getTipoRecurso(),recursos.getDescricao());
    }
}
