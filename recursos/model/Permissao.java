package com.example.recursos.com.example.recursos.model;

public enum Permissao {
    GERENTE("ROLE_ADMIN"),
    TEPT("ROLE_ADMIN"),
    ADMINISTRADOR("ROLE_ADMIN"),
    COORDENADOR("ROLE_USER"),
    PROFESSOR("ROLE_USER"),
    INSTRUTOR("ROLE_USER"),
    ADMINISTRATIVO("ROLE_USER");

    private String permissao;

    Permissao(String permissao) {
        this.permissao = permissao;
    }

    public String getPermissao() {
        return permissao;
    }
}
