package com.example.recursos.com.example.recursos.repository;

import com.example.recursos.com.example.recursos.model.Recursos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RepositoryRecursos extends JpaRepository<Recursos, Long> {

}
