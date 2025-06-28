package com.example.recursos.com.example.recursos.dto.autenticacao;

import com.example.recursos.com.example.recursos.model.Permissao;

public record RegistrarDTO(
        String login,
        String nome,
        String senha,
        Permissao role
) {

}
