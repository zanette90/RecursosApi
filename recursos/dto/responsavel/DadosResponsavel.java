package com.example.recursos.com.example.recursos.dto.responsavel;

import com.example.recursos.com.example.recursos.model.Responsavel;

public record DadosResponsavel(
        long idResponsavel,
        String nome,
        String cracha,
        String telefone
) {

    public DadosResponsavel(Responsavel responsavel) {
        this(responsavel.getId(), responsavel.getNome(),responsavel.getCracha(),responsavel.getTelefone());
    }
}
