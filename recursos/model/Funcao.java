package com.example.recursos.com.example.recursos.model;

import com.example.recursos.com.example.recursos.dto.funcao.DadosFuncao;
import jakarta.persistence.*;

@Entity
public class Funcao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tipoFuncao;
    @Enumerated(EnumType.STRING)
    private Permissao permissao;
    private boolean ativo;

    public Funcao() {
    }

    public Funcao(DadosFuncao dados) {
        this.tipoFuncao = dados.TipoFuncao();
        this.permissao = dados.permissao();
        this.ativo = true;
    }

    public long getId() {
        return id;
    }

    public void atualizar(DadosFuncao dados) {
        this.tipoFuncao = dados.TipoFuncao();
        this.permissao = dados.permissao();
    }

    public String getTipoFuncao() {
        return tipoFuncao;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setTipoFuncao(String tipoFuncao) {
        this.tipoFuncao = tipoFuncao;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
