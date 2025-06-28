package com.example.recursos.com.example.recursos.model;

import com.example.recursos.com.example.recursos.dto.responsavel.DadosResponsavel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cracha;
    private String telefone;
    private boolean ativo;

    public Responsavel() {

    }

    public Responsavel(DadosResponsavel dados) {
        this.nome = dados.nome();
        this.cracha = dados.cracha();
        this.telefone = dados.telefone();
        this.ativo = true;
    }

    public String getNome() {
        return nome;
    }

    public long getId() {
        return id;
    }

    public String getCracha() {
        return cracha;
    }

    public String getTelefone() {
        return telefone;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCracha(String cracha) {
        this.cracha = cracha;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
