package com.example.recursos.com.example.recursos.repository;

import com.example.recursos.com.example.recursos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUsuario extends JpaRepository<Usuario,String> {
    Usuario findByLogin(String login);
}