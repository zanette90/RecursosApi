package com.example.recursos.com.example.recursos.model;

import com.example.recursos.com.example.recursos.dto.recursos.DadosRecursos;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Recursos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String TipoRecurso;
    private String Descricao;
    private boolean Ativo;

    public Recursos() {
    }

    public Recursos(DadosRecursos dados) {
        this.TipoRecurso = dados.TipoRecurso();
        this.Descricao = dados.Descricao();
        this.Ativo = true;
    }

    public String getTipoRecurso() {
        return TipoRecurso;
    }

    public long getId() {
        return id;
    }

    public String getDescricao() {
        return Descricao;
    }

    public boolean isAtivo() {
        return Ativo;
    }

    public void setTipoRecurso(String tipoRecurso) {
        TipoRecurso = tipoRecurso;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public void setAtivo(boolean ativo) {
        Ativo = ativo;
    }
}
