package com.example.recursos.com.example.recursos.model;

import com.example.recursos.com.example.recursos.dto.autenticacao.RegistrarDTO;
import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String senha;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Permissao role;

    public Usuario() {
    }

    public Usuario(RegistrarDTO dados) {
        this.login = dados.login();
        this.senha = dados.senha();
        this.nome = dados.nome();
        this.role = dados.role();
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public Permissao getRole() {
        return role;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRole(Permissao role) {
        this.role = role;
    }
}
