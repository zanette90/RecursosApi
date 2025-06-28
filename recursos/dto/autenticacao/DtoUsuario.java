package com.example.recursos.com.example.recursos.dto.autenticacao;

import com.example.recursos.com.example.recursos.model.Reserva;
import com.example.recursos.com.example.recursos.model.Usuario;

public record DtoUsuario(
        String login,
        String nome
) {

    public DtoUsuario(Usuario usuario) {
        this(usuario.getLogin(), usuario.getNome());
    }
}
