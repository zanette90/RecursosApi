package com.example.recursos.com.example.recursos.dto.funcao;

import com.example.recursos.com.example.recursos.model.Funcao;
import com.example.recursos.com.example.recursos.model.Permissao;

public record DadosFuncao(
        String TipoFuncao,
        Permissao permissao
) {

    public DadosFuncao(Funcao funcao) {
        this(funcao.getTipoFuncao(), funcao.getPermissao());
    }
}
